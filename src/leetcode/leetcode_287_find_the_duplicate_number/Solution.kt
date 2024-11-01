package leetcode.leetcode_287_find_the_duplicate_number

import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/find-the-duplicate-number/
 *
 * Using in place manipulation
 *
 * Stats
 * Runtime: 378 ms, faster than 86.87%
 * Memory Usage: 56.1 MB, less than 80.30%
 */
private fun findDuplicate(nums: IntArray): Int {
    nums.forEach { num ->
        if (nums[abs(num)] < 0) {
            return abs(num)
        } else {
            nums[abs(num)] = -nums[abs(num)]
        }
    }
    return -1
}

/**
 * leetcode - https://leetcode.com/problems/find-the-duplicate-number/
 *
 * Using Floyd's cycle detection
 *
 * Stats
 * Runtime: 423 ms, faster than 49.49%
 * Memory Usage: 58.2 MB, less than 13.64%
 */
private fun findDuplicateUsingFloyd(nums: IntArray): Int {
    var slow = 0
    var fast = 0

    while(true) {
        slow = nums[slow]
        fast = nums[nums[fast]]
        if (fast == slow) break
    }

    var slow2 = 0
    while(slow != slow2) {
        slow = nums[slow]
        slow2 = nums[slow2]
    }

    return slow
}

/**
 * leetcode - https://leetcode.com/problems/find-the-duplicate-number/
 *
 * Using Array as hashmap
 *
 * Stats
 * Runtime: 406 ms, faster than 64.60%
 * Memory Usage: 57.7 MB, less than 17.26%
 */
private fun findDuplicateUsingArray(nums: IntArray): Int {
    while (nums[0] != nums[nums[0]]) {
        nums[nums[0]] = nums[0].also {
            nums[0] = nums[nums[0]]
        }
    }
    return nums[0]
}

/**
 * leetcode - https://leetcode.com/problems/find-the-duplicate-number/
 *
 * Using Set
 *
 * Stats
 * Runtime: 476 ms, faster than 26.10%
 * Memory Usage: 59.2 MB, less than 5.31%
 */
private fun findDuplicateUsingSet(nums: IntArray): Int {
    val set = mutableSetOf<Int>()
    nums.forEach {
        if (set.contains(it)) {
            return it
        }
        set.add(it)
    }
    return -1
}

private fun main() {

}
