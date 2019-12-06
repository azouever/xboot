package com.process.boot.config.mybatis;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author xukaixuan
 */
@Configuration
public class MybatisConfig {

    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;

    @Value("${mybatis.type-aliases-package}")
    private String typeAliasesPackage;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        // 处理resource
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // 设置扫描mapper xml文件
        bean.setMapperLocations(resolver.getResources(mapperLocations));
        bean.setTypeAliasesPackage(typeAliasesPackage);
        bean.setDataSource(dataSource);
        PageInterceptor pageHelper = new PageInterceptor();
        Properties properties = new Properties();
        properties.put("helperDialect", "mysql");
        pageHelper.setProperties(properties);
        //bean.setPlugins(new Interceptor[]{pageHelper, new PageIntercept()});
        bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return bean.getObject();
    }

}
