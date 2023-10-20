package leetcode.leet_300_to_399.leet_341_flatten_nested_list_iterator

/**
 * leetcode - https://leetcode.com/problems/flatten-nested-list-iterator/
 *
 * Using iteration and processing input
 *
 * Stats
 * Runtime: 191 ms, faster than 95.00%
 * Memory Usage: 38 MB, less than 85.00%
 */
private class NestedIterator(nestedList: List<NestedInteger>) {
    private var currentIndex = 0
    private val processedList = mutableListOf<Int>()

    init {
        nestedList.forEach {
            processNestedInteger(it)
        }
    }

    fun processNestedInteger(n: NestedInteger) {
        if (n.isInteger()) {
            n.getInteger()?.let {
                processedList.add(it)
            }
        } else {
            n.getList()?.let {
                it.forEach { ni ->
                    processNestedInteger(ni)
                }
            }
        }
    }


    fun next(): Int {
        return processedList[currentIndex++]
    }

    fun hasNext(): Boolean {
        return currentIndex < processedList.size
    }
}

private fun main() {

}

private class NestedInteger {
    // Constructor initializes an empty nested list.
    constructor()

    // Constructor initializes a single integer.
    constructor(value: Int)

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    fun isInteger(): Boolean {
        return true
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    fun getInteger(): Int? {
        return null
    }

    // Set this NestedInteger to hold a single integer.
    fun setInteger(value: Int): Unit {}

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    fun add(ni: NestedInteger): Unit {}

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    fun getList(): List<NestedInteger>? {
        return null
    }
}
