package chapter2

class User(id: Int) {
    lateinit var name: String
    val id: Int = id
    val isValidName: Boolean
        get() = name != ""
}

data class UserData(val id: Int, var name: String) {}

data class User2(val name: String)
