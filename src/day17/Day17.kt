package day17

import kotlin.math.min

val input = """
##..####
.###....
#.###.##
#....#..
...#..#.
#.#...##
..#.#.#.
.##...#.
""".trimIndent()

val testInput = """
.#.
..#
###
""".trimIndent()

val size = 30

fun main() {
    var state = parseInput(input)
    for (i in 1..6) {
        val nextSpace = createSpace()
        for (w in 1 until size - 1) {
            for (z in 1 until size - 1) {
                for (y in 1 until size - 1) {
                    for (x in 1 until size - 1) {
                        val activeNeighbors = getActiveNeighbors(x, y, z, w, state)
                        if (state[w][z][y][x]) {
                            if (activeNeighbors == 2 || activeNeighbors == 3) {
                                setToTrue(nextSpace, w, z, y, x)
                            }
                        } else {
                            if (activeNeighbors == 3) {
                                setToTrue(nextSpace, w, z, y, x)
                            }
                        }
                    }
                }
            }
        }
        state = nextSpace
        println("Cycle $i")
    }
    val totalActive = countActive(state)
    println("Total active: $totalActive")

}

private fun setToTrue(nextSpace: Array<Array<Array<BooleanArray>>>, w: Int, z: Int, y: Int, x: Int) {
    checkRange(w, z, y, x)
    nextSpace[w][z][y][x] = true
}

fun checkRange(w: Int, z: Int, y: Int, x: Int) {
    if (w == 0 || z == 0 || y == 0 || w == size - 1 || z == size - 1 || y == size - 1 || x == size - 1) {
        println("!! End of space reached: w: $w, z:$z, y:$y, x: $x")
    }
}

fun countActive(state: Array<Array<Array<BooleanArray>>>): Any {
    var active = 0
    state.forEach { wplane ->
        wplane.forEach { zplane ->
            zplane.forEach { row ->
                row.forEach { cell ->
                    if (cell) {
                        active++
                    }
                }
            }
        }
    }
    return active
}

fun getActiveNeighbors(xc: Int, yc: Int, zc: Int, wc: Int, state: Array<Array<Array<BooleanArray>>>): Int {
    var active = 0
    for (w in wc - 1..wc + 1) {
        for (z in zc - 1..zc + 1) {
            for (y in yc - 1..yc + 1) {
                for (x in xc - 1..xc + 1) {
                    if (x != xc || y != yc || z != zc || w != wc) {
                        if (state[w][z][y][x]) {
                            active++
                        }
                    }
                }
            }
        }
    }
    return active
}

fun parseInput(input: String): Array<Array<Array<BooleanArray>>> {
    val space = createSpace()
    val offset = size / 2
    val w = offset
    val z = offset
    input.lines().forEachIndexed { y, line ->
        line.forEachIndexed { x, c ->
            if (c == '#') {
                space[w][z][y + offset][x + offset] = true
            }
        }
    }
    return space
}

private fun createSpace(): Array<Array<Array<BooleanArray>>> {
    val space = Array<Array<Array<BooleanArray>>>(size) {
        Array<Array<BooleanArray>>(size) {
            Array<BooleanArray>(size) {
                BooleanArray(size) { false }
            }
        }
    }
    return space
}
