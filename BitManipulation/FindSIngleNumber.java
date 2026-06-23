package BitManipulation;

public class FindSIngleNumber {
    public static int singleNumber(int arr[]) {
        int x = 0;

        for (int i = 0; i < arr.length; i++) {
            x = x ^ arr[i];
        }
        return x;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 4, 3, 1, 1 };
        System.out.print(singleNumber(arr));
    }
}
