package com.farhad.example.functionsample0.client;

import org.springframework.web.reactive.function.client.WebClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringSupplierFluxClient {
  
    public static void main(String [] args) throws Exception {

        WebClient client = WebClient.create();
        

        WebClient.ResponseSpec responseSpec =  client
                                                    .post()
                                                    .uri("http://localhost:8080/stringSupplierFlux")
                                                    .header("accept", "text/event-stream")
                                                    .retrieve();
        responseSpec
                .bodyToFlux(String.class)
                .subscribe(v -> {
                    log.info("{} " ,v);
                });

        System.in.read();

    }
}
