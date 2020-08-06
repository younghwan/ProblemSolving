package Programmers.Kakao.OpenChattingRoom

import java.util.*


//class Solution {
//    var map = HashMap<String, String>()
//    var arr = ArrayList<Array<String>>()
//
//    fun solution(record: Array<String>): Array<String> {
//
//        for (orders in record) {
//            var order_arr = orders.split(" ")
//            when (order_arr[0]) {
//                "Enter" -> enter(order_arr[1], order_arr[2])
//                "Leave" -> leave(order_arr[1])
//                "Change" -> change(order_arr[1], order_arr[2])
//            }
//        }
//
//        var answer = Array<String>(arr.size) { "" }
//
//        for ((index, value) in arr.withIndex()) {
//            answer[index] = value[0]
//        }
//
//        return answer
//    }
//
//    fun enter(id: String, nickname: String) {
//        for((key)in map){
//            if(key == id) change(id,nickname)
//            break
//        }
//
//        map[id] = nickname
//        var msg = arrayOf("${nickname}님이 들어왔습니다.", id)
//        arr.add(msg)
//    }
//
//    fun leave(id: String) {
//        var nickname = map[id]
//        var msg = arrayOf("${nickname}님이 나갔습니다.", id)
//        arr.add(msg)
//    }
//
//    fun change(id: String, nickname: String) {
//        var curNickname = ""
//        for ((key, value) in map) {
//            if (id == key) {
//                curNickname = value
//                map[key] = nickname
//            }
//        }
//
//        for (msg in arr) {
//            if (msg[1] == id) {
//                var changedMsg = msg[0].replace(curNickname, nickname)
//                msg[0] = changedMsg
//            }
//        }
//    }
//}

class Solution {
    fun solution(record: Array<String>): Array<String> {
        val uid_Map: MutableMap<String, String> = mutableMapOf()

        record.forEach {
            val action = it.split(" ")
            when (action[0]) {
                "Enter" -> {
                    uid_Map[action[1]] = action[2]
                }
                "Change" -> {
                    uid_Map[action[1]] = action[2]
                }
            }
        }

        val dialog = record.map {
            val action = it.split(" ")
            when (action[0]) {
                "Enter" -> {
                    "${uid_Map[action[1]]}님이 들어왔습니다."
                }
                "Leave" -> {
                    "${uid_Map[action[1]]}님이 나갔습니다."
                }
                else -> ""
            }
        }.filter { it != "" }.toTypedArray()

        return dialog
    }
}

fun main() {

    var arr = arrayOf(
        "Enter uid1234 Muzi",
        "Enter uid4567 Prodo",
        "Leave uid1234",
        "Enter uid1234 Prodo",
        "Change uid4567 Ryan"
    )
    var solution = Solution()
    for(ans in solution.solution(arr)){
        println(ans)
    }

}