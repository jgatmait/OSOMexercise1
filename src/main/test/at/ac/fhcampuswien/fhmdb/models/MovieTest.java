package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.HomeController;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void initializeMovies_is_List_not_empty(){
        List<Movie> actual = Movie.initializeMovies();
        assertTrue(!actual.isEmpty());
    }

    //und dann haben wir die getter und setter getestet :)

    @Test
    void get_Title_returns_title() {

        Movie movie1= new Movie("Anastasia", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER));

        String expected="Anastasia";
        String actual= movie1.getTitle();
        assertEquals(expected, actual,"Cannot read title");
    }

    @Test
    void getTitle_when_title_empty() {

        Movie movie1= new Movie("", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER));

        String expected ="";
        String actual = movie1.getTitle();
        assertEquals(expected, actual,"Cannot read empty title");
    }

    @Test
    void getTitle_when_title_null() {

        Movie movie1= new Movie(null, "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER));

        String expected=null;
        String actual= movie1.getTitle();
        assertEquals(expected, actual,"Cannot read null title");
    }
    @Test
    void getDescription_returns_description() {

        Movie movie1= new Movie("Anastasia", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER));

        String expected="blah blah";
        String actual= movie1.getDescription();
        assertEquals(expected, actual,"Cannot read description");
    }
    @Test
    void getDescription_when_description_empty() {

        Movie movie1= new Movie("Anastasia", "", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER));

        String expected="";
        String actual= movie1.getDescription();
        assertEquals(expected, actual,"Cannot read empty description");
    }
    @Test
    void getDescription_when_description_null() {

        Movie movie1= new Movie("Anastasia", null, Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER));

        String expected=null;
        String actual= movie1.getDescription();
        assertEquals(expected, actual,"Cannot read null description");
    }

    @Test
    void getGenre_return_List_of_genres() {

        Movie movie1= new Movie("Anastasia", "blah blah", Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.THRILLER));

            List<Genre> expected=new ArrayList<>();
            Collections.addAll(expected,Genre.DRAMA, Genre.ACTION, Genre.THRILLER);
            Collections.sort(expected);

            List<Genre> actual= movie1.getGenre();
            assertEquals(expected, actual,"Cannot read Genres");
        }
    @Test
    void getGenre_return_empty_List_of_genres() {

        Movie movie1= new Movie("Anastasia", "blah blah", Arrays.asList());

        List<Genre> expected=new ArrayList<>();
        Collections.addAll(expected);

        List<Genre> actual= movie1.getGenre();
        assertEquals(expected, actual,"Cannot read empty Genres");
    }

/*
//cannot test if movies in List Movie.initializeMovies are correct because of equality of Objects...
        @Test
    void initializeMovies_create_List_with_static_data() {

            Movie movie1 = new Movie("Cars","Okay, here we go. Focus. Speed. I am speed.", Arrays.asList(Genre.ANIMATION, Genre.SPORT, Genre.ADVENTURE));
            Movie movie2 = new Movie("Turning Red","But they don't turn my tummy the way you do. I've never met nobody like you.", Arrays.asList(Genre.ANIMATION, Genre.FAMILY, Genre.FANTASY));
            Movie movie3  = new Movie("Wakanda Forever", "Does it offer you comfort or torment?", Arrays.asList(Genre.ACTION, Genre.FANTASY, Genre.DRAMA));
            Movie movie4 = new Movie("Finding Nemo", "P. Sherman 42, Wallaby Way, Sydney, Australia", Arrays.asList(Genre.ANIMATION, Genre.FAMILY, Genre.ADVENTURE));
            Movie movie5 = new Movie("The Dark Knight", "You either die a hero or live long enough to see yourself become the villain.", Arrays.asList(Genre.ACTION, Genre.CRIME, Genre.THRILLER));
            Movie movie6 = new Movie("Forrest Gump", "Mama always said life was like a box of chocolates. You never know what you're gonna get.", Arrays.asList(Genre.COMEDY, Genre.ROMANCE, Genre.DRAMA));
            Movie movie7 = new Movie("Whiplash", "Not my tempo.", Arrays.asList(Genre.DRAMA, Genre.THRILLER));
            Movie movie8 = new Movie("300", "This is Sparta!!!", Arrays.asList(Genre.HISTORY, Genre.WAR, Genre.FANTASY));
            Movie movie9 = new Movie("Child's Play", "Hi, I'm Chucky. Wanna Play?", Arrays.asList(Genre.HORROR, Genre.THRILLER, Genre.MYSTERY));
            Movie movie10 = new Movie("The Sixth Sense", "I see dead people.", Arrays.asList(Genre.HORROR, Genre.MYSTERY, Genre.THRILLER));
            Movie movie11 = new Movie("The Revenant", "I'm not afraid to die anymore", Arrays.asList(Genre.THRILLER,Genre.ADVENTURE)); //Genre.WESTERN,
            Movie movie12 = new Movie("Schindler's List", "Power is when we have every justification to kill, and we don't.", Arrays.asList(Genre.BIOGRAPHY, Genre.DRAMA, Genre.WAR));
            Movie movie13 = new Movie("Greatest Showman", "No one ever made a difference by being like everyone else.", Arrays.asList( ));//Genre.BIOGRAPHY, Genre.MUSICAL, Genre.DRAMA));
            Movie movie14 = new Movie("Coach Carter", null, Arrays.asList(Genre.BIOGRAPHY, Genre.SPORT, Genre.DRAMA));
            Movie movie15 = new Movie("Girl in the Picture", "", Arrays.asList(Genre.DOCUMENTARY, Genre.CRIME));
            Movie movie16 = new Movie("Our Father", "Fertility doctor playing god.", Arrays.asList(Genre.DOCUMENTARY));
            Movie movie17 = new Movie("Rush","The closer you are to death, the more alive you feel.", Arrays.asList(Genre.BIOGRAPHY,Genre.SPORT,Genre.DRAMA));
            Movie movie18 = new Movie("80 for Brady", "", Arrays.asList(Genre.SPORT, Genre.COMEDY));
            Movie movie19 = new Movie("Predator", "", Arrays.asList(Genre.HORROR, Genre.SCIENCE_FICTION,Genre.THRILLER));
            Movie movie20 = new Movie("Avatar", "", Arrays.asList(Genre.SCIENCE_FICTION, Genre.FANTASY, Genre.ACTION));
            Movie[] expected = new Movie[]{movie1,movie2,movie3,movie4,movie5,movie6,movie7,movie8,movie9,
                    movie10,movie11,movie12,movie13,movie14,movie15,movie16,movie17,movie18,movie19,movie20};

            List<Movie> actualL = Movie.initializeMovies();
            Movie[] actual=new Movie[actualL.size()];
            actualL.toArray(actual); // https://codegym.cc/groups/posts/convert-list-to-array 12.3.23
            System.out.println(actual[0].getTitle());
            System.out.println(expected[0].getTitle());
            assertArrayEquals(expected, actual,"Cannot initiaise MovieList");
    }*/
}