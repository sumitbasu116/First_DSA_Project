package co.sumit.striversdp;

/*
 * Problem: https://leetcode.com/problems/climbing-stairs/description/
 * Solution: https://youtu.be/mLfjzJsN8us?list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY
 */
public class ClimbingStairs {

	public static void main(String[] args) {
		
		int n=2;
		
		solve(n);

	}
	private static void solve(int n) {
		int[] dp=new int[n+1];
		for(int i=0;i<n+1;i++) {
			dp[i]=-1;
		}
		
		System.out.println(solveNumberOfWays(n,dp));
	}
	private static int solveNumberOfWays(int n,int[] arr) {
		
		//1.Try to represent the problem in terms of index.
		if(n==0) {
			return 1;
		}else if(n==1) {
			return 1;
		}
		else {
			//2.Do all possible stuffs on that index according to the problem statements.
			if(arr[n]!=-1) {
				return arr[n];
			}else {
				//3. Sum up of stuffs ==> count all ways.
				arr[n]=solveNumberOfWays(n-1,arr)+solveNumberOfWays(n-2,arr);
				return arr[n];
			}
		}
	}

}
