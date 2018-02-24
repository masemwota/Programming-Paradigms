import scala.math._
import scala.util.Random

object math {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(381);   //1, 2, 3, 6, 7, 8
  
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
  			
  };System.out.println("""solve: (a: Double, b: Double, c: Double)Option[(Double, Double)]""");$skip(22); val res$0 = 
  
  solve(2, -2, -4);System.out.println("""res0: Option[(Double, Double)] = """ + $show(res$0));$skip(17); val res$1 = 
  solve(1, 0, 1);System.out.println("""res1: Option[(Double, Double)] = """ + $show(res$1));$skip(18); val res$2 = 
  solve(1, 0, -1);System.out.println("""res2: Option[(Double, Double)] = """ + $show(res$2));$skip(254); 
  
  
  /*
   * PROBLEM 2
   * Distance Formula
   */
   def dist(point1: (Double, Double), point2: (Double, Double)) =
   {
   		val (x1, y1) = point1
   		val (x2, y2) = point2
   		
   		Math.sqrt((Math.pow(x2 - x1, 2)) + (Math.pow(y2 - y1, 2)))
   };System.out.println("""dist: (point1: (Double, Double), point2: (Double, Double))Double""");$skip(26); val res$3 = 
   
   dist((1,1), (0,0));System.out.println("""res3: Double = """ + $show(res$3));$skip(22); val res$4 = 
   dist((3,0), (0,0));System.out.println("""res4: Double = """ + $show(res$4));$skip(346); 
   
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
    };System.out.println("""dot: (point1: (Double, Double, Double), point2: (Double, Double, Double))Double""");$skip(39); val res$5 = 
    
    dot((2.0, 3, 4), (2, 2.0, 2));System.out.println("""res5: Double = """ + $show(res$5));$skip(530); 
    
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
     };System.out.println("""isPrime: (number: Int)AnyVal""");$skip(24); val res$6 = 
     
     isPrime(-10);System.out.println("""res6: AnyVal = """ + $show(res$6));$skip(16); val res$7 = 
     isPrime(0);System.out.println("""res7: AnyVal = """ + $show(res$7));$skip(16); val res$8 = 
     isPrime(1);System.out.println("""res8: AnyVal = """ + $show(res$8));$skip(16); val res$9 = 
     isPrime(2);System.out.println("""res9: AnyVal = """ + $show(res$9));$skip(16); val res$10 = 
     isPrime(3);System.out.println("""res10: AnyVal = """ + $show(res$10));$skip(16); val res$11 = 
     isPrime(7);System.out.println("""res11: AnyVal = """ + $show(res$11));$skip(16); val res$12 = 
     isPrime(8);System.out.println("""res12: AnyVal = """ + $show(res$12));$skip(18); val res$13 = 
     isPrime(193);System.out.println("""res13: AnyVal = """ + $show(res$13));$skip(200); 
     
     
     /*
      * PROBLEM 7
      * Euler's phi function
      */
      
      def gcd(a: Int, b: Int): Int =
      {
      		if((a == 0) | (b == 0)) return a + b
      		gcd(b, a % b)
			};System.out.println("""gcd: (a: Int, b: Int)Int""");$skip(21); val res$14 = 
			
			gcd (30, 105);System.out.println("""res14: Int = """ + $show(res$14));$skip(15); val res$15 = 
			gcd(12, 30);System.out.println("""res15: Int = """ + $show(res$15));$skip(14); val res$16 = 
			gcd(5, 12);System.out.println("""res16: Int = """ + $show(res$16));$skip(214); 
      
      
      //********
      
      
      def phi(input: Int) =
      {
      		var count = 0
      		
      		for(i <- 0 to input)
      			if(gcd(i,input) == 1) count += 1
      		
      		count
      };System.out.println("""phi: (input: Int)Int""");$skip(20); val res$17 = 
      
      phi(9);System.out.println("""res17: Int = """ + $show(res$17));$skip(14); val res$18 = 
      phi(10);System.out.println("""res18: Int = """ + $show(res$18));$skip(249); 
      
      
      
      /*
       * PROBLEM 8
       * Roll dice
       */
       def rollDice() =
       {
       		val num1 = Random.nextInt(6) + 1;
       		val num2 = Random.nextInt(6) + 1;
       		           
       		(num1, num2)
       };System.out.println("""rollDice: ()(Int, Int)""");$skip(25); val res$19 = 
        
       rollDice;System.out.println("""res19: (Int, Int) = """ + $show(res$19));$skip(16); val res$20 = 
       rollDice;System.out.println("""res20: (Int, Int) = """ + $show(res$20));$skip(16); val res$21 = 
       rollDice;System.out.println("""res21: (Int, Int) = """ + $show(res$21))}
   
}
