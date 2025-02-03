package co.sumit.intervals;

public class SortMessageBasedOnPriorityAndTimestamp {

	public static void main(String[] args) {
		/* Suppose, 2D array contains message priority and time stamp and we need sort message based on the priority first and
		 * message with same priority will be sorted by their time stamp.
		 * 1st element represents the priority and second element represents the time stamp number.
		 * lower priority and time stamp has to come first.
		 */
		int[][] arr = { { 1, 20 },{ 5, 30 }, { 5, 10 } };
		
		solve(arr);
		
		for(int[] row:arr) {
			System.out.print(row[0]+" "+row[1]);
			System.out.println();
		}
		
	}

	private static void solve(int[][] arr) {
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i][0]<arr[i-1][0]) {
				int temp[]=arr[i];
				arr[i]=arr[i-1];
				arr[i-1]=temp;
			}
		}
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i][0]==arr[i-1][0]) {
				if(arr[i][1]<arr[i-1][1]) {
					int temp[]=arr[i];
					arr[i]=arr[i-1];
					arr[i-1]=temp;
				}
			}
		}
		
	}

}
