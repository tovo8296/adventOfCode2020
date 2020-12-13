package day13

import java.lang.IllegalArgumentException
import java.math.BigInteger
import java.util.*

val input = """
1000340
13,x,x,x,x,x,x,37,x,x,x,x,x,401,x,x,x,x,x,x,x,x,x,x,x,x,x,17,x,x,x,x,19,x,x,x,23,x,x,x,x,x,29,x,613,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,41
""".trimIndent()

val testInput = """
939
7,13,x,x,59,x,31,19
""".trimIndent()

val testInputPart2_1 = Pair("17,x,13,19", 3417L)
val testInputPart2_2 = Pair("67,7,59,61", 754018L)

fun main() {
    val source = input
    val myTime = Integer.parseInt(source.lines()[0].trim())
    val buses = parseBuses(source.lines()[1].trim())
//    findEarliestBus(myTime, buses) // part 1 => 136

    findContestTime(buses) // part 2 => 305068317272992
}

fun findContestTime(buses: List<Bus>) {
    var bus1 = buses[0]
    for (i in 1 until buses.size) {
        var bus2 = buses[i]
        val vbus = matchBuses(bus2, bus1)
        bus1 = vbus
    }

    println("\n----- Result: t_base = ${bus1.startOffset}")
    val tBase = bus1.startOffset
    buses.forEach { bus ->
        val t = tBase + bus.offset
        val cycle = t.toBigDecimal() / bus.id.toBigDecimal()
        println("$bus leaves at $t (cycle $cycle)")
    }
}


fun matchBuses(bus1: Bus, bus2: Bus): Bus {
    var tBus2 = bus2.startOffset
    for (i in 1..bus1.id.toLong()) {
        tBus2 += bus2.id
        val tBase = tBus2 - bus2.offset
        val tBus1 = tBase + bus1.offset - bus1.startOffset
        if (tBus1 % bus1.id == BigInteger.ZERO) {
            val div1 = tBus1.toFloat() / bus1.id.toFloat()
            val div2 = tBus2.toFloat() / bus2.id.toFloat()
            val product = bus1.id * bus2.id
            val virtualBus = Bus(id = product, offset = BigInteger.ZERO, startOffset = tBase)
            println("Match: $bus1, $bus2 with t-Base at: $tBase. $bus1 leaves at $tBus1 (cycle $div1), $bus2 leaves at $tBus2 (cycle $div2). Full cycle every $product => virtual bus: $virtualBus")
            return virtualBus
        }
    }
    throw IllegalArgumentException("Can not find match for $bus1 and $bus2")
}

fun findEarliestBus(myTime: Int, buses: List<Bus>) {
    var earliestBusTime: Int = Integer.MAX_VALUE
    var earliestBusId = -1
    buses.forEach { bus ->
        val busTime = getNextBusStopAfter(myTime, bus.id.toInt())
        if (busTime < earliestBusTime) {
            earliestBusTime = busTime
            earliestBusId = bus.id.toInt()
        }
    }
    val waitTime = earliestBusTime - myTime
    val mult = earliestBusId * waitTime
    println("Bus $earliestBusId leaves at $earliestBusTime, $waitTime after $myTime. Mult: $mult")
}

fun getNextBusStopAfter(myTime: Int, bus: Int): Int {
    val div: Int = myTime / bus
    val timeBefore = div * bus
    if (timeBefore == myTime) {
        return timeBefore
    } else {
        return timeBefore + bus
    }
}

fun parseBuses(line: String): List<Bus> {
    val buses = mutableListOf<Bus>()
    val tokenizer = StringTokenizer(line, ",")
    var index = 0
    while (tokenizer.hasMoreTokens()) {
        val token = tokenizer.nextToken().trim()
        if (token != "x") {
            buses.add(Bus(id = BigInteger(token), offset = BigInteger(index.toString())))
        }
        index++
    }
    println(buses.toString() + "\n")
    return buses
}

data class Bus(val id: BigInteger, val offset: BigInteger, val startOffset: BigInteger = BigInteger.ZERO)