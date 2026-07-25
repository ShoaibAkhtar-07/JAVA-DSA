package GreedyAlgo;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] value = { 500 };
        int[] weight = { 30 };
        int capacity = 10;

        double[] ratio = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            ratio[i] = value[i] / (double) weight[i];
        }

        double ans = 0;
        for (int i = 0; i < ratio.length; i++) {
            if (capacity >= weight[i]) {
                ans += value[i];
                capacity -= weight[i];
            } else {
                ans += (double) ratio[i] * capacity;
                capacity = 0;
                break;
            }
        }
        System.out.println(ans);
    }
}
