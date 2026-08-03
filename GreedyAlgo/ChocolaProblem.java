package GreedyAlgo;

import java.util.*;

public class ChocolaProblem {
    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer horCost[] = { 4, 1, 3 };
        Integer verCost[] = { 2, 1, 3, 1, 4 };

        Arrays.sort(horCost, Collections.reverseOrder());
        Arrays.sort(verCost, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;
        while (h < horCost.length && v < verCost.length) {
            if (horCost[h] >= verCost[v]) {
                cost += (horCost[h] * vp);
                h++;
                hp++;
            } else {
                cost += (verCost[v] * hp);
                v++;
                vp++;
            }
        }

        while (h < horCost.length) {
            cost += (horCost[h] * vp);
            h++;
            hp++;
        }
        while (v < verCost.length) {
            cost += (verCost[v] * hp);
            v++;
            vp++;
        }
        System.out.println("minimum cost of cuts : " + cost);
    }
}