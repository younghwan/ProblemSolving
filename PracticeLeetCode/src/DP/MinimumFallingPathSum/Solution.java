package DP.MinimumFallingPathSum;

import java.util.Arrays;
import java.util.Collections;

/*
Given a square array of integers A, we want the minimum sum of a falling path through A.
A falling path starts at any element in the first row, and chooses one element from each row.
The next row's choice must be in a column that is different from the previous row's column by at most one.

Example 1:
Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: 12
Explanation:
The possible falling paths are:
[1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
[2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
[3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
The falling path with the smallest sum is [1,4,7], so the answer is 12.
 */
public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = matrix[0][i];
        }

        //1 2 3
        //5 6 8

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]) + matrix[i][j];
                }
                if (j == dp.length - 1) {
                    dp[i][j] = Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]) + matrix[i][j];
                } else if (j > 0 && j < matrix.length - 1) {
                    dp[i][j] = findThreeMin(matrix[i - 1][j], matrix[i - 1][j - 1], matrix[i - 1][j + 1]) + matrix[i][j];
                }
            }
        }
        for (int i : dp[dp.length - 1]) {
            res = Math.min(res, i);
        }
        return res;
    }

    public int findThreeMin(int a, int b, int c) {
        if (a <= b && a <= c) return a;
        if (b <= a && b <= c) return b;
        return c;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.findThreeMin(5, 3, 1));
    }
}
