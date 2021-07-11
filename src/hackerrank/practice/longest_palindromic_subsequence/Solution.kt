package longest_palindromic_subsequence

// recursive
fun recursiveSolution(str: String, start: Int, end: Int, result: Int): Int {
    if (start == end) {
        return result + 1
    }
    return if (str[start] == str[end]) {
        recursiveSolution(str, start + 1, end - 1, result + 2)
    } else {
        maxOf(recursiveSolution(str, start + 1, end, result), recursiveSolution(str, start, end - 1, result))
    }
}

fun solution(str: String): Int {
    val dp = Array(str.length) { Array(str.length) { 0 } }
    for (i in str.indices) {
        dp[i][i] = 1
    }
    for (i in 0..str.length) {
        for (j in i + 1 until str.length) {
            if (i != j) {
                dp[j - i - 1][j] = if (str[j - i - 1] == str[j]) {
                    dp[j - i][j - 1] + 2
                } else {
                    maxOf(dp[j - i][j], dp[j - i - 1][j - 1])
                }
            }
        }
    }
    return dp[str.length - 1][str.length - 1]
}

// LPS
fun longestPalindromicSubsequence(str: String): Int {
    // return recursiveSolution(str, 0, str.length - 1, 0)
    return solution(str)
}

fun main() {
    val result = longestPalindromicSubsequence("BABCBAB")
    println(result)
}

fun printArray(arr: Array<Array<Int>>) {
    arr.forEach { arrItem ->
        arrItem.forEach {
            print("$it ")
        }
        println()
    }
}
