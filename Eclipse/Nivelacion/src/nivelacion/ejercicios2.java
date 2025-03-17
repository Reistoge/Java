package nivelacion;

import java.util.Scanner;

public class ejercicios2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ejercicio 14,15,16
		while(true) {
			Scanner scan=new Scanner(System.in);
			int asd=5/2;
			System.out.print("size: "+(asd));
			int n=scan.nextInt();
			boolean notFound=false;
			int[] numbers=new int[n];
			
			for(int i=0;i<n;i++) {
				System.out.print("number "+(i+1)+": ");
				numbers[i]=scan.nextInt();
			}
			
			numbers=bubbleSort(numbers);
			System.out.println("what number are you searching for ?: ");
			int number=scan.nextInt();
			System.out.println(binarySearch(numbers,number));
			
			 
			 
			System.out.println("the highest number is "+ numbers[numbers.length-1]);
			
			 
			
//			for (int number : numbers) {
//				if(number==q) {
//					System.out.println("eureka !!");
//					notFound=true;
//					break;
//				}
//			}
//			if(notFound==false) {
//				System.out.println("mission failed.");
//				
//			}
		}
	}
	 
			
 
		
 
	
	static int[] swap(int[] arr1,int i, int j) {
		int aux=arr1[i];
		arr1[i]=arr1[j];
		arr1[j]=aux;
		return arr1;
		
	}
	 static int[] bubbleSort(int[] arr1) {
		 for(int i=0;i<arr1.length;i++) {
			 for(int j=i+1;j<arr1.length;j++) {
				 if(arr1[i]>arr1[j]) {
					 arr1=swap(arr1,i,j);
				 }
			 }
		 }
		 return arr1;
	 }
	 static boolean binarySearch(int[] arr,int q ) {
		 int i=0;
		 int j=arr.length-1;
		 int k=0;
		 while(i<=j) {
			 k=(i+j)/2;
			 if(arr[k]>q) {
				 j=k-1;
			 }
			 else if(arr[k]<q) {
				 i=k+1;
			 }
			 else {
				 System.out.println("found!");
				 return true;
			 }
			 
		 }
		 System.out.println("not found :c");
		 return false;
		 
	 }

}
