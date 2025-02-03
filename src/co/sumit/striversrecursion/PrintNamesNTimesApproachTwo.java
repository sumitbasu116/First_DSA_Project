package co.sumit.striversrecursion;

public class PrintNamesNTimesApproachTwo {

	public static void main(String[] args) {

		int n = 5;

		solve(n);

	}

	private static void solve(int n) {
		int i=1;
		f(i,n);
		
	}

	private static void f(int i, int n) {
		
		if(i>n) {
			return;
		}
		System.out.println("Samhita");
		f(i+1,n);
		
	}

}
