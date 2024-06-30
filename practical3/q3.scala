def mean(num1: Int, num2: Int): Double = BigDecimal((num1 + num2) / 2.0).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble

def main(args: Array[String]): Unit = 
    val num1 = 10
    val num2 = 20
    println(s"The mean of $num1 and $num2 is: ${mean(num1, num2)}")

