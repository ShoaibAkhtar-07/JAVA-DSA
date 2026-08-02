package GreedyAlgo;

import java.util.*;

public class IndianCoins {
    public static void main(String[] args) {
        Integer[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        int value = 5011;

        Arrays.sort(coins, Comparator.reverseOrder());
        ArrayList<Integer> ans = new ArrayList<>();
        int CountCoins = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= value) {
                while (coins[i] <= value) {
                    ans.add(coins[i]);
                    CountCoins++;
                    value -= coins[i];
                }
            }
        }
        System.out.println("Total Min coins Used : " + CountCoins);
        for (int num : ans) {
            System.out.print(num + " ");
        }

    }
}
