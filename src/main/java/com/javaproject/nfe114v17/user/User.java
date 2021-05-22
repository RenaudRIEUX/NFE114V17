package com.javaproject.nfe114v17.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaproject.nfe114v17.movie.Movie;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
@Getter
@Setter
public class User {
    //String name;
    //String surname;
    @Id
    @GeneratedValue
    @JsonProperty("userid")
    private int userid;
    @JsonProperty("login")
    private String login;
    @JsonProperty("password")
    private String password;

    @OneToMany(targetEntity = Movie.class, cascade = CascadeType.ALL)
    @JoinColumn(name="um_fk", referencedColumnName = "userid")
    private List<Movie> seenMovies;





}
