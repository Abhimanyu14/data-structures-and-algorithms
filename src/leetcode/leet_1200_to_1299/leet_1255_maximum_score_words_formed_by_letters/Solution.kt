package leetcode.leet_1200_to_1299.leet_1255_maximum_score_words_formed_by_letters

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-score-words-formed-by-letters/?envType=daily-question&envId=2024-05-24
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
    var maxScore = 0
    // Count how many times each letter occurs
    val freq = IntArray(26)
    letters.forEach { char ->
        freq[char - 'a']++
    }

    // Check if adding this word exceeds the frequency of any letter
    fun isValidWord(subsetLetters: IntArray): Boolean {
        for (c in 0..25) {
            if (freq[c] < subsetLetters[c]) {
                return false
            }
        }
        return true
    }

    fun check(w: Int, subsetLetters: IntArray, totalScore: Int) {
        var localTotalScore = totalScore
        if (w == -1) {
            // If all words have been iterated, check the score of this subset
            maxScore = max(maxScore, localTotalScore)
            return
        }
        // Not adding words[w] to the current subset
        check(w - 1, subsetLetters, localTotalScore)
        // Adding words[w] to the current subset
        for (i in 0..<words[w].length) {
            val c = words[w][i] - 'a'
            subsetLetters[c]++
            localTotalScore += score[c]
        }

        if (isValidWord(subsetLetters)) {
            // Consider the next word if this subset is still valid
            check(w - 1, subsetLetters, localTotalScore)
        }
        // Rollback effects of this word
        for (i in 0..<words[w].length) {
            val c = words[w][i] - 'a'
            subsetLetters[c]--
            localTotalScore -= score[c]
        }
    }

    check(words.lastIndex, IntArray(26), 0)
    return maxScore
}

private fun main() {

}
