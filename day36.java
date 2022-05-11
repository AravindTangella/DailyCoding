problem 1: Sudoku is a puzzle where you're given a partially-filled 9 by 9 grid with digits. The objective is to fill the grid with the constraint that every row, column, and box (3 by 3 subgrid) must 		contain all of the digits from 1 to 9.

		Implement an efficient sudoku solver.
		
Solution 1: 
		class Solution {
		    public void solveSudoku(char[][] board) {
			int[][] grid = new int[9][9];
			
			for(int i = 0; i < 9; i++) {
			    for(int j = 0; j < 9; j++) { 
				if(board[i][j] != '.')
				    grid[i][j] = board[i][j] - 48;
			    }
			}
			
			solveSudoku(grid, 0, 0, board);
			
			for(int x = 0; x < 9; x++) {
			    for(int y = 0; y < 9; y++) 
				System.out.print(board[x][y]+" ");
			    System.out.println();
			}
		    }
		    
		    public void solveSudoku(int[][] grid, int i, int j, char[][] board) {
			if(i == 9) {
			    for(int x = 0; x < 9; x++) {
				for(int y = 0; y < 9; y++) 
				    board[x][y] = (char)(grid[x][y]+'0');
			    }
			    return;
			}
			
			int ni = 0;
			int nj = 0;
			
			if(j == 8) {
			    ni = i+1;
			    nj = 0;
			}
			else {
			    ni = i;
			    nj = j + 1;
			}
			
			if(grid[i][j] != 0) 
			    solveSudoku(grid, ni, nj, board);
			else {
			    for(int pos = 1; pos <=9; pos++) {
				if(isValid(grid, i, j, pos)) {
				    grid[i][j] = pos;
				    solveSudoku(grid, ni, nj, board);
				    grid[i][j] = 0;
				}
			    }
			}
		    }
		    
		    public boolean isValid(int[][] grid, int i, int j, int val) {
			for(int x = 0; x < 9; x++) {
			    if(grid[x][j] == val)
				return false;
			}
			
			for(int y = 0; y < 9; y++) {
			    if(grid[i][y] == val)
				return false;
			}
			
			int smi = i/3*3;
			int smj = j/3*3;
			for(int x = 0; x < 3; x++) {
			    for(int y = 0; y < 3; y++){
				if(grid[smi+x][smj+y] == val)
				    return false;
			    }
			}
			
			return true;
		    }
		}
