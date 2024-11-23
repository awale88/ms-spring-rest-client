package ms.spring.rest_client.joke;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class JokeService {

    private final RestClient restClient;

    public JokeService() {
        restClient = RestClient.builder()
                .baseUrl("https://official-joke-api.appspot.com")
                .build();
    }

    public Joke findJoke() {
        return restClient.get()
                .uri("/random_joke")
                .retrieve()
                .body(new ParameterizedTypeReference<Joke>() {
                });
    }

    public Joke findJokeById(int id) {
        return restClient.get()
                .uri("/jokes/random", id)
                .retrieve()
                .body(Joke.class);
    }
}
