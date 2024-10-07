
import scala.util.control.Breaks.{break, breakable}

object PrimeNumbers {
  def isPrime(num: Int): Boolean = {
    var isPrime = true
    breakable {
      for (i <- 2 to math.sqrt(num).toInt) {
        if (num % i == 0) {
          isPrime = false
          break()  
        }
      }
    }
    isPrime
  }

  def getPrimesInRange(n: Int): List[Int] = {
    (3 to n).filter(isPrime).toList
  }

  def findPrimeSumCombination(primeList: List[Int], n: Int): List[(Int, Int)] = {
    var result = List[(Int, Int)]()

    for (i <- primeList.indices if primeList(i) <= n / 2) {
      breakable {
        for (j <- primeList.indices.reverse if primeList(j) > primeList(i)) {
          if (primeList(i) + primeList(j) == n) {
            result = result :+ (primeList(i), primeList(j))  
            break()  // Break once we find a valid pair
          }
        }
      }
    }
    
    result
  }

  def main(args: Array[String]): Unit = {
    var n = 0
    var isEven = false
    

    while (!isEven) {
      print("Enter an even value for n: ")
      n = scala.io.StdIn.readInt()
      if (n % 2 == 0) {
        isEven = true
      } else {
        println("The number must be even. Please try again.")
      }
    }

    val primeList = getPrimesInRange(n)
    println(s"Prime numbers in the range 3 to $n: $primeList")

    val primeSumCombinations = findPrimeSumCombination(primeList, n)
    
    if (primeSumCombinations.nonEmpty) {
      println(s"Prime pairs that add up to $n:")
      primeSumCombinations.foreach { case (a, b) => println(s"$a + $b = $n") }
    } else {
      println(s"No prime pairs add up to $n")
    }
  }
}

