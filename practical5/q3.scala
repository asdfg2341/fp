@main def main() = {
    printFibonacci(10)
    printFibonacci(5)
}

def printFibonacci(n: Int, a: Int = 0, b: Int = 1): Unit = {
  if (n > 0) {
    println(a)
    printFibonacci(n - 1, b, a + b)
  }
}