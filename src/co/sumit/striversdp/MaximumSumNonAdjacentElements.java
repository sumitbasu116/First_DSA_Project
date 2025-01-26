package co.sumit.striversdp;

import java.util.Arrays;

//Also the House Robbe 1 problem: https://www.naukri.com/code360/problems/house-robber_6211018
public class MaximumSumNonAdjacentElements {

	public static void main(String[] args) {

		int[] arr = { 2, 1, 4, 9 };
		
		solve(arr,arr.length);

	}

	private static void solve(int[] arr,int n) {
		
		int[] dp =new int[n+1];
		
		Arrays.fill(dp, -1);
		
		int res=maxSumNonAdjEle(arr,n-1,dp);
		System.out.println(res);
		
	}

	private static int maxSumNonAdjEle(int[] arr, int n, int[] dp) {
		
		if(n==0) {
			return arr[n];
		}else if(n<0) {
			return 0;
		}
		
		if(dp[n]!=-1) {
			return dp[n];
		}
		int pick=arr[n]+maxSumNonAdjEle(arr, n-2, dp);
		int nonPick=maxSumNonAdjEle(arr, n-1, dp);
		return dp[n]=Math.max(pick, nonPick);
	}

}
