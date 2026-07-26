package GreedyAlgo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MaxLenChainOfPairs {
    public static void main(String[] args) {
        int[][] pairs = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        ArrayList<int[]> ansPair = new ArrayList<>();
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int chainLen = 1;
        ansPair.add(pairs[0]);
        int chainEnd = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (chainEnd < pairs[i][0]) {
                chainLen++;
                ansPair.add(pairs[i]);
                chainEnd = pairs[i][1];
            }
        }
        System.out.println("Chain Length = "+chainLen);
        for (int[] pair : ansPair) {
            System.out.println(Arrays.toString(pair));
        }
    }
}
