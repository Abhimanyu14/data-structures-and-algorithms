package leetcode.leet_100_to_199.leet_138_copy_list_with_random_pointer

private class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

/**
 * leetcode - https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * Using loops
 *
 * Stats
 * Runtime: 347 ms, faster than 54.39%
 * Memory Usage: 39.1 MB, less than 78.95%
 */
private fun copyRandomList(node: Node?): Node? {
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
        copyPointer?.next = Node(nodePointer?.`val` ?: 0)
        copyPointer = copyPointer?.next
        nodePointer = nodePointer?.next
    }

    // Reset pointers to head
    nodePointer = node
    copyPointer = copyHead

    var position: Int
    var currentRandom: Node?
    var traverser: Node?

    while (nodePointer != null) {
        if (nodePointer?.random == null) {
            copyPointer?.random = null
        } else {
            currentRandom = nodePointer?.random
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
        nodePointer = nodePointer?.next
    }
    return copyHead
}

/**
 * TODO-Abhi: To solve using list manipulation
 */
private fun main() {

}
