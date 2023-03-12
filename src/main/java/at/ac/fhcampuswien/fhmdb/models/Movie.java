package at.ac.fhcampuswien.fhmdb.models;

import java.util.*;

public class Movie {
    private String title;
    private String description;

    // TODO add more properties here
    private List<Genre> genres;


    public Movie(String title, String description,  List<Genre> genres ){
        this.title = title;
        this.description = description;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }
   /* public void setTitle(String title) {this.title=title;}
    public void setDescription(String description) {this.description=description;}
    public void setGenres(Genre newGenre) {this.genres.add(newGenre);}
*/

    public String getDescription() {
        return description;
    }
    public List<Genre> getGenre(){
        Collections.sort(genres);
        return genres;
    }


  /*  public List<Genre> getGenre(){
        try {
            Collections.sort(genres);
        }catch (NullPointerException e){
            if (genres==null){
                this.setGenres(Genre.SHOW_ALL);
            }
        }
        return genres;
    }*/

   // public void addGenre(Genre g){
   //     genres.add(g);
   // } - durch die Lösung aus dem Turorium vom 24.02.23 wurde die methode unnötig

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();
        // TODO add some dummy data here

        Movie movie1 = new Movie("Cars",
                "Okay, here we go. Focus. Speed. I am speed.",
    //           movie1.addGenre(Genre.ACTION);
    //            movie1.addGenre(Genre.ADVENTURE);
    //            movie1.addGenre(Genre.COMEDY);
        //movie1.getGenre();
     // im Tutorium am 24.02.23 wurde das mit Arrays.asList vorgezeigt und
     // das wirkt einfacher und hat merhere Vorteile aus, also haben wir das übernommen
                Arrays.asList(Genre.ANIMATION, Genre.SPORT, Genre.ADVENTURE));

        Movie movie2 = new Movie("Turning Red",
                "But they don't turn my tummy the way you do. I've never met nobody like you.",
                Arrays.asList(Genre.ANIMATION, Genre.FAMILY, Genre.FANTASY));

        Movie movie3  = new Movie("Wakanda Forever",
                "Does it offer you comfort or torment?",
                Arrays.asList(Genre.ACTION, Genre.FANTASY, Genre.DRAMA));

        Movie movie4 = new Movie("Finding Nemo",
                "P. Sherman 42, Wallaby Way, Sydney, Australia",
                Arrays.asList(Genre.ANIMATION, Genre.FAMILY, Genre.ADVENTURE));

        Movie movie5 = new Movie("The Dark Knight",
                "You either die a hero or live long enough to see yourself become the villain.",
                Arrays.asList(Genre.ACTION, Genre.CRIME, Genre.THRILLER));

        Movie movie6 = new Movie("Forrest Gump",
                "Mama always said life was like a box of chocolates. You never know what you're gonna get.",
                Arrays.asList(Genre.COMEDY, Genre.ROMANCE, Genre.DRAMA));

        Movie movie7 = new Movie("Whiplash",
                "Not my tempo.",
                Arrays.asList(Genre.DRAMA, Genre.THRILLER));

        Movie movie8 = new Movie("300",
                "This is Sparta!!!",
                Arrays.asList(Genre.HISTORY, Genre.WAR, Genre.FANTASY));

        Movie movie9 = new Movie("Child's Play",
                "Hi, I'm Chucky. Wanna Play?",
                Arrays.asList(Genre.HORROR, Genre.THRILLER, Genre.MYSTERY));

        Movie movie10 = new Movie("The Sixth Sense",
                "I see dead people.",
                Arrays.asList(Genre.HORROR, Genre.MYSTERY, Genre.THRILLER));

        Movie movie11 = new Movie("The Revenant",
                "I'm not afraid to die anymore",
                Arrays.asList(Genre.THRILLER,Genre.ADVENTURE)); //Genre.WESTERN,

        Movie movie12 = new Movie("Schindler's List",
                "Power is when we have every justification to kill, and we don't.",
                Arrays.asList(Genre.BIOGRAPHY, Genre.DRAMA, Genre.WAR));

        Movie movie13 = new Movie("Greatest Showman",
                "No one ever made a difference by being like everyone else.",
                Arrays.asList( ));//Genre.BIOGRAPHY, Genre.MUSICAL, Genre.DRAMA));

        Movie movie14 = new Movie("Coach Carter",
                "",
                Arrays.asList(Genre.BIOGRAPHY, Genre.SPORT, Genre.DRAMA));

        Movie movie15 = new Movie("Girl in the Picture",
                "",
                Arrays.asList(Genre.DOCUMENTARY, Genre.CRIME));

        Movie movie16 = new Movie("Our Father",
                "Fertility doctor playing god.",
                Arrays.asList(Genre.DOCUMENTARY));

        Movie movie17 = new Movie("Rush",
                "The closer you are to death, the more alive you feel.",
                Arrays.asList(Genre.BIOGRAPHY,Genre.SPORT,Genre.DRAMA));

        Movie movie18 = new Movie("80 for Brady",
                "",
                Arrays.asList(Genre.SPORT, Genre.COMEDY));
        Movie movie19 = new Movie("Predator",
                "",
                Arrays.asList(Genre.HORROR, Genre.SCIENCE_FICTION,Genre.THRILLER));

        Movie movie20 = new Movie("Avatar",
                "",
                Arrays.asList(Genre.SCIENCE_FICTION, Genre.FANTASY, Genre.ACTION));

        //movie3.getGenre();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);
        movies.add(movie6);
        movies.add(movie7);
        movies.add(movie8);
        movies.add(movie9);
        movies.add(movie10);
        movies.add(movie11);
        movies.add(movie12);
        movies.add(movie13);
        movies.add(movie14);
        movies.add(movie15);
        movies.add(movie16);
        movies.add(movie17);
        movies.add(movie18);
        movies.add(movie19);
        movies.add(movie20);

        return movies;
    }

/*
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Movie mov){
            return Objects.equals(this.getTitle(), mov.getTitle()) && Objects.equals(this.getDescription(), mov.getDescription()) && this.getGenre() == mov.getGenre();
        }else {
            return false;
        }
    }*/

}
