package ParallelSudoku;

import java.util.Scanner;

//sudoku solver

public class SudokuSolverForward extends SudokuSolver{

 
	public SudokuSolverForward(int[][] sudoku, String name) {
		super(sudoku, name);
		// TODO Auto-generated constructor stub
	}
	 

	public   void PrintBoard() {

		for (int i = 0; i < grid_size; i++) {
			for (int j = 0; j < grid_size; j++) {
				System.out.print(this.Sudoku[i][j] + " ");
			}
			System.out.println();
		}

	}

	public   boolean isNumberInRow(int[][] board, int number, int row) {
		for (int i = 0; i < grid_size; i++) {
			if (board[row][i] == number) {
				return true;
			}
		}
		return false;
	}

	public   boolean isNumberInCol(int[][] board, int number, int col) {
		for (int i = 0; i < grid_size; i++) {
			if (board[i][col] == number) {
				return true;
			}
		}
		return false;
	}

	public   boolean isNumberInBox(int[][] board, int number, int row, int col) {
		int localBoxRow = row - (row % 3);
		int localBoxCol = col - (col % 6);
		// we calculate the first 0,0 of very.
		// for some reason the module give us the initial position of every box

		// en el caso de que sea un soduko de 9x9 deberias de hacer modulo 3 a las columnas.
		// y tambien sumarle 3 en vez de 6 en las localBoxCol.
		// es solamente para el calculo de subBloques.
		for (int i = localBoxRow; i < localBoxRow + 3; i++) {
			for (int j = localBoxCol; j < localBoxCol + 6; j++) {

				if (board[i][j] == number) {
					return true;

				}
			}
		}
		return false;

	}

	public   boolean isValidPlacement(int[][] board, int number, int row, int col) {

		return !isNumberInRow(board, number, row) && !isNumberInCol(board, number, col)
				&& !isNumberInBox(board, number, row, col);
	}

	// dos thread empezaran en esquinas o tambien puede que dos threads empiecen en
	// dos
	public   boolean solveBoard( ) {
		n++;
		
		for (int row = 0; row < grid_size; row++) {
			for (int col = 0; col < grid_size; col++) {

				// for each number in grid

				if (this.Sudoku[row][col] == 0) {
					// if the space is in blank

					for (int numberToTry = 1; numberToTry <= grid_size; numberToTry++) {
						// try with numbers from 1 to 9
						// thread.
						if (isValidPlacement(this.Sudoku, numberToTry, row, col)) {
							// if the number to try is valid in that cell assign to that pos and pass to the
							// other case
							this.Sudoku[row][col] = numberToTry;
							// stack frame the row and col of this stack is store in the stack so when it
							// has to backtrack
							// it assign the row col =0
							if (solveBoard( )) {
								return true;
							}

							else {
								this.Sudoku[row][col] = 0;
							}

						}
					}
					return false;
				}
			}
		}
		return true;

	}

	@Override
	public void run() {
		double start = System.currentTimeMillis() / 1000;
		if (solveBoard( )) {
			timeTaken=(System.currentTimeMillis() / 1000) - start;
			PrintBoard();
			System.out.println(this.name+" finished");
			System.out.println("time taken: "+timeTaken);
			System.out.println("iterations: "+n);
			System.err.println();
		} else {
			System.out.println("unsolveable");
		}
		
		
	}

}
