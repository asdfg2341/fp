import math.max

def price(numCopies: Int): Double = numCopies * 24.95

def discountePrice(price: Double): Double = price / 100 * (100 - 40)

//  Rs. 3 for the first 50 copies and 75 cents for each additional copy.
def shippingCost(numCopies: Int): Double = 3 + max((numCopies - 50), 0) * 0.75


@main def main() = 
    val numCopies = 60
    println(discountePrice(price(numCopies)) + shippingCost(numCopies))