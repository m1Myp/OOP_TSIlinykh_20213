package ru.nsu.fit.oop.lab2;

import org.junit.Test;
import ru.nsu.fit.oop.lab2.SubstringSearch;

import static org.junit.Assert.*;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class SubstringSearchTests {
    @Test
    public void simpleTest1() throws IOException {
        FileWriter fw = new FileWriter("input.txt", StandardCharsets.UTF_8);
        String str = "nnnnn n n nn nnnn nnnn nnn";

        fw.write(str);
        fw.close();

        String subStr = "nnn";
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8);
        ArrayList<Integer> kmpSearch = SubstringSearch.KMPSearch("input.txt", subStr);
        int[] result = kmpSearch.stream().mapToInt(i->i).toArray();
        int[] expectedResult = new int[]{0, 1, 2, 13, 14, 18, 19, 23};
        assertArrayEquals(expectedResult, result);
        inputStreamReader.close();

        File file = new File("input.txt");
        boolean wasDeleted = file.delete();
    }

    @Test
    public void simpleTest2() throws IOException {
        FileWriter fw = new FileWriter("input.txt", StandardCharsets.UTF_8);
        String str = "ararara arara araara";

        fw.write(str);
        fw.close();

        String subStr = "ara";
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8);
        ArrayList<Integer> kmpSearch = SubstringSearch.KMPSearch("input.txt", subStr);
        int[] result = kmpSearch.stream().mapToInt(i->i).toArray();
        int[] expectedResult = new int[]{0, 2, 4, 8, 10, 14, 17};
        assertArrayEquals(expectedResult, result);
        inputStreamReader.close();

        File file = new File("input.txt");
        boolean wasDeleted = file.delete();

    }

    @Test
    public void noMatchesTest() throws IOException {
        FileWriter fw = new FileWriter("input.txt", StandardCharsets.UTF_8);
        String str = "ararara arara araara";

        fw.write(str);
        fw.close();

        String subStr = "qqq";
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8);
        ArrayList<Integer> kmpSearch = SubstringSearch.KMPSearch("input.txt", subStr);
        int[] result = kmpSearch.stream().mapToInt(i->i).toArray();
        int[] expectedResult = new int[]{};
        assertArrayEquals(expectedResult, result);
        inputStreamReader.close();

        File file = new File("input.txt");
        boolean wasDeleted = file.delete();
    }

    @Test
    public void largeTest() throws IOException { //on my laptop it takes 2m45s
        FileWriter fw = new FileWriter("input.txt", StandardCharsets.UTF_8);
        String str = "a".repeat(10000000) + 'b' + "a".repeat(10000000);
        fw.write(str);
        fw.close();

        String subStr = "b";
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8);
        ArrayList<Integer> kmpSearch = SubstringSearch.KMPSearch("input.txt", subStr);
        int[] result = kmpSearch.stream().mapToInt(i->i).toArray();
        int[] expectedResult = new int[]{10000000};
        assertArrayEquals(expectedResult, result);
        inputStreamReader.close();

        File file = new File("input.txt");
        boolean wasDeleted = file.delete();
    }
}