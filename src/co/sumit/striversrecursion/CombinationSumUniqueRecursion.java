package co.sumit.striversrecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumUniqueRecursion {

	public static void main(String[] args) {
		int[] arr = { 10, 1, 2, 7, 6, 1, 5 ,2};

		int target = 11;
		
		solve(arr,target);

	}

	private static void solve(int[] arr, int target) {
		List<Integer> list = new ArrayList<>();
		// we need to sort the array first as the problem said the combination should be in lexicographical order.
		Arrays.sort(arr);
		f(arr,target,0,list);
	}

	private static void f(int[] arr, int target, int index, List<Integer> list) {
		if (target == 0) {
            System.out.println(list);
            return;
        }
         //it means we have processed all elements or we stop further recursion (as the array is sorted, larger elements won't work).
        if (index >= arr.length || arr[index] > target) return;

        // Pick the current element
        list.add(arr[index]);
        f(arr, target - arr[index], index + 1, list);
        list.remove(list.size() - 1);

        // Skip duplicates and move to the next distinct element
        int nextIndex = index + 1;
        while (nextIndex < arr.length && arr[nextIndex] == arr[index]) {
            nextIndex++;
        }
        
        // Do Not pick the element 
        f(arr, target, nextIndex, list);
		
	}

}
