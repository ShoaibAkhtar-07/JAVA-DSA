package Recursion;

public class LastOccurance {

    public static int lastOccOfElem(int arr[], int key, int i) {

        if (i == arr.length) {
            return -1;
        }

        int isFound = lastOccOfElem(arr, key, i + 1);

        if (isFound == -1 && arr[i] == key) {
            return i;
        } 
        return isFound;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 5, 4, 6, 8, 9, 0, 1, 7,7 };
        System.out.print(lastOccOfElem(arr, 5, 0));
    }
}