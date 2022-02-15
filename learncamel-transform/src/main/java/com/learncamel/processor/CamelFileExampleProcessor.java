package com.learncamel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.component.file.GenericFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CamelFileExampleProcessor implements org.apache.camel.Processor {
    public void process(Exchange exchange) throws Exception {
        System.out.println("Exchange im Processor is : " + exchange.getIn().getBody());

        GenericFile<File> file = (GenericFile<File>) exchange.getIn().getBody();

        String newValue="";
        String readLine=null;
        if(file != null){
            FileReader file1 = new FileReader(file.getFile());
            BufferedReader reader = new BufferedReader(file1);

            while ((readLine = reader.readLine()) != null){
                System.out.println("Read Line is : " + readLine);

                String oldValue = readLine;

                newValue = newValue.concat(oldValue.replace(",", ":")).concat("\n");

                exchange.getIn().setBody(newValue);
            }
        }
    }
}
