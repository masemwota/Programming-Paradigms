object functional {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
	  /**
	  * PROBLEM 1
	  */
		def compose[T] (f: T => T, g: T =>T): T=>T =
		{
		   def r(x: T): T = f(g(x));
		   r _
		}                                 //> compose: [T](f: T => T, g: T => T)T => T
		
		/**
		* PROBLEM 2
		* Self-composition iterator combinator
		*/
				
		def id[T](x: T): T = x            //> id: [T](x: T)T
		
		def selfIter[T] (f: T => T, n: Int): T => T =
		{
				if(n == 0) id _
				else compose(selfIter(f, n-1), f)
		}                                 //> selfIter: [T](f: T => T, n: Int)T => T
		
		def inc(x: Double) = x + 1        //> inc: (x: Double)Double
	
		 
		selfIter(inc, 0) (10)             //> res0: Double = 10.0
		selfIter(inc, 2) (4)              //> res1: Double = 6.0
		selfIter(inc, 4) (5)              //> res2: Double = 9.0
		selfIter(inc, 5) (5)              //> res3: Double = 10.0
		
		
		def double(x: Double) = 2 * x     //> double: (x: Double)Double
		
		selfIter(double, 0) (2)           //> res4: Double = 2.0
		selfIter(double, 2) (2)           //> res5: Double = 8.0
		selfIter(double, 2) (3)           //> res6: Double = 12.0
		selfIter(double, 3) (2)           //> res7: Double = 16.0
		selfIter(double, 3) (3)           //> res8: Double = 24.0
		selfIter(double, 3) (5)           //> res9: Double = 40.0
		selfIter(double, 4) (1)           //> res10: Double = 16.0
		
		
		/**
		*	PROBLEM 3
		* Counts elements
		*/
		
		def countPass[T](vals: Array[T], test:T=>Boolean) =
		{
				def countP[T](occurences: Int, index: Int): Int =
				{
					if (vals.length == index) occurences
					else
					{
						if(test(vals(index))) countP(occurences+1, index+1)
						else countP(occurences, index+1)
					}
				}
				
				countP(0, 0)
		}                                 //> countPass: [T](vals: Array[T], test: T => Boolean)Int
	 
	
		countPass(Array(1, 2, 3, 4, 5), (n: Int) => n % 2 != 0)
                                                  //> res11: Int = 3
		countPass(Array(2, 3, 4, 5, 7, 8), (x: Int) => x % 2 == 0)
                                                  //> res12: Int = 3
 		countPass(Array("mom", "rotator", "boy", "racecar"), (x: String) => x == x.reverse)
                                                  //> res13: Int = 3
	
		
		/**
		* 	PROBLEM 4
		* Recur combinator
		*/
	
		def recur(baseVal: Int, combine: (Int, Int) => Int): Int => Int =
		{
				def rec(n: Int): Int =
				{
						if(n == 0) baseVal
						else combine(n, rec(n-1))
				}
				
				rec
		}                                 //> recur: (baseVal: Int, combine: (Int, Int) => Int)Int => Int
		//factorial
		recur(1, _*_)(4)                  //> res14: Int = 24
		recur(1, _*_)(5)                  //> res15: Int = 120
		recur(1, _*_)(10)                 //> res16: Int = 3628800
		
		//triangle
		recur(0, _+_)(4)                  //> res17: Int = 10
		recur(0, _+_)(5)                  //> res18: Int = 15
		recur(0, _+_)(10)                 //> res19: Int = 55
		
		
		
		/**
		*	PROBLEM 5
		* De-Optionize
		*/
		
		def parseDigits(digits: String): Option[Int] =
   		if (digits.matches("[0-9]*")) Some(digits.toInt) else None
                                                  //> parseDigits: (digits: String)Option[Int]
		

		def parse2(digits: String): Double =
			parseDigits(digits) match
			{
				case None => throw new Exception("bad input")
				case Some(result) => result
			}                         //> parse2: (digits: String)Double
		

		def deOptionize[T](f: T => Option[T], input: T) =
		{
			val result = f(input)
			result match
			{
				case None => throw new Exception("bad input")
				case Some(result) => f
			}
	
		}                                 //> deOptionize: [T](f: T => Option[T], input: T)T => Option[T]
}