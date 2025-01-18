package co.sumit.stocks;

public class BestTimeToBuyAndSellStocks {

	public static void main(String[] args) {
		int[] arr = {1,7,5,3,6,4};
		//int[] arr = {7,6,4,3,1};
		
		int res=solve(arr);
		
		System.out.println(res);
	}

	private static int solve(int[] arr) {
		int max=0;
		int sellInd=-1;
		int buyInd=-1;
		int buyPrice=Integer.MAX_VALUE;
		int profit=0;
		buyPrice=arr[0];
		buyInd=0;
		int j=1;
		while(j<arr.length) {
			profit=arr[j]-buyPrice;
			if(arr[j]<buyPrice) {
				buyPrice=arr[j];
				buyInd=j;
			}
			if(profit>0) {
				if(profit>max) {
					max=profit;
					sellInd=j;
				}
			}
			j++;
		}
		System.out.println(buyInd+","+sellInd);
		return sellInd;
	}

}
