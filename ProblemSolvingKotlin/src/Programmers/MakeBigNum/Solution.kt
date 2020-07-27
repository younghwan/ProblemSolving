package Programmers.MakeBigNum

import java.lang.StringBuilder

/*
어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

제한 조건
number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
k는 1 이상 number의 자릿수 미만인 자연수입니다.
입출력 예
number	k	return
1924	2	94
1231234	3	3234
4177252841	4	775841
 */

//internal class Solution {
//    fun solution(number: String, k: Int): String {
//        val sb = StringBuilder()
//        var cnt = number.length - k
//        var left = 0
//        var right = number.length - cnt
//        var max = -1
//        var idx = 0
//        while (cnt > 0) {
//            max = -1
//            for (j in left..right) {
//                val num = number[j] - '0'
//                if (num > max) {
//                    idx = j
//                    max = num
//                }
//            }
//            sb.append(number[idx])
//            left = idx + 1
//            right = number.length - --cnt
//        }
//        return sb.toString()
//    }
//}

//class Solution {
//    fun solution(number: String, k: Int): String {
//        var answer = ""
//        var stringSize = number.length - k
//        var index = 0
//        val list = mutableListOf<Char>()
//        while (stringSize > 0) {
//            val string = number.substring(index, number.length - (stringSize - 1))
//            println(string+" "+string.max())
//            string.max()?.let {max ->
//                index += string.indexOf(max) + 1
//                list.add(max)
//            }
//            stringSize -= 1
//        }
//        answer = list.joinToString("")
//        return answer
//    }
//}

fun main() {
    var num = "4177252841"
    var k = 4

    var sol = Solution()
    sol.solution(num, k)
}


class Solution {
    fun solution(number: String, k: Int): String {

        var pick_cnt = number.length - k
        var index = 0
        var ans = StringBuilder()

        while (pick_cnt > 0) {
            var str_picked = number.substring(index, number.length - (pick_cnt - 1))
            var max_num = str_picked.max()!!
            index += str_picked.indexOf(max_num)+1
            ans.append(max_num)
            pick_cnt--
        }
        return ans.toString()
    }
}




