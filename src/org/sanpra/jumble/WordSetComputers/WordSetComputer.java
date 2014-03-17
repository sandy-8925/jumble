package org.sanpra.jumble.WordSetComputers;

import java.util.Set;

/**
 * Common interface for any strategy to compute set of valid words given an input string
 */
public interface WordSetComputer {
    public Set<String> compute(String inputString);
}
