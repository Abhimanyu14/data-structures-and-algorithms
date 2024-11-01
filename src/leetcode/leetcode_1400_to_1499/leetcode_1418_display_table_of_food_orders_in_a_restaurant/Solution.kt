package leetcode.leetcode_1400_to_1499.leetcode_1418_display_table_of_food_orders_in_a_restaurant

/**
 * leetcode - https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/
 *
 * Using
 *
 * Stats
 *
 */

/*
private fun displayTable(orders: List<List<String>>): List<List<String>> {
    val foodItems = TreeSet<String>()
    val map = TreeMap<String, MutableMap<Int, Int>>()
    orders.forEach { order ->
        val table = order[1].toIntOrNull() ?: 0
        val orderFoodItem = order[2]
        foodItems.add(orderFoodItem)
        // Table in map
        if (map.contains(table)) {
            // Table has this food in map
            if (map[table]?.contains(orderFoodItem) == true) {
                map[table]?.put(orderFoodItem, map.getOrDefault(table, mutableMapOf()).getOrDefault(orderFoodItem, 0) + 1)
            } else {
                map[table]?.put(orderFoodItem, 1)
            }
        } else {
            map[table] = mutableMapOf(orderFoodItem to 1)
        }
    }
    val result = mutableListOf<List<String>>()
    val currentLine = mutableListOf("Table")
    foodItems.forEach {
        currentLine.add(it)
    }
    result.add(currentLine.toList())
    map.forEach { (table, foodCountMap) ->
        currentLine.clear()
        currentLine.add(table)
        foodItems.forEach { foodItem ->
            currentLine.add(foodCountMap[foodItem]?.toString() ?: "0")
        }
        result.add(currentLine.toList())
    }
    return result
}
*/

private fun main() {
//    displayTable(
//        listOf(
//            listOf("David", "3", "Ceviche"),
//            listOf("Corina", "10", "Beef Burrito"),
//            listOf("David", "3", "Fried Chicken"),
//            listOf("Carla", "5", "Water"),
//            listOf("Carla", "5", "Ceviche"),
//            listOf("Rous", "3", "Ceviche"),
//        )
//    )
}
