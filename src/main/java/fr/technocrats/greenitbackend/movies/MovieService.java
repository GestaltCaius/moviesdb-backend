package fr.technocrats.greenitbackend.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MovieService {

    @Value("${tmdb_base_url}")
    private String tmdbBaseUrl;

    @Value("${tmdb_api_key}")
    private String tmdbApiKey;

    @Autowired
    private MovieDao movieDao;

    private RestTemplate restTemplate = new RestTemplate();


    /**
     * Request the first 20 most popular movies from TMDB and then put the movies into the database
     * @return HTTP status code (CREATED or BAD REQUEST)
     */
    public ResponseEntity<String> fillDatabase() {
        MovieWrapper movieWrapper = restTemplate.getForObject(
                tmdbBaseUrl + "/movie/popular?api_key=" + tmdbApiKey,
                MovieWrapper.class);
        List<Movie> movieList = movieWrapper.getResults();

        try {
            movieDao.addMovieList(movieList);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Find all movies from database
     * @return movies list
     */
    public List<Movie> findAll() { return movieDao.findAll(); }

    /**
     * Get a movie
     * @param id movie's id
     * @return movie which id = `id`
     */
    public Movie findOne(Integer id) {
        return movieDao.findById(id).orElse(null);
    }
}
