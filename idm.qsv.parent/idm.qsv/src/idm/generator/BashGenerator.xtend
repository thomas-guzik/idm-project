package idm.generator

import idm.qsv.QuerySeparatedValues

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import idm.compiler.BashCompiler

class BashGenerator extends AbstractGenerator {
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val BashCompiler bashCompiler = new BashCompiler()
		fsa.generateFile('tmpfsa.sh', bashCompiler.setQsv(resource.allContents.filter(QuerySeparatedValues).last).compile())
	}

}
