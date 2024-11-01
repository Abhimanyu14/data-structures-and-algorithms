package leetcode.leetcode_278_first_bad_version

/**
 * leetcode - https://leetcode.com/problems/first-bad-version/
 *
 * Using Binary Search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Stats
 * Runtime: 264 ms, faster than 39.92%
 * Memory Usage: 32.9 MB, less than 78.66%
 */
private fun firstBadVersion(n: Int): Int {
    var left = 1
    var right = n
    while (left < right) {
        val mid = left + ((right - left) / 2)
        if (isBadVersion(mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

private fun isBadVersion(n: Int): Boolean {
    // return n >= 4
    // return n >= 1
    return n >= 1702766719
}

private fun main() {
    // println(firstBadVersion(5)) // bad = 4
    // println(firstBadVersion(1)) // bad = 1
    println(firstBadVersion(2126753390)) // bad = 1702766719
}
