package idm.compiler.python

import java.lang.Exception

class MissingConcreteImplementationException extends Exception {
	
	new(String message) {
		super("Missing concrete implementation for class " + message)
	}
	
}