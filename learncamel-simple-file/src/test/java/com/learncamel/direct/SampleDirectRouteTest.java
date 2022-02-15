package com.learncamel.direct;


import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import static org.junit.Assert.*;


public class SampleDirectRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SampleDirectRoute();
    }

    @Test
    public void sampleRouteTest() throws InterruptedException {
        template.sendBody("direct:sampleInput","1234, Tomek, Udemy course");

        Thread.sleep(5000);

        File file = new File("sampleOutput");
        assertTrue(file.isDirectory());

        Exchange exchange = consumer.receive("file:sampleOutput");
        assertEquals("output.txt", exchange.getIn().getHeader("CamelFileName"));
    }
}
