package BackTracking;

public class RatInAMaze {

    public static boolean solve(int maze[][], int row, int col, int path[][]) {

        if (row == maze.length || col == maze[0].length) {
            return false;
        }

        if (maze[row][col] == 0) {
            return false;
        }

        path[row][col] = 1;

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            return true;
        }

        if (solve(maze, row, col + 1, path)) {
            return true;
        }

        if (solve(maze, row + 1, col, path)) {
            return true;
        }

        path[row][col] = 0;
        return false;
    }

    public static void printMaze(int path[][]) {
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path.length; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        int[][] path = new int[maze.length][maze[0].length];
        solve(maze, 0, 0, path);
        printMaze(path);
    }
}
