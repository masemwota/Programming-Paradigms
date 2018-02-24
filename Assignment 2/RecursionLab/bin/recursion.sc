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
	
	//recursive
	def add(m: Int, n: Int): Int =
	{
		if(isZero(n)) m
		else if (isZero(m)) n
		else add(inc(m), dec(n))
	}                                         //> add: (m: Int, n: Int)Int
	add(2, 3)                                 //> res0: Int = 5
	add(1, 9)                                 //> res1: Int = 10
	add(9, 10)                                //> res2: Int = 19
	add(10, 15)                               //> res3: Int = 25
	
	//PROBLEM 5 -- TAIL RECURSION
	
	def addTail(m: Int, n: Int) = {
   	def helper(count: Int, result: Int): Int =
      	if (n < count) result else helper(inc(count), inc(result))
   	helper(1, m)
	}                                         //> addTail: (m: Int, n: Int)Int
	
	addTail(2, 3)                             //> res4: Int = 5
	addTail(1, 9)                             //> res5: Int = 10
	addTail(9, 10)                            //> res6: Int = 19
	addTail(10, 15)                           //> res7: Int = 25
	
	
	/**
	*	PROBLEM 2
	*/
	
	 //recursive
	 def mul (m: Int, n: Int): Int =
	 {
	 		if(isZero(n)) 0
	 		else add(m, mul(m, dec(n)))
	 }                                        //> mul: (m: Int, n: Int)Int
	 mul(2, 4)                                //> res8: Int = 8
	 mul(1, 50)                               //> res9: Int = 50
	 mul(3, 6)                                //> res10: Int = 18
	 mul(7, 6)                                //> res11: Int = 42
	 
	
	 //PROBLEM 5 -- TAIL RECURSIVE
	 def mulTail(m:Int, n: Int) = {
   		def helper(count: Int, result: Int): Int =
      		if (n < count) result else helper(inc(count), add(result, m))
   		helper(1, 0)
		}                                 //> mulTail: (m: Int, n: Int)Int
		
	 mulTail(2, 4)                            //> res12: Int = 8
	 mulTail(1, 50)                           //> res13: Int = 50
	 mulTail(3, 6)                            //> res14: Int = 18
	 mulTail(7, 6)                            //> res15: Int = 42
	 
	 
	 /**
	 * 	PROBLEM 3
	 */

	 //recursion
	 def exp2(m: Int): Int =
	 {
	 		if(isZero(m)) 1
	 		else mul(2, exp2(dec(m)))
	 }                                        //> exp2: (m: Int)Int
	 exp2(0)                                  //> res16: Int = 1
	 exp2(2)                                  //> res17: Int = 4
	 exp2(3)                                  //> res18: Int = 8
	 exp2(4)                                  //> res19: Int = 16
	 exp2(6)                                  //> res20: Int = 64
	 exp2(8)                                  //> res21: Int = 256
	 
	 //PROBLEM 5 -- tail recursion
	 def expTail(n: Int) =
	 {
	 		def helper(count: Int, result: Int): Int =
	 				if(n < count) result else helper(inc(count), mul(count, 2))
	 		helper(1, 1)
	 }                                        //> expTail: (n: Int)Int
	 expTail(0)                               //> res22: Int = 1
	 expTail(2)                               //> res23: Int = 4
	 expTail(3)                               //> res24: Int = 6
	 expTail(4)                               //> res25: Int = 8
	 expTail(6)                               //> res26: Int = 12
	 expTail(8)                               //> res27: Int = 16
	 
	 
	 
	 /**
	 *		PROBLEM 4
	 */
	 def hyperExp(n: Int): Int =
	 {
	 		if(isZero(n)) 1
	 		else hyperExp(n)
	 }                                        //> hyperExp: (n: Int)Int
	 
	 hyperExp(0)                              //> res28: Int = 1
	 //hyperExp(1)
	 //hyperExp(2)
	 //hyperExp(3)
	 //hyperExp(4)
	 
	 
	 //PROBLEM 5 -- tail recursion
	 def hyperExpTail(n: Int) =
	 {
	 			def helper(count: Int, result: Int): Int =
	 				if(n < count) result else helper(count + 1, exp2(n))
	 			helper(1, 1)
	 }                                        //> hyperExpTail: (n: Int)Int
	 hyperExpTail(0)                          //> res29: Int = 1
	 hyperExpTail(1)                          //> res30: Int = 2
	 hyperExpTail(2)                          //> res31: Int = 4
	 hyperExpTail(3)                          //> res32: Int = 8
	 hyperExpTail(4)                          //> res33: Int = 16
	 
	 
	 /**
	 * 		PROBLEM 9
	 */
	 def fib(n: Int): Int =
	 {
	 		if(isZero(n)) 1
	 		else if(n == 1) 1
	 		else fib(n-1) + fib(n-2)
	 }                                        //> fib: (n: Int)Int
	 
	 fib(0)                                   //> res34: Int = 1
	 fib(1)                                   //> res35: Int = 1
	 fib(2)                                   //> res36: Int = 2
	 fib(3)                                   //> res37: Int = 3
	 fib(4)                                   //> res38: Int = 5
	 fib(5)                                   //> res39: Int = 8
	 
	 
	 //tail recursive
	 def fibTail(n: Int) =
	 {
	 		def helper(first: Int, second: Int, count: Int): Int =
	 			if(count < 1) first else helper(second, first+second, count-1)
	 		helper(1, 1, n)
	 }                                        //> fibTail: (n: Int)Int
	 fibTail(0)                               //> res40: Int = 1
	 fibTail(1)                               //> res41: Int = 1
	 fibTail(2)                               //> res42: Int = 2
	 fibTail(3)                               //> res43: Int = 3
	 fibTail(4)                               //> res44: Int = 5
	 fibTail(5)                               //> res45: Int = 8
	 fibTail(6)                               //> res46: Int = 13
	 fibTail(7)                               //> res47: Int = 21
	 fibTail(8)                               //> res48: Int = 34
	 
	 
	 
	 /**
	 * 	PROBLEM 10
	 */
	
	 def choose(m: Int, n: Int): Int =
	 {
	 		if(m == n) 1
	 		else if (m < n) 0
	 		else if(n == 1) m
	 	
	 		else add(choose(dec(m), n), choose(dec(m), dec(n)))
	 }                                        //> choose: (m: Int, n: Int)Int
	 
	 choose(4,2)                              //> res49: Int = 6
	 choose(7,5)                              //> res50: Int = 21
	 choose(11,4)                             //> res51: Int = 330
}