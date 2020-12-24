package day24

import java.lang.IllegalArgumentException

val input = """
nwesesesesewswenwswsesesenesenwnesenwse
nwnenwnwnenenwnenwnenewnwenenwwnenesesenw
neneswnenwenwseeneweswsenesewnenenee
senwewnwnenenwnwnwwesenenwswnenwwnwnw
swseseeseswseseeswseneseswsesesenwsesew
weeneeneswsewnwnesweseneswenwneswne
swseseswswneswswsesewswswseswse
swswseeswswwswnweenewswswesenwswwse
swswswswsweswseeswseseseseeswwsewnw
eneeseenenweeneenenee
eesesenwsesweeseeese
neenenenewnenenenenenwnenenenwnwne
nenenwnwnwnenwnenwnwswnenesenenwnw
neneweweneneenenenenesewneeneenee
nwweswswewneenenwneneneeswneneneswne
eeseeneseesesesewneswseeeseese
swseswsenwswnewswseswswswseswswse
senenenwnwnenwnwnwewnwwnwswnenenwnwnwenw
senwnenenwnwnenwnwwnwswnwnwnenwnwenenwnw
neweseneswswnwswnwswseneseenwseeswee
esesweeneeneswsenwsweeeeseeseee
nenenwewseswseseswsewseneewwwnww
neeswswenwnewnwnwwswwwneswswnwwwnwnw
wwweswwwwwwswwwwww
eeseenweenwseneeeeeeweeenee
eeeeesenenenwesweeeswenwswseswee
neswenenesenenenewnwenesweneneeswne
swswswenwswwswswswswswwwswweswnwsww
seseswseseseeswneeeeesewesesenenw
swwswwwswwwswwswsweneswwwsesww
eneeswenweewenwseeeseeeseswwnw
swnenwswswswseseswswswwseswswswswswswsw
seeseseeseeeesesesenwsenwseweseese
swswswswnwnesweswewseseneswswwnenwsw
eewnenweneswwseeeeneneeeeeene
esenweswwnwnwnwnwnwnwnwnwnwnwnwnwwnw
seeeeeseeneeswweeeeeeneenw
weneswswenenenenwneswneswneneneesene
wnwsesesenwnwnenwnwnesweneenwseswwsw
sewsesesesesesesesewsenesesesesesenesese
swswswwnwswswwweswswswnewwseswsww
nwneneswnwnwnenenenwsenenwnwnenwwnene
neenwenenwsweseeswsesweeseseswneswene
eneeenewewneeneeneweneeesee
nwnwwwnwnewsenwsenw
sesesewswswwneneneeseeewswnwswnwsenw
sewwswwnwwewwwneswswswwwneew
nwsenwwnenenenesenwsenenenenenenenenenwne
sewsewnesenwsenesenwsesweswswsesenenw
eseeeeeeeenweeeeseesee
eseenwseesweswenweseenweeeeswee
neseseseswwneswsesesesewseseseswse
sesweewseseeesenwseeeseeswsweneenw
wnwneseeeseseeseenwwenwseseesese
enwneswnwneneneneneneneenenwnenwwnene
wnwneneneneneneewnwwnenweneesw
nwnenenenwnenenwenenwneneseswnewnenene
nwwsenwnwnenwnenwnenwneneneenwnwsenenww
wwwsewwnwwwnewwneswwewww
swseswwswseswswswswsenwseneeneewsenwsw
nwnesenenwenwnwnwnenwnwnwneswnwnwnenene
seeeweswnenenwsenewenenwewneseee
nwwnwneseswsesweenweswsese
seeseseswsesenesesesenesewseseseeese
swwswneswwnwswneswwewsesewswswsww
seswneswswseswswseseswnwswswswswseswew
wwwwwswwewseswwwwwswwnenesw
nwnwwsenwnenwnwnwnwneenwnwnwnwnenwnww
nwnwneswwswseswswnwnwenwnenesenenenwswenw
neneneneeneeseneneneeneneneswnwnenee
neeeswswnweenwsweseneeseswnwnewe
neswesenwneneneenenweeneene
swseeneewnwseeeenwesenweseseeswnw
eweneeneseeneneneneeeseeeneewene
eeneneewneneeeswneneeneeenwsenenew
nwnwswsweswswnenwswseswswswsweswswnesw
neeeeseeeswewenenwswnene
nwenwnwenwswnwnwwnwswnwnwneswnwneswswese
neswseweeneneeeseenwwnenesenenwnee
wswwseewwwewweewwswnewwwsww
swswswwswswwwswswswswswnweeswswswsw
enenenenenenenenenenwnenenwsenenenewnw
seseswseseseeswseneseseseseseneseesee
neewneeweeeeeneese
enewneseeweneneeneneewenesenene
enwswneeswnwswsewenwwnesewneswseswe
senwswnwnenwnwwnenwnwswnwnwnwnwnwnwnwnwe
sewswneswswswseseseseswswseneswseswswsw
nwnenwwsewneneswnweenwnwnenwnwnwsenene
eswwewswswnwswsw
wwwwwwwwswsenw
nwnwnwnwnwnwnwwwnwnwwnwnwwnwnenwsese
seswnewnenwnweswnwsesenwseeseesesewnw
neneseneeswneneneswwsenwnw
nwnwnwnewnwnesenwnwnenwnwswnwneseenwnw
wwneneeneswneneeewwnesesenenenese
eseeswswsesenwneeewswnenwnwnewnw
nwnesesenewwwswnwewsenwwsewnwwww
eneeenewneneeneneneneswnenwewnesee
neneenewenenenenew
nwsenweewnwwwwenwnwswnwnenwswnwnwse
seseeeeeeswwsenwseeseeseseeese
wwwnwwwwwwwewewwwwwww
swswseseneseswswsewseseseswenwneseseswsw
seswsesesenweseeseswwseseneswsesesesese
swswseswswswswswswswswswnwswswseswsw
nweeneewneeseseesenwsenwseweswnwnw
eeeeeseseeeeewsweenweeeese
nwesesesesenenewwwneeeeweeee
eenenwneneeswewneeeeneenee
seseseswseswseswsenwseeswsesenwseseswne
eseseseswseeneseeseseewnwswsesenese
nwnenwnwseewsenwenewsenwsweswswenenee
wsenwnwwnwwnwneeenwnwne
seswswswswseneneseseswswswswswswswwnesww
wswseswnwsweswseseswesesenwswseseseswsw
sewweseseneseneswsesesenesesesesesese
nwwnwneewwewwwwnwwwwwswwwswsw
nwsweswwneeeeeenwseeenwnwswswesw
wwwwwwsenwwnewwnwwwenwwwew
swneneneswneneswenenwnwnewnwnwsenenenwnene
eswnweseweseeseenwsene
esewewneneneneseneneneneneneneneewwne
eneeeenesenwnenwseneneenenenweesw
nwnwnwseenwnweswnwnwnwnenewnwnwnwswenw
neenenesewsewneeswseseenwweeeesw
eewneeeneeesweeeeeeenenee
nenenenenenwwsenenenenenenenwswneneneene
nwwwwswwwnewwwwwwnwwww
enwswseswenesenwenwseseeswesesenewse
swesweneeenwenenweeneneesweeee
wnwnwnesenwnwwsenewswnwwnwsenwseneswse
neseswseneenwsweneswwnwsenwnesewsenwsw
swswswseseneswweenwswswsesenewseswnesenw
weseseeseseswseseseneeeesesewnese
seeneswnewsesewnwwwwnw
sewseeseeeeesewneeese
seseseenwewsesewneseeeeesweenw
ewswwwswswwswwwswswswsw
nwnwwwsenewswnwwwenwsenwnenwnwnwnw
esenwseseweeneneneswwsewsesewneese
wnwnwswnenwnewwenenesewnenenwnesenesene
wnwnenwwnwnwnwnwnwnwswnwnwnwnwwnenwnwse
eewnesenwsesesweeneeewesweeesee
swenwesweseenwseeseseseenenwesee
nwnwneswnwenwwnwnwnenenwnwnweneswsenw
swwwewwnewseewswwswnewwwww
swwwswewwwsewwsewnwwswwwwnww
wsenwewnwwsewwwnwsewnwnwwsenwnwnw
neswswnenenwneneneenewneneneswnwsw
wwwswwwwnwewwwsewwwwwwwnw
seseseswseswswnweswwswswswnwsesesesesee
nwneneenesenenenwwnwneneswnwnwnenenenwnw
neeenwneeneesweenweeeesw
eweeeeeeeeeeeeneswneeeswe
wseewesesesesesesesesewseenesesesesee
eeeeeseeeeweeee
wsewneseeewseswnewnenenwnenewnesenw
wswenwnwnwnwwnwnwnwwewnwwnwwnww
wwwwwwnewwwsewwwswwneseww
wwwwewwwwwwnw
nwnwnenenwnwnwseenwwsenwenwnwwwnw
seeswswsewnewnwwsweswwswnwswswnwnw
eweseseneeseese
sweeeeeswenenesweseeeeseneee
wnwswewnenewsewwnewwwswwsww
nweenwwwneswnwsenwsewewnwwnwnwww
eswneeneneneneeeneeneeneneeeswne
eeseseneeeeeeeweeneeeswee
enweeseneswnenwnwnwswswswnw
swseseseseseeseeneeese
swswswswswswswswwseswswswswswseeneswnwsesw
senwseenwwsweswseseswse
wnwwnwwnwnwnwwsenwnwnwnewnwnwnwsenwnwse
seseenwesesenwseseseseseseseseseseswswsw
nesewnenenwnwneneswneneswsenwnenwnenw
eswnwweenweseeneeswneeeeeee
seesweneewenenweswseseweseneswsenwse
wsesesesenesesesesesesesesesesese
neneneneenenenenenewneneneneneneswne
eseseeseeseeenweeeswseesenwse
neneseeeeweseewwseseeenweseee
senewnwwwswwewnwwnwwsewenewse
seseseeweseseseneseeeseweseseseee
wswseswseenwwswneswswnwswsww
nwnwnwnwwswnwnwnwnwenenwenwnwnwnwne
sewnwsenweswswswneenwwsenewnwnewnwnw
swseeseseswseneswwsesewwwswnenesesese
eeeneneesweeeeeeneee
nwnweswnwnwenwnwnwnwnwswnwsenwnwnwsenw
swswswswnwenwswswswswweswswesw
nenwnwneswnwneswnenwnenenenwnwnenenenene
wneneneneneneneneseswneneesenewnenwe
enwsenenweneeswswsesesweseseseseswsese
swwseseseeseewnesewnewswseseswseswse
enwneeneneswneneneenenenene
eswweeeeseeneeeeeesesenweee
nenwsenwnwnenwneswnwnwnwnwenwnwnenwnenw
esenwswwnwnwenwsenwnwseseenwswnwwew
nwswnewwwnwswnwwnenwnenwswnwwwwnwnw
eeweseeseseeeeeeesesesewese
nwseeeeenwseeseeeeseeeseeeew
senenwswnweswnwwwwwnwnenwwseswwnwe
ewswnwnewewsenwswseneswswswswseswsw
nwseswnenwwenwwswsesenwnwneewwnwse
seeneseseneweseseseeseseswseseseese
wwsewwswswwswswneswweswswswswwsww
swswswsweswswswswswnwwswswsesesweswsw
seeeeweweeweeeseneenewene
nwseseesewseesewnwneewseesesenenwee
swewwnwnwswswwwweswswswswswneswe
eeneeeneneneneeweneneenesenenenew
swsewwwsewnewwwnwwwwwwnewww
seneswwweswswswwsweswswswswswwswswwnw
seneseseseswsesesewsesesesesw
seswswseswswwewswswswswseswswswswnenw
eseseseesesenenweseesweseeewseseese
swesenenwswnesesenwwwnwse
nenewswnenenenenenesenenenenenenenenesw
senwneseneeneenenw
wseseseeseseeseseseeseseseeenesewe
neeeneweenenee
nwsenenwnenwneeneeeneneneneeswnesene
nwswseeneseenwswnweseneswswnweesesese
nwseseseswsesesesewseeesesesese
eswenesewnenwnwwwnwnwnwneswesenwswsene
sewswwswwswswwswwswswwwneneswnwsww
nenwswenenenenesesesenwwneswnenenewew
senenwswseswsewwsewseseseneeswneswswsw
nwwwnwswswseswseswswwnwweswwwew
eswswswswseseseswswseswswnwswsweswwswse
nenesenenewnenenwnenenenesenenenenenenesw
wnwnwnwwwwwewwwswwwnewnwsenwsw
enwnewnwneswewnewwswwneeseswesew
nwnwnenenwsenwewnenwnenenenwnenwnwnwnwsw
nesenewneenwnwnwnwnwneneneswneswnewnee
ewenewswwsewenwwsenenwwswnwsenwnw
nesenwsenwseseeswswnwese
wnwsenwnwsenwnwswwnwwnenwnwseswnwnwne
newnenwneneenwesenesenenwseseweswswe
senwsesesenwsweseswswsenwnesesesww
sweswseswswwseseseswswsesesenwneseseswnw
nwwenwnwnwsenwnweswnwswnwwswnwnwnenw
enesenenwsewesewsweeneeeeweeee
nwnwnwnwwnwnwnwnwnwwwewnwenwnwnwnw
wseswseseswneeseeseenwseenwseswnwse
seesenwnwwwewseswswnwnwnwe
sewwwwwwwweswwswwwwnewww
neneeswnenwneneswsenweneswneseswseeww
nwnwswenwnwnwnwnwneseswnwsweneswenwnwsw
wwwswwneswwwwwnewswww
senwnwnenwenenenenwnwnewswnwnwnwesw
wswwwwnwswwswwewswnweswswwswew
swseseseswseseswswseseswsesesesenesenwse
nwwnenenenwswsweneenenenenesweneeene
wwnwswwswwswewwwsewwwswswswe
ewwnwwnenesweseenwswswseeswwneenww
eseswsesenwwnwseseseseseseseseswesesesw
wwwwwsewwwwnenwsewnwnenwwwww
nenenenwneneeneswnenenenenwwnenwneenw
seeeeeeeswwseeeeeweneeeenw
senweeneeneswwneeneesweeeswenenesw
nwwnenwnwnwenwnenwnwnwswswnwnwnwenwse
sesenwseseseeseseseseseseese
swswneswsewseseswseswseswseswseeswsewse
seseeseseseeeesesesesewee
seneneeswnenenenenenenenwsenwnenenwnenenew
eeeneeneneweeewneeneneneeseene
swneneneneeneneneenenenenwneenewnene
seswnwseswnwnewneswswnesenewswwwswswsw
enweseeweewewesweeenw
wwwswewneswwwsesewwwnwwswswww
nwwwswwneswwsewswse
swwneseswswnewwswnewwwwse
nwwnwwwnwewwnwswwwwnwwnwwewnw
seseseswneseswseeseswswseswseswwesesenwsw
nweseseseseseseswewseseswsesesesesesese
seseswesesenwseenwsenwseseseseseseseswse
swsenwwnwnwnwnwneswewnenwnweweeswne
eeeenweeeweeeeeeeeesee
nwwwwswnewswewwenwnwwwewswwnw
nwnwnwnwwnwswenwnwnwnwnwnwnwnwnwnwnw
nwwsewewnesewswewnwswwnwwneewse
wnwnwwnwwwnwwnwnewwswwswwwne
enenesweeeeeeneenweeneeneeesw
neeeenweneeneneneneeeeeswsweee
sweswwewseswwwseneneswsewnwwsww
neesesenweweseneseeesesewseeseenwe
sweeeneeeswnene
nwwwswwnwseeweswwwnw
ewswswswwwwneswswnwswswwswswswwww
neewseenwneeswseeneweneweenwesw
seneweseeseseseewseseswweeeese
eneswswswnwswwwswswswswswswswswneswsw
sewswswswswnwswseswswswswnewswwwsww
wwsesenenwnewwwsenw
swnewweswwenenwneseenenenenenenewne
nwwnwnwnwswnwnenwwwnwnwnw
sesesesenwseswnwseseseseseeseswswswswse
swnwswenenwswswneweswwsewsw
nwnwnwnwnenenewewnenenenesenwnwswnwnw
seseswsewswswsenwseseesesenenwesenesww
neneeneeseeeewwwneeenweeeswe
enenwewwswswsenewswsenwewseeneenee
nwwenwswwwnwwnwnwwnwwwwewenwww
sweswnwswesenwsweswseswswnwnwswsweswnwsw
seseseneseseweseewseseswsesewsesese
eweneeneeeeeeseeeeeeeeesw
ewwwnwwwwswwwswswwwwwswwnesw
swnwnenwnwnwwnwnewnwswnwenwnwnwsenwnw
swneeswseseneswwnesesenwsesesenwswnww
seswneseseesesewseseene
wnwwsewnenwnwwsesesenwnwsesesewwwne
eswswwwswseswewwswwswnwswswwwnw
enwnwnenenwnwnwswnwnenwnenwnwswnwnw
newsesenwnenenwnwenwnewnwwnwnwswnwnwnwnw
swneneenesenwwsenwnewnesesenenenwnenw
neneenwnwswswswweeeeeeeenenee
swswseswnwswswswenwswsesenwswseswnewswse
newnenwnenewsenewnesenewneesenwnene
neseseseseswsesewseswneseseswsesesesese
ewseeeeseeesesesesenwseeeswse
wseeeseeeseseesewseenwswseneeee
neseneseswswsesenesewswsesenewsesesenwse
swneneneneneenwneeswneneneeneneneswne
eenewnenenesweeenenenenene
nenenesenenenwneeneeneewseeeene
nwsenenwnenewnwnwnwnwnwnenwnenwnwsenenenw
swnwenwnwwnwnwnwswswewnwnwnwnenwnwnwnww
wwswnwwewwwwsewnwwwww
wseseswnenewwwwwswwwsw
swswwswswwnewswwwseeswwwswwswsw
enesesewewsesweeeseeseseseseesese
nwwnewenwnenwnwnweneswnwneswnenwneenw
eweeeeeseeeweweneeeesesese
wswswswswswswnwseswneswswswswwwswsww
swsenwnwwnwseseseswweeneenwnesenwnee
neeswneneneneewneneneneneneneneneene
nwnewnwnwnwwnwnenwwswnwnwnwwsenwsenwnenw
nwnwnwnwnwnwnwnwsenwnwnwnw
nwnewnwswwwswneewsewnewwswwwww
eeswwesesesenwseeeeeeseeenwe
nenwneswswenwsweneeswneneneneneeswnenw
neneseeneneesewneswnenenwnw
nwnwwwenwenwnwnwwnwnwnwnwwnwswnwnwnw
seseseswswseswsenwswnenwseswwweseswnese
wwewwwseswwswsenwwnwweswnwnee
neenwnwseeneewwneneenenenesewseenese
nwwswswenesewwwwswwswenwneswnewse
seswwnenwnwnenwwneeswsewewsewsesw
eseeseseeeesweneee
eenesesweeeeenwswnwneenenwswnenene
seneseseeeseeswswseswsenwsenwnwsesesese
seseseseseeeeseseeenw
wnwwwweewwwwwswnewwswwww
swswnewnwswseswswswswswwwswswswswwsw
nwnwenwnwnwnwewnwnwnwnwnwnwnwswnwnwnw
seswswswseseseswseswswnwneseneswswseswne
swseswseswswswsewseswsesenenwsesenwseseese
swswsweseswneneswwnewswswswswswswswnew
nwwnwnwnwswnwnwnwnwsenwnwneeeswnwnwnenw
wneneneneseneneew
weeeseweneenewseesesewesesesese
swnweswswseeseswswswseswswswswnwseswew
eneseenweeeswneeeenweswneeee
neneenewneweneneeneseneneswneenenwnene
nesenewneneneeseswneneeneenenwenewnw
neneneweeneneewneeneeneneneene
senenewnesewwwwswswneswwneswsenwse
eenweneseeswnenweswnwsee
nwnwnwsenwnwnwnenwneneneswnwew
sweswneseenwesweeswnwewseneneneeenw
swnwneswwswseswswswswseswseseswswsesw
nwnwnwnwnewnwnwnwsewewsenw
swseseseseswseswswswsenwse
nenwnwesenwnwsenwwnwsenwneswneeneswnw
ewwwewnwwsewnw
nwwnwwnwnwswwnwnwnwnwwnenw
wneeneneneenwswswwneneeneneenesene
nenwnenwnenwnwnenwnwneesenwnenenenwwnew
eenewnenwswwseeenwsenwweneneswne
nwnwnenenwnwwnwnwnwnwswnwswsenw
eeseneenenenenwwseswneneewneenenenee
nenwnenewnwswnenewnwseswneenwnenesene
wnwswwnwwenwenwnwwnwswnwnwnwnwnwnww
neeneneenesewneseenenewnwenwswenese
nwewneeswnwnwseseneswneneswnenwswnwnw
nwnesesewseswsewsewnenenesesenewsesese
seneseswswswswswsenwseseseswseswswswsee
nwwswnwsewwwnewsewnwewesewnwnwnw
eswwenwnenwnwnenwswnwnwnwnwsenenwwne
senweesenwwsewseeneeeenesewseee
nenwnenwnwnwswnwswnenwnenweeswnenwnenene
wnwnwwewsewnewwswwwnwnwwnwwwww
nwwnwswnwnwwnwnenwnwswseewnwnwnwnwe
nenwnenenenwnwnwnenwnenenweenenenwwnesw
wnwnenweseneswwswnwneeseswnenenwswwe
eeeweeeeeeweeeseeee
wwwswwnwwnweswweneswnenwwwnwww
swswwswswseswswswsweseswswseneswswse
seswnwewswwwwswwsewnwneswswewww
seswwwwnewwnwwewwnewwwwww
seneswnenwsweewnwnwenwswswswnesenew
eswnweeesweeseneeeeeeeeeee
wnwswswswswwswswswswwswwwewewsww
nwnwnenwnwnweeswsenweesewswswnwnwswnw
seswwnwsewwwwswsenenw
wwswwwwswswseswwwwewswwswnww
seswseseswseseswseseseswswseseswswnw
swnesewwnwwneswne
wswswsesweswswswseswwswswsweswswnwnwe
seenwsenweseseseesesewseseseseesese
esenwnwnwneswnwnenwwsenwnenwwsenenww
eeeeeneseswseseeseenwseeesw
swseseeneseneseeswwnwese
eeeenweswseeeesee
seseswweenwswnewwwwnew
wswswswnwswswwswswswseneneswseseseeswse
nwswwnwsewewswwswwwenenwwnwww
seneseweseseeneesesesesesenweseseswse
nwnenwnwnwnwsewwenwnenwsenesenwnwnenwne
senwenewsesesewnwwseeweseswsesesenwe
wenwewnwnwnwwnwewnwwwnwwwwnw
seeeeseseeseseesenwseenweesesese
swswswwnwswwwwswnewswswwwswswwew
nenwnenenwnwnwsenenwneneneswnwnwnwsesene
wnewswsenesewswwwswnwwswswnewwseew
wsesenwenwseswsenwwseeseenesenenwwnw
senewewswwswwewwwwnewswwwswsw
swneenwseweseeenwweseseeesenwnwse
""".trimIndent()


