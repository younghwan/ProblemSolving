package DP.UniquePaths;

/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
Above is a 7 x 3 grid. How many possible unique paths are there?

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28

 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for(int i =0 ;i<m; i++){
            for(int j =0; j<n; j++){
                if(i ==0 || j ==0){
                    arr[i][j] = 1;
                }
                else {
                    arr[i][j] += arr[i-1][j] + arr[i][j-1];
                }
            }
        }
        return arr[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int m = 3;
        int n = 2;
        System.out.println(solution.uniquePaths(m, n));
    }

}
