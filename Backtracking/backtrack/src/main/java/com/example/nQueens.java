package com.example;

import java.util.ArrayList;
import java.util.List;

public class nQueens {



    public static boolean isSafe(int row, int coloum, char[][] board, int n){
        
        int drow = row;
        int dcol = coloum;

        // For upper diagnol
        while (drow >= 0 && dcol >= 0) {
            if (board[drow][dcol] == 'Q') {return false;}
            drow--;
            dcol--;
        }
        
        int duprow = row;
        int dupcol = coloum;
        // for same row
        while (dupcol >= 0) {
            if (board[duprow][dupcol] == 'Q') {return false;}
            dupcol--;
        }

        int lowerDiagRow = row;
        int lowerDiagCol = coloum;
        
        while (lowerDiagRow<n && lowerDiagCol>=0 ) {
            if (board[lowerDiagRow][lowerDiagCol] == 'Q') {return false;}
            lowerDiagRow++;
            lowerDiagCol--;
        }

        return true;
    }

    public static List<String> boardToList(char[][] board){
        List<String> res = new ArrayList<>();

        for(char[] row: board){
            res.add(new String(row));
        }

        return res;
    }

    public static void fillBoard(int coloum, char[][] board, List<List<String>> answer, int n){
        if (coloum == n) {
            answer.add(boardToList(board));
            return;
        }

        for(int row = 0; row<n; row++){
            if (isSafe(row, coloum, board, n) == true) {
                board[row][coloum] = 'Q';
                fillBoard(coloum+1, board, answer, n);
                board[row][coloum] = '.';
            }
        }


    }


    public static List<List<String>> solveNQueens(int n){

        List<List<String>> answer = new ArrayList<>();

        char[][] board = new char[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }

        fillBoard(0, board, answer, n);

        return answer;
    }

    


    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

}

