package CodingTest.cp//package Study
//
//var cnt = 0
//
//lateinit var check: HashMap<String, Boolean>
//lateinit var map: HashMap<String, ArrayList<String>>
//fun solution(depar: String, hub: String, dest: String, roads: Array<Array<String>>): Int {
//
//    map = HashMap<String, ArrayList<String>>()
//    check = HashMap<String, Boolean>()
//
//    for (i in roads) {
//        map[i[0]] = arrayListOf()
//    }
//    for (i in roads) {
//        map[i[0]]?.add(i[1])
//    }
//    DFS(depar, hub, dest, arrayListOf())
//    println(cnt)
//    return cnt
//}
//
//fun DFS(pos: String, hub: String, end: String, path: ArrayList<String>) {
//    path.add(pos)
//    println(path)
//    if (pos == end) {
//        if (path.contains(hub)) cnt++
//        return
//    }
//    for (i in map[pos]!!) {
//        DFS(i, hub, end, path)
//        path.remove(i)
//    }
//}
//
//fun CodingTest.Coupang.main() {
//    var road = arrayOf(
//        arrayOf("ULSAN", "BUSAN"),
//        arrayOf("DAEJEON", "ULSAN"),
//        arrayOf("DAEJEON", "GWANGJU"),
//        arrayOf("SEOUL", "DAEJEON"),
//        arrayOf("SEOUL", "ULSAN"),
//        arrayOf("DAEJEON", "DAEGU"),
//        arrayOf("GWANGJU", "BUSAN"),
//        arrayOf("DAEGU", "GWANGJU"),
//        arrayOf("DAEGU", "BUSAN"),
//        arrayOf("ULSAN", "DAEGU"),
//        arrayOf("GWANGJU", "YEOSU"),
//        arrayOf("BUSAN", "YEOSU")
//    )
//    solution("SEOUL", "DAEGU", "YEOSU", road)
//}