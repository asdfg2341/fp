def toUpper(name: String): String = name.toUpperCase

def toLower(name: String): String = name.toLowerCase

def formatNames(name: String)(func: String => String): String = func(name)

@main def main() = {
  println(formatNames("Benny")(toUpper))
  println(formatNames("Niroshan")(name => name.substring(0, 2).toLowerCase + name.substring(2).toUpperCase))
  println(formatNames("Saman")(toLower))
  println(formatNames("Kumara")(name => name.substring(0, name.length - 1).toLowerCase + name.substring(name.length - 1).toUpperCase))

  // println("thathsara".substring(2))

  // val a = formatNames()(toUpper)
  // println(a(toUpper))
}