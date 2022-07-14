package leetcode.leet_1_two_sum

/**
 * Using loop
 *
 * Stats
 * Runtime: 279 ms, faster than 87.54%
 * Memory Usage: 38.9 MB, less than 85.06%
 */
private fun twoSumUsingLoop(nums: IntArray, target: Int): IntArray {
    for (i in nums.indices) {
        for (j in i + 1..nums.lastIndex) {
            if (nums[i] + nums[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }
    return intArrayOf()
}

/**
 * Using map
 *
 * Stats
 * Runtime: 218 ms, faster than 96.60%
 * Memory Usage: 38.2 MB, less than 87.41%
 */
private fun twoSumUsingMap(nums: IntArray, target: Int): IntArray {
    val map = hashMapOf<Int, Int>()
    nums.forEachIndexed { index, num ->
        map[target - num]?.let {
            return intArrayOf(it, index)
        }
        map[num] = index
    }
    return intArrayOf()
}

/**
 * Using diff map
 *
 * Stats
 * Runtime: 218 ms, faster than 96.60%
 * Memory Usage: 38.2 MB, less than 87.41%
 */
private fun twoSum(nums: IntArray, target: Int): IntArray {
    val diffMap = hashMapOf<Int, Int>()
    nums.forEachIndexed { index, num ->
        diffMap[num]?.let {
            return intArrayOf(it, index)
        }
        diffMap[target - num] = index
    }
    return intArrayOf()
}

fun main() {
    println(twoSum(intArrayOf(2, 7, 11, 15), 9).joinToString())
    println(twoSum(intArrayOf(3, 2, 4), 6).joinToString())
    println(twoSum(intArrayOf(3, 3), 6).joinToString())
    println(twoSum(intArrayOf(1, 4, 5, 3, 2), 4).joinToString())
    println(twoSum(intArrayOf(2, 2, 4, 3), 5).joinToString())
}
