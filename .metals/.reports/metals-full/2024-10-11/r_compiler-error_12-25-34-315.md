file:///C:/Users/Dell/Desktop/studiasuperzabawa/inf/UG_ZaawansowaneJezykiProgramowania/11.10.2024/src/main/scala/zad1.scala
### java.lang.AssertionError: assertion failed

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.3\scala3-library_3-3.3.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.12\scala-library-2.13.12.jar [exists ]
Options:



action parameters:
uri: file:///C:/Users/Dell/Desktop/studiasuperzabawa/inf/UG_ZaawansowaneJezykiProgramowania/11.10.2024/src/main/scala/zad1.scala
text:
```scala
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
      false // Liczby mniejsze lub równe 1 nie są pierwsze
    } else if (divisor > math.sqrt(num)) {
      true // Jeśli przekroczymy pierwiastek z liczby, liczba jest pierwsza
    } else if (num % divisor == 0) {
      false // Jeśli liczba jest podzielna przez dzielnik, nie jest pierwsza
    } else {
      isPrime(num, divisor + 1) // Rekurencyjnie sprawdzamy kolejnego dzielnika
    }
  }
/*
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


 */

 // def daSie(n: Int): Boolean ={
    val n=11
    val res=isPrime(n)
  def



    println(s" is thi prime $res")
 // if(n>=0){}

}
```



#### Error stacktrace:

```
scala.runtime.Scala3RunTime$.assertFailed(Scala3RunTime.scala:11)
	dotty.tools.dotc.parsing.Scanners$Scanner.lookahead(Scanners.scala:1083)
	dotty.tools.dotc.parsing.Parsers$Parser.termParamClause$$anonfun$1(Parsers.scala:3329)
	dotty.tools.dotc.parsing.Parsers$Parser.enclosed(Parsers.scala:556)
	dotty.tools.dotc.parsing.Parsers$Parser.inParens(Parsers.scala:558)
	dotty.tools.dotc.parsing.Parsers$Parser.termParamClause(Parsers.scala:3345)
	dotty.tools.dotc.parsing.Parsers$Parser.recur$6(Parsers.scala:3369)
	dotty.tools.dotc.parsing.Parsers$Parser.termParamClauses(Parsers.scala:3377)
	dotty.tools.dotc.parsing.Parsers$Parser.defDefOrDcl(Parsers.scala:3666)
	dotty.tools.dotc.parsing.Parsers$Parser.defOrDcl(Parsers.scala:3557)
	dotty.tools.dotc.parsing.Parsers$Parser.templateStatSeq$$anonfun$1(Parsers.scala:4222)
	dotty.tools.dotc.parsing.Parsers$Parser.checkNoEscapingPlaceholders(Parsers.scala:500)
	dotty.tools.dotc.parsing.Parsers$Parser.templateStatSeq(Parsers.scala:4230)
	dotty.tools.dotc.parsing.Parsers$Parser.$anonfun$39(Parsers.scala:4105)
	dotty.tools.dotc.parsing.Parsers$Parser.enclosed(Parsers.scala:556)
	dotty.tools.dotc.parsing.Parsers$Parser.inBraces(Parsers.scala:559)
	dotty.tools.dotc.parsing.Parsers$Parser.inBracesOrIndented(Parsers.scala:570)
	dotty.tools.dotc.parsing.Parsers$Parser.inDefScopeBraces(Parsers.scala:573)
	dotty.tools.dotc.parsing.Parsers$Parser.templateBody(Parsers.scala:4105)
	dotty.tools.dotc.parsing.Parsers$Parser.templateBodyOpt(Parsers.scala:4098)
	dotty.tools.dotc.parsing.Parsers$Parser.template(Parsers.scala:4075)
	dotty.tools.dotc.parsing.Parsers$Parser.templateOpt(Parsers.scala:4087)
	dotty.tools.dotc.parsing.Parsers$Parser.objectDef(Parsers.scala:3827)
	dotty.tools.dotc.parsing.Parsers$Parser.tmplDef(Parsers.scala:3781)
	dotty.tools.dotc.parsing.Parsers$Parser.defOrDcl(Parsers.scala:3563)
	dotty.tools.dotc.parsing.Parsers$Parser.topStatSeq(Parsers.scala:4162)
	dotty.tools.dotc.parsing.Parsers$Parser.topstats$1(Parsers.scala:4346)
	dotty.tools.dotc.parsing.Parsers$Parser.compilationUnit$$anonfun$1(Parsers.scala:4351)
	dotty.tools.dotc.parsing.Parsers$Parser.checkNoEscapingPlaceholders(Parsers.scala:500)
	dotty.tools.dotc.parsing.Parsers$Parser.compilationUnit(Parsers.scala:4356)
	dotty.tools.dotc.parsing.Parsers$Parser.parse(Parsers.scala:181)
	dotty.tools.dotc.parsing.Parser.parse$$anonfun$1(ParserPhase.scala:32)
	dotty.tools.dotc.parsing.Parser.parse$$anonfun$adapted$1(ParserPhase.scala:40)
	scala.Function0.apply$mcV$sp(Function0.scala:42)
	dotty.tools.dotc.core.Phases$Phase.monitor(Phases.scala:440)
	dotty.tools.dotc.parsing.Parser.parse(ParserPhase.scala:40)
	dotty.tools.dotc.parsing.Parser.runOn$$anonfun$1(ParserPhase.scala:49)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.immutable.List.foreach(List.scala:333)
	dotty.tools.dotc.parsing.Parser.runOn(ParserPhase.scala:49)
	dotty.tools.dotc.Run.runPhases$1$$anonfun$1(Run.scala:246)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.ArrayOps$.foreach$extension(ArrayOps.scala:1323)
	dotty.tools.dotc.Run.runPhases$1(Run.scala:262)
	dotty.tools.dotc.Run.compileUnits$$anonfun$1(Run.scala:270)
	dotty.tools.dotc.Run.compileUnits$$anonfun$adapted$1(Run.scala:279)
	dotty.tools.dotc.util.Stats$.maybeMonitored(Stats.scala:71)
	dotty.tools.dotc.Run.compileUnits(Run.scala:279)
	dotty.tools.dotc.Run.compileSources(Run.scala:194)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:165)
	scala.meta.internal.pc.MetalsDriver.run(MetalsDriver.scala:45)
	scala.meta.internal.pc.WithCompilationUnit.<init>(WithCompilationUnit.scala:28)
	scala.meta.internal.pc.SimpleCollector.<init>(PcCollector.scala:373)
	scala.meta.internal.pc.PcSemanticTokensProvider$Collector$.<init>(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector$lzyINIT1(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.provide(PcSemanticTokensProvider.scala:90)
	scala.meta.internal.pc.ScalaPresentationCompiler.semanticTokens$$anonfun$1(ScalaPresentationCompiler.scala:117)
```
#### Short summary: 

java.lang.AssertionError: assertion failed