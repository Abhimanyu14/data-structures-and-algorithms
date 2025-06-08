package leetcode.leetcode_386_lexicographical_numbers

/**
 * leetcode - https://leetcode.com/problems/lexicographical-numbers/
 *
 * Data Structure - [List]
 * Algorithm - Backtracking (Recursion)
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun lexicalOrder(n: Int): List<Int> {
    val result = mutableListOf<Int>()
    fun backtrack(x: Int) {
        if (x > n) {
            return
        }
        result.add(x)
        for (i in 0..9) {
            backtrack(x * 10 + i)
        }
    }
    for (i in 1..9) {
        backtrack(i)
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/lexicographical-numbers/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
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
private fun lexicalOrderUsingIteration(n: Int): List<Int> {
    val lexicographicalNumbers: MutableList<Int> = ArrayList()
    var currentNumber = 1

    // Generate numbers from 1 to n
    for (i in 0..<n) {
        lexicographicalNumbers.add(currentNumber)

        // If multiplying the current number by 10 is within the limit, do it
        if (currentNumber * 10 <= n) {
            currentNumber *= 10
        } else {
            // Adjust the current number by moving up one digit
            while (currentNumber % 10 == 9 || currentNumber >= n) {
                currentNumber /= 10 // Remove the last digit
            }
            currentNumber += 1 // Increment the number
        }
    }

    return lexicographicalNumbers
}

/**
 * leetcode - https://leetcode.com/problems/lexicographical-numbers/
 *
 * Data Structure - [Trie]
 * Algorithm - Trie
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
private class TrieNode(
    var children: Array<TrieNode?> = arrayOfNulls(10),
)

private class Trie {
    private val root = TrieNode()

    fun addNumbers(x: Int) {
        for (i in 1..x) {
            add(i)
        }
    }

    private fun add(x: Int) {
        var currentNode = root
        x.toString().forEach {
            if (currentNode.children[it - '0'] == null) {
                currentNode.children[it - '0'] = TrieNode()
            }
            currentNode.children[it - '0']?.let {
                currentNode = it
            }
        }
    }

    fun getLexicographicalOrdered(): List<Int> {
        val result = mutableListOf<Int>()
        val stack = ArrayDeque<Pair<TrieNode, Int>>()
        stack.addLast(Pair(root, 0))
        while (stack.isNotEmpty()) {
            val (currentNode, currentValue) = stack.removeLast()
            if (currentValue > 0) {
                result.add(currentValue)
            }
            for (i in 9 downTo 0) {
                currentNode.children[i]?.let {
                    stack.addLast(Pair(it, ((currentValue * 10) + i)))
                }
            }
        }
        return result
    }
}

private fun lexicalOrderUsingTrie(n: Int): List<Int> {
    val trie = Trie()
    trie.addNumbers(n)
    return trie.getLexicographicalOrdered()
}

private fun main() {

}
