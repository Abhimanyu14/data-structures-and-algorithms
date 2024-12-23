package leetcode.leetcode_2471_minimum_number_of_operations_to_sort_a_binary_tree_by_level

import data_structures_and_algorithms.TreeNode
import java.util.LinkedList

/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Tree
 * Algorithm - BFS and Map
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 83 ms, faster than 100.00%
 * Memory Usage: 61.6 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun minimumOperationsUsingMap(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    fun getSwapCount(nums: IntArray): Int {
        var swapCount = 0
        val sortedNums = nums.sortedArray()
        val positionMap = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            positionMap[nums[i]] = i
        }
        for (i in nums.indices) {
            if (nums[i] != sortedNums[i]) {
                swapCount++
                // Update position of swapped values
                val swapPosition = positionMap.getOrDefault(sortedNums[i], -1)
                positionMap[nums[i]] = swapPosition
                nums[swapPosition] = nums[i]
            }
        }
        return swapCount
    }

    var result = 0
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    while (true) {
        val queueSize = queue.size
        if (queueSize == 0) {
            break
        }
        val currentLevelValues = IntArray(queueSize)
        for (i in 0..<queueSize) {
            val currentNode = queue.poll()
            currentLevelValues[i] = currentNode.`val`
            currentNode.left?.let {
                queue.add(it)
            }
            currentNode.right?.let {
                queue.add(it)
            }
        }
        result += getSwapCount(currentLevelValues)
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/
 *
 * Data Structure - Tree
 * Algorithm - BFS and Naive Sorting
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 1562 ms, faster than 100.00%
 * Memory Usage: 58.6 MB, less than 100.00%
 *
 * Time - O(N ^ 2)
 * Space - O(N)
 */
fun minimumOperationsUsingNaiveSorting(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    var result = 0
    val currentQueue = mutableListOf<TreeNode>()
    val nextQueue = mutableListOf<TreeNode>()
    nextQueue.add(root)
    while (true) {
        if (nextQueue.size == 0) {
            break
        }
        currentQueue.clear()
        currentQueue.addAll(nextQueue)
        nextQueue.clear()
        for (i in currentQueue.indices) {
            currentQueue[i].left?.let {
                nextQueue.add(it)
            }
            currentQueue[i].right?.let {
                nextQueue.add(it)
            }
        }

        val processingArray = currentQueue.toTypedArray()
        var candidateIndex: Int
        for (i in 0..<processingArray.lastIndex) {
            candidateIndex = i
            for (j in (i + 1)..processingArray.lastIndex) {
                if (processingArray[j].`val` < processingArray[candidateIndex].`val`) {
                    candidateIndex = j
                }
            }
            if (candidateIndex != i) {
                result++
                processingArray[i] = processingArray[candidateIndex].also {
                    processingArray[candidateIndex] = processingArray[i]
                }
            }
        }
    }
    return result
}

private fun main() {

}
