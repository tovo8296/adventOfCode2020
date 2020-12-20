package day20

import java.lang.IllegalArgumentException
import java.lang.StringBuilder
import kotlin.math.max
import kotlin.math.min

val input = """
Tile 2897:
####..##..
.........#
..........
.#........
##......##
.......#..
...#...##.
...##...#.
......#..#
..##.#.##.

Tile 3541:
##....#..#
......#...
#....#...#
....####.#
#..##..#..
.#........
...#......
........#.
........#.
.#.....#..

Tile 1877:
##..###...
...###....
.#..##.#.#
####....##
....#.#.##
#.#......#
.....#....
..#.#....#
..........
###....##.

Tile 1559:
######.###
.#.#..#...
#....#....
#..#...##.
..##......
##.#.##..#
##....#..#
##.#..#..#
#....###..
#..#..##.#

Tile 2389:
.##.##.###
.#...#..#.
##..##.###
##.....#..
..........
#..#......
#.#......#
....#.....
#..####...
.##..##.#.

Tile 1879:
#...#.#.##
##.....###
#....#..##
#.##.##.##
..#..##..#
........##
#....##.#.
#..##.....
.#........
##..####.#

Tile 1129:
..####..##
.....##...
#....##...
#....#..#.
#.......#.
#.....##..
.....#..#.
#.#...#.##
#..#..#.#.
##.#..#...

Tile 3847:
#.####....
#...#.#..#
..........
#.#..#..##
....#...##
...#....#.
#..#.#...#
#...#....#
##....#..#
.#.....#..

Tile 2333:
###.#.#...
##...#.#.#
#.#...#..#
#....#....
#....#...#
#....##...
.....#....
#....#..##
#..#.#####
.#..##.#.#

Tile 2801:
.#.##.#.##
#......#.#
.#......#.
.##....#.#
#....#...#
...#..#..#
.#.......#
#.....#.#.
..##......
#.....##..

Tile 1493:
#.########
..###.#.##
##.#.....#
..........
..#....##.
#.....#..#
..........
....#....#
.####...#.
#.#....##.

Tile 1433:
#...#.###.
##..#####.
..........
#........#
.#...#..#.
#....##..#
#.......##
.#..#.#.#.
..#.###..#
.###.#....

Tile 1459:
########.#
###..#.###
##...#.##.
#......#.#
...#.....#
#...#..#.#
##......##
...#.#.#.#
#..#..###.
..#.#.####

Tile 3947:
..##.###.#
##.#......
.#....#..#
....##..##
.#...#..##
#.........
..#.......
.........#
...#..#..#
#..###.###

Tile 2767:
.####.#.#.
##.#...#..
###......#
..#....#..
.##..#..#.
..#.###..#
##.....#.#
..#......#
#....#....
.##..####.

Tile 2383:
..####.#..
#..#.#...#
..#.#.....
#........#
.........#
#.#.#....#
#..###.#.#
#......#..
..#.......
..#.#....#

Tile 2837:
#..#.....#
#..#..#...
#...#.#...
......#.##
..#.#.##..
#..##.....
#..#.#.##.
#.##.#.#..
##.##.....
#.##.##.#.

Tile 2251:
..#...##.#
#.#...#...
.#..#.#.##
..#....#.#
....##.#.#
##....#...
........##
......##..
###..##..#
....#####.

Tile 1597:
.#.####..#
...#..#..#
...#...#.#
.###.#....
#.#...#...
#.........
....#.....
.........#
##.....#..
....###.#.

Tile 3089:
###..##..#
.#.####...
#.##..#...
#.....##.#
#.......##
#.##.....#
##...#...#
..........
.#....#.##
.#####.#.#

Tile 2339:
...#.####.
#..#......
#.#.#....#
....#.....
##..#.#.##
.#.##..##.
#..#...#..
#..#.#....
#...#..#.#
.....###.#

Tile 3217:
.##.....##
..#...#..#
...##..##.
##.##.....
.##..#.###
...#...##.
..#.##...#
..#...#...
#.#.......
.####.##.#

Tile 2129:
####..###.
##...#...#
##.......#
..####...#
#.###..#..
##.#....##
#.#.....#.
....#...##
.......#..
#..#.#...#

Tile 2081:
...#.#.###
.........#
...#......
#.###.#.#.
###.##....
#...##.#.#
#......##.
#........#
#.....#...
###.#.###.

Tile 3571:
#...######
#...#####.
.#.#..#...
..#..##...
######.#.#
.#..#.#..#
.#..##.#..
#.##.....#
.....###.#
#...#..##.

Tile 1277:
...##..#..
.......###
#..#..#..#
##..#..#..
.......#..
#...#.#...
...#.#....
.....#.#..
###..###..
###...###.

Tile 1907:
.#.##.#.#.
..###....#
##.#.....#
#...#....#
..###...#.
#...#.#..#
#..#.#....
#.....#..#
###......#
#..#...##.

Tile 3413:
#.#....###
......#..#
.#.#.#....
##.#.#...#
#.....#..#
#.....##.#
###..###..
..#.......
..#....##.
..#..#..#.

Tile 3923:
.#.##.#.#.
##........
.#..#..#.#
#..####...
..#.#.....
##.#.#....
.......#..
####..#.##
...#.#..##
#..##.#.#.

Tile 1429:
.####.##..
...#.#....
#......#.#
...#.#....
##........
.#.##..#..
..###....#
#.....#.#.
..#.#....#
.##...#...

Tile 1511:
...#..#..#
##.###..##
##.....###
#...###..#
........#.
##......##
..#.....#.
...###.###
###...#...
###.##....

Tile 3617:
.##.##..##
....####.#
##.#.#..##
...#####.#
....#....#
.#.##.#..#
.##...#...
....##...#
#..#....#.
#.#.##.#..

Tile 1153:
.#.#.##.##
###.....##
##.##.....
.#.#......
#..#...#.#
###.##..##
....##..##
....#.#..#
..##...###
..#.#...#.

Tile 2917:
....##.#.#
....#..#.#
#.##....##
#...#...##
#.....##..
#..#.#.##.
#....#..##
.....####.
#.##.....#
##..#.#.##

Tile 2819:
##..##.##.
#.##..#..#
#.....#...
##........
##.#.....#
..#.##.#.#
.#####....
##.#.....#
#.#...#.##
#...##.#..

Tile 2927:
.####.....
##..#..###
###.#..###
...###..##
#....#.##.
..#.#..#.#
##......#.
..##....#.
#.....##.#
...#####.#

Tile 2659:
.#..#.##.#
#..##....#
##.#.#.###
....#.##.#
....#.##.#
.#.##...#.
#...#....#
..##..####
#.#...#.#.
#.###.##.#

Tile 2399:
.#..##.#..
##...##.#.
#..##..###
..###....#
##..###..#
...#.#.###
.....#....
....##.#..
......##.#
...#######

Tile 3209:
....##...#
##........
..#......#
#..##.##.#
...#..#..#
###..#.##.
###...#...
.#...#..##
....####..
##....####

Tile 2131:
..#...####
#.#.##....
........##
##..#..#..
###..#....
#.#..#..#.
#...#..#..
..#....#..
......#..#
.##...#.##

Tile 1399:
.####..#.#
.##...#...
#...#...#.
.#..#....#
#.##.#...#
.#...#....
...#....#.
##.##..#..
.#...##...
#....#..##

Tile 1901:
#....#..##
##.......#
#.#.......
.#........
#........#
##....#.##
..#..#...#
.##..#..##
#.#.......
##.##..###

Tile 3041:
.##..#..##
#.#....#.#
#.##.....#
#.......#.
....###..#
...#...#.#
.....#....
#.#.......
.#....#..#
#.##.#.#.#

Tile 3373:
.##.#####.
....#..#.#
#...#...##
..#......#
##.......#
###.#....#
.#.#...#..
#.....#..#
..#.##.#..
#.####..#.

Tile 1831:
.#.#######
##..#.####
.........#
........##
....#.#..#
#....#..##
.....#...#
.........#
..##....#.
##..###...

Tile 1291:
#.###.####
..##....#.
###..#...#
#..#......
##..#...#.
....###...
....#.#...
#.......#.
..####..##
#.#..#####

Tile 3187:
#..#.#....
#........#
#.#...#...
##.......#
##.....#.#
#..#.#..##
###..##...
#..#...#.#
.........#
.#.#.###..

Tile 1061:
##.##.#..#
#.#.......
##........
#...###...
.#........
#.....#...
..........
#........#
..#....###
####.##.#.

Tile 3359:
#####....#
#....#....
.#.....###
#..#.#....
#....#..##
.##..#....
..##.#..##
#....#...#
...##...#.
...#.###..

Tile 2803:
.#.##.....
.#...#...#
...#......
##...#...#
......#..#
.##.......
..#......#
##.......#
##....#..#
#...#.##..

Tile 1657:
###.##....
#..#.#..##
#.#...####
.##....#..
...#..#...
#..#.##...
##..#.....
..........
..........
#.###...##

Tile 3203:
.####.##.#
#.#.#....#
....####.#
...#.#..##
##.....#..
..#.#.#...
.........#
..##..#...
.##.....##
###.....##

Tile 1741:
#..#.###..
#....#....
.#..###..#
##..#..#..
.###......
#........#
..#..#...#
.#.##..#..
##.....#..
...#.##...

Tile 1783:
.##..##...
#...#.##.#
##...#...#
####......
#..#.....#
..#......#
...#.....#
#.#....#.#
#..##...##
##..#..#..

Tile 2063:
##.#.#....
....##...#
.....#.#..
#........#
#.#.##...#
.......#.#
##.###.#..
.##..###..
.........#
...##..###

Tile 2999:
.##...##..
##..#...##
........#.
#.#......#
......##..
#...#...#.
#.........
#..#..#..#
.#..#.....
##.#...#.#

Tile 1307:
#..#...###
#....#.#.#
.#....###.
......#...
#....##..#
.#..#.#.#.
#...#.##..
.#...###..
.#.#.#.###
#.#.##....

Tile 2111:
#.#.#..##.
....##....
#..#....#.
.....##..#
..#....#..
..........
.....##...
.##....###
...#..#...
.#....#.##

Tile 1069:
..##.#..#.
.#......#.
.....#...#
#..#..#..#
##.#.....#
....#....#
...#.#....
#...##..#.
##....#...
##..######

Tile 2137:
#.#.###...
#...#.#.#.
...#.....#
.#...#.#..
..........
...##..##.
#..#.#.#.#
.........#
.#......#.
##.#.##.#.

Tile 3877:
..#####.#.
####......
#..#.....#
#........#
..#...#...
...#..#..#
.###......
..#..#..#.
.#.#.....#
#####....#

Tile 2693:
.#..###..#
##........
.###.#..##
......#.##
.........#
.....#....
#...##...#
.....#.#..
#.#..##...
#.#......#

Tile 3251:
##.#.#..#.
..#.#.....
..........
###.##....
.....#.#.#
##.##...#.
#.#.#..##.
#........#
...###..##
#.##..#..#

Tile 1181:
.#.#.#.#.#
#.#....#.#
#.....#.##
#.....##..
#.....#...
......###.
.....#....
.#....#...
##..##.##.
#.#....##.

Tile 1979:
.#..###.#.
#..#.#..#.
#...##...#
.#..#..##.
#.##....#.
...#......
...#....##
..#.#..#..
.#.#.....#
.##.#..###

Tile 3083:
##....###.
#.#.##.##.
#####.....
##.#.#....
.....#....
#.......#.
.#......#.
###.#....#
#.###...#.
.##.#.#..#

Tile 3181:
#.#...##..
##..#.....
..##..#...
#.#...#..#
.........#
#.........
........##
#.........
......#..#
..##.##.#.

Tile 2521:
#..##.#..#
.##..#..##
###.#....#
####....#.
#..##..###
#.....#..#
..#....#.#
#.....##.#
....#.####
.#.##...##

Tile 1567:
.#...##...
#......#.#
....##.###
.........#
##...#.#..
#.......#.
#..#...#.#
.....#....
...#...#.#
.#...####.

Tile 1289:
.##.###...
#...#..#.#
........##
...#...#.#
.........#
...#......
#..##....#
#...##...#
..........
.#..###.#.

Tile 2719:
..##....#.
#...#....#
.#####...#
.#.#.##...
#####..#..
#....#.#.#
........##
#...#...##
.#.#......
..#.......

Tile 2861:
#....##..#
..........
###.......
##...#..#.
.#.#..#..#
..##..#.##
#...#....#
##....#..#
#.##.#.###
#..#...##.

Tile 1543:
####...#..
##.##.##..
#.##.#..#.
###......#
#....##...
.......#.#
#.##......
..#.#....#
#.......#.
.####.#.#.

Tile 1619:
....#.#.##
...####..#
##....#.##
#..##....#
........##
...#......
...#.#..#.
#...#....#
#.......##
.##..#..#.

Tile 2539:
#.####.###
.##...#..#
#..#......
......#...
.#........
.##.#..##.
..##.##.#.
#..#..#..#
#...#...##
####.#.###

Tile 3329:
##.##..#.#
#.........
.#.#.....#
#.........
#.....#...
.#...#...#
.......#..
#....#.###
..###....#
...##.###.

Tile 2143:
.#........
#.###.....
#..##.....
......#..#
...#.....#
#.......#.
..#...#.##
#...#..##.
###......#
..##.##...

Tile 3221:
..###...##
......##.#
#.#.....##
##.##..#.#
..####..#.
..#.......
##...#...#
......#.##
.....#.#.#
..###.###.

Tile 2971:
...###.#..
..#..#.#..
...##..#.#
#....##...
#..#..#..#
....#....#
##...#....
.#...#..#.
#.#.#..#..
##.##.##..

Tile 3457:
..#...##.#
##.......#
#.....#...
#..#...#.#
....##.##.
##.....#..
..####...#
#.......#.
...#.....#
..#.###.#.

Tile 1361:
#.####.###
##..###..#
.#..##.##.
#..#.....#
#......#..
#.#......#
.....#..#.
#......#..
#.....#..#
.#####.#.#

Tile 1019:
.##..#####
.....#.#..
..#.#.#.#.
..#....##.
......##..
##......#.
..#..##...
.##...###.
.####...#.
.....####.

Tile 3331:
...#.####.
#######.##
#..###..##
#.....###.
#...#....#
#.........
...##..#.#
........#.
....#.#.##
#.#.######

Tile 3677:
..#...##..
#.........
.........#
#..#.#...#
#...##..#.
#.#...#...
##......##
###.......
#.##..#..#
..#..####.

Tile 1381:
#.####.#.#
#........#
...#.....#
...##..#.#
....#...#.
#........#
#...#.....
#..#....##
.#..#.#..#
#####...#.

Tile 3001:
#.##.###.#
#..#.#..##
..##....##
.....##.##
..#..#.#.#
#.........
#...##....
.....##..#
#...##..#.
.#.....#.#

Tile 3881:
.####..#..
....##...#
#....#...#
.#.#.#.#.#
#....#.###
....##...#
.........#
#....#....
.###....#.
##..#..##.

Tile 2609:
######....
#..#.#...#
..#.....#.
#......##.
........##
.#.#....#.
.........#
#..##....#
##.#....##
#...#.###.

Tile 2557:
.##.##....
.....##.##
.....####.
#.##..####
..#..#.#.#
.....#.#.#
.........#
#.#......#
#.#....#..
.#.#.#..##

Tile 3643:
##.##..#.#
....#....#
.......#..
.#.#..#..#
..##....#.
...##.#...
##...#.#..
#......#.#
#.....#..#
..##.##.##

Tile 3907:
###.#.##..
#.#.....##
...##.#..#
#.....#...
.##.....#.
..##..##..
..#..#...#
.......##.
.##......#
##..#####.

Tile 3163:
...##.##..
#.#.#.#...
#..#.#....
...#......
..#.#.....
#.#..#.##.
#.......##
..#..#.#..
#.###.....
..######.#

Tile 1049:
.#....###.
#.....#...
#####.#..#
....###..#
##...#...#
#....##.#.
...####..#
#.#.......
#.....#...
#.#......#

Tile 2687:
.#..##....
#..###...#
.....#...#
..........
##.#...#..
......#...
##....#...
####.##.##
#.....#..#
....###..#

Tile 2953:
...#.#...#
.#.##.##..
.#...##...
..#...##.#
..........
.....###..
##..#....#
.#.#...#..
#......#..
.....#....

Tile 1031:
.#.#####..
..#.##.#..
........#.
#..#..###.
##.#..#..#
....#.##.#
#..#.#.##.
..#......#
.#..#...#.
.#..####..

Tile 1733:
.##..#.##.
#.#..##..#
#..#.#....
......#..#
.#...#.#.#
##..#.##..
#...##...#
..#......#
..#....#..
..#.######

Tile 2017:
...###.#..
.....##..#
#...#.....
#.#.##.#..
##....##..
...##..###
#....#....
#....##..#
..#..#...#
.#.####...

Tile 2069:
......###.
.#..#.....
..#...#...
...#.....#
....##.#..
..#..##...
.#....###.
#..#.#.#.#
.....#..##
..####.###

Tile 3851:
#......#..
#...#.....
#.#..#.###
.#.......#
#.#.......
........#.
#......#..
#...#.....
##..#..#..
.##.#.#.##

Tile 2531:
..##......
.....#....
##..##....
#..#...#.#
.##..###..
.....#....
##.#.#.#..
#..###.###
#...###...
#...#..##.

Tile 1549:
.#..##.#.#
#....#.#.#
.#...#.##.
#....###..
........#.
#.##..#..#
..##.##.##
.#...###..
.##.....##
##.#.....#

Tile 2203:
.##.#...#.
#.........
..#..#.###
.#....##.#
#......#.#
.#.#.#..##
#.######..
#...#.....
..#..#..##
###..#....

Tile 1097:
###..##.##
#....#....
...#.#..##
.##.##...#
##........
..........
.......###
#.##......
...#.....#
#...#.....

Tile 1663:
#.#..##...
##....#..#
........##
#.##..##.#
#...#.##.#
...##..#.#
#...#.#..#
#.......##
.#...#....
#.#####.#.

Tile 1453:
##...##.##
#....##..#
..#...#.#.
#......#.#
.....##.##
.##..##.#.
..#..##..#
#.....#...
.......###
..#...#.#.

Tile 3023:
..###.###.
...#.#....
#........#
#.#..#.###
#.####...#
..........
..#..##.#.
###.....#.
.#....##.#
.#.#.#..#.

Tile 1447:
...#...#..
......##.#
.#.#####..
#.......#.
........##
##.##.##..
..#.......
.....#...#
.#...#..##
#.#####.##

Tile 3691:
..##.#.#.#
#...#.##.#
....###..#
.....#.##.
.....#.#..
......###.
#####.##.#
.###.#####
##....#.##
..#..#....

Tile 3119:
..#.##...#
..##.#..##
#...#.##..
.#.#.#....
....##....
##...#...#
#.....#...
.....#..#.
#.#.....#.
.##.....##

Tile 3037:
.##...####
....#.....
..#......#
##.#......
#......#..
.#...#.#..
..#..#...#
.....#....
....#....#
.#.#..#.##

Tile 1667:
##.####..#
#....#.#.#
.#...#..##
#.#...##.#
#.......##
#.....#...
#.......#.
#....#....
....######
.##.##.#..

Tile 3697:
.#..#..#..
....#....#
...#......
#.##......
.###......
##.#.##...
.#........
#........#
##.......#
.#..#.##..

Tile 1151:
#.....##.#
.....###..
#......#.#
.....#...#
....#..#.#
.#.#..####
#.###...##
.#..#..#.#
......#.#.
#.#.#..##.

Tile 1321:
....###...
#..#......
#...##....
.#...#...#
.........#
...#..#.##
##.##.....
#.........
#..#....##
#.#.####..

Tile 3917:
...#..##..
#...#.#..#
#......###
#.....#..#
#..#.#...#
.##..##.##
......#.##
##..##...#
#...#.....
.#...#.#..

Tile 3067:
.##.###.##
#..#...##.
...#....#.
#.....#.##
..#.#...##
#.....##.#
.##....#.#
#.###.....
#.....#...
.#####..#.

Tile 1697:
.##.....#.
..#......#
.###..###.
#..#.##...
......#..#
#.....#..#
#....##..#
.#.....#.#
..#...#..#
#.........

Tile 1627:
#.#.....#.
###..#....
#....##..#
#.#.##...#
.##..#....
......##..
.##....#.#
.##.....##
##...##.##
###.......

Tile 2273:
....##...#
#........#
###..#...#
..#.......
##......##
#..#..#...
#.....#..#
#.#...#..#
....#..#..
.#.#.#...#

Tile 2089:
##.##.####
.#.##..#.#
....#..##.
..........
.##.#.....
#.##..#.#.
#..###...#
#....#...#
....#..###
#..###..#.

Tile 2677:
.####...##
..#.......
#.....#.#.
#....#..##
.#.......#
#......##.
#.......##
#..#...#..
#.##.#...#
#...#.#.##

Tile 3533:
.#...###..
##.#.#...#
..##.#.#.#
##....##.#
##........
...#..#..#
##.##.#.#.
.#####...#
.......#..
....###..#

Tile 2237:
..##.#.###
#...##.##.
.#..#....#
#.#.##...#
.......#..
#.#....#.#
#....####.
#..####..#
#####..###
####.###.#

Tile 2749:
.#.#.#....
#..#.....#
....##...#
#..#......
#........#
#...#.#...
..#...#...
....#..#.#
.......##.
....######

Tile 2833:
..##..#.#.
#..##...##
....#.#..#
...#....##
#.#.....##
..#.#.....
..##.#.#..
##...#...#
.##..#.#..
######.#.#

Tile 3253:
..####.#.#
#.....#...
.#.......#
..####....
..##....#.
.####...#.
..#.....##
..####.#..
#......###
##..###.#.

Tile 2029:
..#...#..#
......##.#
#..#.#.#.#
#....#.#..
.....###..
#.#.......
..#.#...##
#.#..#.#.#
##..#.#...
.###.#.#..

Tile 1553:
.....##.##
...###...#
..###.....
...#.....#
.....#.##.
.#.#.....#
....#.....
#...#.##.#
#..##..#..
.###....#.

Tile 3539:
#.#...####
.#...#....
...##....#
#.#......#
.#..#.##..
.......#.#
....#.#.#.
#........#
.#...#....
.#.#..##.#

Tile 3823:
..##.###..
.#..###..#
.#.#..##.#
#.......##
......#...
#.#...#..#
..#.....#.
##.####.#.
.#.###....
.#.#.#..#.

Tile 2011:
.####..###
###......#
..........
...###....
.....#.#.#
...##....#
.......#..
..........
..##.....#
..##.#....

Tile 1423:
#..#...###
...##..#..
..###...#.
.###......
#..##..##.
.#.#.#..#.
.......#.#
.##.##.#.#
##.##...#.
#..#.....#

Tile 1373:
.##..#..#.
#.....##.#
###...##..
#..#..##.#
##.##.#...
#...#.....
.....##.#.
....#..##.
.......##.
..##......

Tile 1187:
####.##.##
.##.....#.
##.#....#.
..#....#.#
##........
#.....#..#
##.#.....#
#.#.......
.##.#.....
#..#.##.##

Tile 3863:
#.#.###.#.
##.##.#...
##.#..#...
..##..#...
#..#.....#
....#.....
.....#...#
.#....#..#
.##...#...
#.#...##..

Tile 1009:
.#...##...
###.......
.#...##..#
....##.#.#
..........
.##.......
....#.#..#
..#.......
##..####.#
##..######

Tile 1609:
.#...#..##
#.#.#.....
#.#.#....#
..#....##.
#.........
#...#...#.
.#.####..#
#....##.#.
.....#..#.
.##.#.#..#

Tile 3593:
##.#.##..#
....###...
..#....##.
..#.....#.
#...#.##.#
#.#.#.#.#.
.......#..
##.#.#.#.#
#.#..#..#.
.#..#..###

Tile 2473:
#.####.#..
#.#....#..
#.#.#.#.##
#..#....##
.#.###....
#...###...
.#..###..#
#..#.....#
..##.#...#
###..#.#..

Tile 3449:
#...###..#
.#........
#.#......#
..#...#..#
..#..#.#.#
#......#..
##..#..##.
.###..####
.........#
..###...##

Tile 1021:
....#..#..
......#..#
..#....#..
........##
..........
##.##...##
###.......
..#......#
#..#....##
#....#.###

Tile 2113:
#...#.##..
#...#.###.
..#...#.#.
#..##...#.
..#.####..
.#..#..#..
#...###..#
..#.....##
..##......
...####.##

Tile 3919:
######.##.
.##..###..
#.#......#
#....#...#
#....##.##
.#.##.#..#
...#####..
..#..#...#
.........#
..#....##.
""".trimIndent()

