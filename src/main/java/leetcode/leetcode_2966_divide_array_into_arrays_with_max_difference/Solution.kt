package leetcode.leetcode_2966_divide_array_into_arrays_with_max_difference

/**
 * leetcode - https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/?envType=daily-question&envId=2025-06-18
 *
 * Data Structure - [Array], [IntArray]
 * Algorithm - Sorting
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N * log(N))
 * Space - O(N)
 *
 * Companies - Amazon, Google
 */
private fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
    val subArraysCount = nums.size / 3
    val result = Array(subArraysCount) {
        IntArray(3)
    }
    val sortedNums = nums.sorted()
    for (i in 0..<subArraysCount) {
        for (j in 0..2) {
            result[i][j] = sortedNums[(i * 3) + j]
        }
        if (result[i][2] - result[i][0] > k) {
            return arrayOf()
        }
    }
    return result
}

private fun main() {

}
