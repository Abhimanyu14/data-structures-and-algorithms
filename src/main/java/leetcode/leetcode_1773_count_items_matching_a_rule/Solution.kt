package leetcode.leetcode_1773_count_items_matching_a_rule

/**
 * leetcode - https://leetcode.com/problems/count-items-matching-a-rule/description/
 *
 * Using map
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 9 ms, faster than 16.67%
 * Memory Usage: 46.1 MB, less than 5.56%
 *
 * Time -
 * Space -
 */
private fun countMatches(items: List<List<String>>, ruleKey: String, ruleValue: String): Int {
    val indexMap = mapOf(
        "type" to 0,
        "color" to 1,
        "name" to 2,
    )
    val index = indexMap[ruleKey] ?: 0
    return items.count {
        it[index] == ruleValue
    }
}

private fun main() {

}
