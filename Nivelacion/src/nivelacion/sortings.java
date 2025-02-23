package nivelacion;

import java.util.Iterator;

public class sortings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr1= {0,1,2,3,5,6};
//		int[] arr2= {12,43,34,98};
//	 
//		arr1=add(arr1,arr2);
//		for(int i:arr1) {
//			System.out.println(i);
//		}
		
//		int for1=0;
//		int for2=0;
//		
//		System.out.println("for 1");
//		for(int i=0;i<5;i++) {
//			for1+=i;
//			System.out.print(for1+" ");
//			 
//			
//		}
//		
//		System.out.println("\n for 2");
//		for(int i=0;i<5;++i) {
//			for2+=i;
//			System.out.print(for2+" ");
//			 
//		}
		
		
		
		
		
	}
	static int[] sort(int[] lista) {
		for(int i=0;i<lista.length;i++) {
			for(int j=i+1;j<lista.length;j++) {
				if(lista[i]>lista[j]) {
					lista=swap(lista,i,j);
				}
			}
		}
		return lista;
	}
	
	static int[] add(int[] lista, int element) {
		int[] newList=new int[lista.length+1];
		for(int i=0;i<lista.length;i++) {
			newList[i]=lista[i];
		}
		newList[lista.length]=element;
		
		return newList;
		
	}
	// what ?? it just add the last item.
	static int[] add(int[] lista, int[] elements) {
//		int[] newList=new int[lista.length+elements.length];
//		for(int i:elements) {
//			newList=add(lista,i);
//		}
//		return newList;
//		
		
		for(int i:elements) {
			lista=add(lista,i);
		}
		return lista;
	}
	static int[] swap(int[] lista,int i,int j) {
		int aux=lista[i];
		lista[i]=lista[j];
		lista[j]=aux;
		return lista;
		
	}

}
