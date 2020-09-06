package Programmers.Line

import java.util.Comparator

class Solution5 {
    fun solution(dataSource: Array<Array<String>>, tags: Array<String>) {
        var map1 = HashMap<String, ArrayList<String>>()
        var map2 = HashMap<String, Int>()

        for (arr in dataSource) {
            map1[arr[0]] = arrayListOf()
            for (i in 1 until arr.size) {
                map1[arr[0]]?.add(arr[i])
            }
        }
        for (tag in tags) {
            for (map in map1) {
                if (map.value.contains(tag)) {
                    map2.put(map.key, map2.getOrDefault(map.key, 0) + 1)
                }
            }
        }
        var ans = map2.toList().sortedWith(Comparator { o1, o2 ->
            if(o1.second == o2.second){
                o1.first.compareTo(o2.first)
            }
            else{
                o2.second.compareTo(o1.second)
            }
        }).toMap()

        println(ans.keys)
    }
}

fun main() {
    var sol = Solution5()

    var dataSource = arrayOf(
        arrayOf("doc1", "t1", "t2", "t3"),
        arrayOf("doc2", "t0", "t2", "t3"),
        arrayOf("doc3", "t1", "t6", "t7"),
        arrayOf("doc4", "t1", "t2", "t4"),
        arrayOf("doc5", "t6", "t100", "t8")
    )
    var tags = arrayOf("t100","t1")

    sol.solution(dataSource, tags)
}