/*
 * generated by Xtext 2.23.0
 */
package idm.parser.antlr;

import com.google.inject.Inject;
import idm.parser.antlr.internal.InternalQsvParser;
import idm.services.QsvGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class QsvParser extends AbstractAntlrParser {

	@Inject
	private QsvGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalQsvParser createParser(XtextTokenStream stream) {
		return new InternalQsvParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "QuerySeparatedValues";
	}

	public QsvGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(QsvGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
