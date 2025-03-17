import java.sql.Time;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacci(50));
		
		System.out.println();
	}

	public static long fibonacci(long n) {
		if(n==0) {
			return 0;
		}
		else if (n==1|| n==2) {
			return 1;
		}
		else {
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}
}
