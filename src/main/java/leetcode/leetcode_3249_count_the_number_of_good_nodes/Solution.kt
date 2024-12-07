package leetcode.leetcode_3249_count_the_number_of_good_nodes

/**
 * leetcode - https://leetcode.com/problems/count-the-number-of-good-nodes/
 *
 * Data Structure - Two Pointers
 * Algorithm - Binary Search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 52 ms, faster than 100.00%
 * Memory Usage: 57.9 MB, less than 100.00%
 *
 * Time -  O(N * log(N))
 * Space - O(1)
 */
private fun minimumSize(nums: IntArray, maxOperations: Int): Int {
    fun isPossible(x: Int): Boolean {
        var count = 0
        nums.forEach {
            count += (it / x) - 1
            if (it % x != 0) {
                count++
            }
            if (count > maxOperations) {
                return false
            }
        }
        return count <= maxOperations
    }

    var left = 1
    var right = nums.max()
    while (left < right) {
        val mid = left + ((right - left) / 2)
        if (isPossible(mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

private fun main() {

}
