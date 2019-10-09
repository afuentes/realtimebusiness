package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

//** Fire & Forget  */
@Controller
class RSocketController {   


    @MessageMapping("hello")
    public Mono<Message> helloServer(Message message) {
        return Mono.just(message)
                .map(msg -> new Message(msg.message + " | Server says hello!"));
    }
}