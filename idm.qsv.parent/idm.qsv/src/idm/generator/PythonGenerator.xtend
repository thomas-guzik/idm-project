package idm.generator

import idm.qsv.QuerySeparatedValues

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

class PythonGenerator extends AbstractGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
//		val PythonCompiler pythonCompiler = new PythonCompiler()
		fsa.generateFile("tmpfsa.py", "hello python")
	}
}
