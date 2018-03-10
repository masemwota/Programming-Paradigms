object List1 {
	/**
	* List Processing 1
	* 1, 2, 3, 6, 7, 8, 10, 13
	*/
  
 
  /**
  * PROBLEM 1
  * Write a function that computes the sum of cubes of all
  * odd numbers occurring in a list of integers.
  *
  * NOTE: 4 ways: iterative, recursive, tail-recursive, map-filter-reduce
  */
  def sumOfOddCubesIter (vals: List[Int]) =
  {
  			var count = 0;
			for(i <- 0 to vals.length-1)
			{
				if(vals(i) % 2 == 1) count = count + vals(i) * vals(i) * vals(i)
			}
			count
  }                                               //> sumOfOddCubesIter: (vals: List[Int])Int
   
  sumOfOddCubesIter(List(1, 2, 3, 4))             //> res0: Int = 28
  //answer = (1^3) + (3^3) = 1 + 27 = 28
  sumOfOddCubesIter(List(1, 2, 3, 4, 5, 6))       //> res1: Int = 153
  //answer = (1^3) + (3^3) + (5^3) = 1 + 27 + 125 = 153
   
   
	  /*
	  			RECURSIVE
	  */
  
  def sumOfOddCubesRec (vals: List[Int]): Int =
  {
  		if (vals == Nil) 0
  		else (if(vals.head % 2 == 1) {vals.head * vals.head * vals.head} else 0) + sumOfOddCubesRec(vals.tail)
  }                                               //> sumOfOddCubesRec: (vals: List[Int])Int
  
  sumOfOddCubesRec(List(1, 2, 3, 4))              //> res2: Int = 28
  //answer = (1^3) + (3^3) = 1 + 27 = 28
  sumOfOddCubesRec(List(1, 2, 3, 4, 5))           //> res3: Int = 153
  //answer = (1^3) + (3^3) + (5^3) = 1 + 27 + 125 = 153
  sumOfOddCubesRec(List(1, 2, 3, 4, 5, 6))        //> res4: Int = 153
  //answer = (1^3) + (3^3) + (5^3) = 1 + 27 + 125 = 153
  
  
  /*
  			TAIL RECURSIVE
  */
  def sumOfOddCubesTail (vals: List[Int]): Int =
  {
  		def helper(result: Int, unseen: List[Int]): Int =
  		{
  			if(unseen == Nil) result
  			else helper(result + (if(unseen.head % 2 == 1) {unseen.head * unseen.head * unseen.head} else 0), unseen.tail)
  		}
  		
  		helper(0, vals)
  }                                               //> sumOfOddCubesTail: (vals: List[Int])Int
  
  
  sumOfOddCubesTail(List(1, 2, 3, 4))             //> res5: Int = 28
  //answer = (1^3) + (3^3) = 1 + 27 = 28
  sumOfOddCubesTail(List(1, 2, 3, 4, 5, 6))       //> res6: Int = 153
  //answer = (1^3) + (3^3) + (5^3) = 1 + 27 + 125 = 153
   
  /*
  			MAP - FILTER - REDUCE
  */
  
  def sumOfOddCubesMap (vals: List[Int]) =
  {
  			try
  			{
  				vals.filter((n: Int) => n % 2 == 1).map((n: Int) => n * n * n).reduce(_+_)
  			}
  			catch //(UnsupportedOperationException x)
  			{
  				 case e:UnsupportedOperationException => println("There are no even numbers")
  			}
  }                                               //> sumOfOddCubesMap: (vals: List[Int])AnyVal
  
  sumOfOddCubesMap(List(1, 2, 3, 4))              //> res7: AnyVal = 28
  //answer = (1^3) + (3^3) = 1 + 27 = 28
  sumOfOddCubesMap(List(2, 4, 6))                 //> There are no even numbers
                                                  //| res8: AnyVal = ()
  //answer = 0
  sumOfOddCubesMap(List(1, 2, 3, 4, 5, 6))        //> res9: AnyVal = 153
  //answer = (1^3) + (3^3) + (5^3) = 1 + 27 + 125 = 153
  
  
   
  /**
  *	PROBLEM 2
  * Write a function that computes the sum of numbers
  * in a list of lists of numbers
  *
  * NOTE: 4 ways: iterative, recursive, tail-recursive, map-filter-reduce
  */
  
  /*
  			ITERATIVE
  */
  def sumOfSumsIter[S] (vals: List[S]) =
  {
  		var sum = 0
  		for(nums <- vals)
  		{
  				val isInt = nums.isInstanceOf[List[Int]]
  				if(isInt) sum = sum + sumsIter(nums.asInstanceOf[List[Int]])
  		}
  		sum
  }                                               //> sumOfSumsIter: [S](vals: List[S])Int
  
  //helper method
  def sumsIter (vals: List[Int]) =
  {
  		var cnt = 0
  		for(num <- vals) {cnt = cnt + num}
  		cnt
  }                                               //> sumsIter: (vals: List[Int])Int
  
  sumOfSumsIter(List(List (1, 4), List(2, 3)))    //> res10: Int = 10
  //A = 10
  sumOfSumsIter(List(List (1, 4), List(2, 3), List(0, 5)))
                                                  //> res11: Int = 15
  //A = 15
  sumOfSumsIter(List(List (1, 2, 3), List(4, 5, 6)))
                                                  //> res12: Int = 21
  //A = 21
  sumOfSumsIter(List(List (2, 4, 6, 8), List(1, 3, 5, 7)))
                                                  //> res13: Int = 36
  //A = 36
  
 
  
  /*
  			RECURSIVE
  */
  def sumOfSumsRec (vals: List[List[Int]]): Int =
  {
  		if (vals == Nil) 0 else sumRec(vals.head) + sumOfSumsRec(vals.tail)
  }                                               //> sumOfSumsRec: (vals: List[List[Int]])Int
  
  //helper method to add lists
  def sumRec(vals: List[Int]): Int =
  {
	    if(vals.isEmpty) return 0
	    else return vals.head + sumRec(vals.tail)
  }                                               //> sumRec: (vals: List[Int])Int
  sumRec(List(1,2,3,4))                           //> res14: Int = 10
	sumRec(List(5,10,15))                     //> res15: Int = 30
  
  
  sumOfSumsRec(List(List (1, 4), List(2, 3)))     //> res16: Int = 10
  //A = 10
  sumOfSumsRec(List(List (1, 2, 3), List(4, 5, 6)))
                                                  //> res17: Int = 21
  //A = 21
  sumOfSumsRec(List(List (2, 4, 6, 8), List(1, 3, 5, 7)))
                                                  //> res18: Int = 36
  //A = 36
  
  
  
  /*
  			TAIL - RECURSIVE
  */
  
  def sumOfSumsTail(vals: List[List[Int]]) = {
		
		def helper(count: Int, result: Int): Int =
			if (vals.length-1 < count) result
			else {
				helper(count+1, result + sumTail(vals(count)))
			}
		helper(0,0)
	}                                         //> sumOfSumsTail: (vals: List[List[Int]])Int
	
	//helper method to add list
	def sumTail(vals: List[Int]): Int =
	{
    def helper(result: Int, unseen: List[Int]): Int = {
       if (unseen == Nil) result else helper(result + unseen.head, unseen.tail)
    }
    
    helper(0, vals)
	}                                         //> sumTail: (vals: List[Int])Int
	sumTail(List(1,2,3,4))                    //> res19: Int = 10
	sumTail(List(5,10,15))                    //> res20: Int = 30

  
  sumOfSumsTail(List(List (1, 4), List(2, 3))) //A = 10
                                                  //> res21: Int = 10
  sumOfSumsTail(List(List (1, 2, 3), List(4, 5, 6))) //A = 21
                                                  //> res22: Int = 21
  sumOfSumsTail(List(List (2, 4, 6, 8), List(1, 3, 5, 7))) //A = 36
                                                  //> res23: Int = 36
  
  
  
  /*
  		MAP - FILTER - REDUCE
  */
  def sumOfSumsMap (vals: List[List[Int]]): Int =
  {
  		vals.map(sumsMap).reduce(_+_)
  }                                               //> sumOfSumsMap: (vals: List[List[Int]])Int
  
  //helper method
  def sumsMap (vals: List[Int]): Int=
  {
  		vals.reduce(_+_)
  }                                               //> sumsMap: (vals: List[Int])Int
  
  sumOfSumsMap(List(List (1, 4), List(2, 3))) //A = 10
                                                  //> res24: Int = 10
  sumOfSumsMap(List(List (1, 2, 3), List(4, 5, 6))) //A = 21
                                                  //> res25: Int = 21
  sumOfSumsMap(List(List (2, 4, 6, 8), List(1, 3, 5, 7))) //A = 36
                                                  //> res26: Int = 36
  
  
  
  /**
  *	PROBLEM 3
  * Write a function that returns the depth of a list of nested lists
  */
	def depth(v: Any): Int = {
		v match {
			case Nil => 0
			case h::t => math.max(depth(h) + 1, depth(t))
			case _ => 0
		}
	}                                         //> depth: (v: Any)Int
	depth(List(List(List( 1, 2), List(3))))   //> res27: Int = 3
	depth(List(List(List(3, 4, List(5, (6))))))
                                                  //> res28: Int = 4

	
  
  /**
  *	PROBLEM 6
  * Write a function that returns the number of elements in a list that satisfy a given predicate.
  * (The predicate is a parameter of type T=>Boolean.)
  */
  
  //Iterative
  def satisfyPredicateIter[T] (vals: List[T], function: (T => Boolean)): Int =
  {
  		var cnt = 0
  		for(item <- vals)
  		{
  				if(function(item)) cnt = cnt + 1
  		}
  		cnt
  }                                               //> satisfyPredicateIter: [T](vals: List[T], function: T => Boolean)Int
  satisfyPredicateIter(List(1, 2, 3, 4, 5, 6), (n: Int) => n % 2 == 0)
                                                  //> res29: Int = 3
  satisfyPredicateIter(List("Hi", "A", "Bye", "Hello"), (n: String) => n.length > 2)
                                                  //> res30: Int = 2
  
  
  //Recursive
  def satisfyPredicateRec[T] (vals: List[T], function: (T => Boolean), position: Int = 0): Int =
  {
  		if (vals == Nil) 0
  		else (if(function(vals.head)) {1} else 0) + satisfyPredicateRec(vals.tail, function)
  		
  }                                               //> satisfyPredicateRec: [T](vals: List[T], function: T => Boolean, position: I
                                                  //| nt)Int
  satisfyPredicateRec(List(1, 2, 3, 4, 5, 6), (n: Int) => n % 2 == 0)
                                                  //> res31: Int = 3
  satisfyPredicateRec(List("Hi", "A", "Bye", "Hello"), (n: String) => n.length > 2)
                                                  //> res32: Int = 2
  
  
  //Tail Recursive
  def satisfyPredicateTail[T] (vals: List[T], function: (T => Boolean)): Int = {
    def helper(result: Int, unseen: List[T]): Int = {
       if (unseen == Nil) result else helper(result + (if (function(unseen.head)) 1 else 0), unseen.tail)
    }
    helper(0, vals)
	}                                         //> satisfyPredicateTail: [T](vals: List[T], function: T => Boolean)Int
	satisfyPredicateTail(List(1, 2, 3, 4, 5, 6), (n: Int) => n % 2 == 0)
                                                  //> res33: Int = 3
  satisfyPredicateTail(List("Hi", "A", "Bye", "Hello"), (n: String) => n.length > 2)
                                                  //> res34: Int = 2
                    
                    
	//Map-Filter-Reduce
  def satisfyPredicateFilter[T] (vals: List[T], function: (T => Boolean)): Int =
  {
  		vals.filter((n: T) => function(n)).length
  }                                               //> satisfyPredicateFilter: [T](vals: List[T], function: T => Boolean)Int
  
  satisfyPredicateFilter(List(1, 2, 3, 4, 5, 6), (n: Int) => n % 2 == 0)
                                                  //> res35: Int = 3
  satisfyPredicateFilter(List("Hi", "A", "Bye", "Hello"), (n: String) => n.length > 2)
                                                  //> res36: Int = 2
                                                  
   /**
   *		PROBLEM 7
   * 	Write a function that returns true if all elements in a list satisfy a given predicate.
   */
   
   //iterative
   def allSatisfyIter[T](vals: List[T], function: (T => Boolean)): Boolean =
   {
   		var all = true
   		
   		for(elem <- vals)
   		{
   				if(!function(elem)) all = false
   		}
   	all
   }                                              //> allSatisfyIter: [T](vals: List[T], function: T => Boolean)Boolean
   
    allSatisfyIter(List(2, 4, 6, 8), (n: Int) => n % 2 == 0)
                                                  //> res37: Boolean = true
    allSatisfyIter(List(2, 5, 6, 8), (n: Int) => n % 2 == 0)
                                                  //> res38: Boolean = false
    allSatisfyIter(List("Hi", "Bye", "Hello"), (n: String) => n.length > 2)
                                                  //> res39: Boolean = false
    allSatisfyIter(List("Hi", "Bye", "Hello"), (n: String) => n.length >= 2)
                                                  //> res40: Boolean = true
   
   //Recursive
   def allSatisfyRec[T](vals: List[T], function: (T => Boolean)): Boolean =
   {
   		if(vals == Nil) return true
   		else (if(function(vals.head)) {true} else false) && allSatisfyRec(vals.tail, function)
   }                                              //> allSatisfyRec: [T](vals: List[T], function: T => Boolean)Boolean
   
    allSatisfyRec(List(2, 4, 6, 8), (n: Int) => n % 2 == 0)
                                                  //> res41: Boolean = true
    allSatisfyRec(List(2, 5, 6, 8), (n: Int) => n % 2 == 0)
                                                  //> res42: Boolean = false
    allSatisfyRec(List("Hi", "Bye", "Hello"), (n: String) => n.length > 2)
                                                  //> res43: Boolean = false
    allSatisfyRec(List("Hi", "Bye", "Hello"), (n: String) => n.length >= 2)
                                                  //> res44: Boolean = true
                                                  
    //Tail Recursive
   def allSatisfyTail[T](vals: List[T], function: (T => Boolean)): Boolean =
   {
	    def helper(result: Boolean, unseen: List[T]): Boolean = {
	       if (unseen == Nil) result else helper(result && function(unseen.head), unseen.tail)
	    }
	    helper(true, vals)
   }                                              //> allSatisfyTail: [T](vals: List[T], function: T => Boolean)Boolean
   
    allSatisfyTail(List(2, 4, 6, 8), (n: Int) => n % 2 == 0)
                                                  //> res45: Boolean = true
    allSatisfyTail(List(2, 5, 6, 8), (n: Int) => n % 2 == 0)
                                                  //> res46: Boolean = false
    allSatisfyTail(List("Hi", "Bye", "Hello"), (n: String) => n.length > 2)
                                                  //> res47: Boolean = false
    allSatisfyTail(List("Hi", "Bye", "Hello"), (n: String) => n.length >= 2)
                                                  //> res48: Boolean = true
   
   
   
   //Map-Reduce-Filter
   def allSatisfyFilter[T](vals: List[T], function: (T => Boolean)): Boolean =
   {
   		(vals.filter((n: T) => function(n)).length) == vals.length
   }                                              //> allSatisfyFilter: [T](vals: List[T], function: T => Boolean)Boolean
   
    allSatisfyFilter(List(2, 4, 6, 8), (n: Int) => n % 2 == 0)
                                                  //> res49: Boolean = true
    allSatisfyFilter(List(2, 5, 6, 8), (n: Int) => n % 2 == 0)
                                                  //> res50: Boolean = false
    allSatisfyFilter(List("Hi", "Bye", "Hello"), (n: String) => n.length > 2)
                                                  //> res51: Boolean = false
    allSatisfyFilter(List("Hi", "Bye", "Hello"), (n: String) => n.length >= 2)
                                                  //> res52: Boolean = true
                                                  
     /**
     * 	PROBLEM 8
     * 	Write a function that returns true if any element in a list satisfies a given predicate.
     */
     
     /*
     		iterative
     	*/
   def anySatisfyIter[T](vals: List[T], function: (T => Boolean)): Boolean =
   {
   		var any = false
   		
   		for(elem <- vals)
   		{
   				if(function(elem)) any = true
   		}
   	any
   }                                              //> anySatisfyIter: [T](vals: List[T], function: T => Boolean)Boolean
   
    anySatisfyIter(List(1, 2, 3, 5), (n: Int) => n % 2 == 0)
                                                  //> res53: Boolean = true
    anySatisfyIter(List(1, 3, 5, 7), (n: Int) => n % 2 == 0)
                                                  //> res54: Boolean = false
    anySatisfyIter(List("Hi", "Bye", "Hello"), (n: String) => n.length < 2)
                                                  //> res55: Boolean = false
    anySatisfyIter(List("Hi", "Bye", "Hello"), (n: String) => n.length <= 2)
                                                  //> res56: Boolean = true
   
   /*
  		 Recursive
   */
   def anySatisfyRec[T](vals: List[T], function: (T => Boolean)): Boolean =
   {
   		if(vals == Nil) return false
   		else (if(function(vals.head)) {true} else false) || anySatisfyRec(vals.tail, function)
   }                                              //> anySatisfyRec: [T](vals: List[T], function: T => Boolean)Boolean
   
    anySatisfyRec(List(1, 2, 3, 5), (n: Int) => n % 2 == 0)
                                                  //> res57: Boolean = true
    anySatisfyRec(List(1, 3, 5, 7), (n: Int) => n % 2 == 0)
                                                  //> res58: Boolean = false
    anySatisfyRec(List("Hi", "Bye", "Hello"), (n: String) => n.length < 2)
                                                  //> res59: Boolean = false
    anySatisfyRec(List("Hi", "Bye", "Hello"), (n: String) => n.length <= 2)
                                                  //> res60: Boolean = true
                                                  
    /*
    		Tail Recursive
    	*/
   def anySatisfyTail[T](vals: List[T], function: (T => Boolean)): Boolean =
   {
	    def helper(result: Boolean, unseen: List[T]): Boolean = {
	       if (unseen == Nil) result else helper(result || function(unseen.head), unseen.tail)
	    }
	    helper(false, vals)
   }                                              //> anySatisfyTail: [T](vals: List[T], function: T => Boolean)Boolean
   
    anySatisfyTail(List(1, 2, 3, 5), (n: Int) => n % 2 == 0)
                                                  //> res61: Boolean = true
    anySatisfyTail(List(1, 3, 5, 7), (n: Int) => n % 2 == 0)
                                                  //> res62: Boolean = false
    anySatisfyTail(List("Hi", "Bye", "Hello"), (n: String) => n.length < 2)
                                                  //> res63: Boolean = false
    anySatisfyTail(List("Hi", "Bye", "Hello"), (n: String) => n.length <= 2)
                                                  //> res64: Boolean = true
   
   
   
   /*
   		Map-Reduce-Filter
   	*/
   def anySatisfyFilter[T](vals: List[T], function: (T => Boolean)): Boolean =
   {
   		(vals.filter((n: T) => function(n))).length > 0
   }                                              //> anySatisfyFilter: [T](vals: List[T], function: T => Boolean)Boolean
   
    anySatisfyFilter(List(1, 2, 3, 5), (n: Int) => n % 2 == 0)
                                                  //> res65: Boolean = true
    anySatisfyFilter(List(1, 3, 5, 7), (n: Int) => n % 2 == 0)
                                                  //> res66: Boolean = false
    anySatisfyFilter(List("Hi", "Bye", "Hello"), (n: String) => n.length < 2)
                                                  //> res67: Boolean = false
    anySatisfyFilter(List("Hi", "Bye", "Hello"), (n: String) => n.length <= 2)
                                                  //> res68: Boolean = true
     
     
    /**
    *	PROBLEM 10
    * 	Write a function that returns true if a given list of integers is sorted (in ascending order).
    */
    def sorted(vals: List[Int]): Boolean =
    {
    		var sorted = true;
    		for(i <- 0 to vals.length-2)
    		{
    				val cur = vals(i)
    				val next = vals(i+1)
    				if (next < cur) sorted = false
    		}
    		sorted
    }                                             //> sorted: (vals: List[Int])Boolean
    
    sorted(List(1,2,3,4))                         //> res69: Boolean = true
    sorted(List(4,3,2,1))                         //> res70: Boolean = false
    sorted(List(1,2,4,3))                         //> res71: Boolean = false
    
    
    /**
    *	PROBLEM 13
    * Creating streams
    */

       //An infinitely long stream of 1's
       def makeOnes(): Stream[Int] = 1 #:: makeOnes
                                                  //> makeOnes: ()Stream[Int]
       val ones = makeOnes                        //> ones  : Stream[Int] = Stream(1, ?)
       ones(5)                                    //> res72: Int = 1
       ones                                       //> res73: Stream[Int] = Stream(1, 1, 1, 1, 1, 1, ?)
      

      //The stream of all non-negative integers
      def makeNums(first: Int = 0): Stream[Int] = first #:: makeNums(first+1)
                                                  //> makeNums: (first: Int)Stream[Int]
       val nums = makeNums()                      //> nums  : Stream[Int] = Stream(0, ?)
       nums(5)                                    //> res74: Int = 5
       nums                                       //> res75: Stream[Int] = Stream(0, 1, 2, 3, 4, 5, ?)

      //The stream of all non-negative even integers
      def makeEvenNums(first: Int = 0): Stream[Int] = first #:: makeEvenNums(first+2)
                                                  //> makeEvenNums: (first: Int)Stream[Int]
       val evenNums = makeEvenNums()              //> evenNums  : Stream[Int] = Stream(0, ?)
       evenNums(5)                                //> res76: Int = 10
       evenNums                                   //> res77: Stream[Int] = Stream(0, 2, 4, 6, 8, 10, ?)

			//The stream of all squares of integers
			def makeSquareNums(first: Int = 1): Stream[Int] = (first* first) #:: makeSquareNums(first+1)
                                                  //> makeSquareNums: (first: Int)Stream[Int]
       val squareNums = makeSquareNums()          //> squareNums  : Stream[Int] = Stream(1, ?)
       squareNums(5)                              //> res78: Int = 36
       squareNums                                 //> res79: Stream[Int] = Stream(1, 4, 9, 16, 25, 36, ?)

 
}