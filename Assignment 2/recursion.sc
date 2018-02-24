/**
* Recursion homework
* 1, 2, 3, 4, 5, 9, 10
*/
object recursion {
  
  def inc(n: Int) = n + 1                         //> inc: (n: Int)Int
	def dec(n: Int) = n - 1                   //> dec: (n: Int)Int
	def isZero(n: Int) = n == 0               //> isZero: (n: Int)Boolean
	
	/**
	* 	PROBLEM 1
	*/
	//simple
	def add1(n: Int, m: Int) = n + m          //> add1: (n: Int, m: Int)Int
	add1(2, 3)                                //> res0: Int = 5
	add1(1, 9)                                //> res1: Int = 10
	
	//recursive but wrong
	def add2(n: Int, m: Int): Int =
	{
			if(isZero(n)) 1
			else
				m + add2(dec(n), 1)
	}                                         //> add2: (n: Int, m: Int)Int
	add2(2, 3)                                //> res2: Int = 5
	add2(1, 9)                                //> res3: Int = 10
	add2(10, 15)                              //> res4: Int = 25
	
	
	//actual recursive
	def add(m: Int, n: Int): Int =
	{
		if(isZero(n)) m
		else if (isZero(m)) n
		else add(inc(m), dec(n))
	}                                         //> add: (m: Int, n: Int)Int
	add(2, 3)                                 //> res5: Int = 5
	add(1, 9)                                 //> res6: Int = 10
	add(9, 10)                                //> res7: Int = 19
	add(10, 15)                               //> res8: Int = 25
	
	//Iterative solution
	def add3(m: Int, n: Int) =
	{
			var count = m;
			for(i <- 1 to n) count = count + 1
			count
	}                                         //> add3: (m: Int, n: Int)Int
	add3(2, 3)                                //> res9: Int = 5
	add3(1, 9)                                //> res10: Int = 10
	add3(9, 10)                               //> res11: Int = 19
	add3(10, 15)                              //> res12: Int = 25
	
	
	//PROBLEM 5 -- TAIL RECURSION
	
	def addTail(m: Int, n: Int) = {
   def helper(count: Int, result: Int): Int =
      if (n < count) result else helper(inc(count), inc(result))
   helper(1, m)
}                                                 //> addTail: (m: Int, n: Int)Int
	
	addTail(2, 3)                             //> res13: Int = 5
	addTail(1, 9)                             //> res14: Int = 10
	addTail(9, 10)                            //> res15: Int = 19
	addTail(10, 15)                           //> res16: Int = 25
	
	
	/**
	*	PROBLEM 2
	*/
	
	 //simple
	 def mul1 (n: Int, m: Int) = n * m        //> mul1: (n: Int, m: Int)Int
	 
	 mul1(2, 4)                               //> res17: Int = 8
	 mul1(1, 50)                              //> res18: Int = 50
	 mul1(3, 6)                               //> res19: Int = 18
	 
	 //recursive
	 def mul (m: Int, n: Int): Int =
	 {
	 		if(isZero(n)) 0
	 		else add(m, mul(m, dec(n)))
	 }                                        //> mul: (m: Int, n: Int)Int
	 mul(2, 4)                                //> res20: Int = 8
	 mul(1, 50)                               //> res21: Int = 50
	 mul(3, 6)                                //> res22: Int = 18
	 mul(7, 6)                                //> res23: Int = 42
	 
	 
	 //iterative
	 def mulIt(m: Int, n: Int) =
	 {
	 		var count = 0
	 		for(i <- 1 to m)
	 		count = count + n
	 		
	 		count
	 }                                        //> mulIt: (m: Int, n: Int)Int
	 
	 mulIt(2, 4)                              //> res24: Int = 8
	 mulIt(1, 50)                             //> res25: Int = 50
	 mulIt(3, 6)                              //> res26: Int = 18
	 mulIt(7, 6)                              //> res27: Int = 42
	 
	 //PROBLEM 5 -- TAIL RECURSIVE
	 def mulTail(m:Int, n: Int) = {
   		def helper(count: Int, result: Int): Int =
      		if (n < count) result else helper(inc(count), add(result, m))
   		helper(1, 0)
		}                                 //> mulTail: (m: Int, n: Int)Int
		
	 mulTail(2, 4)                            //> res28: Int = 8
	 mulTail(1, 50)                           //> res29: Int = 50
	 mulTail(3, 6)                            //> res30: Int = 18
	 mulTail(7, 6)                            //> res31: Int = 42
	 
	 
	 /**
	 * 	PROBLEM 3
	 */
	 
	 //simple
	 def exp(m: Int) = Math.pow(2, m) // = 2^m//> exp: (m: Int)Double
	 exp(2)                                   //> res32: Double = 4.0
	 exp(3)                                   //> res33: Double = 8.0
	 exp(4)                                   //> res34: Double = 16.0
	 exp(6)                                   //> res35: Double = 64.0
	 
	 //recursion
	 def exp2(m: Int): Int =
	 {
	 		if(isZero(m)) 1
	 		else mul(2, exp2(dec(m)))
	 }                                        //> exp2: (m: Int)Int
	 exp2(0)                                  //> res36: Int = 1
	 exp2(2)                                  //> res37: Int = 4
	 exp2(3)                                  //> res38: Int = 8
	 exp2(4)                                  //> res39: Int = 16
	 exp2(6)                                  //> res40: Int = 64
	 exp2(8)                                  //> res41: Int = 256
	 
