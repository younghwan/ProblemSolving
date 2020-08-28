package Programmers.Kakao.MaxmizeEquation

import kotlin.math.abs

class Solution {
    val result = mutableListOf<Long>()
    val set = arrayOf("+", "-", "*")
    var check = BooleanArray(3)

    fun solution(expression: String): Long {
        val value = expression.split("+", "-", "*").map { it.toLong() }.toMutableList()
        val phase = mutableListOf<String>()
        expression.forEach { if (it !in '0'..'9') phase.add(it.toString()) }

        for (oper in set.indices) {
            check.fill(false)
            check[oper] = true
            dfs(set[oper], value, phase)
        }

        return result.max()!!
    }

    fun dfs(operator: String, nextValue: MutableList<Long>, nextPhase: MutableList<String>) {

        val newValue = mutableListOf<Long>()
        newValue.addAll(nextValue)
        val newPhase = mutableListOf<String>()
        newPhase.addAll(nextPhase)

        if (newValue.size > 2) {
            repeat(newPhase.count { it == operator }) {
                val index = newPhase.indexOfFirst { it == operator }
                var operand1 = newValue[index]
                var operand2 = newValue[index + 1]

                newValue[index] = calculation(operand1, operator, operand2)
                newValue.removeAt(index + 1)
                newPhase.removeAt(index)

                if (newPhase.size == 1) {
                    result.add(abs(calculation(newValue[0], newPhase[0], newValue[1])))
                    return
                }
            }
        } else {
            result.add(abs(calculation(newValue[0], newPhase[0], newValue[1])))
            return
        }

        for (oper in check.indices) {
            if (check[oper]) continue
            check[oper] = true
            dfs(set[oper], newValue, newPhase)
            check[oper] = false
        }

    }

    fun calculation(operand1: Long, operator: String, operand2: Long): Long {
        return when (operator) {
            "*" -> (operand1 * operand2)
            "+" -> (operand1 + operand2)
            else -> (operand1 - operand2)
        }
    }
}
/*
해석)
1. 6번의 경우에서 3개 수식을 처리해야되니까 val op = arrayOf(*+-,*-+,+*-,+-*,-*+,-+*) 를 선언하면 인덱스로 쉽게 접근가능해서 편하다.
2. 문자열을 나눠야하는데 숫자는 val number = expression.split(+,-,*).toMutableList() 를 통해 얻고
   수식은 val ex = expression.split(\\d.toRegex()).filter{ it != ""}.toMutableList() 로 filter로 공백은 제외하고 수식만 얻는다.
3. 완전탐색한다
 */
class Solution2 {
    fun solution(expression: String): Long {
        val op = arrayOf("*+-","*-+","+*-","+-*","-*+","-+*")
        val array = mutableListOf<Long>()

        for(i in 0 until 6){
            val number = expression.split("+","-","*").toMutableList()
            val ex = expression.split("\\d".toRegex()).filter{ it != ""}.toMutableList()

            for(y in 0 until 3){
                var x = 0
                while(x < ex.size) {
                    if (ex[x] == op[i][y].toString()) {
                        when(ex[x]){
                            "*" -> number[x] = (number[x].toLong() * number[x+1].toLong()).toString()

                            "+" -> number[x] = (number[x].toLong() + number[x+1].toLong()).toString()

                            "-" -> number[x] = (number[x].toLong() - number[x+1].toLong()).toString()
                        }
                        ex.removeAt(x)
                        number.removeAt(x+1)
                    } else x++
                }
            }
            array.add(abs(number[0].toLong()))
        }
        return array.max()!!
    }
}

fun main(){
    val solution = Solution()
    solution.solution("100-200*300-500+20")
}