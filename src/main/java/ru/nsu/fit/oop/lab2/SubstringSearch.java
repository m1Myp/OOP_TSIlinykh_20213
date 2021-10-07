package ru.nsu.fit.oop.lab2;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.nio.file.Files;

import static java.lang.Integer.max;

public class SubstringSearch {
    /**
     * Finds array of length of the longest native substring prefix
     *
     * @param str array of char we want to finds prefixes
     * @param len len of array of char we want to find
     * @return array of length of the longest native substring prefix
     */
    private static int[] prefixFunction(String str, int len){
        int[] values = new int[str.length()];
        for(int i = 0; i < len; ++i) values[i] = 0;
        for(int i = len; i < str.length(); ++i){
            int j = 0;
            while(i + j < str.length() && str.charAt(j) == str.charAt(i+j)){
                values[i+j] = max(values[i+j], j + 1);
                ++j;
            }
        }
        return values;
    }

    /**
     * Finds the indices of the occurrence of a substring {@param searchParam} in {@param file}
     *
     * @param fileName Name of file where we want to search occurrence
     * @param searchParam array of char we want to find
     * @return array of indices of the occurrences. Count from 0
     * @throws IOException if some problems with a reading of the file
     */
    public static ArrayList<Integer> KMPSearch(String fileName, String searchParam) throws IOException {
        if (searchParam == null) {
            throw new NullPointerException("SearchParam is null");
        }

        ArrayList<Integer> indexes = new ArrayList<>();
        String text = new String(Files.readAllBytes(Path.of(fileName)));
        int[] prefixFunc = prefixFunction(searchParam+'#'+text, searchParam.length());

        for(int i = 0; i <= text.length(); ++i){
            if(prefixFunc[i+searchParam.length()] >= searchParam.length())
                indexes.add(i-searchParam.length());
        }
        return indexes;
    }

}