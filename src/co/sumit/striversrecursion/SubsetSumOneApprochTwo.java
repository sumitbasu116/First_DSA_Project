package co.sumit.striversrecursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumOneApprochTwo {

	public static void main(String[] args) {
		int[] arr = {1,2,2};

		solve(arr);
	}

	private static void solve(int[] arr) {
		
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> ansList = new ArrayList<>();
		f(arr,0,list,ansList);
		ansList.stream().forEach(e->{
			e.stream().forEach(el->System.out.print(el+" "));
			System.out.println();
		});
		//list.stream().sorted().toList().forEach(e->System.out.print(e+" "));;
		
	}

	private static void f(int[] arr, int ind, List<Integer> list, List<List<Integer>> ansList) {
		
		ansList.add(new ArrayList<>(list));
		
		for(int i=ind;i<arr.length;i++) {
			if(i!=ind&&arr[i]==arr[i-1]) {
				continue;
			}
			list.add(arr[i]);
			f(arr,i+1,list,ansList);
			list.remove(list.size()-1);
		}
		
	}

}
