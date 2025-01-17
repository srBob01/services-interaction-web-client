package ru.arsentiev.restserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {
    @GetMapping("/api/data")
    public String getData() throws InterruptedException {
        Thread.sleep(3000);
        return "{\"message\": \"Hello from Server!\"}";
    }
}
