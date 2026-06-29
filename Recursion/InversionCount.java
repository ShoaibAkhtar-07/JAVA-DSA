package Recursion;

public class InversionCount {

    public static int mergeSort(int arr[], int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;

            int invCount = mergeSort(arr, start, mid);
            invCount += mergeSort(arr, mid + 1, end);

            invCount += merge(arr, start, mid, end);

            return invCount;
        }
        return 0;
    }

    public static int merge(int arr[], int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        int invCount = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                invCount += (mid - i + 1);
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = start; k < temp.length; i++, k++) {
            arr[i] = temp[k];
        }

        return invCount;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 1, 3, 5 };
        int start = 0;
        int end = arr.length - 1;
        System.out.print(mergeSort(arr, start, end));
    }
}
