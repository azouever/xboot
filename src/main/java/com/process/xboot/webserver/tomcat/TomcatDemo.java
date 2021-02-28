package com.process.xboot.webserver.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kai
 */
public class TomcatDemo {

  private static final Logger log = LoggerFactory.getLogger(TomcatDemo.class);

  public static void main(String[] args) throws LifecycleException {
    Tomcat tomcat = new Tomcat();
    tomcat.setPort(10090);
    tomcat.start();
    System.out.println(tomcat.getClass().getClassLoader());
    System.out.println(tomcat.getConnector().getPort());
  }
}
