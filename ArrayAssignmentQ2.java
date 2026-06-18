public class ArrayAssignmentQ2 {

    public static int searchInRotatedSortedArr(int numbers[], int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high) {
            int mid = high + low / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[low] <= numbers[mid]) {
                if (numbers[low] <= target && target < numbers[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (numbers[mid] < target && target <= numbers[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int numbers[] = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.print(searchInRotatedSortedArr(numbers, 0));
    }
}
