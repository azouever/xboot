

package com.process.xboot.webserver;

import java.net.InetAddress;
import java.util.Set;
import org.springframework.boot.web.server.Compression;
import org.springframework.boot.web.server.Http2;
import org.springframework.boot.web.server.Ssl;
import org.springframework.boot.web.server.SslStoreProvider;

/**
 * A configurable {@link WebServerFactory}.
 *
 * @author Phillip Webb
 * @author Brian Clozel
 * @see ErrorPageRegistry
 * @since 2.0.0
 */
public interface ConfigurableWebServerFactory
    extends WebServerFactory, ErrorPageRegistry {

  /**
   * Sets the port that the web server should listen on. If not specified port '8080' will be used.
   * Use port -1 to disable auto-start (i.e start the web application context but not have it listen
   * to any port).
   *
   * @param port the port to set
   */
  void setPort(int port);

  /**
   * Sets the specific network address that the server should bind to.
   *
   * @param address the address to set (defaults to {@code null})
   */
  void setAddress(InetAddress address);

  /**
   * Sets the error pages that will be used when handling exceptions.
   *
   * @param errorPages the error pages
   */
  void setErrorPages(Set<? extends ErrorPage> errorPages);

  /**
   * Sets the SSL configuration that will be applied to the server's default connector.
   *
   * @param ssl the SSL configuration
   */
  void setSsl(Ssl ssl);

  /**
   * Sets a provider that will be used to obtain SSL stores.
   *
   * @param sslStoreProvider the SSL store provider
   */
  void setSslStoreProvider(SslStoreProvider sslStoreProvider);

  /**
   * Sets the HTTP/2 configuration that will be applied to the server.
   *
   * @param http2 the HTTP/2 configuration
   */
  void setHttp2(Http2 http2);

  /**
   * Sets the compression configuration that will be applied to the server's default connector.
   *
   * @param compression the compression configuration
   */
  void setCompression(Compression compression);

  /**
   * Sets the server header value.
   *
   * @param serverHeader the server header value
   */
  void setServerHeader(String serverHeader);

}
