package SW

fun isPrime(n: Long): Int {
    // Write your code here

    var flag = true
    var j = 2
    while (j * j <= n) {
        if ((n % j) == 0L) {
            flag = false
            break
        }
        j++
    }
    if (flag) return 1
    var ans = 0
    for (i in 2..n / 2) {
        if (n % i == 0L){
            ans = i.toInt()
            break
        }
    }
    return ans
}

fun main() {
    println(isPrime(37961921))
}

