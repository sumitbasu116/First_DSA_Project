package co.sumit.striversrecursion;

import java.util.ArrayList;
import java.util.List;
//computes all possible subset sums of an array
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
		//If i reaches the length of the array, it means we've considered all elements.
		if(i==arr.length) {
			list.add(sum);
			return;
		}
		
		//The first recursive call includes the current element (arr[i]) in the sum.
		f(arr,i+1,sum+arr[i],list);
		
		//The second recursive call excludes the current element from the sum.
		f(arr,i+1,sum,list);
		
	}

}
