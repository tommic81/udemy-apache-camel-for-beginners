package com.learncamel.routes.bean;

import com.learncamel.bean.CamelBean;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyBeanRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:beanInput")
                .log("Bean bean message is : ${body}")
              //  .bean(new CamelBean())
                .bean(new CamelBean(), "map1")
                .log("After bean message is : ${body}")
                .to("mock:output");
    }
}
