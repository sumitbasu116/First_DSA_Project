package co.sumit.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomOverlapping {

	public static void main(String[] args) {
		//int[][] arr = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		int[][] arr = { {9,15},{ 5,8 } };
		System.out.println(isMeetingsOverlapping(arr));
	}

	private static boolean isMeetingsOverlapping(int[][] arr) {
		boolean res=false;
		
		sortArrayUsingFirstElement(arr);
		for(int i=1;i<arr.length;i++) {
			
			if(arr[i][0]<=arr[i-1][1]) {
				res=true;
			}
		}
		
		return res;
	}
	private static void sortArrayUsingFirstElementJavaEight(int[][] arr){
		Arrays.sort(arr,(a,b)->Integer.compare(a[0], b[0]));
		
	}
	private static void sortArrayUsingFirstElement(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j][0]>arr[j+1][0]) {
					int[] temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
}
