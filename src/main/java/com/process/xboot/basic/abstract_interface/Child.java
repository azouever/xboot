package com.process.xboot.basic.abstract_interface;

import lombok.var;

public  class Child extends AbstractParent {

    public static int b;

    static {
        System.out.println("类加载过程中准备阶段的时候a的值是:"+b);
        b=10;
        System.out.println("类加载过程中初始化阶段的时候a的值是:"+b);

        System.out.println("我是子类的静态代码块");
    }

    {
        System.out.println("我是子类的代码块");
    }

    public Child() {
        System.out.println("我是子类的构造器");
    }

    public static void main(String[] args) {
        Child child = new Child();
//        parent static code block
//        child static code block
//        parent code block
//        parent constructor
//        child code block
//        child constructor

    }
}

