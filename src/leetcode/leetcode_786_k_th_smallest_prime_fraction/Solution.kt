package leetcode.leetcode_786_k_th_smallest_prime_fraction

import java.util.PriorityQueue



/**
 * leetcode - https://leetcode.com/problems/k-th-smallest-prime-fraction/?envType=daily-question&envId=2024-05-10
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray? {
    // Create a priority queue to store pairs of fractions
    var k = k
    val priorityQueue = PriorityQueue { a: DoubleArray, b: DoubleArray ->
        java.lang.Double.compare(
            b[0],
            a[0]
        )
    }

    // Push the fractions formed by dividing each element by
    // the largest element into the priority queue
    for (i in arr.indices) {
        priorityQueue.offer(
            doubleArrayOf(
                -1.0 * arr[i] / arr[arr.size - 1],
                i.toDouble(),
                (arr.size - 1).toDouble()
            )
        )
    }

    // Iteratively remove the top element (smallest fraction)
    // and replace it with the next smallest fraction
    while (--k > 0) {
        val cur = priorityQueue.poll()
        val numeratorIndex = cur[1].toInt()
        val denominatorIndex = cur[2].toInt() - 1
        if (denominatorIndex > numeratorIndex) {
            priorityQueue.offer(
                doubleArrayOf(
                    -1.0 * arr[numeratorIndex] / arr[denominatorIndex],
                    numeratorIndex.toDouble(),
                    denominatorIndex.toDouble()
                )
            )
        }
    }

    // Retrieve the kth smallest fraction from
    // the top of the priority queue
    val result = priorityQueue.poll()
    return intArrayOf(arr[result[1].toInt()], arr[result[2].toInt()])
}

private fun main() {

}
