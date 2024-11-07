package leetcode.leetcode_1608_special_array_with_x_elements_greater_than_or_equal_x

/**
 * leetcode - https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
 *
 * Using loops
 *
 * Stats
 * Runtime: 256 ms, faster than 69.23%
 * Memory Usage: 37 MB, less than 7.69%
 */
private fun specialArray(nums: IntArray): Int {
    nums.sort()
    var x: Int
    var pos = nums.size - 1
    while (pos >= 0) {
        x = nums[pos]
        while (x > (nums.size - pos) && (pos == 0 || x > (nums[pos - 1] + 1))) {
            x--
        }
        if ((nums.size - pos) == x && (pos == 0 || x != nums[pos - 1])) {
            return x
        }
        pos--
    }
    return -1
}

/**
 * Using count - Memory efficient but slower
 *
 * Stats
 * Runtime: 296 ms, faster than 23.08%
 * Memory Usage: 34.8 MB, less than 61.54%
 */
fun specialArrayUsingCount(a: IntArray): Int {
    for (i in 1..a.size) if (a.count { it >= i } == i) return i
    return -1
}

private fun main() {

}
