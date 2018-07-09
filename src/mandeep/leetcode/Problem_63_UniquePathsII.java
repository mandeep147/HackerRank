/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.
Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on Jul 8, 2018, 10:32:38 PM
 */
public class Problem_63_UniquePathsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] grid ={
				{0, 0, 0},
				{0, 1, 0},
				{0, 0, 0}
		};
		
		System.out.println(uniquePath(grid));
	}

	/**
	 * @param grid
	 * @return
	 */
	private static int uniquePath(int[][] grid) {
		if(grid == null || grid.length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		
		if(grid[0][0] == 1 || grid[m-1][n-1] == 1)
			return 0;
		
		int[][] dp = new int[m][n];
		dp[0][0]  = 1;
		
		//left column
		for(int i = 1; i < m ; i++){
			if(grid[i][0] == 1)
				dp[i][0] = 0;
			else
				dp[i][0] = dp[i-1][0];
		}
		
		//top row
		for(int i = 1; i < n; i++){
			if(grid[0][i] == 1)
				dp[0][i] = 0;
			else
				dp[0][i] = dp[0][i-1];
		}
		
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				if(grid[i][j] == 1)
					dp[i][j] = 0;
				else
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[m-1][n-1];
	}

}
