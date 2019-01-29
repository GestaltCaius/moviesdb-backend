package fr.technocrats.greenitbackend.movies;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
@Api(value = "movies", description = "Movies operations")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/filldatabase", method = RequestMethod.GET)
    @ApiOperation(value = "Fill database with movies from TheMovieDB API")
    public ResponseEntity<String> fillDatabase() {
        return movieService.fillDatabase();
    }
}
