package leetcode.leetcode_721_accounts_merge

/**
 * leetcode - https://leetcode.com/problems/accounts-merge/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Graph, [Map], [List]
 * Algorithm - DFS
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
 */
private class GraphNode(
    val email: String,
    var name: String,
    val neighbours: MutableList<String> = mutableListOf(),
)

private fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
    val result = mutableListOf<List<String>>()
    val graph = mutableMapOf<String, GraphNode>()
    for (account in accounts) {
        val name = account[0]
        if (!graph.contains(account[1])) {
            graph[account[1]] = GraphNode(
                name = name,
                email = account[1],
            )
        }
        for (i in 1..<account.lastIndex) {
            if (!graph.contains(account[i + 1])) {
                graph[account[i + 1]] = GraphNode(
                    name = name,
                    email = account[i + 1],
                )
            }
            graph[account[i]]!!.neighbours.add(account[i + 1])
            graph[account[i + 1]]!!.neighbours.add(account[i])
        }
    }

    val visited = mutableSetOf<String>()

    fun getAllEmails(email: String): List<String> {
        val emails = mutableListOf<String>()
        val stack = ArrayDeque<String>()
        stack.addLast(email)

        while (stack.isNotEmpty()) {
            val current = stack.removeLast()
            if (visited.contains(current)) {
                continue
            }
            visited.add(current)
            emails.add(current)
            graph[current]?.neighbours?.forEach {
                if (!visited.contains(it)) {
                    stack.addLast(it)
                }
            }
        }
        return emails.sorted()
    }

    for ((email, node) in graph) {
        if (!visited.contains(email)) {
            val newPerson = mutableListOf<String>()
            newPerson.add(node.name)
            newPerson.addAll(getAllEmails(node.email))
            result.add(newPerson)
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/accounts-merge/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [UnionFind], [IntArray], [Map], [List]
 * Algorithm - UnionFind
 *
 * Source - https://youtu.be/6st4IxEF-90
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private class UnionFind(size: Int) {
    private val roots = IntArray(size) { it }
    private val ranks = IntArray(size)

    fun find(x: Int): Int {
        if (roots[x] != x) {
            roots[x] = find(roots[x])
        }
        return roots[x]
    }

    fun union(x: Int, y: Int): Int {
        var rootX = find(x)
        var rootY = find(y)
        if (rootX == rootY) {
            return 0
        } else {
            if (ranks[rootX] < ranks[rootY]) {
                rootX = rootY.also {
                    rootY = rootX
                }
            }
            roots[rootY] = rootX
            if (ranks[rootX] == ranks[rootY]) {
                ranks[rootX]++
            }
            return 1
        }
    }
}

private fun accountsMergeUsingUnionFind(accounts: List<List<String>>): List<List<String>> {
    val result = mutableListOf<List<String>>()
    val unionFind = UnionFind(accounts.size)
    val emailToAccountIndexMap = mutableMapOf<String, Int>()
    for (i in accounts.indices) {
        for (j in 1..accounts[i].lastIndex) {
            if (emailToAccountIndexMap.contains(accounts[i][j])) {
                unionFind.union(i, emailToAccountIndexMap[accounts[i][j]] ?: 0)
            } else {
                emailToAccountIndexMap[accounts[i][j]] = i
            }
        }
    }
    val accountIndexToEmailsMap = mutableMapOf<Int, MutableList<String>>()
    for ((email, accountIndex) in emailToAccountIndexMap) {
        val root = unionFind.find(accountIndex)
        accountIndexToEmailsMap.computeIfAbsent(root) {
            mutableListOf()
        }.add(email)
    }
    for ((accountIndex, emails) in accountIndexToEmailsMap) {
        result.add(listOf(accounts[accountIndex][0]) + emails.sorted())
    }
    return result
}

private fun main() {

}
