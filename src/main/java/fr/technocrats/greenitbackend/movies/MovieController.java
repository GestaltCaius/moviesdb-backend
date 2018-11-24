package fr.technocrats.greenitbackend.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/fill", method = RequestMethod.GET)
    public List<Movie> fillDatabase() {
        return movieService.fillDatabase();
    }
}
