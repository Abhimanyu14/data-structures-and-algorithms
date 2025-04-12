package data_structures_and_algorithms.map

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Use [linkedMapOf] to maintain order of adding keys
 * Use [sortedMapOf] to sort key-value pairs according to natural ordering of the keys.
 *
 * Methods
 * [Map.computeIfAbsent]
 */
class MapOperationsTest {
    @Test
    fun usingMutableMap() {
        val map = mutableMapOf(
            1 to "A",
            2 to "B",
            3 to "D",
            4 to "E",
            5 to "A",
        )

        assertEquals(setOf(1, 2, 3, 4, 5), map.keys)

        assertEquals(listOf("A", "B", "D", "E", "A"), map.values.toList())

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
        mapOfList.computeIfAbsent(5) {
            mutableListOf()
        }.add(15)
        assertEquals(
            mapOf(
                1 to mutableListOf(1, 2, 3),
                2 to mutableListOf(4, 5, 6),
                3 to mutableListOf(7, 8, 9),
                4 to mutableListOf(10, 11),
                5 to mutableListOf(13, 15),
            ), mapOfList
        )
    }

    @Test
    fun usingLinkedMap() {
        val orderedMap = linkedMapOf(
            1 to "A",
            4 to "E",
            2 to "B",
            5 to "A",
            3 to "D",
        )

        assertEquals(listOf(1, 4, 2, 5, 3), orderedMap.keys.toList())

        assertEquals(listOf("A", "E", "B", "A", "D"), orderedMap.values.toList())
    }

    @Test
    fun usingSortedMap() {
        val sortedMap = sortedMapOf(
            1 to "A",
            4 to "E",
            2 to "B",
            5 to "A",
            3 to "D",
        )

        assertEquals(listOf(1, 2, 3, 4, 5), sortedMap.keys.toList())

        assertEquals(listOf("A", "B", "D", "E", "A"), sortedMap.values.toList())
    }
}
