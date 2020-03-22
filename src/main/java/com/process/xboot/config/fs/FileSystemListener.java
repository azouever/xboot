package com.process.xboot.config.fs;

import com.process.xboot.config.mybatis.MybatisRefreshMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author xkx
 * @description 文件监控
 */
@Component
public class FileSystemListener implements ApplicationListener<ContextRefreshedEvent> {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Value("${mybatis.refresh-mapper-enable:false}")
    private Boolean enable;

    @Autowired
    private MybatisRefreshMapper refreshMapper;

    /**
     * 监控目录
     */
    private static String srcUrl = "src.main.resources.mapper".replace(".", File.separator);


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextEvent) {
        if (!enable) {
            return;
        }
        if (contextEvent.getApplicationContext().getParent() != null) {
            return;
        }
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.execute(new FileWatch());
    }

    class FileWatch implements Runnable {

        //@SuppressWarnings("rawtypes")
        private WatchEvent.Kind[] eventKinds = {StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY};

        private WatchService watchService;

        @Override
        public void run() {
            try {
                doWatch();
            } catch (Exception e) {
                log.error("文件监控异常：{}", e);
            }
            log.info("文件监控关闭！");
        }

        private void doWatch() throws Exception {
            // WatchService 文件系统监控器；FileSystems 文件系统，和OS有关
            watchService = FileSystems.getDefault().newWatchService();
            this.registerDirectory(Paths.get("", srcUrl).toFile());

            log.info("===================");
            log.info("文件监控启动成功！");
            log.info("===================");

            while (true) {
                WatchKey key = watchService.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    File changeFile = this.getChangeFile(key, event);
                    // 新建文件夹 添加监听
                    if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())
                            && changeFile.isDirectory()) {
                        log.info("开始监听:{}", changeFile.getAbsolutePath());
                        this.registerDirectory(changeFile);
                        break;
                    }
                    String mapperXmlRegex = "[a-zA-Z]+Mapper\\.xml";
                    if (changeFile.getName().matches(mapperXmlRegex)) {
                        this.refreshMapper(changeFile.getAbsolutePath());
                    }
                }
                key.reset();
            }
        }

        /**
         * 遍历目录下所有文件夹并添加监听
         */
        private void registerDirectory(File rootFile) throws IOException {
            // 创建文件监控队列
            LinkedList<File> fileQueue = new LinkedList<>();
            fileQueue.addLast(rootFile);
            // 依次注册文件夹监控
            while (fileQueue.size() > 0) {
                File tmpFile = fileQueue.removeFirst();
                if (tmpFile.listFiles() != null) {
                    for (File file : tmpFile.listFiles()) {
                        // WatchService 只能监控文件夹
                        if (file.isDirectory()) {
                            fileQueue.addLast(file);
                        }
                    }
                }
                Paths.get(tmpFile.getAbsolutePath()).register(watchService, eventKinds);
            }
        }

        /**
         * 获取有变动的文件
         */
        private File getChangeFile(WatchKey key, WatchEvent<?> event) {
            String filePath = ((Path) key.watchable()).toString();
            String fileName = ((Path) event.context()).toString();
            return new File(filePath + File.separator + fileName);
        }

        /**
         * 刷新Mapper
         */
        private void refreshMapper(String filePath) {
            try {
                refreshMapper.refreshMapper(filePath);
            } catch (Throwable e) {
                log.error("刷新Mapper出错:{}", e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Paths.get("", srcUrl));
    }
}
