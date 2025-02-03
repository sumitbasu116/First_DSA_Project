package co.sumit.striversrecursion;

public class FibonacciRecursion {

	public static void main(String[] args) {
		
		int n=7;
		
		int res = solve(n-1);
		
		System.out.println(res);

	}

	private static int solve(int n) {
		
//		if(n==0) {
//			return 0;
//			
//		}else if (n==1) {
//			return 1;
//		}
		//modified version of above if..else
		if(n<=1) {
			return n;
		}
		
		return solve(n-1)+solve(n-2);
	}

}
