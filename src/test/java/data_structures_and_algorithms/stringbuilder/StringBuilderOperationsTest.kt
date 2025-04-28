package data_structures_and_algorithms.stringbuilder

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Properties
 * [StringBuilder.length]
 *
 * Methods
 * [StringBuilder.append]
 * [StringBuilder.clear]
 * [StringBuilder.deleteCharAt]
 * [StringBuilder.insert]
 * [StringBuilder.isEmpty]
 * [StringBuilder.isNotEmpty]
 * [StringBuilder.toString]
 */
class StringBuilderOperationsTest {
    @Test
    fun stringBuilderTest() {
        val stringBuilder = StringBuilder()

        stringBuilder.append('a')
        assertEquals("a", stringBuilder.toString())

        stringBuilder.append("bc")
        assertEquals("abc", stringBuilder.toString())

        stringBuilder.append(12)
        assertEquals("abc12", stringBuilder.toString())

        stringBuilder.insert(1, 'x')
        assertEquals("axbc12", stringBuilder.toString())

        stringBuilder.deleteCharAt(1)
        assertEquals("abc12", stringBuilder.toString())

        stringBuilder.append(12.0)
        assertEquals("abc1212.0", stringBuilder.toString())

        stringBuilder.append(12L)
        assertEquals("abc1212.012", stringBuilder.toString())

        stringBuilder.append(true)
        assertEquals("abc1212.012true", stringBuilder.toString())

        stringBuilder.append(false)
        assertEquals("abc1212.012truefalse", stringBuilder.toString())

        stringBuilder.append("abc")
        assertEquals("abc1212.012truefalseabc", stringBuilder.toString())

        val removedString = stringBuilder.removeRange(stringBuilder.lastIndex - 2, stringBuilder.length)
        assertEquals("abc1212.012truefalse", removedString.toString())
        assertEquals("abc1212.012truefalseabc", stringBuilder.toString())

        assertEquals(23, stringBuilder.length)

        stringBuilder.clear()
        assertEquals("", stringBuilder.toString())
        assertEquals(0, stringBuilder.length)
    }
}
