import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m1=new int [3][3];
		int[][] m2=new int [3][3];
		FillMatrix(m1);
		m2=SortMatrix(m1);
		DisplayMatrix(m2);
		
		
		 
		 
	}
	public static int[][] FillMatrix(int [][] m){
		Scanner scan = new Scanner(System.in);
		for(int i =0;i<m.length;i++) {
			for(int j=0;j<m.length;j++) {
				
				m[i][j]=scan.nextInt();
				DisplayMatrix(m);
			}
		}
		scan.close();
		return m;
	}
	public static void DisplayMatrix(int[][] m) {
		System.out.println();
		for(int i =0;i<m.length;i++) {
			for(int j=0;j<m.length;j++) {
				System.out.print(m[i][j]);
			}
			System.out.println();
			
		}
		System.out.println();
	}
	public static int[][] SortMatrix(int[][] m){
		int sum[]=new int[m.length];
		for(int i =0;i<m.length;i++) {
			for(int j=0;j<m.length;j++) {
				 sum[i]+=m[i][j];
				
			}
		}
		for(int i =0;i<m.length;i++) {
			for(int j=0;j<m.length;j++) {
				 if(sum[i]>sum[j]) {
					 int temp=sum[i];
					 int[] tempRow=m[i];
					 
					 sum[i]=sum[j];
					 m[i]=m[j];
					 
					 m[j]=tempRow;
					 sum[j]=temp;
					 
				 }
				 else  {
					 int temp=sum[j];
					 int[] tempRow=m[j];
					 
					 sum[j]=sum[i];
					 m[j]=m[i];
					 
					 m[i]=tempRow;
					 sum[i]=temp;
				 }
				
			}
		}
		return m;
		
	}

}