	 //iterative
	 def expIt(m: Int) =
	 {
	 		var count = 0;
	 		for(i <- 0 to m)
	 		{
	 				count = count * 2
	 		}
	 }                                        //> expIt: (m: Int)Unit
	 exp(2)                                   //> res42: Double = 4.0
	 exp(3)                                   //> res43: Double = 8.0
	 exp(4)                                   //> res44: Double = 16.0
	 exp(6)                                   //> res45: Double = 64.0
	 
	 //PROBLEM 5 -- tail recursion
	 def expTail(m: Int, n: Int) =
	 {
	 		def helper(count: Int, result: Int): Int =
	 				if(n < count) result else helper(inc(count), mul(count, 2))
	 		helper(0, 0)
	 }                                        //> expTail: (m: Int, n: Int)Int
	 exp2(0)                                  //> res46: Int = 1
	 exp2(2)                                  //> res47: Int = 4
	 exp2(3)                                  //> res48: Int = 8
	 exp2(4)                                  //> res49: Int = 16
	 exp2(6)                                  //> res50: Int = 64
	 exp2(8)                                  //> res51: Int = 256
	 
	 
	 
	 /**
	 *		PROBLEM 4
	 */
	 //hyperExp(n: Int) = exp(exp(... (exp(0)) ...)) // n-times
	 def hyperExp(n: Int): Int =
	 {
	 		if(isZero(n)) 1
	 		else hyperExp(n)
	 }                                        //> hyperExp: (n: Int)Int
	 
	 //hyperExp(0)
	 //hyperExp(1)
	 //hyperExp(2)
	 //hyperExp(3)
	 //hyperExp(4)
	 
	 //iterative
	 def hyperExpIt(n: Int) =
	 {
	 		var count = 2;
	 		for(i <- 0 to n)
	 		{
	 			count = exp2(n)
	 		}
	 		count
	 }                                        //> hyperExpIt: (n: Int)Int
	 hyperExpIt(0)                            //> res52: Int = 1
	 hyperExpIt(1)                            //> res53: Int = 2
	 hyperExpIt(2)                            //> res54: Int = 4
	 hyperExpIt(3)                            //> res55: Int = 8
	 hyperExpIt(4)                            //> res56: Int = 16
	 
	 
	 //PROBLEM 5 -- tail recursion
	 def hyperExpTail(n: Int) =
	 {
	 			def helper(count: Int, result: Int): Int =
	 				if(n < count) result else helper(count + 1, exp2(n))
	 			helper(1, 1)
	 }                                        //> hyperExpTail: (n: Int)Int
	 hyperExpTail(0)                          //> res57: Int = 1
	 hyperExpTail(1)                          //> res58: Int = 2
	 hyperExpTail(2)                          //> res59: Int = 4
	 hyperExpTail(3)                          //> res60: Int = 8
	 hyperExpTail(4)                          //> res61: Int = 16
	 
	 
	 /**
	 * 		PROBLEM 9
	 */
	 def fib(n: Int): Int =
	 {
	 		if(isZero(n)) 1
	 		else if(n == 1) 1
	 		else fib(n-1) + fib(n-2)
	 }                                        //> fib: (n: Int)Int
	 
	 fib(0)                                   //> res62: Int = 1
	 fib(1)                                   //> res63: Int = 1
	 fib(2)                                   //> res64: Int = 2
	 fib(3)                                   //> res65: Int = 3
	 fib(4)                                   //> res66: Int = 5
	 fib(5)                                   //> res67: Int = 8
	 
	 def fibIt(n: Int) =
	 {
	 		var x = 0
	 		var y = 1
	 		var z = 0
	 		
	 		for(i <- 0 to n)
	 		{
	 				x = y;
	 				y = z;
	 				z = x+ y;
	 		}
	 		z
	 }                                        //> fibIt: (n: Int)Int
	  
	 fibIt(0)                                 //> res68: Int = 1
	 fibIt(1)                                 //> res69: Int = 1
	 fibIt(2)                                 //> res70: Int = 2
	 fibIt(3)                                 //> res71: Int = 3
	 fibIt(4)                                 //> res72: Int = 5
	 fibIt(5)                                 //> res73: Int = 8
	 
	 //tail recursive
	 def fibTail(n: Int) =
	 {
	 		def helper(count: Int, result: Int, sum: Int): Int =
	 			if(n < count) result else helper(count+1, n, n+1)
	 		helper(1, 1, 2)
	 }                                        //> fibTail: (n: Int)Int
	 fibTail(0)                               //> res74: Int = 1
	 fibTail(1)                               //> res75: Int = 1
	 fibTail(2)                               //> res76: Int = 2
	 fibTail(3)                               //> res77: Int = 3
	 fibTail(4)                               //> res78: Int = 4
	 fibTail(5)                               //> res79: Int = 5
	 fibTail(6)                               //> res80: Int = 6
	 fibTail(7)                               //> res81: Int = 7
	 fibTail(8)                               //> res82: Int = 8
	 
	 
	 
	 /**
	 * 	PROBLEM 10
	 */
	 
	 //# of ways to choose m things from n
	 def choose(m: Int, n: Int): Int =
	 {
	 		if(m == n) 1
	 		else if (m < n) 0
	 		else if(n == 1) m
	 		//choose(5, 5) = 1
			//choose(4, 5) = 0
	 		
	 		//Choose (7,5) = choose(6,5) + choose(6,4)
	 		else
	 		add(choose(dec(m), n), choose(dec(m), dec(n)))
	 		
	 }                                        //> choose: (m: Int, n: Int)Int
	 
	 choose(4,2)                              //> res83: Int = 6
	 choose(7,5)                              //> res84: Int = 21
	 choose(11,4)                             //> res85: Int = 330
}