package com.farhad.example.functionsample0.functions;

import java.util.function.Function;

public class ReverseFn implements Function<String,String>{

    @Override
    public String apply(String value) {
        return new StringBuilder(value).reverse().toString();
    }
    
}
