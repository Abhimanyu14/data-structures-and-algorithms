package leetcode.leet_100_to_199.leet_127_word_ladder

import java.util.LinkedList
import java.util.Queue

/**
 * leetcode - https://leetcode.com/problems/word-ladder/
 *
 * TODO(Abhi) - To revisit
 *
 * Using BFS
 *
 * Stats
 * Runtime: 291 ms, faster than 92.67%
 * Memory Usage: 40.8 MB, less than 81.33%
 */
private fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
    val wordSet = wordList.toHashSet()
    if (!wordSet.contains(endWord)) {
        return 0
    }
    val queue: Queue<String> = LinkedList()
    queue.offer(beginWord)
    var result = 1
    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val currentWord = queue.poll()
            for (i in currentWord.indices) {
                val wordArray = currentWord.toCharArray()
                for (ch in 'a'..'z') {
                    wordArray[i] = ch
                    val newWord = String(wordArray)
                    if (newWord == endWord) {
                        return result + 1
                    }
                    if (wordSet.contains(newWord)) {
                        wordSet.remove(newWord)
                        queue.offer(newWord)
                    }
                }
            }
        }
        result++
    }
    return 0
}

private data class Node(
    val word: String,
    val adjacent: MutableSet<String> = mutableSetOf(),
)

private fun ladderLengthUsingBFS(beginWord: String, endWord: String, wordList: List<String>): Int {
    val wordMap = mutableMapOf<String, Node>()
    wordMap[beginWord] = Node(beginWord)
    wordList.forEach {
        wordMap[it] = Node(it)
    }
    if (!wordMap.contains(endWord)) {
        return 0
    }

    fun isAdjacent(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) {
            return false
        }
        var result = 0
        for (i in 0..word1.lastIndex) {
            if (word1[i] != word2[i]) {
                result++
            }
        }
        return result == 1
    }

    val words = wordMap.keys.toList()
    words.forEachIndexed { i, word1 ->
        for (j in (i + 1)..words.lastIndex) {
            val word2 = words[j]
            if (isAdjacent(word1, word2)) {
                wordMap[word2]?.let {
                    wordMap[word1]?.adjacent?.add(it.word)
                }
                wordMap[word1]?.let {
                    wordMap[word2]?.adjacent?.add(it.word)
                }
            }
        }
    }

    val queue = ArrayDeque<Pair<Node, Int>>()
    val visited = mutableSetOf<String>()
    var result = 0
    wordMap[beginWord]?.let {
        queue.add(Pair(it, 1))
    }
    while (queue.isNotEmpty()) {
        val temp = queue.removeFirst()
        visited.add(temp.first.word)
        if (temp.first.word == endWord) {
            result = temp.second
        }
        temp.first.adjacent.forEach {
            if (!visited.contains(it)) {
                wordMap[it]?.let { node ->
                    queue.addLast(Pair(node, temp.second + 1))
                }
            }
        }
    }

    return result
}

private fun main() {
    println(
        ladderLength(
            beginWord = "hit",
            endWord = "cog",
            wordList = listOf("hot", "dot", "dog", "lot", "log", "cog"),
        ),
    )
}
