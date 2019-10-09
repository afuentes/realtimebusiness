package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import lombok.Data;
import reactor.core.publisher.Mono;

//** Fire & Forget  */
@Controller
@MessageMapping("/hello")
class RSocketController {   
    public Mono<Void> hello(String data) {
        System.out.println("Rsocket Message:"+data);
        return Mono.empty();
    }

}