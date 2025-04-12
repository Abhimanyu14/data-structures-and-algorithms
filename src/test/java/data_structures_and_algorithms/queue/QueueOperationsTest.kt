package data_structures_and_algorithms.queue

import java.util.LinkedList
import java.util.Queue
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Use [Queue] or [ArrayDeque] for Queue
 *
 * Properties
 * size
 *
 * Methods
 * [Queue.offer] => [ArrayDeque.addLast]
 * [Queue.poll] => [ArrayDeque.removeLast]
 * [Queue.peek] => [ArrayDeque.first]
 * [Queue.isEmpty] => [ArrayDeque.isEmpty]
 * [Queue.clear] => [ArrayDeque.clear]
 */
class QueueOperationsTest {
    @Test
    fun usingJavaQueue() {
        val queue: Queue<Int> = LinkedList()
        assertEquals("[]", queue.toString())

        queue.offer(35)
        assertEquals("[35]", queue.toString())

        queue.offer(73)
        assertEquals("[35, 73]", queue.toString())

        queue.offer(52)
        assertEquals("[35, 73, 52]", queue.toString())

        val removed = queue.poll()
        assertEquals(35, removed)
        assertEquals("[73, 52]", queue.toString())

        assertEquals(73, queue.peek())

        assertEquals(false, queue.isEmpty())

        assertEquals(2, queue.size)

        queue.clear()
        assertEquals(0, queue.size)
    }

    @Test
    fun usingArrayDeque() {
        val queue = ArrayDeque<Int>()
        assertEquals("[]", queue.toString())

        queue.addLast(35)
        assertEquals("[35]", queue.toString())

        queue.addLast(73)
        assertEquals("[35, 73]", queue.toString())

        queue.addLast(52)
        assertEquals("[35, 73, 52]", queue.toString())

        val removed = queue.removeFirst()
        assertEquals(35, removed)
        assertEquals("[73, 52]", queue.toString())

        assertEquals(73, queue.first())

        assertEquals(false, queue.isEmpty())

        assertEquals(2, queue.size)

        queue.clear()
        assertEquals(0, queue.size)
    }

    @Test
    fun usingArray() {
        val queue = QueueUsingArray(3)
        assertEquals("[]", queue.toString())

        queue.offer(35)
        assertEquals("[35]", queue.toString())

        queue.offer(73)
        assertEquals("[35, 73]", queue.toString())

        queue.offer(52)
        assertEquals("[35, 73, 52]", queue.toString())

        val removed = queue.poll()
        assertEquals(35, removed)
        assertEquals("[73, 52]", queue.toString())

        assertEquals(73, queue.peek())

        assertEquals(false, queue.isEmpty())

        assertEquals(2, queue.size)

        queue.clear()
        assertEquals(0, queue.size)
    }

    @Test
    fun usingLinkedList() {
        val queue = QueueUsingLinkedList()
        assertEquals("[]", queue.toString())

        queue.offer(35)
        assertEquals("[35]", queue.toString())

        queue.offer(73)
        assertEquals("[35, 73]", queue.toString())

        queue.offer(52)
        assertEquals("[35, 73, 52]", queue.toString())

        val removed = queue.poll()
        assertEquals(35, removed)
        assertEquals("[73, 52]", queue.toString())

        assertEquals(73, queue.peek())

        assertEquals(false, queue.isEmpty())

        assertEquals(2, queue.size)

        queue.clear()
        assertEquals(0, queue.size)
    }

    @Test
    fun usingStack() {
        val queue = QueueUsingStack()
        assertEquals("[]", queue.toString())

        queue.offer(35)
        assertEquals("[35]", queue.toString())

        queue.offer(73)
        assertEquals("[35, 73]", queue.toString())

        queue.offer(52)
        assertEquals("[35, 73, 52]", queue.toString())

        val removed = queue.poll()
        assertEquals(35, removed)
        assertEquals("[73, 52]", queue.toString())

        assertEquals(73, queue.peek())

        assertEquals(false, queue.isEmpty())

        assertEquals(2, queue.size)

        queue.clear()
        assertEquals(0, queue.size)
    }
}
