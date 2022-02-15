package com.learncamel.routes.process;

import com.learncamel.processor.CamelDirectExampleProcessor;
import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyDirectProcessorRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:processorInput")
                .log("Received Message before process is ${body} and headers are ${headers}")
                .process(new CamelDirectExampleProcessor())
                .log("Received Message is ${body} and headers are ${headers}")
                //.to("file:data/output?fileName=output.txt")
        .to("mock:output");
    }
}
