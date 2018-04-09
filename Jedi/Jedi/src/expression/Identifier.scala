package expression

/**
 * Identifiers are names of values. To execute an identifier we simply look it up in the environment.
 */
case class Identifier(val name: String) extends Expression {
   override def toString = name
   
   def execute(env: context.Environment) = 
   {
     env(this)
   }
}