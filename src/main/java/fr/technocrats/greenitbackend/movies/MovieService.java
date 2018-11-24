package fr.technocrats.greenitbackend.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MovieService {

    @Value("${tmdb_base_url}")
    private String tmdbBaseUrl;

    @Value("${tmdb_api_key}")
    private String tmdbApiKey;

    private RestTemplate restTemplate = new RestTemplate();


    public List<Movie> fillDatabase() {
        MovieWrapper movieWrapper = restTemplate.getForObject(
                tmdbBaseUrl + "/movie/popular?api_key=" + tmdbApiKey,
                MovieWrapper.class);
        return movieWrapper.getResults();
    }
}
