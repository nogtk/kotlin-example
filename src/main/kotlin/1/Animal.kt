open class Animal(val name: String) {
    fun showName() = println("name is $name")
    open fun cries() = println("")
}
