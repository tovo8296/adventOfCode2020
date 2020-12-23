package day23

import java.lang.StringBuilder
import java.util.ArrayList

val input = mutableListOf<Int>(8, 7, 2, 4, 9, 5, 1, 3, 6)
val testInput = mutableListOf<Int>(3, 8, 9, 1, 2, 5, 4, 6, 7)

typealias Cups = Node
typealias Destination = Node

val sourceList = createMillionCups(input)
var cups: Cups = createNodes(sourceList)
val orderedCups = createOrderedList(cups, sourceList.size)

val maxValue = sourceList.size

//var current = 0

fun main() {
    printCups()
//    val loops = 100 // part 1
    val loops = 10000000
    for (i in 1..loops) {
        if (i % 1000 == 0) {
            println("-- move $i --")
        }
        doMove()
    }

    val cupsAfter1 = cupsAfter1()

//    println("\nAll Cups after 1: ${cupsAfter1.joinToString("")}")

    val product = cupsAfter1[0].toBigInteger() * cupsAfter1[1].toBigInteger()
    println("\n 2 Cups after 1: ${cupsAfter1[0]}, ${cupsAfter1[0]}, product: $product")

}


fun createMillionCups(input: MutableList<Int>): MutableList<Int> {
    val max = input.max()!!
    var nextValue = max + 1
    return MutableList(1000000) { index ->
        if (index < input.size) {
            input[index]
        } else {
            nextValue++
        }
    }
}

fun createOrderedList(cups: Node, max: Int): List<Node?> {
    val list = MutableList<Node?>(max + 1) { null }
    var node = cups
    do {
        list[node.value] = node
        node = node.next
    } while (node != cups)
    return list
}


fun cupsAfter1(): List<Int> {
//    val index1 = cups.indexOf(1)
//    return (1 until cups.size).map { offset ->
//        val index = (index1 + offset) % cups.size
//        cups[index]
//    }

    val node1 = findNode(1)!!
    val list = ArrayList<Int>(1000000)
    var node = node1.next
    while (node != node1) {
        list.add(node.value)
        node = node.next
    }
    return list
}

fun doMove() {
//    printCups()
    val removed = removeCups()
//    println("pick up: $removed")
    val destination = getDestinationIndex(removed)
//    println("destination: ${cups[destination]}")
    insertCups(destination, removed)
//    current = (current + 1) % cups.size
    cups = cups.next
}

fun insertCups(destination: Node, newCups: Node) {
//    val insertIndex = destination + 1
//    cups.addAll(insertIndex, newCups)
//    if (insertIndex <= current) {
//        current += newCups.size
//    }

    val newCupsEnd = newCups.previous
    val afterDestination = destination.next

    connectNodes(destination, newCups)
    connectNodes(newCupsEnd, afterDestination)
}

fun getDestinationIndex(removed: Cups): Destination {
    val currentValue = cups.value
//    val currentValue = cups[current]
    var destinationValue = currentValue - 1
    do {
        if (destinationValue == 0) {
            destinationValue = maxValue
//            return cups.indexOf(cups.max()!!)
        }
        if (findNodeInRing(destinationValue, removed) == null) {
            val destinationNode = findNode(destinationValue)
            return destinationNode!!
        }
//        val destinationIndex = cups.indexOf(destinationValue)
//        if (destinationIndex != -1) {
//            return destinationIndex
//        }
        destinationValue--
    } while (true)
}

private fun removeCups(): Cups {
//    return (1..3).map {
//        val removeIndex = (current + 1) % cups.size
//        if (removeIndex < current) {
//            current--
//        }
//        cups.removeAt(removeIndex)
//    }
    val removeStart = cups.next
    val removeEnd = removeStart.next.next
    val afterRemove = removeEnd.next

    connectNodes(cups, afterRemove)
    connectNodes(removeEnd, removeStart)
    return removeStart
}

fun printCups() {
    var node = cups
    var endReached = false
    val s = StringBuilder("(${node.value.toString()})")
    for (i in 1..20) {
        node = node.next
        if (node == cups) {
            endReached = true
            break
        }
        s.append(" ").append(node.value)
    }
    if (!endReached) {
        s.append(", ...")
    }
    println("cups: $s")
}

fun createNodes(values: MutableList<Int>): Node {
    val first = Node(values[0])
    var previous = first
    for (i in 1 until values.size) {
        val node = Node(values[i])
        connectNodes(previous, node)
        previous = node
    }
    connectNodes(previous, first)
    return first
}

fun findNode(value: Int): Node? {
    return orderedCups[value]
}

fun findNodeInRing(value: Int, ring: Node): Node? {
    var node = ring
    do {
        if (node.value == value) {
            return node
        }
        node = node.next
    } while (node != ring)
    return null
}

fun connectNodes(previous: Node, next: Node) {
    previous.next = next
    next.previous = previous
}

data class Node(val value: Int) {
    lateinit var next: Node
    lateinit var previous: Node
}