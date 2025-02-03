package co.sumit.striversrecursion;

public class PrintNamesNTimesApproachOne {

	public static void main(String[] args) {
		int n=5;
		
		solve(n);

	}

	private static void solve(int n) {
		
		f(n-1);
		
	}

	private static void f(int n) {
		
		if(n==0) {
			System.out.println("Samhita");
			return;
		}
		System.out.println("Samhita");
		f(n-1);
		
	}

}
