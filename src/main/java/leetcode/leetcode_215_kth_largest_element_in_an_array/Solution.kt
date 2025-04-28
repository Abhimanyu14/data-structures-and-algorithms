package leetcode.leetcode_215_kth_largest_element_in_an_array

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Two Pointers
 * Algorithm - Quick Select
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun findKthLargest(nums: IntArray, k: Int): Int {
    fun quickSelect(start: Int, end: Int): Int {
        var left = start
        var right = end - 1
        while (left <= right) {
            if (nums[left] > nums[end]) {
                left++
            } else {
                nums[left] = nums[right].also {
                    nums[right] = nums[left]
                }
                right--
            }
        }
        nums[left] = nums[end].also {
            nums[end] = nums[left]
        }
        return left
    }
    var left = 0
    var right = nums.lastIndex
    var pivot = quickSelect(left, right)
    while (pivot != k - 1) {
        if (pivot > k - 1) {
            right = pivot - 1
        } else {
            left = pivot + 1
        }
        pivot = quickSelect(left, right)
    }
    return nums[k - 1]
}

private fun findKthLargestUsingSorting(nums: IntArray, k: Int): Int {
    return nums.sortedDescending()[k - 1]
}

/**
 * leetcode - https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Data Structure - Min Heap
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N * log(N))
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun findKthLargestUsingMinHeap(nums: IntArray, k: Int): Int {
    val minHeap = PriorityQueue<Int>()
    for (num in nums) {
        minHeap.offer(num)
        if (minHeap.size > k) {
            minHeap.poll()
        }
    }
    return minHeap.poll()
}

private fun main() {
    val input1 = intArrayOf(3, 2, 1, 5, 6, 4)
    val k1 = 2
    val input2 = intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6)
    val k2 = 4
    println(findKthLargest(input1, k1))
    println(findKthLargest(input2, k2))
}
