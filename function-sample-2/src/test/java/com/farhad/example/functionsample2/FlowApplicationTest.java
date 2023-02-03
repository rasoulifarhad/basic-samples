package com.farhad.example.functionsample2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(classes = Application.class,
                webEnvironment = WebEnvironment.RANDOM_PORT   )
public class FlowApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate ;

    @Test
    public void flowUppercaseTest() {

        HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> requestEntity = new HttpEntity<>("Hello", httpHeaders);
		HttpEntity<String> result = this.restTemplate.postForEntity("/uppercaseflow", requestEntity, String.class);
		assertThat(result.getBody()).isEqualTo("HELLO");
    }
    
}
