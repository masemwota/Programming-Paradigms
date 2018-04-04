package value

/**
 * Notifications are acknowledgements (e.g., "ok", "done", "unspecified") 
 * returned by expressions that produce side effects such as updating a variable, store, or environment.
 */
class Notification(note: String) extends Value{
    
}

//Add a companion object with an apply method and pre-defined notifications OK, DONE, and UNSPECIFIED.
object Notification 
{
  def apply(note: String = ok) = new Notification(note)
  def ok = "ok"
  def done = "done"
  def unspecified = "unspecified"
}