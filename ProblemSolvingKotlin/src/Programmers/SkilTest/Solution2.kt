package Programmers.SkilTest

class Solution2 {
    class Solution {
        fun solution(brown: Int, yellow: Int): IntArray {
            var answer = intArrayOf()

            for(i in 1..yellow){
                if(yellow%i==0){
                    var width = yellow/i

                    if(2*(i+width)+4 == brown){
                        if(width>i){
                            answer = intArrayOf(width+2,i+2)
                            break
                        }
                        else {
                            answer = intArrayOf(i+2,width+2)
                            break
                        }
                    }
                }
            }
            return answer
        }
    }
}