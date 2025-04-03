package co.sumit.striversrecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumRecursionApproachTwo {
	public static void main(String[] args) {
		int[] arr = { 2, 3, 6, 7 };

		int target = 7;

		solve(arr, target);

	}

	private static void solve(int[] arr, int target) {
		Arrays.sort(arr);
		List<Integer> list = new ArrayList<>();
		f(arr, 0, list, target);

	}

	private static void f(int[] arr, int ind, List<Integer> list, int target) {
		if (target == 0) {
			list.stream().forEach(e -> System.out.print(e + " "));
			System.out.println();
			return;
		}

		for (int i = ind; i < arr.length; i++) {
			if (arr[i] > target) {
				continue;
			}
			list.add(arr[i]);
			f(arr, i, list, target - arr[i]);

			list.remove(list.size() - 1);
		}

	}
}
