package BitManipulation;

public class EvenOrOdd {

    public static void evenROdd(int n) {
        int bitMask = 1;
        if ((bitMask & n) == 0) {
            System.out.print("even number");
        } else {
            System.out.print("Odd number");
        }
    }

    public static void main(String[] args) {
        int n = 1111;
        evenROdd(n);
    }
}
