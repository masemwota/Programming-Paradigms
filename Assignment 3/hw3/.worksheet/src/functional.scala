object functional {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
  println("Welcome to the Scala worksheet");$skip(126); 
  
	  /**
	  * PROBLEM 1
	  */
		def compose[T] (f: T => T, g: T =>T): T=>T =
		{
		   def r(x: T): T = f(g(x));
		   r _
		};System.out.println("""compose: [T](f: T => T, g: T => T)T => T""");$skip(170); 
		
		/**
		* PROBLEM 2
		* Self-composition iterator combinator
		*/
				
		//def selfIter[T](f: T=>T, n: Int) = f composed with itself n times.
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
		selfIter(double, 4) (1);System.out.println("""res10: Double = """ + $show(res$10));$skip(296); 
		
		
		/**
		*	PROBLEM 3
		* Counts elements
		*/
		
		//Write a function called countPass that counts the number of elements in an array of elements of type T that pass a test of type T=>Boolean.
		//make it recursive
		def countPass[T](vals: Array[T], test: T => Boolean): Int =
		{
				0
		};System.out.println("""countPass: [T](vals: Array[T], test: T => Boolean)Int""");$skip(34); 
		
		def odd(n: Int) = n % 2 != 0;System.out.println("""odd: (n: Int)Boolean""");$skip(40); 
		def pal(n: String) = (n == n.reverse);System.out.println("""pal: (n: String)Boolean""");$skip(35); val res$11 = 
		countPass(Array(1,2,3,4,5), odd);System.out.println("""res11: Int = """ + $show(res$11));$skip(339); 
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
		};System.out.println("""makeIter: (baseVal: Int, combine: (Int, Int) => Int)Int => Int""");$skip(133); 
		
		//iterative factorial
		def f(n: Int) =
		{
			var result = 1
			for(count <- 1 to n)
				result = count * result
			result
		};System.out.println("""f: (n: Int)Int""");$skip(7); val res$12 = 
		f(4);System.out.println("""res12: Int = """ + $show(res$12));$skip(7); val res$13 = 
		f(5);System.out.println("""res13: Int = """ + $show(res$13));$skip(108); 
		
		//factorial recursive
		def factRec(n: Int): Int =
		{
				if (n == 0) 1
				else factRec(n-1) * n
		};System.out.println("""factRec: (n: Int)Int""");$skip(13); val res$14 = 
		factRec(4);System.out.println("""res14: Int = """ + $show(res$14));$skip(13); val res$15 = 
		factRec(5);System.out.println("""res15: Int = """ + $show(res$15));$skip(157); 
	
		//triangle function -- iterative summation
		def trian(n: Int) =
		{
			var result = 0
			for(count <- 1 to n)
				result = count + result
			result
		};System.out.println("""trian: (n: Int)Int""");$skip(11); val res$16 = 
		trian(4);System.out.println("""res16: Int = """ + $show(res$16));$skip(11); val res$17 = 
		trian(5);System.out.println("""res17: Int = """ + $show(res$17));$skip(81); 
		
		def triRec(n: Int): Int =
		{
				if(n == 0) 0
				else triRec(n-1) + n
		};System.out.println("""triRec: (n: Int)Int""");$skip(12); val res$18 = 
		triRec(4);System.out.println("""res18: Int = """ + $show(res$18));$skip(12); val res$19 = 
		triRec(5);System.out.println("""res19: Int = """ + $show(res$19));$skip(199); 
		
		
		
		def recur(baseVal: Int, combine: (Int, Int) => Int): Int => Int =
		{
				
				def rec(n: Int): Int =
				{
						if(n == 0) baseVal
						else combine(n, rec(n-1))
				}
				
				rec
		};System.out.println("""recur: (baseVal: Int, combine: (Int, Int) => Int)Int => Int""");$skip(28); val res$20 = 
		//fact
		recur(1, _*_)(4);System.out.println("""res20: Int = """ + $show(res$20));$skip(19); val res$21 = 
		recur(1, _*_)(5);System.out.println("""res21: Int = """ + $show(res$21));$skip(35); val res$22 = 
		
		//triangle
		recur(0, _+_)(4);System.out.println("""res22: Int = """ + $show(res$22));$skip(19); val res$23 = 
		recur(0, _+_)(5);System.out.println("""res23: Int = """ + $show(res$23));$skip(36); 
		
		
		val fact = makeIter(1, _*_);System.out.println("""fact  : Int => Int = """ + $show(fact ));$skip(13); val res$24 = 
		
		fact(5);System.out.println("""res24: Int = """ + $show(res$24));$skip(10); val res$25 = 
		fact(4);System.out.println("""res25: Int = """ + $show(res$25));$skip(54); 
		
		val tri = makeIter(0, (n: Int, m: Int) => n + m);System.out.println("""tri  : Int => Int = """ + $show(tri ));$skip(12); val res$26 = 
		
		tri(5);System.out.println("""res26: Int = """ + $show(res$26));$skip(9); val res$27 = 
		tri(4);System.out.println("""res27: Int = """ + $show(res$27));$skip(135); 
		
	
		
		/**
		*	PROBLEM 5
		* De-Optionize
		*/
		
		def sqrt(x: Double): Option[Double] =
		if (x < 0) None else Some(math.sqrt(x));System.out.println("""sqrt: (x: Double)Option[Double]""");$skip(15); val res$28 = 
		
		sqrt(100);System.out.println("""res28: Option[Double] = """ + $show(res$28));$skip(13); val res$29 = 
		sqrt(-100);System.out.println("""res29: Option[Double] = """ + $show(res$29));$skip(145); 
		
		def sqrt2(x: Double): Double =
			sqrt(x) match
			{
				case None => throw new Exception("bad input")
				case Some(result) => result
			};System.out.println("""sqrt2: (x: Double)Double""");$skip(111); 
			
		try {
			println(sqrt2(100))
			println(sqrt2(-100))
		} catch {
				case e: Exception => println(e)
		}}
		
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
