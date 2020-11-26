package idm.generator;

import com.google.common.collect.Iterators;
import idm.compiler.BashCompiler;
import idm.qsv.QuerySeparatedValues;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public class BashGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    final BashCompiler bashCompiler = new BashCompiler();
    fsa.generateFile("tmpfsa.sh", bashCompiler.setQsv(IteratorExtensions.<QuerySeparatedValues>last(Iterators.<QuerySeparatedValues>filter(resource.getAllContents(), QuerySeparatedValues.class))).compile());
  }
}
