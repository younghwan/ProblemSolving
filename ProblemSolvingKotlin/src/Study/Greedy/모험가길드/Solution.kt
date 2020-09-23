package Study.Greedy.모험가길드

fun main() {
    var arr = arrayOf(2, 3, 1, 2, 2)
    arr.sort()
    var cnt = 0
    var temp = arrayListOf<Int>()
    for (i in arr.indices) {
        temp.add((arr[i]))
        if (temp.size >= temp[temp.size - 1]){
            cnt++
            temp.clear()
        }
    }
    println(cnt)
}