package idm.tests

import com.google.inject.Inject
import org.eclipse.xtext.generator.InMemoryFileSystemAccess
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.xbase.testing.CompilationTestHelper
import org.junit.Test
import org.junit.runner.RunWith
import idm.provider.InterpreterInjectorProvider

@RunWith(XtextRunner)
@InjectWith(InterpreterInjectorProvider)
class InterpreterGeneratorTest {

	@Inject extension CompilationTestHelper
	
	InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
	
	@Test def test() {
		'''using foo.csv with column names: yes'''.assertCompilesTo('''hello interpreter''');
	}

}
