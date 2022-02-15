package com.learncamel.routes.xmlxstream;

import com.learncamel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnMarshalUsingXStreamTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new UnMarshalUsingXStream();
    }

    @Test
    public void unMashalXstreamTest() throws InterruptedException {
        Employee employee = new Employee();
        employee.setJoinDate("12JAN2017");
        employee.setName("Daniel");
        employee.setId("124");

        String xmlInput = "<?xml version='1.0' encoding='UTF-8'?><employee><id>124</id><name>Daniel</name><joinDate>12JAN2017</joinDate></employee>";

        MockEndpoint endpoint = getMockEndpoint("mock:output");

        endpoint.expectedBodiesReceived(employee.toString());

        template.sendBody("direct:xmlInput",xmlInput);

        assertMockEndpointsSatisfied();
    }
}