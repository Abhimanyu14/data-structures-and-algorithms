package leetcode.leet_800_to_899.leet_885_spiral_matrix_iii

/**
 * leetcode - https://leetcode.com/problems/spiral-matrix-iii/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun spiralMatrixIII(rows: Int, cols: Int, rStart: Int, cStart: Int): Array<IntArray> {
    // Store all possible directions in an array.
    var rStartValue = rStart
    var cStartValue = cStart
    val dir = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
    val traversed = Array(rows * cols) { IntArray(2) }
    var idx = 0

    // Initial step size is 1, value of d represents the current direction.
    var step = 1
    var direction = 0
    while (idx < rows * cols) {
        // direction = 0 -> East, direction = 1 -> South
        // direction = 2 -> West, direction = 3 -> North
        for (i in 0..1) {
            for (j in 0..<step) {
                // Validate the current position
                if (rStartValue in 0..<rows && cStartValue >= 0 && cStartValue < cols
                ) {
                    traversed[idx][0] = rStartValue
                    traversed[idx][1] = cStartValue
                    ++idx
                }
                // Make changes to the current position.
                rStartValue += dir[direction][0]
                cStartValue += dir[direction][1]
            }

            direction = (direction + 1) % 4
        }
        ++step
    }
    return traversed
}

private fun main() {

}
