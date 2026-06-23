package BitManipulation;

public class Swaping {

    public static void main(String[] args) {

        // int a = 1;
        // int b = 2;
        // System.out.println("---Before Swaping---");
        // System.out.println("A : " + a + "\nB : " + b);

        // a = a ^ b;
        // b = a ^ b;
        // a = a ^ b;
        // System.out.println("---After Swaping---");
        // System.out.println("A : " + a + "\nB : " + b);

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.println((char)(ch | ' '));
        }
    }
}
