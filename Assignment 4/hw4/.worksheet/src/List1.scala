object List1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(480); 
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
  };System.out.println("""sumOfOddCubesIter: (vals: List[Int])Int""");$skip(42); val res$0 = 
   
  sumOfOddCubesIter(List(1, 2, 3, 4));System.out.println("""res0: Int = """ + $show(res$0));$skip(85); val res$1 = 
  //answer = (1^3) + (3^3) = 1 + 27 = 28
  sumOfOddCubesIter(List(1, 2, 3, 4, 5, 6));System.out.println("""res1: Int = """ + $show(res$1));$skip(281); 
  //answer = (1^3) + (3^3) + (5^3) = 1 + 27 + 125 = 153
   
   
	  /*
	  			RECURSIVE
	  */
  
  def sumOfOddCubesRec (vals: List[Int]): Int =
  {
  		if (vals == Nil) 0
  		else (if(vals.head % 2 == 1) {vals.head * vals.head * vals.head} else 0) + sumOfOddCubesRec(vals.tail)
  };System.out.println("""sumOfOddCubesRec: (vals: List[Int])Int""");$skip(40); val res$2 = 
  
  sumOfOddCubesRec(List(1, 2, 3, 4));System.out.println("""res2: Int = """ + $show(res$2));$skip(81); val res$3 = 
  //answer = (1^3) + (3^3) = 1 + 27 = 28
  sumOfOddCubesRec(List(1, 2, 3, 4, 5));System.out.println("""res3: Int = """ + $show(res$3));$skip(99); val res$4 = 
  //answer = (1^3) + (3^3) + (5^3) = 1 + 27 + 125 = 153
  sumOfOddCubesRec(List(1, 2, 3, 4, 5, 6));System.out.println("""res4: Int = """ + $show(res$4));$skip(386); 
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
  };System.out.println("""sumOfOddCubesTail: (vals: List[Int])Int""");$skip(44); val res$5 = 
  
  
  sumOfOddCubesTail(List(1, 2, 3, 4));System.out.println("""res5: Int = """ + $show(res$5));$skip(85); val res$6 = 
  //answer = (1^3) + (3^3) = 1 + 27 = 28
  sumOfOddCubesTail(List(1, 2, 3, 4, 5, 6));System.out.println("""res6: Int = """ + $show(res$6));$skip(400); 
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
  };System.out.println("""sumOfOddCubesMap: (vals: List[Int])AnyVal""");$skip(40); val res$7 = 
  
  sumOfOddCubesMap(List(1, 2, 3, 4));System.out.println("""res7: AnyVal = """ + $show(res$7));$skip(75); val res$8 = 
  //answer = (1^3) + (3^3) = 1 + 27 = 28
  sumOfOddCubesMap(List(2, 4, 6));System.out.println("""res8: AnyVal = """ + $show(res$8));$skip(58); val res$9 = 
  //answer = 0
  sumOfOddCubesMap(List(1, 2, 3, 4, 5, 6));System.out.println("""res9: AnyVal = """ + $show(res$9));$skip(506); 
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
  };System.out.println("""sumOfSumsIter: [S](vals: List[S])Int""");$skip(127); 
  
  //helper method
  def sumsIter (vals: List[Int]) =
  {
  		var cnt = 0
  		for(num <- vals) {cnt = cnt + num}
  		cnt
  };System.out.println("""sumsIter: (vals: List[Int])Int""");$skip(50); val res$10 = 
  
  sumOfSumsIter(List(List (1, 4), List(2, 3)));System.out.println("""res10: Int = """ + $show(res$10));$skip(70); val res$11 = 
  //A = 10
  sumOfSumsIter(List(List (1, 4), List(2, 3), List(0, 5)));System.out.println("""res11: Int = """ + $show(res$11));$skip(64); val res$12 = 
  //A = 15
  sumOfSumsIter(List(List (1, 2, 3), List(4, 5, 6)));System.out.println("""res12: Int = """ + $show(res$12));$skip(70); val res$13 = 
  //A = 21
  sumOfSumsIter(List(List (2, 4, 6, 8), List(1, 3, 5, 7)));System.out.println("""res13: Int = """ + $show(res$13));$skip(174); 
  //A = 36
  
 
  
  /*
  			RECURSIVE
  */
  def sumOfSumsRec (vals: List[List[Int]]): Int =
  {
  		if (vals == Nil) 0 else sumRec(vals.head) + sumOfSumsRec(vals.tail)
  };System.out.println("""sumOfSumsRec: (vals: List[List[Int]])Int""");$skip(157); 
  
  //helper method to add lists
  def sumRec(vals: List[Int]): Int =
  {
	    if(vals.isEmpty) return 0
	    else return vals.head + sumRec(vals.tail)
  };System.out.println("""sumRec: (vals: List[Int])Int""");$skip(24); val res$14 = 
  sumRec(List(1,2,3,4));System.out.println("""res14: Int = """ + $show(res$14));$skip(23); val res$15 = 
	sumRec(List(5,10,15));System.out.println("""res15: Int = """ + $show(res$15));$skip(52); val res$16 = 
  
  
  sumOfSumsRec(List(List (1, 4), List(2, 3)));System.out.println("""res16: Int = """ + $show(res$16));$skip(63); val res$17 = 
  //A = 10
  sumOfSumsRec(List(List (1, 2, 3), List(4, 5, 6)));System.out.println("""res17: Int = """ + $show(res$17));$skip(69); val res$18 = 
  //A = 21
  sumOfSumsRec(List(List (2, 4, 6, 8), List(1, 3, 5, 7)));System.out.println("""res18: Int = """ + $show(res$18));$skip(270); 
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
	};System.out.println("""sumOfSumsTail: (vals: List[List[Int]])Int""");$skip(241); 
	
	//helper method to add list
	def sumTail(vals: List[Int]): Int =
	{
    def helper(result: Int, unseen: List[Int]): Int = {
       if (unseen == Nil) result else helper(result + unseen.head, unseen.tail)
    }
    
    helper(0, vals)
	};System.out.println("""sumTail: (vals: List[Int])Int""");$skip(24); val res$19 = 
	sumTail(List(1,2,3,4));System.out.println("""res19: Int = """ + $show(res$19));$skip(24); val res$20 = 
	sumTail(List(5,10,15));System.out.println("""res20: Int = """ + $show(res$20));$skip(60); val res$21 = 

  
  sumOfSumsTail(List(List (1, 4), List(2, 3)));System.out.println("""res21: Int = """ + $show(res$21));$skip(62); val res$22 =  //A = 10
  sumOfSumsTail(List(List (1, 2, 3), List(4, 5, 6)));System.out.println("""res22: Int = """ + $show(res$22));$skip(68); val res$23 =  //A = 21
  sumOfSumsTail(List(List (2, 4, 6, 8), List(1, 3, 5, 7)));System.out.println("""res23: Int = """ + $show(res$23));$skip(137);  //A = 36
  
  
  
  /*
  		MAP - FILTER - REDUCE
  */
  def sumOfSumsMap (vals: List[List[Int]]): Int =
  {
  		vals.map(sumsMap).reduce(_+_)
  };System.out.println("""sumOfSumsMap: (vals: List[List[Int]])Int""");$skip(88); 
  
  //helper method
  def sumsMap (vals: List[Int]): Int=
  {
  		vals.reduce(_+_)
  };System.out.println("""sumsMap: (vals: List[Int])Int""");$skip(58); val res$24 = 
  
  sumOfSumsMap(List(List (1, 4), List(2, 3)));System.out.println("""res24: Int = """ + $show(res$24));$skip(61); val res$25 =  //A = 10
  sumOfSumsMap(List(List (1, 2, 3), List(4, 5, 6)));System.out.println("""res25: Int = """ + $show(res$25));$skip(67); val res$26 =  //A = 21
  sumOfSumsMap(List(List (2, 4, 6, 8), List(1, 3, 5, 7)));System.out.println("""res26: Int = """ + $show(res$26));$skip(232);  //A = 36
  
  
  
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
	};System.out.println("""depth: (v: Any)Int""");$skip(41); val res$27 = 
	depth(List(List(List( 1, 2), List(3))));System.out.println("""res27: Int = """ + $show(res$27));$skip(45); val res$28 = 
	depth(List(List(List(3, 4, List(5, (6))))));System.out.println("""res28: Int = """ + $show(res$28));$skip(386); 

	
  
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
  };System.out.println("""satisfyPredicateIter: [T](vals: List[T], function: T => Boolean)Int""");$skip(71); val res$29 = 
  satisfyPredicateIter(List(1, 2, 3, 4, 5, 6), (n: Int) => n % 2 == 0);System.out.println("""res29: Int = """ + $show(res$29));$skip(85); val res$30 = 
  satisfyPredicateIter(List("Hi", "A", "Bye", "Hello"), (n: String) => n.length > 2);System.out.println("""res30: Int = """ + $show(res$30));$skip(242); 
  
  
  //Recursive
  def satisfyPredicateRec[T] (vals: List[T], function: (T => Boolean), position: Int = 0): Int =
  {
  		if (vals == Nil) 0
  		else (if(function(vals.head)) {1} else 0) + satisfyPredicateRec(vals.tail, function)
  		
  };System.out.println("""satisfyPredicateRec: [T](vals: List[T], function: T => Boolean, position: Int)Int""");$skip(70); val res$31 = 
  satisfyPredicateRec(List(1, 2, 3, 4, 5, 6), (n: Int) => n % 2 == 0);System.out.println("""res31: Int = """ + $show(res$31));$skip(84); val res$32 = 
  satisfyPredicateRec(List("Hi", "A", "Bye", "Hello"), (n: String) => n.length > 2);System.out.println("""res32: Int = """ + $show(res$32));$skip(295); 
  
  
  //Tail Recursive
  def satisfyPredicateTail[T] (vals: List[T], function: (T => Boolean)): Int = {
    def helper(result: Int, unseen: List[T]): Int = {
       if (unseen == Nil) result else helper(result + (if (function(unseen.head)) 1 else 0), unseen.tail)
    }
    helper(0, vals)
	};System.out.println("""satisfyPredicateTail: [T](vals: List[T], function: T => Boolean)Int""");$skip(70); val res$33 = 
	satisfyPredicateTail(List(1, 2, 3, 4, 5, 6), (n: Int) => n % 2 == 0);System.out.println("""res33: Int = """ + $show(res$33));$skip(85); val res$34 = 
  satisfyPredicateTail(List("Hi", "A", "Bye", "Hello"), (n: String) => n.length > 2);System.out.println("""res34: Int = """ + $show(res$34));$skip(198); 
                    
                    
	//Map-Filter-Reduce
  def satisfyPredicateFilter[T] (vals: List[T], function: (T => Boolean)): Int =
  {
  		vals.filter((n: T) => function(n)).length
  };System.out.println("""satisfyPredicateFilter: [T](vals: List[T], function: T => Boolean)Int""");$skip(76); val res$35 = 
  
  satisfyPredicateFilter(List(1, 2, 3, 4, 5, 6), (n: Int) => n % 2 == 0);System.out.println("""res35: Int = """ + $show(res$35));$skip(87); val res$36 = 
  satisfyPredicateFilter(List("Hi", "A", "Bye", "Hello"), (n: String) => n.length > 2);System.out.println("""res36: Int = """ + $show(res$36));$skip(390); 
                                                  
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
   };System.out.println("""allSatisfyIter: [T](vals: List[T], function: T => Boolean)Boolean""");$skip(65); val res$37 = 
   
    allSatisfyIter(List(2, 4, 6, 8), (n: Int) => n % 2 == 0);System.out.println("""res37: Boolean = """ + $show(res$37));$skip(61); val res$38 = 
    allSatisfyIter(List(2, 5, 6, 8), (n: Int) => n % 2 == 0);System.out.println("""res38: Boolean = """ + $show(res$38));$skip(76); val res$39 = 
    allSatisfyIter(List("Hi", "Bye", "Hello"), (n: String) => n.length > 2);System.out.println("""res39: Boolean = """ + $show(res$39));$skip(77); val res$40 = 
    allSatisfyIter(List("Hi", "Bye", "Hello"), (n: String) => n.length >= 2);System.out.println("""res40: Boolean = """ + $show(res$40));$skip(230); 
   
   //Recursive
   def allSatisfyRec[T](vals: List[T], function: (T => Boolean)): Boolean =
   {
   		if(vals == Nil) return true
   		else (if(function(vals.head)) {true} else false) && allSatisfyRec(vals.tail, function)
   };System.out.println("""allSatisfyRec: [T](vals: List[T], function: T => Boolean)Boolean""");$skip(64); val res$41 = 
   
    allSatisfyRec(List(2, 4, 6, 8), (n: Int) => n % 2 == 0);System.out.println("""res41: Boolean = """ + $show(res$41));$skip(60); val res$42 = 
    allSatisfyRec(List(2, 5, 6, 8), (n: Int) => n % 2 == 0);System.out.println("""res42: Boolean = """ + $show(res$42));$skip(75); val res$43 = 
    allSatisfyRec(List("Hi", "Bye", "Hello"), (n: String) => n.length > 2);System.out.println("""res43: Boolean = """ + $show(res$43));$skip(76); val res$44 = 
    allSatisfyRec(List("Hi", "Bye", "Hello"), (n: String) => n.length >= 2);System.out.println("""res44: Boolean = """ + $show(res$44));$skip(345); 
                                                  
    //Tail Recursive
   def allSatisfyTail[T](vals: List[T], function: (T => Boolean)): Boolean =
   {
	    def helper(result: Boolean, unseen: List[T]): Boolean = {
	       if (unseen == Nil) result else helper(result && function(unseen.head), unseen.tail)
	    }
	    helper(true, vals)
   };System.out.println("""allSatisfyTail: [T](vals: List[T], function: T => Boolean)Boolean""");$skip(65); val res$45 = 
   
    allSatisfyTail(List(2, 4, 6, 8), (n: Int) => n % 2 == 0);System.out.println("""res45: Boolean = """ + $show(res$45));$skip(61); val res$46 = 
    allSatisfyTail(List(2, 5, 6, 8), (n: Int) => n % 2 == 0);System.out.println("""res46: Boolean = """ + $show(res$46));$skip(76); val res$47 = 
    allSatisfyTail(List("Hi", "Bye", "Hello"), (n: String) => n.length > 2);System.out.println("""res47: Boolean = """ + $show(res$47));$skip(77); val res$48 = 
    allSatisfyTail(List("Hi", "Bye", "Hello"), (n: String) => n.length >= 2);System.out.println("""res48: Boolean = """ + $show(res$48));$skip(188); 
   
   
   
   //Map-Reduce-Filter
   def allSatisfyFilter[T](vals: List[T], function: (T => Boolean)): Boolean =
   {
   		(vals.filter((n: T) => function(n)).length) == vals.length
   };System.out.println("""allSatisfyFilter: [T](vals: List[T], function: T => Boolean)Boolean""");$skip(67); val res$49 = 
   
    allSatisfyFilter(List(2, 4, 6, 8), (n: Int) => n % 2 == 0);System.out.println("""res49: Boolean = """ + $show(res$49));$skip(63); val res$50 = 
    allSatisfyFilter(List(2, 5, 6, 8), (n: Int) => n % 2 == 0);System.out.println("""res50: Boolean = """ + $show(res$50));$skip(78); val res$51 = 
    allSatisfyFilter(List("Hi", "Bye", "Hello"), (n: String) => n.length > 2);System.out.println("""res51: Boolean = """ + $show(res$51));$skip(79); val res$52 = 
    allSatisfyFilter(List("Hi", "Bye", "Hello"), (n: String) => n.length >= 2);System.out.println("""res52: Boolean = """ + $show(res$52));$skip(419); 
                                                  
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
   };System.out.println("""anySatisfyIter: [T](vals: List[T], function: T => Boolean)Boolean""");$skip(65); val res$53 = 
   
    anySatisfyIter(List(1, 2, 3, 5), (n: Int) => n % 2 == 0);System.out.println("""res53: Boolean = """ + $show(res$53));$skip(61); val res$54 = 
    anySatisfyIter(List(1, 3, 5, 7), (n: Int) => n % 2 == 0);System.out.println("""res54: Boolean = """ + $show(res$54));$skip(76); val res$55 = 
    anySatisfyIter(List("Hi", "Bye", "Hello"), (n: String) => n.length < 2);System.out.println("""res55: Boolean = """ + $show(res$55));$skip(77); val res$56 = 
    anySatisfyIter(List("Hi", "Bye", "Hello"), (n: String) => n.length <= 2);System.out.println("""res56: Boolean = """ + $show(res$56));$skip(243); 
   
   /*
  		 Recursive
   */
   def anySatisfyRec[T](vals: List[T], function: (T => Boolean)): Boolean =
   {
   		if(vals == Nil) return false
   		else (if(function(vals.head)) {true} else false) || anySatisfyRec(vals.tail, function)
   };System.out.println("""anySatisfyRec: [T](vals: List[T], function: T => Boolean)Boolean""");$skip(64); val res$57 = 
   
    anySatisfyRec(List(1, 2, 3, 5), (n: Int) => n % 2 == 0);System.out.println("""res57: Boolean = """ + $show(res$57));$skip(60); val res$58 = 
    anySatisfyRec(List(1, 3, 5, 7), (n: Int) => n % 2 == 0);System.out.println("""res58: Boolean = """ + $show(res$58));$skip(75); val res$59 = 
    anySatisfyRec(List("Hi", "Bye", "Hello"), (n: String) => n.length < 2);System.out.println("""res59: Boolean = """ + $show(res$59));$skip(76); val res$60 = 
    anySatisfyRec(List("Hi", "Bye", "Hello"), (n: String) => n.length <= 2);System.out.println("""res60: Boolean = """ + $show(res$60));$skip(361); 
                                                  
    /*
    		Tail Recursive
    	*/
   def anySatisfyTail[T](vals: List[T], function: (T => Boolean)): Boolean =
   {
	    def helper(result: Boolean, unseen: List[T]): Boolean = {
	       if (unseen == Nil) result else helper(result || function(unseen.head), unseen.tail)
	    }
	    helper(false, vals)
   };System.out.println("""anySatisfyTail: [T](vals: List[T], function: T => Boolean)Boolean""");$skip(65); val res$61 = 
   
    anySatisfyTail(List(1, 2, 3, 5), (n: Int) => n % 2 == 0);System.out.println("""res61: Boolean = """ + $show(res$61));$skip(61); val res$62 = 
    anySatisfyTail(List(1, 3, 5, 7), (n: Int) => n % 2 == 0);System.out.println("""res62: Boolean = """ + $show(res$62));$skip(76); val res$63 = 
    anySatisfyTail(List("Hi", "Bye", "Hello"), (n: String) => n.length < 2);System.out.println("""res63: Boolean = """ + $show(res$63));$skip(77); val res$64 = 
    anySatisfyTail(List("Hi", "Bye", "Hello"), (n: String) => n.length <= 2);System.out.println("""res64: Boolean = """ + $show(res$64));$skip(190); 
   
   
   
   /*
   		Map-Reduce-Filter
   	*/
   def anySatisfyFilter[T](vals: List[T], function: (T => Boolean)): Boolean =
   {
   		(vals.filter((n: T) => function(n))).length > 0
   };System.out.println("""anySatisfyFilter: [T](vals: List[T], function: T => Boolean)Boolean""");$skip(67); val res$65 = 
   
    anySatisfyFilter(List(1, 2, 3, 5), (n: Int) => n % 2 == 0);System.out.println("""res65: Boolean = """ + $show(res$65));$skip(63); val res$66 = 
    anySatisfyFilter(List(1, 3, 5, 7), (n: Int) => n % 2 == 0);System.out.println("""res66: Boolean = """ + $show(res$66));$skip(78); val res$67 = 
    anySatisfyFilter(List("Hi", "Bye", "Hello"), (n: String) => n.length < 2);System.out.println("""res67: Boolean = """ + $show(res$67));$skip(79); val res$68 = 
    anySatisfyFilter(List("Hi", "Bye", "Hello"), (n: String) => n.length <= 2);System.out.println("""res68: Boolean = """ + $show(res$68));$skip(384); 
     
     
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
    };System.out.println("""sorted: (vals: List[Int])Boolean""");$skip(31); val res$69 = 
    
    sorted(List(1,2,3,4));System.out.println("""res69: Boolean = """ + $show(res$69));$skip(26); val res$70 = 
    sorted(List(4,3,2,1));System.out.println("""res70: Boolean = """ + $show(res$70));$skip(26); val res$71 = 
    sorted(List(1,2,4,3));System.out.println("""res71: Boolean = """ + $show(res$71));$skip(160); 
    
    
    /**
    *	PROBLEM 13
    * Creating streams
    */

       //An infinitely long stream of 1's
       def makeOnes(): Stream[Int] = 1 #:: makeOnes;System.out.println("""makeOnes: ()Stream[Int]""");$skip(27); 
       val ones = makeOnes;System.out.println("""ones  : Stream[Int] = """ + $show(ones ));$skip(15); val res$72 = 
       ones(5);System.out.println("""res72: Int = """ + $show(res$72));$skip(12); val res$73 = 
       ones;System.out.println("""res73: Stream[Int] = """ + $show(res$73));$skip(134); 
      

      //The stream of all non-negative integers
      def makeNums(first: Int = 0): Stream[Int] = first #:: makeNums(first+1);System.out.println("""makeNums: (first: Int)Stream[Int]""");$skip(29); 
       val nums = makeNums();System.out.println("""nums  : Stream[Int] = """ + $show(nums ));$skip(15); val res$74 = 
       nums(5);System.out.println("""res74: Int = """ + $show(res$74));$skip(12); val res$75 = 
       nums;System.out.println("""res75: Stream[Int] = """ + $show(res$75));$skip(140); 

      //The stream of all non-negative even integers
      def makeEvenNums(first: Int = 0): Stream[Int] = first #:: makeEvenNums(first+2);System.out.println("""makeEvenNums: (first: Int)Stream[Int]""");$skip(37); 
       val evenNums = makeEvenNums();System.out.println("""evenNums  : Stream[Int] = """ + $show(evenNums ));$skip(19); val res$76 = 
       evenNums(5);System.out.println("""res76: Int = """ + $show(res$76));$skip(16); val res$77 = 
       evenNums;System.out.println("""res77: Stream[Int] = """ + $show(res$77));$skip(140); 

			//The stream of all squares of integers
			def makeSquareNums(first: Int = 1): Stream[Int] = (first* first) #:: makeSquareNums(first+1);System.out.println("""makeSquareNums: (first: Int)Stream[Int]""");$skip(41); 
       val squareNums = makeSquareNums();System.out.println("""squareNums  : Stream[Int] = """ + $show(squareNums ));$skip(21); val res$78 = 
       squareNums(5);System.out.println("""res78: Int = """ + $show(res$78));$skip(18); val res$79 = 
       squareNums;System.out.println("""res79: Stream[Int] = """ + $show(res$79))}

 
}
