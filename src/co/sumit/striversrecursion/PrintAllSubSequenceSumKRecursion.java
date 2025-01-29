package co.sumit.striversrecursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubSequenceSumKRecursion {
	public static void main(String[] args) {
		int[] arr = {3,1,2,7};
		int k=7;
		solve(arr,k);

	}

	private static void solve(int[] arr, int k) {
		List<Integer> list=new ArrayList<>();
		f(arr,0,k,list,0);
		
	}

	private static void f(int[] arr, int i, int k, List<Integer> list,int sum) {
		
		if(i==arr.length) {
			if(sum==k) {
				list.stream().forEach(e->System.out.print(e+" "));
				System.out.println();
			}
			return;
		}
		list.add(arr[i]);
		sum=sum+arr[i];
		f(arr,i+1,k,list,sum);
		
		list.remove(list.size()-1);
		sum=sum-arr[i];
		f(arr,i+1,k,list,sum);
	}

}
