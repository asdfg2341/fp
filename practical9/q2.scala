import scala.util.Try

def categorizeNumber(input: Int): String = {
  val isNegativeOrZero = (n: Int) => n <= 0
  val isEven = (n: Int) => n % 2 == 0

  (isNegativeOrZero(input), isEven(input)) match {
    case (true, _) => "Input is Negative/Zero"
    case (_, true) => "Even number is given"
    case (_, false) => "Odd number is given"
  }
}

@main def main(args: String*): Unit = {
  val numberOption = args.headOption.map(arg => Try(arg.toInt).toOption).flatten
  numberOption match {
    case Some(number) => println(categorizeNumber(number))
    case None => println("Please provide a valid integer.")
  }
}