val testInput = """
Tile 2311:
..##.#..#.
##..#.....
#...##..#.
####.#...#
##.##.###.
##...#.###
.#.#.#..##
..#....#..
###...#.#.
..###..###

Tile 1951:
#.##...##.
#.####...#
.....#..##
#...######
.##.#....#
.###.#####
###.##.##.
.###....#.
..#.#..#.#
#...##.#..

Tile 1171:
####...##.
#..##.#..#
##.#..#.#.
.###.####.
..###.####
.##....##.
.#...####.
#.##.####.
####..#...
.....##...

Tile 1427:
###.##.#..
.#..#.##..
.#.##.#..#
#.#.#.##.#
....#...##
...##..##.
...#.#####
.#.####.#.
..#..###.#
..##.#..#.

Tile 1489:
##.#.#....
..##...#..
.##..##...
..#...#...
#####...#.
#..#.#.#.#
...#.#.#..
##.#...##.
..##.##.##
###.##.#..

Tile 2473:
#....####.
#..#.##...
#.##..#...
######.#.#
.#...#.#.#
.#########
.###.#..#.
########.#
##...##.#.
..###.#.#.

Tile 2971:
..#.#....#
#...###...
#.#.###...
##.##..#..
.#####..##
.#..####.#
#..#.#..#.
..####.###
..#.#.###.
...#.#.#.#

Tile 2729:
...#.#.#.#
####.#....
..#.#.....
....#..#.#
.##..##.#.
.#.####...
####.#.#..
##.####...
##..#.##..
#.##...##.

Tile 3079:
#.#.#####.
.#..######
..#.......
######....
####.#..#.
.#...#.##.
#.#####.##
..#.###...
..#.......
..#.###...
""".trimIndent()

