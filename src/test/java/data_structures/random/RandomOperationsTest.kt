package data_structures.random

import kotlin.random.Random
import org.junit.jupiter.api.Test

/**
 * Use [Random]
 *
 * Methods
 * [Random.nextInt]
 */
private class RandomOperationsTest {
    @Test
    fun randomOperation() {
        val randomInt = Random.nextInt(100) // 0 to 99
    }
}
