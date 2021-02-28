package com.process.xboot.webserver.tomcat;

import java.io.IOException;
import javax.servlet.ServletException;
import org.apache.catalina.Valve;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.core.StandardPipeline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kai
 */
public class PipelineDemo {

  private static final Logger log = LoggerFactory.getLogger(PipelineDemo.class);

  public static void main(String[] args) {
    StandardPipeline standardPipeline = new StandardPipeline();
    standardPipeline.setBasic(new Valve() {
      @Override
      public Valve getNext() {
        return null;
      }

      @Override
      public void setNext(Valve valve) {

      }

      @Override
      public void backgroundProcess() {

      }

      @Override
      public void invoke(Request request, Response response) throws IOException, ServletException {

      }

      @Override
      public boolean isAsyncSupported() {
        return false;
      }
    });
  }
}
