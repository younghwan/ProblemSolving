package Interview

fun decimalToN(base: Int, n: Int): String {
    var newBase = base
    var remains = ""
    while (newBase != 0) {
        remains += (newBase % n).toString()
        newBase /= n
    }
    return remains.reversed()
}

fun nToDecimal(base: Int, n: Int): Int {
    var newBase = base.toString()
    var power = 1
    var res = 0
    for (c in newBase.reversed()){
        res += (c.toInt()-48)*power
        power *= n
    }

    return res

}

fun main() {
    print(nToDecimal(1010,2))
}