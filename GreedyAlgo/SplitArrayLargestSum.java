package GreedyAlgo;

import Stack.stackB;

public class SplitArrayLargestSum {

    public static int isPossible(int mid, int nums[]) {
        int count = 1;
        int tempSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((tempSum + nums[i]) <= mid) {
                tempSum += nums[i];
            } else {
                count++;
                tempSum = nums[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 7, 2, 5, 10, 8 };
        int k = 2;
        int l = 0;
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            l = Math.max(nums[i], l);
            r += nums[i];
        }
        int mid = 0;
        int ans = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            int count = isPossible(mid, nums);
            if (count <= k) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(ans);
    }
}