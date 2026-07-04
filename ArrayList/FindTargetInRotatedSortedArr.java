package ArrayList;

import java.util.ArrayList;

public class FindTargetInRotatedSortedArr {

    public static ArrayList<Integer> newArr(ArrayList<Integer> height, int target) {

        ArrayList<Integer> ans = new ArrayList<>();

        int pivot = -1;
        for (int i = 0; i < height.size(); i++) {
            if (height.get(i) > height.get(i + 1)) {
                pivot = i;
                break;
            }
        }
        int rp = pivot;
        int lp = pivot + 1;
        int n = height.size();

        while (lp != rp) {
            if ((height.get(rp) + height.get(lp)) == target) {
                ans.add(lp);
                ans.add(rp);
                return ans;
            }

            if ((height.get(rp) + height.get(lp)) > target) {
                rp = (n + rp - 1) % n;
            } else {
                lp = (lp + 1) % n;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(11);
        height.add(15);
        height.add(6);
        height.add(8);
        height.add(9);
        height.add(10);
        System.out.print(newArr(height, 16));
    }
}
