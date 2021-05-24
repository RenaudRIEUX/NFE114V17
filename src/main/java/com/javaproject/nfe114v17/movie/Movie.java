package com.javaproject.nfe114v17.movie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaproject.nfe114v17.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    @Id
    @JsonProperty("movieId")
    private int movieId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("adult")
    private boolean adult;
    @JsonProperty("budget")
    private long budget;
    @JsonProperty("popularity")
    private double popularity;
    @JsonProperty("release_date")
    private LocalDate release_date;
    @JsonProperty("revenue")
    private double revenue;
    @JsonProperty("runtime")
    private int runtime;
    @JsonProperty("status")
    private String status;
    @JsonProperty("vote_average")
    private double vote_average;
    @JsonProperty("vote_count")
    private double vote_count;
//    @JsonProperty("user")
//    @ManyToOne
//    @JoinColumn(name="userId")
//    private User user;


}
