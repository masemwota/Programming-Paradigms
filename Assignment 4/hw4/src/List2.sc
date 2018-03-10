object List2 {
  /**
  *		LIST PROCESSING II
  */
  
  /**
  * 	PROBLEM 1
  */
  
  //avg of scores
  def avg(scores: List[Double]): Double =
  {
  		scores.reduce(_+_) / scores.length
  }                                               //> avg: (scores: List[Double])Double
  
	//list of averages for each student
	def avgAvg(scores: List[List[Double]]): List[Double] =
	{
		scores.map((n: List[Double]) => avg(n))
	}                                         //> avgAvg: (scores: List[List[Double]])List[Double]
   
	//list of positions in the list with avg >= 70
	def passing(scores: List[List[Double]]): List[Int] =
	{
		val averages = avgAvg(scores)
		var pass: List[Int] = List()
		for(i <- 0 until averages.length)
		{
				if(averages(i) >= 70) pass = pass :+ i
		}
		pass
	}                                         //> passing: (scores: List[List[Double]])List[Int]
	
	//sum of scores
	def sum(scores: List[Double]): Double =
  {
  		scores.reduce(_+_)
  }                                               //> sum: (scores: List[Double])Double
  
	//sum of sums of all scores
	def sumSums(scores: List[List[Double]]):Double =
	{
			scores.map((n: List[Double]) => sum(n)).reduce(_+_)
	}                                         //> sumSums: (scores: List[List[Double]])Double
	
	
	/**
	* testing
	*/
	var cs152: List[List[Double]] = List(List(93, 89, 90), List(64, 76, 68), List(88, 82, 78))
                                                  //> cs152  : List[List[Double]] = List(List(93.0, 89.0, 90.0), List(64.0, 76.0, 
                                                  //| 68.0), List(88.0, 82.0, 78.0))
	
	avg(cs152(0))                             //> res0: Double = 90.66666666666667
	avg(cs152(1))                             //> res1: Double = 69.33333333333333
	avg(cs152(2))                             //> res2: Double = 82.66666666666667
	
	avgAvg(cs152)                             //> res3: List[Double] = List(90.66666666666667, 69.33333333333333, 82.66666666
                                                  //| 666667)
	
	passing(cs152)                            //> res4: List[Int] = List(0, 2)
	sumSums(cs152)                            //> res5: Double = 728.0
	
	
	/**
	*	PROBLEM 2
	* Spellcheck in dictionary
	*/
	
	//all words in doc not in dictionary
	def spellCheck(doc: List[String], dictionary: List[String]): List[String] =
	{
		var absent: List[String] = List()
		for(word <- doc)
		{
			if(!dictionary.contains(word)) absent = absent :+ word
		}
		absent
	}                                         //> spellCheck: (doc: List[String], dictionary: List[String])List[String]
	
	//testing
	val dictionary = List("hello", "there", "partner", "all")
                                                  //> dictionary  : List[String] = List(hello, there, partner, all)
	val doc = List("howdy", "there", "partner", "yall")
                                                  //> doc  : List[String] = List(howdy, there, partner, yall)
 	spellCheck(doc, dictionary)               //> res6: List[String] = List(howdy, yall)
	
	
	/**
	*	PROBLEM 3
	* 	Spellcheck using map, filter, reduce
	*/
	def spellCheckSmart(doc: List[String], dictionary: List[String]): List[String] =
	{
		doc.filter((n: String) => !dictionary.contains(n))
	}                                         //> spellCheckSmart: (doc: List[String], dictionary: List[String])List[String]
	
	spellCheckSmart(doc, dictionary)          //> res7: List[String] = List(howdy, yall)
	
	
	/**
	*  PROBLEM 4
	* 	Polynomials and monomials
	* A polynomial can be represented as a list of monomials.
	* A monomial is a pair of the form (coefficient, exponent)
	*/
	
	//result of substituting x in mono: (coefficient, exponent)
	def evalMono(mono: (Double, Double), x: Double): Double =
	{
			val (coefficient, exponent) = mono
			coefficient * Math.pow(x, exponent)
	}                                         //> evalMono: (mono: (Double, Double), x: Double)Double
	 
	evalMono((3.0, 2.0), 2)                   //> res8: Double = 12.0
	//3(2 ^ 2) = 3 * 4 = 12
	evalMono((3.0, 2.0), 5)                   //> res9: Double = 75.0
	//3(5 ^ 2) = 3 * 25 = 75
	evalMono((-5.0, 0.0), 5)                  //> res10: Double = -5.0
	//-5(5 ^ 0) = -5 * 1 = -5
	
	
	//resut of substituting x in poly
	def evalPoly(poly: List[(Double, Double)], x: Double): Double =
	{
		poly.map((n: (Double,Double)) => evalMono(n, x)).reduce(_+_)
	}                                         //> evalPoly: (poly: List[(Double, Double)], x: Double)Double
	
	val ex1 = List((3.0, 2.0), (-5.0, 0.0))   //> ex1  : List[(Double, Double)] = List((3.0,2.0), (-5.0,0.0))
	evalPoly(ex1, 2)                          //> res11: Double = 7.0
	//3x^2 - 5 = 3(2^2) - 5 = 12 - 5 = 7
	evalPoly(ex1, 5)                          //> res12: Double = 70.0
	//3(5^2)-5 = 75-5 = 70
	
}