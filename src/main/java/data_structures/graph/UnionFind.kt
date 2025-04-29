package data_structures.graph

private class UnionFind(n: Int) {
    private val root = IntArray(n) { it }
    private val rank = IntArray(n)

    fun find(x: Int): Int {
        if (root[x] != x) {
            root[x] = find(root[x]) // Concept - Path compression
        }
        return root[x]
    }

    fun union(x: Int, y: Int): Int {
        var rootX = find(x)
        var rootY = find(y)

        // rootX == rootY => they are already in same tree
        if (rootX == rootY) {
            return 0
        } else {
            // Checking tree with smaller number of nodes
            if (rank[rootX] < rank[rootY]) {
                rootX = rootY.also {
                    rootY = rootX
                }
            }

            // Attaching lower rank tree (tree with less node) to the higher one (tree with more nodes).
            root[rootY] = rootX

            // If now, ranks are equal, increasing rank of X.
            if (rank[rootX] == rank[rootY]) {
                rank[rootX]++
            }
            return 1
        }
    }
}

private fun main() {
    val unionFind = UnionFind(5)
    unionFind.union(0, 1)
    unionFind.union(1, 2)
    unionFind.union(3, 4)
}
