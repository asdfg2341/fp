def salary(work_hours: Int, ot_hours: Int): Int = {
    val wage = 250
    val ot_wage = 85
    val salary = (work_hours * wage) + (ot_hours * ot_wage)
    return salary
}

def salary_after_tax(salary: Double): Double = {
    val tax = 0.12
    return salary * (1 - tax)
}

@main def main() = 
    val work_hours = 40
    val ot_hours = 30
    println("Weekly Salary: " + salary_after_tax(salary(work_hours, ot_hours)))