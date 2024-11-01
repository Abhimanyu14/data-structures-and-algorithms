package leetcode.leetcode_1200_to_1299.leetcode_1287_element_appearing_more_than_25_in_sorted_array

/**
 * leetcode - https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 *
 * Using linear search with look ahead
 *
 * Stats
 * Runtime: 201 ms, faster than 70.00%
 * Memory Usage: 39.7 MB, less than 10.00%
 */
private fun findSpecialInteger(arr: IntArray): Int {
    val window = arr.size / 4
    arr.forEachIndexed { index, item ->
        if (item == arr[index + window]) {
            return item
        }
    }
    return -1
}

/**
 * leetcode - https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 *
 * Using linear search
 *
 * Stats
 * Runtime: 206 ms, faster than 60.00%
 * Memory Usage: 39.5 MB, less than 20.00%
 */
private fun findSpecialIntegerUsingLinearSearch(arr: IntArray): Int {
    if (arr.size == 1) {
        return arr[0]
    }
    var prev = arr[0]
    var count = 1
    for (i in 1..arr.lastIndex) {
        if (arr[i] == prev) {
            count++
            if (count > arr.size / 4F) {
                return prev
            }
        } else {
            count = 1
            prev = arr[i]
        }
    }
    return -1
}

private fun main() {

}
