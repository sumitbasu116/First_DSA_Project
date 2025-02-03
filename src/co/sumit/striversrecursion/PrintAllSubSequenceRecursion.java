package co.sumit.striversrecursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubSequenceRecursion {

	public static void main(String[] args) {
		int[] arr = {3,1,2};
		int n = arr.length;
		solve(arr,n);
	}

	private static void solve(int[] arr, int n) {
		List<Integer> list = new ArrayList<>();
		f(arr,0,list);
	}

	private static void f(int[] arr, int i, List<Integer> list) {
		if(i==arr.length) {
			list.stream().forEach(e->System.out.print(e+" "));
			System.out.println();
			return;
		}
		//pick the element
		list.add(arr[i]);
		f(arr,i+1,list);
		
		//in order to not pick the element, first remove from the List, then simply call the recursive function.
		list.remove(list.size()-1);
		f(arr,i+1,list);
	}

}
