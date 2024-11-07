package leetcode.leetcode_676_implement_magic_dictionary

/**
 * leetcode - https://leetcode.com/problems/implement-magic-dictionary/?envType=problem-list-v2&envId=trie
 *
 * TODO(Abhi) - To revisit
 *
 * Using trie
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 108 ms, faster than 100.00%
 * Memory Usage: 40.3 MB, less than 87.50%
 *
 * Time -
 * Space -
 */
private class TrieNode(
    val char: Char,
    var isWord: Boolean = false,
    val children: Array<TrieNode?> = arrayOfNulls(26),
)

private class MagicDictionary {
    private val trieHeads: Array<TrieNode?> = arrayOfNulls(26)

    fun buildDict(dictionary: Array<String>) {
        dictionary.forEach { word ->
            if (trieHeads[word[0] - 'a'] == null) {
                trieHeads[word[0] - 'a'] = TrieNode(word[0])
            }
            var current = trieHeads[word[0] - 'a']
            for (i in 1..word.lastIndex) {
                if (current?.children?.get(word[i] - 'a') == null) {
                    current?.children?.set(word[i] - 'a', TrieNode(word[i]))
                }
                current = current?.children?.get(word[i] - 'a')
            }
            current?.isWord = true
        }
    }

    fun search(searchWord: String): Boolean {
        fun search(index: Int, changed: Boolean, current: TrieNode): Boolean {
            if (index == searchWord.length) {
                return false
            }
            current.children.forEach {
                if (it != null) {
                    if (changed) {
                        if (current.char == searchWord[index]) {
                            if (search(index + 1, true, it)) {
                                return true
                            }
                        }
                    } else {
                        if (search(index + 1, current.char != searchWord[index], it)) {
                            return true
                        }
                    }
                }
            }
            if (index == searchWord.lastIndex) {
                return current.isWord && ((changed && current.char == searchWord[index]) || (!changed && current.char != searchWord[index]))
            }
            return false
        }

        for (head in trieHeads) {
            if (head != null) {
                if (searchWord.length == 1) {
                    if (head.char != searchWord[0] && head.isWord) {
                        return true
                    }
                } else {
                    head.children.forEach {
                        if (it != null) {
                            if (search(1, head.char != searchWord[0], it)) {
                                return true
                            }
                        }
                    }
                }
            }
        }
        return false
    }
}

private fun main() {
    val magicDictionary = MagicDictionary()
    magicDictionary.buildDict(arrayOf("hello", "leetcode"))
    println(magicDictionary.search("hello"))
    // println(magicDictionary.search("hhllo"))
//    println(magicDictionary.search("hell"))
//    println(magicDictionary.search("leetcoded"))

    /**
     * Test cases
     *
     * ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
     * [[], [["hello","leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
     * ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
     * [[], [["hello","hallo","leetcode"]], ["hello"], ["hallo"], ["hell"], ["leetcodd"]]
     * ["MagicDictionary", "buildDict", "search", "search", "search", "search", "search", "search", "search", "search", "search"]
     * [[], [["a","b","ab","abc"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["ab"], ["ba"], ["abc"]]
     * ["MagicDictionary", "buildDict", "search", "search", "search", "search", "search", "search", "search", "search", "search", "search", "search", "search", "search", "search", "search"]
     * [[], [["a","b","ab","abc","abcabacbababdbadbfaejfoiawfjaojfaojefaowjfoawjfoawj","abcdefghijawefe","aefawoifjowajfowafjeoawjfaow","cba","cas","aaewfawi","babcda","bcd","awefj"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["ab"], ["ba"], ["abc"], ["cba"], ["abb"], ["bb"], ["aa"], ["bbc"], ["abcd"]]
     */
}
