/**
 * generated by Xtext 2.23.0
 */
package idm.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import idm.compiler.bash.CompilerBashQsv;
import idm.compiler.python.PythonCompiler;
import idm.qsv.QuerySeparatedValues;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class QsvGenerator extends AbstractGenerator {
  private static String target = "sh";
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    String _path = resource.getURI().trimFileExtension().path();
    String _plus = (_path + ".");
    final String location = (_plus + QsvGenerator.target);
    final QuerySeparatedValues qsv = IteratorExtensions.<QuerySeparatedValues>last(Iterators.<QuerySeparatedValues>filter(resource.getAllContents(), QuerySeparatedValues.class));
    InputOutput.<String>println(("Compiling output to: " + location));
    boolean _equals = Objects.equal(QsvGenerator.target, "sh");
    if (_equals) {
      final CompilerBashQsv bashCompiler = new CompilerBashQsv(qsv);
      fsa.generateFile(location, bashCompiler.compile());
    } else {
      boolean _equals_1 = Objects.equal(QsvGenerator.target, "py");
      if (_equals_1) {
        final PythonCompiler pythonCompiler = new PythonCompiler(qsv);
        fsa.generateFile(location, pythonCompiler.compile());
      } else {
        fsa.generateFile("greetings.txt", "Generator output!");
      }
    }
  }
  
  public static void setTargetLanguage(final String targetLanguage) {
    QsvGenerator.target = targetLanguage;
  }
}
