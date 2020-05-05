package com.process.xboot.basic.nested_class;

public class AnonymousClassTest {

    public static void main(String[] args) {

        ProductInformationList p = new AbstractProductInformationList(){
            @Override
            public String getName() {
                return "anonymous abstract class";
            }
        };
        System.out.println(p.getName());
        System.out.println(p.getNumber());
        ProductInformationList p1 = new ProductInformationList() {
            @Override
            public int getNumber() {
                return 20;
            }

            @Override
            public String getName() {
                return "anonymous interface";
            }
        };
        System.out.println(p.getName());
        System.out.println(p.getNumber());
    }
}
