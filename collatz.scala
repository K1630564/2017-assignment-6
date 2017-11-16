import java.awt.List
import java.util
// Part 1 about the 3n+1 conjecture
//=================================

object CW6a {


  def collatz(n: Long): Long = {
    val count=1

    if (n==1) {
      count }

    else if (n%2==1) {
      val count2 =collatz(n*3+1)+1
      count2
    }
    else {
      val count3=collatz(n/2) +1
      count3
    }
  }





  def collatz_max(bnd: Long) : (Long, Long) = {

    val hej = bnd.toInt

    val listOfCollatz = (1 to hej).toList.map(i => collatz(i))

    val maxValue = listOfCollatz.max

    (maxValue, listOfCollatz.indexOf(maxValue) + 1)
  }

  }