fun main() {
    val floorInstructions = parseFloorInstructions(input)
    val center = 100
    var floor = Array(center * 2) { BooleanArray(center * 2) { false } }
    flipTilesForInstructions(floorInstructions, center, floor)

    for (i in 1..100) {
        println("#### Turn $i")
        floor = nextTurn(floor)
    }

    val flippedCount = countFlippedTiles(floor)
    println("Flipped tiles: $flippedCount")
}

fun nextTurn(floor: Array<BooleanArray>): Array<BooleanArray> {
    val newFloor = Array(floor.size) { BooleanArray(floor[0].size) { false } }
    floor.forEachIndexed { y, row ->
        row.forEachIndexed { x, tile ->
            val coord = Coord(x, y)
            val count = getAdjacentBlack(floor, coord)
            val black = if (isBlack(floor, coord)) {
                !(count == 0 || count > 2)
            } else {
                count == 2
            }
            newFloor[y][x] = black
            if (black && (coord.x == 0 || coord.y == 0 || coord.x == floor[0].size - 1 || coord.y == floor.size - 1)) {
                println("WARNING: Tile flipped at border: $coord")
            }

        }
    }
    return newFloor
}

fun getAdjacentBlack(floor: Array<BooleanArray>, source: Coord): Int {
    var count = 0
    Direction.values().forEach { dir ->
        val coord = nextCoord(source, dir)
        if (isBlack(floor, coord)) {
            count++
        }
    }
    return count
}

