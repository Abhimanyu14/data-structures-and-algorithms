package leetcode.leetcode_1313_decompress_run_length_encoded_list

/**
 * leetcode - https://leetcode.com/problems/decompress-run-length-encoded-list/
 *
 * Using
 *
 * Stats
 * Runtime: 245 ms, faster than 95.24%
 * Memory Usage: 36.4 MB, less than 100.00%
 */
private fun decompressRLElist(nums: IntArray): IntArray {
    val result = mutableListOf<Int>()
    var i = 0
    while (i < nums.size) {
        result.addAll(MutableList(nums[i]) { nums[i + 1] })
        i += 2
    }
    return result.toIntArray()
}

private fun main() {

}
