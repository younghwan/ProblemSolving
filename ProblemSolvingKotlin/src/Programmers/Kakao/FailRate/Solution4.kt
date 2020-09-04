package Programmers.Kakao.FailRate

class Solution4 {
    fun solution(N: Int, stages: IntArray): IntArray {
        return (1..N)
            .map { currentStage ->
                val failPerson = stages.count { stage -> currentStage == stage }
                val passedPerson = stages.count { stage -> currentStage <= stage }
                val failRate = if(passedPerson == 0) 0f else failPerson.toFloat() / passedPerson.toFloat()
                Pair(currentStage, failRate)
            }
            .sortedBy { it.first }
            .sortedByDescending { it.second }
            .map { it.first }
            .toIntArray()
    }
}