package data_structures.queue

import java.util.Stack

class QueueUsingStack {
    private val buffer = Stack<Int>()
    private val stack = Stack<Int>()
    val size: Int
        get() = stack.size

    fun offer(x: Int) {
        while (stack.isNotEmpty()) {
            buffer.push(stack.pop())
        }
        stack.push(x)
        while (buffer.isNotEmpty()) {
            stack.push(buffer.pop())
        }
    }

    fun poll(): Int? {
        return stack.pop()
    }

    fun peek(): Int? {
        return stack.peek()
    }

    fun isEmpty(): Boolean {
        return stack.isEmpty()
    }

    fun clear() {
        stack.clear()
    }

    override fun toString(): String {
        val result = StringBuilder()
        result.append('[')
        if (stack.isNotEmpty()) {
            val popped = stack.pop()
            result.append(popped)
            buffer.push(popped)
        }
        while (stack.isNotEmpty()) {
            val popped = stack.pop()
            result.append(", $popped")
            buffer.push(popped)
        }
        while (buffer.isNotEmpty()) {
            stack.push(buffer.pop())
        }
        result.append(']')
        return result.toString()
    }
}

class QueueUsingStackOptimizingPush {
    private val buffer = Stack<Int>()
    private val stack = Stack<Int>()
    val size: Int
        get() = stack.size + buffer.size

    fun offer(x: Int) {
        stack.push(x)
    }

    fun poll(): Int? {
        return if (buffer.isNotEmpty()) {
            buffer.pop()
        } else {
            while (stack.isNotEmpty()) {
                buffer.push(stack.pop())
            }
            buffer.pop()
        }
    }

    fun peek(): Int? {
        return if (buffer.isNotEmpty()) {
            buffer.peek()
        } else {
            while (stack.isNotEmpty()) {
                buffer.push(stack.pop())
            }
            buffer.peek()
        }
    }

    fun isEmpty(): Boolean {
        return stack.isEmpty() && buffer.isEmpty()
    }

    fun clear() {
        stack.clear()
        buffer.clear()
    }

    override fun toString(): String {
        // TODO(Abhi): Fix this later
        val result = StringBuilder()
        result.append('[')
        if (stack.isNotEmpty()) {
            val popped = stack.pop()
            result.append(popped)
            buffer.push(popped)
        }
        while (stack.isNotEmpty()) {
            val popped = stack.pop()
            result.append(", $popped")
            buffer.push(popped)
        }
        while (buffer.isNotEmpty()) {
            stack.push(buffer.pop())
        }
        result.append(']')
        return result.toString()
    }
}
