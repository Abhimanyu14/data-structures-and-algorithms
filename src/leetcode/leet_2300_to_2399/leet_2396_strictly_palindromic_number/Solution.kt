package leetcode.leet_2300_to_2399.leet_2396_strictly_palindromic_number

/**
 * leetcode - https://leetcode.com/problems/strictly-palindromic-number/
 *
 * Using loops
 *
 * Stats
 * Runtime: 223 ms, faster than 63.27%
 * Memory Usage: 34.3 MB, less than 18.37%
 */
private fun isStrictlyPalindromic(n: Int): Boolean {
    for (i in 2..(n - 2)) {
        if (!isPalindromeInBaseX(n, i)) {
            return false
        }
    }
    return true
}

fun isPalindromeInBaseX(n: Int, b: Int): Boolean {
    val remList = mutableListOf<Int>()
    var temp = n
    while (temp != 0) {
        remList.add(temp % b)
        temp /= b
    }
    for (i in 0..(remList.lastIndex / 2)) {
        if (remList[i] == remList[remList.lastIndex - i]) {
            return false
        }
    }
    return true
}

private fun main() {

}
