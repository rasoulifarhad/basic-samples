package com.farhad.example.functionsample0;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = Application.class,
                webEnvironment = WebEnvironment.RANDOM_PORT   )
@Slf4j
public class ApplicationTest {

    @Autowired
    private TestRestTemplate rest ;

    @Test
    public void uppercaseFnTest() throws Exception{

        String body = "Hello" ;
        String expected = "HELLO";
        ResponseEntity<String> result =  
                        rest.exchange(RequestEntity
                                            .post(new URI("/uppercaseFn"))
                                            .body(body), 
                         String.class);
        log.info("{}" , result.getBody());
        assertEquals(result.getBody(), expected);
    }
    
}
