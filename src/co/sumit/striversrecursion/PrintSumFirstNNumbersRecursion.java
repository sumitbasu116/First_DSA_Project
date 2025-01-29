package co.sumit.striversrecursion;

public class PrintSumFirstNNumbersRecursion {

	public static void main(String[] args) {
		
		int n=120;
		
		int res=solve(n);
		
		System.out.println(res);

	}

	private static int solve(int n) {
		int i=1;
		int sum=0;
		return f(i,n,sum);
	}

	private static int f(int i, int n, int sum) {
		if(i>n) {
			return sum;
		}
		
		return f(i+1,n,sum+i);
	}

}
