package co.sumit.striversdp;

import java.util.Arrays;

public class HouseRobberTwo {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 1 };

		System.out.println(solve(arr, arr.length));
	}

	private static int solve(int[] arr, int n) {

		int[] temp1 = new int[n];
		int[] temp2 = new int[n];
		
		for(int i=0,j=0;i<n;i++,j++) {
			if(i!=0) {
				temp1[j]=arr[i];
			}
			if(i!=n-1) {
				temp2[j]=arr[i];
			}
		}
		
		return Math.max( solveNonAdjSubSum(temp1,temp1.length),solveNonAdjSubSum(temp2,temp2.length));
		
	}

	private static int solveNonAdjSubSum(int[] arr, int n) {

		int[] dp = new int[n + 1];

		Arrays.fill(dp, -1);

		int res = maxSumNonAdjEle(arr, n - 1, dp);
		return res;

	}

	private static int maxSumNonAdjEle(int[] arr, int n, int[] dp) {

		if (n == 0) {
			return arr[n];
		} else if (n < 0) {
			return 0;
		}

		if (dp[n] != -1) {
			return dp[n];
		}
		int pick = arr[n] + maxSumNonAdjEle(arr, n - 2, dp);
		int nonPick = maxSumNonAdjEle(arr, n - 1, dp);
		return dp[n] = Math.max(pick, nonPick);
	}

}
