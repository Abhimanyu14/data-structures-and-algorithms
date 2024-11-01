package leetcode.leetcode_1400_to_1499.leetcode_1441_build_an_array_with_stack_operations


/**
 * leetcode - https://leetcode.com/problems/build-an-array-with-stack-operations/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 * Runtime: 170 ms, faster than 50.00%
 * Memory Usage: 36.2 MB, less than 50.00%
 */
private fun buildArray(target: IntArray, n: Int): List<String> {
    val result = mutableListOf<String>()
    var i = 0
    for (num in target) {
        while (i < num - 1) {
            result.add("Push")
            result.add("Pop")
            i++
        }
        result.add("Push")
        i++
    }
    return result
}

private fun main() {

}
