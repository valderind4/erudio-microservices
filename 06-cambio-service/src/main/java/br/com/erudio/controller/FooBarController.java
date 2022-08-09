package br.com.erudio.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="Foo Bar")
@RestController
@RequestMapping("cambio-service")
@Slf4j
public class FooBarController {

    @Operation(summary = "Foo Bar")
    @GetMapping("/foo-bar")
//    @Retry(name="default", fallbackMethod = "fallbackMethod")
//    @CircuitBreaker(name="default", fallbackMethod = "fallbackMethod")
//    @RateLimiter(name="default")
    @Bulkhead(name="default")
    public String fooBar(){
        log.info("Resquest to foo-bar is received");
//        var response = new RestTemplate()
//                .getForEntity("http://localhost:8080/foo-bar", String.class);

//        return response.getBody();
        return "once upon a time. foo-bar.";
    }

    public String fallbackMethod(Exception e){
        return "fallbackmethod foo-bar 2";
    }

}
