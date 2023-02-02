package com.farhad.example.functionsample0.client;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;

@Slf4j
public class FluxClient {
   
    public static void main(String [] args) throws Exception {

        WebClient client = WebClient.create();
        
        List<String> list = Arrays.asList("Hello","By","Goodmorning");

        WebClient.ResponseSpec responseSpec =  client
                                                    .post()
                                                    .uri("http://localhost:8080/uppercaseFlux")
                                                    .header("Content-Type", "text/event-stream")
                                                    .header("accept", "text/event-stream")
                                                    .body(Flux.fromIterable(list),String.class)
                                                    .retrieve();
        responseSpec
                .bodyToFlux(String.class)
                .subscribe(v -> {
                    log.info("Received: {} " ,v);
                });

        System.in.read();

    }
}
