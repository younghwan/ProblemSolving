package Programmers.SkilTest.Level3

class Solution {
    var ansSet = HashSet<Int>()
    lateinit var arr: Array<Array<Int>>
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {


        arr = Array(N+1) { Array(N+1) { 0 } }
        for (i in road) {
            arr[i[0]][i[1]] = i[2]
            arr[i[1]][i[0]] = i[2]
        }

        for(i in arr){
           println(i.contentToString())
        }

        DFS(1,0,k)
        println(ansSet)
        return ansSet.size
    }

    fun DFS(n: Int, cnt: Int, k: Int) {
        println(n)
        if (cnt >= k) {
            return
        }
        ansSet.add(n)
        for ((idx,i) in arr[n].withIndex()) {
            if(i != 0){
                DFS(idx,i+cnt,k)
            }
        }
    }
}