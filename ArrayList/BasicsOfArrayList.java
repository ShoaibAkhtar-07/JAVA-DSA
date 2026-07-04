package ArrayList;

import java.util.ArrayList;
import java.util.*;

public class BasicsOfArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // // // Add operation O(1)
        // // list.add(1);
        // // list.add(2);
        // // list.add(3);
        // // list.add(4);
        // // System.out.println(list);

        // // // Get Operation O(n)
        // // int ele = list.get(2);
        // // System.out.println(ele);

        // // // Remove Element O(n)
        // // list.remove(2);
        // // System.out.println(list);

        // // // Set Element at Index O(n)
        // // list.set(2, 3);
        // // System.out.println(list);

        // // // Contains Element O(n)
        // // System.out.println(list.contains(4));

        // // System.out.println(list.size());

        // list.add(2);
        // list.add(5);
        // list.add(9);
        // list.add(3);
        // list.add(6);

        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < list.size(); i++) {
        // max = Math.max(max, list.get(i));
        // }

        // System.out.println(max);

        // System.out.println(list);
        // Collections.sort(list);
        // System.out.println(list);
        // Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);

        // Multi Dimentional ArrayList
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list1.add(i);
            list2.add(i * 2);
            list3.add(i * 3);
        }

        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        for (int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> current = mainList.get(i);
            for (int j = 0; j < current.size(); j++) {
                System.out.print(current.get(j) + "  ");
            }
            System.out.println();
        }

        System.out.println(mainList);
    }

}
