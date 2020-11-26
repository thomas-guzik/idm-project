package idm.compiler

class TerminalOutput {
	String output
	String error

	new(String stdOut, String stdErr) {
		output = stdOut
		error = stdErr
	}

	def String getOutput() {
		return output
	}

	def String getError() {
		return error
	}
}
