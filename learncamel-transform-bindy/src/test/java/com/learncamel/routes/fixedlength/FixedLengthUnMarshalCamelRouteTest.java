package com.learncamel.routes.fixedlength;

import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class FixedLengthUnMarshalCamelRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new FixedLengthUnMarshalCamelRoute();
    }

    @Test
    public void unMarshalFixedLengthFile(){
        Exchange exchange = consumer.receive("direct:output");
        List<EmployeeWithFixedLength> employeeWithFixedLengths = (List<EmployeeWithFixedLength>) exchange.getIn().getBody();
        assertNotNull(employeeWithFixedLengths);

        assertEquals("dilip", employeeWithFixedLengths.get(0).getName());
        assertEquals("kevin", employeeWithFixedLengths.get(1).getName());
        LocalDate expectedDate = LocalDate.of(2017,01,12);
        LocalDate expectedDate2 = LocalDate.of(2018,01,22);
        assertEquals(expectedDate.getYear(), employeeWithFixedLengths.get(0).getJoiningDate().getYear());
        assertEquals(expectedDate2.getYear(), employeeWithFixedLengths.get(1).getJoiningDate().getYear());

        assertEquals(30, employeeWithFixedLengths.get(0).getAge());
        assertEquals(30, employeeWithFixedLengths.get(1).getAge());

        BigDecimal expectedDlipSalary = new BigDecimal("8000.00");
        BigDecimal expectedKevinSalary = new BigDecimal("9000.00");
        assertEquals(expectedDlipSalary, employeeWithFixedLengths.get(0).getSalary());
        assertEquals(expectedKevinSalary, employeeWithFixedLengths.get(1).getSalary());
    }
}