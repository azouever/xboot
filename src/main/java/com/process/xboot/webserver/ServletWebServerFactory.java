

package com.process.xboot.webserver;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;

/**
 * Factory interface that can be used to create a {@link WebServer}.
 *
 * @author Phillip Webb
 * @see WebServer
 * @since 2.0.0
 */
@FunctionalInterface
public interface ServletWebServerFactory {

  /**
   * Gets a new fully configured but paused {@link WebServer} instance. Clients should not be able
   * to connect to the returned server until {@link WebServer#start()} is called (which happens when
   * the {@link ApplicationContext} has been fully refreshed).
   *
   * @param initializers {@link ServletContextInitializer}s that should be applied as the server
   *                     starts
   * @return a fully configured and started {@link WebServer}
   * @see WebServer#stop()
   */
  WebServer getWebServer(ServletContextInitializer... initializers);

}
