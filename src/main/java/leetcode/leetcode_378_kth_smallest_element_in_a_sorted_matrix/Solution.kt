package leetcode.leetcode_378_kth_smallest_element_in_a_sorted_matrix

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 *
 * Data Structure - [PriorityQueue] (MinHeap)
 * Algorithm - Heap
 *
 * Using custom PriorityQueue comparator
 *
 * PriorityQueue methods - [PriorityQueue.offer], [PriorityQueue.poll]
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(k)
 * Space - O(matrix.length)
 *
 * Companies - Meta
 */
private fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
    val minHeap = PriorityQueue<Triple<Int, Int, Int>> { a, b -> // Value, Row, Col
        a.first - b.first
    }
    for (i in matrix.indices) {
        minHeap.offer(Triple(matrix[i][0], i, 0))
    }
    repeat(k - 1) {
        val (value, row, col) = minHeap.poll()
        if (col < matrix[0].lastIndex) {
            minHeap.offer(Triple(matrix[row][col + 1], row, col + 1))
        }
    }
    return minHeap.poll().first
}

private fun kthSmallestUsingPointersArray(matrix: Array<IntArray>, k: Int): Int {
    val pointers = IntArray(matrix.size)
    val minHeap = PriorityQueue<Pair<Int, Int>> { a, b ->
        if (a.first > b.first) {
            1
        } else if (a.first == b.first) {
            0
        } else {
            -1
        }
    }
    for (i in matrix.indices) {
        minHeap.offer(Pair(matrix[i][0], i))
    }
    for (i in 0..(k - 2)) {
        val row = minHeap.poll().second
        pointers[row]++
        if (pointers[row] <= matrix[0].lastIndex) {
            minHeap.offer(Pair(matrix[row][pointers[row]], row))
        }
    }
    return minHeap.poll().first
}

private fun main() {

}
