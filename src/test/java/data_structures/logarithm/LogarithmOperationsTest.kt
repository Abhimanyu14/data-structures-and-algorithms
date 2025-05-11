package data_structures.logarithm

import kotlin.math.ln
import kotlin.math.log
import kotlin.math.log10
import kotlin.math.log2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Methods
 * [log2]
 * [ln]
 * [log]
 * [log10]
 */
class LogarithmOperationsTest {
    @Test
    fun logarithm() {
        assertEquals(Double.NEGATIVE_INFINITY, log2(0.0))
        assertEquals(0.0, log2(1.0))
        assertEquals(1.0, log2(2.0))
        assertEquals(2.0, log2(4.0))
        assertEquals(3.0, log2(8.0))
        assertEquals(3.3219280948873626, log2(10.0))
        assertEquals(4.0, log2(16.0))
        assertEquals(6.643856189774725, log2(100.0))

        assertEquals(1.0, ln(Math.E))

        assertEquals(1.0, log(5.0,5.0))
        assertEquals(2.0, log(25.0,5.0))

        assertEquals(Double.NEGATIVE_INFINITY, log10(0.0))
        assertEquals(0.0, log10(1.0))
        assertEquals(1.0, log10(10.0))
        assertEquals(2.0, log10(100.0))
        assertEquals(3.0, log10(1000.0))
    }
}
