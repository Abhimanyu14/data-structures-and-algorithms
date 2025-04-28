package leetcode.leetcode_31_next_permutation

/**
 * leetcode - https://leetcode.com/problems/next-permutation/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Two Pointers
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun nextPermutation(nums: IntArray) {
    fun reverse(start: Int) {
        var left = start
        var right = nums.lastIndex
        while (left < right) {
            nums[left] = nums[right].also {
                nums[right] = nums[left]
            }
            left++
            right--
        }
    }

    // Step 1: Find pivot index
    var pivot = nums.lastIndex - 1
    while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) {
        pivot--
    }

    if (pivot >= 0) {
        // Step 2: Find swap index
        var swap = nums.lastIndex
        while (nums[swap] <= nums[pivot]) {
            swap--
        }

        // Step 3: Swap values at pivot and swap
        nums[swap] = nums[pivot].also {
            nums[pivot] = nums[swap]
        }
    }

    // Step 4: Reverse numbers after pivot index
    reverse(pivot + 1)
}

private fun main() {

}
