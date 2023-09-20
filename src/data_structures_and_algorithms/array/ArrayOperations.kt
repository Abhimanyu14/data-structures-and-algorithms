package data_structures_and_algorithms.array

import data_structures_and_algorithms.linkedlist.ListNode

private fun main() {
    // Empty immutable array
    val emptyArray = arrayOf<Int>()
    println("Array Size: ${emptyArray.size}")

    // Array of int
    val arrayOfInt = arrayOf(1, 2)

    // Array of multiple data type
    val arrayOfMultipleDataType = arrayOf(1, 2, "")

    // Empty int array
    val emptyIntArray = IntArray(10)

    // Int Array with data
    val intArray = intArrayOf(1, 2, 3)

    // Array value can be changed
    intArray[1] = 10
    println("Int Array: ${intArray.joinToString(", ")}")

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
    println("Array Traversal")
    for (i in intArray) {
        println(i)
    }
    readLine()

}
