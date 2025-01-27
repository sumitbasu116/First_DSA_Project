package co.sumit.striversdp;
import java.util.Arrays;
public class NinjasTraining {
	public static void main(String[] args) {

//		int[][] arr = { 
//				{ 1, 2, 5 }, 
//				{ 3, 1, 1 }, 
//				{ 3, 3, 3 } 
//				};
		
		int[][] arr = { 
				{ 10, 40, 70 }, 
				{ 20, 50, 80 }, 
				{ 30, 60, 90 } 
				};
		System.out.println(solve(arr));
	}

	private static int solve(int[][] arr) {
		int noOfTask=arr[0].length;
		int[][] dp = new int[arr.length][noOfTask+1];
		for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
		/*
		 * 0 means task 0
		 * 1 means task 1
		 * 2 means task 2
		 */
		int lastTask=3;//3 means no task performed which is required for day 0 when no task was performed at last day
		int res=f(arr,arr.length-1,lastTask,noOfTask,dp);
		return res;
		
	}

	private static int f(int[][] arr, int n, int lastTask,int noOfTask, int[][] dp) {
		int maxi=0;
		if(n==0) {
			
			for(int task=0;task<noOfTask;task++) {
				if(task!=lastTask) {
					maxi = Math.max(maxi,arr[0][task] );
				}
			}
			return dp[n][lastTask]=maxi;
		}
		maxi=0;
		int point=0;
		for(int task=0;task<noOfTask;task++) {
			if(task!=lastTask) {
				//total point is the point of that day for that task + previous day maximum point
				//and need to pass the current day task to the previous day as a last task which can not be performed.
				point=arr[n][task]+f(arr,n-1,task,noOfTask,dp);
				maxi=Math.max(maxi, point);
			}
		}
		return dp[n][lastTask]=maxi;
		
	}
	
}
