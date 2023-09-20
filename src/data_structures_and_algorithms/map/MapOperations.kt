package data_structures_and_algorithms.map

/**
 * Use listOf or mutableListOf
 *
 * keys, values, computeIfAbsent
 */
fun main() {
    val map = mutableMapOf(
        1 to "A",
        2 to "B",
        3 to "D",
        4 to "E",
        5 to "A",
    )

    // keys
    println(map.keys)

    // values
    println(map.values.toList())

    // iteration
    map.forEach {
        print("{${it.key} : ${it.value} }, ")
    }
    println()

    val mapOfList = mutableMapOf(
        1 to mutableListOf(1, 2, 3),
        2 to mutableListOf(4, 5, 6),
        3 to mutableListOf(7, 8, 9),
        4 to mutableListOf(10),
    )
    mapOfList.computeIfAbsent(4) {
        mutableListOf()
    }.add(11)
    mapOfList.computeIfAbsent(5) {
        mutableListOf()
    }.add(13)
    println(mapOfList)
}
