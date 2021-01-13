/*
 * generated by Xtext 2.23.0
 */
package idm.generator

import idm.compiler.bash.CompilerBashQsv
import idm.compiler.python.PythonCompiler
import idm.qsv.QuerySeparatedValues
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class QsvGenerator extends AbstractGenerator {

	static String target = "sh"

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val location = resource.URI.trimFileExtension.path + "." + target
		val qsv = resource.allContents.filter(QuerySeparatedValues).last
		println("Compiling output to: " + location)
		if (target == "sh") {
			val CompilerBashQsv bashCompiler = new CompilerBashQsv(qsv)
			fsa.generateFile(location, bashCompiler.compile())
		} else if (target == "py") {
			val PythonCompiler pythonCompiler = new PythonCompiler(qsv)
			fsa.generateFile(location, pythonCompiler.compile())
		} else {
			fsa.generateFile('greetings.txt', 'Generator output!')
		}
	}

	def static void setTargetLanguage(String targetLanguage) {
		target = targetLanguage
	}
}
