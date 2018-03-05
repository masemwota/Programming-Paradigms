object List1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(116); 
	/**
	* List Processing 1
	* 1, 2, 3, 6, 7, 8, 10, 13
	*/
  println("Welcome to the Scala worksheet");$skip(514); 
  
  /*
  For problems 1, 2, 6, 7, & 8 implement four versions:

·       Iterative version
·       Recursive version
·       Tail-recursive version (this should be different from the previous version)
·       map-filter-reduce version

  
  */
  
  
  /**
  * PROBLEM 1
  * Write a function that computes the sum of cubes of all
  * odd numbers occurring in a list of integers.
  *
  * NOTE: 4 ways: iterative, recursive, tail-recursive, map-filter-reduce
  */
  def sumOfOddCubesIter (vals: List[Int])
  {
  
  };System.out.println("""sumOfOddCubesIter: (vals: List[Int])Unit""");$skip(41); 
  
  sumOfOddCubesIter(List(1, 2, 3, 4));$skip(85); 
  //answer = (1^3) + (3^3) = 1 + 27 = 28
  sumOfOddCubesIter(List(1, 2, 3, 4, 5, 6));$skip(142); 
  //answer = (1^3) + (3^3) + (5^3) = 1 + 27 + 125 = 153
  
	  /*
	  			RECURSIVE
	  */
  
  def sumOfOddCubesRec (vals: List[Int])
  {
  
  };System.out.println("""sumOfOddCubesRec: (vals: List[Int])Unit""");$skip(40); 
  
  sumOfOddCubesRec(List(1, 2, 3, 4));$skip(84); 
  //answer = (1^3) + (3^3) = 1 + 27 = 28
  sumOfOddCubesRec(List(1, 2, 3, 4, 5, 6));$skip(145); 
  //answer = (1^3) + (3^3) + (5^3) = 1 + 27 + 125 = 153
  
  /*
  			TAIL RECURSIVE
  */
  
  def sumOfOddCubesTail (vals: List[Int])
  {
  
  };System.out.println("""sumOfOddCubesTail: (vals: List[Int])Unit""");$skip(41); 
  
  sumOfOddCubesTail(List(1, 2, 3, 4));$skip(85); 
  //answer = (1^3) + (3^3) = 1 + 27 = 28
  sumOfOddCubesTail(List(1, 2, 3, 4, 5, 6));$skip(148); 
  //answer = (1^3) + (3^3) + (5^3) = 1 + 27 + 125 = 153
  
  /*
  			MAP - FILTER - REDUCE
  */
  def sumOfOddCubesMap (vals: List[Int])
  {
  
  };System.out.println("""sumOfOddCubesMap: (vals: List[Int])Unit""");$skip(40); 
  
  sumOfOddCubesMap(List(1, 2, 3, 4));$skip(84); 
  //answer = (1^3) + (3^3) = 1 + 27 = 28
  sumOfOddCubesMap(List(1, 2, 3, 4, 5, 6));$skip(334); 
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
  def sumOfSumsIter[T] (vals: List[T])
  {
  
  };System.out.println("""sumOfSumsIter: [T](vals: List[T])Unit""");$skip(59); 
  
  sumOfSumsIter(List(List (1, 4), List(2, 3)));$skip(62);  //A = 10
  sumOfSumsIter(List(List (1, 2, 3), List(4, 5, 6)));$skip(68);  //A = 21
  sumOfSumsIter(List(List (2, 4, 6, 8), List(1, 3, 5, 7)));$skip(77);  //A = 36
  
  /*
  			RECURSIVE
  */
  def sumOfSumsRec[T] (vals: List[T])
  {
  
  };System.out.println("""sumOfSumsRec: [T](vals: List[T])Unit""");$skip(58); 
  
  sumOfSumsRec(List(List (1, 4), List(2, 3)));$skip(61);  //A = 10
  sumOfSumsRec(List(List (1, 2, 3), List(4, 5, 6)));$skip(67);  //A = 21
  sumOfSumsRec(List(List (2, 4, 6, 8), List(1, 3, 5, 7)));$skip(85);  //A = 36
  
  /*
  			TAIL - RECURSIVE
  */
  def sumOfSumsTail[T] (vals: List[T])
  {
  
  };System.out.println("""sumOfSumsTail: [T](vals: List[T])Unit""");$skip(59); 
  
  sumOfSumsTail(List(List (1, 4), List(2, 3)));$skip(62);  //A = 10
  sumOfSumsTail(List(List (1, 2, 3), List(4, 5, 6)));$skip(68);  //A = 21
  sumOfSumsTail(List(List (2, 4, 6, 8), List(1, 3, 5, 7)));$skip(88);  //A = 36
  
  /*
  		MAP - FILTER - REDUCE
  */
  def sumOfSumsMap[T] (vals: List[T])
  {
  
  };System.out.println("""sumOfSumsMap: [T](vals: List[T])Unit""");$skip(58); 
  
  sumOfSumsMap(List(List (1, 4), List(2, 3)));$skip(61);  //A = 10
  sumOfSumsMap(List(List (1, 2, 3), List(4, 5, 6)));$skip(67);  //A = 21
  sumOfSumsMap(List(List (2, 4, 6, 8), List(1, 3, 5, 7))) //A = 36}
  
}
