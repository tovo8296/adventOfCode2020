package day12

import java.lang.IllegalArgumentException
import kotlin.math.abs


val input = """
F36
L90
S5
F67
W3
R90
F67
R90
E1
S5
W2
N1
E1
F21
S4
E2
S5
R90
N1
F69
R180
N3
F40
E1
S3
R90
S1
R90
F100
W3
F82
N2
W2
F47
W5
F77
W5
R90
N2
W2
F34
N3
E3
F54
L90
S1
E3
R90
F9
R90
E1
N1
F91
L90
S4
W5
S3
L90
W3
F6
L180
N5
F34
E2
L90
F84
L90
W5
L90
W2
N2
E4
L270
F31
N1
R90
N1
W4
L90
F72
S4
F2
L90
F92
N4
E5
F88
R180
E1
S4
E1
S1
F9
N2
W2
L90
F61
R90
F93
S3
L90
W3
F26
E1
L90
E4
S3
R270
N2
F39
R180
S4
E4
F65
S4
R180
S2
F46
W5
R90
E4
L90
F98
W4
R90
E2
R180
F14
L90
S1
F8
S3
L90
N3
F11
S2
L90
W3
S3
L90
W1
L90
F64
S2
E2
N4
W3
F38
E3
N2
F19
S2
L90
E2
F94
E1
R90
E2
S5
L90
F6
E3
S4
L180
W5
R90
N3
W3
S5
F24
L90
F1
W4
F47
W2
S1
E1
S2
E1
N4
L180
F61
W2
F20
E5
S3
F37
F6
L90
E1
R90
W5
S2
L90
E2
N2
L90
F50
W2
F49
R90
S1
R180
S5
R90
S1
E4
R90
F65
L90
S5
E1
F61
S2
F40
L90
E5
R90
E5
L90
S1
F67
S2
F48
R270
E4
F35
S5
F14
L180
E3
L90
F64
W3
R90
E2
R90
S3
L90
S2
W4
F94
R180
N1
W1
R90
F41
R90
N1
L90
W2
N2
R90
F43
N1
L180
F6
E4
F99
N1
F54
N3
R90
F57
W5
F16
S5
L90
E5
R90
S4
L90
F68
L180
S1
E4
R90
F88
S2
F19
R90
W2
W1
F62
S2
R90
N3
R180
S5
E4
F41
W2
S5
W1
R90
W2
W4
L90
S4
R90
F1
W5
F44
W3
N2
F41
W5
L90
N5
W1
F13
E2
R90
N3
W3
F8
W1
R90
F51
R90
E1
S5
F18
S2
E3
F23
L180
F26
N2
F25
E4
F24
E5
N1
L90
S1
E5
R90
F88
S2
W3
R90
F30
L90
E4
L270
S1
E2
F87
W4
N1
R180
N1
F2
L90
S3
F29
S4
L90
N2
F59
L90
W2
N5
F45
N2
W4
N4
F27
W5
F4
S2
F56
L180
S2
R90
W4
F95
L90
R90
F68
L90
S4
W5
F46
N1
W2
F80
R270
F35
L90
E3
S5
R90
S1
W2
F53
S3
R180
F38
F57
W1
R90
N1
W4
S3
R180
E1
F24
S5
F96
W4
F53
S4
F59
F7
E5
S2
L90
E2
L90
N5
L90
N3
F75
S2
R180
N1
W3
N3
R90
F71
L180
S4
L90
F53
S5
L90
N5
S5
F14
L90
E3
F40
N1
E3
N2
F69
W1
N5
W3
S3
R90
N3
F3
S5
E1
R90
E5
F16
R90
F94
E2
L180
F16
E2
F71
W1
F4
L90
W4
F45
L90
S3
W3
S5
R90
E3
N1
W1
S3
L90
W2
W1
S5
F1
L90
E3
L180
S5
F5
W1
L90
N5
E5
R90
E2
R90
W5
R90
F11
W5
S2
E5
R90
F29
W5
S5
F14
S4
L90
F48
R180
F63
E4
N4
E5
W5
S4
W5
S5
F9
L270
W3
F78
W2
F100
W2
N4
F44
F11
E2
F17
E4
F80
S5
F36
L90
W2
F12
L90
N4
E3
S5
F90
F73
W1
S3
W4
F50
N4
N3
F79
W5
F38
L90
W5
S3
F50
R90
L270
R180
F84
L180
E2
R180
N3
N3
W5
S3
L180
N3
E1
N4
N5
F23
N2
E1
N1
E3
F64
E4
F4
R90
S4
E5
S2
L90
E3
F32
W1
N2
F20
E4
W5
F93
E5
N1
W4
F18
E1
N1
F7
N3
F55
E3
F91
W4
F86
N5
W1
F38
N4
R180
W4
S5
F95
R180
F22
R90
F58
W3
F62
L90
F17
S2
R90
N5
L90
N4
E1
N1
E2
E4
R180
F72
N4
E4
R180
F74
W5
N5
W5
N5
W2
F26
S2
E4
N4
F23
E2
F95
E1
N4
E1
L270
S3
E3
R90
S2
E5
R180
F73
S5
W1
F61
F60
E2
F97
S2
L90
W5
R180
F99
R180
F52
N1
L180
S4
W4
R180
F70
S4
L90
S5
W2
L90
N2
W5
F31
L90
E3
F87
L90
S2
W4
F25
L180
F50
S5
E1
F75
N2
F30
S4
F100
E3
L180
F57
L90
W5
R90
W2
F65
L90
F29
E4
L270
E3
L90
N4
E2
E5
F36
N4
E4
N4
F41
E2
S3
F72
W4
F26
L90
E5
R90
N4
F97
L90
W1
F31
N2
L90
E3
N5
L90
F5
R180
F97
S1
E5
N4
R90
F77
N2
F92
S5
F84
E3
S3
L270
N3
R180
N4
F63
N4
E5
F62
S3
F54
N2
E5
F89
R90
S4
F95
F56
L90
S4
L90
S4
R180
F93
""".trimIndent()

