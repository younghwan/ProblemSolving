package CodingTest.cpan//fun CodingTest.Coupang.main() {
//
//    val ans = IntArray(2)
//    var max = 0
//    for (i in 2..9) {
//        val res = decimalToN(1000000, i)
//        var tmp = 1
//        for (c in res) {
//            if (c == '0') continue
//            tmp *= c.toString().toInt()
//        }
//        if (max <= tmp) {
//            max = tmp
//            ans[0] = i
//            ans[1] = tmp
//            if (max == tmp && ans[0] < i) {
//                ans[0] = i
//            }
//        }
//    }
//    println(ans.contentToString())
//
//}
//
//fun decimalToN(base: Int, n: Int): String {
//    var newBase = base
//    var remains = ""
//    while (newBase != 0) {
//        remains += (newBase % n).toString()
//        newBase /= n
//    }
//    return remains.reversed()
//}