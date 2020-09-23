package Study.Greedy.큰수의법칙

fun main() {
    var N = 5 //배열의 크기
    var M = 8 //숫자가 더해지는 횟수
    var K = 3 //숫자의 최대 연속횟수
    var arr = arrayOf(2, 4, 5, 4, 6)

    arr.sort()
    var first = arr[N - 1]
    var second = arr[N - 2]


    // 가장큰수가 몇번 더해지는지 판단하는것 즉, 6이 몇번 더해지는지 판단
    var cnt = M / (K + 1) * K
    cnt += M % (K + 1)

    var res = cnt*first + (M-cnt)*second // 가장큰수 * 횟수 + 두번째로 큰수 * 횟수
    println(res)
}