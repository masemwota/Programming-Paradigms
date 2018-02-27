object dds {
  		//Assignment 3: Discrete Dynamical Systems
  
	  /**
	  *	PROBLEM 1
	  * CONTROL LOOP: a tail recursive implementation of controlLoop
	  */
	  def controlLoop[S](state: S, cycle: Int, halt: (S, Int)=> Boolean, update: (S, Int)=>S): S =
	  {
	  			if (halt(state, cycle)) state
	  			else controlLoop(update(state, cycle), cycle + 1, halt, update)
	  }                                       //> controlLoop: [S](state: S, cycle: Int, halt: (S, Int) => Boolean, update: (S
                                                  //| , Int) => S)S
  
  
	  /**
	  * 	PROBLEM 2
	  * POPULATION GROWTH: asexually reproducing pond of amoebas.
	  * initial population doubles every week until it exceeds 10^5.
	  */
		val capacity = 10e5;              //> capacity  : Double = 1000000.0
		
		def updatePop(currentPop: Int, numWeeks: Int) =
		(currentPop * 2)                  //> updatePop: (currentPop: Int, numWeeks: Int)Int
		
		def stopPop(currentPop: Int, numWeeks: Int) =
		(currentPop > capacity)           //> stopPop: (currentPop: Int, numWeeks: Int)Boolean
		
		controlLoop(50, 0, stopPop, updatePop)
                                                  //> res0: Int = 1638400
		controlLoop(500, 0, stopPop, updatePop)
                                                  //> res1: Int = 1024000
		controlLoop(10000, 0, stopPop, updatePop)
                                                  //> res2: Int = 1280000
	
	
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
  		}                                 //> solve: (f: Double => Double)Double
	  
	  /**
	  *	PROBLEM 4
	  * Approximating Square Roots
	  */
	  	def sqrt(x: Double) = solve((n: Double) => n * n - x)
                                                  //> sqrt: (x: Double)Double
	  
	  sqrt(100)                               //> res3: Double = 10.000000000166429
	  sqrt(49)                                //> res4: Double = 7.000000142285558
	  sqrt(36)                                //> res5: Double = 6.000000005545686
	  
	  
  		/**
		*	PROBLEM 5
  		* Approximating Cube Roots
  		*/
  		def cubeRoot(x: Double) = solve((n: Double) => n * n * n - x)
                                                  //> cubeRoot: (x: Double)Double
  			
  		cubeRoot(8)                       //> res6: Double = 2.000000000036784
  		cubeRoot(27)                      //> res7: Double = 3.0000000000019176
  		cubeRoot(64)                      //> res8: Double = 4.000000000119973
  		
  		/**
  		*	PROBLEM 6
  		* Approximating Nth Roots
  		*/
  		def nthRoot(x: Double, n: Int) = solve((r: Double) => math.pow(r, n) - x)
                                                  //> nthRoot: (x: Double, n: Int)Double
  		
  		nthRoot(8, 3)                     //> res9: Double = 2.000000000036784
  		nthRoot(49, 2)                    //> res10: Double = 7.000000142285558
  		nthRoot(64, 3)                    //> res11: Double = 4.0000000001199725
  		nthRoot(81, 4)                    //> res12: Double = 3.000000000001341
  		
}