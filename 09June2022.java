Problem 1 : Given a matrix of 1s and 0s, return the number of "islands" in the matrix. A 1 represents land and 0 represents water, so an island is a group of 1s that are neighboring whose perimeter is surrounded by water.

            For example, this matrix has 4 islands.

            1 0 0 0 0
            0 0 1 1 0
            0 1 1 0 0
            0 0 0 0 0
            1 1 0 0 1
            1 1 0 0 1
            
Solution : class Solution {
              public int numIslands(char[][] grid) {
                  int islands = 0; //Stores the count of islands

                  for(int i = 0; i < grid.length; i++) {
                      for(int j = 0; j < grid[0].length; j++) {
                          if(grid[i][j] == '1') {
                              dfs(grid, i, j);
                              islands++;
                          }
                      }
                  }

                  return islands;
              }
              public void dfs(char[][] grid, int i, int j) {

                  //Stop checking for island when indices reach out of bounds
                  if(i == -1 || i == grid.length || j == -1 || j == grid[0].length)
                      return;

                  //Checking if it is water or the land that is visited
                  if(grid[i][j] == '0' || grid[i][j] == '2')
                      return;

                  grid[i][j] = '2';//making the land as visited

                  //Checking if any land is connected to it on the four sides of current land
                  dfs(grid, i-1, j);
                  dfs(grid, i+1, j);
                  dfs(grid, i, j-1);
                  dfs(grid, i, j+1); 
              }
          }
