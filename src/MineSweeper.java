import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    public static void main(String[] args) {
        int[][] board = new int[10][10];
        int[][] displayBoard = new int[10][10];
        int mines = 0;
        int score = 0;
        boolean gameOver = false;


        int mineThreshold = 6;
        Random random = new Random();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (random.nextInt(10) > mineThreshold) {
                    board[i][j] = -1;
                    mines++;
                }
            }
        }


        Scanner scanner = new Scanner(System.in);
        while (!gameOver) {

            System.out.println("Score: " + score);
            System.out.println("Mines: " + mines);
            for (int i = 0; i < displayBoard.length; i++) {
                for (int j = 0; j < displayBoard[i].length; j++) {
                    if (displayBoard[i][j] == 0) {
                        System.out.print("# ");
                    } else if (displayBoard[i][j] == 1) {
                        System.out.print(board[i][j] + " ");
                    } else if (displayBoard[i][j] == 2) {
                        System.out.print("F ");
                    }
                }
                System.out.println();
            }


            System.out.print("Enter row and column (e.g. 3 4): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();


            if (displayBoard[row][col] == 0) {
                if (board[row][col] == -1) {
                    System.out.println("Game over!");
                    gameOver = true;
                } else {
                    displayBoard[row][col] = 1;
                    score++;
                }
            } else if (displayBoard[row][col] == 1) {
                System.out.println("Already opened!");
            } else if (displayBoard[row][col] == 2) {
                displayBoard[row][col] = 0;
                mines++;
            } else {
                displayBoard[row][col] = 2;
                mines--;
            }


            if (score == (board.length * board[0].length) - mines) {
                System.out.println("Congratulations, you won!");
                gameOver = true;
            }
        }
    }
}
