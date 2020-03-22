package com.process.xboot.dp.singleton;

import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author xkx
 * @description 双重检查锁实现单例模式, 懒汉式, 线程安全, 外面的对于null的判断是为了提高性能, volatile这个关键字很重要,因为它可以防止指令重排序,必须保证new
 * Singleton()这个过程按照顺序执行,这不是一个原子操作 分为三步:1给对象内存(应该是根据数据类型呀什么的判断所需要的内存大小) 2调用构造函数来对成员变量进行赋值
 * 3将singleton对象指向分配的内存空间 由于第二步和第三步不一定是按照顺序执行的,所有就可能返回一个虽然singleton不是指向null,但是其还没有完成赋值操作的对象,去进行使用,这个时候很显然是有问题的
 */
public class Singleton implements Serializable {

  private static final Logger log = LoggerFactory.getLogger(Singleton.class);

  private static volatile Singleton instance;

  private Singleton() {
  }

  public static Singleton getInstance() {
    if (null == instance) {
      synchronized (Singleton.class) {
        if (null == instance) {
          instance = new Singleton();
        }
      }
    }
    return instance;
  }

  private Object readResolve() {
    return instance;
  }
}
