package BackTracking;

public class GridWays {

    public static int no_ofGridWays(int i, int j, int n, int m) {

        if (i == n - 1 && j == m - 1) {
            return 1;
        } else if (i == n || j == m) {
            return 0;
        }

        int w1 = no_ofGridWays(i, j + 1, n, m);
        int w2 = no_ofGridWays(i + 1, j, n, m);
        return w1 + w2;

    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        System.out.println(no_ofGridWays(0, 0, n, m));
    }
}