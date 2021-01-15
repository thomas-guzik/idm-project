package idm.provider;

/* Inspiration :
 * https://www.eclipse.org/forums/index.php/t/263021/
 */

import org.eclipse.xtext.generator.IGenerator2;
import org.eclipse.xtext.testing.GlobalRegistries;
import org.eclipse.xtext.testing.GlobalRegistries.GlobalStateMemento;
import org.eclipse.xtext.testing.IInjectorProvider;
import org.eclipse.xtext.testing.IRegistryConfigurator;

import com.google.inject.Guice;
import com.google.inject.Injector;

import idm.QsvRuntimeModule;
import idm.QsvStandaloneSetup;
import idm.generator.InterpreterGenerator;

public class InterpreterInjectorProvider implements IInjectorProvider, IRegistryConfigurator {

	protected GlobalStateMemento stateBeforeInjectorCreation;
	protected GlobalStateMemento stateAfterInjectorCreation;
	protected Injector injector;
	
	static {
		GlobalRegistries.initializeDefaults();
	}
	
	@Override
	public Injector getInjector() {
		if (injector == null) {
			this.injector = internalCreateInjector();
			stateAfterInjectorCreation = GlobalRegistries.makeCopyOfGlobalState();
		}
		return injector;
	}
	
	protected Injector internalCreateInjector() {
		return new QsvStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new QsvRuntimeModule() {
					@Override
					public Class<? extends IGenerator2> bindIGenerator2() {
						return  InterpreterGenerator.class;
					}
				});
			}
		}.createInjectorAndDoEMFRegistration();
	}
	

	@Override
	public void setupRegistry() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restoreRegistry() {
		// TODO Auto-generated method stub
		
	}
}