package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.models.Genre;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.*;
import at.ac.fhcampuswien.fhmdb.HomeController;


class HomeControllerTest {

    @Test
    void does_List_of_movies_exist() {
        List<Movie> actual = HomeController.allMovies;
        assertTrue(!actual.isEmpty());
    }
   /*
   @Test
   void does_oberservable_List_of_movies_exist() {
        HomeController hc=new HomeController();
        List<Movie> actual = hc.initialize(, null);
        assertTrue(!actual.isEmpty());
    }*/

    @Test
    public void sort_movies_by_titles_ascending() {

        HomeController hc = new HomeController();
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Anastasia", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER)));
        movieList.add(new Movie("Dingaling", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER)));
        movieList.add(new Movie("Zimmbabwe", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY)));
        movieList.add(new Movie("Cops", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.DOCUMENTARY)));

        hc.sortMovieList(movieList, true);

        assertEquals("Anastasia", movieList.get(0).getTitle());
        assertEquals("Cops", movieList.get(1).getTitle());
        assertEquals("Dingaling", movieList.get(2).getTitle());
        assertEquals("Zimmbabwe", movieList.get(3).getTitle());
    }
    @Test
    public void sort_movies_by_titles_descending() {

        HomeController hc = new HomeController();
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Anastasia", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER)));
        movieList.add(new Movie("Dingaling", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER)));
        movieList.add(new Movie("Zimmbabwe", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY)));
        movieList.add(new Movie("Cops", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.DOCUMENTARY)));

        hc.sortMovieList(movieList, false);

        assertEquals("Anastasia", movieList.get(3).getTitle());
        assertEquals("Cops", movieList.get(2).getTitle());
        assertEquals("Dingaling", movieList.get(1).getTitle());
        assertEquals("Zimmbabwe", movieList.get(0).getTitle());

    }

    @Test
    void filter_movies_by_genre_show_all_movies_clicked() {
        HomeController hc = new HomeController();
        List<Movie> movieList = new ArrayList<>();

        Movie movie1= new Movie("Anastasia", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER));
        Movie movie2= new Movie("Dingaling", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.ADVENTURE));
        Movie movie3= new Movie("Glass Onion", "blah blah", Arrays.asList());
        Movie movie4= new Movie("Zimmbabwe", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY));
        Movie movie5= new Movie("Cops", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.DOCUMENTARY));
        Collections.addAll(movieList, movie1,movie2,movie3,movie4,movie5);

        List<Movie> expected = new ArrayList<>();
        Collections.addAll(expected, movie1,movie2,movie3,movie4,movie5);

        List<Movie> actual = hc.filterMoviesByGenre(movieList, Genre.SHOW_ALL);

        assertEquals(expected, actual, "Not all Movies shown!");
    }
    @Test
    void filter_movies_by_genre_no_movie_with_that_genre() {
        HomeController hc = new HomeController();
        List<Movie> movieList = new ArrayList<>();

        Movie movie1= new Movie("Anastasia", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER));
        Movie movie2= new Movie("Dingaling", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.ADVENTURE));
        Movie movie4= new Movie("Zimmbabwe", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY));
        Movie movie5= new Movie("Cops", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.DOCUMENTARY));
        Collections.addAll(movieList, movie1,movie2,movie5,movie4);

        List<Movie> expected = new ArrayList<>();
        Collections.addAll(expected);

        List<Movie> actual = hc.filterMoviesByGenre(movieList, Genre.WESTERN);

        assertEquals(expected, actual, "There is no movie with that genre!");
    }
    @Test
    void filter_movies_by_genre_when_there_is_no_movie_with_that_genre_it_will_show_movies_with_no_genre() {
        HomeController hc = new HomeController();
        List<Movie> movieList = new ArrayList<>();

        Movie movie1= new Movie("Anastasia", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER));
        Movie movie2= new Movie("Dingaling", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.ADVENTURE));
        Movie movie3= new Movie("Glass Onion", "blah blah", Arrays.asList());
        Movie movie4= new Movie("Zimmbabwe", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY));
        Movie movie5= new Movie("Cops", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.DOCUMENTARY));
        Collections.addAll(movieList, movie1,movie2,movie3,movie4, movie5);

        List<Movie> expected = new ArrayList<>();
        Collections.addAll(expected, movie3);

        List<Movie> actual = hc.filterMoviesByGenre(movieList, Genre.WESTERN);

        assertEquals(expected, actual, "Movie with no genre should also be shown");
    }
    @Test
    void filter_movies_by_genre_only_two_movies_have_genre_not_all() {
        HomeController hc = new HomeController();
        List<Movie> movieList = new ArrayList<>();

        Movie movie1= new Movie("Anastasia", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER));
        Movie movie2= new Movie("Dingaling", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.ADVENTURE));
        Movie movie3= new Movie("Glass Onion", "blah blah", Arrays.asList());
        Movie movie4= new Movie("Zimmbabwe", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY));
        Movie movie5= new Movie("Cops", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.DOCUMENTARY));
        Collections.addAll(movieList, movie1,movie2,movie3,movie4,movie5);

        List<Movie> expected = new ArrayList<>();
        Collections.addAll(expected,movie1,movie2,movie3);
        List<Movie> actual = hc.filterMoviesByGenre(movieList, Genre.DRAMA);

        assertEquals(expected, actual, "Not all movies with selected genre shown - 2 movies");
    }
    @Test
    void filter_movies_by_genre_all_movies_have_genre() {
        HomeController hc = new HomeController();
        List<Movie> movieList = new ArrayList<>();

        Movie movie1= new Movie("Anastasia", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER));
        Movie movie2= new Movie("Dingaling", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.ADVENTURE));
        Movie movie3= new Movie("Glass Onion", "blah blah", Arrays.asList());
        Movie movie4= new Movie("Zimmbabwe", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY));
        Movie movie5= new Movie("Cops", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.DOCUMENTARY));
        Collections.addAll(movieList, movie1,movie2,movie3,movie4, movie5);

        List<Movie> expected = new ArrayList<>();
        Collections.addAll(expected,movie1,movie2,movie4,movie5,movie3);

        List<Movie> actual = hc.filterMoviesByGenre(movieList, Genre.ACTION);

        assertEquals(expected, actual, "Not all movies with selected genre shown - all movies");
    }

//did we test configuration settings when testing different possibilities?
}