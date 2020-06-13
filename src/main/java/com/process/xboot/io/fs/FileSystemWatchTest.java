package com.process.xboot.io.fs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.*;
import java.util.Map;
import java.util.Properties;

/**
 * @author xkx
 * @description do something
 */
public class FileSystemWatchTest {

    private static final Logger log = LoggerFactory.getLogger(FileSystemWatchTest.class);

    public static void main(String[] args) throws IOException, InterruptedException {
        FileSystem fileSystem = FileSystems.getDefault();
        WatchService watchService = fileSystem.newWatchService();
        Properties properties = System.getProperties();
        Map<String, String> env = System.getenv();
        Path path = Paths.get("/Users/xukaixuan/IdeaProjects/xboot/src/main/java/com/process/boot/io/fs");
        path.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println(
                        "Event kind:" + event.kind()
                                + ". File affected: " + event.context() + ".");
            }
            key.reset();
        }

    }
}
