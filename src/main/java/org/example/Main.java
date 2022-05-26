package org.example;

import java.io.*;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.module.guice.*;
import com.google.inject.Guice;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        System.err.println("hello world");
        var objectMapper = new ObjectMapper();
        var injector = Guice.createInjector(new ObjectMapperModule(), new InjectionModule());
        var aFactory = injector.getInstance(AFactory.class);
        var a = aFactory.create("New instance of org.example.A !!!");
        System.err.println("a name: " + a.getName());
        var file = new File("a.json");
        objectMapper.writer().writeValue(file, a);
        var a2 = objectMapper.reader(new GuiceInjectableValues(injector)).readValue(file, A.class);
        System.err.println("a2 name: " + a2.getName());
    }

}
