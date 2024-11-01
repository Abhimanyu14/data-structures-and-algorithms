package leetcode.leetcode_2300_to_2399.leetcode_2396_strictly_palindromic_number

/**
 * Using list
 *
 * leetcode - https://leetcode.com/problems/strictly-palindromic-number/
 *
 * Stats
 * Runtime: 143 ms, faster than 84.62%
 * Memory Usage: 33.5 MB, less than 57.69%
 */
private fun isStrictlyPalindromicUsingList(n: Int): Boolean {
    fun isPalindromeInBaseX(n: Int, b: Int): Boolean {
        val remList = mutableListOf<Int>()
        var temp = n
        while (temp != 0) {
            remList.add(temp % b)
            temp /= b
        }
        for (i in 0..(remList.lastIndex / 2)) {
            if (remList[i] != remList[remList.lastIndex - i]) {
                return false
            }
        }
        return true
    }
    for (i in 2..(n - 2)) {
        if (!isPalindromeInBaseX(n, i)) {
            return false
        }
    }
    return true
}

/**
 * Using string builder - more memory for less runtime
 *
 * leetcode - https://leetcode.com/problems/strictly-palindromic-number/
 *
 * Stats
 * Runtime: 129 ms, faster than 100.00%
 * Memory Usage: 33.9 MB, less than 38.46%
 */
private fun isStrictlyPalindromicUsingStringBuilder(n: Int): Boolean {
    fun isPalindromeInBaseX(n: Int, b: Int): Boolean {
        val sb = StringBuilder()
        var temp = n
        while (temp != 0) {
            sb.append(temp % b)
            temp /= b
        }
        for (i in 0..(sb.lastIndex / 2)) {
            if (sb[i] != sb[sb.lastIndex - i]) {
                return false
            }
        }
        return true
    }
    for (i in 2..(n - 2)) {
        if (!isPalindromeInBaseX(n, i)) {
            return false
        }
    }
    return true
}

/**
 * Using string builder and reversed
 *
 * leetcode - https://leetcode.com/problems/strictly-palindromic-number/
 *
 * Stats
 * Runtime: 137 ms, faster than 92.31%
 * Memory Usage: 34.3 MB, less than 30.77%
 */
private fun isStrictlyPalindromicUsingReversed(n: Int): Boolean {
    fun isPalindromeInBaseX(n: Int, b: Int): Boolean {
        val sb = StringBuilder()
        var temp = n
        while (temp != 0) {
            sb.append(temp % b)
            temp /= b
        }
        return sb.toString() == sb.toString().reversed()
    }
    for (i in 2..(n - 2)) {
        if (!isPalindromeInBaseX(n, i)) {
            return false
        }
    }
    return true
}

/**
 * Using toString(radix)
 *
 * leetcode - https://leetcode.com/problems/strictly-palindromic-number/
 *
 * Stats
 * Runtime: 164 ms, faster than 65.38%
 * Memory Usage: 34.9 MB, less than 23.08%
 */
private fun isStrictlyPalindromicUsingToString(n: Int): Boolean {
    fun isPalindromeInBaseX(n: Int, b: Int): Boolean {
        val sb = n.toString(b)
        for (i in 0..(sb.lastIndex / 2)) {
            if (sb[i] != sb[sb.lastIndex - i]) {
                return false
            }
        }
        return true
    }
    for (i in 2..(n - 2)) {
        if (!isPalindromeInBaseX(n, i)) {
            return false
        }
    }
    return true
}

private fun main() {

}
