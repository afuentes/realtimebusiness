package hello;

import java.time.Duration;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import reactor.core.publisher.Mono;

@Controller
public class RSocketController {

    @MessageMapping("/health")
    public Mono<Void> handleHealth(String payload) {
        return Mono.delay(Duration.ofMillis(10))
        .map(l -> createResponse(payload));

    }


}