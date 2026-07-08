package ArrayList;

import java.util.ArrayList;

public class LeetCode2190 {

    public static int mostFreqFoll(int key, ArrayList<Integer> list) {
        int[] frequency = new int[1001];
        for (int i = 0; i < list.size() - 1; i++) {
            if (key == list.get(i)) {
                int found = list.get(i + 1);
                frequency[found]++;
            }
        }

        int max = Integer.MIN_VALUE;
        int target = 0;

        for (int i = 0; i < frequency.length; i++) {
            if (max < frequency[i]) {
                target = i;
                max = frequency[i];
            }
        }
        return target;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(100);
        list.add(200);
        list.add(1);
        list.add(100);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println(mostFreqFoll(1, list));
    }
}