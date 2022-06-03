package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        char[][] gameBoard = createEmptyBoard();
        printBoard(gameBoard);
        playGame(gameBoard);
    }

    static char[][] createEmptyBoard() {
        final int gridRows = 3;
        final int gridCols = 3;
        char[][] gameBoard = new char[gridRows][gridCols];
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = ' ';
            }
        }
        return gameBoard;
    }

    static void printBoard(char[][] grid) {
        System.out.println("---------");
        for (int i = 0; i < grid.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    static boolean analyzeBoard(char[][] grid) {
        int emptyCounter = 0;
        boolean x_Wins = false;
        boolean o_Wins = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ' ') {
                    emptyCounter++;
                }
            }
        }
        // row results
        // row 1
        if (grid[0][0] == 'X' && grid[0][1] == 'X' && grid[0][2] == 'X') {
            x_Wins = true;
        }
        if (grid[0][0] == 'O' && grid[0][1] == 'O' && grid[0][2] == 'O') {
            o_Wins = true;
        }
        // row 2
        if (grid[1][0] == 'X' && grid[1][1] == 'X' && grid[1][2] == 'X') {
            x_Wins = true;
        }
        if (grid[1][0] == 'O' && grid[1][1] == 'O' && grid[1][2] == 'O') {
            o_Wins = true;
        }
        // row 3
        if (grid[2][0] == 'X' && grid[2][1] == 'X' && grid[2][2] == 'X') {
            x_Wins = true;
        }
        if (grid[2][0] == 'O' && grid[2][1] == 'O' && grid[2][2] == 'O') {
            o_Wins = true;
        }
        // column results
        // column 1
        if (grid[0][0] == 'X' && grid[1][0] == 'X' && grid[2][0] == 'X') {
            x_Wins = true;
        }
        if (grid[0][0] == 'O' && grid[1][0] == 'O' && grid[2][0] == 'O') {
            o_Wins = true;
        }
        // column 2
        if (grid[0][1] == 'X' && grid[1][1] == 'X' && grid[2][1] == 'X') {
            x_Wins = true;
        }
        if (grid[0][1] == 'O' && grid[1][1] == 'O' && grid[2][1] == 'O') {
            o_Wins = true;
        }
        // column 3
        if (grid[0][2] == 'X' && grid[1][2] == 'X' && grid[2][2] == 'X') {
            x_Wins = true;
        }
        if (grid[0][2] == 'O' && grid[1][2] == 'O' && grid[2][2] == 'O') {
            o_Wins = true;
        }
        // Diagonal results
        if (grid[0][0] == 'X' && grid[1][1] == 'X' && grid[2][2] == 'X') {
            x_Wins = true;
        }
        if (grid[0][0] == 'O' && grid[1][1] == 'O' && grid[2][2] == 'O') {
            o_Wins = true;
        }
        if (grid[0][2] == 'X' && grid[1][1] == 'X' && grid[2][0] == 'X') {
            x_Wins = true;
        }
        if (grid[0][2] == 'O' && grid[1][1] == 'O' && grid[2][0] == 'O') {
            o_Wins = true;
        }
        // Print board status
        if (!x_Wins && !o_Wins && emptyCounter == 0) {
            System.out.println("Draw");
            return true;
        }
        if (x_Wins && !o_Wins) {
            System.out.println("X wins");
            return true;
        }
        if (!x_Wins && o_Wins) {
            System.out.println("O wins");
            return true;
        }
        return false; // continue playing
        }


    static void playGame(char[][] gameBoard) {
        Scanner scanner = new Scanner(System.in);
        boolean correctInput = false;
        final int maxInput = 3;
        final int minInput = 1;
        int row = 0;
        int column = 0;
        char playerTurn = 'X';
        boolean gameFinished = false;
        while (!gameFinished) {
            correctInput = false;
            while (!correctInput) {
                System.out.print("Enter the coordinates : ");
                String input = scanner.nextLine().trim().replace(" ", "");
                if (Character.isDigit(input.charAt(0)) && Character.isDigit(input.charAt(1))) {
                    row = Character.getNumericValue(input.charAt(0));
                    column = Character.getNumericValue(input.charAt(1));
                } else {
                    System.out.println("You should enter numbers!");
                    continue;
                }
                if (row > maxInput || row < minInput || column > maxInput || column < minInput) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (gameBoard[row - 1][column - 1] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                } else {
                    correctInput = true;
                }
            }
            if (playerTurn == 'X') {
                gameBoard[row - 1][column - 1] = 'X';
                playerTurn = 'O';
            } else {
                gameBoard[row - 1][column - 1] = 'O';
                playerTurn = 'X';
            }
            printBoard(gameBoard);
            gameFinished = analyzeBoard(gameBoard);
        }
    }
}
