package leetcode.leet_0_to_99.leet_85_maximal_rectangle

/**
 * leetcode - https://leetcode.com/problems/maximal-rectangle/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 249 ms, faster than 30.00%
 * Memory Usage: 40.2 MB, less than 97.50%
 *
 * Time -
 * Space -
 */
private fun maximalRectangle(matrix: Array<CharArray>): Int {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return 0
    }
    val colHeights = IntArray(matrix[0].size)
    fun getMaxArea(): Int {
        val stack = ArrayDeque<Int>()
        var max = 0
        colHeights.forEachIndexed { index, height ->
            while (stack.isNotEmpty() && height < colHeights[stack.last()]) {
                val shortest = colHeights[stack.removeLast()]
                val width = index - if (stack.isEmpty()) {
                    0
                } else {
                    (stack.last() + 1)
                }
                max = maxOf(max, shortest * width)
            }
            stack.addLast(index)
        }
        while (stack.isNotEmpty()) {
            val shortest = colHeights[stack.removeLast()]
            val width = colHeights.size - if (stack.isEmpty()) {
                0
            } else {
                (stack.last() + 1)
            }
            max = maxOf(max, shortest * width)
        }
        return max
    }
    var result = 0
    matrix.forEach { row ->
        row.forEachIndexed { index, item ->
            if (item == '1') {
                colHeights[index]++
            } else {
                colHeights[index] = 0
            }
        }
        result = maxOf(result, getMaxArea())
    }
    return result
}

private fun main() {

}
