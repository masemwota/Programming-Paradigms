import scala.math._

object math {
  println("Welcome to the Scala worksheet")
  
  //Problem 1
  def solve(a: Double, b: Double, c: Double): Option[(Double, Double)] =
  {
  			var x1 = ((-b) + Math.sqrt(Math.pow(b, 2) - (4* a * c)))/ (2 * a)
  			var x2 = ((-b) - Math.sqrt(Math.pow(b, 2) - (4* a * c)))/ (2 * a)
  			
  			if(x1 == "NaN") None (x1, x2)
  			else Some (x1, x2)
  			
  }
  
  solve(2, -2, -4)
  solve(1, 0, 1)
  solve(1, 0, -1)
}