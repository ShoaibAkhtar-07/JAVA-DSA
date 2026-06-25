public class QuickSort {

    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void sorting(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }

        int pidx = partition(arr, start, end);
        sorting(arr, start, pidx - 1);
        sorting(arr, pidx + 1, end);

    }

    public static int partition(int arr[], int start, int end) {
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

            }
        }
        i++;
        int temp = pivot;
        arr[end] = arr[i];
        arr[i] = temp;

        return i;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 3, 4, 5, 2, 8, 9, 7, 6 };
        int start = 0;
        int end = arr.length - 1;
        sorting(arr, start, end);
        printArr(arr);
    }
}