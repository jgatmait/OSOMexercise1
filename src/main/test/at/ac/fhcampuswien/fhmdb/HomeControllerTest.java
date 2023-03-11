package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.models.Genre;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class HomeControllerTest {


    @Test
    public void sort_movies_by_titles_ascending(){

        HomeController hc = new HomeController();
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Anastasia","blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER)));
        movieList.add(new Movie("Dingaling","blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER)));
        movieList.add(new Movie("Zimmbabwe","blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY)));
        movieList.add(new Movie("Cops","blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.DOCUMENTARY));

        hc.sortMovieList(movieList,true);

        assertEquals("Anastasia",movieList.get(0).getTitle());
        assertEquals("Cops",movieList.get(1).getTitle());
        assertEquals("Dingaling",movieList.get(2).getTitle());
        assertEquals("Zimmbabwe",movieList.get(3).getTitle());

    }
    @Test
    public void sort_movies_by_titles_descending(){

        HomeController hc = new HomeController();
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Anastasia","blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER)));
        movieList.add(new Movie("Dingaling","blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER)));
        movieList.add(new Movie("Zimmbabwe","blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY)));
        movieList.add(new Movie("Cops","blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.DOCUMENTARY));

        hc.sortMovieList(movieList,false);

        assertEquals("Anastasia",movieList.get(3).getTitle());
        assertEquals("Cops",movieList.get(2).getTitle());
        assertEquals("Dingaling",movieList.get(1).getTitle());
        assertEquals("Zimmbabwe",movieList.get(0).getTitle());

    }

@Test
    public void filter_movies_by_genre_documentary(){
        HomeController hc = new HomeController();
        List<Movie> movieList = new ArrayList<>();

        movieList.add(new Movie("Anastasia","blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER)));
        movieList.add(new Movie("Dingaling","blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.ADVENTURE)));
        movieList.add(new Movie("Zimmbabwe","blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY)));
        movieList.add(new Movie("Cops","blah blah", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.DOCUMENTARY));

        filterMoviesByGenre(movieList, DOCUMENTARY);

        assertEquals("Anastasia",movieList.get().getGenre());
        assertEquals("Cops",movieList.get(2).getTitle());
        assertEquals("Dingaling",movieList.get(1).getTitle());
        assertEquals("Zimmbabwe",movieList.get(0).getTitle());

    }


}