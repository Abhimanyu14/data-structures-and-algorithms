package data_structures_and_algorithms.common

/**
 * Anagrams
 *
 * Using counter map
 */
private fun isAnagram(str1: String, str2: String): Boolean {
    val counter1 = mutableMapOf<Char, Int>()
    val counter2 = mutableMapOf<Char, Int>()
    str1.forEach {
        counter1[it] = counter1.getOrDefault(it, 0) + 1
    }
    str2.forEach {
        counter2[it] = counter2.getOrDefault(it, 0) + 1
    }
    for ((key, value) in counter1) {
        if (counter2[key] != value) {
            return false
        }
    }
    return counter1.keys.size == counter2.keys.size
}

private fun main() {
    println(isAnagram("test", "sett"))
}