val testTileInput = """
Tile 1:
##.
...
...
""".trimIndent()

val monster = """
                  # 
#    ##    ##    ###
 #  #  #  #  #  #   
""".trimIndent()

val tilesPerDim = 12
//val tilesPerDim = 3
val startIndex = 25
var minX = 25
var minY = 25
var maxX = 25
var maxY = 25


fun main() {
    var tiles = parseTiles(input)
    tiles = tiles.sortedBy { it.id }
    findNeighbors(tiles)
    printMap(tiles)

    multiplyCorners(tiles) // part1

    val fullImage = createFullImage(tiles, false)
    println("\n\n********** Full Image ***************\n$fullImage\n*******************")

    findMonsters(fullImage)

}

fun multiplyCorners(tiles: List<Tile>) {
    var product = 1L
    tiles.forEach { tile ->
        if (tile.getNeighborCount() == 2) {
            product *= tile.id.toLong()
        }
    }
//    println("Product of corners: $product") // part 1 => 64802175715999


}

var startTile: Tile? = null

fun findNeighbors(tiles: List<Tile>) {
//    println("---------- Find Neighbors ------------\n")
    var tile = tiles[0]
    tile.coord = Coord(startIndex, startIndex)
    startTile = tile
    tile.imageAdjusted = true
    findNeighborsForTile(tile, tiles)
}

