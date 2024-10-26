package leetcode.leet_2400_to_2499.leet_2467_most_profitable_path_in_a_tree


/**
 * leetcode - https://leetcode.com/problems/most-profitable-path-in-a-tree/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 *
 */
private data class Node(
    val value: Int,
    var parent: Node? = null,
    val adjacentNodeValues: MutableSet<Int> = mutableSetOf(),
) {
    val depth: Int
        get() = 1 + (parent?.depth ?: -1)
}

private fun mostProfitablePath(edges: Array<IntArray>, bob: Int, amount: IntArray): Int {
    val nodes = Array(edges.size + 1) {
        Node(it)
    }
    val root = nodes[0]
    edges.forEach { edge ->
        nodes[edge[1]].parent = nodes[edge[0]]
        nodes[edge[0]].adjacentNodeValues.add(nodes[edge[1]].value)
        nodes[edge[1]].adjacentNodeValues.add(nodes[edge[0]].value)
    }

    // Find Bob's path to 0 by searching depth-first from 0 to Bob's starting location
    fun findBob(node: Node, parent: Node?): Node? {
        if (node.value == bob) {
            return node
        }
        nodes[node.value].adjacentNodeValues.forEach { adjacentNodeValue ->
            if (adjacentNodeValue != parent?.value) {
                findBob(nodes[adjacentNodeValue], node)?.let {
                    return it
                }
            }
        }
        return null
    }

    val bobNode = findBob(root, null) ?: return -1
    val bobLength = bobNode.depth

    // Resolve Bob's impact on amounts as a result of his path.
    var node = bobNode
    // Handle nodes before the halfway point (if any).
    while (node.depth > bobLength shr 1) {
        amount[node.value] = 0
        node.parent?.let {
            node = it
        }
    }
    // If there is a halfway point, take or pay half of the amount at that node.
    // Is bobLength (number of steps, not nodes) even?  If so there's a halfway point.
    // And, because of the way we've iterated, if it exists, it is `node`, because we
    // have stopped zeroing out amounts just short of that midway point.
    if (bobLength and 1 == 0) {
        amount[node.value] /= 2
    }

    // Now, optimize Alice's path with a depth-first search and return her max income.
    val max = intArrayOf(Int.MIN_VALUE)

    fun optimizeAlice(
        i: Int,
        lastI: Int,
        income: Int,
    ) {
        // Track number of children (neighbors not equal to lastI) so we know when we are at a leaf.
        var children = 0
        nodes[i].adjacentNodeValues.forEach { adjacentNodeValue ->
            // Search neighbors except the neighbor we just came from.
            if (adjacentNodeValue != lastI) {
                children++
                optimizeAlice(adjacentNodeValue, i, income + amount[adjacentNodeValue])
            }
        }
        if (children == 0) {
            // We are at a leaf - check if income is a new maximum.
            if (income > max[0]) {
                max[0] = income
            }
        }
    }

    optimizeAlice(0, -1, amount[0])

    return max[0]
}

private fun main() {
    println(
        mostProfitablePath(
            edges = arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 2),
                intArrayOf(1, 3),
                intArrayOf(3, 4),
            ),
            bob = 3,
            amount = intArrayOf(-2, 4, 2, -4, 6),
        )
    )
}
