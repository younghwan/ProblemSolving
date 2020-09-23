package Study.Greedy.만들수없는금액

import java.util.*


// 핵심 : 연속된 숫자의 총합까지 그 숫자들의 조합으로 다 만들수있다는것
fun main() {
    var n = 0
    var arrayList = ArrayList<Int>()

    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    for (i in 0 until n) {
        arrayList.add(sc.nextInt())
    }
    arrayList.sort()
    var target = 1
    for (i in 0 until n) {
        println(target)
        // 만들 수 없는 금액을 찾았을 때 반복 종료
        if (target < arrayList[i]) break
        target += arrayList[i]
    }
    println(target)
}