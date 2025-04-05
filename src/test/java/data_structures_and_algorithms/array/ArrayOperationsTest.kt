package data_structures_and_algorithms.array

import kotlin.random.Random
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * TODO(Abhi) - To revisit
 *
 * Use [Array]
 *
 * Methods
 * [Array.clone]
 */
private class ArrayOperationsTest {

    @Test
    fun arrayOperations() {
        val intArray = intArrayOf(1, 4, 7, 9)
        val clone = intArray.clone()
        intArray[3] = 23
        assertEquals("1, 4, 7, 9", clone.joinToString())
        assertEquals("1, 4, 7, 23", intArray.joinToString())
    }
}
