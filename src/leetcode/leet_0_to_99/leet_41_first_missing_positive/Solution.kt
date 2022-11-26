package leetcode.leet_0_to_99.leet_41_first_missing_positive

/**
 * WIP Using Map
 *
 * Stats
 * Runtime: 1351 ms, faster than 48.69%
 * Memory Usage: 139 MB, less than 57.07%
 */
private fun firstMissingPositive(nums: IntArray): Int {
    var result = 1
    val hashSet = HashSet<Int>()
    nums.forEach {
        if (it > 0) {
            if (it == result) {
                result++
            } else {
                hashSet.add(it)
            }
        }
    }
    while (hashSet.contains(result)) result++
    return result
}

fun main() {
    println(firstMissingPositive(intArrayOf(1, 2, 0)))
    println(firstMissingPositive(intArrayOf(3, 4, -1, 1)))
    println(firstMissingPositive(intArrayOf(7, 8, 9, 11, 12)))
}