private fun findNeighborsForTile(tile: Tile, tiles: List<Tile>) {
    Direction.values().forEach { direction ->
        if (!tile.hasNeighbor(direction)) {
            val newTile = findNeighbor(tile, direction, tiles)
            if (newTile != null) {
                findNeighborsForTile(newTile, tiles)
            }
        }
    }
}

fun findNeighbor(tile: Tile, direction: Direction, tiles: List<Tile>): Tile? {
    val pixels = tile.getPixelBorder(direction)
    tiles.forEach { other ->
        if (other != tile) {
            Direction.values().forEach { otherDir ->
                val otherPixels = other.getPixelBorder(otherDir)
                val match = pixelsMatch(pixels, otherPixels)
                match?.let { sameOrder ->
                    //                    println("****** Match ${tile.id} $direction  to  ${other.id} $otherDir (sameOrder: $sameOrder, symmetric: ${isSymmetric(pixels)})")
//                    println("\n************ ${tile.id}")
//                    printPixels(tile.pixels)
//                    println("\n************ ${other.id}")
//                    printPixels(other.pixels)
//                    println("\n******")
                    other.adjustImage(direction, otherDir, sameOrder)
                    val newMatch = tile.setNeighbor(direction, other)
                    require(newMatch)
//                    printMap(tiles)
                    return other
                }
            }
        }
    }
//    println("** no match found for ${tile.id} $direction:  ${pixels.map { if (it) "#" else '.' }}")
    return null
}

