package Application.DSA;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.abs;

public class Anagram {


    public int howManyCharacterToMakeAnagram(String first, String second) {


        int[] charCounts1 = getCharCounts(first);
        int[] charCounts2 = getCharCounts(second);

        return compareCharCounts(charCounts1,charCounts2);





    }

    private int compareCharCounts(int[] charCounts1, int[] charCounts2) {
        return IntStream.range(0,26).map(i -> abs(charCounts1[i]-charCounts2[i])).sum();
    }

    private int[] getCharCounts(String first) {

        int[] result = new int[26];
        int offset = (int)'a';
        first.chars().forEach(c -> result[c-offset]++);

        return result;


    }
}
