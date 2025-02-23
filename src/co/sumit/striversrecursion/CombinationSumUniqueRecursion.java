package co.sumit.striversrecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumUniqueRecursion {

	public static void main(String[] args) {
		int[] arr = {10 ,1, 2,7 ,6 ,1 ,5};
		
		int target =8;
		
		solve(arr,target);

	}

	private static void solve(int[] arr, int target) {
		List<Integer> list = new ArrayList<>();
		// we need to sort the array first as the problem said the combination should be in lexicographical order.
		Arrays.sort(arr);
		f(arr,target,0,list);
	}

	private static void f(int[] arr, int target, int ind, List<Integer> list) {
		if(target==0) {
			list.stream().forEach(e->System.out.print(e+" "));
			System.out.println();
			return;
		}
		
		/*
		 * we need a for loop here, bcz, to form a unique combination, suppose we can start from index 1,
		 * Then we can either choose the element from 2nd followed by 3rd followed 4th and so on, considering all are unique elements.
		 * suppose we can start from index 2, Then we can either choose the element from 3rd followed 4th and so on.
		 */
		for(int i=ind;i<arr.length;i++) {
			// Skip duplicates to ensure unique combinations.
			/* Example 1:
			 * {1,1,1,2,2} and target = 4, suppose, we choose {1,1,2}, here, the first two 1s are from the index 0th and 1st.
			 * Hence, we can not choose 2nd index 1 as then it will create the same combination.
			 * Example 2: {1,1,1,1,2,2} and target = 5, suppose, we choose {1,1,1,2}, here, the first three 1s are from the index 0th and 1st and 2nd.
			 * Hence, we can not choose 1 from the 3rd index otherwise, it will create the same combination as {1,1,1,2}.
			 */
			if(i>ind && arr[i]==arr[i-1]) {
				continue;
			}
			// If the current number is greater than the remaining target, break (as array is sorted).
			if(arr[i]>target) {
				break;
			}
			list.add(arr[i]);
			f(arr,target-arr[i],i+1,list);
			list.remove(list.size()-1);
		}
		
	}

}
