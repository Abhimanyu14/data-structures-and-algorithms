package data_structures_and_algorithms.array

import data_structures_and_algorithms.linkedlist.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Use [Array]
 *
 * Properties
 * [Array.size]
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
        // Empty immutable array
        val emptyArray = arrayOf<Int>()
        assertEquals(0, emptyArray.size)

        // Array of int
        val arrayOfInt = arrayOf(1, 2)

        // Array of multiple data type
        val arrayOfMultipleDataType = arrayOf(1, 2, "")

        // Empty int array of given size
        val emptyIntArray = IntArray(10)

        // Int Array with data
        var intArray = intArrayOf(1, 2, 3)

        // Array value can be changed
        intArray[1] = 10
        assertEquals("1, 2, 3", intArray.joinToString(", "))

        // Other primitive arrays in Kotlin
        val charArray = charArrayOf('a', 'b')
        val floatArray = floatArrayOf(12F, 35.35F)
        val booleanArray = booleanArrayOf(true, false)
        val byteArray = byteArrayOf(1, 55)
        val doubleArray = doubleArrayOf(12.2, 23.5)
        val shortArray = shortArrayOf(123, 3443)
        val longArray = longArrayOf(12, 23)

        /**
         * Objects array with given size
         */
        val listNodesArray = arrayOfNulls<ListNode?>(10)

        /**
         * Array traversal
         */
        for (num in intArray) {
            //
        }

        intArray = intArrayOf(1, 4, 7, 9)
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
