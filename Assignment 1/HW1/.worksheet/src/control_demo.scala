object control_demo {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(65); 
  println("Welcome to the Scala worksheet");$skip(258); 
  
  // problem 1
  
  def tax(income: Double) =
  			income match {
  					case income if income < 100 => .1 * income
  					case income if income < 1000 => .2 * income
  					case income if income < 10000 => .3 * income
  					case _ => .1 * income
  			};System.out.println("""tax: (income: Double)Double""");$skip(13); val res$0 = 
  
  tax(99);System.out.println("""res0: Double = """ + $show(res$0));$skip(11); val res$1 = 
  tax(101);System.out.println("""res1: Double = """ + $show(res$1));$skip(17); val res$2 = 
  tax(100000000);System.out.println("""res2: Double = """ + $show(res$2))}
}
