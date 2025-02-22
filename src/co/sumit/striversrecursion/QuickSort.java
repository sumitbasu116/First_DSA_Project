package co.sumit.striversrecursion;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {4,6,2,5,7,9,1,3};
		quicksort(arr,0,arr.length-1);
		Arrays.stream(arr).forEach(e->System.out.print(e+" "));
	}

	/*
	 * 1. Pick up a pivot and place in its correct place.
	 * 2. Smaller go on the left and larger go on the right. 
	 */
	
	private static void quicksort(int[] arr,int low,int high) {
		if(low>=high) {
			return;
		}
		int partitionIndex=f(arr,low,high);
		quicksort(arr,low,partitionIndex-1);
		quicksort(arr,partitionIndex+1,high);
	}

	private static int f(int[] arr, int low, int high) {
		int i=low,j=high;
		int pivot=i;
		while(i<=j) {
			while(arr[i]<=arr[pivot] && i<=high) {
				i++;
			}while(arr[j]>arr[pivot] && j>=low) {
				j--;
			}
			if(i<j) {
				swap(arr,i,j);
			}
		}
		swap(arr,pivot,j);
		
		return j;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	
	
}
