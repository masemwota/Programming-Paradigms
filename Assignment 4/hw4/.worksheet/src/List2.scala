object List2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(188); 
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
  };System.out.println("""avg: (scores: List[Double])Double""");$skip(144); 
  
	//list of averages for each student
	def avgAvg(scores: List[List[Double]]): List[Double] =
	{
		scores.map((n: List[Double]) => avg(n))
	};System.out.println("""avgAvg: (scores: List[List[Double]])List[Double]""");$skip(269); 
   
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
	};System.out.println("""passing: (scores: List[List[Double]])List[Int]""");$skip(91); 
	
	//sum of scores
	def sum(scores: List[Double]): Double =
  {
  		scores.reduce(_+_)
  };System.out.println("""sum: (scores: List[Double])Double""");$skip(143); 
  
	//sum of sums of all scores
	def sumSums(scores: List[List[Double]]):Double =
	{
			scores.map((n: List[Double]) => sum(n)).reduce(_+_)
	};System.out.println("""sumSums: (scores: List[List[Double]])Double""");$skip(116); 
	
	
	/**
	* testing
	*/
	var cs152: List[List[Double]] = List(List(93, 89, 90), List(64, 76, 68), List(88, 82, 78));System.out.println("""cs152  : List[List[Double]] = """ + $show(cs152 ));$skip(17); val res$0 = 
	
	avg(cs152(0));System.out.println("""res0: Double = """ + $show(res$0));$skip(15); val res$1 = 
	avg(cs152(1));System.out.println("""res1: Double = """ + $show(res$1));$skip(15); val res$2 = 
	avg(cs152(2));System.out.println("""res2: Double = """ + $show(res$2));$skip(17); val res$3 = 
	
	avgAvg(cs152);System.out.println("""res3: List[Double] = """ + $show(res$3));$skip(18); val res$4 = 
	
	passing(cs152);System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(16); val res$5 = 
	sumSums(cs152);System.out.println("""res5: Double = """ + $show(res$5));$skip(307); 
	
	
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
	};System.out.println("""spellCheck: (doc: List[String], dictionary: List[String])List[String]""");$skip(72); 
	
	//testing
	val dictionary = List("hello", "there", "partner", "all");System.out.println("""dictionary  : List[String] = """ + $show(dictionary ));$skip(53); 
	val doc = List("howdy", "there", "partner", "yall");System.out.println("""doc  : List[String] = """ + $show(doc ));$skip(30); val res$6 = 
 	spellCheck(doc, dictionary);System.out.println("""res6: List[String] = """ + $show(res$6));$skip(208); 
	
	
	/**
	*	PROBLEM 3
	* 	Spellcheck using map, filter, reduce
	*/
	def spellCheckSmart(doc: List[String], dictionary: List[String]): List[String] =
	{
		doc.filter((n: String) => !dictionary.contains(n))
	};System.out.println("""spellCheckSmart: (doc: List[String], dictionary: List[String])List[String]""");$skip(36); val res$7 = 
	
	spellCheckSmart(doc, dictionary);System.out.println("""res7: List[String] = """ + $show(res$7));$skip(381); 
	
	
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
	};System.out.println("""evalMono: (mono: (Double, Double), x: Double)Double""");$skip(28); val res$8 = 
	 
	evalMono((3.0, 2.0), 2);System.out.println("""res8: Double = """ + $show(res$8));$skip(50); val res$9 = 
	//3(2 ^ 2) = 3 * 4 = 12
	evalMono((3.0, 2.0), 5);System.out.println("""res9: Double = """ + $show(res$9));$skip(52); val res$10 = 
	//3(5 ^ 2) = 3 * 25 = 75
	evalMono((-5.0, 0.0), 5);System.out.println("""res10: Double = """ + $show(res$10));$skip(200); 
	//-5(5 ^ 0) = -5 * 1 = -5
	
	
	//resut of substituting x in poly
	def evalPoly(poly: List[(Double, Double)], x: Double): Double =
	{
		poly.map((n: (Double,Double)) => evalMono(n, x)).reduce(_+_)
	};System.out.println("""evalPoly: (poly: List[(Double, Double)], x: Double)Double""");$skip(43); 
	
	val ex1 = List((3.0, 2.0), (-5.0, 0.0));System.out.println("""ex1  : List[(Double, Double)] = """ + $show(ex1 ));$skip(18); val res$11 = 
	evalPoly(ex1, 2);System.out.println("""res11: Double = """ + $show(res$11));$skip(56); val res$12 = 
	//3x^2 - 5 = 3(2^2) - 5 = 12 - 5 = 7
	evalPoly(ex1, 5);System.out.println("""res12: Double = """ + $show(res$12))}
	//3(5^2)-5 = 75-5 = 70
	
}
