package leetcode.leetcode_1502_can_make_arithmetic_progression_from_sequence

/**
 * leetcode - https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - Array, Set
 * Algorithm - Iteration, Simulation
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Google, Meta, Amazon
 */
private fun canMakeArithmeticProgression(arr: IntArray): Boolean {
    var maxValue = arr[0]
    var minValue = arr[0]
    for (num in arr) {
        maxValue = maxOf(maxValue, num)
        minValue = minOf(minValue, num)
    }
    val maxMinDiff = (maxValue - minValue)
    if (maxMinDiff % (arr.size - 1) != 0) {
        return false
    }
    if (maxMinDiff == 0) {
        return true
    }
    val diff = maxMinDiff / (arr.size - 1)
    val set = mutableSetOf<Int>()
    for (i in minValue..maxValue step diff) {
        set.add(i)
    }
    for (num in arr) {
        if (set.contains(num)) {
            set.remove(num)
        } else {
            return false
        }
    }
    return true
}

/**
 * leetcode - https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - Array
 * Algorithm - Sorting
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N * log(N))
 * Space - O(N)
 *
 * Companies - Google, Meta, Amazon
 */
private fun canMakeArithmeticProgressionUsingSorting(arr: IntArray): Boolean {
    val sorted = arr.sorted()
    val diff = sorted[1] - sorted[0]
    for (i in 2 until sorted.size) {
        if (sorted[i] - sorted[i - 1] != diff) {
            return false
        }
    }
    return true
}
