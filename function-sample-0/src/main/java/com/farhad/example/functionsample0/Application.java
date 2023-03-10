package com.farhad.example.functionsample0;

import java.time.Duration;
import java.util.function.Function;
import java.util.function.Supplier;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Flux;

/**
 * Spring Cloud Function has 4 main features:
 * 
 * In the nutshell Spring Cloud Function provides the following features: 
 * 
 *   1. Wrappers for @Beans of type Function, Consumer and Supplier, exposing them to the outside world as either HTTP endpoints 
 *      and/or message stream listeners/publishers with RabbitMQ, Kafka etc.
 * 
 *   - Choice of programming styles - reactive, imperative or hybrid.
 *    
 *   - Function composition and adaptation (e.g., composing imperative functions with reactive).
 *    
 *   - Support for reactive function with multiple inputs and outputs allowing merging, joining and other complex streaming 
 *     operation to be handled by functions.
 *    
 *   - Transparent type conversion of inputs and outputs.
 *    
 *   - Packaging functions for deployments, specific to the target platform (e.g., Project Riff, AWS Lambda and more)
 *    
 *   - Adapters to expose function to the outside world as HTTP endpoints etc.
 *    
 *   - Deploying a JAR file containing such an application context with an isolated classloader, so that you can pack them together 
 *     in a single JVM.
 * 
 *    
 *   - Adapters for AWS Lambda, Azure, Google Cloud Functions, Apache OpenWhisk and possibly other "serverless" service providers.
 * 
 * 
 */

@SpringBootApplication
public class Application {

    @Bean
	public Function<Flux<String>,Flux<String>> uppercaseFlux() {
		return flux -> flux.map(value -> value.toUpperCase() ) ;
	}

	@Bean
	public Function<String,String> uppercase() {
		return value -> value.toUpperCase()  ;
	}

	@Bean
	public Supplier<Flux<String>> stringSupplierFlux() {
		return () -> 
              Flux
			  	.interval(Duration.ofSeconds(2))
				.log()
				.map(counter -> String.format("Counter-%s", counter) );
		
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		// SpringApplication.run(FunctionSampleApplication.class, "--management.endpoints.web.exposure.include=functions");
		
	}

}
