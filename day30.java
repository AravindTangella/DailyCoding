Problem : Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k. If such a subset cannot be made, then return null.

	Integers can appear more than once in the list. You may assume all numbers in the list are positive.

	For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.

Solution :
	import java.util.*;

	public class SubsetSumEqualToK {
	    static List<Integer> indexes = new ArrayList<>();

	    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++)
		    arr[i] = sc.nextInt();

		int k = sc.nextInt();
		int dp[][] = new int[n+1][k+1];
		for(int i[] :dp)
		    Arrays.fill(i, -1);

		dp[n][k] = findSubset(arr, dp, n, k, indexes);

		if(dp[n][k] == k)
		    System.out.println("True");
		else
		    System.out.println("False");
	    }

	    public static int findSubset(int arr[], int[][] dp, int n, int k, List<Integer> indexes) {
		if(n==0)
		    return 0;

		if(dp[n][k] != -1)
		    return dp[n][k];

		if(arr[n-1] <= k) {
		    return dp[n][k] = Math.max(arr[n - 1] + findSubset(arr, dp, n - 1, k - arr[n - 1], indexes),
		            findSubset(arr, dp,n - 1, k, indexes));
		}

		return dp[n][k] = findSubset(arr, dp, n-1, k, indexes);
	    }
	}

