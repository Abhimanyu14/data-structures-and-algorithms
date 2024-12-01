package leetcode.leetcode_1346_check_if_n_and_its_double_exist

/**
 * leetcode - https://leetcode.com/problems/check-if-n-and-its-double-exist/
 *
 * Data Structure - Set
 * Algorithm - Iteration
 *
 * Stats
 * Runtime: 3 ms, faster than 85.29%
 * Memory Usage: 38.1 MB, less than 22.81%
 *
 * Time - O(N)
 * Space - O(N)
 */
fun checkIfExist(arr: IntArray): Boolean {
    val set = mutableSetOf<Int>()
    arr.forEach {
        if (set.contains(it * 2) || (it % 2 == 0 && set.contains(it / 2))) {
            return true
        }
        set.add(it)
    }
    return false
}

private fun main() {

}
