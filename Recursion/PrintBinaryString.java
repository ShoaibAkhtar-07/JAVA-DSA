package Recursion;

public class PrintBinaryString {

    public static void stringWithoutConsecutiveOnes(int n, int lastPlace, String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }

        if (lastPlace == 0) {
            stringWithoutConsecutiveOnes(n - 1, 0, str + "0");
            stringWithoutConsecutiveOnes(n -1, 1, str + "1");
        }else{
            stringWithoutConsecutiveOnes(n - 1, 0, str + "0");
        }
    }

    public static void main(String[] args) {
        stringWithoutConsecutiveOnes(3, 0, "");

    }
}
