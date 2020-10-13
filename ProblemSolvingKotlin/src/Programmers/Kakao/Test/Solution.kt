//package Programmers.Kakao.Test
//
//class Solution {
//    fun solution(new_id: String): String {
//
//        var input = new_id.toLowerCase()
//
//        var newId = ""
//
//        for (c in input) {
//            if ((c in 'a'..'z') || c.isDigit() || c == '-' || c == '_' || c == '.') {
//                newId += c
//            }
//        }
//
//        newId = newId.replace("\\.+".toRegex(), ".")
//        if (newId[0] == '.') newId = newId.removeRange(0, 1)
//        if (newId.isNotEmpty() && newId[newId.length - 1] == '.') newId = newId.removeRange(newId.length - 1, newId.length)
//
//        if (newId == "") newId += "a"
//
//        if (newId.length >= 16) {
//            newId = newId.removeRange(15, newId.length)
//        }
//        if (newId[newId.length - 1] == '.') newId = newId.removeRange(newId.length - 1, newId.length)
//
//        if (newId.length <= 2) {
//            while (newId.length < 3) {
//                newId += newId[newId.length - 1]
//            }
//        }
//        println(newId)
//        return newId
//    }
//}
//
//fun KotlinPractice.Interview.CodingTest.Coupang.main() {
//    var solution = Solution()
//    solution.solution(		"=.=")
//}