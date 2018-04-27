package value

/**
 * Notifications are acknowledgements (e.g., "ok", "done", "unspecified") 
 * returned by expressions that produce side effects such as updating a variable, store, or environment.
 */
class Notification(val note: String) extends Value{
    override def toString: String = note;
}

//Add a companion object with an apply method and pre-defined notifications OK, DONE, and UNSPECIFIED.
object Notification 
{
  def apply(note: String = "unspecified") = new Notification(note)
  def ok = Notification("ok")
  def done = Notification("done")
  def unspecified = Notification("unspecified")
}