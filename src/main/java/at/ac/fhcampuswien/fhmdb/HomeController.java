package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.*;
import java.util.List;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView movieListView;

    @FXML
    public JFXComboBox genreComboBox;

    @FXML
    public JFXButton sortBtn;

    public static List<Movie> allMovies = Movie.initializeMovies();

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();
    // automatically updates corresponding UI elements when underlying data changes

   // observableMovies.addAll(allMovies);         // add dummy data to observable list

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies);         // add dummy data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        // TODO add genre filter items with genreComboBox.getItems().addAll(...)
        genreComboBox.setPromptText("Filter by Genre");
      //  genreComboBox.getItems().add("SHOW ALL GENRES");
        genreComboBox.getItems().addAll(Genre.values());


        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here

        // Sort button example:
        sortBtn.setOnAction(actionEvent -> {
            if (sortBtn.getText().equals("Sort (asc)")) {
                // DONE TODO sort observableMovies ascending
                sortMovieList(observableMovies, true);
                sortBtn.setText("Sort (desc)");
            } else {
                // DONE TODO sort observableMovies descending
                sortBtn.setText("Sort (asc)");
                sortMovieList(observableMovies, false);
            }
        });

        searchBtn.setOnAction(actionEvent -> {
            Genre filterGenre;
            if (genreComboBox.getValue()!=null) {
                filterGenre = (Genre) genreComboBox.getValue();
            }else {
                filterGenre=Genre.SHOW_ALL;
            }

            observableMovies.clear();
            observableMovies.addAll(filterMoviesByGenre(allMovies, filterGenre));
            String key = searchField.getText();
            List<Movie> searchedMovies = searchMovies(observableMovies, key);
            observableMovies.clear();
            observableMovies.addAll(searchedMovies);
        });

/*
        searchBtn.setOnAction(actionEvent -> {
            String searchText = searchBtn.getText();               // 11.03.23 https://jenkov.com/tutorials/javafx/combobox.html
            Object selectedItem = genreComboBox.getValue(); // 11.03.23 https://jenkov.com/tutorials/javafx/combobox.html
            //    JFXComboBox cb = (JFXComboBox)source;
            //    Object selectedItem = cb.getSelectedItem(); // 11.03.23 https://stackoverflow.com/questions/32752072/jcombobox-and-itemlistener-actionlistener
       /*
            if(searchText.equals("Movie in List")) { //TODO: welche movies haben den gesuchten begriff? copy in zwischenliste
                // TODO show liste movies die gesuchten begriff enthalten (zwischenliste überschreibt observable

            } else if (searchBtn.getText().equals("Movie in List")){
                // TODO : Text "No Movies found - please refine your search"
            // WICHTIG!!! TODO: was ist wenn searchfield leer?
        }

        });
*/
    }

    public void sortMovieList(List<Movie> movieList, boolean ascending){
            if (ascending){
                movieList.sort(Comparator.comparing(Movie::getTitle));
            }else {
                movieList.sort(Comparator.comparing(Movie::getTitle).reversed());
            }
    }


    public static ObservableList<Movie> filterMoviesByGenre(List<Movie> allMovies, Genre filterGenre){
        ObservableList<Movie> filteredList = FXCollections.observableArrayList();
        for (Movie movie: allMovies){
            if (movie.getGenre().contains(filterGenre)){
                filteredList.add(movie);
            }
        }
        for (Movie movie: allMovies){
            if(movie.getGenre().isEmpty()){
                filteredList.add(movie);
            }
        }
        if (filterGenre.equals(Genre.SHOW_ALL)){
            filteredList.clear();
            filteredList.addAll(allMovies);
        }
        return filteredList;

    }
    public List<Movie> searchMovies(List<Movie> movieList, String keyword) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.getTitle().toLowerCase().contains(keyword.toLowerCase()) || movie.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(movie);
            }
        }
        return result;
    }

}