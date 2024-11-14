package dk.easv.wordsearch.gui;

import dk.easv.wordsearch.bll.WordLogic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.List;

public class HelloController {

    @FXML
    private ListView<String> AllWords; // Specify the generic type
    @FXML
    private ListView<String> AllA; // Specify the generic type
    @FXML
    private ListView<String> AllN; // Specify the generic type
    @FXML
    private ListView<String> SearchHistory; // Specify the generic type
    @FXML
    private TextField txtWordSearch;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnClearHistory;
    @FXML
    private Label lblWordCount;
    @FXML
    private Label lblSearchResult;

    private WordLogic wordLogic; // Declare WordLogic
    private ObservableList<String> allWords = FXCollections.observableArrayList();
    private ObservableList<String> allA = FXCollections.observableArrayList();
    private ObservableList<String> allN = FXCollections.observableArrayList();
    private ObservableList<String> searchHistory = FXCollections.observableArrayList(); // This should be ObservableList

    public HelloController() {
        wordLogic = new WordLogic(); // Initialize WordLogic
        this.searchHistory.addAll(wordLogic.loadSearchHistory()); // Load search history from file
    }

    @FXML
    public void initialize() {
        loadWords();
        SearchHistory.setItems(searchHistory); // Correct way to set the ObservableList
    }

    private void loadWords() {
        allWords.addAll(wordLogic.getWords()); // Load words into AllWords ListView
        AllWords.setItems(allWords); // Set the items for the ListView
        lblWordCount.setText(String.valueOf(allWords.size())); // Update word count label
    }

    @FXML
    protected void onSearch(ActionEvent actionEvent) {
        String searchTerm = txtWordSearch.getText().toLowerCase();

        // Clear the lists before updating them with new results
        allA.clear();
        allN.clear();
        allWords.clear();
        AllA.setItems(allA);
        AllN.setItems(allN);
        AllWords.setItems(allWords);

        // Check if the search term starts with 'a' or 'n'
        if (searchTerm.startsWith("a")) {
            allA.addAll(getWordsStartingWith("a", searchTerm)); // Add words starting with 'a' to AllA
            AllA.setItems(allA); // Set items for ListView
        } else if (searchTerm.startsWith("n")) {
            allN.addAll(getWordsStartingWith("n", searchTerm)); // Add words starting with 'n' to AllN
            AllN.setItems(allN); // Set items for ListView
        } else if (!searchTerm.isEmpty()) {
            // If the search term starts with any letter other than 'a' or 'n', search in all words
            allWords.addAll(getWordsStartingWith("", searchTerm)); // Get words containing the search term
            AllWords.setItems(allWords); // Set items for ListView
        } else {
            lblSearchResult.setText("Search word was not on the list");
            return; // Exit if the search term is invalid or empty
        }

        lblSearchResult.setText("Search Results for: " + searchTerm);

        // Add to search history if it's not already there
        if (!searchHistory.contains(searchTerm)) {
            searchHistory.add(searchTerm);  // Add the new search term to the history
            wordLogic.saveSearchHistory(searchHistory);  // Save updated history to the file
            SearchHistory.setItems(searchHistory); // Update ListView with new history
        }
    }

    // This method returns words that start with a specific prefix and contains the search term
    private List<String> getWordsStartingWith(String prefix, String searchTerm) {
        return wordLogic.getWords().stream()
                .filter(word -> word.toLowerCase().startsWith(prefix) && word.toLowerCase().contains(searchTerm))
                .toList();
    }

    @FXML
    private void onClearHistory(ActionEvent actionEvent) {
        searchHistory.clear(); // Clear the search history list
        wordLogic.saveSearchHistory(searchHistory); // Save the cleared history
        SearchHistory.setItems(searchHistory); // Update ListView with cleared history
    }

    @FXML
    protected void onExit() {
        wordLogic.saveSearchHistory(searchHistory); // Save search history when exiting
    }
}
