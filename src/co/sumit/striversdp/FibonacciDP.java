package co.sumit.striversdp;

/* Problem: find the nth fibonacci number by using DP.
 * Solution: https://youtu.be/tyB0ztf0DNY?list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY
 */

/*
 * Try to represent the problem in terms of index.
 * Do all possible stuffs on that index according to the problem statements.
 * Sum up of stuffs ==> count all ways.
 * min or max (of all stuffs) ==> find min or max  
 */
public class FibonacciDP {
    public static int fibonacci(int n,int[] arr) {
        
    	if (n <= 0) {
            return 0;  
        } else if (n == 1) {
            return 1;
        } else {
        	if(arr[n]!=-1) {
        		return arr[n];
        	}else {
        		arr[n]=fibonacci(n - 1,arr) + fibonacci(n - 2,arr);
        		return arr[n];
        	}
        }
    }

    public static void main(String[] args) {
        int n = 10; 
        solve(n);
    }

	private static void solve(int n) {
		int[] arr=new int[n+1];
		for(int i=0;i<n+1;i++) {
			arr[i]=-1;
		}
		System.out.println("Fibonacci number at position " + n + " is " + fibonacci(n,arr));
	}
}

