import scala.math._
import scala.util.Random

object math {  //1, 2, 3, 6, 7, 8
  
  /*
   * Problem 1
   * Quadratic Formula
   */
  def solve(a: Double, b: Double, c: Double) =
  {
  			val det = Math.pow(b, 2) - (4* a * c)
  			var x1 = ((-b) + Math.sqrt(det))/ (2 * a)
  			var x2 = ((-b) - Math.sqrt(det))/ (2 * a)
  			
  			if (det < 0) None
  			else Some(x1, x2)
  			
  }                                               //> solve: (a: Double, b: Double, c: Double)Option[(Double, Double)]
  
  solve(2, -2, -4)                                //> res0: Option[(Double, Double)] = Some((2.0,-1.0))
  solve(1, 0, 1)                                  //> res1: Option[(Double, Double)] = None
  solve(1, 0, -1)                                 //> res2: Option[(Double, Double)] = Some((1.0,-1.0))
  
  
  /*
   * PROBLEM 2
   * Distance Formula
   */
   def dist(point1: (Double, Double), point2: (Double, Double)) =
   {
   		val (x1, y1) = point1
   		val (x2, y2) = point2
   		
   		Math.sqrt((Math.pow(x2 - x1, 2)) + (Math.pow(y2 - y1, 2)))
   }                                              //> dist: (point1: (Double, Double), point2: (Double, Double))Double
   
   dist((1,1), (0,0))                             //> res3: Double = 1.4142135623730951
   dist((3,0), (0,0))                             //> res4: Double = 3.0
   
   //The type of dist is a double because the function evaluates to a double
   
   
   /*
    * PROBLEM 3
    * Dot Product
    */
    
    def dot(point1: (Double, Double, Double), point2: (Double, Double, Double)) =
    {
    		val (x1, x2, x3) = point1
    		val (y1, y2, y3) = point2
    		
    		(x1 * y1) + (x2 * y2) + (x3 * y3)
    }                                             //> dot: (point1: (Double, Double, Double), point2: (Double, Double, Double))Do
                                                  //| uble
    
    dot((2.0, 3, 4), (2, 2.0, 2))                 //> res5: Double = 18.0
    
    /*
     * PROBLEM 6
     * Prime Number
     */
     
     def isPrime(number: Int) =
     {
     		try
     		{
     			if(number < 0) throw new Exception("number is negative")
     		
     			var prime = true
     		
     			if(number == 0) prime = false
     			else if(number == 1) prime = false
     			else
     				for(i <- 2 to number)
     					if((number % i == 0) && (i != number)) prime = false
     					
     			prime
  				}
  				
  				catch
  				{
  				 case e: Exception => println(e)
  				}
     }                                            //> isPrime: (number: Int)AnyVal
     
     isPrime(-10)                                 //> java.lang.Exception: number is negative
                                                  //| res6: AnyVal = ()
     isPrime(0)                                   //> res7: AnyVal = false
     isPrime(1)                                   //> res8: AnyVal = false
     isPrime(2)                                   //> res9: AnyVal = true
     isPrime(3)                                   //> res10: AnyVal = true
     isPrime(7)                                   //> res11: AnyVal = true
     isPrime(8)                                   //> res12: AnyVal = false
     isPrime(193)                                 //> res13: AnyVal = true
     
     
     /*
      * PROBLEM 7
      * Euler's phi function
      */
      
      def gcd(a: Int, b: Int): Int =
      {
      		if((a == 0) | (b == 0)) return a + b
      		gcd(b, a % b)
			}                         //> gcd: (a: Int, b: Int)Int
			
			gcd (30, 105)             //> res14: Int = 15
			gcd(12, 30)               //> res15: Int = 6
			gcd(5, 12)                //> res16: Int = 1
      
      
      //********
      
      
      def phi(input: Int) =
      {
      		var count = 0
      		
      		for(i <- 0 to input)
      			if(gcd(i,input) == 1) count += 1
      		
      		count
      }                                           //> phi: (input: Int)Int
      
      phi(9)                                      //> res17: Int = 6
      phi(10)                                     //> res18: Int = 4
      
      
      
      /*
       * PROBLEM 8
       * Roll dice
       */
       def rollDice() =
       {
       		val num1 = Random.nextInt(6) + 1;
       		val num2 = Random.nextInt(6) + 1;
       		           
       		(num1, num2)
       }                                          //> rollDice: ()(Int, Int)
        
       rollDice                                   //> res19: (Int, Int) = (3,1)
       rollDice                                   //> res20: (Int, Int) = (4,2)
       rollDice                                   //> res21: (Int, Int) = (6,1)
   
}