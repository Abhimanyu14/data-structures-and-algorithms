package leetcode.leetcode_599_minimum_index_sum_of_two_lists

/**
 * leetcode - https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 *
 * Using Maps and Lists
 *
 * Stats
 * Runtime: 306 ms, faster than 66.67%
 * Memory Usage: 44.2 MB, less than 26.19%
 */
private fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
    val map1 = mutableMapOf<String, Int>()
    val map2 = mutableMapOf<String, Int>()
    list1.forEachIndexed { index, item ->
        map1[item] = index
    }
    list2.forEachIndexed { index, item ->
        map2[item] = index
    }
    val result = mutableListOf<String>()
    var leastIndexSum = Int.MAX_VALUE
    var indexSum: Int
    map1.forEach { (key, value) ->
        if (map2.contains(key)) {
            indexSum = value + (map2[key] ?: 0)
            if (indexSum < leastIndexSum) {
                leastIndexSum = indexSum
                result.clear()
                result.add(key)
            } else if (indexSum == leastIndexSum) {
                result.add(key)
            }
        }
    }
    return result.toTypedArray()
}

/**
 * leetcode -
 *
 * Using Set and Lists
 *
 * Stats
 * Runtime: 359 ms, faster than 38.09%
 * Memory Usage: 40.9 MB, less than 38.09%
 */
private fun findRestaurantUsingSet(list1: Array<String>, list2: Array<String>): Array<String> {
    val commonStrings = list1.toSet() intersect list2.toSet()
    val result = mutableListOf<String>()
    var leastIndexSum = Int.MAX_VALUE

    var indexSum: Int
    commonStrings.forEach {
        indexSum = list1.indexOf(it) + list2.indexOf(it)
        if (indexSum < leastIndexSum) {
            leastIndexSum = indexSum
            result.clear()
            result.add(it)
        } else if (indexSum == leastIndexSum) {
            result.add(it)
        }
    }
    return result.toTypedArray()
}

private fun main() {
    println(
        findRestaurant(
            arrayOf("Shogun", "Tapioca Express", "Burger King", "KFC"),
            arrayOf("Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"),
        )
    )
}
