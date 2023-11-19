package leetcode.leet_1800_to_1899.leet_1887_reduction_operations_to_make_the_array_elements_equal

/**
 * leetcode - https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/
 *
 * Using sorting
 *
 * Stats
 * Runtime: 498 ms, faster than 100.00%
 * Memory Usage: 52.7 MB, less than 100.00%
 */
private fun reductionOperations(nums: IntArray): Int {
    var result = 0
    nums.sort()
    var element = 0
    var prev = nums[0]
    nums.forEach {
        if (it != prev) {
            element++
            prev = it
        }
        result += element
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/
 *
 * Using Map, Set, List and sorting
 *
 * Stats
 * Runtime: 920 ms, faster than 100.00%
 * Memory Usage: 52.5 MB, less than 100.00%
 */
private fun reductionOperationsUsingMap(nums: IntArray): Int {
    var result = 0
    val counter = mutableMapOf<Int, Int>()
    nums.forEach {
        counter[it] = counter.getOrDefault(it, 0) + 1
    }
    val keys = counter.keys.toList().sorted()
    keys.forEachIndexed { index, i ->
        result += index * counter.getOrDefault(i, 0)
    }
    return result
}

private fun main() {

}
