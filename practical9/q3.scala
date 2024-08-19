def toUpper(name: String): String = name.toUpperCase

def toLower(name: String): String = name.toLowerCase

def formatNames(name: String)(format: String => String): String = format(name)

@main def main(args: String*): Unit = {
  val names = List(
    ("Benny", toUpper),
    ("Niroshan", (name: String) => name.substring(0, 2).toUpperCase + name.substring(2)),
    ("Saman", toLower),
    ("Kumara", (name: String) => name.substring(0, 1).toUpperCase + name.substring(1, 5).toLowerCase + name.substring(5).toUpperCase)
  )

  names.foreach { case (name, format) =>
    println(formatNames(name)(format))
  }
}