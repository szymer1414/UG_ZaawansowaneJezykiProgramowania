@main
def zad1: Unit = {
  def Niemalejace(liczba: String): Boolean = {
    liczba.sliding(2).forall { pair => pair(0) <= pair(1) 
    }
  }
  def Przysta(liczba: String): Boolean = {
    liczba.map(_.asDigit).sum % 2 != 0
  }

  val linie = io.Source.fromResource("liczby.txt").getLines.toList
  println(linie.filter(liczba => Niemalejace(liczba) && Przysta(liczba)))
}