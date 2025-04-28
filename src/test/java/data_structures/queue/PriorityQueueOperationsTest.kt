package data_structures.queue

import java.util.PriorityQueue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

/**
 * Use [PriorityQueue] for PriorityQueue
 *
 * Properties
 * [PriorityQueue.size]
 *
 * Methods
 * [PriorityQueue.offer]
 * [PriorityQueue.poll]
 * [PriorityQueue.peek]
 * [PriorityQueue.isEmpty]
 * [PriorityQueue.clear]
 */
class PriorityQueueOperationsTest {
    @Test
    fun usingJavaPriorityQueue() {
        val priorityQueue = PriorityQueue<Int>()
        assertEquals("[]", priorityQueue.toString())

        priorityQueue.offer(35)
        assertEquals("[35]", priorityQueue.toString())

        var removed: Int? = priorityQueue.poll()
        assertEquals(35, removed)
        assertEquals("[]", priorityQueue.toString())

        removed = priorityQueue.poll()
        assertNull(removed)
        assertEquals("[]", priorityQueue.toString())

        val peek = priorityQueue.peek()
        assertNull(peek)
        assertEquals("[]", priorityQueue.toString())

        priorityQueue.offer(73)
        assertEquals("[73]", priorityQueue.toString())

        priorityQueue.offer(52)
        assertEquals("[52, 73]", priorityQueue.toString())

        removed = priorityQueue.poll()
        assertEquals(52, removed)
        assertEquals("[73]", priorityQueue.toString())

        assertEquals(73, priorityQueue.first())

        assertEquals(false, priorityQueue.isEmpty())

        assertEquals(1, priorityQueue.size)

        priorityQueue.clear()
        assertEquals(0, priorityQueue.size)
    }
}
