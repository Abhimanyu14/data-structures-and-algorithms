package leetcode.leetcode_3011_find_if_array_can_be_sorted

/**
 * leetcode - https://leetcode.com/problems/find-if-array-can-be-sorted/?envType=daily-question&envId=2024-11-06
 *
 * TODO(Abhi) - To revisit
 *
 * Using bubble sort
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 11 ms, faster than 100.00%
 * Memory Usage: 38.8 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun canSortArray(nums: IntArray): Boolean {
    val values = nums.clone()
    for (i in values.indices) {
        for (j in 0..<values.size - i - 1) {
            if (values[j] <= values[j + 1]) {
                continue
            } else {
                if (values[j].countOneBits() == values[j + 1].countOneBits()) {
                    values[j] = values[j + 1].also {
                        values[j + 1] = values[j]
                    }
                } else {
                    return false
                }
            }
        }
    }
    return true
}

private fun main() {

}
