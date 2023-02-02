package com.farhad.example.functionsample3;

import java.util.Random;
import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {


	@Bean
	public Function<Bar,Foo> fooBar() {
		
		return (bar) -> {
			int id = new Random().nextInt(1000);
			Foo foo = new Foo(id, bar);
			return foo ; 
		};
	}

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		// SpringApplication.run(FunctionSampleApplication.class, "--management.endpoints.web.exposure.include=functions");
		
	}

}
