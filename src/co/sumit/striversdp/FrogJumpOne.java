package co.sumit.striversdp;

import java.util.Arrays;

public class FrogJumpOne {

	public static void main(String[] args) {
		int n = 6;
		int[] arr = { 30, 10, 60, 10, 60, 50 };

		solve(arr, n);

	}

	private static void solve(int[] arr, int n) {
		int[] res = new int[n + 1];
		Arrays.fill(res, -1);

		System.out.println(solveMinEnergy(arr, res, n - 1));
	}

	private static int solveMinEnergy(int[] arr, int[] res, int n) {
		if (n == 0) {
			return 0;
		}
		if (res[n] != -1) {
			return res[n];
		}
		int right = Integer.MAX_VALUE;
		int left = solveMinEnergy(arr, res, n - 1) + Math.abs(arr[n] - arr[n - 1]);
		if (n > 1) {
			right = solveMinEnergy(arr, res, n - 2) + Math.abs(arr[n] - arr[n - 2]);
		}
		return res[n] = Math.min(left, right);
	}
}
