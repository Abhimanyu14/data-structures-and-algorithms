package data_structures_and_algorithms.set

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Use [setOf]
 *
 * Methods
 * [Set.union], [Set.intersect], [Set.random], [MutableSet.add]
 *
 * Operators
 * [+], [-]
 */
private class SetOperationsTest {
    @Test
    fun setOperations() {
        val set1 = setOf(1, 2, 3)
        val set2 = setOf(3, 4, 5)

        val union = set1 union set2
        assertEquals(setOf(1, 2, 3, 4, 5), union)

        val intersection = set1 intersect set2
        assertEquals(setOf(3), intersection)

        val difference2From1 = set1 - set2
        assertEquals(setOf(1, 2), difference2From1)

        val difference1From2 = set2 - set1
        assertEquals(setOf(4, 5), difference1From2)

        assertEquals(setOf(1, 2, 3, 23), set1 + 23) // Plus
        assertEquals(setOf(1, 2, 3), set1)

        assertEquals(setOf(1, 2, 3), set1 - 45) // Minus
        assertEquals(setOf(1, 3), set1 - 2) // Minus
        assertEquals(setOf(1, 2, 3), set1)

        // assertEquals(3, set1.random())

        val set3 = setOf(35, 78, 32)
        assertEquals(35, set3.elementAt(0))
        assertEquals(78, set3.elementAt(1))
        assertEquals(32, set3.elementAt(2))
    }

    @Test
    fun mutableSetOperations() {
        val set = mutableSetOf<Int>()

        // add() returns boolean value
        assertEquals(true, set.add(1))
        assertEquals(true, set.add(2))
        assertEquals(true, set.add(3))
        assertEquals(false, set.add(1))
    }
}

