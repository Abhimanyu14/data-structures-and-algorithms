package data_structures.bitwise

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private class BitwiseOperationsTest {
    @Test
    fun shiftOperations() {
        assertEquals(1, 1 shl 0)
        assertEquals(2, 1 shl 1)
        assertEquals(20, 10 shl 1)
        assertEquals(5, 10 shr 1)
        assertEquals(4, 1 shl 2)
        assertEquals(8, 1 shl 3)
        assertEquals(128, 1 shl 7)
    }

    @Test
    fun andOperation() {
        assertEquals(0, 128 and 0)
        assertEquals(128, 128 and (1 shl 7))
    }
}
