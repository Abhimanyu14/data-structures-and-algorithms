package leetcode.leet_2300_to_2399.leet_2353_design_a_food_rating_system

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/design-a-food-rating-system/
 *
 * Using priority queue and map
 *
 * Stats
 * Runtime: 3606 ms, faster than 20.00
 * Memory Usage: 87.2 MB, less than 100.00%
 */
private class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {
    private val map = mutableMapOf<String, PriorityQueue<Pair<String, Int>>>()
    private val foodCuisineMap: Map<String, String>

    init {
        for (i in foods.indices) {
            map.computeIfAbsent(cuisines[i]) {
                PriorityQueue { p1, p2 ->
                    if (p2.second > p1.second) {
                        1
                    } else if (p2.second < p1.second) {
                        -1
                    } else {
                        p1.first.compareTo(p2.first)
                    }
                }
            }.offer(Pair(foods[i], ratings[i]))
        }
        foodCuisineMap = foods.zip(cuisines).toMap()
    }

    fun changeRating(food: String, newRating: Int) {
        map[foodCuisineMap[food]]?.first { it.first == food }?.let {
            map[foodCuisineMap[food]]?.remove(it)
        }
        map[foodCuisineMap[food]]?.offer(Pair(food, newRating))
    }

    fun highestRated(cuisine: String): String {
        return map[cuisine]?.peek()?.first.orEmpty()
    }
}

private fun main() {

}
