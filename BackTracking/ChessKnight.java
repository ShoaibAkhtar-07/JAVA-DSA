package BackTracking;

public class ChessKnight {
    static int n = 5;
    static int[] dx = { -2, -2, 2, 2, -1, -1, 1, 1 };
    static int[] dy = { -1, 1, -1, 1, -2, 2, -2, 2 };

    public static void print(int board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean solve(int row, int col, int move, int board[][]) {

        if (move == n * n) {
            return true;
        }

        for (int k = 0; k < 8; k++) {
            int nx = row + dx[k];
            int ny = col + dy[k];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == -1) {
                board[nx][ny] = move;
                if (solve(nx, ny, move + 1, board) == true) {
                    return true;
                }

                board[nx][ny] = -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int board[][] = new int[n][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = -1;
            }
        }
        board[0][0] = 0;
        if (solve(0, 0, 1, board) == false) {
            System.out.print("--Not Possible--");
        } else {
            print(board);
        }

    }
}
