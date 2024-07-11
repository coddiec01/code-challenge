package com.synchrony.codechallenge.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component //  Mark the class as a Spring component for dependency injection.
public class ImgurApiClient {

    private final WebClient webClient; // Declares a WebClient instance to make HTTP requests.

    @Value("${imgur.client.id}") // Inject values from properties
    private String clientId; // Injects the value of the imgur.client.id property from the properties file.

    @Value("${imgur.api.url}")
    private String apiUrl; // Injects the value of the imgur.api.url property from the properties file.

    public ImgurApiClient(WebClient.Builder webClientBuilder) { // Constructor that accepts a WebClient.Builder instance.
        this.webClient = webClientBuilder.baseUrl(apiUrl).build(); // Builds the WebClient with the base URL set to apiUrl.
    }

    // Method to upload an image, accepting a base64-encoded image string and returning a Mono<ImgurResponse>.
    public Mono<ImgurResponse> uploadImage(String imageBase64) { // Mono accepts a single or empty value
        return webClient.post()
                // Sets the URI to /image.
                .uri("/image")
                // Adds an authorization header with the client ID.
                .header(HttpHeaders.AUTHORIZATION, "Client-ID " + clientId)
                // Sets the request body to the base64-encoded image.
                .bodyValue(imageBase64)
                // Sends the request and retrieves the response.
                .retrieve()
                // Converts the response body to a Mono<ImgurResponse>.
                .bodyToMono(ImgurResponse.class);
    }
    //Method to delete an image, accepting a delete hash and returning a Mono<String>.
    public Mono<String> deleteImage(String deleteHash) {
        // Initiates an HTTP DELETE request.
        return webClient.delete()
                // Sets the URI to /image/{deleteHash}, replacing {deleteHash} with the actual delete hash.
                .uri("/image/{deleteHash}", deleteHash)
                // Adds an authorization header with the client ID.
                .header(HttpHeaders.AUTHORIZATION, "Client-ID " + clientId)
                // Sends the request and retrieves the response.
                .retrieve()
                // Converts the response body to a Mono<String>.
                .bodyToMono(String.class);
    }

    // Method to get an image, accepting an image ID and returning a Mono<ImgurResponse>.
    public Mono<ImgurResponse> getImage(String imageId) {
        // Initiates an HTTP GET request.
        return webClient.get()
                // Sets the URI to /image/{imageId}, replacing {imageId} with the actual image ID.
                .uri("/image/{imageId}", imageId)
                // Adds an authorization header with the client ID.
                .header(HttpHeaders.AUTHORIZATION, "Client-ID " + clientId)
                // Sends the request and retrieves the response.
                .retrieve()
                // Converts the response body to a Mono<ImgurResponse>.
                .bodyToMono(ImgurResponse.class);
    }
}
