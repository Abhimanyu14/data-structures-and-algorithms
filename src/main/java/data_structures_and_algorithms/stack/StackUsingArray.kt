package data_structures_and_algorithms.stack

class StackUsingArray(
    private val maxSize: Int,
) {
    private val stack = IntArray(maxSize)
    var size = 0

    fun push(x: Int): Boolean {
        if (size == maxSize) {
            return false
        }
        stack[size] = x
        size++
        return true
    }

    fun pop(): Int? {
        if (size == 0) {
            return null
        }
        size--
        return stack[size]
    }

    fun peek(): Int {
        return stack[size - 1]
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun clear() {
        size = 0
    }

    override fun toString(): String {
        return "[${stack.take(size).joinToString(", ")}]"
    }
}

