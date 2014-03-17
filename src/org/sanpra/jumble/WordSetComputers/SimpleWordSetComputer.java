package org.sanpra.jumble.WordSetComputers;

import java.util.HashSet;
import java.util.Set;

/**
 * Simple brute force implementation - generate all possible combinations and test for validity against dictionary
 */
public class SimpleWordSetComputer implements WordSetComputer {
    @Override
    public Set<String> compute(String inputString) {
        Set<String> wordSet = new HashSet<>();
        return wordSet;
    }
}
