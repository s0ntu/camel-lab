package com.sontu.camel.ex2.filecopy;

import org.apache.camel.main.Main;

public class ExampleRunner {
  public static void main(String[] args) throws Exception {
    String sourceDir = args[0];
    String targetDir = args[1];
    if (sourceDir != null && targetDir != null) {
      Main main = new Main();
      main.addRouteBuilder(new FileCopyRouteBuilder(sourceDir, targetDir));
      main.run();
    }
  }
}
