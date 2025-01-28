package co.sumit.striversrecursion;

public class PrintNToOneApproachTwo {
	public static void main(String[] args) {
		int n = 4;
		solve(n);
	}

	private static void solve(int n) {
		f(n,n);
	}

	private static void f(int i, int n) {
		if(i<1) {
			return;
		}
		System.out.print(i+" ");
		f(i-1,n);
	}
}
