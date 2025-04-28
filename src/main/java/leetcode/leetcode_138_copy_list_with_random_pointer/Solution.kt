package leetcode.leetcode_138_copy_list_with_random_pointer

private class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

/**
 * leetcode - https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Map], LinkedList
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 347 ms, faster than 54.39%
 * Memory Usage: 39.1 MB, less than 78.95%
 *
 * Time - O(2 * N)
 * Space - O(N)
 *
 * Companies - Meta
 */

/**
 * leetcode - https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Map], LinkedList
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 347 ms, faster than 54.39%
 * Memory Usage: 39.1 MB, less than 78.95%
 *
 * Time - O(2 * N)
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun copyRandomListUsingIndexMapping(node: Node?): Node? {
    if (node == null) {
        return null
    }
    val originalNodeToIndexMap = mutableMapOf<Node, Int>()
    val newIndexToNodeMap = mutableMapOf<Int, Node>()

    var index = 0
    var current: Node? = node
    val newHead = Node(current?.`val` ?: 0)
    var newPointer: Node? = newHead

    originalNodeToIndexMap[current!!] = 0
    newIndexToNodeMap[index] = newPointer!!
    index++
    current = current.next

    while (current != null) {
        val newNode = Node(current.`val`)
        newPointer?.next = newNode
        newPointer = newPointer?.next
        originalNodeToIndexMap[current] = index
        newIndexToNodeMap[index] = newPointer!!
        index++
        current = current.next
    }

    current = node
    newPointer = newHead
    while (current != null) {
        if (current.random != null) {
            val randomNodeIndex = originalNodeToIndexMap[current.random!!]
            newPointer?.random = newIndexToNodeMap[randomNodeIndex]
        }
        current = current.next
        newPointer = newPointer?.next
    }
    return newHead
}

/**
 * leetcode - https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 347 ms, faster than 54.39%
 * Memory Usage: 39.1 MB, less than 78.95%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun copyRandomListWithoutMap(node: Node?): Node? {
    // If root node is null return null
    if (node == null) {
        return null
    }

    // Result copy list head
    val copyHead = Node(node.`val`)

    // For original list
    var nodePointer: Node? = node.next
    // For new list
    var copyPointer: Node? = copyHead

    // Copy list skipping random
    while (nodePointer != null) {
        copyPointer?.next = Node(nodePointer.`val`)
        copyPointer = copyPointer?.next
        nodePointer = nodePointer.next
    }

    // Reset pointers to head
    nodePointer = node
    copyPointer = copyHead

    var position: Int
    var currentRandom: Node?
    var traverser: Node?

    while (nodePointer != null) {
        if (nodePointer.random == null) {
            copyPointer?.random = null
        } else {
            currentRandom = nodePointer.random
            position = 0

            traverser = node
            while (traverser != currentRandom) {
                position++
                traverser = traverser?.next
            }

            traverser = copyHead
            while (position > 0) {
                position--
                traverser = traverser?.next
            }
            copyPointer?.random = traverser
        }
        copyPointer = copyPointer?.next
        nodePointer = nodePointer.next
    }
    return copyHead
}

/**
 * TODO-Abhi: To solve using list manipulation
 */
private fun main() {

}
