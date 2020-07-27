package Programmers.Carpet

//class Solution {
//    fun solution(brown: Int, yellow: Int): IntArray {
//        var answer = intArrayOf()
//
//        for(i in 1..yellow){
//            if(yellow%i==0){
//                var width = yellow/i
//
//                if(2*(i+width)+4 == brown){
//                    if(width>i){
//                        answer = intArrayOf(width+2,i+2)
//                        break
//                    }
//                    else {
//                        answer = intArrayOf(i+2,width+2)
//                        break
//                    }
//                }
//            }
//        }
//        return answer
//    }
//}


class Solution {
    fun solution(brown: Int, red: Int): IntArray {
        return (1..red)
            .filter { red % it == 0 }
            .first { brown == (red / it * 2) + (it * 2) + 4 }
            .let { intArrayOf(red / it + 2, it + 2) }
    }
}

fun main() {
    var sol = Solution()

    println(sol.solution(10, 2)[0])
    println(sol.solution(10, 2)[1])
}
