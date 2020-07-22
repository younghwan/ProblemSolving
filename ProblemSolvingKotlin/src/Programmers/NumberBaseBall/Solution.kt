package Programmers.NumberBaseBall

//문제 설명
//숫자 야구 게임이란 2명이 서로가 생각한 숫자를 맞추는 게임입니다. 게임해보기
//
//각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 3자리의 숫자를 불러서 결과를 확인합니다. 그리고 그 결과를 토대로 상대가 정한 숫자를 예상한 뒤 맞힙니다.
//
//* 숫자는 맞지만, 위치가 틀렸을 때는 볼
//* 숫자와 위치가 모두 맞을 때는 스트라이크
//* 숫자와 위치가 모두 틀렸을 때는 아웃
//예를 들어, 아래의 경우가 있으면
//
//A : 123
//B : 1스트라이크 1볼.
//A : 356
//B : 1스트라이크 0볼.
//A : 327
//B : 2스트라이크 0볼.
//A : 489
//B : 0스트라이크 1볼.
//이때 가능한 답은 324와 328 두 가지입니다.
//
//질문한 세 자리의 수, 스트라이크의 수, 볼의 수를 담은 2차원 배열 baseball이 매개변수로 주어질 때, 가능한 답의 개수를 return 하도록 solution 함수를 작성해주세요.
//
//제한사항
//질문의 수는 1 이상 100 이하의 자연수입니다.
//baseball의 각 행은 [세 자리의 수, 스트라이크의 수, 볼의 수] 를 담고 있습니다.
//입출력 예
//baseball	                                            return
//[[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]]	2


class Solution {
    fun solution(baseball: Array<IntArray>): Int {
        var solArr = ArrayList<String>()

        for(i in 123..987){
            var num = i.toString()

            if(num[0] == num[1] || num[1] == num[2] || num[0] == num[2]) continue
            if(num[0] == '0' || num[1] == '0' || num[2] == '0') continue

            var flag = false
            for (match in baseball) {
                var cand = match[0].toString()
                var strike = match[1]
                var ball = match[2]

                var num_ball =0
                var num_strike = 0

                for(k in 0..2){
                    if(cand[k] == num[k])
                    {
                        num_strike++
                        continue
                    }
                    if(cand.contains(num[k])) num_ball++
                }

                if(strike != num_strike || ball != num_ball){
                    flag = false
                    break
                }
                flag = true
            }
            if(flag) solArr.add(num)

        }
        return solArr.size
    }
}

//class Solution {
//    fun solution(baseball: Array<IntArray>) =
//        (123..987)
//            .filter { !it.toString().contains('0') && it.toString().toSet().size === 3 }
//            .filter { check(it, baseball) }.size
//
//    fun check(candidate: Int, baseball: Array<IntArray>) =
//        baseball.all { (question, strikes, balls) ->
//            question.toString().foldIndexed(Pair(0, 0)) { index, acc, c ->
//                when (c) {
//                    candidate.toString()[index] -> Pair(acc.first + 1, acc.second)
//                    in candidate.toString() -> Pair(acc.first, acc.second + 1)
//                    else -> acc
//                }
//            } == Pair(strikes, balls)
//        }
//}

fun main(){
    var solution = Solution()
    var array : Array<IntArray> = arrayOf(intArrayOf(123, 1, 1), intArrayOf(356, 1, 0), intArrayOf(327, 2, 0), intArrayOf(489, 0, 1))

    println(solution.solution(array))

//    var str1 = "As"
//    print(str1.contains("a"))

}