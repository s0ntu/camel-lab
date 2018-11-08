package com.sontu.camel.ex1.simplelifecycle;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import java.util.concurrent.TimeUnit;

public class FileCopy {
  public static void main(String[] args) throws Exception {

    // Step 1: Create camel context
    CamelContext camelContext = new DefaultCamelContext();

    // Step 2: Add Routes to the camel context
    camelContext.addRoutes(new RouteBuilder() {
      public void configure() {
        from("file:tmp/sourceDir?noop=true")
            .to("file:tmp/targetDir");
      }
    });

    // Step 3: Non-blocking starts internal threads
    camelContext.start();

    TimeUnit.SECONDS.sleep(10); // Letting threads invoked by start() to complete

    // Step 4: Waits/terminates the threads initiated by start() and returns
    camelContext.stop();
  }
}
