package Programmers.Kakao.Test


class Solution2 {
    var candiComb = ArrayList<String>()
    fun solution(orders: Array<String>, course: IntArray): Array<String> {

        var ans = ArrayList<String>()
        var pair = HashSet<Pair<String, Int>>()
        for (n in course) {
            pair = HashSet<Pair<String, Int>>()
            for (order in orders) {
                val visited = BooleanArray(order.length)
                combination(order, visited, 0, order.length, n)
            }

            for (i in candiComb) {
                var cnt = 0
                for (order in orders) {
                    var isContain = true
                    for (c in i) {
                        if (!order.contains(c)) {
                            isContain = false
                        }
                    }

                    if (isContain) {
                        cnt++
                    }
                }

                if (cnt > 1) {
                    pair.add(Pair(i, cnt))
                }
            }

            if(pair.isEmpty()) continue
            var res = pair.sortedByDescending { it.second }
            var maxCnt = res[0].second
            for (i in res) {
                if(i.second < maxCnt) break
                else{
                    ans.add(i.first)
                }
            }

            candiComb.clear()
            pair.clear()

        }

        var answer = HashSet<String>()

        for (i in ans.sorted()) {
            var temp =""
            for(c in i.toList().sorted()){
                temp += c
            }
            answer.add(temp)
        }

        return answer.sorted().toTypedArray()
    }

    fun combination(arr: String, visited: BooleanArray, start: Int, n: Int, r: Int) {
        if (r == 0) {
            add(arr, visited, n)
            return
        }
        for (i in start until n) {
            visited[i] = true
            combination(arr, visited, i + 1, n, r - 1)
            visited[i] = false
        }

    }

    fun add(arr: String, visited: BooleanArray, n: Int) {
        var str = ""
        for (i in 0 until n) {
            if (visited[i]) {
                str += arr[i]
            }
        }
        candiComb.add(str)
    }
}

fun main() {
    var solution = Solution2()
    var arr = arrayOf("XYZ", "XWY", "WXA")
    var cou = intArrayOf(2, 3, 4)
    solution.solution(arr, cou)
//    val visited = BooleanArray(arr.size)
//    solution.combination("ABCFG",visited,0,arr.size-1,3)
//
//    for(i in solution.candiComb){
//        println(i)
//    }

}