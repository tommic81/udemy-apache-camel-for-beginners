package com.learncamel.eip.contentbasesrouter;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class ContentBasedRouterRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new ContentBasedRouterRoute();
    }

    @Test
    public void contentBasedRouterTest() throws InterruptedException {

        Thread.sleep(5000);
        File file = new File("html");

        assertTrue(file.isDirectory());

        File file2 = new File("text");
        assertTrue(file2.isDirectory());
        File file3 = new File("json");
        assertTrue(file3.isDirectory());

        File fileAll = new File("all");
        assertTrue(fileAll.isDirectory());
    }
}