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
		
		//def selfIter[T](f: T=>T, n: Int) = f composed with itself n times.
		def id[T](x: T): T = x            //> id: [T](x: T)T
		
		def selfIter[T] (f: T => T, n: Int): T => T =
		{
				if(n == 0) id _
				else if(n == 1) f
				else selfIter(compose(f, f) , n-1)
		}                                 //> selfIter: [T](f: T => T, n: Int)T => T
		
		def inc(x: Double) = x + 1        //> inc: (x: Double)Double
	
		 
		selfIter(inc, 0) (10)             //> res0: Double = 10.0
		selfIter(inc, 2) (4)              //> res1: Double = 6.0
		selfIter(inc, 4) (5)              //> res2: Double = 13.0
		selfIter(inc, 5) (5)              //> res3: Double = 21.0
		
		
		def double(x: Double) = 2 * x     //> double: (x: Double)Double
		
		selfIter(double, 0) (2)           //> res4: Double = 2.0
		selfIter(double, 2) (2)           //> res5: Double = 8.0
		selfIter(double, 2) (3)           //> res6: Double = 12.0
		selfIter(double, 3) (2)           //> res7: Double = 32.0
		selfIter(double, 3) (3)           //> res8: Double = 48.0
		selfIter(double, 4) (1)           //> res9: Double = 256.0
}