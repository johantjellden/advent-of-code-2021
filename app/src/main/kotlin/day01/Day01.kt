package day01

import common.InputRepo
import common.readSessionCookie
import common.solve

fun main(args: Array<String>) {
    val day = 1
    val input = InputRepo(args.readSessionCookie()).get(day = day)

    solve(day, input, ::solveDay01Part1, ::solveDay01Part2)
}

fun solveDay01Part1(input: List<String>): Int {

    val nrs = input.map { it.toInt() }

    return nrs.increaseCounter()
}

fun solveDay01Part2(input: List<String>): Int {
    val nrs = input.map(String::toInt)

    return nrs
        .windowed(3, 1)
        .map { it.sum() }
        .increaseCounter()
}

private fun List<Int>.increaseCounter() = this.fold(
    Pair<Int?, Int>(null, 0)
) { acc, nextNr ->
    if (acc.first == null) {
        acc.copy(nextNr, 0)
    } else if (nextNr > acc.first!!) {
        acc.copy(nextNr, acc.second + 1)
    } else {
        acc.copy(nextNr, acc.second)
    }

}.second
