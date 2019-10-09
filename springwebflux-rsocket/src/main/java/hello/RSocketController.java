package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

//** Fire & Forget  */
@Controller
class RSocketController {   


    @MessageMapping("hello")
    public Mono<Message> helloServer(Message message) {
        return Mono.just(new Message(message + " | Server says hello!"));         
    }
}