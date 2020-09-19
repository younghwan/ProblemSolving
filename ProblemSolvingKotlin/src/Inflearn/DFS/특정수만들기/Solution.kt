package Inflearn.DFS.특정수만들기

/*
61. 특정 수 만들기(DFS : MS 인터뷰)
N개의 원소로 구성된 자연수 집합이 주어지면, 집합의 원소와 ‘+’, ‘-’ 연산을 사용하여 특정 수인 M을 만드는 경우가 몇 가지 있는지 출력하는 프로그램을 작성하세요. 각 원소는 연산에 한 번만 사용합니다.
예를 들어 {2, 4, 6, 8}이 입력되고, M=12이면
2+4+6=12
4+8=12
6+8-2=12
2-4+6+8=12
로 총 4가지의 경우가 있습니다. 만들어지는 경우가 존재하지 않으면 -1를 출력한다.
▣ 입력설명
첫 번째 줄에 자연수 N(1<=N<=10)와 M(1<=M<=100) 주어집니다.
두 번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않는다.

▣ 입력예제 1
4 12
2 4 6 8
▣ 출력예제 1
4
 */
lateinit var arr: Array<Int>
var len = 0
var target = 12
var cnt = 0
fun main() {
    len = 4
    arr = arrayOf(2, 4, 6, 8)

    DFS(0, 0)

    println(cnt)
}

fun DFS(idx: Int, res: Int) {
    if (idx == len) {
        if (res == target) cnt++
        return
    }
    DFS(idx + 1, res + arr[idx])
    DFS(idx + 1, res - arr[idx])
    DFS(idx + 1, res)
}