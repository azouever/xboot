package com.process.xboot.basic.BeanLifecycle;

public class Parent extends GrandParent {


    public Parent() {
        super();
        System.out.println("Parent 构造函数");
    }

    {
        System.out.println("Parent 成员代码块");
    }

    static {
        System.out.println("Parent 静态代码块");
    }


}