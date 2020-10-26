package SW

fun minX(arr: Array<Int>): Int {
    // Write your code here
    var ans = 0
    var tmp = 0
    for (i in arr.indices) {
        if (tmp < 1) {
            tmp = -tmp
            ans += tmp + 1
            tmp = 1
        }
    }
    return ans
}

fun main() {
    println(minX(arrayOf(-5, 4, -2, 3, 1, -1, -6, -1, 0, 5)))
}

