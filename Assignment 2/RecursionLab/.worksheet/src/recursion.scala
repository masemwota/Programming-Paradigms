/**
* Recursion homework
* 1, 2, 3, 4, 5, 9, 10
*/

object recursion {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(99); 
  
  def inc(n: Int) = n + 1;System.out.println("""inc: (n: Int)Int""");$skip(25); 
	def dec(n: Int) = n - 1;System.out.println("""dec: (n: Int)Int""");$skip(29); 
	def isZero(n: Int) = n == 0;System.out.println("""isZero: (n: Int)Boolean""");$skip(147); 
	
	/**
	* 	PROBLEM 1
	*/
	
	//recursive
	def add(m: Int, n: Int): Int =
	{
		if(isZero(n)) m
		else if (isZero(m)) n
		else add(inc(m), dec(n))
	};System.out.println("""add: (m: Int, n: Int)Int""");$skip(11); val res$0 = 
	add(2, 3);System.out.println("""res0: Int = """ + $show(res$0));$skip(11); val res$1 = 
	add(1, 9);System.out.println("""res1: Int = """ + $show(res$1));$skip(12); val res$2 = 
	add(9, 10);System.out.println("""res2: Int = """ + $show(res$2));$skip(13); val res$3 = 
	add(10, 15);System.out.println("""res3: Int = """ + $show(res$3));$skip(201); 
	
	//PROBLEM 5 -- TAIL RECURSION
	
	def addTail(m: Int, n: Int) = {
   	def helper(count: Int, result: Int): Int =
      	if (n < count) result else helper(inc(count), inc(result))
   	helper(1, m)
	};System.out.println("""addTail: (m: Int, n: Int)Int""");$skip(17); val res$4 = 
	
	addTail(2, 3);System.out.println("""res4: Int = """ + $show(res$4));$skip(15); val res$5 = 
	addTail(1, 9);System.out.println("""res5: Int = """ + $show(res$5));$skip(16); val res$6 = 
	addTail(9, 10);System.out.println("""res6: Int = """ + $show(res$6));$skip(17); val res$7 = 
	addTail(10, 15);System.out.println("""res7: Int = """ + $show(res$7));$skip(136); 
	
	
	/**
	*	PROBLEM 2
	*/
	
	 //recursive
	 def mul (m: Int, n: Int): Int =
	 {
	 		if(isZero(n)) 0
	 		else add(m, mul(m, dec(n)))
	 };System.out.println("""mul: (m: Int, n: Int)Int""");$skip(12); val res$8 = 
	 mul(2, 4);System.out.println("""res8: Int = """ + $show(res$8));$skip(13); val res$9 = 
	 mul(1, 50);System.out.println("""res9: Int = """ + $show(res$9));$skip(12); val res$10 = 
	 mul(3, 6);System.out.println("""res10: Int = """ + $show(res$10));$skip(12); val res$11 = 
	 mul(7, 6);System.out.println("""res11: Int = """ + $show(res$11));$skip(210); 
	 
	
	 //PROBLEM 5 -- TAIL RECURSIVE
	 def mulTail(m:Int, n: Int) = {
   		def helper(count: Int, result: Int): Int =
      		if (n < count) result else helper(inc(count), add(result, m))
   		helper(1, 0)
		};System.out.println("""mulTail: (m: Int, n: Int)Int""");$skip(19); val res$12 = 
		
	 mulTail(2, 4);System.out.println("""res12: Int = """ + $show(res$12));$skip(17); val res$13 = 
	 mulTail(1, 50);System.out.println("""res13: Int = """ + $show(res$13));$skip(16); val res$14 = 
	 mulTail(3, 6);System.out.println("""res14: Int = """ + $show(res$14));$skip(16); val res$15 = 
	 mulTail(7, 6);System.out.println("""res15: Int = """ + $show(res$15));$skip(131); 
	 
	 
	 /**
	 * 	PROBLEM 3
	 */

	 //recursion
	 def exp2(m: Int): Int =
	 {
	 		if(isZero(m)) 1
	 		else mul(2, exp2(dec(m)))
	 };System.out.println("""exp2: (m: Int)Int""");$skip(10); val res$16 = 
	 exp2(0);System.out.println("""res16: Int = """ + $show(res$16));$skip(10); val res$17 = 
	 exp2(2);System.out.println("""res17: Int = """ + $show(res$17));$skip(10); val res$18 = 
	 exp2(3);System.out.println("""res18: Int = """ + $show(res$18));$skip(10); val res$19 = 
	 exp2(4);System.out.println("""res19: Int = """ + $show(res$19));$skip(10); val res$20 = 
	 exp2(6);System.out.println("""res20: Int = """ + $show(res$20));$skip(10); val res$21 = 
	 exp2(8);System.out.println("""res21: Int = """ + $show(res$21));$skip(197); 
	 
