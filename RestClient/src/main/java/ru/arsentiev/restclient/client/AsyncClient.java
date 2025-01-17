package ru.arsentiev.restclient.client;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AsyncClient {

    private final WebClient webClient;

    public AsyncClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8080").build();
    }

    public void fetchData() {
        System.out.println("Sending asynchronous request...");
        Mono<String> responseMono = webClient.get()
                .uri("/api/data")
                .retrieve()
                .bodyToMono(String.class);

        responseMono.subscribe(
                response -> {
                    System.out.println("Response received: " + response);
                },
                error -> {
                    System.err.println("Error occurred: " + error.getMessage());
                },
                () -> {
                    System.out.println("Request completed.");
                }
        );

        System.out.println("Request sent. Waiting for response asynchronously...");
    }
}
