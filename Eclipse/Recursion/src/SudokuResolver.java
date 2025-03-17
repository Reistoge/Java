import java.util.Scanner;

//sudoku solver


public class SudokuResolver {
	private static final int grid_size=9;
	static int n=0;
	static Scanner scan;
	public static void main(String[] args) {
		scan=new Scanner(System.in);
		int[][] board= {
				{0, 0, 8, 0, 0, 0, 0, 0, 0},
				{1, 0, 0, 0, 8, 5, 0, 2, 0},
				{0, 0, 0, 1, 6, 4, 9, 0, 0},
				{6, 9, 5, 0, 4, 0, 0, 3, 2},
				{4, 0, 0, 3, 2, 0, 0, 0, 7},
				{3, 0, 0, 6, 0, 8, 0, 1, 0},
				{2, 0, 0, 0, 7, 3, 5, 0, 1},
				{8, 0, 0, 0, 9, 0, 0, 0, 6},
				{7, 0, 4, 0, 0, 6, 2, 0, 3}



				
		};
		PrintBoard(board);
		System.out.println();
		if(solveBoard(board)) {
			
			PrintBoard(board);
			System.out.println(n);
		}
		

	}
	public static void PrintBoard(int[][] board) {
		
		for(int i=0;i<grid_size;i++) {
			for(int j=0;j<grid_size;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	public static boolean isNumberInRow(int[][] board, int number, int row) {
		for (int i = 0; i < grid_size; i++) {
			if (board[row][i] == number) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNumberInCol(int[][] board, int number, int col) {
		for (int i = 0; i < grid_size; i++) {
			if (board[i][col] == number) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	public static boolean isNumberInBox(int[][] board,int number,int row,int col) {
		int localBoxRow=row-(row%3);
		int localBoxCol=col-(col%3);
		// we calculate the first 0,0 of very.
		// for some reason the module give us the initial position of every box
		
		for(int i=localBoxRow;i<localBoxRow+3;i++) {
			for(int j=localBoxCol;j<localBoxCol+3;j++) {
				
				if(board[i][j]==number) {
					return true;
					
				}
			}
		}
		return false;
		
	}
	public static boolean isValidPlacement(int [][] board,int number,int row, int col) {
		
		return !isNumberInRow(board, number, row) &&
				!isNumberInCol(board, number, col)&&
				!isNumberInBox(board, number, row, col);
	}

	public static boolean solveBoard(int[][] board ) {
		n++;
		for(int row=0;row<grid_size;row++) {
			for(int col=0;col<grid_size;col++) {
				 
				// for each number in grid
				
				if(board[row][col]==0) {
					//if the space is in blank
					
		 			for(int numberToTry=1;numberToTry<=grid_size;numberToTry++) {
						//try with numbers from 1 to 9 
						if(isValidPlacement(board, numberToTry, row, col)) {
							// if the number to try is valid in that cell assign to that pos and pass to the other case
							board[row][col]=numberToTry;
							// stack frame the row and col of this stack is store in the stack so when it has to backtrack 
							// it assign the row col =0 
							if(solveBoard(board)) {return true;}
							
						else {board[row][col]=0;}
						
					}
				}
					return false;
			}
		}
		}
	return true;
		
	}
		 
}
	
	
