object Main {
  def main(args: Array[String]): Unit = {
    ReverseString
    PalindromCheck
    FormTriangle
    PrimeSumChecker
  }
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

object PalindromCheck {
  def palindrom(tab: Array[Int]): Boolean = {
    if (tab.length <= 1) true
    else {
      if (tab.head == tab.last) {
        palindrom(tab.slice(1, tab.size - 1))
      } else {
        false
      }
    }
  }

  val tab = Array(1, 2, 3, 4, 5)
  val tab2 = Array(1, 2, 3, 2, 1)
  val res = palindrom(tab2)
  print(tab2.mkString)
  println(s" is this palindrome $res")
}

object FormTriangle {
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

  val wys = 5
  triangle(wys)
}

object PrimeSumChecker {
  def isPrime(num: Int, divisor: Int = 2): Boolean = {
    if (num <= 1) {
      false
    } else if (divisor > math.sqrt(num)) {
      true
    } else if (num % divisor == 0) {
      false
    } else {
      isPrime(num, divisor + 1)
    }
  }

  def findPrimesLessThan(n: Int, current: Int = 2, primes: List[Int] = List()): List[Int] = {
    if (current >= n) {
      primes.reverse
    } else {
      if (isPrime(current)) {
        findPrimesLessThan(n, current + 1, current :: primes)
      } else {
        findPrimesLessThan(n, current + 1, primes)
      }
    }
  }

  def findPrimePairs(even: Int, primes: List[Int], pairs: List[(Int, Int)] = List()): List[(Int, Int)] = {
    if (primes.isEmpty) {
      pairs
    } else {
      val p1 = primes.head
      val p2 = even - p1
      if (p2 >= 2 && primes.contains(p2) && !(pairs.contains((p2, p1)))) {
        findPrimePairs(even, primes.tail, (p1, p2) :: pairs)
      } else {
        findPrimePairs(even, primes.tail, pairs)
      }
    }
  }

  def checkEvenNumbersLessThan(n: Int, even: Int = 4): Unit = {
    if (even >= n) return
    val primes = findPrimesLessThan(n)
    val primePairs = findPrimePairs(even, primes)
    if (primePairs.nonEmpty) {
      println(s"$even can be expressed as the sum of the following prime pairs:")
      primePairs.foreach { case (p1, p2) => println(s"$p1 + $p2 = $even") }
    } else {
      println(s"$even cannot be expressed as the sum of two primes.")
    }
    checkEvenNumbersLessThan(n, even + 2)
  }

  val n = 17
  checkEvenNumbersLessThan(n)
}
