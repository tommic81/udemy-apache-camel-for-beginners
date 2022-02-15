package com.learncamel.routes.csv;

import com.learncamel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CSVMarshalRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CSVMarshalRoute();
    }

    @Test
    public void csVMarshalRoute(){
        Employee employee = new Employee();
        employee.setId("1");
        employee.setLastName("Sundar");
        employee.setFirstName("Dilip");

        Employee employee2 = new Employee();
        employee2.setId("2");
        employee2.setLastName("Hart");
        employee2.setFirstName("Kevin");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        employeeList.add(employee2);
    template.sendBody("direct:objInput", employeeList);
        File file = new File("data/csv/output");
        assertTrue(file.isDirectory());
    }
}
