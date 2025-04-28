package data_structures.character

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Properties
 *
 * Methods
 * [Char.digitToInt]
 * [Char.isDigit]
 * [Char.isLetter]
 * [Char.isLetterOrDigit]
 * [Char.isLowerCase]
 * [Char.isUpperCase]
 * [Char.lowercase]
 * [Char.uppercase]
 */
class CharacterOperationsTest {
    @Test
    fun characterTest() {
        assertEquals(true, '2'.isDigit())
        assertEquals(false, '2'.isLetter())
        assertEquals(true, 'a'.isLetter())
        assertEquals(true, 'A'.isLetter())
        assertEquals(false, 'A'.isLowerCase())
        assertEquals(true, 'A'.isUpperCase())
        assertEquals("a", 'A'.lowercase())
        assertEquals("A", 'a'.uppercase())
        assertEquals(true, 'A'.isLetterOrDigit())
        assertEquals(true, '6'.isLetterOrDigit())
        assertEquals(6, '6'.digitToInt())
    }
}
