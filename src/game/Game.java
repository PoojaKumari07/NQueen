package game;

import board.Board;

public class Game {

    Board qb;

    public Game(Board qb) {
        this.qb = qb;

    }

    public void play() {
        if (qb.size < 4) {
            System.out.println("No configutration possible");
            return;

        }
        nqueen_helper(qb.matrix, 0);

    }

    private void nqueen_helper(char matrix[][], int row) {
        if (row == matrix.length) {
            printBoard(matrix);
            return;
        }

        for (int col = 0; col < matrix.length; col++) {
            if (isSafeQueen(matrix, row, col) == true) {
                matrix[row][col] = 'Q';
                nqueen_helper(matrix, row + 1);
                matrix[row][col] = '-';
            }
        }
    }

    private boolean isSafeQueen(char matrix[][], int row, int col) {
        for (int i = row - 1, j = col - 1; j >= 0 && i >= 0; i--, j--) {

            if (matrix[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; j < matrix.length && i >= 0; i--, j++) {
            if (matrix[i][j] == 'Q') {
                return false;
            }

        }

        for (int i = row - 1; i >= 0; i--) {
            if (matrix[i][col] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public void printBoard(char matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
