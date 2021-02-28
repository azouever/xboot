package com.process.xboot.config.web.filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ReqBodyFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    XbootRequestWrapper requestWrapper = null;

    if (request instanceof HttpServletRequest) {
      requestWrapper = new XbootRequestWrapper((HttpServletRequest) request);
      JsonNode requestParamJson = getRequestParamJson(requestWrapper);
      System.out.println(requestParamJson);
//      requestWrapper.setBody(getRequestParamJson(requestWrapper).toString());
    }
    if (requestWrapper == null) {
      chain.doFilter(request, response);
    } else {
      chain.doFilter(requestWrapper, response);
    }
  }

  @Override
  public void destroy() {
  }

  // 获取request中的body数据
  private JsonNode getRequestParamJson(XbootRequestWrapper request) throws IOException {
    String body = request.getBody();
    ObjectMapper mapper = new ObjectMapper();
    JsonNode jsonNode = mapper.readTree(body);
//    JsonNode serviceName = jsonNode.get("serviceName");
//    ObjectNode objectNode = mapper.createObjectNode();
//    objectNode.put("serviceName", jsonNode.get("serviceName").asText());
//    objectNode.put("propertyFromFilter", "propertyFromFilter");
    return jsonNode;
  }
}