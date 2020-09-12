package Programmers.Kakao.Test

import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.log

class Solution4 {
    fun solution(play_time: String, adv_time: String, logs: Array<String>): String {
        var answer: String = ""
        var format = SimpleDateFormat("hh:mm:ss")

        var arr = ArrayList<Pair<Date, Date>>()
        for(log in logs){
            var startTime = format.parse(log.split("-")[0])
            var endTime = format.parse(log.split("-")[1])
            arr.add(Pair(startTime,endTime))

        }

        for(i in arr){
            println(i)
        }

        return answer
    }
}

fun main() {
    var play = "02:03:55"
    var adv = "00:14:15"
    var logs =
        arrayOf("01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30")

    var solution = Solution4()
    solution.solution(play, adv, logs)
}
