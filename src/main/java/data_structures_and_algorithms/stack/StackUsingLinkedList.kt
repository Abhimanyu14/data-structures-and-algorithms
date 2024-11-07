package data_structures_and_algorithms.stack

import kotlin.math.max

private class StackNode(
    val value: Int,
    var next: StackNode? = null,
)

class StackUsingLinkedList {
    private var top: StackNode? = null
    var size = 0

    fun push(x: Int) {
        val newTop = StackNode(x).apply {
            next = top
        }
        top = newTop
        size++
    }

    fun pop(): Int? {
        val removedValue = top?.value
        top = top?.next
        size = max(0, size - 1)
        return removedValue
    }

    fun peek(): Int? {
        return top?.value
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun clear() {
        size = 0
        top = null
    }

    override fun toString(): String {
        val result = StringBuilder()
        result.append(']')
        var current = top
        if (current != null) {
            result.insert(0, current.value)
            current = current.next
        }
        while (current != null) {
            result.insert(0, "${current.value}, ")
            current = current.next
        }
        result.insert(0, '[')
        return result.toString()
    }
}

