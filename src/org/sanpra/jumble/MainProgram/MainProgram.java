package org.sanpra.jumble.MainProgram;

import org.sanpra.jumble.WordSetComputers.SimpleWordSetComputer;
import org.sanpra.jumble.WordSetComputers.WordSetComputer;

import java.util.Scanner;
import java.util.Set;

/**
 * Main program class - starting point for execution
 */
public final class MainProgram {
    public static void main(String[] args) {
        //get input string from user
        String inputString = getInputStringFromUser();

        //compute jumbled word set
        WordSetComputer wordSetComputer = new SimpleWordSetComputer();
        Set<String> wordSet = wordSetComputer.compute(inputString);

        //output jumbled word set
        System.out.println();
        System.out.println("List of valid words is: ");
        for(String word : wordSet) {
            System.out.println(word);
        }
    }

    private static String getInputStringFromUser() {
        Scanner inputScanner = new Scanner(System.in);
        return inputScanner.next();
    }
}
