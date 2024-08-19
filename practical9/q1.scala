def calculateInterest(deposit: Double): Double = {
  val interestRate = deposit match {
    case x if x <= 20000 => 0.02
    case x if x <= 200000 => 0.04
    case x if x <= 2000000 => 0.035
    case _ => 0.065
  }
  deposit * interestRate
}

@main def main(args: String*): Unit = {
  val deposit = args.headOption.map(_.toDouble).getOrElse(0.0)
  val interest = calculateInterest(deposit)
  println(s"Interest for deposit of Rs. $deposit is Rs. $interest")
}