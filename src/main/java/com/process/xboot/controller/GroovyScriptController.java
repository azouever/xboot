package com.process.xboot.controller;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kai
 */
@RestController
@RequestMapping("/test/groovy")
public class GroovyScriptController {

  private static final Logger log = LoggerFactory.getLogger(GroovyScriptController.class);


  @Autowired
  private Binding groovyBinding;

  private GroovyShell groovyShell;

  @PostConstruct
  public void init() {

    groovyShell = new GroovyShell(groovyBinding);
  }


  @PostMapping("execute")
  public ResponseEntity executeScript(@RequestBody String scriptParam) {
    Script script = groovyShell.parse(scriptParam);
    return ResponseEntity.ok(script.run());
  }
}
