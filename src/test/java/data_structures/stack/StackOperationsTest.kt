package data_structures.stack

import java.util.Stack
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Use [Stack] or [ArrayDeque] for Stack
 *
 * Properties
 * [Stack.size] => [ArrayDeque.size]
 *
 * Methods
 * [Stack.push] => [ArrayDeque.addLast]
 * [Stack.pop] => [ArrayDeque.removeLast]
 * [Stack.peek] => [ArrayDeque.last]
 *
 * [Stack.clear] => [ArrayDeque.clear]
 * [Stack.isEmpty] => [ArrayDeque.isEmpty]
 */
class StackOperationsTest {
    @Test
    fun usingJavaStack() {
        val stack = Stack<Int>()
        assertEquals("[]", stack.toString())

        stack.push(35)
        assertEquals("[35]", stack.toString())

        stack.push(73)
        assertEquals("[35, 73]", stack.toString())

        stack.push(52)
        assertEquals("[35, 73, 52]", stack.toString())

        val popped = stack.pop()
        assertEquals(52, popped)
        assertEquals("[35, 73]", stack.toString())

        assertEquals(73, stack.peek())

        assertEquals(false, stack.isEmpty())

        assertEquals(2, stack.size)

        stack.clear()
        assertEquals(0, stack.size)
    }

    @Test
    fun usingArrayDeque() {
        val stack = ArrayDeque<Int>()
        assertEquals("[]", stack.toString())

        stack.addLast(35)
        assertEquals("[35]", stack.toString())

        stack.addLast(73)
        assertEquals("[35, 73]", stack.toString())

        stack.addLast(52)
        assertEquals("[35, 73, 52]", stack.toString())

        val popped = stack.removeLast()
        assertEquals(52, popped)
        assertEquals("[35, 73]", stack.toString())

        assertEquals(73, stack.last())

        assertEquals(false, stack.isEmpty())

        assertEquals(2, stack.size)

        stack.clear()
        assertEquals(0, stack.size)
    }

    @Test
    fun usingArray() {
        val stack = StackUsingArray(10)
        assertEquals("[]", stack.toString())

        stack.push(35)
        assertEquals("[35]", stack.toString())

        stack.push(73)
        assertEquals("[35, 73]", stack.toString())

        stack.push(52)
        assertEquals("[35, 73, 52]", stack.toString())

        val popped = stack.pop()
        assertEquals(52, popped)
        assertEquals("[35, 73]", stack.toString())

        assertEquals(73, stack.peek())

        assertEquals(false, stack.isEmpty())

        assertEquals(2, stack.size)

        stack.clear()
        assertEquals(0, stack.size)
    }

    @Test
    fun usingLinkedList() {
        val stack = StackUsingLinkedList()
        assertEquals("[]", stack.toString())

        stack.push(35)
        assertEquals("[35]", stack.toString())

        stack.push(73)
        assertEquals("[35, 73]", stack.toString())

        stack.push(52)
        assertEquals("[35, 73, 52]", stack.toString())

        val popped = stack.pop()
        assertEquals(52, popped)
        assertEquals("[35, 73]", stack.toString())

        assertEquals(73, stack.peek())

        assertEquals(false, stack.isEmpty())

        assertEquals(2, stack.size)

        stack.clear()
        assertEquals(0, stack.size)
    }

    @Test
    fun usingQueue() {
        val stack = StackUsingQueue()
        assertEquals("[]", stack.toString())

        stack.push(35)
        assertEquals("[35]", stack.toString())

        stack.push(73)
        assertEquals("[35, 73]", stack.toString())

        stack.push(52)
        assertEquals("[35, 73, 52]", stack.toString())

        val popped = stack.pop()
        assertEquals(52, popped)
        assertEquals("[35, 73]", stack.toString())

        assertEquals(73, stack.peek())

        assertEquals(false, stack.isEmpty())

        assertEquals(2, stack.size)

        stack.clear()
        assertEquals(0, stack.size)
    }
}
