class InvalidIncomeException extends Exception

object Control {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(608);  //Sequence Control - 1,2,3,4,5
  
  /*
   * PROBLEM 1
   * Tax Calculator
   */
  def tax(income: Double) = {
  		if (income < 0) throw new InvalidIncomeException()
  		 
  		income match {
  				case income if income < 20000 => 0 * income
    			case income if income < 30000 => .05 * income
    			case income if income < 40000 => 0.11 * income
    			case income if income < 60000 => .23 * income
    			case income if income < 100000 => .32 * income
    			case income if income >= 100000 => .50 * income
    			case _ => income
  			}
  };System.out.println("""tax: (income: Double)Double""");$skip(25); val res$0 = 

	//tax(-99)
	tax(15000);System.out.println("""res0: Double = """ + $show(res$0));$skip(12); val res$1 = 
	tax(25000);System.out.println("""res1: Double = """ + $show(res$1));$skip(13); val res$2 = 
	tax(500000);System.out.println("""res2: Double = """ + $show(res$2));$skip(16); val res$3 = 
	tax(100000000);System.out.println("""res3: Double = """ + $show(res$3));$skip(204); 
	
	
	
	/*
	* PROBLEM 2
	* Draw Rectangle
	*/
	
	def rectangle(n: Int, m: Int) =
	{
		var rect = ""
		for(i <- 1 to n; j <- 1 to m)
		{
			rect += "*"
			if(j % m == 0) rect += "\n"
		}
		println(rect)
	};System.out.println("""rectangle: (n: Int, m: Int)Unit""");$skip(18); 
	
	println("3,4");$skip(16); 
	rectangle(3,4);$skip(17); 
  println("4,4");$skip(17); 
  rectangle(4,4);$skip(227); 
     
     
   /*
    * PROBLEM 3
    * Print Sums
    */
    def printSums(n: Int, m: Int) =
    {
    		for(i <- 1 to n-1; j <- 1 to m-1)
    		{
    			val sum = i+j
    			println(i + " + " + j + " = " + sum)
    		}
    };System.out.println("""printSums: (n: Int, m: Int)Unit""");$skip(24); 
    
    printSums(4,3)
            
   /*
    * PROBLEM 4
    * Escape
    */
    import scala.util.control.Breaks._;$skip(346); 
    def mystery =
    {
    			breakable {
    				for(i <- 0 to 100)
    				{
    						if (i % 3 == 0) print ("")
    						else if(i == 10) break
    						else println("i = " + i)
    				}
    			}
    			
    			System.out.println("done")
    };System.out.println("""mystery: => Unit""");$skip(17); 
    
    mystery;$skip(134); 
    
            
   /*
   	* Problem 5
   	*/
   	
   	def root(x: Double): Option[Double] = if (x < 0) None else Some(Math.sqrt(x));System.out.println("""root: (x: Double)Option[Double]""");$skip(74); 

		def below10(x: Double): Option[Double] = if (x < 10) Some(x) else None;System.out.println("""below10: (x: Double)Option[Double]""");$skip(123); 
		
		def pureRoot(x: Option[Double]): Option[Double] =
			x match {
				case None => None
				case Some(y) => root(y)
			};System.out.println("""pureRoot: (x: Option[Double])Option[Double]""");$skip(127); 

		def pureBelow10(x: Option[Double]): Option[Double] =
			x match {
				case None => None
				case Some(y) => below10(y)
			};System.out.println("""pureBelow10: (x: Option[Double])Option[Double]""");$skip(83); 
		
		def below10root(x: Option[Double]): Option[Double] = pureRoot(pureBelow10(x));System.out.println("""below10root: (x: Option[Double])Option[Double]""");$skip(26); val res$4 = 
		
			//tests
			root(36);System.out.println("""res4: Option[Double] = """ + $show(res$4));$skip(12); val res$5 = 
			root(49);System.out.println("""res5: Option[Double] = """ + $show(res$5));$skip(22); val res$6 = 
			pureRoot(Some(64));System.out.println("""res6: Option[Double] = """ + $show(res$6));$skip(22); val res$7 = 
			pureRoot(Some(81));System.out.println("""res7: Option[Double] = """ + $show(res$7));$skip(18); val res$8 = 
			
			below10(7);System.out.println("""res8: Option[Double] = """ + $show(res$8));$skip(15); val res$9 = 
			below10(12);System.out.println("""res9: Option[Double] = """ + $show(res$9));$skip(25); val res$10 = 
			
			pureBelow10(None);System.out.println("""res10: Option[Double] = """ + $show(res$10));$skip(24); val res$11 = 
			pureBelow10(Some(8));System.out.println("""res11: Option[Double] = """ + $show(res$11));$skip(25); val res$12 = 
			pureBelow10(Some(15));System.out.println("""res12: Option[Double] = """ + $show(res$12));$skip(28); val res$13 = 
			
			below10root(Some(9));System.out.println("""res13: Option[Double] = """ + $show(res$13));$skip(25); val res$14 = 
			below10root(Some(15));System.out.println("""res14: Option[Double] = """ + $show(res$14));$skip(24); val res$15 = 
			below10root(Some(4));System.out.println("""res15: Option[Double] = """ + $show(res$15));$skip(21); val res$16 = 
			below10root(None);System.out.println("""res16: Option[Double] = """ + $show(res$16))}
}
 