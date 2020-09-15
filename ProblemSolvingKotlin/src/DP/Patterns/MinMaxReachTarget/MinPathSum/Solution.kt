package DP.Patterns.MinMaxReachTarget.MinPathSum

import java.lang.Integer.min

// https://leetcode.com/problems/minimum-path-sum/

class Solution {
    var ans = Int.MAX_VALUE
    var dir = arrayOf(
        arrayOf(1, 0),
        arrayOf(0, 1)
    )

    lateinit var newGrid: Array<IntArray>

    fun minPathSum(grid: Array<IntArray>): Int {
        newGrid = grid
        DP()
        for(i in newGrid){
            println(i.contentToString())
        }
        return newGrid[newGrid.size-1][newGrid[0].size-1]
    }


    // 시간초과
    fun DFS(row: Int, col: Int, cnt: Int = 0, grid: Array<IntArray>) {
        var newCnt = cnt + grid[row][col]
        if (row == grid.size - 1 && col == grid[0].size - 1) {
            ans = min(newCnt, ans)
        }
        for (i in 0..1) {
            var newRow = row + dir[i][0]
            var newCol = col + dir[i][1]
            if (newRow < grid.size && newCol < grid[0].size) {
                DFS(row + dir[i][0], col + dir[i][1], newCnt, grid)
            }
        }
    }

    fun DP() {
        for (i in newGrid.indices) {
            for (j in newGrid[0].indices) {
                if (i == 0 && j == 0) {
                    continue
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    newGrid[i][j] += min(newGrid[i][j - 1], newGrid[i - 1][j])
                }
                if (i - 1 < 0) {
                    newGrid[i][j] += newGrid[i][j-1]
                }
                if (j - 1 < 0) {
                    newGrid[i][j] += newGrid[i-1][j]
                }
            }
        }
    }
}

fun main() {
    var solution = Solution()
    var input = arrayOf(
        intArrayOf(1, 3, 1), intArrayOf(1, 5, 1),
        intArrayOf(4, 2, 1)
    )

    println(solution.minPathSum(input))

}
