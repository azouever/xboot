package com.process.boot.config.mybatis;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

@Service
public class MybatisRefreshMapper {

    private static Logger log = LoggerFactory.getLogger(MybatisRefreshMapper.class);

    @Value("${mybatisRefreshMapper.enable:true}")
    private Boolean enable;

    @Value("${mybatis.mapper-locations}")
    private String packageSearchPath;

    @Autowired
    private SqlSessionFactory sessionFactory;

    /**
     * Mapper资源路径
     */
    private Resource[] mapperLocations;

    /**
     * MyBatis配置对象
     */
    private Configuration configuration;

    @PostConstruct
    public void initMapperRefresh() {
        try {
            this.configuration = sessionFactory.getConfiguration();
            this.mapperLocations =
                    new PathMatchingResourcePatternResolver().getResources(packageSearchPath);
        } catch (Exception e) {
            log.error("初始化mapper配置异常：{}", e);
        }
    }

    public void refreshMapper() {
        this.refreshMapper(null);
    }

    /**
     * 刷新Mapper文件（如果传入参数为null,清理刷新所有Mapeer,否则刷新指定Mapper）
     *
     * @param changFilePath 变更文件路径
     */
    public void refreshMapper(String changFilePath) {
        if (!enable) {
            return;
        }
        // step.1 清理相关缓存
        try {
            removeConfig(changFilePath);
        } catch (Exception e1) {
            log.error("清理缓存失败");
        }
        // step.2 重新加载相关Mappper(若changFilePath为空,刷新所有文件)
        if (StringUtils.isEmpty(changFilePath)) {
            // 重新加载所有mapper文件
            for (Resource configLocation : mapperLocations) {
                try {
                    this.reloadMapper(configLocation.getFile().getAbsolutePath());
                } catch (IOException e) {
                    log.error("重新加载mapper文件异常：{}", e);
                }
            }
        } else {
            // 加载指定Mapper
            this.reloadMapper(changFilePath);
        }

    }


    /**
     * 重新加载变更文件
     */
    private void reloadMapper(String changFilePath) {
        try {
            if (StringUtils.isNotEmpty(changFilePath)) {
                InputStream inputStream = new FileInputStream(changFilePath);
                // 重新编译加载资源文件
                XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(inputStream, configuration,
                        changFilePath, configuration.getSqlFragments());
                xmlMapperBuilder.parse();
            }
        } catch (IOException e) {
            log.error("mapper文件{}不存在或内容格式不对", changFilePath);
        }
        log.info("文件缓存加载成功:{}.", changFilePath);
    }

    /**
     * 清空Configuration中所有的缓存
     */
    private void removeConfig(String changFilePath) throws Exception {
        Class<?> classConfig = configuration.getClass();
        clearMap(classConfig, "mappedStatements");
        clearMap(classConfig, "caches");
        clearMap(classConfig, "resultMaps");
        clearMap(classConfig, "parameterMaps");
        clearMap(classConfig, "keyGenerators");
        clearMap(classConfig, "sqlFragments");
        clearMap(classConfig, "cacheRefMap");
        clearSet(classConfig, "loadedResources", changFilePath);
        clearList(classConfig, "incompleteStatements", changFilePath);
        clearList(classConfig, "incompleteCacheRefs", changFilePath);
        clearList(classConfig, "incompleteResultMaps", changFilePath);
        clearList(classConfig, "incompleteMethods", changFilePath);

    }

    @SuppressWarnings("rawtypes")
    private void clearList(Class<?> classConfig, String fileName, String changFilePath)
            throws Exception {
        Field field = classConfig.getDeclaredField(fileName);
        field.setAccessible(true);
        LinkedList listConfig = (LinkedList) field.get(configuration);
        listConfig.clear();
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void clearMap(Class<?> classConfig, String fieldName) throws Exception {
        // 清理原有资源，更新为自己的StrictMap,方便增量重新加载
        Field field = classConfig.getDeclaredField(fieldName);
        field.setAccessible(true);
        Map mapConfig = (Map) field.get(configuration);
        if (!(mapConfig instanceof StrictMap)) {
            Map newMap = new StrictMap(StringUtils.capitalize(fieldName) + "collection");
            for (Object key : mapConfig.keySet()) {
                try {
                    newMap.put(key, mapConfig.get(key));
                } catch (IllegalArgumentException ex) {
                    newMap.put(key, ex.getMessage());
                }
            }
            field.set(configuration, newMap);
        }
    }

    @SuppressWarnings("rawtypes")
    private void clearSet(Class<?> classConfig, String fieldName, String changFilePath)
            throws Exception {
        Field field = classConfig.getDeclaredField(fieldName);
        field.setAccessible(true);
        Set setConfig = (Set) field.get(configuration);
        if (StringUtils.isEmpty(changFilePath)) {
            setConfig.clear();
        } else {
            setConfig.remove(changFilePath);
        }
    }


    /**
     * 重写 org.apache.ibatis.session.Configuration.StrictMap 类 来自 MyBatis3.4.0版本，修改 put 方法，允许反复 put更新。
     */
    public static class StrictMap<V> extends HashMap<String, V> {

        private static final long serialVersionUID = -4950446264854982944L;
        private String name;

        public StrictMap(String name, int initialCapacity, float loadFactor) {
            super(initialCapacity, loadFactor);
            this.name = name;
        }

        public StrictMap(String name, int initialCapacity) {
            super(initialCapacity);
            this.name = name;
        }

        public StrictMap(String name) {
            super();
            this.name = name;
        }

        public StrictMap(String name, Map<String, ? extends V> m) {
            super(m);
            this.name = name;
        }

        @Override
        @SuppressWarnings("unchecked")
        public V put(String key, V value) {
            // ThinkGem 刷新(先删除后添加)
            remove(key);
            // ThinkGem end
            if (containsKey(key)) {
                throw new IllegalArgumentException(name + " already contains value for " + key);
            }
            String point = ".";
            if (key.contains(point)) {
                final String shortKey = getShortName(key);
                if (super.get(shortKey) == null) {
                    super.put(shortKey, value);
                } else {
                    super.put(shortKey, (V) new Ambiguity(shortKey));
                }
            }
            return super.put(key, value);
        }

        @Override
        public V get(Object key) {
            V value = super.get(key);
            if (value == null) {
                throw new IllegalArgumentException(name + " does not contain value for " + key);
            }
            if (value instanceof Ambiguity) {
                throw new IllegalArgumentException(((Ambiguity) value).getSubject() + " is ambiguous in "
                        + name
                        + " (try using the full name including the namespace, or rename one of the entries)");
            }
            return value;
        }

        private String getShortName(String key) {
            final String[] keyparts = key.split("\\.");
            return keyparts[keyparts.length - 1];
        }


        protected static class Ambiguity {

            private String subject;

            public Ambiguity(String subject) {
                this.subject = subject;
            }

            public String getSubject() {
                return subject;
            }
        }
    }

}
