import java.awt.List
import java.util
// Part 1 about the 3n+1 conjecture
//=================================

object CW6a {


  def collatz(n: Long): Long = {

    if (n==1) {
      1 }

    else {
      if (n % 2 == 0) {
        collatz(n / 2) + 1
      }
      else {
        collatz(n * 3 + 1) + 1

      }
    }
  }


/*


  def collatz_max(bnd: Long) : (Long, Long) = {

    val hej = bnd.toInt

    val listOfCollatz = (1 to hej).toList.map(i => collatz(i))

    val maxValue = listOfCollatz.max

    (maxValue, listOfCollatz.indexOf(maxValue) + 1)
  }
*/

  }






