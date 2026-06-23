package BitManipulation;

public class ClearLastIthBit {

    public static int clearIBits(int n, int i) {
        int bitMask = -1 << i;
        return n & bitMask;
    }

    public static void main(String[] args) {
        System.out.print(clearIBits(15, 2));
    }
}