fun pixelsMatch(pixels: List<Boolean>, other: List<Boolean>): Boolean? {
    if (pixels.toList() == other.toList()) {
        return true
    } else if (pixels.asReversed().toList() == other.toList()) {
        return false
    } else {
        return null
    }
}

fun isSymmetric(pixels: List<Boolean>): Boolean {
    return pixels.withIndex().all { it.value == pixels[pixels.size - 1 - it.index] }
}

fun parseTiles(input: String): List<Tile> {
    val tiles = mutableListOf<Tile>()
    lateinit var pixels: MutableList<List<Boolean>>
    input.lines().forEach { line ->
        if (line.startsWith("Tile")) {
            val id = Integer.parseInt(line.substring("Tile ".length, line.length - 1))
            pixels = mutableListOf()
            tiles.add(Tile(id, pixels))
        } else if (line.trim().isEmpty()) {
            // ignore
        } else {
            pixels.add(parsePixelLine(line))
        }
    }
    return tiles

}

fun parsePixelLine(line: String): List<Boolean> {
    return line.map { it == '#' }
}

private fun rotatePixels(source: List<List<Boolean>>, clockwise: Boolean): List<List<Boolean>> {
    val count = source.size
    val newPixels = List(count) { MutableList(count) { false } }
    source.forEachIndexed { y, row ->
        row.forEachIndexed { x, px ->
            val yNew = if (clockwise) x else (count - 1 - x)
            val xNew = if (clockwise) (count - 1 - y) else y
            newPixels[yNew][xNew] = px
        }
    }
    return newPixels
}

