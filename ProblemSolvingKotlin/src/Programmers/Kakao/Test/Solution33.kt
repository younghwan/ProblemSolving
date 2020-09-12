package Programmers.Kakao.Test

class Solution33 {
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

        var tmpMap = mapOf<Int, Array<String>>()
        for ((idx, q) in queryArr.withIndex()) {
            tmpMap = map
            if (q[0] == "-" && q[1] == "-" && q[2] == "-" && q[3] == "-") {
                tmpMap = tmpMap.filter { it.value[4].toInt() >= q[4].toInt() }.toMap()
                answer[idx] = tmpMap.size
                continue
            }

            if (q[0] == "-" && q[1] != "-" && q[2] != "-" && q[3] != "-") {
                tmpMap = tmpMap.filter {
                    it.value.contains(q[1])
                        .and(it.value.contains(q[2]))
                        .and(it.value.contains(q[3]))
                        .and(it.value[4].toInt() >= q[4].toInt())
                }

                answer[idx] = tmpMap.size
                continue
            }

            if (q[0] != "-" && q[1] == "-" && q[2] != "-" && q[3] != "-") {
                tmpMap = tmpMap.filter { it.value.contains(q[0]) }.toMap()
                tmpMap = tmpMap.filter { it.value.contains(q[2]) }.toMap()
                tmpMap = tmpMap.filter { it.value.contains(q[3]) }.toMap()
                tmpMap = tmpMap.filter { it.value[4].toInt() >= q[4].toInt() }
                answer[idx] = tmpMap.size
                continue
            }

            if (q[0] != "-" && q[1] != "-" && q[2] == "-" && q[3] != "-") {
                tmpMap = tmpMap.filter { it.value.contains(q[0]) }.toMap()
                tmpMap = tmpMap.filter { it.value.contains(q[1]) }.toMap()
                tmpMap = tmpMap.filter { it.value.contains(q[3]) }.toMap()
                tmpMap = tmpMap.filter { it.value[4].toInt() >= q[4].toInt() }
                answer[idx] = tmpMap.size
                continue
            }

            if (q[0] != "-" && q[1] != "-" && q[2] != "-" && q[3] == "-") {
                tmpMap = tmpMap.filter { it.value.contains(q[0]) }.toMap()
                tmpMap = tmpMap.filter { it.value.contains(q[1]) }.toMap()
                tmpMap = tmpMap.filter { it.value.contains(q[2]) }.toMap()
                tmpMap = tmpMap.filter { it.value[4].toInt() >= q[4].toInt() }
                answer[idx] = tmpMap.size
                continue
            }

            // 3개
            if (q[0] == "-" && q[1] == "-" && q[2] == "-" && q[3] != "-") {
                tmpMap = tmpMap.filter { it.value.contains(q[3]) }.toMap()
                tmpMap = tmpMap.filter { it.value[4].toInt() >= q[4].toInt() }
                answer[idx] = tmpMap.size
                continue
            }

            if (q[0] == "-" && q[1] == "-" && q[2] != "-" && q[3] == "-") {
                tmpMap = tmpMap.filter { it.value.contains(q[2]) }.toMap()
                tmpMap = tmpMap.filter { it.value[4].toInt() >= q[4].toInt() }
                answer[idx] = tmpMap.size
                continue
            }

            if (q[0] == "-" && q[1] != "-" && q[2] == "-" && q[3] == "-") {
                tmpMap = tmpMap.filter { it.value.contains(q[1]) }.toMap()
                tmpMap = tmpMap.filter { it.value[4].toInt() >= q[4].toInt() }
                answer[idx] = tmpMap.size
                continue
            }

            if (q[0] != "-" && q[1] == "-" && q[2] == "-" && q[3] == "-") {
                tmpMap = tmpMap.filter { it.value.contains(q[0]) }.toMap()
                tmpMap = tmpMap.filter { it.value[4].toInt() >= q[4].toInt() }
                answer[idx] = tmpMap.size
                continue
            }

            // 2개
            if (q[0] != "-" && q[1] != "-" && q[2] == "-" && q[3] == "-") {
                tmpMap = tmpMap.filter {
                    it.value.contains(q[0])
                        .and(it.value.contains(q[1]))
                        .and(it.value[4].toInt() >= q[4].toInt())
                }
                answer[idx] = tmpMap.size
                continue
            }

            if (q[0] != "-" && q[1] == "-" && q[2] == "-" && q[3] != "-") {
                tmpMap = tmpMap.filter {
                    it.value.contains(q[0])
                        .and(it.value.contains(q[3]))
                        .and(it.value[4].toInt() >= q[4].toInt())
                }
                answer[idx] = tmpMap.size
                continue
            }

            if (q[0] != "-" && q[1] == "-" && q[2] != "-" && q[3] == "-") {
                tmpMap = tmpMap.filter {
                    it.value.contains(q[0])
                        .and(it.value.contains(q[2]))
                        .and(it.value[4].toInt() >= q[4].toInt())
                }

                answer[idx] = tmpMap.size
                continue
            }

            if (q[0] == "-" && q[1] != "-" && q[2] == "-" && q[3] != "-") {
                tmpMap = tmpMap.filter {
                    it.value.contains(q[1])
                        .and(it.value.contains(q[3]))
                        .and(it.value[4].toInt() >= q[4].toInt())
                }
                answer[idx] = tmpMap.size
                continue
            }

            if (q[0] == "-" && q[1] != "-" && q[2] != "-" && q[3] == "-") {
                tmpMap = tmpMap.filter {
                    it.value.contains(q[1])
                        .and(it.value.contains(q[2]))
                        .and(it.value[4].toInt() >= q[4].toInt())
                }

                answer[idx] = tmpMap.size
                continue
            }

            if (q[0] == "-" && q[1] == "-" && q[2] != "-" && q[3] != "-") {
                tmpMap = tmpMap.filter {
                    it.value.contains(q[2])
                        .and(it.value.contains(q[3]))
                        .and(it.value[4].toInt() >= q[4].toInt())
                }

                answer[idx] = tmpMap.size
                continue
            }



            tmpMap = tmpMap.filter {
                it.value.contains(q[0])
                    .and(it.value.contains(q[1]))
                    .and(it.value.contains(q[2]))
                    .and(it.value.contains(q[3]))
                    .and(it.value[4].toInt() >= q[4].toInt())
            }

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
        "- and backend and senior and - 150",
//        "- and - and - and chicken 100",
//        "- and - and - and - 150"
    )

    var solution = Solution33()
    solution.solution(info, query)
}