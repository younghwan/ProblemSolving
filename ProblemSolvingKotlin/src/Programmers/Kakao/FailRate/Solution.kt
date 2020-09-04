package Programmers.Kakao.FailRate

class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        var answer = intArrayOf()

        var map = HashMap<Int,Double>()

        for(standard in 1..N){
            var nums_challenger = 0.0
            var nums_notClear = 0.0
            for(cur in stages){
                if(standard<=cur){
                    nums_challenger++
                }
                if(standard==cur){
                    nums_notClear++
                }
            }
            var rate : Double = (nums_notClear/nums_challenger)
            if(nums_challenger == 0.0){
                rate = 0.0
            }
            map[standard] = rate
        }
        var sortedmap = map.toList().sortedWith(compareByDescending{it.second }).toMap()

        for(i in sortedmap){
            println(i.key.toString() + " " + i.value )
        }

        sortedmap.keys.toTypedArray()

        return sortedmap.keys.toTypedArray().toIntArray()
    }
}

fun main(){
    var solution = Solution()
    solution.solution(4, intArrayOf(1,2,3,4))
}