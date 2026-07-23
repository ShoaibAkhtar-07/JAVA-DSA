package Queue;

public class LeetCode2073 {
    public static int findingTime(int arr[], int k) {
        int time = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i <= k) {
                time += Math.min(arr[i], arr[k]);
            }
            if (i > k) {
                time += Math.min(arr[i], arr[k] - 1);
            }
        }
        return time;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 2 };
        System.out.println(findingTime(arr, 2));
    }
}
