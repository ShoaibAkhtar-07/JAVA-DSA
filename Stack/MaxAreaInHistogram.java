package Stack;

import java.util.Stack;

public class MaxAreaInHistogram {

    public static void findMaxArea(int arr[]) {
        Stack<Integer> st = new Stack<>();
        int[] rightSmaller = new int[arr.length];
        int[] leftSmallet = new int[arr.length];
        int maxArea = 0;

        // Right Smaller
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                rightSmaller[i] = arr.length;
            } else {
                rightSmaller[i] = st.peek();
            }
            st.push(i);
        }

        // Left Smallest
        st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                leftSmallet[i] = -1;
            } else {
                leftSmallet[i] = st.peek();
            }
            st.push(i);
        }

        // Calculating Area
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = rightSmaller[i] - leftSmallet[i] - 1;
            int area = height * width;
            maxArea = Math.max(area, maxArea);
        }
        System.out.print("Maximum Area in Histogram : " + maxArea);
    }

    public static void main(String[] args) {
        int[] height = { 2, 1, 5, 6, 2, 3 };
        findMaxArea(height);
    }
}