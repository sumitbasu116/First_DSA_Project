package co.sumit.striversrecursion;

public class PrintCountOfAllSubSequencesOfSumRecursion {

	public static void main(String[] args) {
		int[] arr = {3,1,2,7,4};
		int k=7;
		solve(arr,k);

	}

	private static void solve(int[] arr, int k) {
		int count =0;
		count=f(arr,arr.length,0,0,k,count);
		System.out.println(count);
	}

	private static int f(int[] arr,int n, int i,int sum, int k, int count) {
		
		if(i==n) {
			if(sum==k) {
				return 1;
			}
			return 0;
		}
		
		sum=sum+arr[i];
		int l=f(arr,n,i+1,sum,k,count);
		
		sum=sum-arr[i];
		int r=f(arr,n,i+1,sum,k,count);
		return l+r;
	}

}
