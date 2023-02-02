package com.farhad.example.functionsample0.client;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {
    
    public static void main(String [] args) throws Exception {

        WebClient client = WebClient.create();
        
        String body = "Hello";
        WebClient.ResponseSpec responseSpec =  client
                                                    .post()
                                                    .uri("http://localhost:8080/uppercaseFn")
                                                    .header("Content-Type", "text/plain")
                                                    .body(BodyInserters.fromValue(body))
                                                    .retrieve();
        responseSpec
                .bodyToFlux(String.class)
                .subscribe(v -> {
                    log.info("{} Uppercased To: {}" , body,v);
                });

        System.in.read();

    }
}
