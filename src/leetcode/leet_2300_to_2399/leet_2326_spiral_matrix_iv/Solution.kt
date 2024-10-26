package leetcode.leet_2300_to_2399.leet_2326_spiral_matrix_iv

import data_structures_and_algorithms.linkedlist.ListNode
import java.util.Arrays
import kotlin.math.min


/**
 * leetcode - https://leetcode.com/problems/spiral-matrix-iv/
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
private fun spiralMatrix(m: Int, n: Int, head: ListNode): Array<IntArray> {
    // Store the east, south, west, north movements in a matrix.
    var headCopy: ListNode? = head
    var i = 0
    var j = 0
    var curD = 0
    val movement = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(-1, 0),
    )
    val res = Array(m) { IntArray(n) }
    for (row in res) {
        Arrays.fill(row, -1)
    }

    while (headCopy != null) {
        res[i][j] = headCopy.`val`
        val newI = i + movement[curD][0]
        val newJ = j + movement[curD][1]

        // If we bump into an edge or an already filled cell, change the
        // direction.
        if (min(newI.toDouble(), newJ.toDouble()) < 0 || newI >= m || newJ >= n || res[newI][newJ] != -1
        ) curD = (curD + 1) % 4
        i += movement[curD][0]
        j += movement[curD][1]

        headCopy = headCopy.next
    }

    return res
}

private fun main() {

}
