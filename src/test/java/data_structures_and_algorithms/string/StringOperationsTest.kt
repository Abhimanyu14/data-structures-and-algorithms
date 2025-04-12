package data_structures_and_algorithms.string

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Properties
 * [String.length]
 * [String.lastIndex]
 *
 * Methods
 * [String.first]
 * [String.last]
 * [String.isEmpty]
 * [String.isNotEmpty]
 * [String.equals]
 */
class StringOperationsTest {
    @Test
    fun stringTest() {
        val string = "A new String"
        assertEquals(12, string.length)
        assertEquals(11, string.lastIndex)
        assertEquals('A', string.first())
        assertEquals('g', string.last())
        assertEquals(false, string.isEmpty())
        assertEquals(true, string.isNotEmpty())

        assertEquals(false, "ABC" == "abc")
        assertEquals(true, "ABC".equals("abc", true))
    }
}
