// Advanced Part 3 about a really dumb investment strategy
//==========================================================

object CW6c {


  //two test portfolios

  val blchip_portfolio = List("GOOG", "AAPL", "MSFT", "IBM", "FB", "AMZN", "BIDU")
  val rstate_portfolio = List("PLD", "PSA", "AMT", "AIV", "AVB", "BXP", "CCI", "DLR", "EQIX", "EQR", "ESS", "EXR", "FRT", "GGP", "HCP")


  // (1.a) The function below takes a stock symbol and a year as arguments.
  //       It should read the corresponding CSV-file and read the January
  //       data from the given year. The data should be collected in a list of
  //       strings for each line in the CSV-file.

  import io.Source
  import scala.util._

  def get_january_data(symbol: String, year: Int): List[String] = {

    val content = Source.fromFile(symbol + ".csv").mkString
    val newContent = content.split("\n").toList
    val toReturn = newContent.filter(newContent => newContent.startsWith(year.toString))

    toReturn

  }

  def get_first_price(symbol: String, year: Int): Option[Double] = {

    val jan_data = get_january_data(symbol, year)

    if (jan_data.length < 0) {
      None
    }

    else {
      val first = jan_data.head
      val arr = first.split(",")
      val toReturn = arr(1).toDouble
      Some(toReturn)
    }


  }

  def get_prices(portfolio: List[String], years: Range) : List[List[Option[Double]]] = {


    val toReturn = for (x <- years) yield {

      val hej: List[Option[Double]] = for (y <- portfolio) yield {


        val addTo: Option[Double] = get_first_price(y, x)
        addTo

      }

      hej



    }

    toReturn.toList


  }



  def get_delta(price_old: Option[Double], price_new: Option[Double]) : Option[Double] = {



    if(price_new.isDefined && price_old.isDefined){

      val pn: Double =  price_new.get

      val po: Double = price_old.get

      val toReturn = (pn - po) / po

      Some(toReturn)

    }

    else{
      None
    }


  }

  def get_deltas(data: List[List[Option[Double]]]) :  List[List[Option[Double]]] = {



    val toReturn = for(x <- data) yield {

      val neew = data.indexOf(x)

      val hej =  for(y <- x) yield {

        val neeew = x.indexOf(y)
        val addTo: Option[Double] = get_delta(y, data(neew+1)(neeew))
        addTo

      }

      hej


    }

    toReturn


  }


// (3) Write a function that given change factors, a starting balance and a year
//     calculates the yearly yield, i.e. new balance, according to our dump investment 
//     strategy. Another function calculates given the same data calculates the
//     compound yield up to a given year. Finally a function combines all 
//     calculations by taking a portfolio, a range of years and a start balance
//     as arguments.


//def yearly_yield(data: List[List[Option[Double]]], balance: Long, year: Int) : Long = ... 

//def compound_yield(data: List[List[Option[Double]]], balance: Long, year: Int) : Long = ... 

//def investment(portfolio: List[String], years: Range, start_balance: Long) : Long = ...



//test cases for the two portfolios given above

//investment(rstate_portfolio, 1978 to 2017, 100)
//investment(blchip_portfolio, 1978 to 2017, 100)

}
