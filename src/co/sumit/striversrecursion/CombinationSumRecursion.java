package co.sumit.striversrecursion;

import java.util.ArrayList;
import java.util.List;

//element can repeat
public class CombinationSumRecursion {

	public static void main(String[] args) {
		
		int[] arr = {2,3,6,7};
		
		int target = 7;
		
		solve(arr,target);

	}

	private static void solve(int[] arr, int target) {
		
		List<Integer> list = new ArrayList<>();
		
		f(arr,target,0,list);
		
	}

	private static void f(int[] arr, int target, int i, List<Integer> list) {
		
		if (target == 0) {
            System.out.println(list);
            return;
        }
		if(i >= arr.length) {
			return;
		}
		//pick the same element
		if(arr[i]<=target) {//we can only pick up an element which is less than or equal to target 
			list.add(arr[i]);
			f(arr,target-arr[i],i,list);
			list.remove(list.size()-1);
		}
		
		//not pick the same element, continue with the next element
		f(arr,target,i+1,list);
	}

}
