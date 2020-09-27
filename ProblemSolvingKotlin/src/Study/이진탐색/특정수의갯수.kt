package Study.이진탐색

fun main() {
    var arr = arrayOf(1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2)
    var target = 2

    var start = 0
    var end = arr.size - 1

    println(end(arr, start, end, target) - first(arr, start, end, target) + 1)

}

fun first(arr: Array<Int>, start: Int, end: Int, target: Int): Int {
    var left = start
    var right = end
    var mid = 0
    while (left <= right) {
        mid = (left + right) / 2
        if (arr[mid] == target) {
            if (mid == 0) return mid
            else if (arr[mid - 1] != target) return mid
        }
        if (arr[mid] < target) {
            left = mid + 1
        }
        if (arr[mid] >= target) {
            right = mid - 1
        }
    }
    return mid
}

fun end(arr: Array<Int>, start: Int, end: Int, target: Int): Int {
    var left = start
    var right = end
    var mid = 0
    while (left <= right) {
        mid = (left + right) / 2
        if (arr[mid] == target) {
            if (mid == arr.size - 1) return mid
            else if (arr[mid + 1] != target) return mid
        }
        if (arr[mid] <= target) {
            left = mid + 1
        }
        if (arr[mid] > target) {
            right = mid - 1
        }
    }
    return mid
}