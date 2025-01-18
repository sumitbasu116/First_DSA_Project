package co.sumit.intervals;

import java.util.Arrays;

/*
 * If start is the minimum,then it means a meeting has started.
 * If end is the minimum, then it means a meeting has ended.
 */
public class MeetingRoomCount {

	public static void main(String[] args) {
		int[][] arr = { { 5, 10 },{ 0, 30 } , { 15, 20 } };
		//int[][] arr = { { 5,8 }, {9,15} };
		//int[][] arr = { { 4,9} };
		System.out.println(bookMeetingRoomsCount(arr));
	}

	private static int bookMeetingRoomsCount(int[][] arr) {
		int res=0;
		int[] start=new int[arr.length];
		int[] end=new int[arr.length];
		
		for(int i=0;i<arr.length;i++) {
			start[i]=arr[i][0];
			end[i]=arr[i][1];
		}
		Arrays.sort(start);
		Arrays.sort(end);
		int s=0,e=0;
		int count=0;
		while(s<arr.length&&e<arr.length) {
			
			int min = Math.min(start[s], end[e]);
			if(min==start[s]) {
				s++;
				count++;
				if(count>res) {
					res=count;
				}
			}else if(min==end[e]) {
				e++;
				count--;
			}
		}
		return res;
	}

}
