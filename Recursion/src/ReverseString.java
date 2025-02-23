import java.util.*;
import java.util.random.RandomGenerator;
public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// given a string of length n reverse it with recursion :0 !
		
		String B=BuildString(500);
		System.out.println(B);
		 
		String A="sdfsdasdwerert";
		String C="asd";
		System.out.println(DetectString(A, C, 0));
		//System.out.println(equals("asd", "asd",2));
		 
	}
//	public static void reverse(int n,String s) {
//		
//		if(n<0) {
//			return;
//		}
//		System.out.print(s.charAt(n));
//		reverse(n-1, s);
//		
//	}
	
	
	public static boolean DetectString(String S, String Inside,int n) {
		if(n==S.length()) {
			return false;
		}
		if(S.charAt(n)==Inside.charAt(0)) {
			String temp= CortarString(S, n);
			if(equals(temp, Inside, Inside.length()-1)){
				return true;
			}
			
			
		}
		DetectString(S, Inside, n+1);
		 
		 
		// if the string equals the searched it ends
		
			
			
		 
		// check if the char are equals, if it equals pass to the next if not stop it and pass to the next case
		 
		return true;
		
		
		
	}
	
	public static boolean equals(String original, String compare,int originalLength) {
		 if(originalLength<0) {
			 return true;
		 }
		 if(original.charAt(originalLength)==compare.charAt(originalLength)) {
			return  equals(original, compare, originalLength-1);
			 
		 }
		 else {
			 return false;
		 }
		
		
	}
	public static String BuildString(int limit) {
		String r="hola";
		int randomI= (int) Math.round(Math.random()*(r.length()-1));		
		if(limit==0) {
			return "";
		}
		return r.charAt(randomI)+BuildString(limit-1);//---> work
		//return r.charAt(randomI)+BuildString(--limit); //---->work 
		//return r.charAt(randomI)+BuildString(limit-1); ----> doesnt work
	}
	public static String reverse(String str){
		 if (str == null || str.length() <= 1) {
			 return str;
		 }
		 return reverse(CortarString(str, 1)) + str.charAt(0);
	}
	
	
	public static String CortarString(String s, int index) {
		if(index<=s.length()-1) {
			 
			
			// case("auto", 1)
				// 1<=3 "u" + case("auto",2)
				// 2<=3 "t"+ case("auto",3)
				// 3<=3 "o" + case("auto",4)
				// +""
			return s.charAt(index)+CortarString(s, index+1);
		}
		else {
			return "";
		}
		 
 
		
	}
//	public static String CortarString2(String s, int index) {
//		String c="";
//		 for(int i=index;i<=s.length()-1;i++) {
//			 c+=s.charAt(i);
//			 
//		 }
//		 return c;
// 
//		
//	}
	// for with recursion
	 
	

	 
	 


}
