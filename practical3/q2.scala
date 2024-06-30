def stringsLongerThan(len: Int, strs: Array[String]): Array[String] = strs.filter(str => str.length > len)

@main def main() =
    val names = Array("thathsara", "madushanka", "sachintha", "sachith", "john", "doe", "jane", "smith")
    println(stringsLongerThan(5, names).mkString(", "))