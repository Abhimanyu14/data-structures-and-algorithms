package data_structures_and_algorithms.list

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * TODO(Abhi) - To revisit
 *
 * Use [listOf] or [mutableListOf]
 *
 * Methods - [List.sorted],  [List.filterNot { }], [MutableList.add]
 */
private class ListOperationsTest {
    @Test
    fun listOperationsTest() {
        val list = listOf(5, 27, 8, 3, 68, 3, 6, 2, 6)

        // Sorted
        assertEquals(listOf(2, 3, 3, 5, 6, 6, 8, 27, 68), list.sorted())
        assertEquals(listOf(5, 27, 8, 3, 68, 3, 6, 2, 6), list)

        // filterNot
        assertEquals(listOf(5, 8, 3, 3, 6, 2, 6), list.filterNot { it > 25 })
    }

    @Test
    fun mutableListOperationsTest() {
        val list = mutableListOf(5, 27, 8, 3, 68, 3, 6, 2, 6)

        list.add(0, 45) // Index as first parameter
        assertEquals(listOf(45, 5, 27, 8, 3, 68, 3, 6, 2, 6), list)
    }
}