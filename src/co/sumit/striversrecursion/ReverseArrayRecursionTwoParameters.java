package co.sumit.striversrecursion;

import java.util.Arrays;

public class ReverseArrayRecursionTwoParameters {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		
		solve(arr);
		
		Arrays.stream(arr).forEach(e->System.out.print(e+" "));

	}

	private static void solve(int[] arr) {
		
		int n = arr.length;
		
		f(arr,0,n-1);
		
	}

	private static void f(int[] arr, int l, int r) {
		
		if(l>=r) {
			return;
		}
		swap(arr,l,r);
		
		f(arr,l+1,r-1);
	}

	private static void swap(int[] arr, int i, int n) {
		int temp = arr[i];
		arr[i]=arr[n];
		arr[n]=temp;
	}

}
