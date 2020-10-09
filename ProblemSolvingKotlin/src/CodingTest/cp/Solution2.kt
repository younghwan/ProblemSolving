package CodingTest.cp

import java.text.SimpleDateFormat
import java.util.*

class Solution2 {
    var monthEnd = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

    fun solution(n: Int, customers: Array<String>): Int {
        var kioskList = arrayListOf<Kiosk>()
        for (i in 1..n) {
            kioskList.add(Kiosk(i))
        }

        var curPos = 0

        for (i in customers) {

            var log = i.substring(0, i.length - 3)
            var process = i.substring(i.length - 2)

            val simpleDateFormat = SimpleDateFormat("MM/dd HH:mm:ss")
            val simpleDateFormat2 = SimpleDateFormat("mm")

            val start: Date = simpleDateFormat.parse(log)
            val end: Date = simpleDateFormat2.parse(process)

            var endTime = start.time + (end.time*-1)

            var diff = Long.MIN_VALUE
            var maxKioPos = 0
            var isFull = true
            for (pos in curPos until kioskList.size) {
                println(pos)
                if (kioskList[curPos].endTime <= start.time) {
                    kioskList[curPos].endTime = endTime
                    kioskList[curPos].customerCnt++
                    curPos = pos + 1
                    isFull = false
                    break
                } else {
                    if (kioskList[curPos].endTime - start.time > diff) {
                        diff = kioskList[curPos].endTime - start.time
                        maxKioPos = curPos
                    }
                }
            }
            if (curPos == kioskList.size) curPos = 0

            if(isFull){
                kioskList[maxKioPos].endTime = endTime
                kioskList[maxKioPos].customerCnt++
            }
        }

        for (i in kioskList) {
            println(i.customerCnt)
        }
        return 1
    }
}

data class Kiosk(var number: Int) {
    var endTime: Long = 0
    var customerCnt = 0
}

data class Customer(var time: String) {
    var log = time.split(" ")
    var month = log[0].split("/")[0]
    var day = log[0].split("/")[1]
    val process = log[2].toInt() * 60

    var startLog: Array<String> = log[1].split(":".toRegex()).toTypedArray()

    var end = (startLog[0].toInt() * 60 * 60) + (startLog[1].toInt() * 60) + (startLog[2].toInt())
}

fun main() {
    var sol = Solution2()
    var arr = arrayOf(
        "10/01 23:20:25 30",
        "10/01 23:25:50 26",
        "10/01 23:31:00 05",
        "10/01 23:33:17 24",
        "10/01 23:50:25 13",
        "10/01 23:55:45 20",
        "10/01 23:59:39 03",
        "10/02 00:10:00 10"
    )

    sol.solution(3, arr)

}