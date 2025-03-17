
public class Example3 {
//	En la rivera de un río hay 3 caníbales, 3 misioneros y un bote.
//	 Todos quieren cruzar el río en forma segura.
//	 El bote puede trasladar a lo más 2 personas.
//	 En ningún momento pueden haber más caníbales que 
//	misioneros en un lado del río. (Por las consecuencias nefastas 
//	para los misioneros)
	// codigo no funciona...
	// solucion github https://github.com/bidbiri/Solucion-Problema-de-Misioneros-y-canibales/commit/master
	
	// 3300 ----> 0033.
	
	public static void main(String[] args) {
		int[] start = { 3, 3, 0, 0 };
		game(start);

	}

	public static void game(int[] state) {
		 
		printArr(state);
		if (validState(state) && !isFinished(state)) {
			 
			int[] mov1 = { 1, 0 };
			int[] arr1 = move(state, mov1);
			game(arr1);
			 

			int[] mov2 = { 0, 1 };
			int[] arr2 = move(state, mov2);
			game(arr2);
		 
			int[] mov3 = { 1, 1 };
			int[] arr3 = move(state, mov3);
			game(arr3);
			 
			int[] mov4 = { 2, 0 };
			int[] arr4 = move(state, mov4);
			game(arr4);
			 
			int[] mov5 = { 0, 2 };
			int[] arr5 = move(state, mov5);
			game(arr5);
			 
		 
		}
		 
	}

	public static void printArr(int[] arr) {
		String con= "valid";
		if(!validState(arr)) {
			con="not valid";
		}
		for (int c : arr) {
			System.out.print(c + " ");
		}
		System.out.print(" " +con);
		System.out.println();
	}

	public static int[] move(int[] state, int[] move) {

		int[] arr = new int[4];
		arr[0] = state[0] - move[0];
		arr[1] = state[1] - move[1];
		arr[2] = state[2] + move[0];
		arr[3] = state[3] + move[1];

		return arr;

	}

	public static boolean validState(int[] state) {
		if (sumState(state) != 6) {
			return false;

		}
		if(state[0]>state[1] && state[1]>0 || state[2] >state[3] && state[3]>0) {
			return false;
		}
		
		
		return true;

	}

	public static boolean isFinished(int[] state) {
		if (state[2] == 3 && state[3] == 3) {
			 
			return true;
		}
		return false;
	}

	public static int sumState(int[] state) {
		int total = 0;
		for (int n : state) {
			if(n<0) {
				return 0;
			}
			total += n;
		}
		return total;
	}
	
}
