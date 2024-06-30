def attendanceForPrice(price: Int): Int = 120 + (15 - price) / 5 * 20

def cost(attendance: Int): Double = 500 + 3 * attendance

def profit(price: Int): Double = attendanceForPrice(price) * price - cost(attendanceForPrice(price))

@main def main() = 
    println(profit(30))