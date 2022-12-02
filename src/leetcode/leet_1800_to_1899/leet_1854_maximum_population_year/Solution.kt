package leetcode.leet_1800_to_1899.leet_1854_maximum_population_year

/**
 * Using loops and hashmap
 *
 * Stats
 * Runtime: 366 ms, faster than 25.00%
 * Memory Usage: 36.4 MB, less than 62.50%
 */
private fun maximumPopulation(logs: Array<IntArray>): Int {
    val population = mutableMapOf<Int, Int>()
    logs.forEach {
        population[it[0]] = 0
        population[it[1]] = 0
    }
    var resultYear = Int.MAX_VALUE
    var resultPopulation = 0
    population.keys.forEach { year ->
        logs.forEach { log ->
            if (log[0] <= year && year < log[1]) {
                population[year] = 1 + (population[year] ?: 0)
            }
        }
        if ((population[year] ?: 0) > resultPopulation) {
            resultYear = year
            resultPopulation = population[year] ?: 0
        } else if ((population[year] ?: 0) == resultPopulation && year < resultYear) {
            resultYear = year
            resultPopulation = population[year] ?: 0
        }
    }
    return resultYear
}

private fun main() {

}
