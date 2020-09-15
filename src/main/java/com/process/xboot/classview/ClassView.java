package com.process.xboot.classview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xkx
 * @description do something
 */
public class ClassView {

    private final Logger log = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        Integer a = 100, b =100, c = 150, d = 150;
        System.out.println(a == b);
        System.out.println(c == d);
      ClassView.class.getDeclaredFields()[0].getModifiers();
    }
}
