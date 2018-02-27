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
		
		//Write a function called countPass that counts the number of elements in an array of elements of type T that pass a test of type T=>Boolean.
		//make it recursive
		def countPass[T](vals: Array[T], test: T => Boolean): Int =
		{
				0
		}                                 //> countPass: [T](vals: Array[T], test: T => Boolean)Int
		
		def odd(n: Int) = n % 2 != 0      //> odd: (n: Int)Boolean
		def pal(n: String) = (n == n.reverse)
                                                  //> pal: (n: String)Boolean
		countPass(Array(1,2,3,4,5), odd)  //> res11: Int = 0
		//countPass(Array("mom", "dad", "dog" "bro"), pal)
		
		
		/**
		* 	PROBLEM 4
		* Recur combinator
		*/
		
		def makeIter(baseVal: Int, combine: (Int, Int) => Int): Int => Int =
		{
				def f(n: Int): Int =
				{
						var result = baseVal
						for(count <- 1 to n)
							result = combine(count, result)
						result
				}
				f _
		}                                 //> makeIter: (baseVal: Int, combine: (Int, Int) => Int)Int => Int
		
		//iterative factorial
		def f(n: Int) =
		{
			var result = 1
			for(count <- 1 to n)
				result = count * result
			result
		}                                 //> f: (n: Int)Int
		f(4)                              //> res12: Int = 24
		f(5)                              //> res13: Int = 120
		
		//factorial recursive
		def factRec(n: Int): Int =
		{
				if (n == 0) 1
				else factRec(n-1) * n
		}                                 //> factRec: (n: Int)Int
		factRec(4)                        //> res14: Int = 24
		factRec(5)                        //> res15: Int = 120
	
		//triangle function -- iterative summation
		def trian(n: Int) =
		{
			var result = 0
			for(count <- 1 to n)
				result = count + result
			result
		}                                 //> trian: (n: Int)Int
		trian(4)                          //> res16: Int = 10
		trian(5)                          //> res17: Int = 15
		
		def triRec(n: Int): Int =
		{
				if(n == 0) 0
				else triRec(n-1) + n
		}                                 //> triRec: (n: Int)Int
		triRec(4)                         //> res18: Int = 10
		triRec(5)                         //> res19: Int = 15
		
		
		
		def recur(baseVal: Int, combine: (Int, Int) => Int): Int => Int =
		{
				
				def rec(n: Int): Int =
				{
						if(n == 0) baseVal
						else combine(n, rec(n-1))
				}
				
				rec
		}                                 //> recur: (baseVal: Int, combine: (Int, Int) => Int)Int => Int
		//fact
		recur(1, _*_)(4)                  //> res20: Int = 24
		recur(1, _*_)(5)                  //> res21: Int = 120
		
		//triangle
		recur(0, _+_)(4)                  //> res22: Int = 10
		recur(0, _+_)(5)                  //> res23: Int = 15
		
		
		val fact = makeIter(1, _*_)       //> fact  : Int => Int = functional$$$Lambda$30/1595953398@3b81a1bc
		
		fact(5)                           //> res24: Int = 120
		fact(4)                           //> res25: Int = 24
		
		val tri = makeIter(0, (n: Int, m: Int) => n + m)
                                                  //> tri  : Int => Int = functional$$$Lambda$30/1595953398@4e04a765
		
		tri(5)                            //> res26: Int = 15
		tri(4)                            //> res27: Int = 10
		
	
		
		/**
		*	PROBLEM 5
		* De-Optionize
		*/
		
		def sqrt(x: Double): Option[Double] =
		if (x < 0) None else Some(math.sqrt(x))
                                                  //> sqrt: (x: Double)Option[Double]
		
		sqrt(100)                         //> res28: Option[Double] = Some(10.0)
		sqrt(-100)                        //> res29: Option[Double] = None
		
		def sqrt2(x: Double): Double =
			sqrt(x) match
			{
				case None => throw new Exception("bad input")
				case Some(result) => result
			}                         //> sqrt2: (x: Double)Double
			
		try {
			println(sqrt2(100))
			println(sqrt2(-100))
		} catch {
				case e: Exception => println(e)
		}                                 //> 10.0
                                                  //| java.lang.Exception: bad input
		
		//the code
		//S is stuff you don't care about
		
		/*
		def deOptionize[S,T](f: S => Option[T]): S => T =
		{
				
		}
		
		val sqrt3 = deOptionize(sqrt)
		
		sqrt3(100)
		sqrt3(-100)
		
		*/
		
}