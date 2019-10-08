package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import lombok.Data;
import reactor.core.publisher.Mono;

@Controller
@MessageMapping("hello")
class GreetingServerController {   
    public Mono<Void> hello(Greeting p) {
        return Mono.empty();
    }
    
}

@Data
class Greeting {
    String name;
}