package Inflearn.DFS.부분집합

var N = 0
lateinit var table: Array<Boolean>
var ans = ArrayList<ArrayList<Int>>()

fun DFS(check: Boolean, size: Int) {
    table[size] = check

    // 종료지점
    if (size == N - 1) {
        table[size] = check
        var str = ""
        for (i in 0..size) {
            if (table[i]) str += "${i+1} "
        }
        println(str.trim())
        return
    }

    // 재귀
    DFS(true, size + 1)
    DFS(false, size + 1)
}

fun main() {
    N = 3
    table = Array(N) { true }
    DFS(true, 0)
    DFS(false, 0)

    for (i in ans) {
        println(i)
    }
}