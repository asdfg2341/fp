import scala.io.StdIn.readLine

def validateInput(name: String, marks: Int, totalMarks: Int): (Boolean, Option[String]) = {
  if (name.isEmpty) {
    (false, Some("Name cannot be empty"))
  } else if (marks < 0 || totalMarks < 0) {
    (false, Some("Marks and total marks must be positive integers"))
  } else if (marks > totalMarks) {
    (false, Some("Marks cannot exceed total possible marks"))
  } else {
    (true, None)
  }
}

def getStudentInfo(): (String, Int, Int, Double, Char) = {
  val name = readLine("Enter student's name: ")
  val marks = readLine("Enter student's marks: ").toInt
  val totalMarks = readLine("Enter total possible marks: ").toInt

  val percentage = (marks.toDouble / totalMarks) * 100
  val grade = percentage match {
    case p if p >= 90 => 'A'
    case p if p >= 75 => 'B'
    case p if p >= 50 => 'C'
    case _            => 'D'
  }

  (name, marks, totalMarks, percentage, grade)
}

def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
  var isValid = false
  var name = ""
  var marks = 0
  var totalMarks = 0

  while (!isValid) {
    val tempName = readLine("Enter student's name: ")
    val tempMarks = readLine("Enter student's marks: ").toIntOption.getOrElse(-1)
    val tempTotalMarks = readLine("Enter total possible marks: ").toIntOption.getOrElse(-1)

    val (valid, errorMessage) = validateInput(tempName, tempMarks, tempTotalMarks)
    if (valid) {
      isValid = true
      name = tempName
      marks = tempMarks
      totalMarks = tempTotalMarks
    } else {
      println(s"Invalid input: ${errorMessage.getOrElse("Unknown error")}")
    }
  }

  val percentage = (marks.toDouble / totalMarks) * 100
  val grade = percentage match {
    case p if p >= 90 => 'A'
    case p if p >= 75 => 'B'
    case p if p >= 50 => 'C'
    case _            => 'D'
  }

  (name, marks, totalMarks, percentage, grade)
}

def printStudentRecord(student: (String, Int, Int, Double, Char)): Unit = {
  val (name, marks, totalMarks, percentage, grade) = student
  println(s"Student Name: $name")
  println(s"Marks: $marks / $totalMarks")
  println(f"Percentage: $percentage%.2f%%")
  println(s"Grade: $grade")
}

@main def runStudentRecordSystem(): Unit = {
  val student = getStudentInfoWithRetry()
  printStudentRecord(student)
}
