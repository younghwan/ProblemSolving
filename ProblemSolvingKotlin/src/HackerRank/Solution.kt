package HackerRank

fun balancedSum(arr: Array<Int>): Int {
    // Write your code here
    var rightSum = 0
    var leftSum = 0
    var left = 0
    var right = 1
    for (i in 1 until arr.size) {
        rightSum += arr[i]
    }
    while (right < arr.size) {
        rightSum -= arr[right]
        leftSum += arr[left]
        if (leftSum == rightSum) return left + 1
        left++
        right++
    }
    return 0
}

fun main() {
    var arr = arrayOf(1, 2, 1)
    println(balancedSum(arr))
}

