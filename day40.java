Problem 1: There is an N by M matrix of zeroes. Given N and M, write a function to count the number of ways of starting at the top-left corner and 
           getting to the bottom-right corner. You can only move right or down.

          For example, given a 2 by 2 matrix, you should return 2, since there are two ways to get to the bottom-right:

          -> Right, then down
          -> Down, then right
          
Solution : class Solution {
              public int uniquePaths(int m, int n) {
                  int dp[][] = new int[m+1][n+1];
                  for(int i[] : dp)
                      Arrays.fill(i, -1);

                  return findUniquePaths(dp, m, n);
              }
              public int findUniquePaths(int[][] dp, int m, int n) {
                  if(m == 1 && n == 1)
                      return 1;

                  int up = 0, left = 0;

                  if(dp[m][n] != -1)
                      return dp[m][n];

                  if(m > 1)
                      up = findUniquePaths(dp, m-1, n);
                  if(n > 1)
                      left = findUniquePaths(dp, m, n-1);

                  return dp[m][n] = up+left;
              }
          }
