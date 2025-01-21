package co.sumit.striversdp;

import java.util.Arrays;

public class FrogJumpOne {

	public static void main(String[] args) {
		int n = 4;
		//int[] arr = { 30, 10, 60, 10, 60, 50 };
		int[] arr = {10 ,20, 30, 10};

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
		int secondJump = Integer.MAX_VALUE;
		//Frog can jump only 1 steps or two steps
		//while jumping from nth step to (n-1)th step, it looses (arr[n] - arr[n - 1]) energy.
		int firstJump = solveMinEnergy(arr, res, n - 1) + Math.abs(arr[n] - arr[n - 1]);
		if (n > 1) {
			secondJump = solveMinEnergy(arr, res, n - 2) + Math.abs(arr[n] - arr[n - 2]);
		}
		return res[n] = Math.min(firstJump, secondJump);
	}
}
