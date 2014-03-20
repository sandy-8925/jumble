package org.sanpra.jumble.WordSetComputers;

import org.sanpra.jumble.utils.DictionaryUtils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Simple brute force implementation - generate all possible combinations and test for validity against dictionary
 */
public class SimpleWordSetComputer implements WordSetComputer {

    private static final int MINIMUM_VALID_WORD_SIZE = 2;

    /**
     * Generates a set of valid words that can be formed from the characters in the input string
     * @param inputString Input string
     * @return The set of valid words
     *
     * If inputString is null or empty, returns empty set
     */
    @Override
    public Set<String> compute(String inputString) {
        if(inputString == null || inputString.isEmpty())
            return new HashSet<>();
        Set<String> wordSet = generateAllPermutations(inputString);
        removeInvalidWordsFromSet(wordSet);
        return wordSet;
    }

    /**
     * Removes all invalid words from wordSet. Word validity is based on call to DictionaryUtils.isValidWord
     * @param wordSet Set of strings. If wordSet is empty or null, returns with no changes.
     */
    private void removeInvalidWordsFromSet(Set<String> wordSet) {
        if(wordSet == null) return;
        Iterator<String> wordSetIterator = wordSet.iterator();
        while(wordSetIterator.hasNext()) {
            if(!DictionaryUtils.isValidWord(wordSetIterator.next()))
                wordSetIterator.remove();
        }
    }

    /**
     * Generate all possible permutations of characters in inputString, of length>=2
     * @param inputString String containing characters for which permutations need to be computed.
     * @return  A Set of String objects containing all possible permutations for characters in inputString
     *          If inputString is empty or null, returns empty set
     */
    private Set<String> generateAllPermutations(String inputString) {
        Set<String> permutations = new HashSet<>();
        permute("", inputString, permutations);
        return permutations;
    }

    /**
     * Generates all possible permutations(of length>=2) of characters in remaining, appends them to prefix and stores the strings in permutations
     * @param prefix Prefix string for permutation
     * @param remaining  Remaining characters for which permutations need to be generated
     * @param permutations   Set in which permutations must be stored
     */
    private static void permute(String prefix, String remaining, Set<String> permutations) {
        if(permutations == null || prefix == null || remaining == null) return;
        if(remaining.isEmpty()) return;

        //generate all possible permutations for prefix as well, if it has 2 or more characters
        if(prefix.length() >= MINIMUM_VALID_WORD_SIZE)
            permute("", prefix, permutations);

        //recursion stopping condition - if remaining is single character, add to permutation set
        if(remaining.length() == 1) {
            permutations.add(prefix + remaining);
            return;
        }

        //for each character in String remaining, append to prefix and generate permutations of remaining characters
        for(int counter = 0; counter < remaining.length(); counter++) {
            String newPrefix = prefix + remaining.charAt(counter);
            String newRemaining = remaining.substring(0, counter) + remaining.substring(counter+1, remaining.length());
            permute(newPrefix, newRemaining, permutations);
        }
    }


}
