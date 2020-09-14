package Programmers.Line.Test

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.Collections.min
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


//class Solution {
//    fun solution(boxes: Array<IntArray>): Int {
//        var n = boxes.size * 2
//
//        var map = HashMap<Int, Int>()
//
//        for (i in boxes) {
//            for (j in i) {
//                map[j] = map.getOrDefault(j, 0) + 1
//            }
//        }
//
//        var complete = map.filter { it.value == 2 }.size * 2
//
//        return (n - complete) / 2
//    }
//}
//
//class Solution {
//    fun solution(ball: IntArray, order: IntArray): IntArray {
//
//        var arr = ArrayList<Int>()
//        var temp = ArrayList<Int>()
//        var answer = ArrayList<Int>()
//
//        for (i in ball) {
//            arr.add(i)
//        }
//
//
//        for (i in order) {
//            var num = i
//
//            when (num) {
//                arr[0] -> {
//                    answer.add(arr[0])
//                    arr.removeAt(0)
//                }
//                arr[arr.size - 1] -> {
//                    answer.add(arr[arr.size - 1])
//                    arr.removeAt(arr.size - 1)
//                }
//                else -> {
//                    temp.add(i)
//                }
//            }
//
//
//            if (temp.isNotEmpty()) {
//                var flag = true
//                while (flag) {
//                    flag = false
//                    for (t in temp) {
//                        if (arr.isNotEmpty()) {
//                            when (t) {
//                                arr[0] -> {
//                                    answer.add(t)
//                                    arr.removeAt(0)
//                                    flag = true
//                                }
//                                arr[arr.size - 1] -> {
//                                    answer.add(arr[arr.size - 1])
//                                    arr.removeAt(arr.size - 1)
//                                    flag = true
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        return answer.toIntArray()
//    }
//}

//class Solution {
//    fun solution(n: Int): IntArray {
//
//        var str_n = n.toString()
//        var cnt = 0
//        while (str_n.length >1){
//            cnt++
//            str_n = cSum(str_n).toString()
//        }
//
//
//        var answer = intArrayOf(cnt,str_n.toInt())
//        return answer
//    }
//
//    fun cSum(n: String): Int {
//        var arr = ArrayList<Int>()
//        for (i in 1 until n.length) {
//            if(n[i] != '0'){
//                arr.add(n.substring(0,i).toInt() + n.substring(i,n.length).toInt())
//            }else if(i == n.length-1){
//                arr.add(n.substring(0,i).toInt() + n.substring(i,n.length).toInt())
//            }
//        }
//
//        return min(arr)
//    }
//}


class Solution {
    var comMap = HashMap<String, ArrayList<Char>>()
    var appMap = HashMap<String, ArrayList<Char>>()
    var comCnt = HashMap<String, Int>()
    var appCnt = HashMap<String, Int>()
    var matchingMap = HashMap<String, ArrayList<String>>()

    fun solution(companies: Array<String>, applicants: Array<String>): Array<String> {
        var answer: Array<String> = arrayOf<String>()

        for (i in companies) {
            var sp = i.split(" ")
            var al = ArrayList<Char>()
            for (c in sp[1]) {
                al.add(c)
            }
            comMap[sp[0]] = al
            comCnt[sp[0]] = sp[2].toInt()
            matchingMap[sp[0]] = arrayListOf()
        }

        for (i in applicants) {
            var sp = i.split(" ")
            var al = ArrayList<Char>()
            for (c in sp[1]) {
                al.add(c)
            }
            appMap[sp[0]] = al
            appCnt[sp[0]] = sp[2].toInt()
        }




        while (!check()) {
            apply()
            reject()
        }
        var ans = ArrayList<String>()
        for(i in matchingMap){
            for(j in i.value){
            }
        }



        return answer
    }

    fun apply() {
        for (i in appMap) {
            matchingMap[i.value[0].toString()]?.add(i.key)
            appCnt[i.key]?.minus(1)
        }
    }

    fun reject() {
        for (i in matchingMap) {
            var max = comCnt[i.key]!!
            if (max < i.value.size) {
                for (c in comMap[i.key]!!) {
                    if (max != 0 && i.value.contains(c.toString())) {
                        max--
                        continue
                    } else if (i.value.contains(c.toString())) {
                        i.value.remove(c.toString())
                        appMap[c.toString()]!!.remove(i.key)
                    }
                }
            }
        }
    }

    fun check(): Boolean {
        var flag = true
        for (i in appCnt) {
            if (i.value != 0) flag = false
        }
        return flag
    }

}

fun main() {
    var solution = Solution()
    var com = arrayOf("A fabdec 2", "B cebdfa 2", "C ecfadb 2")
    var app = arrayOf("a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2")

    solution.solution(com, app)


}

