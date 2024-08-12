import scala.util.Try

def categorizeNumber(input: Int): String = {
  val multipleOfThree = (n: Int) => n % 3 == 0
  val multipleOfFive = (n: Int) => n % 5 == 0

  (multipleOfThree(input), multipleOfFive(input)) match {
    case (true, true) => "Multiple of Both Three and Five"
    case (true, false) => "Multiple of Three"
    case (false, true) => "Multiple of Five"
    case (false, false) => "Not a Multiple of Three or Five"
  }
}

@main def main(args: String*): Unit = {
  val numberOption = args.headOption.map(arg => Try(arg.toInt).toOption).flatten // because option[option[int]]
  numberOption match {
    case Some(number) => println(categorizeNumber(number))
    case None => println("Please provide a valid integer.")
  }
}