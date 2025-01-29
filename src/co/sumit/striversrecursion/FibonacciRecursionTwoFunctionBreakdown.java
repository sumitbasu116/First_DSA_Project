package co.sumit.striversrecursion;

public class FibonacciRecursionTwoFunctionBreakdown {

	public static void main(String[] args) {
		int n = 7;

		int res = solve(n - 1);

		System.out.println(res);

	}

	private static int solve(int n) {
		if(n<=1) {
			return n;
		}
		int last=solve(n-1);
		int secondLast=solve(n-2);
		return last + secondLast;
	}

}
