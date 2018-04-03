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
};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(794); 


  	//testing
	Accumulator.program = List(Add(3), Mul(5), Add(1), Mul(2));$skip(19); 
	Accumulator.run();$skip(22); val res$0 = 
	Accumulator.register;System.out.println("""res0: Int#921 = """ + $show(res$0));$skip(61); 
	// computing (((10 * 2) + 3) * 5)
	Accumulator.register = 0;$skip(61); 
	Accumulator.program = List(Add(10), Mul(2), Add(3), Mul(5));$skip(19); 
	Accumulator.run();$skip(22); val res$1 = 
	Accumulator.register;System.out.println("""res1: Int#921 = """ + $show(res$1))}
}
