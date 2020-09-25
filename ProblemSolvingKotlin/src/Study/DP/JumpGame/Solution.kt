package Study.DP.JumpGame
/*
알고리즘 문제해결 전략 1권
215p
 */

class Solution {
    //완전탐색 알고리즘
    var n: Int = 3

    var arr: Array<Array<Int>> = arrayOf(arrayOf(2, 5, 1), arrayOf(6, 1, 1), arrayOf(7, 2, 3))
    fun jump(x: Int, y: Int): Boolean {
        //기저함수
        if (x >= arr.size) return false
        if (y >= arr.size) return false

        if (x == arr.size - 1 && y == arr.size - 1) return true

        var jumpSize = arr[y][x]

        return jump(x + jumpSize, y) || jump(x, y + jumpSize)

    }

    var check: Array<Array<Int>> = Array(4) { Array(4) { -1 } }

    //Study.DP
    fun jump2(x: Int, y: Int): Int {
        if (x >= arr.size) return 0
        if (y >= arr.size) return 0

        if(x == arr.size-1 && y == arr.size-1) return 1

        var jumpSize = arr[y][x]
        var ret = check[y][x]
        if (ret != -1) return ret
            ret = jump2(x + jumpSize,y) + jump2(x,y+jumpSize)

        return ret
    }

}
//
fun main() {
    var solution : Solution = Solution()


    println(solution.jump(0,0))
    println(solution.jump2(0,0))

}