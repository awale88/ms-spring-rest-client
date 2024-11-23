package ms.spring.rest_client.joke;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jokes")
public class JokeController {

    private final JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping()
    Joke findJoke() {
        return jokeService.findJoke();
    }

    @GetMapping("/{id}")
    Joke findJokeById(@PathVariable Integer id){
        return jokeService.findJokeById(id);
    }
}
