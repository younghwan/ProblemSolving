package CranePuppeteer

import java.util.*

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var stack = Stack<Int>()
        var answer = 0
        for (move in moves) {
            for (target_arr in board) {
                if (target_arr[move - 1] != 0) {
                    stack.add(target_arr[move - 1])
                    target_arr[move - 1] = 0
                    if(stack.size>1){
                        if(stack[stack.size-1] == stack[stack.size-2]){
                            stack.pop()
                            stack.pop()
                            answer += 2
                        }
                    }

                    for(i in stack){
                        print(i)
                    }
                    println()
                    break
                }
            }
        }
        println()
        return answer
    }
}

fun main() {
    var Solution = Solution()
    var moves: IntArray = intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)
    var board: Array<IntArray> = arrayOf(
        intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 1, 0, 3), intArrayOf(0, 2, 5, 0, 1)
        , intArrayOf(4, 2, 4, 4, 2), intArrayOf(3, 5, 1, 3, 1)
    )

    print(Solution.solution(board = board, moves = moves))
}
