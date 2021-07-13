package hackerrank.practice.highest_value_palindrome

import kotlin.math.max

fun toPalindrome(s: String): Int {
    var i = 0
    var changes = 0
    while (i <= (s.length - 1) / 2) {
        if (s[i] != s[s.length - 1 - i]) {
            changes++
        }
        i++
    }
    return changes
}

fun highestValuePalindrome(s: String, n: Int, k: Int): String {
    val changes = toPalindrome(s)
    val result = s.toCharArray()
    when {
        k < changes -> {
            return "-1"
        }
        k == changes -> {
            var i = 0
            while (i <= (s.length - 1) / 2) {
                if (result[i] != result[result.size - 1 - i]) {
                    result[i] = max(result[i].code, result[result.size - 1 - i].code).toChar()
                    result[result.size - 1 - i] = max(result[i].code, result[result.size - 1 - i].code).toChar()
                }
                i++
            }
            return result.joinToString("")
        }
        else -> {
            val increase = k - changes
            // TODO
        }
    }
    return "No result"
}

fun main() {
    val result = highestValuePalindrome("3943", 4, 1)
    println(result)
}
