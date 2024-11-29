//zadanie 1

case class C(re: Double, im: Double) {
  def this(re: Double) = this(re, 0.0)

  def +(that: C): C = new C(this.re + that.re, this.im + that.im)
  def -(that: C): C = new C(this.re - that.re, this.im - that.im)

  def *(that: C): C = new C(
    this.re * that.re - this.im * that.im,
    this.re * that.im + this.im * that.re
  )
  def +(real: Double): C = new C(this.re + real, this.im)
  def -(real: Double): C = new C(this.re - real, this.im)
  def *(real: Double): C = new C(this.re * real, this.im * real)
 
  // def +(real: Double): C = new C(this.re + real, this.im)
  extension(real: Double) {
    def +(complex: C): C = new C(real+complex.re, complex.im)
    def -(complex: C): C = new C(complex.re - real, complex.im)
    def *(complex: C): C = new C(complex.re * real, complex.im * real)
  }

  def /(that: C): C = {
    val denom = that.re * that.re + that.im * that.im
    if (denom == 0)
      throw new IllegalArgumentException(
        "Dzielenie przez zero jest niedozwolone."
      )
    new C(
      (this.re * that.re + this.im * that.im) / denom,
      (this.im * that.re - this.re * that.im) / denom
    )
  }
  def /(real: Double): C = new C(this.re / real, this.im / real)

  override def toString: String = {
    if (im > 0) s"$re + ${im}i"
    else if (im < 0) s"$re - ${im}i"
    else if (im == 0) s"$re"
    else s"$re - ${-im}i"
  }
}
//zykład użycia
object Complex {
  def main(args: Array[String]): Unit = {
    val z1 = new C(4, 4)
    val z2 = new C(5, 0)
    val z3 = new C(5, 2)
    val z4 = new C(5)
    println(z1)
    println(z2)
    println(z3)
    println(z4)
    println(z1 - 23)
    println(z1 + z2)
    println(89+z1)
    println(z3 / 2)

    println(z3 == z1)
    println(z3 != z1)
    println(z2 + 2)
    // println(z3z1)
    val c = C(1.0, 2.5)
    println(c)
  }
}
