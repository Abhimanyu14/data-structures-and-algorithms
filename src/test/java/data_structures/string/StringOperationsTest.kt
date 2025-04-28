package data_structures.string

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Properties
 * [String.lastIndex]
 * [String.length]
 *
 * Methods
 * [String.equals]
 * [String.first]
 * [String.isEmpty]
 * [String.isNotEmpty]
 * [String.last]
 * [String.repeat]
 * [String.substring]
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
        assertEquals("A new StringA new StringA new String", string.repeat(3))
        assertEquals("ew String", string.substring(3))
        assertEquals("ew S", string.substring(3, 7))

        assertEquals(false, "ABC" == "abc")
        assertEquals(true, "ABC".equals("abc", true))
    }
}
