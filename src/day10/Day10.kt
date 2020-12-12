package day10

import java.lang.IllegalArgumentException
import java.math.BigInteger

val input = """
133
157
39
74
108
136
92
55
86
46
111
58
80
115
84
67
98
30
40
61
71
114
17
9
123
142
49
158
107
139
104
132
155
96
91
15
11
23
54
6
63
126
3
10
116
87
68
72
109
62
134
103
1
16
101
117
35
120
151
102
85
145
135
79
2
147
33
41
93
52
48
64
81
29
20
110
129
43
148
36
53
26
42
156
154
77
88
73
27
34
12
146
78
47
28
97
""".trimIndent()

val testInput = """
28
33
18
42
31
14
46
20
48
47
24
23
49
45
19
38
39
11
1
32
25
35
8
17
7
9
4
2
34
10
3
""".trimIndent()

val simpleInput = """
16
10
15
5
1
11
7
19
6
12
4
""".trimIndent()

fun main() {
    val joltages = input.lines().map { Integer.parseInt(it) }.toMutableList()
    joltages.sort()
    val deviceJoltage = joltages.last() + 3
    println("device joltage: $deviceJoltage, number of adapters: ${joltages.size}")

    val joltagesWithBounds = ArrayList(joltages)
    joltagesWithBounds.add(0, 0)
    joltagesWithBounds.add(deviceJoltage)

//    countDiff1Diff3(joltagesWithBounds) // part 1
    countArrangements(joltagesWithBounds) // part 2 => 6908379398144
}

fun countDiff1Diff3(joltagesWithBounds: ArrayList<Int>) {
    var diff1 = 0
    var diff3 = 0
    var previous = joltagesWithBounds[0]
    joltagesWithBounds.forEachIndexed { index, joltage ->
        val diff = joltage - previous
        when (diff) {
            1 -> diff1++
            2 -> {/* ignore */
            }
            3 -> diff3++
            else -> throw IllegalArgumentException("Invalid difference between $previous and $joltage at index $index")
        }
        previous = joltage
    }

    println("diff1 * diff3: ${diff1 * diff3}")
}

fun countArrangements(joltagesWithDevice: java.util.ArrayList<Int>) {
    val bits = BooleanArray(joltagesWithDevice.last() + 1)
    joltagesWithDevice.forEach { bits[it] = true }

//    println(joltagesWithDevice.joinToString(", "))
//    println(bits.joinToString(" "))

    var arrangements: BigInteger = BigInteger.ONE

    bits.forEachIndexed { index, bit ->
        if (bit) {
            if (index > 0 && index < bits.size - 1 && bits[index - 1]) {
                if (bits[index + 1]) {
                    println("Double (xXx): $index")
                    arrangements = arrangements * BigInteger.TWO
                    if (bits.getOrElse(index - 1, { false }) && bits.getOrElse(index - 2, { false }) && bits.getOrElse(index - 3, { false })) {
                        arrangements = arrangements / BigInteger("8") * BigInteger("7")
                        println("xXXXx  at: $index => not all optinal")
                    }
                } else if (bits[index + 2]) {
                    if (bits[index + 3]) {
                        println("Triple (xX_xx): $index")
                        arrangements = arrangements * BigInteger("3")
                    } else {
                        println("Double (xX_x_): $index")
                        arrangements = arrangements * BigInteger.TWO
                    }
                }
            }
        }
    }

    println("Arrangements: $arrangements")
}
