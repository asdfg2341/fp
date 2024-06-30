def easy(distance: Double) = distance * 8
def tempo(distance: Double) = distance * 7

@main def main() = println(easy(2) + tempo(3) + easy(2))