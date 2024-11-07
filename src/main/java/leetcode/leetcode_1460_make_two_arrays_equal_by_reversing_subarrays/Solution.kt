package leetcode.leetcode_1460_make_two_arrays_equal_by_reversing_subarrays

/**
 * leetcode - https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/
 *
 * Using counter map
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
    val counter = mutableMapOf<Int, Int>()
    target.forEach {
        counter[it] = counter.getOrDefault(it, 0) + 1
    }
    arr.forEach {
        counter[it] = counter.getOrDefault(it, 0) - 1
        if (counter.getOrDefault(it, 0) == -1) {
            return false
        }
    }
    return true
}

private fun main() {

}
