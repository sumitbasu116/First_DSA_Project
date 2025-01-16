package co.sumit.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
		//int[][] arr = {{1,3},{1,5},{6,7}};
		//int[][] arr = {{1,2},{2,4}};
		intervalMerge(arr);
	}

	private static void intervalMerge(int[][] arr) {
		
		Arrays.sort(arr,(a,b)->Integer.compare(a[0], b[0]));
		List<Integer[]> output=new ArrayList<>();
		for(int i=1;i<arr.length;i++) {
			if(arr[i][0]<=arr[i-1][1]) {
				output.add(new Integer[] {arr[i-1][0],Math.max(arr[i][1], arr[i-1][1])});
			}else {
				output.add(new Integer[] {arr[i][0],arr[i][1]});
			}
		}
		
		for(Integer ele[]:output) {
			System.out.println(ele[0]+","+ele[1]);
		}
	}
}
