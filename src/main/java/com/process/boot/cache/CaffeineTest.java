package com.process.boot.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author xkx
 * @description do something
 */
public class CaffeineTest {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private Cache<String, Object> cache;

    @Before
    public void buildCli() {
        cache = Caffeine.newBuilder()
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .maximumSize(20)
                .build();
    }


    @Test
    public void population() {
        cache.put("hello", "caffeine");
    }

    @After
    public void getTest() {
        System.out.println(cache.getIfPresent("hello"));
    }
}
