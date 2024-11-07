package leetcode.leetcode_1343_number_of_sub_arrays_of_size_k_and_average_greater_than_or_equal_to_threshold

/**
 * leetcode - https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
 *
 * Using sliding window - single pass
 *
 * Stats
 * Runtime: 333 ms, faster than 66.67%
 * Memory Usage: 50 MB, less than 44.44%
 */
private fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {
    val target = k.toLong() * threshold
    var i = 0
    var current = 0L
    while (i < k) {
        current += arr[i]
        i++
    }
    var result = 0
    while (i < arr.size) {
        if (current >= target) {
            result++
        }
        current -= arr[i - k]
        current += arr[i]
        i++
    }
    if (current >= target) {
        result++
    }
    return result
}

private fun main() {

}
