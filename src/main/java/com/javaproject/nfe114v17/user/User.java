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
    @JsonProperty("userId")
    private int userId;
    @JsonProperty("login")
    private String login;
    @JsonProperty("password")
    private String password;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_movie_favorite",
            joinColumns = { @JoinColumn(name = "userId") },
            inverseJoinColumns = { @JoinColumn(name = "movieId") }
    )
    private Set<Movie> seenMovies;
//    @OneToMany(targetEntity = Movie.class,
//            mappedBy = "user",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    @JoinColumn(name="um_fk", referencedColumnName = "userId")
//    private ;
//




}
