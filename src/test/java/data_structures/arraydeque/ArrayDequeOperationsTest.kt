package data_structures.arraydeque

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Properties
 * [ArrayDeque.size]
 *
 *  Methods
 * [ArrayDeque.addFirst]
 * [ArrayDeque.addLast]
 * [ArrayDeque.removeFirst]
 * [ArrayDeque.removeLast]
 * [ArrayDeque.first]
 * [ArrayDeque.last]
 * [ArrayDeque.toString]
 * [ArrayDeque.joinToString]
 * [ArrayDeque.isEmpty]
 * [ArrayDeque.isNotEmpty]
 * [ArrayDeque.clear]
 */
class StackOperationsTest {
    @Test
    fun usingArrayDeque() {
        val arrayDeque = ArrayDeque<Int>()
        assertEquals("[]", arrayDeque.toString())

        arrayDeque.addLast(35)
        assertEquals("[35]", arrayDeque.toString())

        arrayDeque.addLast(73)
        assertEquals("[35, 73]", arrayDeque.toString())

        arrayDeque.addFirst(52)
        assertEquals("[52, 35, 73]", arrayDeque.toString())

        assertEquals("52, 35, 73", arrayDeque.joinToString())
        assertEquals("523573", arrayDeque.joinToString(""))
        assertEquals("52:35:73", arrayDeque.joinToString(":"))

        var removedItem = arrayDeque.removeLast()
        assertEquals(73, removedItem)
        assertEquals("[52, 35]", arrayDeque.toString())

        assertEquals(52, arrayDeque.first())
        assertEquals(35, arrayDeque.last())

        assertEquals(false, arrayDeque.isEmpty())
        assertEquals(true, arrayDeque.isNotEmpty())

        assertEquals(2, arrayDeque.size)

        removedItem = arrayDeque.removeFirst()
        assertEquals(52, removedItem)
        assertEquals("[35]", arrayDeque.toString())

        arrayDeque.clear()
        assertEquals(0, arrayDeque.size)
    }
}
