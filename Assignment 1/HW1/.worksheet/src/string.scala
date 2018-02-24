import scala.util.Random

object string {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(403);   //1, 2, 4, 5, 8, 9
  
  /*
  * PROBLEM 1
  * Palindrome Detector
  *
  */
  
  def isPal(input : String) =
  {
  		val word = input.replaceAll("\\s", "")
  		val len = word.length()
  		
  		var result = false
  
  		for(i <- 0 to len-1)
  		{
  			val j = len - i- 1

  			if(word(i) != word(j)) result = false
  			else result = true
  		}
  	
  		result
  };System.out.println("""isPal: (input: String)Boolean""");$skip(32); val res$0 = 
  
  //tests
  isPal("rotator");System.out.println("""res0: Boolean = """ + $show(res$0));$skip(21); val res$1 = 
  isPal("      cat");System.out.println("""res1: Boolean = """ + $show(res$1));$skip(19); val res$2 = 
  isPal("Rotator");System.out.println("""res2: Boolean = """ + $show(res$2));$skip(24); val res$3 = 
  isPal("    r0tat0r ");System.out.println("""res3: Boolean = """ + $show(res$3));$skip(24); val res$4 = 
  isPal("     madam  ");System.out.println("""res4: Boolean = """ + $show(res$4));$skip(20); val res$5 = 
  isPal("GreeK   ");System.out.println("""res5: Boolean = """ + $show(res$5));$skip(18); val res$6 = 
  isPal("ReDder");System.out.println("""res6: Boolean = """ + $show(res$6));$skip(17); val res$7 = 
  isPal("$%^%$");System.out.println("""res7: Boolean = """ + $show(res$7));$skip(162); 
  
  
  /*
   * PROBLEM 2
   * Improved palindrome detector
   */
   
   def isPal2 (input: String) =
   		isPal(input.replaceAll("[^a-zA-Z]", "").toLowerCase());System.out.println("""isPal2: (input: String)Boolean""");$skip(60); val res$8 = 
   
   //tests
   isPal2("A man, a plan, a canal, Panama!");System.out.println("""res8: Boolean = """ + $show(res$8));$skip(30); val res$9 = 
   isPal2("Not a palindrome");System.out.println("""res9: Boolean = """ + $show(res$9));$skip(42); val res$10 = 
   isPal2("Was it a car OR a cat I saw?");System.out.println("""res10: Boolean = """ + $show(res$10));$skip(29); val res$11 = 
   isPal2("No 'x' in Nixon");System.out.println("""res11: Boolean = """ + $show(res$11));$skip(408); 
   
   
   
   /*
    * PROBLEM 4
    * Random Word Generator
    *
    */
    
    def mkWord(prompt: Int = 5) =
    {
    		//unicode: 0061 -> 007A; 97 -> 122
    		//r.nextInt((max - min) + 1) + min;
    		
    		var word = ""
  	
    		for(i <- 1 to prompt)
    		{
    			val rand = Random.nextInt((122 - 97) + 1) + 97;
    			val c = rand.toChar
    			
    			word = word + c
    		}
    		word
    };System.out.println("""mkWord: (prompt: Int)String""");$skip(18); val res$12 = 
    
    mkWord();System.out.println("""res12: String = """ + $show(res$12));$skip(13); val res$13 = 
    mkWord();System.out.println("""res13: String = """ + $show(res$13));$skip(13); val res$14 = 
    mkWord();System.out.println("""res14: String = """ + $show(res$14));$skip(15); val res$15 = 
    mkWord(20);System.out.println("""res15: String = """ + $show(res$15));$skip(525); 
    
    
    /*
     * PROBLEM 5
     * Random Sentence Generator
     *
     */
     
     def mkSentence(input: Int = Random.nextInt(5)+10) =
     {
     		var sentence = ""
   
     		for(i <- 1  to input)
     		{
     				val rand = Random.nextInt(10) + 1
     				val word = mkWord(rand)
     				sentence += word
     				
     				if(i == input) sentence += "."
     				else sentence += " "
     		}
     		
     		val c = sentence(1)
     		val rest = sentence.substring(1)
     		 
     		c.toUpper + rest
     };System.out.println("""mkSentence: (input: Int)String""");$skip(25); val res$16 = 
     
     mkSentence(1);System.out.println("""res16: String = """ + $show(res$16));$skip(19); val res$17 = 
     mkSentence(2);System.out.println("""res17: String = """ + $show(res$17));$skip(19); val res$18 = 
     mkSentence(3);System.out.println("""res18: String = """ + $show(res$18));$skip(19); val res$19 = 
     mkSentence(4);System.out.println("""res19: String = """ + $show(res$19));$skip(18); val res$20 = 
     mkSentence();System.out.println("""res20: String = """ + $show(res$20));$skip(623); 
                                                  
     /*
      * PROBLEM 8
      * Sum of two numbers
      */
      
     def eval(input: String) =
       {
       		try
       		{
       			val compute = input.replaceAll("\\s", "")
       			val numbers = compute.split("\\+")
       	
       			val plus = compute.indexOf("+")
       			if(plus < 0) throw new Exception("missing operator")
       			
       			val num1 = numbers(0).toDouble
       			val num2 = numbers(1).toDouble
       		
       			num1 + num2
       	}
       	
       	catch
       	{
       		case e: Exception => println(e)
       	}
       };System.out.println("""eval: (input: String)AnyVal""");$skip(28); val res$21 = 
     
      eval("3.14+42");System.out.println("""res21: AnyVal = """ + $show(res$21));$skip(38); val res$22 = 
      
		  eval("  -26  +  -49.99  ");System.out.println("""res22: AnyVal = """ + $show(res$22));$skip(19); val res$23 = 
			eval("21 * 43");System.out.println("""res23: AnyVal = """ + $show(res$23));$skip(23); val res$24 = 
			
			eval("abc + 3");System.out.println("""res24: AnyVal = """ + $show(res$24));$skip(883); 

      
      
      
      /*
       * PROBLEM 9
       * Products of two numbers
       */
       
       def eval2(input: String) =
       {
       		try
       		{
       			val compute = input.replaceAll("\\s", "")
   
       			val plus = compute.indexOf("+")
       			val times = compute.indexOf("*")
       			
       			//if neither plus or times operator present
       			if((plus < 0) && (times < 0)) throw new Exception("missing operator")
       			
       			var numbers = Array[String]()
       		
       			if(plus > 0) numbers = compute.split("\\+")
       			else numbers = compute.split("\\*")
       			
       			val num1 = numbers(0).toDouble
       			val num2 = numbers(1).toDouble
       		
       			if(plus > 0) num1 + num2
       			else num1 * num2
       	}
       	
       	catch
       	{
       		case e: Exception => println(e)
       	}
       };System.out.println("""eval2: (input: String)AnyVal""");$skip(31); val res$25 = 
       
       eval2("21 + 4");System.out.println("""res25: AnyVal = """ + $show(res$25));$skip(24); val res$26 = 
       eval2("3.14+42");System.out.println("""res26: AnyVal = """ + $show(res$26));$skip(33); val res$27 = 
		   eval2("  -26  +  -49.99  ");System.out.println("""res27: AnyVal = """ + $show(res$27));$skip(21); val res$28 = 
			 eval2("21 * 43");System.out.println("""res28: AnyVal = """ + $show(res$28));$skip(25); val res$29 = 
			
			 eval2("abc + 3");System.out.println("""res29: AnyVal = """ + $show(res$29))}
       
}
