package idm.generator

import idm.qsv.QuerySeparatedValues

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import idm.compiler.bash.CompilerBashQsv

class BashGenerator extends AbstractGenerator {
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val CompilerBashQsv bashCompiler = new CompilerBashQsv(resource.allContents.filter(QuerySeparatedValues).last)
		fsa.generateFile('tmpfsa.sh', bashCompiler.compile())
	}

}
