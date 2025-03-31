package com.example.restapi.client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.restapi.model.Libro;

public class DeusterMixManager {

    private String DEUSTERMIX_CONTROLLER_URL_TEMPLATE = "http://%s:%s/api/deustermix";
    private final String DEUSTERMIX_CONTROLLER_URL;
    private final RestTemplate restTemplate;

    public DeusterMixManager(String hostname, String port) {
        DEUSTERMIX_CONTROLLER_URL = String.format(DEUSTERMIX_CONTROLLER_URL_TEMPLATE, hostname, port);
        this.restTemplate = new RestTemplate();
    }

    
    public List<Libro> getAllLibros() {
        ResponseEntity<Libro[]> response = restTemplate.getForEntity(DEUSTERMIX_CONTROLLER_URL + "/libros", Libro[].class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return List.of(response.getBody());
        } else {
            System.out.println("Failed to retrieve books. Status code: " + response.getStatusCode());
            return List.of();
        }
    }


}
