package leetcode.leet_200_to_299.leet_215_kth_largest_element_in_an_array

import algorithms.searching.quickSelectDriver

fun findKthLargest(nums: IntArray, k: Int): Int {
    return quickSelectDriver(nums, nums.size - k + 1)
}

private fun main() {
    val input1 = intArrayOf(3, 2, 1, 5, 6, 4)
    val k1 = 2
    val input2 = intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6)
    val k2 = 4
    println(findKthLargest(input1, k1))
    println(findKthLargest(input2, k2))
}
