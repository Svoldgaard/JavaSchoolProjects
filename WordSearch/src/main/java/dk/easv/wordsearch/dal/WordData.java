package dk.easv.wordsearch.dal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordData {

    private File myObj = new File("/Users/majkensvoldgaard/Desktop/Jave School projects/WordSearch/src/main/java/dk/easv/wordsearch/dal/Word.txt");
    private List<String> words; // Declare the list to store words

    public WordData() {
        words = new ArrayList<>(); // Initialize the list in the constructor
    }

    public void readFile() {
        try {
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                words.add(data); // Store the data in the list
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Example method to access the stored words
    public List<String> getWords() {
        return words; // Return the list of words
    }

    private static final String HISTORY_FILE_PATH = "search_history.txt";  // Path to the file where you save the search history

    // Load search history from a file
    public List<String> loadSearchHistory() {
        List<String> history = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(HISTORY_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                history.add(line);  // Read each line and add it to the history list
            }
        } catch (IOException e) {
            System.err.println("Error loading search history: " + e.getMessage());
        }
        return history;  // Return the loaded search history
    }

    // Save search history to a file
    public void saveSearchHistory(List<String> searchHistory) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORY_FILE_PATH))) {
            for (String term : searchHistory) {
                writer.write(term);
                writer.newLine();  // Write each search term on a new line
            }
        } catch (IOException e) {
            System.err.println("Error saving search history: " + e.getMessage());
        }
    }
}
