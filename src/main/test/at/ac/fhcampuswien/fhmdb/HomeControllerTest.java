package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.models.Genre;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java.net.URL;
import java.util.*;
import at.ac.fhcampuswien.fhmdb.HomeController;

class HomeControllerTest {




    @Test
    void does_List_of_movies_exist() {
        List<Movie> actual = HomeController.allMovies;
        assertTrue(!actual.isEmpty());
    }

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
    void filter_movies_by_genre_if_tehre_is_no_movie_with_that_genre_then_show_movies_with_no_genre() {
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

    public void search_for_keyword_in_description() {
        HomeController hc = new HomeController();
        List<Movie> movieList = new ArrayList<Movie>();

        Movie movie1 = new Movie("Anastasia", "blah one", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER));
        Movie movie2 = new Movie("Dingaling", "blah two", Arrays.asList(Genre.ACTION, Genre.THRILLER));
        Movie movie3 = new Movie("Zimmbabwe", "blahthree", Arrays.asList(Genre.THRILLER));
        movieList.addAll(Arrays.asList(movie1, movie2, movie3));

        // Test the searchMovies function with keyword "blah"
        List<Movie> result = hc.searchMovies(movieList, "lAh ");

        List<Movie> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(movie1, movie2));

        assertEquals(expected, result, "Search in description does not work");
    }
    public void search_for_keyword_in_title() {
        HomeController hc = new HomeController();
        List<Movie> movieList = new ArrayList<Movie>();

        Movie movie1 = new Movie("Anastasia", "blah one", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER));
        Movie movie2 = new Movie("Dingaling", "blah two", Arrays.asList(Genre.ACTION, Genre.THRILLER));
        Movie movie3 = new Movie("Zimmbabwesia", "blah three", Arrays.asList(Genre.THRILLER));
        movieList.addAll(Arrays.asList(movie1, movie2, movie3));

        // Test the searchMovies function with keyword "blah"
        List<Movie> result = hc.searchMovies(movieList, "Sia");

        List<Movie> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(movie1, movie3));

        assertEquals(expected, result, "Search in title does not work");
    }
    public void search_for_non_existing_keyword() {
        HomeController hc = new HomeController();
        List<Movie> movieList = new ArrayList<Movie>();

        Movie movie1 = new Movie("Anastasia", "blah one", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER));
        Movie movie2 = new Movie("Dingaling", "blah two", Arrays.asList(Genre.ACTION, Genre.THRILLER));
        Movie movie3 = new Movie("Zimmbabwe", "blah three", Arrays.asList(Genre.THRILLER));
        movieList.addAll(Arrays.asList(movie1, movie2, movie3));

        // Test the searchMovies function with keyword "blah"
        List<Movie> result = hc.searchMovies(movieList, "OSOM");

        List<Movie> expected = new ArrayList<>();

        assertEquals(expected, result, "Search with non existing keyword does not work");
    }
    public void search_executed_while_no_keyword_input() {
        HomeController hc = new HomeController();
        List<Movie> movieList = new ArrayList<Movie>();

        Movie movie1 = new Movie("Anastasia", "blah one", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER));
        Movie movie2 = new Movie("Dingaling", "blah two", Arrays.asList(Genre.ACTION, Genre.THRILLER));
        Movie movie3 = new Movie("Zimmbabwe", "blah three", Arrays.asList(Genre.THRILLER));
        movieList.addAll(Arrays.asList(movie1, movie2, movie3));

        // Test the searchMovies function with keyword "blah"
        List<Movie> result = hc.searchMovies(movieList, null);

        List<Movie> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(movie1, movie2, movie3));

        assertEquals(expected, result, "Search in description does not work");
    }
    @Test
    public void search_for_keyword_in_title_and_description() {
        HomeController hc = new HomeController();
        List<Movie> movieList = new ArrayList<Movie>();

        Movie movie1 = new Movie("Anastasia", "blah one", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER));
        Movie movie2 = new Movie("Dingaling", "blah two", Arrays.asList(Genre.ACTION, Genre.THRILLER));
        Movie movie3 = new Movie("Glass Onion", "blah three", Arrays.asList(Genre.THRILLER));
        movieList.addAll(Arrays.asList(movie1, movie2, movie3));

        // Test the searchMovies function with keyword "on"
        List<Movie> result = hc.searchMovies(movieList, "on");

        List<Movie> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(movie1, movie3));

        assertEquals(expected, result, "Search in title and description does not work");
    }

//did we test configuration settings when testing different possibilities?
}