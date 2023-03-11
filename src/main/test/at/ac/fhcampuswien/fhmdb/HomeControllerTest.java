package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.models.Genre;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import at.ac.fhcampuswien.fhmdb.HomeController;


class HomeControllerTest {

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

  /*  @Test
  //hier problem dass Filter in initialize:searchBtn gesetzt wird, also kann ich nicht hier testen, muss neu
    public void filter_movies_by_genre_nothing_chosen() {
        HomeController hc = new HomeController();
        List<Movie> movieList = new ArrayList<>();

        movieList.add(new Movie("Anastasia", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER)));
        movieList.add(new Movie("Dingaling", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.ADVENTURE)));
        movieList.add(new Movie("Zimmbabwe", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY)));
        movieList.add(new Movie("Cops", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.DOCUMENTARY)));

        List<Movie> expected = movieList;
        List<Movie> actual = hc.filterMoviesByGenre(movieList, null);

        assertEquals(expected, actual);
    }
*/
    @Test
    void filter_movies_by_genre_show_all() {
        HomeController hc = new HomeController();
        List<Movie> movieList = new ArrayList<>();

        movieList.add(new Movie("Anastasia", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER)));
        movieList.add(new Movie("Dingaling", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.ADVENTURE)));
        movieList.add(new Movie("Zimmbabwe", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY)));
        movieList.add(new Movie("Cops", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.DOCUMENTARY)));

        List<Movie> expected = movieList;
        List<Movie> actual = hc.filterMoviesByGenre(movieList, Genre.SHOW_ALL_GENRES);

        assertEquals(expected, actual);
    }

    @Test
    void filter_movies_by_genre_WESTERN() {
        HomeController hc = new HomeController();
        List<Movie> movieList = new ArrayList<>();

        Movie movie1= new Movie("Anastasia", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER));
        Movie movie2= new Movie("Dingaling", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.ADVENTURE));
        Movie movie3= new Movie("Zimmbabwe", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY));
        Movie movie4= new Movie("Cops", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.DOCUMENTARY));
        Collections.addAll(movieList, movie1,movie2,movie3,movie4);

        List<Movie> expected = new ArrayList<>();
        Collections.addAll(expected);

        List<Movie> actual = hc.filterMoviesByGenre(movieList, Genre.WESTERN);

        assertEquals(expected, actual);
    }

    @Test
    void filter_movies_by_genre_DRAMA() {
        HomeController hc = new HomeController();
        List<Movie> movieList = new ArrayList<>();

        Movie movie1= new Movie("Anastasia", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER));
        Movie movie2= new Movie("Dingaling", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.ADVENTURE));
        Movie movie3= new Movie("Zimmbabwe", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY));
        Movie movie4= new Movie("Cops", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.DOCUMENTARY));
        Collections.addAll(movieList, movie1,movie2,movie3,movie4);

        List<Movie> expected = new ArrayList<>();
        Collections.addAll(expected,movie1,movie2);
        List<Movie> actual = hc.filterMoviesByGenre(movieList, Genre.DRAMA);

        assertEquals(expected, actual);
    }

    @Test
    void filter_movies_by_genre_ACTION() {
        HomeController hc = new HomeController();
        List<Movie> movieList = new ArrayList<>();

        Movie movie1= new Movie("Anastasia", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER));
        Movie movie2= new Movie("Dingaling", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.ADVENTURE));
        Movie movie3= new Movie("Zimmbabwe", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY));
        Movie movie4= new Movie("Cops", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.DOCUMENTARY));
        Collections.addAll(movieList, movie1,movie2,movie3,movie4);

        List<Movie> expected = new ArrayList<>();
        Collections.addAll(expected,movie1,movie2,movie3,movie4);

        List<Movie> actual = hc.filterMoviesByGenre(movieList, Genre.ACTION);

        assertEquals(expected, actual);
    }

    @Test
    void filter_movies_by_genre_FANTASY() {
        HomeController hc = new HomeController();
        List<Movie> movieList = new ArrayList<>();

        Movie movie1= new Movie("Anastasia", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER));
        Movie movie2= new Movie("Dingaling", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.ADVENTURE));
        Movie movie3= new Movie("Zimmbabwe", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY));
        Movie movie4= new Movie("Cops", "blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.DOCUMENTARY));
        Collections.addAll(movieList, movie1,movie2,movie3,movie4);

        List<Movie> expected = new ArrayList<>();
        Collections.addAll(expected,movie3);

        List<Movie> actual = hc.filterMoviesByGenre(movieList, Genre.FANTASY);

        assertEquals(expected, actual);
    }

}