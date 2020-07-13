package String.ScoreOfParentheses

class SolutionByKotilin {
    fun scoreOfParentheses(S: String): Int {
        var depth = 0.toDouble()
        var result = 0.toDouble()
        for (i in S.indices) {
            if (S[i] == '(') depth++
            else depth--
            if(S[i] == ')' && S[i-1] == '(') result += Math.pow(2.0,depth)
        }
        return result.toInt()
    }
}