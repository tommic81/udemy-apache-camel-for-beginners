package com.learncamel.routes.csv;

import com.learncamel.domain.EmployeeWithAddress;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class CsvunMarshalWithLinkRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CsvUnMarshalWithLinkRoute();
    }
    @Test
    public void  umMarshalCSV(){
        Exchange exchange = consumer.receive("direct:output");

        EmployeeWithAddress employeeWithAddress = (EmployeeWithAddress) exchange.getIn().getBody();

        assertEquals("USA",employeeWithAddress.getAddress().getCountry());

    }
}