package com.farhad.example.functionsample1;

import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Flux;
import org.springframework.cloud.function.context.PollableBean;
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
 *   - Adapters for AWS Lambda, Azure, Google Cloud Functions, Apache OpenWhisk and possibly other "serverless" service providers.
 * 
 * 
 */

@SpringBootApplication
public class Application {

    @Bean
	public Supplier<Flux<String>> onceExecutedSupplier() {
		return () -> {
			String time1 = String.valueOf(System.nanoTime());
			String time2 = String.valueOf(System.nanoTime());
			String time3 = String.valueOf(System.nanoTime());
			
			return Flux.just(time1,time2,time3);
		}; 
	}

	@Bean
	@PollableBean(splittable = true)
	public Supplier<Flux<String>> pollableExecutedSupplier() {
		return () -> {
			String time1 = String.valueOf(System.nanoTime());
			String time2 = String.valueOf(System.nanoTime());
			String time3 = String.valueOf(System.nanoTime());
			
			return Flux.just(time1,time2,time3);
		}; 
	}


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		// SpringApplication.run(FunctionSampleApplication.class, "--management.endpoints.web.exposure.include=functions");
		
	}

}
