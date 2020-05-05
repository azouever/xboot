package com.process.xboot.basic.abstract_interface;

public abstract class AbstractParent {

    static {
        a = 10;
        System.out.println("我是抽象类的静态代码块");
//        System.out.println(a);
    }
    public static Integer a;

    {
        System.out.println("我是抽象类的代码块");
    }

    public AbstractParent() {
        System.out.println("我是抽象类的构造器");
    }

}

