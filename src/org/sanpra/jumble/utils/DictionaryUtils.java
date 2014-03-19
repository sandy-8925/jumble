package org.sanpra.jumble.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;

/**
 * Class holding various utility methods and data for dictionary
 */
public final class DictionaryUtils {
    private static Collection<String> wordList;

    /**
     * Reads list of words from file and stores in wordList
     */
    static {
        final String dictionaryFilePath = "./resources/dictionary/dictionary.txt";
        try {
            wordList = Files.readAllLines(Paths.get(dictionaryFilePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if a word is valid - a word is valid if it is present in the dictionary
     * @param word The query string that will be checked against the dictionary. Will check string as a whole,
     *             and not split into individual words.
     * @return  If word is present in dictionary, returns true, Else, returns false. When
     *  word is null or empty, returns false.
     */
    public static boolean isValidWord(String word) {
        if(word == null || word.isEmpty()) return false;
        return wordList.contains(word);
    }
}