val testInput = """
F10
N3
F7
R90
F11
""".trimIndent()

data class Instruction(val code: CommandCode, val number: Int)

enum class CommandCode {
    North,
    South,
    East,
    West,
    Left,
    Right,
    Forward
}

enum class Direction {
    North,
    East,
    South,
    West
}

data class Coord(var east: Int, var north: Int)


fun main() {
    val route = parse(input)

    calculateAsShipCommands(route) // part 1 => 1152
    calculateAsWaypointCommands(route) // part 2 => 58637
}

fun calculateAsWaypointCommands(route: List<Instruction>) {
    var waypoint = Coord(north = 1, east = 10)
    var shipEast = 0
    var shipNorth = 0

    route.forEach { instruction ->
        when (instruction.code) {
            CommandCode.North -> waypoint.north += instruction.number
            CommandCode.South -> waypoint.north -= instruction.number
            CommandCode.East -> waypoint.east += instruction.number
            CommandCode.West -> waypoint.east -= instruction.number
            CommandCode.Left -> waypoint = turnWaypoint(waypoint, instruction.number, false)
            CommandCode.Right -> waypoint = turnWaypoint(waypoint, instruction.number, true)
            CommandCode.Forward -> {
                shipEast += waypoint.east * instruction.number
                shipNorth += waypoint.north * instruction.number
            }
        }
//        println("Ship: East: $shipEast, North: $shipNorth      waypoint: $waypoint")
    }
    val distanceAbs = abs(shipNorth) + abs(shipEast)
    println("calculateAsWaypointCommands: Position: North: $shipNorth, East: $shipEast, Manhattan Distance: $distanceAbs")
}

fun turnWaypoint(waypoint: Coord, number: Int, clockwise: Boolean): Coord {
    val turns = number / 90
    val sign = if (clockwise) 1 else -1
    val turnsAbs = ((turns * sign) + 4) % 4
    return when (turnsAbs) {
        1 -> Coord(east = waypoint.north, north = -waypoint.east)
        2 -> Coord(east = -waypoint.east, north = -waypoint.north)
        3 -> Coord(east = -waypoint.north, north = waypoint.east)
        else -> throw IllegalArgumentException("Unknown direction: $number, $clockwise => abs: $turnsAbs")
    }
}

private fun calculateAsShipCommands(route: List<Instruction>) {
    var direction = Direction.East
    var e = 0
    var n = 0

    route.forEach { instruction ->
        when (instruction.code) {
            CommandCode.North -> n += instruction.number
            CommandCode.South -> n -= instruction.number
            CommandCode.East -> e += instruction.number
            CommandCode.West -> e -= instruction.number
            CommandCode.Left -> direction = turnShip(direction, instruction.number, false)
            CommandCode.Right -> direction = turnShip(direction, instruction.number, true)
            CommandCode.Forward -> {
                when (direction) {
                    Direction.North -> n += instruction.number
                    Direction.East -> e += instruction.number
                    Direction.South -> n -= instruction.number
                    Direction.West -> e -= instruction.number
                }
            }
        }
    }
    val distanceAbs = abs(n) + abs(e)
    println("calculateAsShipCommands: Position: North: $n, East: $e, Manhattan Distance: $distanceAbs")
}

fun turnShip(direction: Direction, number: Int, clockwise: Boolean): Direction {
    val sign = if (clockwise) 1 else -1
    if (number % 90 != 0) {
        throw IllegalArgumentException("Unknown turn: $direction, $number, $clockwise")
    }
    val turns = number / 90
    val newNumber = direction.ordinal + (turns * sign)
    val newOrdinal = (newNumber + 4) % 4
    return Direction.values()[newOrdinal]
}

fun parse(input: String): List<Instruction> {
    return input.lines().map { line ->
        val code = when (line[0]) {
            'N' -> CommandCode.North
            'S' -> CommandCode.South
            'E' -> CommandCode.East
            'W' -> CommandCode.West
            'L' -> CommandCode.Left
            'R' -> CommandCode.Right
            'F' -> CommandCode.Forward
            else -> throw IllegalArgumentException("Unknown command code: $line")
        }
        val number = Integer.parseInt(line.substring(1))
        Instruction(code, number)
    }.toList()
}