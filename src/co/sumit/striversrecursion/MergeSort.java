package co.sumit.striversrecursion;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] arr = {3,1,2,4,1,5,6,2,4};
		
		mergesort(arr,0,arr.length-1);

		Arrays.stream(arr).forEach(e->System.out.print(e+" "));
	}

	private static void mergesort(int[] arr,int low,int high) {
		if(low>=high) {
			return;
		}
		int mid = (low+high)/2;
		
		mergesort(arr,low,mid);
		
		mergesort(arr,mid+1,high);
		
		merge(arr,low,mid,high);
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		int[] temp = new int[arr.length];
		int left=low;int right=mid+1;
		int tepmpInd=0;
		while(left<=mid && right<=high) {
			if(arr[left]<=arr[right]) {
				temp[tepmpInd++]=arr[left];
				left++;
			}else {
				temp[tepmpInd++]=arr[right];
				right++;
			}
		}
		while(left<=mid) {
			temp[tepmpInd++]=arr[left];
			left++;
		}
		while(right<=high) {
			temp[tepmpInd++]=arr[right];
			right++;
		}
		for(int i=low,j=0;i<=high;i++,j++) {
			arr[i]=temp[j];
		}
	}

}
