package Recursion;

public class TheTowerOfHanoi {

    public static void solve(int n, char src, char help, char dest) {
        if (n == 1) {
            System.out.println("move disk 1 from " + src + " to " + dest);
            return;
        }

        solve(n - 1, src, dest, help);
        System.out.println("move disk " + n + " from " + src + " to " + dest);
        solve(n - 1, help, src, dest);

    }

    public static void main(String[] args) {
        int n = 3;
        solve(n, 'A', 'B', 'C');

    }
}
