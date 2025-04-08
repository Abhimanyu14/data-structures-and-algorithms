package leetcode.leetcode_167_two_sum_ii_input_array_is_sorted

/**
 * leetcode - https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Data Structure - Two Pointers
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 277 ms, faster than 81.38%
 * Memory Usage: 40.4 MB, less than 78.99%
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun twoSum(numbers: IntArray, target: Int): IntArray {
    var left = 0
    var right = numbers.lastIndex
    var sum: Int
    while (left < right) {
        sum = numbers[left] + numbers[right]
        if (sum == target) {
            return intArrayOf(left + 1, right + 1)
        } else if (sum > target) {
            right--
        } else {
            left++
        }
    }
    return intArrayOf()
}

/**
 * leetcode - https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Data Structure - Iteration & Two Pointers
 * Algorithm - Binary Search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 853 ms, faster than 10.37%
 * Memory Usage: 46.2 MB, less than 75.53%
 *
 * Time - O(N * log(N))
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun twoSumUsingBinarySearch(numbers: IntArray, target: Int): IntArray {
    fun find(start: Int, toFind: Int): Int {
        var left = start
        var right = numbers.lastIndex
        while (left < right) {
            val mid = left + (right - left) / 2
            if (numbers[mid] >= toFind) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    for (i in 0..<numbers.lastIndex) {
        val pos = find(i + 1, target - numbers[i])
        if (numbers[pos] == target - numbers[i]) {
            return intArrayOf(i + 1, pos + 1)
        }
    }
    return intArrayOf()
}

/**
 * leetcode - https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Data Structure - Two Pointers
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 853 ms, faster than 10.37%
 * Memory Usage: 46.2 MB, less than 75.53%
 *
 * Time - O(N^2)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun twoSumUsingLoops(numbers: IntArray, target: Int): IntArray {
    var lastIndex = numbers.size - 1
    for (i in numbers.indices) {
        for (j in i + 1..lastIndex) {
            if (numbers[i] + numbers[j] == target) {
                return intArrayOf(i + 1, j + 1)
            } else if (numbers[i] + numbers[j] > target) {
                lastIndex = j - 1
            }
        }
    }
    return intArrayOf()
}

private fun main() {

}
