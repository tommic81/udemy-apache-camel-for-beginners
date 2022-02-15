package com.learncamel.routes.gson;

import com.learncamel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnMarshalUsingGsonTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new UnMarshalUsingGson();
    }

    @Test
    public void unMarshalGSONTest(){

        String input =  "{\"id\":\"1\",\"name\":\"Dilip\",\"joinDate\":\"12Jan2017\"}";
        Employee employee = (Employee) template.requestBody("direct:unMarshalGSON", input);

        assertEquals("1", employee.getId());
    }
}