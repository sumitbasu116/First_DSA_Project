package co.sumit.striversrecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//generates all unique subsets of an array
public class SubsetSumTwo {

	public static void main(String[] args) {
		int[] arr = {3,4,1};
		uniqueSubsets(arr.length,arr).stream().forEach(e->{
			e.stream().forEach(ob->System.out.print(ob+" "));
			System.out.println();
		});
	}
	
	
	public static List<List<Integer>> uniqueSubsets(int n, int arr[]) {
        
		Arrays.sort(arr);
		
		List<List<Integer>> ansList = new ArrayList<>();
		
		f(0,arr,new ArrayList<Integer>(),ansList);
		
		return ansList;
		
    }


	private static void f(int ind, int[] arr, List<Integer> ds, List<List<Integer>> ansList) {
		//Every subset, including the empty set, is added.
		ansList.add(new ArrayList<>(ds));
		
		for(int i=ind;i<arr.length;i++) {
			 /* This avoids duplicate subsets by skipping repeated elements (useful if arr contains duplicates).
			 * Works only if arr is sorted.
			 */
			if(i!=ind && arr[i]==arr[i-1]) {
				continue;
			}
			ds.add(arr[i]);
			/* Moves to the next index after selecting arr[i].
			 * Ensures that each selected element is only used once in the current recursive branch.
			 * Using f(i + 1, arr, ds, ansList); (Correct Approach)
				 f(0, [1,2,3], [], ansList)
					├── f(1, [1,2,3], [1], ansList)
					│   ├── f(2, [1,2,3], [1,2], ansList)
					│   │   ├── f(3, [1,2,3], [1,2,3], ansList) ✅ (Correctly moves forward)
					│   │   ├── Backtrack → [1,2]
					│   ├── f(3, [1,2,3], [1,3], ansList)
					│   ├── Backtrack → [1]
					├── f(1, [1,2,3], [2], ansList)
					│   ├── f(3, [1,2,3], [2,3], ansList)
					│   ├── Backtrack → [2]
					├── f(2, [1,2,3], [3], ansList)
			 * Using f(ind + 1, arr, ds, ansList); (Incorrect Approach)
				 f(0, [1,2,3], [], ansList)
					├── f(1, [1,2,3], [1], ansList)
					│   ├── f(2, [1,2,3], [1,2], ansList)
					│   │   ├── f(2, [1,2,3], [1,2,3], ansList) ❌ (Wrong! It does not move forward)
					│   ├── f(2, [1,2,3], [1,3], ansList) ❌ (Wrong!)
			
			 */
			f(i+1,arr,ds,ansList);
			ds.remove(ds.size()-1);
		}
	}
	
	

}
