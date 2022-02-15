package com.learncamel.routes.gson;

import com.learncamel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarshalUsingGsonTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MarshalUsingGson();
    }

    @Test
    public void mashalUsingGson(){
        Employee employee = new Employee();
        employee.setId("1");
        employee.setName("Dilip");
        employee.setJoinDate("12Jan2017");

        String expectedJson = "{\"id\":\"1\",\"name\":\"Dilip\",\"joinDate\":\"12Jan2017\"}";
        String employeeJson =  template.requestBody("direct:marshalGSON", employee, String.class);

        System.out.println("employee Json " + employeeJson);

         assertEquals(expectedJson,employeeJson);

    }
}