package data_structures_and_algorithms.graph

class UnionFind(
    val n: Int,
) {
    private val root = IntArray(n) { it }
    private val rank = IntArray(n)

    fun find(x: Int): Int {
        if (root[x] != x) {
            root[x] = find(root[x]) // Concept - Path compression
        }
        return root[x]
    }

    fun union(x: Int, y: Int) {
        var rootX = find(x)
        var rootY = find(y)

        // rootX == rootY => they are already in same tree
        if (rootX != rootY) {
            // Checking tree with smaller number of nodes
            if (rank[rootX] < rank[rootY]) {
                rootX = rootY.also {
                    rootY = rootX
                }
            }

            // Attaching lower rank tree to the higher one.
            root[rootY] = rootX

            // If now ranks are equal increasing rank of X.
            if (rank[rootX] == rank[rootY]) {
                rank[rootX]++
            }
        }
    }

    fun findAll(): List<Int> {
        return buildList {
            repeat(n) {
                add(find(it))
            }
        }
    }
}

private fun main() {
    val unionFind = UnionFind(5)
    println(unionFind.findAll().joinToString(", "))
    unionFind.union(0, 1)
    println(unionFind.findAll().joinToString(", "))
    unionFind.union(1, 2)
    println(unionFind.findAll().joinToString(", "))
    unionFind.union(3, 4)
    println(unionFind.findAll().joinToString(", "))
}
