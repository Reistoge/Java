package nivelacion;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("helloWorld");
		int[][] lista=new int[10][15];
		print(bubbleSort(lista));
		
		
		
	}
	public static void print(int string) {
		
		System.out.println(string);
		
	}	
 
	
//	int[][] arr, int[] arr[], and int arr[][] are all equivalent in Java. They are all two-dimensional arrays of integers.
	public static int bubbleSort(int vector[]) {
		return vector.length;
	}
	public static int bubbleSort(int vector[][]) {
		return vector.length;
	}
	

}