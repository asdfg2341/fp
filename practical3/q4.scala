def sumOfEvens(nums: List[Int]): Int = nums.filter(_ % 2 == 0).sum  // nums.filter(num => num % 2 == 0)

@main def main() =
  println(sumOfEvens(List(1)))
