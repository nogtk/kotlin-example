package chapter2

import AddCalculationExecutor
import AddCalculationExecutorDelegate
import CommonCalculationExecutor

fun main(_args: Array<String>) {
    printOddOrEvenNumberText(1) 
    printOddOrEvenNumberText(2)
    printNumText(100)
    printNumText(200)
    printNumText(300)

    val user = User(1)
    user.name = "Taka"
    println(user.id)
    println(user.name)
    println(user.isValidName)

    val taka = UserData(1, "Taka")
    val taka2 = UserData(1, "Taka")
    val taki = UserData(1, "Taki")
    println(taka == taka2)
    println(taka == taki)

    println("taka=${taka.hashCode()}")
    println("taka2=${taka2.hashCode()}")
    println("taki=${taki.hashCode()}")

    val set = hashSetOf(taka)
    println(set.contains(taka2))
    println(set.contains(taki))

    val userDataName = UserDataName(id=1, age=25)
    println(userDataName.toString())

    println(calc(1, 3))
    println(squared(5))

    printCalcResult(10, 20) { n, m -> 
        n + m
    }
    printCalcResult(10, 20, { num3, num4 -> num3 * num4 } )

    println(2.square())

    println(oddNumbers)
    println(oddNumbersRun)

    println(createUser2("taka"))
    println(createUser2(null))

    updateUser(100, "Kotlin", "Nagoya")

    val executor = AddCalculationExecutor(CommonCalculationExecutor())
    executor.printStartMessage()
    println(executor.calc(8, 11))
    val executorDelegate = AddCalculationExecutorDelegate(CommonCalculationExecutor())
    executorDelegate.printStartMessage()
    println(executorDelegate.calc(8, 11))
}

fun printOddOrEvenNumberText(num: Int) {
    val text = if (num % 2 == 0)  "偶数" else "奇数"

    println(text)
}

fun printNumText(num: Int) {
    val text = when (num) {
        100 -> { "Equal to 100" }
        200 -> { "Equal to 200" }
        else -> { "Undefined value" }
    }

    println(text)
}

val calc: (Int, Int) -> Int = { num1, num2 -> num1 + num2 }
val squared: (Int) -> Int = { it * it }

typealias Calc = (Int, Int) -> Int
fun printCalcResult(num1: Int, num2: Int, calc: Calc) {
    println(calc(num1, num2))
}

fun Int.square(): Int = this * this

val oddNumbers = with(mutableListOf<Int>()) {
    for (i in 1..10) { if(i % 2 == 1) add(i) }
    this.joinToString(separator = " ")
}

val oddNumbersRun = mutableListOf<Int>().run {
    for (i in 1..10) { if (i % 2 == 1) add(i) }
    this.joinToString(separator = " ")
}

fun createUser2(name: String?): User2? {
    return name?.let { User2(it) }
}
