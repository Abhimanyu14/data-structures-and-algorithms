package leetcode.leetcode_800_to_899.leetcode_884_uncommon_words_from_two_sentences

import java.util.LinkedList


/**
 * leetcode - https://leetcode.com/problems/uncommon-words-from-two-sentences/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun uncommonFromSentences(s1: String, s2: String): Array<String> {
    val count: MutableMap<String, Int> = mutableMapOf()
    for (word in s1.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) count[word] =
        count.getOrDefault(word, 0) + 1
    for (word in s2.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) count[word] =
        count.getOrDefault(word, 0) + 1

    val ans: MutableList<String> = mutableListOf()
    for (word in count.keys) {
        if (count[word] == 1) ans.add(word)
    }

    return ans.toTypedArray<String>()
}

private fun main() {

}
