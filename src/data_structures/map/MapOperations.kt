package data_structures.map

/**
 * Use listOf or mutableListOf
 *
 * keys,
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

    // iteration
    map.forEach {
        print("{${it.key} : ${it.value} }, ")
    }
}
