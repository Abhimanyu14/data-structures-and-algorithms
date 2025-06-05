package leetcode.leetcode_2359_find_closest_node_to_given_two_nodes

/**
 * leetcode - https://leetcode.com/problems/find-closest-node-to-given-two-nodes/description/?envType=daily-question&envId=2025-05-30
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {
    if (node1 == node2) {
        return node1
    }
    var current1 = node1
    var current2 = node2
    val nodesInPath1 = mutableSetOf<Int>()
    nodesInPath1.add(current1)
    val nodesInPath2 = mutableSetOf<Int>()
    nodesInPath2.add(current2)
    while (current1 != -1 || current2 != -1) {
        if (current1 != -1) {
            if (nodesInPath1.contains(edges[current1])) {
                current1 = -1
            } else {
                current1 = edges[current1]
                if (current1 != -1) {
                    nodesInPath1.add(current1)
                }
            }
        }
        if (current2 != -1) {
            if (nodesInPath2.contains(edges[current2])) {
                current2 = -1
            } else {
                current2 = edges[current2]
                if (current2 != -1) {
                    nodesInPath2.add(current2)
                }
            }
        }
        val intersectionSet = nodesInPath1 intersect nodesInPath2
        if (intersectionSet.isNotEmpty()) {
            return intersectionSet.min()
        }
    }
    return -1
}

private fun main() {

}
