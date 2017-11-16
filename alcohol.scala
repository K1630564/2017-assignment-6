// Part 2 about Alcohol-Consumption Worldwide
//============================================

object CW6b {

import io.Source
import scala.util._

val url_alcohol = 
  "https://raw.githubusercontent.com/fivethirtyeight/data/master/alcohol-consumption/drinks.csv"

val file_population = 
  "population.csv"


  val b:String = "country,beer_servings,spirit_servings,wine_servings,total_litres_of_pure_alcohol\nAfghanistan,0,0,0,0.0\nAlbania,89,132,54,4.9\nAlgeria,25,0,14,0.7\nAndorra,245,138,312,12.4\nAngola,217,57,45,5.9\nAntigua & Barbuda,102,128,45,4.9\nArgentina,193,25,221,8.3\nArmenia,21,179,11,3.8\nAustralia,261,72,212,10.4\nAustria,279,75,191,9.7\nAzerbaijan,21,46,5,1.3\nBahamas,122,176,51,6.3\nBahrain,42,63,7,2.0\nBangladesh,0,0,0,0.0\nBarbados,143,173,36,6.3\nBelarus,142,373,42,14.4\nBelgium,295,84,212,10.5\nBelize,263,114,8,6.8\nBenin,34,4,13,1.1\nBhutan,23,0,0,0.4\nBolivia,167,41,8,3.8\nBosnia-Herzegovina,76,173,8,4.6\nBotswana,173,35,35,5.4\nBrazil,245,145,16,7.2\nBrunei,31,2,1,0.6\nBulgaria,231,252,94,10.3\nBurkina Faso,25,7,7,4.3\nBurundi,88,0,0,6.3\nCote d'Ivoire,37,1,7,4.0\nCabo Verde,144,56,16,4.0\nCambodia,57,65,1,2.2\nCameroon,147,1,4,5.8\nCanada,240,122,100,8.2\nCentral African Republic,17,2,1,1.8\nChad,15,1,1,0.4\nChile,130,124,172,7.6\nChina,79,192,8,5.0\nColombia,159,76,3,4.2\nComoros,1,3,1,0.1\nCongo,76,1,9,1.7\nCook Islands,0,254,74,5.9\nCosta Rica,149,87,11,4.4\nCroatia,230,87,254,10.2\nCuba,93,137,5,4.2\nCyprus,192,154,113,8.2\nCzech Republic,361,170,134,11.8\nNorth Korea,0,0,0,0.0\nDR Congo,32,3,1,2.3\nDenmark,224,81,278,10.4\nDjibouti,15,44,3,1.1\nDominica,52,286,26,6.6\nDominican Republic,193,147,9,6.2\nEcuador,162,74,3,4.2\nEgypt,6,4,1,0.2\nEl Salvador,52,69,2,2.2\nEquatorial Guinea,92,0,233,5.8\nEritrea,18,0,0,0.5\nEstonia,224,194,59,9.5\nEthiopia,20,3,0,0.7\nFiji,77,35,1,2.0\nFinland,263,133,97,10.0\nFrance,127,151,370,11.8\nGabon,347,98,59,8.9\nGambia,8,0,1,2.4\nGeorgia,52,100,149,5.4\nGermany,346,117,175,11.3\nGhana,31,3,10,1.8\nGreece,133,112,218,8.3\nGrenada,199,438,28,11.9\nGuatemala,53,69,2,2.2\nGuinea,9,0,2,0.2\nGuinea-Bissau,28,31,21,2.5\nGuyana,93,302,1,7.1\nHaiti,1,326,1,5.9\nHonduras,69,98,2,3.0\nHungary,234,215,185,11.3\nIceland,233,61,78,6.6\nIndia,9,114,0,2.2\nIndonesia,5,1,0,0.1\nIran,0,0,0,0.0\nIraq,9,3,0,0.2\nIreland,313,118,165,11.4\nIsrael,63,69,9,2.5\nItaly,85,42,237,6.5\nJamaica,82,97,9,3.4\nJapan,77,202,16,7.0\nJordan,6,21,1,0.5\nKazakhstan,124,246,12,6.8\nKenya,58,22,2,1.8\nKiribati,21,34,1,1.0\nKuwait,0,0,0,0.0\nKyrgyzstan,31,97,6,2.4\nLaos,62,0,123,6.2\nLatvia,281,216,62,10.5\nLebanon,20,55,31,1.9\nLesotho,82,29,0,2.8\nLiberia,19,152,2,3.1\nLibya,0,0,0,0.0\nLithuania,343,244,56,12.9\nLuxembourg,236,133,271,11.4\nMadagascar,26,15,4,0.8\nMalawi,8,11,1,1.5\nMalaysia,13,4,0,0.3\nMaldives,0,0,0,0.0\nMali,5,1,1,0.6\nMalta,149,100,120,6.6\nMarshall Islands,0,0,0,0.0\nMauritania,0,0,0,0.0\nMauritius,98,31,18,2.6\nMexico,238,68,5,5.5\nMicronesia,62,50,18,2.3\nMonaco,0,0,0,0.0\nMongolia,77,189,8,4.9\nMontenegro,31,114,128,4.9\nMorocco,12,6,10,0.5\nMozambique,47,18,5,1.3\nMyanmar,5,1,0,0.1\nNamibia,376,3,1,6.8\nNauru,49,0,8,1.0\nNepal,5,6,0,0.2\nNetherlands,251,88,190,9.4\nNew Zealand,203,79,175,9.3\nNicaragua,78,118,1,3.5\nNiger,3,2,1,0.1\nNigeria,42,5,2,9.1\nNiue,188,200,7,7.0\nNorway,169,71,129,6.7\nOman,22,16,1,0.7\nPakistan,0,0,0,0.0\nPalau,306,63,23,6.9\nPanama,285,104,18,7.2\nPapua New Guinea,44,39,1,1.5\nParaguay,213,117,74,7.3\nPeru,163,160,21,6.1\nPhilippines,71,186,1,4.6\nPoland,343,215,56,10.9\nPortugal,194,67,339,11.0\nQatar,1,42,7,0.9\nSouth Korea,140,16,9,9.8\nMoldova,109,226,18,6.3\nRomania,297,122,167,10.4\nRussian Federation,247,326,73,11.5\nRwanda,43,2,0,6.8\nSt. Kitts & Nevis,194,205,32,7.7\nSt. Lucia,171,315,71,10.1\nSt. Vincent & the Grenadines,120,221,11,6.3\nSamoa,105,18,24,2.6\nSan Marino,0,0,0,0.0\nSao Tome & Principe,56,38,140,4.2\nSaudi Arabia,0,5,0,0.1\nSenegal,9,1,7,0.3\nSerbia,283,131,127,9.6\nSeychelles,157,25,51,4.1\nSierra Leone,25,3,2,6.7\nSingapore,60,12,11,1.5\nSlovakia,196,293,116,11.4\nSlovenia,270,51,276,10.6\nSolomon Islands,56,11,1,1.2\nSomalia,0,0,0,0.0\nSouth Africa,225,76,81,8.2\nSpain,284,157,112,10.0\nSri Lanka,16,104,0,2.2\nSudan,8,13,0,1.7\nSuriname,128,178,7,5.6\nSwaziland,90,2,2,4.7\nSweden,152,60,186,7.2\nSwitzerland,185,100,280,10.2\nSyria,5,35,16,1.0\nTajikistan,2,15,0,0.3\nThailand,99,258,1,6.4\nMacedonia,106,27,86,3.9\nTimor-Leste,1,1,4,0.1\nTogo,36,2,19,1.3\nTonga,36,21,5,1.1\nTrinidad & Tobago,197,156,7,6.4\nTunisia,51,3,20,1.3\nTurkey,51,22,7,1.4\nTurkmenistan,19,71,32,2.2\nTuvalu,6,41,9,1.0\nUganda,45,9,0,8.3\nUkraine,206,237,45,8.9\nUnited Arab Emirates,16,135,5,2.8\nUnited Kingdom,219,126,195,10.4\nTanzania,36,6,1,5.7\nUSA,249,158,84,8.7\nUruguay,115,35,220,6.6\nUzbekistan,25,101,8,2.4\nVanuatu,21,18,11,0.9\nVenezuela,333,100,3,7.7\nVietnam,111,2,1,2.0\nYemen,6,0,0,0.1\nZambia,32,19,4,2.5\nZimbabwe,64,18,4,4.7"


def get_csv_page(url: String) : List[String] = {

  val content = scala.io.Source.fromURL(url).mkString
  content.split("\n").toList



}




def get_csv_file(file: String) : List[String] = {


  val content = scala.io.Source.fromFile(file).mkString
  content.split("\n").toList

}



//(2) Complete the functions that process the csv-lists. For
//    process_alcs extract the country name (as String) and the 
//    pure alcohol consumption (as Double). For process_pops
//    generate a Map of Strings (country names) to Long numbers 
//    (population sizes). 

  /*
def process_alcs(lines: List[String]) : List[(String, Double)] = {

  val theList = get_csv_page("https://raw.githubusercontent.com/fivethirtyeight/data/master/alcohol-consumption/drinks.csv")

  for(i <- 1 to theList)


}
*/

//def process_pops(lines: List[String]) : Map[String, Long] = ...



//(3) Calculate for each country the overall alcohol_consumption using
//    the data from the alcohol list and the population sizes list. You
//    should only include countries on the alcohol list that are also
//    on the population sizes list with the exact same name. Note that
//    the spelling of some names in the alcohol list differs from the
//    population sizes list. You can ignore entries where the names differ. 
//    Sort the resulting list according to the country with the highest alcohol 
//    consumption to the country with the lowest alcohol consumption.

//def sorted_country_consumption() : List[(String, Long)] = ...


//   Calculate the world consumption of pure alcohol of all countries, which 
//   should be the first element in the tuple below. The second element is
//   the overall consumption of the first n countries in the sorted list
//   from above; and finally the double should be the percentage of the 
//   first n countries drinking from the the world consumption of alcohol.          

//def percentage(n: Int) : (Long, Long, Double) = ...

}
