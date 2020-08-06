package Programmers.Camouflage

import kotlin.collections.HashMap

class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1 //곱셈을 위해 1로 선언
        val clothesMap = HashMap<String, Int>()
        //map 구하기
        for (i in clothes.indices) {
            //의상종류, 갯수
            clothesMap[clothes[i][1]] = clothesMap.getOrDefault(clothes[i][1], 0) + 1
        }
        //조합
        val keySet: Set<String> = clothesMap.keys //의상종류.
        for (key in keySet) {
            answer *= clothesMap[key]!! + 1
        }
        return answer - 1 //아무것도 안입는 경우의 수 제거
    }
}

//class Solution {
//    fun solution(clothes: Array<Array<String>>) = clothes
//        .groupBy { it[1] }.values   // group by type of clothes, keep only names of clothes
//        .map { it.size + 1 }        // number of things to wear in a group (including wearing nothing)
//        .reduce(Int::times)         // combine
//        .minus(1)                   // remove the case where the spy wears nothing
//}


//class Solution {
//    fun solution(clothes: Array<Array<String>>): Int {
//        return clothes.groupBy { it[1] }.values.fold(1) { acc, v -> acc * (v.size + 1) }  - 1
//    }
//}