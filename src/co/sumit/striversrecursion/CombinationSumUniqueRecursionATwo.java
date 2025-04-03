package co.sumit.striversrecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumUniqueRecursionATwo {
	public static void main(String[] args) {
		int[] arr = { 10, 1, 2, 7, 6, 1, 5 ,2};

		int target = 11;

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
			if (arr[i] > target || (i != ind && arr[i] == arr[i - 1])) {
				continue;
			}
			list.add(arr[i]);
			f(arr, i + 1, list, target - arr[i]);

			list.remove(list.size() - 1);
		}

	}
}
