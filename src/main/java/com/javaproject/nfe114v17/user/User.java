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
@Entity
@Table
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String password;
    private boolean active;
    private String roles;



    public User(String userName, String password) {
        this.userId = 0;
        this.userName = userName;
        this.password = password;
        this.active = true;
        this.roles = "ADMIN";
        this.seenMovies = null;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "seen_movies",
            joinColumns = { @JoinColumn(name = "userId") },
            inverseJoinColumns = { @JoinColumn(name = "movieId") }
    )
    private Set<Movie> seenMovies;

    public void addSeenMovie(Movie movie){
        seenMovies.add(movie);
    }

    public int getId() {
        return userId;
    }

    public void setId(int id) {
        this.userId = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

}
