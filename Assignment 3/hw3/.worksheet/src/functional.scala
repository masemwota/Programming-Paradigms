object functional {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
  println("Welcome to the Scala worksheet");$skip(126); 
  
	  /**
	  * PROBLEM 1
	  */
		def compose[T] (f: T => T, g: T =>T): T=>T =
		{
		   def r(x: T): T = f(g(x));
		   r _
		};System.out.println("""compose: [T](f: T => T, g: T => T)T => T""");$skip(99); 
		
		/**
		* PROBLEM 2
		* Self-composition iterator combinator
		*/
				
		def id[T](x: T): T = x;System.out.println("""id: [T](x: T)T""");$skip(117); 
		
		def selfIter[T] (f: T => T, n: Int): T => T =
		{
				if(n == 0) id _
				else compose(selfIter(f, n-1), f)
		};System.out.println("""selfIter: [T](f: T => T, n: Int)T => T""");$skip(32); 
		
		def inc(x: Double) = x + 1;System.out.println("""inc: (x: Double)Double""");$skip(30); val res$0 = 
	
		 
		selfIter(inc, 0) (10);System.out.println("""res0: Double = """ + $show(res$0));$skip(23); val res$1 = 
		selfIter(inc, 2) (4);System.out.println("""res1: Double = """ + $show(res$1));$skip(23); val res$2 = 
		selfIter(inc, 4) (5);System.out.println("""res2: Double = """ + $show(res$2));$skip(23); val res$3 = 
		selfIter(inc, 5) (5);System.out.println("""res3: Double = """ + $show(res$3));$skip(38); 
		
		
		def double(x: Double) = 2 * x;System.out.println("""double: (x: Double)Double""");$skip(29); val res$4 = 
		
		selfIter(double, 0) (2);System.out.println("""res4: Double = """ + $show(res$4));$skip(26); val res$5 = 
		selfIter(double, 2) (2);System.out.println("""res5: Double = """ + $show(res$5));$skip(26); val res$6 = 
		selfIter(double, 2) (3);System.out.println("""res6: Double = """ + $show(res$6));$skip(26); val res$7 = 
		selfIter(double, 3) (2);System.out.println("""res7: Double = """ + $show(res$7));$skip(26); val res$8 = 
		selfIter(double, 3) (3);System.out.println("""res8: Double = """ + $show(res$8));$skip(26); val res$9 = 
		selfIter(double, 3) (5);System.out.println("""res9: Double = """ + $show(res$9));$skip(26); val res$10 = 
		selfIter(double, 4) (1);System.out.println("""res10: Double = """ + $show(res$10));$skip(367); 
		
		
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
		};System.out.println("""countPass: [T](vals: Array[T], test: T => Boolean)Int""");$skip(63); val res$11 = 
	 
	
		countPass(Array(1, 2, 3, 4, 5), (n: Int) => n % 2 != 0);System.out.println("""res11: Int = """ + $show(res$11));$skip(61); val res$12 = 
		countPass(Array(2, 3, 4, 5, 7, 8), (x: Int) => x % 2 == 0);System.out.println("""res12: Int = """ + $show(res$12));$skip(87); val res$13 = 
 		countPass(Array("mom", "rotator", "boy", "racecar"), (x: String) => x == x.reverse);System.out.println("""res13: Int = """ + $show(res$13));$skip(239); 
	
		
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
		};System.out.println("""recur: (baseVal: Int, combine: (Int, Int) => Int)Int => Int""");$skip(33); val res$14 = 
		//factorial
		recur(1, _*_)(4);System.out.println("""res14: Int = """ + $show(res$14));$skip(19); val res$15 = 
		recur(1, _*_)(5);System.out.println("""res15: Int = """ + $show(res$15));$skip(20); val res$16 = 
		recur(1, _*_)(10);System.out.println("""res16: Int = """ + $show(res$16));$skip(35); val res$17 = 
		
		//triangle
		recur(0, _+_)(4);System.out.println("""res17: Int = """ + $show(res$17));$skip(19); val res$18 = 
		recur(0, _+_)(5);System.out.println("""res18: Int = """ + $show(res$18));$skip(20); val res$19 = 
		recur(0, _+_)(10);System.out.println("""res19: Int = """ + $show(res$19));$skip(167); 
		
		
		
		/**
		*	PROBLEM 5
		* De-Optionize
		*/
		
		def parseDigits(digits: String): Option[Int] =
   		if (digits.matches("[0-9]*")) Some(digits.toInt) else None;System.out.println("""parseDigits: (digits: String)Option[Int]""");$skip(164); 
		

		def parse2(digits: String): Double =
			parseDigits(digits) match
			{
				case None => throw new Exception("bad input")
				case Some(result) => result
			};System.out.println("""parse2: (digits: String)Double""");$skip(194); 
		

		def deOptionize[T](f: T => Option[T], input: T) =
		{
			val result = f(input)
			result match
			{
				case None => throw new Exception("bad input")
				case Some(result) => f
			}
	
		};System.out.println("""deOptionize: [T](f: T => Option[T], input: T)T => Option[T]""")}
}
