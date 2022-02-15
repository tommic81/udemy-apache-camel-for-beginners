package com.learncamel.routes;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AggregatorSimpleRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new AggregatorSimpleRoute();
    }

    @Test
    public void aggregateSimpleTest() throws InterruptedException {

        MockEndpoint mock = getMockEndpoint("mock:output");

        mock.expectedBodiesReceived("123");

        template.sendBodyAndHeader("direct:simpleAggregator", "1", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "2", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "4", "aggregatorId", 2);
        template.sendBodyAndHeader("direct:simpleAggregator", "3", "aggregatorId", 1);
        assertMockEndpointsSatisfied();


    }


    @Test
    public void aggregateMultipleMessage() throws InterruptedException {

        MockEndpoint mock = getMockEndpoint("mock:output");

        List<String> expectedBodies = new ArrayList<String>();
        expectedBodies.add("123");
        expectedBodies.add("567");
        mock.expectedBodiesReceived(expectedBodies);

        template.sendBodyAndHeader("direct:simpleAggregator", "1", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "2", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "4", "aggregatorId", 2);
        template.sendBodyAndHeader("direct:simpleAggregator", "3", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "5", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "6", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "7", "aggregatorId", 1);
        assertMockEndpointsSatisfied();

    }






    @Test
    public void aggregateSimpleTest_MultipleMessage_DifferentAggregateid() throws InterruptedException {

        MockEndpoint mock = getMockEndpoint("mock:output");
        List<String> expectedBodies = new ArrayList<String>();
        expectedBodies.add("123");
        expectedBodies.add("444");
        mock.expectedBodiesReceived(expectedBodies);

        template.sendBodyAndHeader("direct:simpleAggregator", "1", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "2", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "4", "aggregatorId", 2);
        template.sendBodyAndHeader("direct:simpleAggregator", "3", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "4", "aggregatorId", 2);
        template.sendBodyAndHeader("direct:simpleAggregator", "4", "aggregatorId", 2);
        assertMockEndpointsSatisfied();


    }


}