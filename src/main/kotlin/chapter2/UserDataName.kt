package chapter2

data class UserDataName(val id: Int, var name: String = "Default Name", val age: Int) {}

data class UserAddress(val id: Int, var name: String, var address: String)

fun getUser(id: Int): UserAddress {
  return UserAddress(id, "Taka", "Tokyo")
}

fun updateUser(id: Int, newName: String, newAddress: String) {
  val user = getUser(id).also { u ->
    u.name = newName
    u.address = newAddress
  }
  println(user)
}
