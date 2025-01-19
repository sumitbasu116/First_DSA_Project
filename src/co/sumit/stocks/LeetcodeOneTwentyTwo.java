package co.sumit.stocks;

public class LeetcodeOneTwentyTwo {
	public static void main(String[] args) {
		//int[] arr={7,1,5,3,6,4};
		//int[] arr={1,2,3,4,5};
		int[] arr={7,6,4,3,1};
		/*
		 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
		 * On each day, you may decide to buy and/or sell the stock. 
		 * You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
		 * Find and return the maximum profit you can achieve.
		 */
		int maxProfit=solve(arr);
		System.out.println(maxProfit);
	}

	private static int solve(int[] arr) {
		int j=1;
		int profit=0;
		while(j<arr.length) {
			if(arr[j]>arr[j-1]) {
				profit=profit+(arr[j]-arr[j-1]);
			}
			j++;
		}
		
		return profit;
	}
}
