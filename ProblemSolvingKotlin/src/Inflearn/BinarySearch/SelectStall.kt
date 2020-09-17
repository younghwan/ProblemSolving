package Inflearn.BinarySearch

import java.lang.Integer.min

/*
44. 마구간 정하기(이분검색 응용)
N개의 마구간이 1차원 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가 지며, 마구간간에 좌표가 중복되는 일은 없습니다.
현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,
가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대 값을 출력하는 프로그램을 작성하세요.
▣ 입력설명
첫 줄에 자연수 N(3<=N<=200,000)과 C(2<=C<=N)이 공백을 사이에 두고 주어집니다.
둘째 줄부터 N개의 줄에 걸쳐 마구간의 좌표 xi(0<=xi<=1,000,000,000)가 한 줄에 하나씩 주어집니다.
▣ 출력설명
첫 줄에 가장 가까운 두 말의 최대 거리를 출력하세요.
▣ 입력예제 1
5 3
1
2
8
4
9

▣ 출력예제 1
3
 */
fun main() {
    var N = 5
    var C = 3

    var arr = arrayOf(1, 2, 8, 4, 9)
    arr.sort()

    var mMax = arr[arr.size - 1] - arr[0]
    var left = arr[0]
    var right = arr.size - 1
    var mid = (left + right) / 2
    var ans = Int.MAX_VALUE


    while (left <= right) {

//        if (count(mid, arr) == C) {
//            ans = min(ans, mid)
//        }

        if (C > count(mid, arr)) {
            right = mid - 1
        } else {
            left = mid + 1
        }
        mid = (left + right) / 2
    }

    println(mid)
}

fun count(n: Int, arr: Array<Int>): Int {
    var cnt = 1
    var tmp = 0
    for ((idx, a) in arr.withIndex()) {
        if (arr[idx] - arr[tmp] >= n) {
            tmp = idx
            cnt++
        }
    }
    return cnt
}


