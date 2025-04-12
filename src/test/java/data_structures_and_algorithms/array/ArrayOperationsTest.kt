package data_structures_and_algorithms.array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Use [Array]
 *
 * Methods
 * [Array.clone]
 * [Array.sort]
 * [Array.sorted]
 * [Array.toString]
 * [Array.joinToString]
 */
private class ArrayOperationsTest {
    @Test
    fun arrayOperations() {
        val intArray = intArrayOf(1, 4, 7, 9)
        val clone = intArray.clone()
        intArray[3] = 23
        assertEquals("1, 4, 7, 9", clone.joinToString())
        assertEquals("1, 4, 7, 23", intArray.joinToString())

        val originalArray = intArrayOf(16, 4, 1, 7, 10)
        assertEquals("[1, 4, 7, 10, 16]", originalArray.sorted().toString())
        assertEquals("16, 4, 1, 7, 10", originalArray.joinToString())

        originalArray.sort()
        assertEquals("1, 4, 7, 10, 16", originalArray.joinToString())
    }
}
