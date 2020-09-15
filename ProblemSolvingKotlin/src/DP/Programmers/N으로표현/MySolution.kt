package DP.Programmers.N으로표현

class MySolution {
    fun solution(N: Int, number: Int): Int {

        var stand = ""
        var arr = ArrayList<ArrayList<Int>>()

        arr.add(arrayListOf(-1))
        arr.add(arrayListOf(N))
        arr.add(arrayListOf(N + N, N * N, N - N, N / N, "$N$N".toInt()))

        for (i in 3..8) {
            stand = stand.padEnd(i, N.toString().toCharArray()[0])
            var res = arrayListOf<Int>()

            for (j in 1 until i) {
                res = oper(arr[j], arr[i - j])
            }
            res.add(stand.toInt())
            arr.add(res)
        }

        for ((idx, a) in arr.withIndex()) {
            for (i in a) {
                if (number == i) {
                    if (idx > 8) return -1
                    else {
                        return idx
                    }
                }
            }
        }
        for (i in arr) {
            println(i)
        }

        return -1
    }

    fun oper(a: ArrayList<Int>, b: ArrayList<Int>): ArrayList<Int> {
        var res = HashSet<Int>()
        for (i in a) {

            for (j in b) {
                res.add(i + j)
                res.add(i * j)
                res.add(i - j)
                if (j != 0) {
                    res.add(i / j)
                }
                if (i != 0) {
                    res.add(j / i)
                }
                res.add(j - i)
            }
        }
        return res.toList() as ArrayList
    }
}

fun main() {
    var solution = Solution()
    var ar1 = arrayListOf<Int>(5)
    var ar2 = arrayListOf<Int>(55, 10, 0, 25, 1)
//    solution.oper(ar1, ar2)
    println(solution.solution(5, 12))
}
