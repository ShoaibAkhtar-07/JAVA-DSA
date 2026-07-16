package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElem {

    public static int[] nextGreater(int arr[]) {
        int[] ans = new int[arr.length];

        //// Brute Force
        // Arrays.fill(ans, -1);
        // for (int i = 0; i < arr.length; i++) {
        // for (int j = i + 1; j < arr.length; j++) {
        // if (arr[j] > arr[i]) {
        // ans[i] = arr[j];
        // break;
        // }
        // }
        // }
        // return ans;

        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = arr[s.peek()];
            }
            s.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 8, 0, 1, 3 };
        int ans[] = nextGreater(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}