private fun mirror(source: List<List<Boolean>>, horizontal: Boolean): List<List<Boolean>> {
    val count = source.size
    val newPixels = List(count) { MutableList(count) { false } }
    source.forEachIndexed { y, row ->
        row.forEachIndexed { x, px ->
            val yNew = if (horizontal) y else (count - 1 - y)
            val xNew = if (horizontal) (count - 1 - x) else x
            newPixels[yNew][xNew] = px
        }
    }
    return newPixels

}

private fun testRotate() {
    var testPixels = parseTiles(testTileInput)[0].pixels
    printPixels(testPixels)
    println("******* Clockwise")
    for (i in 1..4) {
        testPixels = rotatePixels(testPixels, true)
        printPixels(testPixels)
        println()
    }
    println("****** Counter Clockwise")
    for (i in 1..4) {
        testPixels = rotatePixels(testPixels, false)
        printPixels(testPixels)
        println()
    }
}

fun printPixels(pixels: List<List<Boolean>>) {
    println(formatPixels(pixels))
}

fun formatPixels(pixels: List<List<Boolean>>): String =
        pixels.map { it.map { if (it) '#' else '.' }.joinToString("") }.joinToString("\n")

fun printMap(tiles: List<Tile>) {
    val grid = Array(maxY - minY + 1) { y ->
        Array(maxX - minX + 1) { x ->
            val coord = Coord(minX + x, minY + y)
            tiles.find { it.coord == coord }
        }
    }

    println("***************************** Puzzle *********************************")
    println(grid.map { row ->
        row.map { tile ->
            tile?.id ?: "____"
        }.joinToString(", ")
    }.joinToString("\n\n"))
    println("**********************************************************************")
}

