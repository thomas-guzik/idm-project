package idm.interpreter

class InterpreterOutput {
	
	String output
	String error

	new(String stdOut, String stdErr) {
		output = stdOut
		error = stdErr
	}
	
	def getOutput() {
		return output
	}
	
	def getError() {
		return error
	}
}