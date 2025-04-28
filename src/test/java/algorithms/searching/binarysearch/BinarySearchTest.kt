package algorithms.searching.binarysearch

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private class BinarySearchTest {
    @Test
    fun findIndexOfTarget() {
        val input = intArrayOf(1, 2, 5, 7, 9, 10, 23, 45, 67)
        var result = binarySearch(input, 1)
        assertEquals(0, result)

        result = binarySearch(input, 1)
        assertEquals(0, result)

        result = binarySearch(input, 5)
        assertEquals(2, result)

        result = binarySearch(input, 9)
        assertEquals(4, result)

        result = binarySearch(input, 23)
        assertEquals(6, result)

        result = binarySearch(input, 67)
        assertEquals(8, result)
    }
}
