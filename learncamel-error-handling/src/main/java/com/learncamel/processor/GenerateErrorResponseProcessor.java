package com.learncamel.processor;

import org.apache.camel.Exchange;

public class GenerateErrorResponseProcessor implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        Exception e = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
        System.out.println("Acutal Exceptipn Message "  + e.getMessage());
        System.out.println("Acutal Exceptipn Class "  + e.getClass());

        String failedEndoint = (String) exchange.getProperty(Exchange.FAILURE_ENDPOINT);
        System.out.println("Failed Endpoint : " + failedEndoint);


        exchange.getIn().setBody("Exception happened in the route.");
    }
}