private fun isBlack(floor: Array<BooleanArray>, coord: Coord) =
        floor.getOrElse(coord.y, { booleanArrayOf() }).getOrElse(coord.x, { false })

fun countFlippedTiles(floor: Array<BooleanArray>): Int {
    var count = 0
    floor.forEach { row ->
        row.forEach { tile ->
            if (tile) {
                count++
            }
        }
    }
    return count
}

private fun flipTilesForInstructions(floorInstructions: List<List<Direction>>, center: Int, floor: Array<BooleanArray>) {
    floorInstructions.forEach { tileInstructions ->
        val destinationTile = getCoordForInstructions(tileInstructions, Coord(center, center))
        floor[destinationTile.y][destinationTile.x] = !floor[destinationTile.y][destinationTile.x]
    }
}

fun getCoordForInstructions(tileInstructions: List<Direction>, start: Coord): Coord {
    var coord = start
    tileInstructions.forEach { dir ->
        coord = nextCoord(coord, dir)
    }
    return coord
}

fun nextCoord(source: Coord, dir: Direction): Coord {
    val oneYEven = (source.y + 1) % 2 // 1 for y = 0, 2, 4, ...
    val oneYOdd = source.y % 2 // 1 for y = 1, 3, 5, ...
    return when (dir) {
        Direction.East -> Coord(source.x + 1, source.y)
        Direction.West -> Coord(source.x - 1, source.y)
        Direction.NorthEast -> Coord(source.x + (oneYOdd), source.y - 1)
        Direction.NorthWest -> Coord(source.x - (oneYEven), source.y - 1)
        Direction.SouthEast -> Coord(source.x + (oneYOdd), source.y + 1)
        Direction.SouthWest -> Coord(source.x - (oneYEven), source.y + 1)
    }
}

