object control_demo {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  // problem 1
  
  def tax(income: Double) =
  			income match {
  					case income if income < 100 => .1 * income
  					case income if income < 1000 => .2 * income
  					case income if income < 10000 => .3 * income
  					case _ => .1 * income
  			}                         //> tax: (income: Double)Double
  
  tax(99)                                         //> res0: Double = 9.9
  tax(101)                                        //> res1: Double = 20.200000000000003
  tax(100000000)                                  //> res2: Double = 1.0E7
}