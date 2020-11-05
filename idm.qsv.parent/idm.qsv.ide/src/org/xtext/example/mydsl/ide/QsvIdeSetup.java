/*
 * generated by Xtext 2.23.0
 */
package org.xtext.example.mydsl.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.util.Modules2;
import org.xtext.example.mydsl.QsvRuntimeModule;
import org.xtext.example.mydsl.QsvStandaloneSetup;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class QsvIdeSetup extends QsvStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new QsvRuntimeModule(), new QsvIdeModule()));
	}
	
}