package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.List;

public class MovieSearch {
    private List<Movie> movieList;
    public MovieSearch(List<Movie> movieList){
        this.movieList = movieList;
    }
    // Methode zum Suchen von Filmen nach Titel
    public List<Movie> searchByTitle(String key){
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movieList){
            if (movie.getTitle().contains(key)){
                result.add(movie);
            }
        }
        return result;
    }
    public List<Movie> searchByDescription(String description){
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movieList){
            if ( movie.getDescription().contains(description)){
                result.add(movie);
            }
        }
        return result;
    }

}
