package com.learncamel.eip.wiretap;

import org.apache.camel.builder.RouteBuilder;

public class WireTapRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:input?noop=true")
                .wireTap("file:debug")
                .to("file:all");
    }
}
