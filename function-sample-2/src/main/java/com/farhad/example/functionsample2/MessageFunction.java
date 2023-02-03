package com.farhad.example.functionsample2;

import java.util.function.Function;
import  org.springframework.messaging.Message;

public interface MessageFunction extends Function<Message<String>,Message<String>> {

}
