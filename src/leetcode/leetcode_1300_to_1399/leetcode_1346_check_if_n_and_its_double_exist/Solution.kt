package leetcode.leetcode_1300_to_1399.leetcode_1346_check_if_n_and_its_double_exist

/**
 * leetcode - https://leetcode.com/problems/check-if-n-and-its-double-exist/
 *
 * Using set
 *
 * Stats
 * Runtime: 188 ms, faster than 28.12%
 * Memory Usage: 36.2 MB, less than 96.88%
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
