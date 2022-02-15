package com.learncamel.routes.defaulterrorhandler;

import com.learncamel.bean.DataModifier;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class DefaultErrorHandlerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        //Error Logging
        /**used by default*/
        // errorHandler(defaultErrorHandler());
      /**handling with retry*/
        //errorHandler(defaultErrorHandler().maximumRedeliveries(2).redeliveryDelay(3000).retryAttemptedLogLevel(LoggingLevel.WARN));


        /**Error Logging exponetial back off*/
        errorHandler(defaultErrorHandler().maximumRedeliveries(2).redeliveryDelay(3000).backOffMultiplier(2).retryAttemptedLogLevel(LoggingLevel.WARN));


        from("direct:exception")
                .bean(new DataModifier(), "map")
                .to("log:?level=INFO&showBody=true")
                .to("mock:errorqueue");
    }
}
