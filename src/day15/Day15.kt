package day15

val input = intArrayOf(15,12,0,14,3,1)

fun main() {
    calculateNumberAt(2020) // part 1 => 249
    calculateNumberAt(30000000) // part 2 => 41687
}

fun calculateNumberAt(destinationAge: Int) {
    var memory = mutableMapOf<Int, Int>()
    var previousAge = 0
    var previousNumber = 0
    input.forEach { num ->
        if (previousAge > 0) {
            memory.put(previousNumber, previousAge)
        }
        previousAge++
        previousNumber = num
    }
    while(previousAge < destinationAge) {
        val nextNum = calculateNextNumber(previousAge, previousNumber, memory)
        memory.put(previousNumber, previousAge)
        previousAge++
        previousNumber = nextNum
    }
    println("Number at $previousAge is $previousNumber")
}

fun calculateNextNumber(previousAge: Int, previousNumber: Int, memory: MutableMap<Int, Int>): Int {
    if (memory.containsKey(previousNumber)) {
        val oldAge = memory.get(previousNumber)!!
        return previousAge - oldAge
    }else {
        return 0
    }
}
