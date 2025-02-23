package co.sumit.striversrecursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumOne {

	public static void main(String[] args) {
		int[] arr = {1,2};

		solve(arr);
	}

	private static void solve(int[] arr) {
		
		List<Integer> list = new ArrayList<>();
		
		f(arr,0,0,list);
		list.stream().sorted().toList().forEach(e->System.out.print(e+" "));;
		
	}

	private static void f(int[] arr, int i, int sum, List<Integer> list) {
		
		if(i==arr.length) {
			list.add(sum);
			return;
		}
		
		f(arr,i+1,sum+arr[i],list);
		
		f(arr,i+1,sum,list);
		
	}

}
