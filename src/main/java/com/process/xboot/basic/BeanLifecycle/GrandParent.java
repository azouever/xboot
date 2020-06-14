package com.process.xboot.basic.BeanLifecycle;

public class GrandParent {

    public GrandParent(){
        super();
        System.out.println("GrandParent 构造函数");
    }

    {
        System.out.println("GrandParent 成员代码块");
    }

    static {
        System.out.println("GrandParent 静态代码块");
    }
}