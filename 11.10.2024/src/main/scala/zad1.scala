//BEZ petli oraz zmiennych [var??]

//rekurencyjna funckaj reverse(str: StrRing): String, ktora zwroci odwrocony napis jako argument
def main(args: Array[String]): Unit = {
ReverseString
PalindormCheck
formTriangle
dasizm
}
object ReverseString {
  def reverse(str: String): String = {
    if (str.isEmpty) ""
    else reverse(str.tail) + str.head
  }

  val napis = "losowy napis czesc"
  val res = reverse(napis)
  println(res)
}
object PalindormCheck {
  
  def palindome(tab: Array[Int]): Boolean = {
    if (tab.length <= 1) true
    else {
      if (tab.head == tab.last) {
        palindome(tab.slice(1, tab.size - 1))
      } else {
        false
      }
    }

  }

  val tab = Array(1, 2, 3, 4, 5)
  val tab2 = Array(1, 2, 3, 2, 1)

  val res = palindome(tab2)
  print(tab2.mkString)
  println(s" is this palindrome $res")
}




object formTriangle {
  def pascalValue(row: Int, col: Int): Int = {
    if (col == 0 || col == row) {
      1
    } else {
      pascalValue(row - 1, col - 1) + pascalValue(row - 1, col)
    }
  }

  def triangle(wys: Int): Unit = {
    for (row <- 0 until wys) {
      print(" " * (wys - row - 1) * 2)
      for (col <- 0 to row) {
        print(f"${pascalValue(row, col)}%4d") 
      }
      println() 
    }
  }
    val wys = 8  
    triangle(wys)
  }

object dasizm{
def isPrime(num: Int, divisor: Int = 2): Boolean = {
  if (num <= 1) {
    false
  } else if (divisor > math.sqrt(num)) {
    true 
  } else if (num % divisor == 0) {
    false 
    isPrime(num, divisor + 1) 
  }
}

 // def daSie(n: Int): Boolean ={


 val n=10
 isPrime(n)
 // if(n>=0){}

}