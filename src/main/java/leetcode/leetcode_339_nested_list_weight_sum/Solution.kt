package leetcode.leetcode_339_nested_list_weight_sum

/**
 * leetcode - https://leetcode.com/problems/nested-list-weight-sum/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 * Premium Question
 *
 * Data Structure - [List]
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun depthSum(nestedList: List<NestedInteger>): Int {
    fun depthSum(currentList: List<NestedInteger>, depth: Int): Int {
        var result = 0
        currentList.forEach {
            result += if (it.isInteger()) {
                depth * (it.getInteger() ?: 0)
            } else {
                depthSum(it.getList().orEmpty(), depth + 1)
            }
        }
        return result
    }
    return depthSum(nestedList, 1)
}

private fun main() {

}

class NestedInteger {
    // Constructor initializes an empty nested list.
    constructor()

    // Constructor initializes a single integer.
    constructor(value: Int)

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    fun isInteger(): Boolean {
        return false
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // The result is undefined if this NestedInteger holds a nested list
    fun getInteger(): Int? {
        return null
    }

    // Set this NestedInteger to hold a single integer.
    fun setInteger(value: Int): Unit {}

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    fun add(ni: NestedInteger): Unit {}

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // The result is undefined if this NestedInteger holds a single integer
    fun getList(): List<NestedInteger>? {
        return null
    }
}
