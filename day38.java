Problem 1 : Given a multiset of integers, return whether it can be partitioned into two subsets whose sums are the same.

            For example, given the multiset {15, 5, 20, 10, 35, 15, 10}, it would return true, since we can split it up into {15, 5, 10, 15, 10} and
            {20, 35}, which both add up to 55.

            Given the multiset {15, 5, 20, 10, 35}, it would return false, since we can't split it up into two subsets that add up to the same sum.
  
  Solution : class Solution {
                public boolean canPartition(int[] nums) {
                    int n = nums.length;
                    int sum = 0;

                    for(int i : nums) 
                        sum += i;

                    if(sum%2 != 0) 
                        return false;

                    int dp[][] = new int[n+1][(sum/2)+1];

                    for(int i[] : dp)
                        Arrays.fill(i, -1);

                    dp[n][sum/2] = subsetSum(nums, dp, n, sum/2);

                    return dp[n][sum/2] == sum/2;
                }

                public int subsetSum(int[] nums, int[][] dp, int n, int k) {
                    if(n == 0)
                        return 0;

                    if(dp[n][k] != -1)
                        return dp[n][k];

                    if(k-nums[n-1] >= 0)
                        return dp[n][k] = Math.max(nums[n-1]+subsetSum(nums, dp, n-1, k-nums[n-1]), 
                                                   subsetSum(nums, dp, n-1, k));

                    return dp[n][k] = subsetSum(nums, dp, n-1, k);
                }
            }
