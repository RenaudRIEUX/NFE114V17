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
    @JsonProperty("id")
    private int movieId;
    private String title;
    private boolean adult;
    private long budget;
    private double popularity;
    private LocalDate release_date;
    private double revenue;
    private int runtime;
    private String status;
    private double vote_average;
    private double vote_count;



}
