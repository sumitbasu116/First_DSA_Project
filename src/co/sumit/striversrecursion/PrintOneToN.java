package co.sumit.striversrecursion;

public class PrintOneToN {
	public static void main(String[] args) {
		int n = 4;
		solve(n);
	}

	private static void solve(int n) {
		int i = 1;
		f(i, n);
	}

	private static void f(int i, int n) {
		if (i > n) {
			return;
		}
		System.out.print(i + " ");
		f(i + 1, n);
	}
}
