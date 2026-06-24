public class MergeSort {
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void sorting(int arr[], int start, int end) {

        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        sorting(arr, start, mid);
        sorting(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }

    public static void merge(int arr[], int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = start; k < temp.length; i++, k++) {
            arr[i] = temp[k];
        }

        
    }

    public static void main(String[] args) {
        int[] arr = { 6, 3, 9, 5, 2, 8 };
        int start = 0;
        int end = arr.length - 1;
        sorting(arr, start, end);
        printArr(arr);
    }
}
