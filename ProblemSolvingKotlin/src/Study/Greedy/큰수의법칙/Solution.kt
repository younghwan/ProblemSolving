package Study.Greedy.큰수의법칙

// 이것이 코딩테스트다 - 그리디(92p)
fun main() {
    var N = 5 //배열의 크기
    var M = 8 //숫자가 더해지는 횟수
    var K = 3 //숫자의 최대 연속횟수
    var arr = arrayOf(2, 4, 5, 4, 6)

    arr.sort()
    var ans = 0
    var tempK = K
    repeat(M) {
        if (tempK == 0) {
            ans += arr[N - 2]
            tempK = K
        } else {
            ans += arr[N - 1]
            tempK--
        }
    }
    println(ans)
}

// 이런식으로하면 큰수가 들어올때 시간초과가 생긴다. 반복되는 수열의 특징을 이용해 식을 짜서 풀수가있다. CodingTest.Coupang.Solution2 참고