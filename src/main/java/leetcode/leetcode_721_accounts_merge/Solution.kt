package leetcode.leetcode_721_accounts_merge

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

private fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
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
