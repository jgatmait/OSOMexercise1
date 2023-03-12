package at.ac.fhcampuswien.fhmdb.ui;

import at.ac.fhcampuswien.fhmdb.HomeController;
import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieCellTest {

    @Test
    void updateItem_if_no_description_available() {
            MovieCell mc=new MovieCell();
            Movie movie1= new Movie("Anastasia", "", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER));
            String expected="No description available";

            mc.updateItem(movie1, false);
            String actual= movie1.getDescription();

    }


}