fun parseFloorInstructions(input: String): List<List<Direction>> {
    return input.lines().map { line ->
        parseTileInstructions(line)
    }
}

fun parseTileInstructions(line: String): List<Direction> {
    var index = 0
    val directions = mutableListOf<Direction>()
    while (index < line.length) {
        val c = line[index++]
        val dir = when (c) {
            'e' -> Direction.East
            'w' -> Direction.West
            'n' -> {
                val c2 = line[index++]
                when (c2) {
                    'e' -> Direction.NorthEast
                    'w' -> Direction.NorthWest
                    else -> throw IllegalArgumentException("Unknown char2 $c2 after $c at ${line.subSequence(0, index)}")
                }
            }
            's' -> {
                val c2 = line[index++]
                when (c2) {
                    'e' -> Direction.SouthEast
                    'w' -> Direction.SouthWest
                    else -> throw IllegalArgumentException("Unknown char2 $c2 after $c at ${line.subSequence(0, index)}")
                }
            }
            else -> throw IllegalArgumentException("Unknown char $c at ${line.subSequence(0, index)}")
        }
        directions.add(dir)
    }
    return directions
}

enum class Direction(val code: String) {
    East("e"),
    SouthEast("se"),
    SouthWest("sw"),
    West("w"),
    NorthWest("nw"),
    NorthEast("ne")
}

data class Coord(val x: Int, val y: Int)