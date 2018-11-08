package com.sontu.camel.ex2.filecopy;

import org.apache.camel.builder.RouteBuilder;

public class FileCopyRouteBuilder extends RouteBuilder {

  private String sourceDir;
  private String targetDir;

  public FileCopyRouteBuilder(String sourceDir, String targetDir) {
    this.sourceDir = sourceDir;
    this.targetDir = targetDir;
  }

  public void configure() throws Exception {
    from("file:" + sourceDir + "?noop=true")
        .to("file:"+ targetDir);
  }
}
