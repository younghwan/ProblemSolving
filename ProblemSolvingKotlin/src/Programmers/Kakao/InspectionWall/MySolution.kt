package Programmers.Kakao.InspectionWall

import KotlinPractice.Interview.Sol
import java.util.*
import kotlin.collections.ArrayList

/*
레스토랑을 운영하고 있는 스카피는 레스토랑 내부가 너무 낡아 친구들과 함께 직접 리모델링 하기로 했습니다.
레스토랑이 있는 곳은 스노우타운으로 매우 추운 지역이어서 내부 공사를 하는 도중에 주기적으로 외벽의 상태를 점검해야 할 필요가 있습니다.
레스토랑의 구조는 완전히 동그란 모양이고 외벽의 총 둘레는 n미터이며, 외벽의 몇몇 지점은 추위가 심할 경우 손상될 수도 있는 취약한 지점들이 있습니다.
따라서 내부 공사 도중에도 외벽의 취약 지점들이 손상되지 않았는 지, 주기적으로 친구들을 보내서 점검을 하기로 했습니다. 다만, 빠른 공사 진행을 위해 점검 시간을 1시간으로 제한했습니다.
친구들이 1시간 동안 이동할 수 있는 거리는 제각각이기 때문에, 최소한의 친구들을 투입해 취약 지점을 점검하고 나머지 친구들은 내부 공사를 돕도록 하려고 합니다.
편의 상 레스토랑의 정북 방향 지점을 0으로 나타내며, 취약 지점의 위치는 정북 방향 지점으로부터 시계 방향으로 떨어진 거리로 나타냅니다. 또, 친구들은 출발 지점부터 시계, 혹은 반시계 방향으로 외벽을 따라서만 이동합니다.
외벽의 길이 n, 취약 지점의 위치가 담긴 배열 weak, 각 친구가 1시간 동안 이동할 수 있는 거리가 담긴 배열 dist가 매개변수로 주어질 때,
취약 지점을 점검하기 위해 보내야 하는 친구 수의 최소값을 return 하도록 solution 함수를 완성해주세요.

제한사항
n은 1 이상 200 이하인 자연수입니다.
weak의 길이는 1 이상 15 이하입니다.
서로 다른 두 취약점의 위치가 같은 경우는 주어지지 않습니다.
취약 지점의 위치는 오름차순으로 정렬되어 주어집니다.
weak의 원소는 0 이상 n - 1 이하인 정수입니다.
dist의 길이는 1 이상 8 이하입니다.
dist의 원소는 1 이상 100 이하인 자연수입니다.
친구들을 모두 투입해도 취약 지점을 전부 점검할 수 없는 경우에는 -1을 return 해주세요.
입출력 예
n	weak	dist	result
12	[1, 5, 6, 10]	[1, 2, 3, 4]	2
12	[1, 3, 4, 9, 10]	[3, 5, 7]	1
입출력 예에 대한 설명
입출력 예 #1

원형 레스토랑에서 외벽의 취약 지점의 위치는 다음과 같습니다.

친구들을 투입하는 예시 중 하나는 다음과 같습니다.

4m를 이동할 수 있는 친구는 10m 지점에서 출발해 시계방향으로 돌아 1m 위치에 있는 취약 지점에서 외벽 점검을 마칩니다.
2m를 이동할 수 있는 친구는 4.5m 지점에서 출발해 6.5m 지점에서 외벽 점검을 마칩니다.
그 외에 여러 방법들이 있지만, 두 명보다 적은 친구를 투입하는 방법은 없습니다. 따라서 친구를 최소 두 명 투입해야 합니다.

입출력 예 #2

원형 레스토랑에서 외벽의 취약 지점의 위치는 다음과 같습니다.

7m를 이동할 수 있는 친구가 4m 지점에서 출발해 반시계 방향으로 점검을 돌면 모든 취약 지점을 점검할 수 있습니다. 따라서 친구를 최소 한 명 투입하면 됩니다.

 */
class MySolution {

    var rotatedWeek: ArrayList<IntArray> = ArrayList()

    fun solution(n: Int, weak: IntArray, dist: IntArray): Int {
        var answer = 0
        rotateWeek(weak, n)
        var cand = permute(dist.toTypedArray())

        for (weeks in rotatedWeek) {
            var start = weak[0]
            var end = weak[weak.size - 1]
            for (friends in cand!!) {
                var idx = 1
                for (i in friends) {
                    if (idx == weeks.size - 1)
                        if (start + i >= weak[idx]) {
                            idx++
                            start = weeks[idx]
                        }
                }
            }
        }

        return answer
    }


    fun rotateWeek(weak: IntArray, n: Int) {

        var tempArr = weak

        repeat(weak.size) {
            rotatedWeek.add(tempArr)

            var tmp = IntArray(weak.size)
            for (i in weak.indices) {
                if (i == 0) {
                    tmp[tmp.size - 1] = tempArr[i] + n
                } else {
                    tmp[i - 1] = tempArr[i]
                }
            }
            tempArr = tmp
        }

//        for (arr in rotatedWeek) {
//            for (i in arr) {
//                print("$i ")
//            }
//            println()
//        }
    }

    fun nextPermute(nums: Array<Int>): Array<Int>? {
        var copies = Array(nums.size) { 0 }

        for ((i, num) in nums.withIndex()) {
            copies[i] = num
        }
        var idx = -1
        for (i in 0..copies.size - 2) {
            if (copies[i] < copies[i + 1]) {
                idx = i
            }
        }
        if (idx < 0) {
            return null
        }


        for (i in copies.size - 1 downTo idx) {
            if (copies[idx] < copies[i]) {
                var tmp = copies[idx]
                copies[idx] = copies[i]
                copies[i] = tmp
                break
            }
        }

        for (i in idx + 1 until (copies.size + idx + 1) / 2) {
            var tmp = copies[i]
            copies[i] = copies[copies.size - (i - idx)]
            copies[copies.size - (i - idx)] = tmp
        }
        return copies
    }

    fun permute(nums: Array<Int>): MutableList<MutableList<Int>>? {
        val permutations: MutableList<MutableList<Int>> = java.util.ArrayList()
        Arrays.sort(nums)
        var curArray = nums
        while (true) {
            val integerList: MutableList<Int> = java.util.ArrayList()
            for (i in curArray.indices) {
                integerList.add(curArray[i])
            }
            permutations.add(integerList)
            val nextPermutation = nextPermute(curArray) ?: break
            curArray = nextPermutation
        }
        return permutations
    }
}

fun main() {
    var solution = Solution()
    solution.solution(12, intArrayOf(1, 5, 6, 10), intArrayOf(1, 2, 3, 4))
//    solution.solution(12, intArrayOf(1, 2, 4, 9, 10), intArrayOf(3, 5, 7))

}

// 1 5 6 10 , 5 6 10 13 , 6 10 13 17, 10, 13, 17, 18