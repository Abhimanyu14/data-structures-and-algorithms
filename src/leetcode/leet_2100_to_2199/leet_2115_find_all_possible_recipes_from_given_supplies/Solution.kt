package leetcode.leet_2100_to_2199.leet_2115_find_all_possible_recipes_from_given_supplies

/**
 * leetcode - https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
 *
 * TODO-Abhi: WIP
 *
 * Using
 *
 * Stats
 *
 */
private fun findAllRecipes(
    recipes: Array<String>,
    ingredients: List<List<String>>,
    supplies: Array<String>,
): List<String> {
    val map = mutableMapOf<String, List<String>>()
    val result = mutableListOf<String>()
    val set = mutableSetOf<String>()
    for (i in recipes.indices) {
        map[recipes[i]] = ingredients[i]
    }

    fun canMake(item: String): Boolean {
        if (set.contains(item)) {
            return true
        }
        if (!map.contains(item)) {
            return false
        }
        val recipeIngredients = map[item] ?: emptyList()
        for (i in recipeIngredients) {
            if (!(supplies.contains(i) || canMake(i))) {
                return false
            }
        }
        set.add(item)
        return true
    }
    recipes.forEach {
        if (canMake(it)) {
            result.add(it)
        }
    }
    return result
}

private fun main() {
    println(
        findAllRecipes(
            arrayOf("ju", "fzjnm", "x", "e", "zpmcz", "h", "q"),
            listOf(
                listOf("d"),
                listOf("hveml", "f", "cpivl"),
                listOf("cpivl", "zpmcz", "h", "e", "fzjnm", "ju"),
                listOf("cpivl", "hveml", "zpmcz", "ju", "h"),
                listOf("h", "fzjnm", "e", "q", "x"),
                listOf("d", "hveml", "cpivl", "q", "zpmcz", "ju", "e", "x"),
                listOf("f", "hveml", "cpivl"),
            ),
            arrayOf("f", "hveml", "cpivl", "d"),
        )
    )
}
