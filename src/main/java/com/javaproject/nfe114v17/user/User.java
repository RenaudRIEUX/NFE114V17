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

//    @OneToMany(targetEntity = Movie.class,
//            mappedBy = "user",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    @JoinColumn(name="um_fk", referencedColumnName = "userId")
//    private Set<Movie> seenMovies;
//




}
