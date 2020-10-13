package Programmers.KthNumber

//배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
//
//예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
//
//array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
//1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
//2에서 나온 배열의 3번째 숫자는 5입니다.
//배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
//
//제한사항
//array의 길이는 1 이상 100 이하입니다.
//array의 각 원소는 1 이상 100 이하입니다.
//commands의 길이는 1 이상 50 이하입니다.
//commands의 각 원소는 길이가 3입니다.
//입출력 예
//array	                commands	                        return
//[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
//입출력 예 설명
//[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
//[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
//[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.


//class Solution {
//    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
//        var answer = mutableListOf<Int>()
//
//        for(command in commands){
//            var start = command[0]-1
//            var end = command[1]-1
//            var target = command[2]-1
//            var temp_arr = mutableListOf<Int>()
//
//            for(i in start..end){
//                temp_arr.add(array[i])
//            }
//
//            temp_arr.sort()
//
//            answer.add(temp_arr[target])
//
//        }
//
//
//        return answer.toIntArray()
//    }
//}

class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        return commands.map { command ->
            array.slice(IntRange(command[0] - 1, command[1] - 1)).sorted()[command[2] - 1]
        }.toIntArray()
    }
}

//array	                commands	                        return
//[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
fun main() {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        return commands.map {
            array.slice(it[0]-1 until it[1]).sorted()[it[2]-1]
        }.toIntArray()
    }
}

//data class Person(val name: String, val age: Int)
//
//fun KotlinPractice.Interview.CodingTest.Coupang.main() {
//    val people = listOf(Person("Alice", 29), Person("Bob", 31))
//    println (people.map { it.name })
//}


//class Solution {
//    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
//        var cnt = 0
//        var answer = IntArray(commands.size)
//        for(c in commands){
//            // println(c.get(0))
//            var _arr = array.sliceArray(c.get(0) - 1..c.get(1) - 1)
//            _arr.sort(0, _arr.size)
//            answer.set(cnt, _arr.get(c.get(2) - 1))
//            cnt++
//        }
//
//        return answer
//    }
//}