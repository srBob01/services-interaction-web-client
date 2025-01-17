package ru.arsentiev.restclient.client;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SyncClient {
    private final WebClient webClient;

    public SyncClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public void fetchData() {
        System.out.println("Sending synchronous request...");
        String response = webClient.get()
                .uri("/api/data")
                .retrieve()
                .bodyToMono(String.class)
                .block(); // Блокирующий вызов
        System.out.println("Response: " + response);
    }

}
