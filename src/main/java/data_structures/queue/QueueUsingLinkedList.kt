package data_structures.queue

import kotlin.math.max

private class QueueNode(
    val value: Int,
    var next: QueueNode? = null,
)

class QueueUsingLinkedList {
    private var start: QueueNode? = null
    private var end: QueueNode? = null
    var size = 0

    fun offer(x: Int) {
        if (start == null) {
            start = QueueNode(x)
            end = start
        } else {
            val newEnd = QueueNode(x)
            end?.next = newEnd
            end = newEnd
        }
        size++
    }

    fun poll(): Int? {
        val removedValue = start?.value
        start = start?.next
        size = max(0, size - 1)
        return removedValue
    }

    fun peek(): Int? {
        return start?.value
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun clear() {
        size = 0
        start = null
        end = null
    }

    override fun toString(): String {
        val result = StringBuilder()
        result.append('[')
        var current = start
        if (current != null) {
            result.append(current.value)
            current = current.next
        }
        while (current != null) {
            result.append(", ${current.value}")
            current = current.next
        }
        result.append(']')
        return result.toString()
    }
}