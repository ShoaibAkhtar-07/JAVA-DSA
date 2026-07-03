package BackTracking;

public class RatInAMazePrintAllWays {

    public static void solve(int maze[][], int row, int col, int path[][]) {
        if (row == maze.length || col == maze[0].length) {
            return;
        }

        if (maze[row][col] == 0) {
            return;
        }

        path[row][col] = 1;

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            print(path);
            System.out.println();
            path[row][col] = 0;
            return;
        }

        solve(maze, row, col + 1, path);

        solve(maze, row + 1, col, path);

        path[row][col] = 0;
    }

    public static void main(String[] args) {
        int maze[][] = { { 1, 1, 1, 1 },
                { 0, 1, 0, 1 },
                { 1, 1, 1, 1 },
                { 1, 0, 1, 1 } };

        int[][] path = new int[maze.length][maze[0].length];
        solve(maze, 0, 0, path);

    }

    public static void print(int path[][]) {
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[0].length; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
    }
}
