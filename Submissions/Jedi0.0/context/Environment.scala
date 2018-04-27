package context
/**
 *  The global environment is a hash table that associates identifiers to values. (E.g., pi = 3.14.) Initially it is empty. 
 *  Executing declarations at the console's prompt will add bindings to the global environment.
 */
class Environment extends collection.mutable.HashMap[expression.Identifier, value.Value]

