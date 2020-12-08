package handheld

import java.lang.IllegalArgumentException

enum class Op {
    acc,
    jmp,
    nop,
}

data class Instruction(val op: Op, val arg: Long)

fun parseHandheld(input: String): List<Instruction> {
    return input.lines().map {
        parseInstruction(it)
    }
}

fun parseInstruction(line: String): Instruction {
    val spaceIndex = line.indexOf(" ")
    val opString = line.substring(0, spaceIndex)
    val op = Op.valueOf(opString)
    val sign = when(line[spaceIndex+1]) {
        '+' -> true
        '-' -> false
        else -> throw IllegalArgumentException("Can't find sign at index ${spaceIndex+1} of: '$line'")
    }
    val numString = line.substring(spaceIndex+2)
    val numAbs = java.lang.Long.parseLong(numString)
    val num = if (sign) numAbs else -numAbs
    return Instruction(op, num).also {
//        println("Parse $line to $it")
    }
}


class HandheldComputer(val program: List<Instruction> ) {
    var acc: Long = 0L
    var opPointer = 0

    fun runNextInstruction() {
        val instruction = nextInstruction()
        when (instruction.op) {
            Op.acc -> {
                acc += instruction.arg
                opPointer++
            }
            Op.jmp -> opPointer += instruction.arg.toInt() // TODO check int range
            Op.nop -> opPointer++
            else -> throw IllegalArgumentException("Unknown instruction: $instruction")
        }
//        println("Instruction $instruction    => nextOp: $opPointer,   acc: $acc")
    }

    fun nextInstruction() = program[opPointer]
}