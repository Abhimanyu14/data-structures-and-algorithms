package advent_of_code.day_02

import java.io.File
import kotlin.math.max

private data class BagConfig(
    val red: Int = 0,
    val green: Int = 0,
    val blue: Int = 0,
)

private data class Game(
    val id: Int,
    val bagConfigs: List<BagConfig>,
)

private fun Game.isPossible(bagConfig: BagConfig): Boolean {
    bagConfigs.forEach {
        if (bagConfig.red < it.red || bagConfig.blue < it.blue || bagConfig.green < it.green) {
            return false
        }
    }
    return true
}

private fun Game.minBagConfig(): BagConfig {
    var red = 0
    var green = 0
    var blue = 0
    bagConfigs.forEach {
        red = max(red, it.red)
        green = max(green, it.green)
        blue = max(blue, it.blue)
    }
    return BagConfig(
        red = red,
        green = green,
        blue = blue,
    )
}

private fun BagConfig.power(): Int {
    return red * blue * green
}

private fun solution1(games: List<Game>): Int {
    var result = 0
    val bagConfig = BagConfig(12, 13, 14)
    games.forEach { game ->
        if (game.isPossible(bagConfig)) {
            result += game.id
        }
    }
    return result
}

private fun solution2(games: List<Game>): Int {
    return games.sumOf {
        it.minBagConfig().power()
    }
}

private fun lineToGame(line: String): Game {
    val split = line.split(":")
    return Game(
        id = split[0].substring(5).toInt(),
        bagConfigs = split[1].split(";").map {
            stringToBagConfig(it)
        },
    )
}

private fun stringToBagConfig(string: String): BagConfig {
    var red = 0
    var blue = 0
    var green = 0
    string.split(",").forEach { substring ->
        if (substring.contains("red")) {
            red = substring.filter { it.isDigit() }.toInt()
        } else if (substring.contains("blue")) {
            blue = substring.filter { it.isDigit() }.toInt()
        } else if (substring.contains("green")) {
            green = substring.filter { it.isDigit() }.toInt()
        }
    }
    return BagConfig(
        red = red,
        green = green,
        blue = blue
    )
}

private fun main() {
    println(
        solution1(
            games = File("src/advent_of_code/day_02/input.txt")
                .readLines()
                .map {
                    lineToGame(it)
                },
        )
    )
    println(
        solution2(
            games = File("src/advent_of_code/day_02/input.txt")
                .readLines()
                .map {
                    lineToGame(it)
                },
        )
    )
}
