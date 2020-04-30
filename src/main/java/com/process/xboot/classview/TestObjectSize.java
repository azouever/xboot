package com.process.xboot.classview;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

public class TestObjectSize {
    private Object o = new Object();
    public static void main(String[] args) {
        //查看对象内部信息
        TestObjectSize testObjectSize = new TestObjectSize();
        System.out.println(ClassLayout.parseInstance(testObjectSize).toPrintable());
        System.out.println("=================");
        synchronized (testObjectSize){
            System.out.println(ClassLayout.parseInstance(testObjectSize).toPrintable());
        }
        System.out.println("=================");

        System.out.println(GraphLayout.parseInstance(testObjectSize).toPrintable());
        System.out.println("=================");
        System.out.println(GraphLayout.parseInstance(testObjectSize).totalSize());

        System.out.println(ClassLayout.parseInstance(new Object[0]).toPrintable());
    }
}