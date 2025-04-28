package leetcode.leetcode_18_4sum


/**
 * leetcode - https://leetcode.com/problems/4sum/description/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
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
internal class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        return kSum(nums.sorted(), target, 0, 4)
    }

    private fun kSum(nums: List<Int>, target: Int, start: Int, k: Int): List<List<Int>> {
        val res: MutableList<MutableList<Int>> = ArrayList()

        // If we have run out of numbers to add, return res.
        if (start == nums.size) {
            return res
        }

        // There are k remaining values to add to the sum. The
        // average of these values is at least target / k.
        val averageValue = target / k

        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if (nums[start] > averageValue || averageValue > nums[nums.size - 1]) {
            return res
        }

        if (k == 2) {
            return twoSum(nums, target, start)
        }

        for (i in start..<nums.size) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (subset in kSum(
                    nums,
                    target - nums[i],
                    i + 1,
                    k - 1
                )) {
                    res.add(ArrayList(listOf(nums[i])))
                    res[res.size - 1].addAll(subset)
                }
            }
        }

        return res
    }

    private fun twoSum(nums: List<Int>, target: Int, start: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        var left = start
        var right = nums.lastIndex
        while (left < right) {
            val currentSum = nums[left] + nums[right]
            if (currentSum < target || (left > start && nums[left] == nums[left - 1])) {
                left++
            } else if (currentSum > target || (right < nums.lastIndex && nums[right] == nums[right + 1])) {
                right--
            } else {
                result.add(listOf(nums[left], nums[right]))
                left++
                right--
            }
        }

        return result
    }
}

internal class Solution1 {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        return kSum(nums.sorted(), target, 0, 4)
    }

    private fun kSum(nums: List<Int>, target: Int, start: Int, k: Int): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()

        // If we have run out of numbers to add, return res.
        if (start == nums.size) {
            return result
        }

        // There are k remaining values to add to the sum. The
        // average of these values is at least target / k.
        val averageValue = target / k

        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if (nums[start] > averageValue || averageValue > nums[nums.size - 1]) {
            return result
        }

        if (k == 2) {
            return twoSum(nums, target, start)
        }

        for (i in start..nums.lastIndex) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (subset in kSum(nums, target - nums[i], i + 1, k - 1)) {
                    result.add(ArrayList(listOf(nums[i])))
                    result[result.size - 1].addAll(subset)
                }
            }
        }

        return result
    }

    private fun twoSum(nums: List<Int>, target: Int, start: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val set = mutableSetOf<Int>()
        for (i in start..nums.lastIndex) {
            if (result.isEmpty() || result.last()[1] != nums[i]) {
                if (set.contains(target - nums[i])) {
                    result.add(listOf(target - nums[i], nums[i]))
                }
            }
            set.add(nums[i])
        }
        return result
    }
}

private fun main() {

}
