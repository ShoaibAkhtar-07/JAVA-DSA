public class BubbleSort {
    public static void sorting(int arr[]) {
        int swaps = 0;
        boolean flag = false;

        for (int turns = 0; turns < arr.length - 1; turns++) {
            for (int j = 0; j < arr.length - 1 - turns; j++) {
                if (arr[j] > arr[j + 1]) {
                    swaps++;
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (flag = false) {
                break;
            }
        }
        System.out.println("no.of Swaps : " + swaps);
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        sorting(arr);
        printArr(arr);
    }
}
