object dds {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(368); 
  		//Assignment 3: Discrete Dynamical Systems
  
	  /**
	  *	PROBLEM 1
	  * CONTROL LOOP: a tail recursive implementation of controlLoop
	  */
	  def controlLoop[S](state: S, cycle: Int, halt: (S, Int)=> Boolean, update: (S, Int)=>S): S =
	  {
	  			if (halt(state, cycle)) state
	  			else controlLoop(update(state, cycle), cycle + 1, halt, update)
	  };System.out.println("""controlLoop: [S](state: S, cycle: Int, halt: (S, Int) => Boolean, update: (S, Int) => S)S""");$skip(187); 
  
  
	  /**
	  * 	PROBLEM 2
	  * POPULATION GROWTH: asexually reproducing pond of amoebas.
	  * initial population doubles every week until it exceeds 10^5.
	  */
		val capacity = 10e5;System.out.println("""capacity  : Double = """ + $show(capacity ));$skip(72); ;
		
		def updatePop(currentPop: Int, numWeeks: Int) =
		(currentPop * 2);System.out.println("""updatePop: (currentPop: Int, numWeeks: Int)Int""");$skip(77); 
		
		def stopPop(currentPop: Int, numWeeks: Int) =
		(currentPop > capacity);System.out.println("""stopPop: (currentPop: Int, numWeeks: Int)Boolean""");$skip(44); val res$0 = 
		
		controlLoop(50, 0, stopPop, updatePop);System.out.println("""res0: Int = """ + $show(res$0));$skip(42); val res$1 = 
		controlLoop(500, 0, stopPop, updatePop);System.out.println("""res1: Int = """ + $show(res$1));$skip(44); val res$2 = 
		controlLoop(10000, 0, stopPop, updatePop);System.out.println("""res2: Int = """ + $show(res$2));$skip(565); 
	
	
		/**
		* 		PROBLEM 3
		* 		Funding Roots of Functions
		* 		Give me any function and I'll guess the root of it
		*/
	  	def solve(f: Double => Double): Double =
	  {
	  			val delta = 1e-5
	  			
	  			//helper
	  			def df(x: Double) = (f(x + delta) - f(x)) / delta
	  			
	  			//halting function
	  			def goodEnough(guess: Double, numGuesses: Int) = math.abs(f(guess)) <= delta
	  				
	  			//update function
		  			def improve(guess: Double, numGuesses: Int) = guess - (f(guess) / df(guess))
		  			
		  			controlLoop(1.0, 0, goodEnough, improve)
  		};System.out.println("""solve: (f: Double => Double)Double""");$skip(122); 
	  
	  /**
	  *	PROBLEM 4
	  * Approximating Square Roots
	  */
	  	def sqrt(x: Double) = solve((n: Double) => n * n - x);System.out.println("""sqrt: (x: Double)Double""");$skip(17); val res$3 = 
	  
	  sqrt(100);System.out.println("""res3: Double = """ + $show(res$3));$skip(12); val res$4 = 
	  sqrt(49);System.out.println("""res4: Double = """ + $show(res$4));$skip(12); val res$5 = 
	  sqrt(36);System.out.println("""res5: Double = """ + $show(res$5));$skip(134); 
	  
	  
  		/**
		*	PROBLEM 5
  		* Approximating Cube Roots
  		*/
  		def cubeRoot(x: Double) = solve((n: Double) => n * n * n - x);System.out.println("""cubeRoot: (x: Double)Double""");$skip(22); val res$6 = 
  			
  		cubeRoot(8);System.out.println("""res6: Double = """ + $show(res$6));$skip(17); val res$7 = 
  		cubeRoot(27);System.out.println("""res7: Double = """ + $show(res$7));$skip(17); val res$8 = 
  		cubeRoot(64);System.out.println("""res8: Double = """ + $show(res$8));$skip(144); 
  		
  		/**
  		*	PROBLEM 6
  		* Approximating Nth Roots
  		*/
  		def nthRoot(x: Double, n: Int) = solve((r: Double) => math.pow(r, n) - x);System.out.println("""nthRoot: (x: Double, n: Int)Double""");$skip(23); val res$9 = 
  		
  		nthRoot(8, 3);System.out.println("""res9: Double = """ + $show(res$9));$skip(19); val res$10 = 
  		nthRoot(49, 2);System.out.println("""res10: Double = """ + $show(res$10));$skip(19); val res$11 = 
  		nthRoot(64, 3);System.out.println("""res11: Double = """ + $show(res$11));$skip(19); val res$12 = 
  		nthRoot(81, 4);System.out.println("""res12: Double = """ + $show(res$12))}
  		
}
