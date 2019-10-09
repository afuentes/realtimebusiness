package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

//** Fire & Forget  */
@Controller
class RSocketController {   

    @MessageMapping("/hello")
    public Mono<Void> helloServer(Message message) {
        System.out.println("Rsocket Message:"+message);
        return Mono.empty();
    }
}