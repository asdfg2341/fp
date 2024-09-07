class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator must be nonzero")

  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1)

  def neg: Rational = new Rational(-numer, denom)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  override def toString: String = s"$numer/$denom"
}

@main def main() = {
    val x = new Rational(1, 2)
    val negX = x.neg // evaluates to -1/2
    println(negX)
}