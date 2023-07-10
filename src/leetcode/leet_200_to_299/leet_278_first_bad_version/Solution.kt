package leetcode.leet_200_to_299.leet_278_first_bad_version

/**
 * leetcode - https://leetcode.com/problems/first-bad-version/
 * Using Binary Search
 *
 * Stats
 * Runtime: 229 ms, faster than 99.69%
 * Memory Usage: 33 MB, less than 85.91%
 */
private fun firstBadVersion(n: Int): Int {
    var low = 1
    var high = n
    while (low < high) {
        val mid = (low + ((high - low) / 2))
        if (isBadVersion(mid)) {
            high = mid
        } else {
            low = (mid + 1)
        }
    }
    return low
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
