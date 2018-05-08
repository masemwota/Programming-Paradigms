package expression
import context._
import value._

case class Block (val exps: List[Expression]) extends SpecialForm { 
	def execute(env: Environment): Value = 
	{
	  val tempEnv = new Environment(env)
	  val values = exps.map(_.execute(tempEnv))
	  values(values.size-1)
	}
}
