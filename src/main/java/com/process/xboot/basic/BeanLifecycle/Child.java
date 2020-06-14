package com.process.xboot.basic.BeanLifecycle;

public class Child extends Parent {

    public static  Integer a;

   static  {
        a=1;
       Child child = new Child();
   }


    public Child() {
        super();
        System.out.println("Child 构造函数");
        System.out.println(a);
    }

    {
        System.out.println("Child 成员代码块");
    }

    static {
        System.out.println("Child 静态代码块");
        a=100;
    }


}