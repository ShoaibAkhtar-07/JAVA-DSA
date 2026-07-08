package ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class LeetCode2150 {

    public static ArrayList<Integer> lonely(ArrayList<Integer> nums) {
        Collections.sort(nums);
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            int curr = nums.get(i);
            boolean isLonely = true;
            if (i > 0 && nums.get(i - 1).equals(curr) || i < nums.size() - 1 && nums.get(i + 1).equals(curr)) {
                isLonely = false;
            }
            if (i > 0 && nums.get(i - 1).equals(curr - 1) || i < nums.size() - 1 && nums.get(i + 1).equals(curr + 1)) {
                isLonely = false;
            }
            if (isLonely == true) {
                results.add(curr);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(5);
        nums.add(3);

        System.out.println(lonely(nums));
    }
}
