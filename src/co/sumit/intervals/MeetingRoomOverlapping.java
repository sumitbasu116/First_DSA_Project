package co.sumit.intervals;

public class MeetingRoomOverlapping {

	public static void main(String[] args) {
		int[][] arr = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		//int[][] arr = { { 5,8 }, {9,15} };
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

	private static void sortArrayUsingFirstElement(int[][] arr) {
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j][0]>arr[j+1][0]) {
					int[] temp = arr[j];
					arr[j+1]=temp;
					arr[j]=arr[j+1];
				}
			}
			
		}
		
	}

}
