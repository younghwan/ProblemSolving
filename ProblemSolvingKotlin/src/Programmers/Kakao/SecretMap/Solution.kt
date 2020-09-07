package Programmers.Kakao.SecretMap

class Solution {
    fun solution(n: Int, arr1: IntArray, arr2: IntArray): Array<String> {

        var ansArr = Array<String>(arr1.size) { " " }

        for (i in arr1.indices) {
            var tmpStr = StringBuilder()
            for (c in arr1[i].or(arr2[i]).toString(2)) {
                if (c == '1') tmpStr.append("#")
                else tmpStr.append(" ")
            }
            ansArr[i] = tmpStr.toString()
        }

        for(i in ansArr){
            println(i)
        }

        return ansArr
    }


    fun solution2(n: Int, arr1: IntArray, arr2: IntArray): Array<String> {
        val answer = Array<String>(n){""}
        for (i in 0 until n) {
            var temp = Integer.toBinaryString(arr1[i] or arr2[i])
            temp = String.format("%" + n + "s", temp)
            temp = temp.replace("1", "#")
            temp = temp.replace("0", " ")
            answer[i] = temp
        }
        return answer
    }
}

/*
n	5
arr1	[9, 20, 28, 18, 11]
arr2	[30, 1, 21, 17, 28]

[46, 33, 33 ,22, 31, 50]
arr2	[27 ,56, 19, 14, 14, 10]
출력	["#####","# # #", "### #", "# ##", "#####"]
 */


fun main() {
    var solution = Solution()
//    solution.solution(5, intArrayOf(46,3,33,22,31,50), intArrayOf(27,56,19,14,14,10))
    var ans = solution.solution2(6, intArrayOf(0, 3, 33, 22, 31, 50), intArrayOf(0, 56, 19, 14, 14, 10))

    for(i in ans){
        println(i)
    }


}