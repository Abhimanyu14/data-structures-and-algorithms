package data_structures_and_algorithms.list

/**
 * Use listOf or mutableListOf
 *
 * sorted(), filterNot{},
 */
private fun main() {
    val list = listOf(5, 27, 8, 3, 68, 3, 6, 2, 6)

    // Sorted
    println(list.sorted())
    println(list)

    // filterNot
    println(list.filterNot { it > 25 })
}
