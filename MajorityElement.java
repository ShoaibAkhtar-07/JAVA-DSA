public class MajorityElement {

    public static int majority(int arr[]) {
        int count = 0;
        int candidate = -1;
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                candidate = arr[i];
            }
            if (candidate == arr[i]) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;

    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3 };
        System.out.println(majority(nums));
    }
}
