package co.sumit.striversrecursion;

public class StringPalindromeRecursion {

	public static void main(String[] args) {
		
		String str = "MADAMA";
		
		boolean res=solve(str);
		
		System.out.println(res);
	}

	private static boolean solve(String str) {
		
		char[] arr =str.toCharArray();
		return f(arr,0,str.length()-1);
	}

	private static boolean f(char[] arr, int l, int r) {
		
		if(l>=r) {
			return true;
		}
		else if(arr[l]!=arr[r]) {
			return false;
		}
		return f(arr,l+1,r-1);
	}

}
