package idm.tests

import org.eclipse.xtext.xbase.testing.CompilationTestHelper

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import com.google.inject.Inject
import org.eclipse.xtext.generator.InMemoryFileSystemAccess

import idm.provider.BashInjectorProvider

@RunWith(XtextRunner)
@InjectWith(BashInjectorProvider)
class BashGeneratorTest {

	@Inject extension CompilationTestHelper
	
	InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
	
	@Test def test() {
		'''using foo.csv with column names: yes'''.assertCompilesTo('''hello python''');
	}

}
