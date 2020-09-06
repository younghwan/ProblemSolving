package Programmers.Line

import java.util.*

class Solution1 {
    fun solution(str: String): Int {

        var stack1 = Stack<Char>() // ()
        var stack2 = Stack<Char>() // {}
        var stack3 = Stack<Char>() // []
        var stack4 = Stack<Char>() // <>

        var count =0;


        for (char in str) {
            if (char == '(') {
                stack1.add(char)
                continue
            }
            if (char == '{') {
                stack2.add(char)
                continue
            }
            if (char == '[') {
                stack3.add(char)
                continue
            }
            if (char == '<') {
                stack4.add(char)
                continue
            }

            //close
            if (char == ')') {
                if (!stack1.isEmpty()) {
                    stack1.pop()
                    count++
                } else {
                    return -1
                }
                continue
            }
            if (char == '}') {
                if (!stack2.isEmpty()) {
                    stack2.pop()
                    count++
                } else {
                    return -1
                }
                continue
            }
            if (char == ']') {
                if (!stack3.isEmpty()) {
                    stack3.pop()
                    count++
                } else {
                    return -1
                }
                continue
            }

            if (char == '>') {
                if (!stack4.isEmpty()) {
                    stack4.pop()
                    count++
                } else {
                    return -1
                }
                continue
            }
        }

        return count
    }

}

fun main() {


    var str1 = "Hello, world!"
    var str2 = "line [plus]"
    var str3 = "if (Count of eggs is 4.) {Buy milk.}"
    var str4 = ">_<"

    var solution1 = Solution1()
    println(solution1.solution(str1))
    println(solution1.solution(str2))
    println(solution1.solution(str3))
    println(solution1.solution(str4))

}