fun createFullImage(tiles: List<Tile>, withSeparators: Boolean): String {
    val pxPerTile = 8
    val offset = 1
    var image = StringBuilder()
    for (tileY in 0 until tilesPerDim) {
        for (yInTile in 0 until pxPerTile) {
            for (tileX in 0 until tilesPerDim) {
                val coord = Coord(minX + tileX, minY + tileY)
                val tile = tiles.find { it.coord == coord }!!
                for (xInTile in 0 until pxPerTile) {
                    val px = tile.pixels[offset + yInTile][offset + xInTile]
                    val c = if (px) "#" else "."
                    image.append(c)
                }
                if (withSeparators) {
                    image.append(" ")
                }
            }
            image.append("\n")
        }
        if (withSeparators) {
            image.append("\n")
        }
    }
    return image.toString()
}


fun findMonsters(fullImage: String) {
    val regexes = monster.lines().map { line ->
        val expr = line.map {
            when (it) {
                ' ' -> "."
                '#' -> "#"
                else -> throw IllegalArgumentException("Unknown char: $it")
            }
        }.joinToString("")
        println("Regex: $expr")
        Regex(expr)
    }

    var maxMonsterCount = 0
    val tile = parseTiles("Tile 0:\n$fullImage")[0]
    for (i in 0..3) {

        printPixels(tile.pixels)
        maxMonsterCount = max(maxMonsterCount, countMonsters(tile, regexes))

        println("\n************** Mirror horizontal (rotate $i) *****************\n")
        tile.adjustImage(mirrorParallel = true, mirrorOrthogonal = false, horizontal = true, rotate = false, clockwise = false)
        printPixels(tile.pixels)
        maxMonsterCount = max(maxMonsterCount, countMonsters(tile, regexes))
        tile.adjustImage(mirrorParallel = true, mirrorOrthogonal = false, horizontal = true, rotate = false, clockwise = false)

        println("\n************** Mirror vertical (rotate $i) *****************\n")
        tile.adjustImage(mirrorParallel = false, mirrorOrthogonal = true, horizontal = true, rotate = false, clockwise = false)
        printPixels(tile.pixels)
        maxMonsterCount = max(maxMonsterCount, countMonsters(tile, regexes))
        tile.adjustImage(mirrorParallel = false, mirrorOrthogonal = true, horizontal = true, rotate = false, clockwise = false)

        println("\n************** Mirror both (rotate $i) *****************\n")
        tile.adjustImage(mirrorParallel = true, mirrorOrthogonal = true, horizontal = true, rotate = false, clockwise = false)
        printPixels(tile.pixels)
        maxMonsterCount = max(maxMonsterCount, countMonsters(tile, regexes))
        tile.adjustImage(mirrorParallel = true, mirrorOrthogonal = true, horizontal = true, rotate = false, clockwise = false)

        println("\n\n***  rotate clockwise ${i + 1}")
        tile.adjustImage(mirrorParallel = false, mirrorOrthogonal = false, horizontal = true, rotate = true, clockwise = true)
    }

    val monsterHashCount = countHashes(monster)
    val tileHashCount = countHashes(formatPixels(tile.pixels))
    val hotwaterRougness = tileHashCount - (monsterHashCount * maxMonsterCount)
    println("Max monster count: $maxMonsterCount")
    println("# in Monster: $monsterHashCount")
    println("# in Tile: $tileHashCount")
    println("Hotwater Roughness: $hotwaterRougness")
    // 2581 is too high
}

fun countHashes(text: String): Int {
    return text.count { it == '#' }
}

fun countMonsters(tile: Tile, regexes: List<Regex>): Int {
//    Regex: ..................#.
//    Regex: #....##....##....###
//    Regex: .#..#..#..#..#..#...
    var count = 0
    val lines = formatPixels(tile.pixels).lines()

    if (lines[0] == ".####...#####..#...###..") {
        println("Expected: 2")
    }

    for (i in 1..lines.size - 2) {
        val matches1 = findAllRegExMatches(lines[i], regexes[1])
        if (matches1.isEmpty()) {
            continue
        }
        val matches0 = findAllRegExMatches(lines[i - 1], regexes[0])
        val matches2 = findAllRegExMatches(lines[i + 1], regexes[2])

//        println("-- Line ${i - 1}")
//        println("Matches 0: $matches0")
//        println("Matches 1: $matches1")
//        println("Matches 2: $matches2")

        matches1.forEach { match1 ->
            if (matches0.any { m0 -> match1 == m0 } && matches2.any { m0 -> match1 == m0 }) {
                count++
            }
        }
    }
    println("Monster found: $count")
    return count
}

