package com.learncamel.routes.csv;

import com.learncamel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class CSVUnMarshalRoute extends RouteBuilder {
    public void configure() throws Exception {
        DataFormat bindy = new BindyCsvDataFormat(Employee.class);

        from("file:data/csv/input?fileName=file1.txt&noop=true")
        .unmarshal(bindy)
        .log("unMarshaled message is ${body}")
        .to("direct:output");
    }
}
