package com.example.assignment;

public class Movie {
    private String movieName;
    private String movieTime;
    private String seat;

    public Movie(){
    }

    public Movie(String movieName, String movieTime, String seat){
        this.movieName = movieName;
        this.movieTime = movieTime;
        this.seat = seat;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public String getSeat() {
        return seat;
    }
}
