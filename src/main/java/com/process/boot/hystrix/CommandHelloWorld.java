//package com.process.boot.hystrix;
//
//import com.netflix.hystrix.HystrixCommand;
//import com.netflix.hystrix.HystrixCommandGroupKey;
//
//public class CommandHelloWorld extends HystrixCommand<String> {
//
//    private String name;
//
//    public CommandHelloWorld(HystrixCommandGroupKey group, String name) {
//        super(group);
//        this.name = name;
//    }
//
//    public CommandHelloWorld(Setter setter, String name) {
//        super(setter);
//        this.name = name;
//    }
//
//    @Override
//    protected String run() throws Exception {
//        if ("Alice".equals(name)) {
//            throw new RuntimeException("出错了");
//        }
//        return "Hello, " + name;
//    }
//
//    @Override
//    protected String getFallback() {
//        return "Failure, " + name;
//    }
//
//}