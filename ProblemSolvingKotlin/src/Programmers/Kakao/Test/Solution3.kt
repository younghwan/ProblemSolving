package Programmers.Kakao.Test

class Solution {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        var answer: IntArray = IntArray(query.size)

        var map = HashMap<Int, Array<String>>()

        for ((idx, str) in info.withIndex()) {
            map[idx] = str.split(" ").toTypedArray()
        }

        var queryArr = Array<Array<String>>(query.size) { arrayOf("") }
        for ((idx, i) in query.withIndex()) {
            queryArr[idx] = i.split(" and ", " ").toTypedArray()
        }

        for ((idx, q) in queryArr.withIndex()) {
            var tmpMap = mapOf<Int, Array<String>>()
            for (m in map) {
                tmpMap = map
                if (q[0] == "-" && q[1] == "-" && q[2] == "-" && q[3] == "-") {
                    tmpMap = tmpMap.filter { it.value[4].toInt() >= q[4].toInt() }.toMap()
                    break
                }

                if (q[0] == "-" && q[1] != "-" && q[2] != "-" && q[3] != "-") {
                    if (q[1] != "-") {
                        tmpMap = tmpMap.filter { it.value.contains(q[1]) }.toMap()
                    }

                    if (q[2] != "-") {
                        tmpMap = tmpMap.filter { it.value.contains(q[2]) }.toMap()
                    }

                    if (q[3] != "-") {
                        tmpMap = tmpMap.filter { it.value.contains(q[3]) }.toMap()
                    }
                    tmpMap = tmpMap.filter { it.value[4].toInt() >= q[4].toInt() }
                    break
                }

                if (q[0] != "-" && q[1] == "-" && q[2] != "-" && q[3] != "-") {
                    if (q[1] != "-") {
                        tmpMap = tmpMap.filter { it.value.contains(q[0]) }.toMap()
                    }

                    if (q[2] != "-") {
                        tmpMap = tmpMap.filter { it.value.contains(q[2]) }.toMap()
                    }

                    if (q[3] != "-") {
                        tmpMap = tmpMap.filter { it.value.contains(q[3]) }.toMap()
                    }
                    tmpMap = tmpMap.filter {it.value[4].toInt() >= q[4].toInt() }
                    break
                }

                if (q[0] != "-" && q[1] != "-" && q[2] == "-" && q[3] != "-") {
                    if (q[1] != "-") {
                        tmpMap = tmpMap.filter { it.value.contains(q[0]) }.toMap()
                    }

                    if (q[2] != "-") {
                        tmpMap = tmpMap.filter { it.value.contains(q[1]) }.toMap()
                    }

                    if (q[3] != "-") {
                        tmpMap = tmpMap.filter { it.value.contains(q[3]) }.toMap()
                    }
                    tmpMap = tmpMap.filter { it.value[4].toInt() >= q[4].toInt() }
                    break
                }

                if (q[0] != "-" && q[1] != "-" && q[2] != "-" && q[3] == "-") {
                    if (q[1] != "-") {
                        tmpMap = tmpMap.filter { it.value.contains(q[0]) }.toMap()
                    }

                    if (q[2] != "-") {
                        tmpMap = tmpMap.filter { it.value.contains(q[1]) }.toMap()
                    }

                    if (q[3] != "-") {
                        tmpMap = tmpMap.filter { it.value.contains(q[2]) }.toMap()
                    }
                    tmpMap = tmpMap.filter { it.value[4].toInt() >= q[4].toInt() }
                    break
                }


                if (q[1] != "-") {
                    tmpMap = tmpMap.filter { it.value.contains(q[0]) }.toMap()
                }
                if (q[1] != "-") {
                    tmpMap = tmpMap.filter { it.value.contains(q[1]) }.toMap()
                }

                if (q[2] != "-") {
                    tmpMap = tmpMap.filter { it.value.contains(q[2]) }.toMap()
                }

                if (q[3] != "-") {
                    tmpMap = tmpMap.filter { it.value.contains(q[3]) }.toMap()
                }
                tmpMap = tmpMap.filter { it.value[4].toInt() >= q[4].toInt() }
            }

            for (i in tmpMap) {
                println(i.value.contentToString())
            }
            println()

            answer[idx] = tmpMap.size
        }

        return answer
    }
}

fun main() {
    var info = arrayOf(
        "java backend junior pizza 150",
        "python frontend senior chicken 210",
        "python frontend senior chicken 150",
        "cpp backend senior pizza 260",
        "java backend junior chicken 80",
        "python backend senior chicken 50"
    )
    var query = arrayOf(
//        "java and backend and junior and pizza 100",
//        "python and frontend and senior and chicken 200",
//        "cpp and - and senior and pizza 250",
//        "- and backend and senior and - 150",
//        "- and - and - and chicken 100",
        "- and - and - and - 150"
    )

    var solution = Solution()
    solution.solution(info, query)
}