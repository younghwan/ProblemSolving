package CodingTest.cpan//package Study
//
//fun CodingTest.Coupang.main() {
//    var arr = intArrayOf(1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100)
//    var diff = IntArray(arr.size)
//    var k = 2
//    var map = HashMap<Int, Int>()
//    var check = false
//    var cnt = 0
//    var hack = arrayListOf<Int>()
//
//    for (i in 1 until arr.size) {
//        diff[i] = arr[i - 1] - arr[i]
//    }
//
//    for (i in diff) {
//        map[i] = map.getOrDefault(i, 0) + 1
//    }
//
//    for (i in map) {
//        if (i.value >= k) hack.add(i.key)
//    }
//    println(hack)
//    var set = HashSet<Int>()
//    for (i in hack) {
//        for ((idx, j) in diff.withIndex()) {
//            if (i == j) {
//                set.add(idx)
//                set.add(idx - 1)
//            }
//        }
//    }
//
//    println(diff.contentToString())
//    if (set.isEmpty()) {
//        println(-1)
//    }
//    println(arr.size-set.size)
//}
////작되지 않은 점수가 하나도 없다면, 0을 return 합니다.