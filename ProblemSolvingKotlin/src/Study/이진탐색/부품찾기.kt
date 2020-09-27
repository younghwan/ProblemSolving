package Study.이진탐색

fun main() {
    var N = 5
    var storage = arrayOf(8, 3, 7, 9, 2)
    var list = arrayOf(5, 7, 9)
    storage.sort()
    println(storage.contentToString())
    for (i in list) {
        if (find(i, storage)) print("YES ") else print("NO ")
    }
}

fun find(i: Int, arr: Array<Int>): Boolean {
    var start = 0
    var end = arr.size

    while (start <= end) {
        var mid = (start + end) / 2
        if (arr[mid] == i) return true
        if (arr[mid] < i) start = mid + 1
        if (arr[mid] > i) end = mid - 1
    }
    return false
}
