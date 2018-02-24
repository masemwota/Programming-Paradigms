import scala.util.Random

object string {  //1, 2, 4, 5, 8, 9
  
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
  }                                               //> isPal: (input: String)Boolean
  
  //tests
  isPal("rotator")                                //> res0: Boolean = true
  isPal("      cat")                              //> res1: Boolean = false
  isPal("Rotator")                                //> res2: Boolean = false
  isPal("    r0tat0r ")                           //> res3: Boolean = true
  isPal("     madam  ")                           //> res4: Boolean = true
  isPal("GreeK   ")                               //> res5: Boolean = false
  isPal("ReDder")                                 //> res6: Boolean = false
  isPal("$%^%$")                                  //> res7: Boolean = true
  
  
  /*
   * PROBLEM 2
   * Improved palindrome detector
   */
   
   def isPal2 (input: String) =
   		isPal(input.replaceAll("[^a-zA-Z]", "").toLowerCase())
                                                  //> isPal2: (input: String)Boolean
   
   //tests
   isPal2("A man, a plan, a canal, Panama!")      //> res8: Boolean = true
   isPal2("Not a palindrome")                     //> res9: Boolean = false
   isPal2("Was it a car OR a cat I saw?")         //> res10: Boolean = true
   isPal2("No 'x' in Nixon")                      //> res11: Boolean = true
   
   
   
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
    }                                             //> mkWord: (prompt: Int)String
    
    mkWord()                                      //> res12: String = zvbon
    mkWord()                                      //> res13: String = paelb
    mkWord()                                      //> res14: String = rzmzf
    mkWord(20)                                    //> res15: String = meonfjatqukyjeixzqmk
    
    
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
     }                                            //> mkSentence: (input: Int)String
     
     mkSentence(1)                                //> res16: String = Ddi.
     mkSentence(2)                                //> res17: String = Qqnk e.
     mkSentence(3)                                //> res18: String = Yyoxmibtv mlaoy frmfzp.
     mkSentence(4)                                //> res19: String = Mmen k cw zzlgiakykg.
     mkSentence()                                 //> res20: String = Dda vxhvvqgcm anot nmjeq nivoae reppgzuxiq ljhejnjxh mqyci 
                                                  //| fax bmgrfqga dil.
                                                  
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
       }                                          //> eval: (input: String)AnyVal
     
      eval("3.14+42")                             //> res21: AnyVal = 45.14
      
		  eval("  -26  +  -49.99  ")      //> res22: AnyVal = -75.99000000000001
			eval("21 * 43")           //> java.lang.Exception: missing operator
                                                  //| res23: AnyVal = ()
			
			eval("abc + 3")           //> java.lang.NumberFormatException: For input string: "abc"
                                                  //| res24: AnyVal = ()

      
      
      
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
       }                                          //> eval2: (input: String)AnyVal
       
       eval2("21 + 4")                            //> res25: AnyVal = 25.0
       eval2("3.14+42")                           //> res26: AnyVal = 45.14
		   eval2("  -26  +  -49.99  ")    //> res27: AnyVal = -75.99000000000001
			 eval2("21 * 43")         //> res28: AnyVal = 903.0
			
			 eval2("abc + 3")         //> java.lang.NumberFormatException: For input string: "abc"
                                                  //| res29: AnyVal = ()
       
}