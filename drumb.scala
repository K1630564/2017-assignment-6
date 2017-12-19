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



    val toReturn = for(x <- (0 until data.size-1).toList) yield {

      val temp =  for(y <- (0 until data.head.size).toList) yield {

        val addTo: Option[Double] = get_delta(data(x)(y), data(x+1)(y)  )
        addTo

      }
      temp


    }

    toReturn

  }

  def yearly_yield(data: List[List[Option[Double]]], balance: Long, year: Int) : Long ={


    val nrCompanies = data.head.size
    val perCompany = balance / nrCompanies

    if(data(year).nonEmpty){

      val toReturn = for(x <- (0 until data(year).size).toArray) yield{

        perCompany * data(year)(x).get



      }

      toReturn.sum.toLong + balance

    }
    else{
      balance
    }
  }



  def compound_yield(data: List[List[Option[Double]]], balance: Long, year: Int) : Long = {

    balance + yearly_yield(data, balance, year)
  }

  def investment(portfolio: List[String], years: Range, start_balance: Long) : Long = {

    val prices = get_prices(portfolio, years)
    val deltasPrices = get_deltas(prices)

    val toReturn = for(x <- (0 until deltasPrices.size).toArray) yield {

      compound_yield(deltasPrices, compound_yield(deltasPrices, start_balance, x), x)
    }

    toReturn.last

  }

}
