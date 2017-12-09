
/**
 * Write a description of class ChessProblems here.
 *
 * @author  Cipher
 * @version 20171110
 */

import java.util.*;


public class ChessProblems {
    private static final int[][] knightMoves = {
       {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
    };
    
    private static final int[][] WHITE_MOVES = {
        {-1, -1}, {-1, 0}, {-1, 1}
    };
    
    private static final int[][] BLACK_MOVES = {
        {1, -1}, {1, 0}, {1, 1}
    };
    
    
    private static boolean inside(int i, int j, int n) {
        return 0 <= i && i < n && 0 <= j && j < n;
    }
    
    
    public int countSafeSquaresRooks(int n, boolean[][] rooks) {
        int ans = 0;
        boolean[] safeRow = new boolean[n];
        boolean[] safeCol = new boolean[n];
        Arrays.fill(safeRow, true);
        Arrays.fill(safeCol, true);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rooks[i][j]) {
                    safeRow[i] = false;
                    safeCol[j] = false;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (safeRow[i] && safeCol[j]) {
                    ans++;
                }
            }
        }
        
        return ans;
    }
    
    
    public int countKnightMoves(int n, boolean[][] knights) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (knights[i][j]) {
                    for (int[] move : knightMoves) {
                        int r = i + move[0];
                        int c = j + move[1];
                        if (inside(r, c, n) && !knights[r][c]) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
    
    
    public int countPawnMoves(int n, char[][] board) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'w') {
                    for (int[] move: WHITE_MOVES) {
                        int r = i + move[0];
                        int c = j + move[1];
                        char s = move[1] == 0 ? ' ' : 'b';
                        if (inside(r, c, n) && board[r][c] == s) {
                            ans++;
                        }
                    }
                }
                if (board[i][j] == 'b') {
                    for (int[] move: BLACK_MOVES) {
                        int r = i + move[0];
                        int c = j + move[1];
                        char s = move[1] == 0 ? ' ' : 'w';
                        if (inside(r, c, n) && board[r][c] == s) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
    
    
    public int countSafeSquaresQueens(int n, boolean[][] queens) {
        int ans = 0;
        boolean[] safeRow = new boolean[n];
        boolean[] safeCol = new boolean[n];
        boolean[] safeSE = new boolean[2 * n - 1];
        boolean[] safeNE = new boolean[2 * n - 1];
        Arrays.fill(safeRow, true);
        Arrays.fill(safeCol, true);
        Arrays.fill(safeSE, true);
        Arrays.fill(safeNE, true);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (queens[i][j]) {
                    safeRow[i] = false;
                    safeCol[j] = false;
                    safeSE[n - i + j - 1] = false;
                    safeNE[i + j] = false;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (safeRow[i] && safeCol[j] && safeSE[n - i + j - 1] && safeNE[i + j]) {
                    ans++;
                }
            }
        }
        
        return ans;
    }
}
