package org.sanpra.jumble.WordSetComputers;

import org.sanpra.jumble.utils.DictionaryUtils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Simple brute force implementation - generate all possible combinations and test for validity against dictionary
 */
public class SimpleWordSetComputer implements WordSetComputer {
    @Override
    public Set<String> compute(String inputString) {
        Set<String> wordSet = generateAllPermutations(inputString);
        removeInvalidWordsFromSet(wordSet);
        return wordSet;
    }

    private void removeInvalidWordsFromSet(Set<String> wordSet) {
        if(wordSet == null) return;
        Iterator<String> wordSetIterator = wordSet.iterator();
        while(wordSetIterator.hasNext()) {
            if(!DictionaryUtils.isValidWord(wordSetIterator.next()))
                wordSetIterator.remove();
        }
    }

    private Set<String> generateAllPermutations(String inputString) {
        Set<String> permutations = new HashSet<>();
        permute("", inputString, permutations);
        return permutations;
    }

    private static void permute(String prefix, String remaining, Set<String> permutations) {
        if(permutations == null || prefix == null || remaining == null) return;
        if(remaining.isEmpty()) return;
        //recursion stopping condition - if remaining is single character, check
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
