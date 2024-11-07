package leetcode.leetcode_167_two_sum_ii___input_array_is_sorted

/**
 * leetcode - https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Using pointers
 *
 * Stats
 * Runtime: 277 ms, faster than 81.38%
 * Memory Usage: 40.4 MB, less than 78.99%
 */
private fun twoSum(numbers: IntArray, target: Int): IntArray {
    var first = 0
    var last = numbers.lastIndex
    var sum: Int
    while (true) {
        sum = numbers[first] + numbers[last]
        if (sum == target) {
            return intArrayOf(first + 1, last + 1)
        } else if (sum > target) {
            last--
        } else {
            first++
        }
    }
}

/**
 * leetcode - https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Using loops
 *
 * Stats
 * Runtime: 853 ms, faster than 10.37%
 * Memory Usage: 46.2 MB, less than 75.53%
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
    println(twoSum(intArrayOf(2, 7, 11, 15), 9).joinToString(", "))
    println(twoSum(intArrayOf(2, 3, 4, 10, 11), 6).joinToString(", "))
    println(twoSum(intArrayOf(-1, 0), -1).joinToString(", "))
}
