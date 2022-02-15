package com.learncamel.file;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFilesCamelMultiRoute {
    public static void main(String[] args ){
        CamelContext context = new DefaultCamelContext();
        try {

            //copy files from data/input to  data/output
            context.addRoutes(new RouteBuilder(){

                public void configure() throws Exception {
                    from("file:data/input?noop=true")
                            .to("log:?level=INFO&showBody=true&showHeaders=true")
                            .to("file:data/output")
                            .to("file:data/anotherOutput");

                    from("file:data/input1?noop=true")
                            .to("file:data/output1");
                }
            });

            context.start();

            Thread.sleep(5000);
            context.stop();
        } catch (Exception e) {
            System.out.println("Exception is : " +e);
        }
    }
}
