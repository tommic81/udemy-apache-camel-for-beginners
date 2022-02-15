package com.learncamel.routes.fixedlength;

import com.learncamel.domain.EmployeeWithFixedLength;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.apache.camel.spi.DataFormat;

public class FixedLengthMarshalCamelRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        DataFormat bindy = new BindyFixedLengthDataFormat(EmployeeWithFixedLength.class);

        from("direct:input")
                .marshal(bindy)
                .log("Marshaled message is ${body}")
                .to("file:data/fixedlength/output?fileName=output.txt");

    }
}
