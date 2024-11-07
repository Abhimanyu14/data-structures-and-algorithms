package data_structures_and_algorithms.common

/**
 * Palindrome string
 *
 * Using string - reversed()
 */
private fun isPalindrome(str: String): Boolean {
    return str == str.reversed()
}

/**
 * Palindrome string
 *
 * Using iteration
 */
private fun isPalindromeUsingIteration(str: String): Boolean {
    for (i in 0..(str.lastIndex / 2)) {
        if (str[i] != str[str.lastIndex - i]) {
            return false
        }
    }
    return true
}

private fun main() {
    println(isPalindrome("Aba"))
    println(isPalindrome("AbA"))
    println(isPalindrome("abab"))
}
