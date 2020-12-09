package com.process.xboot.groovy;

import static org.junit.Assert.assertEquals;

import groovy.lang.GroovyShell;
import groovy.lang.Script;
import groovy.util.Eval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kai
 */
public class ExecuteByJava {

  private static final Logger log = LoggerFactory.getLogger(ExecuteByJava.class);

  public static void main(String[] args) {

    Eval.me("println 'hello world'");

    GroovyShell shell = new GroovyShell();
//可以绑定更多变量
    shell.setVariable("age", 22);
//直接求值
    System.out.println(shell.evaluate("if(age < 18){'未成年'}else{'成年'}"));
//解析为脚本，延迟执行或者缓存起来
    Script script = shell.parse("if(age < 18){'未成年'}else{'成年'}");
    assertEquals(script.run(), "成年");

  }

}
