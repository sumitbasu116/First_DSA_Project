package co.sumit.striversrecursion;

import java.util.ArrayList;
import java.util.List;

public class PrintOnlyOneSubSequenceOfSumRecursion {

	public static void main(String[] args) {
		int[] arr = {3,1,2,7,4};
		int k=7;
		solve(arr,k);

	}

	private static void solve(int[] arr, int k) {
		List<Integer> list = new ArrayList<>();
		
		f(arr,arr.length,0,0,k,list);
		
	}

	private static boolean f(int[] arr,int n, int i,int sum, int k, List<Integer> list) {
		
		if(i==n) {
			if(sum==k) {
				list.stream().forEach(e->System.out.print(e+" "));
				System.out.println();
				return true;
			}
			return false;
		}
		
		list.add(arr[i]);
		sum=sum+arr[i];
		if(f(arr,n,i+1,sum,k,list)) {
			return true;
		}
		
		list.remove(list.size()-1);
		
		sum=sum-arr[i];
		if(f(arr,n,i+1,sum,k,list)) {
			return true;
		}
		return false;
	}

}
