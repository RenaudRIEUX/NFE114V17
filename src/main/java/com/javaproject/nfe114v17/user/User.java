package com.javaproject.nfe114v17.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaproject.nfe114v17.movie.Movie;
import lombok.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.*;
import java.util.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String login;
    private String password;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "seen_movies",
            joinColumns = { @JoinColumn(name = "userId") },
            inverseJoinColumns = { @JoinColumn(name = "movieId") }
    )
    private Set<Movie> seenMovies;

    public void addMovie(Movie movie){
        seenMovies.add(movie);
    }

}
