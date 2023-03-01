package at.ac.fhcampuswien.fhmdb.models;

import java.util.*;

public class Movie {
    private String title;
    private String description;

    // TODO add more properties here

    private List<Genre> genres;




    public Movie(String title, String description ){
        this.title = title;
        this.description = description;
        genres = new ArrayList<>();



    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void addGenre(Genre g){
        genres.add(g);
    }

    public String getGenre(){

        System.out.println(this.getTitle() + " " + genres);
        Collections.sort(genres);

        return genres.toString().replace("[","").replace("]", "");
    }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();
        // TODO add some dummy data here
        Movie movie1 = new Movie("Cars", "Okay, here we go. Focus. Speed. I am speed.");
        movie1.addGenre(Genre.ACTION);
        movie1.addGenre(Genre.ADVENTURE);
        movie1.addGenre(Genre.COMEDY);

        //movie1.getGenre();


        Movie movie2 = new Movie("Turning Red", "But they don't turn my tummy the way you do. I've never met nobody like you.");
        movie2.addGenre(Genre.ANIMATION);
        movie2.addGenre(Genre.FAMILY);
        movie2.addGenre(Genre.FANTASY);

        //movie2.getGenre();

        Movie movie3  = new Movie("Wakanda Forever", "Does it offer you comfort or torment?");
        movie3.addGenre(Genre.ACTION);
        movie3.addGenre(Genre.FANTASY);

        Movie movie4 = new Movie("Finding Nemo", "P. Sherman 42, Wallaby Way, Sydney, Australia");

        Movie movie5 = new Movie("The Dark Knight", "You either die a hero or live long enough to see yourself become the villain.");
        movie5.addGenre(Genre.ACTION);
        movie5.addGenre(Genre.CRIME);
        movie5.addGenre(Genre.DRAMA);

        //movie3.getGenre();

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);

        return movies;
    }
}
