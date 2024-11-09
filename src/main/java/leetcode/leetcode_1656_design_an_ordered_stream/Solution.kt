package leetcode.leetcode_1656_design_an_ordered_stream

/**
 * leetcode - https://leetcode.com/problems/design-an-ordered-stream/description/
 *
 * Using array
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 170 ms, faster than 40.00%
 * Memory Usage: 60.2 MB, less than 44.44%
 *
 * Time -
 * Space -
 */
private class OrderedStream(n: Int) {
    val items = Array<String?>(n) { null }
    var start = 0

    fun insert(idKey: Int, value: String): List<String> {
        val result = mutableListOf<String>()
        items[idKey] = value
        while (start <= items.lastIndex && items[start] != null) {
            result.add(items[start].orEmpty())
            start++
        }
        return result
    }
}

private fun main() {

}
