package com.farhad.example.functionsample3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.slf4j.Slf4j;

// @Slf4j
public class TestApp {


//    @Test 
//    public void  testUpperCaseFunction() {
//        try (ConfigurableApplicationContext context = 
//                            new SpringApplicationBuilder(Application.class)
//                                            .web(WebApplicationType.NONE)
//                                            .run(
//                                                "--logging.level.org.springframework.cloud.function=DEBUG",
//                                                "--spring.main.lazy-initialization=true",
//                                                "--spring.cloud.function.definition=uppercaseFlux;reverseFlux;uppercase;reverse;uppercase|reverse")) {
//            
//            FunctionCatalog functionCatalog = context.getBean(FunctionCatalog.class);
//            FunctionInvocationWrapper uppercaseFunction = functionCatalog.lookup("uppercase");
//
//            String expected = "HELLO";
//            String result = (String)uppercaseFunction.apply("Hello");
//
//            assertEquals(result, expected);
//
//
//        } 
//    }


}
