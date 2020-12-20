package day20

//##.
//...
//...

var failed = false

fun main() {
    // rotate counter clockwise, same order

    var tile = createTestTile(1, """
...
...
##.
    """.trimIndent())
    tile.adjustImage(Direction.West, Direction.South, true)
    testPixels(tile,
            """
..#
..#
...
""".trimIndent())

    tile = createTestTile(2, """
..#
..#
...
    """.trimIndent())
    tile.adjustImage(Direction.South, Direction.East, true)
    testPixels(tile,
            """
##.
...
...
""".trimIndent())

    tile = createTestTile(3, """
##.
...
...
    """.trimIndent())
    tile.adjustImage(Direction.East, Direction.North, true)
    testPixels(tile,
            """
#..
#..
...
""".trimIndent())

    tile = createTestTile(4, """
#..
#..
...
    """.trimIndent())
    tile.adjustImage(Direction.North, Direction.West, true)
    testPixels(tile,
            """
...
...
##.
""".trimIndent())




    // rotate counter clockwise, reverse order

    tile = createTestTile(11, """
...
...
##.
    """.trimIndent())
    tile.adjustImage(Direction.West, Direction.South, false)
    testPixels(tile,
            """
...
..#
..#
""".trimIndent())

    tile = createTestTile(12, """
..#
..#
...
    """.trimIndent())
    tile.adjustImage(Direction.South, Direction.East, false)
    testPixels(tile,
            """
.##
...
...
""".trimIndent())

    tile = createTestTile(13, """
##.
...
...
    """.trimIndent())
    tile.adjustImage(Direction.East, Direction.North, false)
    testPixels(tile,
            """
...
#..
#..
""".trimIndent())

    tile = createTestTile(14, """
#..
#..
...
    """.trimIndent())
    tile.adjustImage(Direction.North, Direction.West, false)
    testPixels(tile,
            """
...
...
.##
""".trimIndent())



    // rotate clockwise, same order

    tile = createTestTile(21, """
...
...
##.
    """.trimIndent())
    tile.adjustImage(Direction.East, Direction.South, true)
    testPixels(tile,
            """
#..
#..
...
""".trimIndent())

    tile = createTestTile(22, """
..#
..#
...
    """.trimIndent())
    tile.adjustImage(Direction.North, Direction.East, true)
    testPixels(tile,
            """
...
...
##.
""".trimIndent())

    tile = createTestTile(23, """
##.
...
...
    """.trimIndent())
    tile.adjustImage(Direction.West, Direction.North, true)
    testPixels(tile,
            """
..#
..#
...
""".trimIndent())

    tile = createTestTile(24, """
#..
#..
...
    """.trimIndent())
    tile.adjustImage(Direction.South, Direction.West, true)
    testPixels(tile,
            """
##.
...
...
""".trimIndent())




    // rotate clockwise, reverse order

    tile = createTestTile(31, """
...
...
##.
    """.trimIndent())
    tile.adjustImage(Direction.East, Direction.South, false)
    testPixels(tile,
            """
...
#..
#..
""".trimIndent())

    tile = createTestTile(32, """
..#
..#
...
    """.trimIndent())
    tile.adjustImage(Direction.North, Direction.East, false)
    testPixels(tile,
            """
...
...
.##
""".trimIndent())

    tile = createTestTile(33, """
##.
...
...
    """.trimIndent())
    tile.adjustImage(Direction.West, Direction.North, false)
    testPixels(tile,
            """
...
..#
..#
""".trimIndent())

    tile = createTestTile(34, """
#.
#..
...
    """.trimIndent())
    tile.adjustImage(Direction.South, Direction.West, false)
    testPixels(tile,
            """
.##
...
...
""".trimIndent())



    println("\n\nFailed: $failed")
}

private fun createTestTile(id: Int, pixelString: String) = parseTiles("Tile $id:\n$pixelString")[0]

fun testPixels(tile: Tile, expected: String) {
    val actual = formatPixels(tile.pixels)
    if (actual != expected) {
        failed = true
        println("############# ERROR: **** expected: \n$expected\n**** actual: \n$actual\n\n")
    }

}
