package Study.Greedy.곱하기혹은더하기

fun main() {
//    var str = "02984"
    var str = "567"
    var arr = Array(str.length) { 0 }
    for ((idx, c) in str.withIndex()) {
        arr[idx] = c.toString().toInt()
    }


    var res = 0
    for (n in arr) {
        if (n == 0 || n == 1 || res == 0) res += n
        else res *= n
    }
    println(res)
}