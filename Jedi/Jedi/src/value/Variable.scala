package value

class Variable(val content: Value) {
  
  //The toString is the content with [] square braces around it 
  override def toString: String = 
  {
    "[" + content + "]"
  }
}