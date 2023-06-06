package de.neuefische.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@Service
public class RickService {

    private final WebClient webClient;

    public RickService(@Value ("${rick-api-url}") String rickApiUrl) {
        this.webClient = WebClient.create(rickApiUrl);
    }


    public List<RickCharacter> getRickCharacters() {
            RickResponse rickResponse = Objects.requireNonNull(webClient.get()
                            .uri("/character")
                            .retrieve()
                            .toEntity(RickResponse.class)
                            .block())
                    .getBody();
            assert rickResponse != null;
            return rickResponse.getResults();

        }
    }

