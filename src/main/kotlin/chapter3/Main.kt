package chapter3

import DogKotlin
import HelloByJava
import java.time.LocalDateTime
import java.util.*

data class Time(val time: LocalDateTime)

fun main(_args: Array<String>) {
    val hello = HelloByJava()
    hello.printHello()

    val uuid: UUID = UUID.randomUUID()
    println(uuid.toString())

    val now = Time(LocalDateTime.now())
    println(now.time)

    val dogKotlin = DogKotlin()
    println(dogKotlin.cry())
}
