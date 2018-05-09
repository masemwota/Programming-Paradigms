package context

import scala.util.parsing.combinator._
import expression._
import value._

class Jedi3Parsers extends Jedi2Parsers {
  
  // assignment ::= identifier ~ "=" ~ expression
  def assignment: Parser[Assignment] = identifier ~ "=" ~ expression ^^ 
  {
    case id ~ "=" ~ exp => Assignment(id, exp)
  }
  
  // iteration ::= "while" ~ "(" ~ expression ~ ")" ~ expression
    def iteration: Parser[Iteration] =  "while" ~ "(" ~ expression ~ ")" ~ expression ^^ 
    {
      case "while" ~ "(" ~ cond ~ ")" ~ body => Iteration(cond, body)
    }
  
  // dereference ::= "[" ~ expression ~ "]"
    def dereference: Parser[FunCall] = "[" ~ expression ~ "]" ^^ 
    {
      case "[" ~ exp ~ "]" => FunCall(Identifier("dereference"), List(exp))
      //Dereference parser makes it into a funcall and the function you’re calling is the dereference function which is a new alu function. 
    }

  override def expression: Parser[Expression] = declaration | conditional | iteration | disjunction | failure("Invalid expression")
  override def term: Parser[Expression]  = lambda | funCall | block | assignment | dereference | literal | "("~>expression<~")"
}