def calculateSquare(numbers: List[Int]): List[Int] = {
    numbers.map(number => number * number)
}

@main def main(): Unit = {
    val input = List(1, 2, 3, 4, 5)
    val output = calculateSquare(input)
    println(output)
}
