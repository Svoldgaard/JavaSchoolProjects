package dk.easv.wordsearch.bll;


import dk.easv.wordsearch.dal.WordData;
import java.util.List;

public class WordLogic {

    private WordData wordData;

    public WordLogic() {
        wordData = new WordData();
        wordData.readFile(); // Load words when the logic is initialized
    }

    public List<String> getWords() {
        return wordData.getWords(); // Provide access to words
    }

    public List<String> loadSearchHistory() {
        return wordData.loadSearchHistory();
    }

    // Save search history to the data layer (WordData)
    public void saveSearchHistory(List<String> searchHistory) {
        wordData.saveSearchHistory(searchHistory);
    }
}