private fun findAllRegExMatches(line: String, regex: Regex): List<Int> {
    var start = 0
    val regexSize = 18 // actually 20, but be safe
    val matches = mutableListOf<Int>()
    while (start < line.length - regexSize) {
        val match = regex.find(line, start)
        if (match != null) {
            matches.add(match.range.start)
            start = match.range.start + 1
        } else {
            start = line.length
        }
    }
    return matches
}

data class Tile(val id: Int, var pixels: List<List<Boolean>>) {

    var coord: Coord? = null

    var west: Tile? = null
    var north: Tile? = null
    var east: Tile? = null
    var south: Tile? = null

    override fun toString(): String {
        return "Tile $id:\n${formatPixels(pixels)}"
    }

    var imageAdjusted = false

    fun getNeighbor(direction: Direction): Tile? = when (direction) {
        Direction.West -> west
        Direction.North -> north
        Direction.East -> east
        Direction.South -> south
    }

    fun hasNeighbor(direction: Direction): Boolean = getNeighbor(direction) != null

    fun getNeighborCount(): Int = Direction.values().count { hasNeighbor(it) }

    fun setNeighbor(direction: Direction, other: Tile): Boolean {
        require(coord != null)
        val old = getNeighbor(direction)
        if (old == other) {
            return false
        }
        require(old == null) { "$id has already neighbor for $direction: $old.id" }

        val otherCoord: Coord
        when (direction) {
            Direction.West -> {
                west = other
                otherCoord = Coord(coord!!.x - 1, coord!!.y)
            }
            Direction.North -> {
                north = other
                otherCoord = Coord(coord!!.x, coord!!.y - 1)
            }
            Direction.East -> {
                east = other
                otherCoord = Coord(coord!!.x + 1, coord!!.y)
            }
            Direction.South -> {
                south = other
                otherCoord = Coord(coord!!.x, coord!!.y + 1)
            }
        }
        minX = min(minX, otherCoord.x)
        maxX = max(maxX, otherCoord.x)
        minY = min(minY, otherCoord.y)
        maxY = max(maxY, otherCoord.y)
        System.out.flush()
        require(other.coord == null || other.coord == otherCoord) { "${other.id} has already Coord: ${other.coord}, should be $direction of $id at $coord" }
        other.coord = otherCoord

        other.setNeighbor(direction.opposite(), this)
        return true
    }

    fun getPixelBorder(direction: Direction): List<Boolean> {
        return when (direction) {
            Direction.North -> pixels.first()
            Direction.South -> pixels.last()
            Direction.West -> getPixelColumn(true)
            Direction.East -> getPixelColumn(false)
        }
    }

    fun getPixelColumn(start: Boolean): List<Boolean> {
        return pixels.map { row ->
            if (start) row.first() else row.last()
        }
    }

    fun adjustImage(otherTileDir: Direction, unadjustedDir: Direction, sameOrder: Boolean): Boolean {
        require(imageAdjusted || getNeighborCount() == 0)
        val horizontal = unadjustedDir.horizontal()
        val rotate = otherTileDir.horizontal() != horizontal
        val adjustedDir = otherTileDir.opposite()
        val clockwise = ((unadjustedDir.ordinal + 1) % 4) == adjustedDir.ordinal
        val mirrorParallel: Boolean
        val mirrorOrthogonal: Boolean
        if (rotate) {
            val forwardBefore = unadjustedDir == Direction.North || unadjustedDir == Direction.East
            val forwardAfter = adjustedDir == Direction.North || adjustedDir == Direction.East
//            mirrorOrthogonal = clockwise == sameOrder
            mirrorOrthogonal = (forwardBefore == forwardAfter) != sameOrder
            mirrorParallel = false
        } else {
            mirrorParallel = unadjustedDir != adjustedDir
            mirrorOrthogonal = !sameOrder
        }

        if (!rotate && !mirrorOrthogonal && !mirrorParallel) {
            imageAdjusted = true
            return false
        }
        require(!imageAdjusted) { "** ERROR: Tile $id already adjusted! Expected: $unadjustedDir becomes $adjustedDir, sameOrder: $sameOrder" }

        return adjustImage(mirrorParallel, mirrorOrthogonal, horizontal, rotate, clockwise)
    }

    fun adjustImage(mirrorParallel: Boolean, mirrorOrthogonal: Boolean, horizontal: Boolean, rotate: Boolean, clockwise: Boolean): Boolean {
        var newPixels: List<List<Boolean>> = pixels
        if (mirrorParallel) {
            newPixels = mirror(newPixels, horizontal)
        }
        if (mirrorOrthogonal) {
            newPixels = mirror(newPixels, !horizontal)
        }
        if (rotate) {
            newPixels = rotatePixels(newPixels, clockwise)
        }

        //        println("\n******** Adjust Tile $id: $unadjustedDir becomes $adjustedDir, sameOrder: $sameOrder ( => horiz: ${unadjustedDir.horizontal()}, MirPar: $mirrorParallel, MirOrth: $mirrorOrthogonal, Rot: $rotate, Clock: $clockwise)")
        //        printPixels(pixels)
        //        println("********* NEW:")
        //        printPixels(newPixels)

        pixels = newPixels
        imageAdjusted = true
        return true
    }
}

enum class Direction {
    West,
    North,
    East,
    South;

    fun opposite(): Direction = values()[(ordinal + 2) % 4]

    fun horizontal(): Boolean = this == West || this == East
}

data class Coord(val x: Int, val y: Int)