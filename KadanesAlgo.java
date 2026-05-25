import java.util.*;

public class KadanesAlgo {
    public static void kadanes(int numbers[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            largest = Math.max(largest, numbers[i]);

            currSum = currSum + numbers[i];

            if (currSum < 0) {
                currSum = 0;
            }
            maxSum = Math.max(currSum, maxSum);
        }
        if (maxSum == 0) {
            maxSum = largest;
        }
        System.out.println("max sub array sum : " + maxSum);
    }

    public static void main(String[] args) {
        int numbers[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        kadanes(numbers);
    }
}
