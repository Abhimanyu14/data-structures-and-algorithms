package leetcode.leet_0_to_99.leet_9_palindrome_number

/**
 * Using loops
 *
 * Stats
 * Runtime: 242 ms, faster than 94.89%
 * Memory Usage: 35.3 MB, less than 93.90%
 */
private fun isPalindromeUsingLoops(x: Int): Boolean {
    if (x < 0) {
        return false
    }
    val arr = x.toDigitsInReverse()
    for (i in 0..((arr.size - 1) / 2)) {
        if (arr[i] != arr[arr.size - i - 1]) {
            return false
        }
    }
    return true
}

/**
 * Using loops
 *
 * Stats
 * Runtime: 354 ms, faster than 80.07%
 * Memory Usage: 39.9 MB, less than 36.81%
 */
private fun isPalindromeUsingTwoPointer(x: Int): Boolean {
    if (x < 0) {
        return false
    }
    val arr = x.toDigitsInReverse()
    var start = 0
    var end = arr.lastIndex
    while (start < end) {
        if (arr[start] != arr[end]) {
            return false
        } else {
            start++
            end--
        }
    }
    return true
}

/**
 * Using recursion
 *
 * Stats
 * Runtime: 241 ms, faster than 95.18%
 * Memory Usage: 35.7 MB, less than 90.28%
 */
private fun isPalindrome(x: Int): Boolean {
    if (x < 0) {
        return false
    }
    val arr = x.toDigitsInReverse()

    return isPalindromeHelper(arr, 0, arr.size - 1)
}

private fun isPalindromeHelper(arr: List<Int>, start: Int, end: Int): Boolean {
    if (start >= end) {
        return true
    }
    if (arr[start] != arr[end]) {
        return false
    }
    return isPalindromeHelper(arr, start + 1, end - 1)
}

// Performs better than .toString.toCharArray()
fun Int.toDigitsInReverse(): List<Int> {
    val digits = mutableListOf<Int>()
    var temp = this
    do {
        digits.add(temp % 10)
        temp /= 10
    } while (temp > 0)
    return digits
}

private fun main() {
    println(isPalindrome(121))
    println(isPalindrome(-121))
    println(isPalindrome(10))
    println(isPalindrome(0))
    println(isPalindrome(11))
}
