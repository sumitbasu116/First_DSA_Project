package co.sumit.striversrecursion;

public class PrintCountOfAllSubSequencesOfSumRecursion {

	public static void main(String[] args) {
		int[] arr = {3,1,2,7,4};
		int k=7;
		solve(arr,k);

	}

	private static void solve(int[] arr, int k) {
		System.out.println(f(arr,0,0,k));
	}

	private static int f(int[] arr,int i,int sum, int k) {
		
		if(i==arr.length) {
			if(sum==k) {
				return 1;
			}
			return 0;
		}
		
		sum=sum+arr[i];
		int l=f(arr,i+1,sum,k);
		
		sum=sum-arr[i];
		int r=f(arr,i+1,sum,k);
		return l+r;
	}

}
