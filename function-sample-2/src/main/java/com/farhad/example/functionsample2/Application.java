package com.farhad.example.functionsample2;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.Message;


@SpringBootApplication
public class Application {


	@Bean
	public Function<Flux<String>,Flux<String>> uppercaseFlux(){
		return flux -> flux.map((s) -> s.toUpperCase());
	}

	@Bean                          
	public Function<Flux<String>,Flux<String>> reverseFlux(){
		return flux -> flux.map((s) -> new StringBuilder(s).reverse().toString());
	}

	@Bean
	public Function<String,String> uppercase(){
		return (s) -> s.toUpperCase();
	}

	@Bean                          
	public Function<String,String> reverse(){
		return (s) -> new StringBuilder(s).reverse().toString();
	}


	@Bean
	public IntegrationFlow uppercaseFlow() {
		return IntegrationFlows
						.from(MessageFunction.class,(gateway) -> gateway.beanName("uppercaseflow"))
						.<String,String>transform(String::toUpperCase)
						.logAndReply();
	}

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		// SpringApplication.run(FunctionSampleApplication.class, "--management.endpoints.web.exposure.include=functions");
		
	}

}
