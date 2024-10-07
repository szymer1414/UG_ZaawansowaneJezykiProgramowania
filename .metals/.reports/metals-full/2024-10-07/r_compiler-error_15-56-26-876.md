file:///C:/Users/Dell/Desktop/studiasuperzabawa/inf/UG_ZaawansowaneJezykiProgramowania/04.10.2024/src/main/scala/zad1.scala
### dotty.tools.dotc.core.TypeError$$anon$1: Toplevel definition mainProg is defined in
  C:/Users/Dell/Desktop/studiasuperzabawa/inf/UG_ZaawansowaneJezykiProgramowania/04.10.2024/src/main/scala/Main.scala
and also in
  C:/Users/Dell/Desktop/studiasuperzabawa/inf/UG_ZaawansowaneJezykiProgramowania/04.10.2024/src/main/scala/zad1.scala
One of these files should be removed from the classpath.

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.3\scala3-library_3-3.3.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.12\scala-library-2.13.12.jar [exists ]
Options:



action parameters:
offset: 780
uri: file:///C:/Users/Dell/Desktop/studiasuperzabawa/inf/UG_ZaawansowaneJezykiProgramowania/04.10.2024/src/main/scala/zad1.scala
text:
```scala
import scala.util.control.Breaks.{break, breakable}

object PrimeNumbers {
  def isPrime(num: Int): Boolean = {
    if (num <= 1) false
    else {
      var isPrime = true
      breakable {
        for (i <- 2 to math.sqrt(num).toInt) {
          if (num % i == 0) {
            isPrime = false
            break()  // Exit the loop when a divisor is found
          }
        }
      }
      isPrime
    }
  }

  def getPrimesInRange(n: Int): List[Int] = {
    (2 to n).filter(isPrime).toList
  }

  def main(args: Array[String]): Unit = {
    var n = 0
    do {
      print("Enter an even value for n: ")
      n = scala.io.StdIn.readInt()
      if (n % 2 != 0) {
        println("The number must be even. Please try again.")
      }
    } while (@@n % 2 != 0)  // Continue until the user enters an even number
    
    println(s"Prime numbers in the range 0 to $n: " + getPrimesInRange(n))
  }
}

```



#### Error stacktrace:

```

```
#### Short summary: 

dotty.tools.dotc.core.TypeError$$anon$1: Toplevel definition mainProg is defined in
  C:/Users/Dell/Desktop/studiasuperzabawa/inf/UG_ZaawansowaneJezykiProgramowania/04.10.2024/src/main/scala/Main.scala
and also in
  C:/Users/Dell/Desktop/studiasuperzabawa/inf/UG_ZaawansowaneJezykiProgramowania/04.10.2024/src/main/scala/zad1.scala
One of these files should be removed from the classpath.