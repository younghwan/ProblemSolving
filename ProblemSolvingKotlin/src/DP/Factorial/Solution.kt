package DP.Factorial

//팩토리얼의 경우 한번 테이블을 만들어두면 편해진다

lateinit var arr: Array<Int>

fun facto(i: Int): Int {
    if (i == 1) return 1
    if (i == 0) return 1
    else {
        if(arr[i-1] == 1){
            arr[i-1] = i * facto(i - 1)
            return arr[i-1]
        }
        else{
            return arr[i-1]
        }
    }
}

fun main() {
    var n = 10
    arr = Array(n){1}

    facto(n)

    for(i in arr){
        println(i)
    }

}
