/* Problem 5 -- Weather Station*/

object WeatherStation extends App {
 
  trait IThermometer
  {
   // = avg degrees Farenheit
   def getMeanTemperature(cities: List[String]): Double
  }
  
  //adaptee
  class CelsiusTherm 
  {
   // = degrees Celsius 
   def computeTemp(city: String): Double = 50 * math.random // fake temperature for now
  }
  
  //adapter 
  object ThermAdapter extends IThermometer 
  {
    override
    def getMeanTemperature(cities: List[String]): Double = 
    {
      val ct = new CelsiusTherm
      ((cities.map(ct.computeTemp)).map(toFahrenheit)).reduce(_+_) / cities.length
    }
    
    def toFahrenheit(temp: Double): Double = 
    {
      (temp * 1.8) + 32 
    }
  }
  
  val thermometer: IThermometer = ThermAdapter
  val avgTemp = thermometer.getMeanTemperature(List("LA", "SF", "SLC", "Rio"))
  println("avg temp = " + avgTemp)
  
  /*
   * Output 
   * avg temp = 86.58602232449421
   */
}

