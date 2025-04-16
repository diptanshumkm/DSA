package com.example;

public class SudukoSolver {
    
    public static boolean isValid(int row, int col, char i, char[][] board){
        //Check in row
        int tempRow = row;
        int tempCol = 0;
        while (tempCol<=8) {
            if (board[tempRow][tempCol] == i ) {
                return false;
            }
            tempCol++;
        }

        //Check in col
        int dumCol = col;
        int dumRow = 0;
        while (dumRow<=8) {
            if (board[dumRow][dumCol] == i) {
                return false;
            }
            dumRow++;
        }

        // Check in 3x3 grid
        int startRow = 3 * (row/3);
        int startCol = 3 * (col/3);
        for(int r = startRow; r<startRow+3; r++){
            for(int c = startCol; c < startCol+3; c++){
                if (board[r][c] == i) {
                    return false;
                }
            }
        }

        return true;    
    }

    public static boolean solve(char[][] board){
        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                if (board[row][col] == '.') { //check is empty
                    for(char i='1'; i<='9'; i++){
                        if (isValid(row, col, i, board)) {
                            board[row][col] = i;
                            if(solve(board)){return true;}
                            board[row][col] = '.'; //BackTrack
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void solveSudoku(char[][] board){
        solve(board);
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(); // Print a new line after each row
        }
    }
    

    public static void main(String[] args) {

        char[][] board = {
            { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
            { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
            { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
            { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
            { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
            { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
            { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
            { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
            { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        solveSudoku(board);


        printBoard(board);
        
    }
}
