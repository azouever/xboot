package com.process.xboot.basic;


import com.google.common.collect.Lists;
import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class SystemTest {

    @Test
    public void envTest() {
        Map<String, String> env = System.getenv();
        Flux.fromIterable(env.entrySet()).subscribe(entry->{
            System.out.println("env key:"+entry.getKey()+"------"+"env value:"+entry.getValue());
        });
    }

    @Test
    public void propertiesTest() {
        Properties properties = System.getProperties();
//        Flux.fromIterable(properties.stringPropertyNames()).subscribe(name->{
//            System.out.println("properties name:[["+name+"]]------"+"properties value:[["+properties.getProperty(name)+"]]");
//        });
        properties.list(System.out);
    }

    @Test
    public void gcTest() {
//        List<Person> arrayList = Lists.newArrayListWithExpectedSize(4);
        for (int i = 0; i < 4; i++) {
            Person person = new Person("xkx00" + i);
//            arrayList.add(person);
        }
//        System.runFinalization();
        System.gc();
    }

}


class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void finalize() throws Throwable {
        super.finalize();
        System.out.println(this.name + "被回收了……");
    }
}
