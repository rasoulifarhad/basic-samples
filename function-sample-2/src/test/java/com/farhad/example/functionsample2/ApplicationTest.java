package com.farhad.example.functionsample2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.catalog.SimpleFunctionRegistry.FunctionInvocationWrapper;
import org.springframework.context.ConfigurableApplicationContext;

import reactor.core.publisher.Flux;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApplicationTest {


    @Test 
    public void  testUpperCaseFunction() {
        try (ConfigurableApplicationContext context = 
                            new SpringApplicationBuilder(Application.class)
                                            .web(WebApplicationType.NONE)
                                            .run(
                                                "--logging.level.org.springframework.cloud.function=DEBUG",
                                                "--spring.main.lazy-initialization=true",
                                                "--spring.cloud.function.definition=uppercaseFlux;reverseFlux;uppercase;reverse;uppercase|reverse")) {
            
            FunctionCatalog functionCatalog = context.getBean(FunctionCatalog.class);
            FunctionInvocationWrapper uppercaseFunction = functionCatalog.lookup("uppercase");

            String expected = "HELLO";
            String result = (String)uppercaseFunction.apply("Hello");

            assertEquals(result, expected);


        } 
    }

    @Test 
    public void  testReverseFunction() {
        try (ConfigurableApplicationContext context = 
                            new SpringApplicationBuilder(Application.class)
                                            .web(WebApplicationType.NONE)
                                            .run(
                                                "--logging.level.org.springframework.cloud.function=DEBUG",
                                                "--spring.main.lazy-initialization=true",
                                                "--spring.cloud.function.definition=reverse")) {
            
            FunctionCatalog functionCatalog = context.getBean(FunctionCatalog.class);
            FunctionInvocationWrapper reverseFunction = functionCatalog.lookup("reverse");

            String expected = "olleH";
            String result = (String)reverseFunction.apply("Hello");

            assertEquals(result, expected);


        } 
    }

    @Test 
    public void  testUppercaseReverseCompositFunction() {
        try (ConfigurableApplicationContext context = 
                            new SpringApplicationBuilder(Application.class)
                                            .web(WebApplicationType.NONE)
                                            .run(
                                                "--logging.level.org.springframework.cloud.function=DEBUG",
                                                "--spring.main.lazy-initialization=true",
                                                "--spring.cloud.function.definition=uppercase|reverse")) {
            
            FunctionCatalog functionCatalog = context.getBean(FunctionCatalog.class);
            FunctionInvocationWrapper uppercaseReverseCompositFunction = functionCatalog.lookup("uppercase|reverse");

            String expected = "OLLEH";
            String result = (String)uppercaseReverseCompositFunction.apply("Hello");

            assertEquals(result, expected);


        } 
    }

    @Test 
    public void  testUppercaseReverseCompositFunction2() {
        try (ConfigurableApplicationContext context = 
                            new SpringApplicationBuilder(Application.class)
                                            .web(WebApplicationType.NONE)
                                            .run(
                                                "--logging.level.org.springframework.cloud.function=DEBUG",
                                                "--spring.main.lazy-initialization=true",
                                                "--spring.cloud.function.definition=uppercase")) {
            
            FunctionCatalog functionCatalog = context.getBean(FunctionCatalog.class);
            Function<Flux<String>,Flux<String>> up = functionCatalog.lookup("uppercase");

            Flux<String> flux  = up.apply(Flux.just("Hello"));
            flux.subscribe(t -> log.info("{}",t));

        } 
    }


}
