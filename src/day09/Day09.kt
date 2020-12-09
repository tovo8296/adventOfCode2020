package day09

import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.lang.Long
import kotlin.math.max
import kotlin.math.min

val preambleLength = 25

fun main() {
    val numbers = inputDay09.lines().map { Long.parseLong(it) }
    val requestedIndex = findInvalidIndex(numbers)
    val range = findContiguousSum(numbers, requestedIndex)
    val min = findMinMaxNumber(numbers, range, false)
    val max = findMinMaxNumber(numbers, range, true)
    println("Range extreme sum is ${min + max}")
}

fun findMinMaxNumber(numbers: List<kotlin.Long>, range: Pair<Int, Int>, biggest: Boolean): kotlin.Long {
    var extreme = numbers[range.first]
    for (i in range.first..range.second) {
        if (biggest){
            extreme = max(extreme, numbers[i])
        }else {
            extreme = min(extreme, numbers[i])
        }
    }
    return extreme
}

fun findContiguousSum(numbers: List<kotlin.Long>, requestedIndex: Int): Pair<Int, Int> {
    val requestedSum = numbers[requestedIndex]
    for (start in 0 until requestedIndex) {
        for (end in start until requestedIndex) {
            val sum = sumRange(numbers, start, end)
            if  (sum == requestedSum) {
                return Pair(start, end)
            }
        }
    }
    throw IllegalArgumentException("Found no sum range")
}

fun sumRange(numbers: List<kotlin.Long>, start: Int, end: Int): kotlin.Long {
    var sum: kotlin.Long = 0L
    for (i in start..end) {
        sum += numbers[i]
    }
    return sum
}

private fun findInvalidIndex(numbers: List<kotlin.Long>): Int {
    for (i in preambleLength until numbers.size) {
        val sum = numbers[i]
        val found = hasSummandsBefore(i, numbers, sum)
        if (!found) {
            println("Number $sum at index $i not found")
            return i
        }
    }
    throw IllegalStateException("Found no invalid number")
}

private fun hasSummandsBefore(i: Int, numbers: List<kotlin.Long>, sum: kotlin.Long): Boolean {
    for (si1 in (i - preambleLength) until i) {
        for (si2 in (i - preambleLength) until i) {
            val s1 = numbers[si1]
            val s2 = numbers[si2]
            if (s1 != s2 && s1 + s2 == sum) {
                return true
            }
        }
    }
    return false
}