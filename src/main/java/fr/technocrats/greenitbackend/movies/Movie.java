package fr.technocrats.greenitbackend.movies;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "MOVIES")
@Data
public class Movie {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String title;

    @Column
    private String poster_path;

    @Column
    private String backdrop_path;

    @Column(length = 1024)
    private String overview;

    @Column
    private String release_date;
}
