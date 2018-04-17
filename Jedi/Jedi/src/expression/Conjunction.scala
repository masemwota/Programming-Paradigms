package expression
import context._
import value._

//&& 

/**
 * checks that the input is an instance of boolean, throws an exception otherwise. 
 * turns the input into an instance of boole, executes it, and checks add
 */
case class Conjunction(operands: List[Expression]) extends SpecialForm
{
    def execute(env: context.Environment) = 
    {
      //make sure it is an instance of boolean or throw exception 
      val filtered = operands.filter((exp: Expression) => exp.isInstanceOf[value.Boole]) 
      //execute
      val executed = operands.map((exp: Expression) => exp.asInstanceOf[value.Boole])
      //vals.filter((n: Int) => n % 2 == 1).map((n: Int) => n * n * n).reduce(_+_)
      
      
        def helper(current: Expression, next: List[Expression], result: Boole): value.Boole = 
        {
          //if (current.isInstanceOf[value.Boole]
          //if (current.execute(env) && result) result else helper(count + 1, newResult) 
          val exec = current.execute(env)
          exec match 
          {
            case b: Boole => helper(next.head, next.tail, Boole(b.value && result.value))
            case _ => throw new TypeException("Conjunction takes a Boole")
          }
        }
        
        helper(operands.head, operands.tail, Boole(true))
    }

  
  
  /**
  def execute(env: Environment): Value = {

    val ops: List[Expression] = operands.filter((op: Expression) => op.isInstanceOf[Boole]).map((op: Expression) => op.asInstanceOf[Boole])
    var result = true
    var index =  0

    if(ops.size == operands.size)
      {
        while(result && index < ops.length) {
          if (ops(index).execute(env) == Boole(true))
            index = index + 1

          else result = false
        }
      }
    else throw new TypeException()
    Boole(result)

  }
  * 
  * */
  */
}