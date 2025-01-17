package ru.arsentiev.restclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.arsentiev.restclient.client.AsyncClient;
import ru.arsentiev.restclient.client.SyncClient;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {

    private final SyncClient syncClient;
    private final AsyncClient asyncClient;

    public RestClientApplication(SyncClient syncClient, AsyncClient asyncClient) {
        this.syncClient = syncClient;
        this.asyncClient = asyncClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(RestClientApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Running synchronous client:");
        syncClient.fetchData();

        System.out.println("\nRunning asynchronous client:");
        asyncClient.fetchData();
    }

}
