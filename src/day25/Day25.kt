package day25

import java.lang.IllegalStateException
import java.math.BigInteger

val input = Pair(6929599, 2448427)
//Loopsize for subject number 6929599 is: 15210194
//Loopsize for subject number 2448427 is: 8652834
//Encryption key is 16933668 (based on subject2 2448427 and loopsize1 15210194)
//Encryption key is 16933668 (based on subject1 6929599 and loopsize2 8652834)

val testInput = Pair(5764801, 17807724)

val mod = 20201227
val modBI = mod.toBigInteger()

fun main() {
    val source = input
    val loopSize1 = findLoopSize(source.first)
    val loopSize2 = findLoopSize(source.second)

    val key1 = transform(source.second.toBigInteger(), loopSize1)
    println("Encryption key is $key1 (based on subject2 ${source.second} and loopsize1 $loopSize1)")
    val key2 = transform(source.first.toBigInteger(), loopSize2)
    println("Encryption key is $key2 (based on subject1 ${source.first} and loopsize2 $loopSize2)")
}

fun findLoopSize(result: Int): Int {
    val subjectNumber = 7.toBigInteger()
    val resultBI = result.toBigInteger()
    for (i in 1..mod) {
        val actual = transform(subjectNumber, i)
        if (actual == resultBI) {
            println("Loopsize for subject number $result is: $i")
            return i
        }
    }
    throw IllegalStateException("Can not find loopsize for subject number $result")
}

private fun transform(subjectNumber: BigInteger, loopSize: Int) =
        subjectNumber.modPow(loopSize.toBigInteger(), modBI)
