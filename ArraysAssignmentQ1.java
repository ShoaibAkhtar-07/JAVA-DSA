public class ArraysAssignmentQ1 {

    public static boolean containsDuplicate(int numbers[]) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /*
         * Question 1:- Given an integer array nums, return true if any value appears at
         * least twice
         * in the array, and return false if every element is distinct
         */
        int numbers[] = { 1, 2, 3, 4};
        System.out.println(containsDuplicate(numbers));

    }
}
