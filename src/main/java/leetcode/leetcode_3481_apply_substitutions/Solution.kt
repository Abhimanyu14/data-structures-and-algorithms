package leetcode.leetcode_3481_apply_substitutions

/**
 * leetcode - https://leetcode.com/problems/apply-substitutions/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
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
private fun applySubstitutions(replacements: List<List<String>>, text: String): String {
    val map = mutableMapOf<String, String>()
    for ((key, value) in replacements) {
        map[key] = value
    }
    fun expand(word: String): String {
        val result = StringBuilder()
        var i = 0
        while (i <= word.lastIndex) {
            while (i <= word.lastIndex && word[i] != '%') {
                result.append(word[i])
            }
            if (i <= word.lastIndex && word[i] == '%') {
                i++
                val key = StringBuilder()
                while (i <= word.lastIndex && word[i] != '%') {
                    key.append(word[i])
                }
                result.append(expand(map[key.toString()]!!))
                i++
            }
        }
        return result.toString()
    }
    return expand(text)
}

private fun main() {

}
