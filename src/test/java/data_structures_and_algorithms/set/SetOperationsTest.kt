package data_structures_and_algorithms.set

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Use [setOf] to maintain order of adding keys
 * Use [sortedSetOf] to sort key-value pairs according to natural ordering of the keys.
 *
 * Methods
 * [MutableSet.add]
 *
 * [Set.elementAt]
 * [Set.first]
 * [Set.intersect]
 * [Set.last]
 * [Set.random]
 * [Set.toString]
 * [Set.union]
 *
 * Operators
 * [Set.plus] => [-]
 * [Set.minus] => [-]
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
        assertEquals(true, set.add(3))
        assertEquals(true, set.add(2))
        assertEquals(false, set.add(3))
        assertEquals(true, set.add(1))
        assertEquals(3, set.first())
        assertEquals(1, set.last())
        assertEquals("[3, 2, 1]", set.toString())
    }

    @Test
    fun sortedSetOperations() {
        val set = sortedSetOf<Int>()

        // add() returns boolean value
        assertEquals(true, set.add(3))
        assertEquals(true, set.add(2))
        assertEquals(false, set.add(3))
        assertEquals(true, set.add(1))
        assertEquals(true, set.add(-1))
        assertEquals(true, set.add(-100))
        assertEquals(-100, set.first())
        assertEquals(3, set.last())
        assertEquals("[-100, -1, 1, 2, 3]", set.toString())
    }
}

