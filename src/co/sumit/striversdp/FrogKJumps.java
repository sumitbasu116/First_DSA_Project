package co.sumit.striversdp;

import java.util.Arrays;

public class FrogKJumps {

	public static void main(String[] args) {
		int n = 4;
		int k=3;
		int[] arr = { 30, 10, 60, 10, 60, 50 };
		//int[] arr = {10 ,20, 30, 10};

		solve(arr, n,k);
		
	}

	private static void solve(int[] arr, int n,int k) {
		int[] res=new int[n];
		Arrays.fill(res, -1);
		/* Why not passing n here?
		 * n-1 means index and index starts from 0 and goes up to n-1.
		 */
		System.out.println(solveMinEnergyOfKJumps(arr,res,n-1,k));
		
	}

	private static int solveMinEnergyOfKJumps(int[] arr, int[] res, int n,int k) {
		
		if(n==0) {
			return 0;
		}
		
		if(res[n]!=-1) {
			return res[n];
		}
		int min=Integer.MAX_VALUE;
		int en=0;
		for(int i=1;i<=k;i++) {
			if(n-i>=0) {//i should not be greater than index or n.
				en=solveMinEnergyOfKJumps(arr,res,n-i,k)+Math.abs(arr[n]-arr[n-i]);
				min=Math.min(min, en);
			}
		}
		return res[n]=min;
	}

}
