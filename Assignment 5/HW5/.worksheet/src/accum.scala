
object accum extends App
{
	object Accumulator {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(75); 
  
	var register: Int = 0;System.out.println("""register  : Int = """ + $show(register ));$skip(35); 
	var program = List[Instruction]();System.out.println("""program  : <error> = """ + $show(program ));$skip(87); 
	
	def run()
	{
		for(inst <- program)
		{
			register = inst.execute(register)
		}
	};System.out.println("""run: ()Unit""");$skip(18); 
	
	def program {}
	
	
	
		trait instruction
  		{
 				def execute(register: Int): Int
  		}
  		
  	class add(val num: Int) extends instruction
  	{
  			def execute(register: Int) = num + register
  	}
  	
  	class sub(val num: Int) extends instruction
  	{
  			def execute(register: Int) = num + register
  	};System.out.println("""program: => Unit""");$skip(381); val res$0 = 
  	
  	
  	//testing
  	
	Accumulator.program = List(Add(3), Mul(5), Add(1), Mul(2));System.out.println("""res0: <error> = """ + $show(res$0));$skip(19); val res$1 = 
	Accumulator.run();System.out.println("""res1: <error> = """ + $show(res$1));$skip(22); val res$2 = 
	Accumulator.register;System.out.println("""res2: <error> = """ + $show(res$2));$skip(61); val res$3 = 
	// computing (((10 * 2) + 3) * 5)
	Accumulator.register = 0;System.out.println("""res3: <error> = """ + $show(res$3));$skip(61); val res$4 = 
	Accumulator.program = List(Add(10), Mul(2), Add(3), Mul(5));System.out.println("""res4: <error> = """ + $show(res$4));$skip(19); val res$5 = 
	Accumulator.run();System.out.println("""res5: <error> = """ + $show(res$5));$skip(22); val res$6 = 
	Accumulator.register;System.out.println("""res6: <error> = """ + $show(res$6))}
	
	/*
  Register = inst(register)
	
	add(3) = (r:Int) => r + 3
	mul(5 = (r:Int) => r * 5
	*/
}
