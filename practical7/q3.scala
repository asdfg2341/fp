def filterPrimes(input: List[Int]): List[Int] = {
    input.filter(value => isPrime(value))
}

def divisibleBy(dividend: Int, divisor: Int): Boolean = dividend % divisor == 0

def isPrime(value: Int): Boolean = {
  if (value <= 1) false
  else (2 until value).forall(i => !divisibleBy(value, i))
}

@main def main() = {
    val input = List(1, 2, 3, 4, 5)
    val output = filterPrimes(input)
    println(output)
}