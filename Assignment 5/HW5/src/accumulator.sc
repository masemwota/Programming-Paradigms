/* Problem 6 -- Accumulator*/

object accumulator {

  trait Instruction
  	{
 			def execute(register: Int): Int
	}
	
  		
  	class Add(val num: Int) extends Instruction
  	{
  			def execute(register: Int) = num + register
  	}
  	
  	object Add
  	{
  		def apply(n: Int) = new Add(n)
  	}
  	
  	class Mul(val num: Int) extends Instruction
  	{
  			def execute(register: Int) = num * register
  	}
  	
  	object Mul
  	{
  		def apply(n: Int) = new Mul(n)
  	}
  	
	object Accumulator {
	  
	  var register: Int = 0
		var program = List[Instruction]()
		
		def run()
		{
			for(inst <- program)
			{
				register = inst.execute(register)
			}
		}
	
		def program (ops: List[Instruction])
		{
			program = ops
		}
}


  	//testing
	Accumulator.program = List(Add(3), Mul(5), Add(1), Mul(2))
	Accumulator.run()
	Accumulator.register                      //> res0: Int#921 = 32
	// computing (((10 * 2) + 3) * 5)
	Accumulator.register = 0
	Accumulator.program = List(Add(10), Mul(2), Add(3), Mul(5))
	Accumulator.run()
	Accumulator.register                      //> res1: Int#921 = 115
}