package leetcode.leetcode_1891_cutting_ribbons

/**
 * leetcode - https://leetcode.com/problems/cutting-ribbons/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 * Premium question
 *
 * Data Structure - Two Pointers
 * Algorithm - Binary Search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space - O(1)
 *
 * Companies - Google, Meta
 */
private fun maxLength(ribbons: IntArray, k: Int): Int {
    var left = 1
    var right = ribbons.max() + 1
    fun canNotCut(x: Int): Boolean {
        var count = 0
        for (ribbon in ribbons) {
            count += (ribbon / x)
            if (count >= k) {
                return false
            }
        }
        return true
    }
    while (left < right) {
        val mid = left + (right - left) / 2
        if (canNotCut(mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left - 1
}

private fun maxLengthUsingBinarySearch(ribbons: IntArray, k: Int): Int {
    fun canCut(l: Int): Boolean {
        var count = 0
        for (ribbon in ribbons) {
            count += ribbon / l
            if (count >= k) {
                return true
            }
        }
        return false
    }

    var left = 1
    var right = ribbons.max() + 1

    while (left < right) {
        val mid = left + ((right - left) / 2)
        if (canCut(mid)) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left - 1
}

private fun main() {

}