	 //PROBLEM 5 -- tail recursion
	 def expTail(n: Int) =
	 {
	 		def helper(count: Int, result: Int): Int =
	 				if(n < count) result else helper(inc(count), mul(count, 2))
	 		helper(1, 1)
	 };System.out.println("""expTail: (n: Int)Int""");$skip(13); val res$22 = 
	 expTail(0);System.out.println("""res22: Int = """ + $show(res$22));$skip(13); val res$23 = 
	 expTail(2);System.out.println("""res23: Int = """ + $show(res$23));$skip(13); val res$24 = 
	 expTail(3);System.out.println("""res24: Int = """ + $show(res$24));$skip(13); val res$25 = 
	 expTail(4);System.out.println("""res25: Int = """ + $show(res$25));$skip(13); val res$26 = 
	 expTail(6);System.out.println("""res26: Int = """ + $show(res$26));$skip(13); val res$27 = 
	 expTail(8);System.out.println("""res27: Int = """ + $show(res$27));$skip(114); 
	 
	 
	 
	 /**
	 *		PROBLEM 4
	 */
	 def hyperExp(n: Int): Int =
	 {
	 		if(isZero(n)) 1
	 		else hyperExp(n)
	 };System.out.println("""hyperExp: (n: Int)Int""");$skip(17); val res$28 = 
	 
	 hyperExp(0);System.out.println("""res28: Int = """ + $show(res$28));$skip(264); 
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
	 };System.out.println("""hyperExpTail: (n: Int)Int""");$skip(18); val res$29 = 
	 hyperExpTail(0);System.out.println("""res29: Int = """ + $show(res$29));$skip(18); val res$30 = 
	 hyperExpTail(1);System.out.println("""res30: Int = """ + $show(res$30));$skip(18); val res$31 = 
	 hyperExpTail(2);System.out.println("""res31: Int = """ + $show(res$31));$skip(18); val res$32 = 
	 hyperExpTail(3);System.out.println("""res32: Int = """ + $show(res$32));$skip(18); val res$33 = 
	 hyperExpTail(4);System.out.println("""res33: Int = """ + $show(res$33));$skip(137); 
	 
	 
	 /**
	 * 		PROBLEM 9
	 */
	 def fib(n: Int): Int =
	 {
	 		if(isZero(n)) 1
	 		else if(n == 1) 1
	 		else fib(n-1) + fib(n-2)
	 };System.out.println("""fib: (n: Int)Int""");$skip(12); val res$34 = 
	 
	 fib(0);System.out.println("""res34: Int = """ + $show(res$34));$skip(9); val res$35 = 
	 fib(1);System.out.println("""res35: Int = """ + $show(res$35));$skip(9); val res$36 = 
	 fib(2);System.out.println("""res36: Int = """ + $show(res$36));$skip(9); val res$37 = 
	 fib(3);System.out.println("""res37: Int = """ + $show(res$37));$skip(9); val res$38 = 
	 fib(4);System.out.println("""res38: Int = """ + $show(res$38));$skip(9); val res$39 = 
	 fib(5);System.out.println("""res39: Int = """ + $show(res$39));$skip(204); 
	 
	 
	 //tail recursive
	 def fibTail(n: Int) =
	 {
	 		def helper(first: Int, second: Int, count: Int): Int =
	 			if(count < 1) first else helper(second, first+second, count-1)
	 		helper(1, 1, n)
	 };System.out.println("""fibTail: (n: Int)Int""");$skip(13); val res$40 = 
	 fibTail(0);System.out.println("""res40: Int = """ + $show(res$40));$skip(13); val res$41 = 
	 fibTail(1);System.out.println("""res41: Int = """ + $show(res$41));$skip(13); val res$42 = 
	 fibTail(2);System.out.println("""res42: Int = """ + $show(res$42));$skip(13); val res$43 = 
	 fibTail(3);System.out.println("""res43: Int = """ + $show(res$43));$skip(13); val res$44 = 
	 fibTail(4);System.out.println("""res44: Int = """ + $show(res$44));$skip(13); val res$45 = 
	 fibTail(5);System.out.println("""res45: Int = """ + $show(res$45));$skip(13); val res$46 = 
	 fibTail(6);System.out.println("""res46: Int = """ + $show(res$46));$skip(13); val res$47 = 
	 fibTail(7);System.out.println("""res47: Int = """ + $show(res$47));$skip(13); val res$48 = 
	 fibTail(8);System.out.println("""res48: Int = """ + $show(res$48));$skip(203); 
	 
	 
	 
	 /**
	 * 	PROBLEM 10
	 */
	
	 def choose(m: Int, n: Int): Int =
	 {
	 		if(m == n) 1
	 		else if (m < n) 0
	 		else if(n == 1) m
	 	
	 		else add(choose(dec(m), n), choose(dec(m), dec(n)))
	 };System.out.println("""choose: (m: Int, n: Int)Int""");$skip(17); val res$49 = 
	 
	 choose(4,2);System.out.println("""res49: Int = """ + $show(res$49));$skip(14); val res$50 = 
	 choose(7,5);System.out.println("""res50: Int = """ + $show(res$50));$skip(15); val res$51 = 
	 choose(11,4);System.out.println("""res51: Int = """ + $show(res$51))}
}
