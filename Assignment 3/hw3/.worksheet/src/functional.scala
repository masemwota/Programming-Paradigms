object functional {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
  println("Welcome to the Scala worksheet");$skip(126); 
  
	  /**
	  * PROBLEM 1
	  */
		def compose[T] (f: T => T, g: T =>T): T=>T =
		{
		   def r(x: T): T = f(g(x));
		   r _
		};System.out.println("""compose: [T](f: T => T, g: T => T)T => T""");$skip(168); 
		
		/**
		* PROBLEM 2
		* Self-composition iterator combinator
		*/
		
		//def selfIter[T](f: T=>T, n: Int) = f composed with itself n times.
		def id[T](x: T): T = x;System.out.println("""id: [T](x: T)T""");$skip(140); 
		
		def selfIter[T] (f: T => T, n: Int): T => T =
		{
				if(n == 0) id _
				else if(n == 1) f
				else selfIter(compose(f, f) , n-1)
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
		selfIter(double, 4) (1);System.out.println("""res9: Double = """ + $show(res$9))}
}
