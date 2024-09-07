def countLetterOccurrences(words: List[String]): Int = {
  val lengths = words.map(_.length)
  val totalLength = lengths.reduce(_ + _)
  totalLength
}

// Example usage
@main def main(): Unit = {
  val words = List("apple", "banana", "cherry", "date")
  val totalCount = countLetterOccurrences(words)
  println(s"Total count of letter occurrences: $totalCount")
}