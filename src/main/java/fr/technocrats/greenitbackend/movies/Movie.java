package fr.technocrats.greenitbackend.movies;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "MOVIES")
@Data
public class Movie {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Unique ID")
    private Integer id;

    @Column
    @ApiModelProperty(value = "English title")
    private String title;

    @Column
    @ApiModelProperty(value = "Movie poster")
    @JsonProperty("poster_path")
    private String posterPath;

    @Column
    @ApiModelProperty(value = "Background image for the movie")
    @JsonProperty("backdrop_path")
    private String backdropPath;

    @Column(length = 1024)
    @ApiModelProperty(value = "Synopsis")
    private String overview;

    @Column
    @ApiModelProperty(value = "Release date")
    @JsonProperty("release_date")
    private String releaseDate;

    @Column
    @ApiModelProperty(value = "Rating (0 to 10)")
    @JsonProperty("vote_average")
    private Integer voteAverage;

}
