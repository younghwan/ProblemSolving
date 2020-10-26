package SW

fun lastLetters(word: String): String {
    // Write your code here
    var ans = "${word[word.length-1]} ${word[word.length-2]}"
    return ans
}

fun main() {
    println(lastLetters("APPLE"))
}

