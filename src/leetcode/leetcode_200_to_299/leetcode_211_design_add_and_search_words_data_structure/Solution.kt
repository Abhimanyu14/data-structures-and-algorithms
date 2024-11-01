package leetcode.leetcode_200_to_299.leetcode_211_design_add_and_search_words_data_structure

/**
 * leetcode - https://leetcode.com/problems/design-add-and-search-words-data-structure/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 *
 */
private class Node(
    val char: Char,
) {
    var isWord = false
    val children: Array<Node?> = Array(26) { null }
}

private class WordDictionary() {
    val parents: Array<Node?> = Array(26) { null }

    fun addWord(word: String) {
        if (parents[word[0] - 'a'] == null) {
            parents[word[0] - 'a'] = Node(word[0])
        }
        var current = parents[word[0] - 'a']
        for (i in 1..word.lastIndex) {
            if (current?.children?.get(word[i] - 'a') == null) {
                current?.children?.set(word[i] - 'a', Node(word[i]))
            }
            current = current?.children?.get(word[i] - 'a')
        }
        current?.isWord = true
    }

    fun search(word: String): Boolean {
        if (word[0] == '.') {
            return true
        } else {
            if (parents[word[0] - 'a'] == null) {
                return false
            }
            var current = parents[word[0] - 'a']
            for (i in 1..word.lastIndex) {
                if (current?.children?.get(word[i] - 'a') == null) {
                    return false
                }
                current = current.children[word[i] - 'a']
            }
            return current?.isWord ?: false
        }
    }
}

private fun main() {

}
