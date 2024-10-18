import scala.annotation.tailrec
object Main {
  def main(args: Array[String]): Unit = {
    ReverseString
    // PalindromCheck
    PrimeNr
    Bit
    Fibbo
    Sorting
  }
}

object ReverseString {

  def reverse(str: String): String = {
    @tailrec
    def helper(str: String, acc: String): String = {
      if (str == "") acc
      else helper(str.tail, str.head +: acc)
    }
    helper(str, "")
  }
  println(reverse("czesc"))

}
//zad2
object PrimeNr {
  def isPrime(num: Int): Boolean = {
    @tailrec
    def helper(num: Int, acc: Int = 2): Boolean = {
      if (num <= 1) {
        false
      } else if (acc > math.sqrt(num)) {
        true
      } else if (num % acc == 0) {
        false
      } else {
        helper(num, acc + 1)
      }
    }
    helper(num)
  }
  println(isPrime(19))
//zadanie 3
}
object Bit {
  def binToDec(bin: Int): Int = {
    @tailrec
    def helper(bin: Int, acc: Int = 1, result: Int = 0): Int = {
      if (bin == 0) result
      else {
        if (bin % 10 == 1) {
          helper(bin / 10, acc * 2, result + acc)
        } else {
          helper(bin / 10, acc * 2, result)
        }
      }
    }
    helper(bin)
  }
  println(binToDec(110011))
}
//zad4
object Fibbo {
  def value(n: Int): Int = {
    @tailrec
    def helper(n: Int, a: Int = 1, b: Int = 2): Int = {
      if (n == 0) b
      else if (n == 1) a
      else helper(n - 1, a + b, a)
    }
    helper(n)
  }
  println(value(5))
}
//zadanie 5
object Sorting {
  def isOrdered(tab: Array[Int], mlr: (Int, Int) => Boolean): Boolean = {
    @tailrec
    def helper(index: Int): Boolean = {
      if (index >= tab.length - 1) true 
      else if (!mlr(tab(index), tab(index + 1))) false 
      else helper(index + 1)
    }
    if (tab.isEmpty || tab.length == 1) true
    else helper(0)
  }

  println(isOrdered(Array(1, 3, 3, 6, 8), (_>=_)))
}
