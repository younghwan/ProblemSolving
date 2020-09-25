package Study.DP.Fibonacci


fun recursiveFibo(i: Int): Int {
    if (i == 0) return 0
    if (i == 1) return 1
    else {
        return recursiveFibo(i - 1) + recursiveFibo(i - 2)
    }
}

lateinit var arr: Array<Int>
fun dpFibo(i: Int): Int {
    if (i == 0) return 1
    if (i == 1) return 1
    else arr[i] = dpFibo(i-1) + dpFibo(i-2)

    return arr[i]
}

fun main() {
    println(recursiveFibo(6))
    var n = 10
    arr = Array(n) { 1 }
    dpFibo(n-1)

    for(i in arr){
        println(i)
    }
}
