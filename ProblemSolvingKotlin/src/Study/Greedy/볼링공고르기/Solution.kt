package Study.Greedy.볼링공고르기

fun main() {
    var N = 5
    var M = 3
    var arr = arrayOf(1,3,2,3,2)
    var cntArr = Array<Int>(arr.size + 1) { 0 }
    var ans = 0
    for (i in arr) {
        cntArr[i]++
    }
    for (i in 1..cntArr.size-2) {
        ans += (N-cntArr[i]) * cntArr[i]
    }
    println(ans)
}