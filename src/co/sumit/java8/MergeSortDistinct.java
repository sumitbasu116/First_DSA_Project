package co.sumit.java8;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSortDistinct {

	public static void main(String[] args) {
		int[] a = new int[] {4, 2, 5, 1};
		int[] b = new int[] {8, 1, 9, 5};
		
		int[] res = IntStream.concat(Arrays.stream(a), Arrays.stream(b))
				.sorted()
				.distinct().toArray();
		Arrays.stream(res).forEach(System.out::print);
	}
}
