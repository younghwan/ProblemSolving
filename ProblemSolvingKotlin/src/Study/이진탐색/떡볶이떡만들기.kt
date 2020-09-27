package Study.이진탐색

fun main() {
    var target = 6
    var arr = arrayOf(19, 15, 10, 17)
    var tArr = Array(arr.size){0}
    var start = 0
    var end = arr.maxOf { it }
    while (start <= end) {
        var mid = (start + end) / 2
        for ((idx,i) in arr.withIndex()) {
            if(i-mid < 0){
                tArr[idx] = 0
            }
            else tArr[idx] = i - mid
        }
        if(tArr.sum() == target){
            println(mid)
            return
        }
        if (tArr.sum() < target) end = mid - 1
        if (tArr.sum() > target) start = mid + 1
    }
}