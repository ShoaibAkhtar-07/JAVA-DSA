package GreedyAlgo;

import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] value = { 120, 100, 60 };
        int[] weight = { 30, 20, 10 };
        int capacity = 50;

        double[][] ratio = new double[value.length][2];
        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double) weight[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        double ans = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                ans += value[idx];
                capacity -= weight[idx];
            } else {
                ans += (double) ratio[i][1] * capacity;
                capacity = 0;
                break;
            }
        }
        System.out.println(ans);
    }
}
