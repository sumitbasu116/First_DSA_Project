package co.sumit.striversrecursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationRecursion {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		
		permute(arr);
	}

	private static void permute(int[] arr) {
		
		boolean[] marker=new boolean[arr.length];
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> ansList = new ArrayList<>();
		f(arr,0,marker,list,ansList);
		ansList.stream().forEach(e->{
			e.stream().forEach(el->System.out.print(el+" "));
			System.out.println();
		});
	}

	private static void f(int[] arr, int ind, boolean[] marker, List<Integer> list,List<List<Integer>> ansList) {
		if(list.size()==arr.length) {
			ansList.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i=0;i<arr.length;i++) {
			if(!marker[i]) {
				marker[i]=true;
				list.add(arr[i]);
				f(arr,ind+1,marker,list,ansList);
				marker[i]=false;
				list.remove(list.size()-1);
			}
		}
		
	}

}
