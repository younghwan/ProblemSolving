package Programmers.Line

class Solution4 {
    fun solution(snapshots: Array<Array<String>>, transactions: Array<Array<String>>) {

        var map = HashMap<String, Int>()
        for (snapshot in snapshots) {
            map[snapshot[0]] = Integer.valueOf(snapshot[1])
        }


        // 중복제거
        var distinctTrans = transactions.distinctBy { it[0] }

        println(map)

        for (i in distinctTrans) {

            if (i[1] == "SAVE"){
                map.put(i[2],map.getOrDefault(i[2],0)+Integer.valueOf(i[3]))
            }
            if(i[1] =="WITHDRAW"){
                map[i[2]] = map[i[2]]!! - Integer.valueOf(i[3])
            }
        }
        println(map)

        var ans = map.toList().sortedBy { it.first }.toMap()

        for(i in ans){
            println("${i.key} , ${i.value}")
        }
    }
}

fun main() {
    var solution = Solution4()

    var snapshots = arrayOf(arrayOf("ACCOUNT1", "100"), arrayOf("ACCOUNT2", "150"))
    var transactions = arrayOf(
        arrayOf("1", "SAVE", "ACCOUNT2", "100"),
        arrayOf("2", "WITHDRAW", "ACCOUNT1", "50"),
        arrayOf("1", "SAVE", "ACCOUNT2", "100"),
        arrayOf("4", "SAVE", "ACCOUNT3", "500"),
        arrayOf("3", "WITHDRAW", "ACCOUNT2", "30")
    )

    solution.solution(snapshots, transactions)
}