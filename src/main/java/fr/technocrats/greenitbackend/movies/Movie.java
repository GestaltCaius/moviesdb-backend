package fr.technocrats.greenitbackend.movies;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "MOVIES")
@Data
public class Movie {
    @Id
    @Column
    private int id;

    @Column
    private String title;

    @Column
    private String poster_path;

    @Column
    private String backdrop_path;

    @Column
    private String overview;

    @Column
    private String release_date;
}
