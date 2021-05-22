package com.javaproject.nfe114v17.movie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    int movieId;
    @JsonProperty("title")
    String title;
    @JsonProperty("adult")
    boolean adult;
    @JsonProperty("budget")
    long budget;
    @JsonProperty("popularity")
    double popularity;
    @JsonProperty("release_date")
    LocalDate release_date;
    @JsonProperty("revenue")
    double revenue;
    @JsonProperty("runtime")
    int runtime;
    @JsonProperty("status")
    String status;
    @JsonProperty("vote_average")
    double vote_average;
    @JsonProperty("vote_count")
    double vote_count;

}
