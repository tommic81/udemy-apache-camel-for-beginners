package com.learncamel.routes.csv;

import com.learncamel.domain.Employee;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CSVUnMarshalRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CSVUnMarshalRoute();
    }

    @Test
    public void csvUnMarshalRoute() throws InterruptedException {
        Exchange exchange = consumer.receive("direct:output");

        Thread.sleep(5000);
        List<Employee> employees = (List<Employee>) exchange.getIn().getBody();

        assertEquals("dilip",employees.get(0).getFirstName());
        assertEquals("kevin",employees.get(1).getFirstName());

    }
}