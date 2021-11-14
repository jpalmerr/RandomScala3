extension (x: Int) {
  def pow(exponent: Int) = Math.pow(x, exponent).round
  def sqrt() = Math.sqrt(x)
}

2.pow(4)
4.sqrt()