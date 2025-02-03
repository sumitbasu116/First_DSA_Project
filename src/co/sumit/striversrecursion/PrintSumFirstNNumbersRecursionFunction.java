package co.sumit.striversrecursion;

public class PrintSumFirstNNumbersRecursionFunction {

	public static void main(String[] args) {
		int n = 120;

		int res = solve(n);

		System.out.println(res);

	}

	private static int solve(int n) {
		if(n==0) {
			return 0;
		}
		return n+ solve(n-1);
	}

}
