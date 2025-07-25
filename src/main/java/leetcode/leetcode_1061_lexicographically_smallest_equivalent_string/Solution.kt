package leetcode.leetcode_1061_lexicographically_smallest_equivalent_string

/**
 * leetcode - https://leetcode.com/problems/lexicographically-smallest-equivalent-string/?envType=daily-question&envId=2025-06-05
 *
 * Data Structure - UnionFind
 * Algorithm - UnionFind
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
private class UnionFind {
    private val roots = IntArray(26) { it }

    fun find(x: Int): Int {
        if (roots[x] != x) {
            roots[x] = find(roots[x])
        }
        return roots[x]
    }

    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX > rootY) {
            roots[rootX] = rootY
        } else if (rootX < rootY) {
            roots[rootY] = rootX
        }
    }
}

private fun smallestEquivalentString(s1: String, s2: String, baseStr: String): String {
    val unionFind = UnionFind()
    for (i in s1.indices) {
        unionFind.union(s1[i] - 'a', s2[i] - 'a')
    }
    val result = CharArray(baseStr.length)
    for (i in baseStr.indices) {
        result[i] = 'a' + unionFind.find(baseStr[i] - 'a')
    }
    return String(result)
}

private fun smallestEquivalentStringUsingArray1(s1: String, s2: String, baseStr: String): String {
    val roots = IntArray(26) { it }
    var root1: Int
    var root2: Int
    var newRoot: Int
    var rootToChange: Int
    for (i in s1.indices) {
        if (s1[i] == s2[i]) {
            continue
        }
        root1 = roots[s1[i] - 'a']
        root2 = roots[s2[i] - 'a']
        if (root1 < root2) {
            newRoot = root1
            rootToChange = root2
        } else {
            newRoot = root2
            rootToChange = root1
        }
        roots.forEachIndexed { index, root ->
            if (root == rootToChange) {
                roots[index] = newRoot
            }
        }
    }
    return baseStr.toCharArray().map { 'a' + roots[it - 'a'] }.joinToString("")
}

private fun smallestEquivalentStringUsingArray(s1: String, s2: String, baseStr: String): String {
    val letters = IntArray(26) { -1 }
    var index1: Int
    var index2: Int
    var temp: Int = -1
    for (i in s1.indices) {
        temp = -1
        if (s1[i] < s2[i]) {
            index1 = s1[i].toInt() - 'a'.toInt()
            index2 = s2[i].toInt() - 'a'.toInt()
            if (letters[index2] == -1 || letters[index2] > index1) {
                temp = letters[index2]
                letters[index2] = index1
            }
            while (index1 > 0 && letters[index1] != -1 && letters[index1] != index1) {
                index1 = letters[index1]
            }
            letters[index1] = index1
            if (temp != -1) {
                while (letters[temp] != temp) {
                    temp = letters[temp]
                }
                letters[temp] = index1
            }
        } else if (s1[i] > s2[i]) {
            index1 = s2[i].toInt() - 'a'.toInt()
            index2 = s1[i].toInt() - 'a'.toInt()
            if (letters[index2] == -1 || letters[index2] > index1) {
                temp = letters[index2]
                letters[index2] = index1
            }
            while (index1 > 0 && letters[index1] != -1 && letters[index1] != index1) {
                index1 = letters[index1]
            }
            letters[index1] = index1
            if (temp != -1) {
                while (letters[temp] != temp) {
                    temp = letters[temp]
                }
                letters[temp] = index1
            }
        } else {
            index1 = s1[i].toInt() - 'a'.toInt()
            if (letters[index1] == -1 || letters[index1] > index1) {
                letters[index1] = index1
            }
        }
        println(
            "$i ${
                letters.mapIndexed { index, i ->
                    Pair('a' + index, i)
                }.filter {
                    it.second != -1
                }.joinToString(", ")
            }"
        )
        println()
    }
    val result = StringBuilder()
    baseStr.forEach {
        index1 = it.toInt() - 'a'.toInt()
        if (letters[index1] == -1) {
            result.append(it)
        } else {
            while (letters[index1] != index1) {
                index1 = letters[index1]
            }
            result.append('a' + letters[index1])
        }
    }
    return result.toString()
}
