 

import java.lang.*;

public class ParallelSolutionsSudoku {
//	LEER:
//	PARA EL CAMBIO DE FILAS Y COLUMNAS DEBES CAMBIAR ESTAR COSAS:
//
//		-EL GRID SIZE DE CLASE SUDOKU SOLVER (public static int grid_size ;
//		-MODULO DE LA FUNCION isNumberInBox(int[][] board, int number, int row, int col):
//			- SI ES 9X9 ENTONCES modulo e iterador DEBE ESTAR CON 3 (i e j)
//			- SI ES 18X18 SOLO LAS COLUMNAS DEBEN ESTAR CON MODULO 6 E ITERANDOSE CON +6 EN VEZ DE 3 (solo j).
	
	
	
	public static void main(String[] args) throws InterruptedException {
		// esto genera sudokus nxn con n<=9 k: numeros restantes.
		// sudoko.mat para obtener la matriz
		int N = 9, K = 70;
		// creamos un sudoku 9x9  con 70 numeros restantes.
		RandomSudoku sudoku = new RandomSudoku(N, K);
		// lo rellenamos con los valores random
		sudoku.fillValues();

		
		// aqui hay un sudoku 18x18 de ejemplo.
		int[][] board = {

				// easy for backwards
				{0,1,0,0,0,0,0,0,0,6,0,0,0,0,0,0,0,2},
				{0,2,0,0,0,18,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,5,0,0,0,0,0,0,3,0,0,0,0,0},
				{0,0,0,4,0,0,0,0,0,0,0,0,0,18,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,9,0,0,0,0,0,7,0},
				{0,0,0,17,0,6,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,7,0,0,0,0,0,0,0,3,0,0,0},
				{0,3,0,0,0,0,0,8,0,0,0,0,0,0,0,0,0,9},
				{0,0,0,0,0,0,0,0,9,0,0,0,0,0,0,0,0,0},
				{9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,11,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,16,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{2,0,0,0,0,0,0,0,0,0,0,15,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0},
				{0,0,1,0,0,15,16,17,0,0,0,0,0,0,0,0,0,0},
				{3,8,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,1}

		};
		
		System.out.println("start");
		SudokuSolver.PrintBoard(board);
		
		System.out.println();
		// creamos las estrategias y les entregamos un sudoku.
		SudokuSolver forward = new SudokuSolverForward(board, "forward");
		SudokuSolver backwards = new SudokuSolverBackwards(board, "backwards");
		// inicializamos los threads.
		Thread t1 = new Thread(forward);
		Thread t2 = new Thread(backwards);
		t1.start();
		t2.start();
		// los unimos a nuestra cadena .
		t1.join();
		t2.join();
		// esperamos a que se ejecuten y terminen todos los threads 
		// vemos que thread se demoro más que el otro.
		if (forward.timeTaken > backwards.timeTaken) {
			System.out.println("backwards is faster !!");
		} else {
			System.out.println("forward is faster !!");
		}

	}
}
/* Java program for RandomSudoku generator */

class RandomSudoku {
	int[][] mat;
	int N; // number of columns/rows.
	int SRN; // square root of N
	int K; // No. Of missing digits

	// Constructor
	RandomSudoku(int N, int K) {
		this.N = N;
		this.K = K;

		// Compute square root of N
		Double SRNd = Math.sqrt(N);
		SRN = SRNd.intValue();

		mat = new int[N][N];
	}

	// RandomSudoku Generator
	public void fillValues() {
		// Fill the diagonal of SRN x SRN matrices
		fillDiagonal();

		// Fill remaining blocks
		fillRemaining(0, SRN);

		// Remove Randomly K digits to make game
		removeKDigits();
	}

	// Fill the diagonal SRN number of SRN x SRN matrices
	void fillDiagonal() {

		for (int i = 0; i < N; i = i + SRN)

			// for diagonal box, start coordinates->i==j
			fillBox(i, i);
	}

	// Returns false if given 3 x 3 block contains num.
	boolean unUsedInBox(int rowStart, int colStart, int num) {
		for (int i = 0; i < SRN; i++)
			for (int j = 0; j < SRN; j++)
				if (mat[rowStart + i][colStart + j] == num)
					return false;

		return true;
	}

	// Fill a 3 x 3 matrix.
	void fillBox(int row, int col) {
		int num;
		for (int i = 0; i < SRN; i++) {
			for (int j = 0; j < SRN; j++) {
				do {
					num = randomGenerator(N);
				} while (!unUsedInBox(row, col, num));

				mat[row + i][col + j] = num;
			}
		}
	}

	// Random generator
	int randomGenerator(int num) {
		return (int) Math.floor((Math.random() * num + 1));
	}

	// Check if safe to put in cell
	boolean CheckIfSafe(int i, int j, int num) {
		return (unUsedInRow(i, num) && unUsedInCol(j, num) && unUsedInBox(i - i % SRN, j - j % SRN, num));
	}

	// check in the row for existence
	boolean unUsedInRow(int i, int num) {
		for (int j = 0; j < N; j++)
			if (mat[i][j] == num)
				return false;
		return true;
	}

	// check in the row for existence
	boolean unUsedInCol(int j, int num) {
		for (int i = 0; i < N; i++)
			if (mat[i][j] == num)
				return false;
		return true;
	}

	// A recursive function to fill remaining
	// matrix
	boolean fillRemaining(int i, int j) {
		// System.out.println(i+" "+j);
		if (j >= N && i < N - 1) {
			i = i + 1;
			j = 0;
		}
		if (i >= N && j >= N)
			return true;

		if (i < SRN) {
			if (j < SRN)
				j = SRN;
		} else if (i < N - SRN) {
			if (j == (int) (i / SRN) * SRN)
				j = j + SRN;
		} else {
			if (j == N - SRN) {
				i = i + 1;
				j = 0;
				if (i >= N)
					return true;
			}
		}

		for (int num = 1; num <= N; num++) {
			if (CheckIfSafe(i, j, num)) {
				mat[i][j] = num;
				if (fillRemaining(i, j + 1))
					return true;

				mat[i][j] = 0;
			}
		}
		return false;
	}

	// Remove the K no. of digits to
	// complete game
	public void removeKDigits() {
		int count = K;
		while (count != 0) {
			int cellId = randomGenerator(N * N) - 1;

			// System.out.println(cellId);
			// extract coordinates i and j
			int i = (cellId / N);
			int j = cellId % N;

			// System.out.println(i+" "+j);
			if (mat[i][j] != 0) {
				count--;
				mat[i][j] = 0;
			}
		}
	}

 
}
 
