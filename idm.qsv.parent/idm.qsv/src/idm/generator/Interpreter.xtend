package idm.generator

import idm.compiler.python.PythonCompiler
import idm.qsv.QuerySeparatedValues
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.util.List
import java.util.Scanner
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.xtext.validation.Issue

class Interpreter {
	Scanner scanner;
	ResourceSet set
	IResourceValidator validator

	new(ResourceSet resourceSet, IResourceValidator resourceValidator) {
		scanner = new Scanner(System.in)
		set = resourceSet
		validator = resourceValidator
	}

	def void run(String[] args) throws IOException {
		while (true) {
			prompt()
		}
	}

	def private void prompt() {
		showInitial()
		var something = scanner.nextLine()
		while (something.endsWith("\\")) {
			showNext()
			val next = scanner.nextLine()
			something += "\n" + next
		}
		// should interpret code here
		val compiler = new PythonCompiler(something.toResource)
		println(compiler.compile())
	}

	def private void showInitial() {
		print("qsv> ")
	}

	def private void showNext() {
		print("...> ")
	}

	def private QuerySeparatedValues toResource(String code) {
		val File tmpFile = File.createTempFile("test", ".qsv");
		val path = tmpFile.getPath
		val FileWriter writer = new FileWriter(tmpFile);
		writer.write(code);
		writer.close();
		val Resource resource = set.getResource(URI.createFileURI(path), true);
		// Validate the resource
		val List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		if (!list.isEmpty()) {
			for (Issue issue : list) {
				System.err.println(issue);
			}
			return null
		}
		val qsv = resource.allContents.filter(QuerySeparatedValues).last

		return qsv
	}

	def String dump(EObject mod_, String indent) {
		var res = indent + mod_.toString.replaceFirst('.*[.]impl[.](.*)Impl[^(]*', '$1 ')

		for (a : mod_.eCrossReferences)
			res += ' ->' + a.toString().replaceFirst('.*[.]impl[.](.*)Impl[^(]*', '$1 ')
		res += "\n"
		for (f : mod_.eContents) {
			res += f.dump(indent + "    ")
		}
		return res
	}

}
