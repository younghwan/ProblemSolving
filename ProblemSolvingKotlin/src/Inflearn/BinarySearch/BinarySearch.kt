package Inflearn.BinarySearch

/*
42. 이분검색
임의의 N개의 숫자가 입력으로 주어집니다.
N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면 이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요.
▣ 입력설명
첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다. 두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.
▣ 출력설명
첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.
▣ 입력예제
8 32
23 87 65 12 57 32 99 81
▣ 출력예제
3
 */

fun main() {
    var len = 8
    var target = 3
//    var arr = arrayOf(27,87,65,12,57,32,99,81)
    var arr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8)

    arr.sort()


    var left = 1
    var right = len
    var mid = (left + right) / 2

    while (left <= right) {
        var value = arr[mid]
        if (value == target) break
        if (value < target) {
            left = mid+1
        } else {
            right = mid-1
        }
        mid = (left + right) / 2


    }
    println(arr[mid])

}


