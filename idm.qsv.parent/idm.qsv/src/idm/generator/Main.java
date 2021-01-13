/*
 * generated by Xtext 2.23.0
 */
package idm.generator;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import idm.QsvStandaloneSetup;

import java.io.IOException;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.GeneratorDelegate;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

public class Main {

	public static void main(String[] args) {
		Injector injector = new QsvStandaloneSetup().createInjectorAndDoEMFRegistration();
		Main main = injector.getInstance(Main.class);
		main.runInterpreter();
		
		System.exit(0);
		if (args.length < 2) {
			System.err.println("Aborting: no path to EMF resource provided or no target language!");
			return;
		}
		System.out.println("");
		System.out.println("******");
		System.out.println("Code generation for: " + args[1] + " to " + args[0] + "...");
		main.runGenerator(args[1], args[0]);
	}

	@Inject
	private Provider<ResourceSet> resourceSetProvider;

	@Inject
	private IResourceValidator validator;

	@Inject
	private GeneratorDelegate generator;

	@Inject 
	private JavaIoFileSystemAccess fileAccess;

	protected void runGenerator(String string, String target) {
		// Load the resource
		ResourceSet set = resourceSetProvider.get();
		Resource resource = set.getResource(URI.createFileURI(string), true);

		// Validate the resource
		List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		if (!list.isEmpty()) {
			for (Issue issue : list) {
				System.err.println(issue);
			}
			return;
		}

		// Configure and start the generator
		QsvGenerator.setTargetLanguage(target);
		fileAccess.setOutputPath("/");
		GeneratorContext context = new GeneratorContext();
		context.setCancelIndicator(CancelIndicator.NullImpl);
		generator.generate(resource, fileAccess, context);
	}
	
	protected void runInterpreter() {
		// Load the resource
		ResourceSet set = resourceSetProvider.get();
		
		Interpreter interpreter = new Interpreter(set, validator);
		try {
			interpreter.run(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
