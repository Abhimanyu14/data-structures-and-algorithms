package leetcode.leetcode_1233_remove_sub_folders_from_the_filesystem

/**
 * leetcode - https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/?envType=problem-list-v2&envId=trie
 *
 * Data Structure - [Trie], [Map], [StringBuilder], [ArrayDeque] (Stack), [List]
 * Algorithm - Trie
 *
 * Using Map properties - [values]
 * Using String properties - [length]
 *
 * Using Array methods - [arrayOfNulls]
 * Using StringBuilder methods - [clear], [toString]
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
    val word: String,
    var isWord: Boolean = false,
    val children: MutableMap<String, TrieNode> = mutableMapOf(),
)

private class Trie {
    private val root = TrieNode("")

    fun add(word: String) {
        var currentNode = root
        for (folder in getFolders(word)) {
            if (currentNode.children[folder] == null) {
                currentNode.children[folder] = TrieNode(folder)
            }
            currentNode.children[folder]?.let {
                currentNode = it
            }
        }
        currentNode.isWord = true
    }

    private fun getFolders(word: String): List<String> {
        val result = mutableListOf<String>()
        val stringBuilder = StringBuilder()
        var index = 1
        while (index < word.length) {
            if (word[index] == '/') {
                result.add(stringBuilder.toString())
                stringBuilder.clear()
            } else {
                stringBuilder.append(word[index])
            }
            index++
        }
        return result
    }

    fun getRootFolders(): List<String> {
        val result = mutableListOf<String>()
        val stack = ArrayDeque<Pair<TrieNode, String>>()
        stack.add(Pair(root, ""))
        while (stack.isNotEmpty()) {
            val (currentNode, currentFolder) = stack.removeLast()
            if (currentNode.isWord) {
                result.add(currentFolder)
            } else {
                currentNode.children.values.forEach {
                    stack.add(Pair(it, "$currentFolder/${it.word}"))
                }
            }
        }
        return result
    }
}

class Solution {
    fun removeSubfolders(folder: Array<String>): List<String> {
        val trie = Trie()
        for (word in folder) {
            trie.add(word)
        }
        return trie.getRootFolders()
    }
}

private fun main() {

}
