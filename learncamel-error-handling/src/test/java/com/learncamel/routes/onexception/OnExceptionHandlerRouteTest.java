package com.learncamel.routes.onexception;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class OnExceptionHandlerRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new OnExceptionHandlerRoute();
    }

    @Test
    public void onExceptionCheck(){
        String request=null;
        final String response = template.requestBody("direct:exception", request, String.class);
        System.out.println("Response is : " + response);
    }

    @Test
    public void onExceptionCheck_handled(){
        String request=null;
        String expected = "Exception happened in the route.";
        final String response = template.requestBody("direct:exception", request, String.class);
        System.out.println("Response is : " + response);

        assertEquals(expected, response);
    }

    @Test
    public void onExceptionCheck_ignored(){
        String request=null;
        String expected = null;
        final String response = template.requestBody("direct:exception", request, String.class);
        System.out.println("Response is : " + response);

        assertEquals(expected, response);
    }
}