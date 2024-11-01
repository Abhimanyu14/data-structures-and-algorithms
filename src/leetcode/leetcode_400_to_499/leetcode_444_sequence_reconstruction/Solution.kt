package leetcode.leetcode_400_to_499.leetcode_444_sequence_reconstruction

/**
 * leetcode - https://leetcode.com/problems/sequence-reconstruction/
 *
 * TODO(Abhi) - To revisit
 *
 * Using Topological sort
 * Use contentEquals for array content equality check
 *
 * Stats
 * Runtime: 475 ms, faster than 47.06%
 * Memory Usage: 48.5 MB, less than 70.59%
 */
private fun sequenceReconstruction(nums: IntArray, sequences: List<List<Int>>): Boolean {
    val inDegrees = MutableList(nums.size + 1) { 0 }
    val graph = mutableMapOf<Int, MutableList<Int>>()
    sequences.forEach {
        for (i in 1..it.lastIndex) {
            graph.computeIfAbsent(it[i - 1]) {
                mutableListOf()
            }.add(it[i])
            inDegrees[it[i]]++
        }
    }

    val queue = ArrayDeque<Int>()
    for (i in 1..inDegrees.lastIndex) {
        if (inDegrees[i] == 0) {
            queue.addLast(i)
        }
    }
    val result = mutableListOf<Int>()
    while (queue.isNotEmpty()) {
        if (queue.size != 1) {
            return false
        }
        val temp = queue.removeFirst()
        graph[temp]?.forEach {
            inDegrees[it]--
            if (inDegrees[it] == 0) {
                queue.addLast(it)
            }
        }
        result.add(temp)
    }
    return nums contentEquals result.toIntArray()
}

private fun main() {

}
