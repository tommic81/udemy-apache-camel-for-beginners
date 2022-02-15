package com.learncamel.routes.xml2json;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class XML2JSONRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new XML2JSONRoute();
    }

    @Test
    public void marshalEmployee2JSONXML() {
        String expected = "{\"id\":\"123\",\"name\":\"dilip\",\"joinDate\":\"12JAN2017\"}";

        String input = "<?xml version='1.0' encoding='UTF-8'?><employee><id>123</id><name>dilip</name><joinDate>12JAN2017</joinDate></employee>";

        String response = template.requestBody("direct:marshalEmployeexml2json", input, String.class);

        System.out.println("Response: " + response);

        assertEquals(expected, response);

    }

    //direct:unMarshalEmployeejson2xml

    @Test
    public void unMarshalEmployeejson2XML(){
        String input = "{\"id\":\"123\",\"name\":\"dilip\",\"joinDate\":\"12JAN2017\"}";

        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
                "<employee><id>123</id><joinDate>12JAN2017</joinDate><name>dilip</name></employee>\r\n";

        String response = template.requestBody("direct:unMarshalEmployeejson2xml", input, String.class);

        assertEquals(expected, response);
    }
}