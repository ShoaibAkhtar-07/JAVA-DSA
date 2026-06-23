package Recursion;

public class FindOccurance {

    public static void findOcc(int arr[], int key, int i) {
        if (i == arr.length) {
            return;
        }
        if (arr[i] == key) {
            System.out.print(i + " ");
        }
        findOcc(arr, key, i + 1);
    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 3, 1, 7, 8, 3, 1, 2, 6, 2 };
        findOcc(arr, 2, 0);
    }

}