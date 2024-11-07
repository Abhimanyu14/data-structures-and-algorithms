package leetcode.leetcode_1443_minimum_time_to_collect_all_apples_in_a_tree

/**
 * leetcode - https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
 *
 * Using
 *
 * Stats
 * Runtime: 910 ms, faster than 100.00%
 * Memory Usage: 93.7 MB, less than 100.00%
 */
class MyTreeNode(
    val index: Int,
    val hasApple: Boolean,
    val adjacent: MutableList<MyTreeNode> = mutableListOf()
)

private class Solution {
    fun minTime(n: Int, edges: Array<IntArray>, hasApple: List<Boolean>): Int {
        val nodes = mutableMapOf<Int, MyTreeNode>()
        edges.forEach {
            if (!nodes.contains(it[0])) {
                nodes[it[0]] = MyTreeNode(it[0], hasApple[it[0]])
            }
            if (!nodes.contains(it[1])) {
                nodes[it[1]] = MyTreeNode(it[1], hasApple[it[1]])
            }
            nodes[it[0]]?.let { node ->
                nodes[it[1]]?.adjacent?.add(node)
            }
            nodes[it[1]]?.let { node ->
                nodes[it[0]]?.adjacent?.add(node)
            }
        }
        val traversed = mutableSetOf<Int>()
        fun collectApples(pos: Int) : Pair<Boolean, Int> {
            traversed.add(pos)
            if (nodes[pos]!!.adjacent.isEmpty()) {
                return Pair(nodes[pos]!!.hasApple,  0)
            }
            var flag = nodes[pos]!!.hasApple
            var count = 0
            nodes[pos]!!.adjacent.forEach {
                if (!traversed.contains(it.index)) {
                    val temp = collectApples(it.index)
                    if (temp.first) {
                        count += temp.second + 2
                        flag = true
                    }
                }
            }
            return Pair(flag, count)
        }
        return collectApples(0).second
    }
}

private fun main() {

}
