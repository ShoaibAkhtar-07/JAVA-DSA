public class DivideAndConquer {

    public static int searchInSortedRotatedArr(int arr[], int start, int end, int target) {

        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return mid;
        }
        if (arr[start] <= arr[mid]) {
            if (arr[start] <= target && target <= arr[mid]) {
                return searchInSortedRotatedArr(arr, start, mid - 1, target);
            } else {
                return searchInSortedRotatedArr(arr, mid + 1, end, target);
            }
        } else {
            if (target >= arr[mid] && target <= arr[end]) {
                return searchInSortedRotatedArr(arr, mid + 1, end, target);
            } else {
                return searchInSortedRotatedArr(arr, start, mid - 1, target);
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int start = 0;
        int end = arr.length - 1;
        int target = 2;
        System.out.println(searchInSortedRotatedArr(arr, start, end, target));
    }
}
