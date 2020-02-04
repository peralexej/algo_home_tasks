package kot

import kotlin.math.abs
import kotlin.system.measureNanoTime


fun main(args: Array<String>) {
    val firstNum = abs(50000L)
    val secondNum = abs(90000L)
    var result = 0L


    var time = measureNanoTime {
        result = NODSubtraction(firstNum, secondNum)
    }
    println("Substraction algo time is: $time and result is: $result")

    time = measureNanoTime {
        result = NODRemainder(firstNum, secondNum)
    }
    println("Remainder algo time is: $time and result is: $result")

    time = measureNanoTime {
        result = NODbitOper(firstNum, secondNum)
    }
    println("Bit algo time is: $time and result is: $result")
}

fun NODSubtraction(a: Long, b: Long): Long {
    var a = a
    var b = b
    while (a != b) {
        if (a > b) {
            a -= b
        } else {
            b -= a
        }
    }
    return a
}

fun NODRemainder(a: Long, b: Long): Long {
    var a = a
    var b = b
    var t: Long
    while (b != 0L) {
        t = b
        b = a % b
        a = t
    }
    return a
}


fun NODbitOper(a: Long, b: Long): Long {
    var a = a
    var b = b
    var shift = 0
    if (a == 0L)
        return b
    if (b == 0L)
        return a
    while (a or b and 1 == 0L) {
        a = a shr 1
        b = b shr 1
        ++shift
    }
    while (a and 1 == 0L)
        a = a shr 1
    do {
        while (b and 1 == 0L)
            b = b shr 1
        if (a > b) {
            val t = b
            b = a
            a = t
        }
        b = b - a
    } while (b != 0L)
    return a shl shift
}