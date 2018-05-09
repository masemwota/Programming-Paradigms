package value

class Variable(var content: Value) extends Value{
  
  //The toString is the content with [] square braces around it 
  override def toString: String = 
  {
    "[" + content + "]"
  }
  
  
}