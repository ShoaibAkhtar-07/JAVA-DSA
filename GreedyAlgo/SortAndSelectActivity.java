package GreedyAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SortAndSelectActivity {
    public static void main(String[] args) {
        int[] start = { 0, 1, 3, 5, 5, 8 };
        int[] end = { 6, 2, 4, 7, 9, 9 };
        int[][] sortAct = new int[start.length][3];
        for (int i = 0; i < sortAct.length; i++) {
            sortAct[i][0] = i;
            sortAct[i][1] = start[i];
            sortAct[i][2] = end[i];
        }
        Arrays.sort(sortAct, Comparator.comparingDouble(o -> o[2]));

        int maxAct = 0;

        ArrayList<Integer> ans = new ArrayList<>();
        maxAct = 1;
        ans.add(sortAct[0][0]);
        int lastEnd = sortAct[0][2];
        for (int i = 1; i < sortAct.length; i++) {
            if (sortAct[i][1] >= lastEnd) {
                maxAct++;
                ans.add(sortAct[i][0]);
                lastEnd = sortAct[i][2];
            }
        }

        System.out.println("Maximum Activities : " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
    }
}
