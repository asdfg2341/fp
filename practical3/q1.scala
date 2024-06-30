def reverse(str: String): String = if str.isEmpty then "" else reverse(str.tail) + str.head

@main def main() =
    val str = "thathsara"
    println(reverse(str))