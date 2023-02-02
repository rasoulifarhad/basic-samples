package com.farhad.example.functionsample0.functions;

import java.util.function.Function;


public class UppercaseFn implements Function<String,String>{

    @Override
    public String apply(String value) {
        return value.toUpperCase();
    }
    
}
