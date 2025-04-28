package data_structures.list

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Use [listOf] or [mutableListOf]
 *
 * Methods
 * [List.sorted]
 * [List.sortedDescending]
 * [List.filterNot]
 *
 * [MutableList.add]
 * [MutableList.addAll]
 * [MutableList.remove]
 * [MutableList.removeAt]
 * [MutableList.removeAll]
 * [MutableList.sort]
 * [MutableList.sortDescending]
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

        assertEquals(listOf(2, 3, 3, 5, 6, 6, 8, 27, 45, 68), list.sorted())
        assertEquals(listOf(45, 5, 27, 8, 3, 68, 3, 6, 2, 6), list)

        assertEquals(listOf(68, 45, 27, 8, 6, 6, 5, 3, 3, 2), list.sortedDescending())
        assertEquals(listOf(45, 5, 27, 8, 3, 68, 3, 6, 2, 6), list)

        list.sort()
        assertEquals(listOf(2, 3, 3, 5, 6, 6, 8, 27, 45, 68), list)

        list.sortDescending()
        assertEquals(listOf(68, 45, 27, 8, 6, 6, 5, 3, 3, 2), list)
    }
}
