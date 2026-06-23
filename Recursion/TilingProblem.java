package Recursion;

public class TilingProblem {
    public static int tailing(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int verticalTiles = tailing(n - 1);
        int horizontalTiles = tailing(n - 2);

        int totalTiles = verticalTiles + horizontalTiles;
        return totalTiles;
    }

    public static void main(String[] args) {

        System.out.print(tailing(4));
    }
}
