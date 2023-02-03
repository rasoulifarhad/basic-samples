package com.farhad.example.functionsample0;
import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
import org.springframework.cloud.function.context.FunctionCatalog;

import static org.junit.jupiter.api.Assertions.assertEquals;


@FunctionalSpringBootTest
public class FunctionalTest {
    

    @Autowired
    private FunctionCatalog catalog ;

    @Test
    public void testUppercase() {

        Function<String,String> function =  catalog.lookup(Function.class, "uppercase");

        String expected = "HELLO";
        String result = function.apply("Hello");

        assertEquals(expected, result) ;

    }
}
