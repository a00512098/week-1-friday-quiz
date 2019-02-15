package com.example.week1fridaytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Problems1To6 {

    public static void main(String[] args) {

        // First problem
        System.out.println("----- First problem -----");
        List<String> problem1 = new ArrayList<String>();
        problem1.add("Hello");
        problem1.add("It's me");
        problem1.add("Hello");
        problem1.add("Turtle");
        problem1.add("Turtle");
        problem1.add(null);
        problem1.add(null);
        findDuplicates(problem1);

        // Second problem
        System.out.println("----- Second Problem -----");
        System.out.println(checkPalindrome("redivider"));
        System.out.println(checkPalindrome("Marco"));
        System.out.println(checkPalindrome("civic"));
        System.out.println(checkPalindrome("hello"));

        // Third problem
        System.out.println("----- Third Problem -----");
        for (int i = 20; i > 0; i--)
            fizzBuzz(i);

        // Fourth problem
        System.out.println("----- Fourth Problem -----");
        System.out.println(checkAnagrams("hola", "hoal")); // true
        System.out.println(checkAnagrams("apple", "lepa")); // false
        System.out.println(checkAnagrams("apple", null)); // false
        System.out.println(checkAnagrams("TACO", "COAT")); // true

        // Fifth problem
        System.out.println("----- Fifth Problem -----");
        printTables();

        // Sixth problem
        System.out.println("----- Sixth Problem -----");
        char[][] sixthPArray = {
                {'a','b','c'},
                {'d','e','f'},
                {'g','a','b'}
        };
        System.out.print("| ");
        for (String item : getPositionsForDuplicatedItems(sixthPArray))
            System.out.print(item + " | ");
    }

    // This method finds duplicated items in a list and prints them once
    public static void findDuplicates(List<String> strings) {
        HashMap<String, Integer> duplicates = new HashMap<>();
        for (String item : strings) {
            if (!duplicates.containsKey(item)){
                duplicates.put(item, 1);
            } else {
                duplicates.put(item, duplicates.get(item) + 1);
            }

            if (duplicates.get(item) > 1)
                System.out.println("Duplicated item: " + item + " found " + duplicates.get(item) + " times");
        }
    }

    public static boolean checkPalindrome(String word) {
        if (word == null || word.length() == 0)
            return false;

        for (int i = 0, j = word.length() - 1; i < word.length(); i++, j--) {
            if (word.charAt(i) != word.charAt(j))
                return false;
        }
        return true;
    }

    public static void fizzBuzz(int count) {
        if (count % 5 == 0 && count % 3 == 0) {
            System.out.println("fizzbuzz");
            return;
        } else if (count % 5 == 0) {
            System.out.println("buzz");
            return;
        } else if (count % 3 == 0) {
            System.out.println("fizz");
            return;
        } else {
            System.out.println(count);
        }
    }

    public static boolean checkAnagrams(String word1, String word2) {
        // Special cases
        if (word1 == null || word2 == null)
            return false;
        if (word1.equals(word2))
            return true;

        // Regular scenarios
        if (word1.length() == word2.length()) {
            HashMap<Character, Integer> word1Holder = new HashMap<>();
            HashMap<Character, Integer> word2Holder = new HashMap<>();

            for (int i = 0; i < word1.length(); i++) {
                if (!word1Holder.containsKey(word1.charAt(i))){
                    word1Holder.put(word1.charAt(i), 1);
                    word2Holder.put(word2.charAt(i), 1);
                } else {
                    word1Holder.put(word1.charAt(i), word1Holder.get(word1.charAt(i)) + 1);
                    word2Holder.put(word2.charAt(i), word2Holder.get(word2.charAt(i)) + 1);
                }
            }

            return word1Holder.equals(word2Holder);
        }

        return false;
    }

    public static void printTables() {

        int[][] tables = new int[10][10];
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                tables[i - 1][j - 1] = i * j;
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j < 9)
                    System.out.print(tables[i][j] + ", ");
                else System.out.println(tables[i][j]);
            }
        }
    }

    // Method for problem 6
    public static List<String> getPositionsForDuplicatedItems(char[][] array){
        HashMap<Character, Integer> duplicated = new HashMap<>();
        List<String> indexesList = new ArrayList<>();

        // This array find duplicated items and count them
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (!duplicated.containsKey(array[i][j])){
                    duplicated.put(array[i][j], 1);
                } else {
                    duplicated.put(array[i][j], duplicated.get(array[i][j]) + 1);
                }
            }
        }

        // get rid of non duplicated entries
        // Iterator helps to avoid concurrent exceptions
        Iterator<Map.Entry<Character, Integer>> iterator = duplicated.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            if(entry.getValue() == 1)
                iterator.remove();
        }

        // List indexes of duplicated items
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (duplicated.get(array[i][j]) != null)
                    indexesList.add(i+","+j);
            }
        }

        return indexesList;
    }
}
