package leetcode.leet_5_longest_palindromic_substring

import kotlin.math.floor

fun isPalindrome(str: String): Boolean {
    for (i in 0 until floor((str.length / 2).toDouble()).toInt()) {
        if (str[i] != str[str.length - i - 1]) {
            return false
        }
    }
    return true
}

// TODO: Find an optimal solution
fun longestPalindrome(s: String): String {
    if (s.isEmpty() || s.length == 1 || isPalindrome(s)) {
        return s
    }
    val x = longestPalindrome(s.substring(0, s.length - 1))
    val y = longestPalindrome(s.substring(1, s.length))
    return if (x.length > y.length) {
        x
    } else {
        y
    }
}

fun main() {
    val input = "babad"
    val input1 = "cbbd"
    val input2 = "a"
    val input3 = "ac"

    // This requires more optimal solution
    val input4 = "babaddtattarrattatddetartrateedredividerb"
    println(longestPalindrome(input))
    println(longestPalindrome(input1))
    println(longestPalindrome(input2))
    println(longestPalindrome(input3))
    // println(longestPalindrome(input4))
}
