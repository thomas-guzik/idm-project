package idm.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import idm.services.QsvGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalQsvParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'no'", "'*'", "'in'", "'<'", "'>'", "'<='", "'>='", "'!='", "'not in'", "'using'", "'with'", "'column'", "'names:'", "'print'", "':columns'", "'-'", "'#'", "':lines'", "'or'", "'and'", "'('", "')'", "'yes'", "'='"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalQsvParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalQsvParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalQsvParser.tokenNames; }
    public String getGrammarFileName() { return "InternalQsv.g"; }


    	private QsvGrammarAccess grammarAccess;

    	public void setGrammarAccess(QsvGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleQuerySeparatedValues"
    // InternalQsv.g:53:1: entryRuleQuerySeparatedValues : ruleQuerySeparatedValues EOF ;
    public final void entryRuleQuerySeparatedValues() throws RecognitionException {
        try {
            // InternalQsv.g:54:1: ( ruleQuerySeparatedValues EOF )
            // InternalQsv.g:55:1: ruleQuerySeparatedValues EOF
            {
             before(grammarAccess.getQuerySeparatedValuesRule()); 
            pushFollow(FOLLOW_1);
            ruleQuerySeparatedValues();

            state._fsp--;

             after(grammarAccess.getQuerySeparatedValuesRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQuerySeparatedValues"


    // $ANTLR start "ruleQuerySeparatedValues"
    // InternalQsv.g:62:1: ruleQuerySeparatedValues : ( ( rule__QuerySeparatedValues__Group__0 ) ) ;
    public final void ruleQuerySeparatedValues() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:66:2: ( ( ( rule__QuerySeparatedValues__Group__0 ) ) )
            // InternalQsv.g:67:2: ( ( rule__QuerySeparatedValues__Group__0 ) )
            {
            // InternalQsv.g:67:2: ( ( rule__QuerySeparatedValues__Group__0 ) )
            // InternalQsv.g:68:3: ( rule__QuerySeparatedValues__Group__0 )
            {
             before(grammarAccess.getQuerySeparatedValuesAccess().getGroup()); 
            // InternalQsv.g:69:3: ( rule__QuerySeparatedValues__Group__0 )
            // InternalQsv.g:69:4: rule__QuerySeparatedValues__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QuerySeparatedValues__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQuerySeparatedValuesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQuerySeparatedValues"


    // $ANTLR start "entryRuleHeader"
    // InternalQsv.g:78:1: entryRuleHeader : ruleHeader EOF ;
    public final void entryRuleHeader() throws RecognitionException {
        try {
            // InternalQsv.g:79:1: ( ruleHeader EOF )
            // InternalQsv.g:80:1: ruleHeader EOF
            {
             before(grammarAccess.getHeaderRule()); 
            pushFollow(FOLLOW_1);
            ruleHeader();

            state._fsp--;

             after(grammarAccess.getHeaderRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHeader"


    // $ANTLR start "ruleHeader"
    // InternalQsv.g:87:1: ruleHeader : ( ( rule__Header__Group__0 ) ) ;
    public final void ruleHeader() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:91:2: ( ( ( rule__Header__Group__0 ) ) )
            // InternalQsv.g:92:2: ( ( rule__Header__Group__0 ) )
            {
            // InternalQsv.g:92:2: ( ( rule__Header__Group__0 ) )
            // InternalQsv.g:93:3: ( rule__Header__Group__0 )
            {
             before(grammarAccess.getHeaderAccess().getGroup()); 
            // InternalQsv.g:94:3: ( rule__Header__Group__0 )
            // InternalQsv.g:94:4: rule__Header__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Header__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHeaderAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHeader"


    // $ANTLR start "entryRuleStatement"
    // InternalQsv.g:103:1: entryRuleStatement : ruleStatement EOF ;
    public final void entryRuleStatement() throws RecognitionException {
        try {
            // InternalQsv.g:104:1: ( ruleStatement EOF )
            // InternalQsv.g:105:1: ruleStatement EOF
            {
             before(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_1);
            ruleStatement();

            state._fsp--;

             after(grammarAccess.getStatementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalQsv.g:112:1: ruleStatement : ( ( rule__Statement__StatementAssignment ) ) ;
    public final void ruleStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:116:2: ( ( ( rule__Statement__StatementAssignment ) ) )
            // InternalQsv.g:117:2: ( ( rule__Statement__StatementAssignment ) )
            {
            // InternalQsv.g:117:2: ( ( rule__Statement__StatementAssignment ) )
            // InternalQsv.g:118:3: ( rule__Statement__StatementAssignment )
            {
             before(grammarAccess.getStatementAccess().getStatementAssignment()); 
            // InternalQsv.g:119:3: ( rule__Statement__StatementAssignment )
            // InternalQsv.g:119:4: rule__Statement__StatementAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Statement__StatementAssignment();

            state._fsp--;


            }

             after(grammarAccess.getStatementAccess().getStatementAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRulePrint"
    // InternalQsv.g:128:1: entryRulePrint : rulePrint EOF ;
    public final void entryRulePrint() throws RecognitionException {
        try {
            // InternalQsv.g:129:1: ( rulePrint EOF )
            // InternalQsv.g:130:1: rulePrint EOF
            {
             before(grammarAccess.getPrintRule()); 
            pushFollow(FOLLOW_1);
            rulePrint();

            state._fsp--;

             after(grammarAccess.getPrintRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrint"


    // $ANTLR start "rulePrint"
    // InternalQsv.g:137:1: rulePrint : ( ( rule__Print__Group__0 ) ) ;
    public final void rulePrint() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:141:2: ( ( ( rule__Print__Group__0 ) ) )
            // InternalQsv.g:142:2: ( ( rule__Print__Group__0 ) )
            {
            // InternalQsv.g:142:2: ( ( rule__Print__Group__0 ) )
            // InternalQsv.g:143:3: ( rule__Print__Group__0 )
            {
             before(grammarAccess.getPrintAccess().getGroup()); 
            // InternalQsv.g:144:3: ( rule__Print__Group__0 )
            // InternalQsv.g:144:4: rule__Print__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Print__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPrintAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrint"


    // $ANTLR start "entryRuleSelector"
    // InternalQsv.g:153:1: entryRuleSelector : ruleSelector EOF ;
    public final void entryRuleSelector() throws RecognitionException {
        try {
            // InternalQsv.g:154:1: ( ruleSelector EOF )
            // InternalQsv.g:155:1: ruleSelector EOF
            {
             before(grammarAccess.getSelectorRule()); 
            pushFollow(FOLLOW_1);
            ruleSelector();

            state._fsp--;

             after(grammarAccess.getSelectorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSelector"


    // $ANTLR start "ruleSelector"
    // InternalQsv.g:162:1: ruleSelector : ( ( rule__Selector__Group__0 ) ) ;
    public final void ruleSelector() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:166:2: ( ( ( rule__Selector__Group__0 ) ) )
            // InternalQsv.g:167:2: ( ( rule__Selector__Group__0 ) )
            {
            // InternalQsv.g:167:2: ( ( rule__Selector__Group__0 ) )
            // InternalQsv.g:168:3: ( rule__Selector__Group__0 )
            {
             before(grammarAccess.getSelectorAccess().getGroup()); 
            // InternalQsv.g:169:3: ( rule__Selector__Group__0 )
            // InternalQsv.g:169:4: rule__Selector__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Selector__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSelectorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSelector"


    // $ANTLR start "entryRuleColumns"
    // InternalQsv.g:178:1: entryRuleColumns : ruleColumns EOF ;
    public final void entryRuleColumns() throws RecognitionException {
        try {
            // InternalQsv.g:179:1: ( ruleColumns EOF )
            // InternalQsv.g:180:1: ruleColumns EOF
            {
             before(grammarAccess.getColumnsRule()); 
            pushFollow(FOLLOW_1);
            ruleColumns();

            state._fsp--;

             after(grammarAccess.getColumnsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleColumns"


    // $ANTLR start "ruleColumns"
    // InternalQsv.g:187:1: ruleColumns : ( ( rule__Columns__Group__0 ) ) ;
    public final void ruleColumns() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:191:2: ( ( ( rule__Columns__Group__0 ) ) )
            // InternalQsv.g:192:2: ( ( rule__Columns__Group__0 ) )
            {
            // InternalQsv.g:192:2: ( ( rule__Columns__Group__0 ) )
            // InternalQsv.g:193:3: ( rule__Columns__Group__0 )
            {
             before(grammarAccess.getColumnsAccess().getGroup()); 
            // InternalQsv.g:194:3: ( rule__Columns__Group__0 )
            // InternalQsv.g:194:4: rule__Columns__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Columns__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getColumnsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleColumns"


    // $ANTLR start "entryRuleColRange"
    // InternalQsv.g:203:1: entryRuleColRange : ruleColRange EOF ;
    public final void entryRuleColRange() throws RecognitionException {
        try {
            // InternalQsv.g:204:1: ( ruleColRange EOF )
            // InternalQsv.g:205:1: ruleColRange EOF
            {
             before(grammarAccess.getColRangeRule()); 
            pushFollow(FOLLOW_1);
            ruleColRange();

            state._fsp--;

             after(grammarAccess.getColRangeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleColRange"


    // $ANTLR start "ruleColRange"
    // InternalQsv.g:212:1: ruleColRange : ( ( rule__ColRange__Group__0 ) ) ;
    public final void ruleColRange() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:216:2: ( ( ( rule__ColRange__Group__0 ) ) )
            // InternalQsv.g:217:2: ( ( rule__ColRange__Group__0 ) )
            {
            // InternalQsv.g:217:2: ( ( rule__ColRange__Group__0 ) )
            // InternalQsv.g:218:3: ( rule__ColRange__Group__0 )
            {
             before(grammarAccess.getColRangeAccess().getGroup()); 
            // InternalQsv.g:219:3: ( rule__ColRange__Group__0 )
            // InternalQsv.g:219:4: rule__ColRange__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ColRange__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getColRangeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleColRange"


    // $ANTLR start "entryRuleColumn"
    // InternalQsv.g:228:1: entryRuleColumn : ruleColumn EOF ;
    public final void entryRuleColumn() throws RecognitionException {
        try {
            // InternalQsv.g:229:1: ( ruleColumn EOF )
            // InternalQsv.g:230:1: ruleColumn EOF
            {
             before(grammarAccess.getColumnRule()); 
            pushFollow(FOLLOW_1);
            ruleColumn();

            state._fsp--;

             after(grammarAccess.getColumnRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleColumn"


    // $ANTLR start "ruleColumn"
    // InternalQsv.g:237:1: ruleColumn : ( ( rule__Column__Alternatives ) ) ;
    public final void ruleColumn() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:241:2: ( ( ( rule__Column__Alternatives ) ) )
            // InternalQsv.g:242:2: ( ( rule__Column__Alternatives ) )
            {
            // InternalQsv.g:242:2: ( ( rule__Column__Alternatives ) )
            // InternalQsv.g:243:3: ( rule__Column__Alternatives )
            {
             before(grammarAccess.getColumnAccess().getAlternatives()); 
            // InternalQsv.g:244:3: ( rule__Column__Alternatives )
            // InternalQsv.g:244:4: rule__Column__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Column__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getColumnAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleColumn"


    // $ANTLR start "entryRuleColumnName"
    // InternalQsv.g:253:1: entryRuleColumnName : ruleColumnName EOF ;
    public final void entryRuleColumnName() throws RecognitionException {
        try {
            // InternalQsv.g:254:1: ( ruleColumnName EOF )
            // InternalQsv.g:255:1: ruleColumnName EOF
            {
             before(grammarAccess.getColumnNameRule()); 
            pushFollow(FOLLOW_1);
            ruleColumnName();

            state._fsp--;

             after(grammarAccess.getColumnNameRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleColumnName"


    // $ANTLR start "ruleColumnName"
    // InternalQsv.g:262:1: ruleColumnName : ( ( rule__ColumnName__NamebAssignment ) ) ;
    public final void ruleColumnName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:266:2: ( ( ( rule__ColumnName__NamebAssignment ) ) )
            // InternalQsv.g:267:2: ( ( rule__ColumnName__NamebAssignment ) )
            {
            // InternalQsv.g:267:2: ( ( rule__ColumnName__NamebAssignment ) )
            // InternalQsv.g:268:3: ( rule__ColumnName__NamebAssignment )
            {
             before(grammarAccess.getColumnNameAccess().getNamebAssignment()); 
            // InternalQsv.g:269:3: ( rule__ColumnName__NamebAssignment )
            // InternalQsv.g:269:4: rule__ColumnName__NamebAssignment
            {
            pushFollow(FOLLOW_2);
            rule__ColumnName__NamebAssignment();

            state._fsp--;


            }

             after(grammarAccess.getColumnNameAccess().getNamebAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleColumnName"


    // $ANTLR start "entryRuleColumnNumber"
    // InternalQsv.g:278:1: entryRuleColumnNumber : ruleColumnNumber EOF ;
    public final void entryRuleColumnNumber() throws RecognitionException {
        try {
            // InternalQsv.g:279:1: ( ruleColumnNumber EOF )
            // InternalQsv.g:280:1: ruleColumnNumber EOF
            {
             before(grammarAccess.getColumnNumberRule()); 
            pushFollow(FOLLOW_1);
            ruleColumnNumber();

            state._fsp--;

             after(grammarAccess.getColumnNumberRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleColumnNumber"


    // $ANTLR start "ruleColumnNumber"
    // InternalQsv.g:287:1: ruleColumnNumber : ( ( rule__ColumnNumber__Group__0 ) ) ;
    public final void ruleColumnNumber() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:291:2: ( ( ( rule__ColumnNumber__Group__0 ) ) )
            // InternalQsv.g:292:2: ( ( rule__ColumnNumber__Group__0 ) )
            {
            // InternalQsv.g:292:2: ( ( rule__ColumnNumber__Group__0 ) )
            // InternalQsv.g:293:3: ( rule__ColumnNumber__Group__0 )
            {
             before(grammarAccess.getColumnNumberAccess().getGroup()); 
            // InternalQsv.g:294:3: ( rule__ColumnNumber__Group__0 )
            // InternalQsv.g:294:4: rule__ColumnNumber__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ColumnNumber__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getColumnNumberAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleColumnNumber"


    // $ANTLR start "entryRuleLines"
    // InternalQsv.g:303:1: entryRuleLines : ruleLines EOF ;
    public final void entryRuleLines() throws RecognitionException {
        try {
            // InternalQsv.g:304:1: ( ruleLines EOF )
            // InternalQsv.g:305:1: ruleLines EOF
            {
             before(grammarAccess.getLinesRule()); 
            pushFollow(FOLLOW_1);
            ruleLines();

            state._fsp--;

             after(grammarAccess.getLinesRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLines"


    // $ANTLR start "ruleLines"
    // InternalQsv.g:312:1: ruleLines : ( ( rule__Lines__Group__0 ) ) ;
    public final void ruleLines() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:316:2: ( ( ( rule__Lines__Group__0 ) ) )
            // InternalQsv.g:317:2: ( ( rule__Lines__Group__0 ) )
            {
            // InternalQsv.g:317:2: ( ( rule__Lines__Group__0 ) )
            // InternalQsv.g:318:3: ( rule__Lines__Group__0 )
            {
             before(grammarAccess.getLinesAccess().getGroup()); 
            // InternalQsv.g:319:3: ( rule__Lines__Group__0 )
            // InternalQsv.g:319:4: rule__Lines__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Lines__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLinesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLines"


    // $ANTLR start "entryRuleLineRange"
    // InternalQsv.g:328:1: entryRuleLineRange : ruleLineRange EOF ;
    public final void entryRuleLineRange() throws RecognitionException {
        try {
            // InternalQsv.g:329:1: ( ruleLineRange EOF )
            // InternalQsv.g:330:1: ruleLineRange EOF
            {
             before(grammarAccess.getLineRangeRule()); 
            pushFollow(FOLLOW_1);
            ruleLineRange();

            state._fsp--;

             after(grammarAccess.getLineRangeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLineRange"


    // $ANTLR start "ruleLineRange"
    // InternalQsv.g:337:1: ruleLineRange : ( ( rule__LineRange__Group__0 ) ) ;
    public final void ruleLineRange() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:341:2: ( ( ( rule__LineRange__Group__0 ) ) )
            // InternalQsv.g:342:2: ( ( rule__LineRange__Group__0 ) )
            {
            // InternalQsv.g:342:2: ( ( rule__LineRange__Group__0 ) )
            // InternalQsv.g:343:3: ( rule__LineRange__Group__0 )
            {
             before(grammarAccess.getLineRangeAccess().getGroup()); 
            // InternalQsv.g:344:3: ( rule__LineRange__Group__0 )
            // InternalQsv.g:344:4: rule__LineRange__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LineRange__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLineRangeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLineRange"


    // $ANTLR start "entryRuleLine"
    // InternalQsv.g:353:1: entryRuleLine : ruleLine EOF ;
    public final void entryRuleLine() throws RecognitionException {
        try {
            // InternalQsv.g:354:1: ( ruleLine EOF )
            // InternalQsv.g:355:1: ruleLine EOF
            {
             before(grammarAccess.getLineRule()); 
            pushFollow(FOLLOW_1);
            ruleLine();

            state._fsp--;

             after(grammarAccess.getLineRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLine"


    // $ANTLR start "ruleLine"
    // InternalQsv.g:362:1: ruleLine : ( ( rule__Line__Group__0 ) ) ;
    public final void ruleLine() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:366:2: ( ( ( rule__Line__Group__0 ) ) )
            // InternalQsv.g:367:2: ( ( rule__Line__Group__0 ) )
            {
            // InternalQsv.g:367:2: ( ( rule__Line__Group__0 ) )
            // InternalQsv.g:368:3: ( rule__Line__Group__0 )
            {
             before(grammarAccess.getLineAccess().getGroup()); 
            // InternalQsv.g:369:3: ( rule__Line__Group__0 )
            // InternalQsv.g:369:4: rule__Line__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Line__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLineAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLine"


    // $ANTLR start "entryRuleCondition"
    // InternalQsv.g:378:1: entryRuleCondition : ruleCondition EOF ;
    public final void entryRuleCondition() throws RecognitionException {
        try {
            // InternalQsv.g:379:1: ( ruleCondition EOF )
            // InternalQsv.g:380:1: ruleCondition EOF
            {
             before(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getConditionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalQsv.g:387:1: ruleCondition : ( ( rule__Condition__Group__0 ) ) ;
    public final void ruleCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:391:2: ( ( ( rule__Condition__Group__0 ) ) )
            // InternalQsv.g:392:2: ( ( rule__Condition__Group__0 ) )
            {
            // InternalQsv.g:392:2: ( ( rule__Condition__Group__0 ) )
            // InternalQsv.g:393:3: ( rule__Condition__Group__0 )
            {
             before(grammarAccess.getConditionAccess().getGroup()); 
            // InternalQsv.g:394:3: ( rule__Condition__Group__0 )
            // InternalQsv.g:394:4: rule__Condition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Condition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConditionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleMidPriority"
    // InternalQsv.g:403:1: entryRuleMidPriority : ruleMidPriority EOF ;
    public final void entryRuleMidPriority() throws RecognitionException {
        try {
            // InternalQsv.g:404:1: ( ruleMidPriority EOF )
            // InternalQsv.g:405:1: ruleMidPriority EOF
            {
             before(grammarAccess.getMidPriorityRule()); 
            pushFollow(FOLLOW_1);
            ruleMidPriority();

            state._fsp--;

             after(grammarAccess.getMidPriorityRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMidPriority"


    // $ANTLR start "ruleMidPriority"
    // InternalQsv.g:412:1: ruleMidPriority : ( ( rule__MidPriority__Group__0 ) ) ;
    public final void ruleMidPriority() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:416:2: ( ( ( rule__MidPriority__Group__0 ) ) )
            // InternalQsv.g:417:2: ( ( rule__MidPriority__Group__0 ) )
            {
            // InternalQsv.g:417:2: ( ( rule__MidPriority__Group__0 ) )
            // InternalQsv.g:418:3: ( rule__MidPriority__Group__0 )
            {
             before(grammarAccess.getMidPriorityAccess().getGroup()); 
            // InternalQsv.g:419:3: ( rule__MidPriority__Group__0 )
            // InternalQsv.g:419:4: rule__MidPriority__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MidPriority__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMidPriorityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMidPriority"


    // $ANTLR start "entryRuleHighestPriority"
    // InternalQsv.g:428:1: entryRuleHighestPriority : ruleHighestPriority EOF ;
    public final void entryRuleHighestPriority() throws RecognitionException {
        try {
            // InternalQsv.g:429:1: ( ruleHighestPriority EOF )
            // InternalQsv.g:430:1: ruleHighestPriority EOF
            {
             before(grammarAccess.getHighestPriorityRule()); 
            pushFollow(FOLLOW_1);
            ruleHighestPriority();

            state._fsp--;

             after(grammarAccess.getHighestPriorityRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHighestPriority"


    // $ANTLR start "ruleHighestPriority"
    // InternalQsv.g:437:1: ruleHighestPriority : ( ( rule__HighestPriority__Alternatives ) ) ;
    public final void ruleHighestPriority() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:441:2: ( ( ( rule__HighestPriority__Alternatives ) ) )
            // InternalQsv.g:442:2: ( ( rule__HighestPriority__Alternatives ) )
            {
            // InternalQsv.g:442:2: ( ( rule__HighestPriority__Alternatives ) )
            // InternalQsv.g:443:3: ( rule__HighestPriority__Alternatives )
            {
             before(grammarAccess.getHighestPriorityAccess().getAlternatives()); 
            // InternalQsv.g:444:3: ( rule__HighestPriority__Alternatives )
            // InternalQsv.g:444:4: rule__HighestPriority__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__HighestPriority__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getHighestPriorityAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHighestPriority"


    // $ANTLR start "entryRuleBinCond"
    // InternalQsv.g:453:1: entryRuleBinCond : ruleBinCond EOF ;
    public final void entryRuleBinCond() throws RecognitionException {
        try {
            // InternalQsv.g:454:1: ( ruleBinCond EOF )
            // InternalQsv.g:455:1: ruleBinCond EOF
            {
             before(grammarAccess.getBinCondRule()); 
            pushFollow(FOLLOW_1);
            ruleBinCond();

            state._fsp--;

             after(grammarAccess.getBinCondRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBinCond"


    // $ANTLR start "ruleBinCond"
    // InternalQsv.g:462:1: ruleBinCond : ( ( rule__BinCond__Group__0 ) ) ;
    public final void ruleBinCond() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:466:2: ( ( ( rule__BinCond__Group__0 ) ) )
            // InternalQsv.g:467:2: ( ( rule__BinCond__Group__0 ) )
            {
            // InternalQsv.g:467:2: ( ( rule__BinCond__Group__0 ) )
            // InternalQsv.g:468:3: ( rule__BinCond__Group__0 )
            {
             before(grammarAccess.getBinCondAccess().getGroup()); 
            // InternalQsv.g:469:3: ( rule__BinCond__Group__0 )
            // InternalQsv.g:469:4: rule__BinCond__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BinCond__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBinCondAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBinCond"


    // $ANTLR start "entryRuleOpComp"
    // InternalQsv.g:478:1: entryRuleOpComp : ruleOpComp EOF ;
    public final void entryRuleOpComp() throws RecognitionException {
        try {
            // InternalQsv.g:479:1: ( ruleOpComp EOF )
            // InternalQsv.g:480:1: ruleOpComp EOF
            {
             before(grammarAccess.getOpCompRule()); 
            pushFollow(FOLLOW_1);
            ruleOpComp();

            state._fsp--;

             after(grammarAccess.getOpCompRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOpComp"


    // $ANTLR start "ruleOpComp"
    // InternalQsv.g:487:1: ruleOpComp : ( ( rule__OpComp__Alternatives ) ) ;
    public final void ruleOpComp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:491:2: ( ( ( rule__OpComp__Alternatives ) ) )
            // InternalQsv.g:492:2: ( ( rule__OpComp__Alternatives ) )
            {
            // InternalQsv.g:492:2: ( ( rule__OpComp__Alternatives ) )
            // InternalQsv.g:493:3: ( rule__OpComp__Alternatives )
            {
             before(grammarAccess.getOpCompAccess().getAlternatives()); 
            // InternalQsv.g:494:3: ( rule__OpComp__Alternatives )
            // InternalQsv.g:494:4: rule__OpComp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OpComp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getOpCompAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpComp"


    // $ANTLR start "entryRuleBoolean"
    // InternalQsv.g:503:1: entryRuleBoolean : ruleBoolean EOF ;
    public final void entryRuleBoolean() throws RecognitionException {
        try {
            // InternalQsv.g:504:1: ( ruleBoolean EOF )
            // InternalQsv.g:505:1: ruleBoolean EOF
            {
             before(grammarAccess.getBooleanRule()); 
            pushFollow(FOLLOW_1);
            ruleBoolean();

            state._fsp--;

             after(grammarAccess.getBooleanRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // InternalQsv.g:512:1: ruleBoolean : ( ( rule__Boolean__Alternatives ) ) ;
    public final void ruleBoolean() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:516:2: ( ( ( rule__Boolean__Alternatives ) ) )
            // InternalQsv.g:517:2: ( ( rule__Boolean__Alternatives ) )
            {
            // InternalQsv.g:517:2: ( ( rule__Boolean__Alternatives ) )
            // InternalQsv.g:518:3: ( rule__Boolean__Alternatives )
            {
             before(grammarAccess.getBooleanAccess().getAlternatives()); 
            // InternalQsv.g:519:3: ( rule__Boolean__Alternatives )
            // InternalQsv.g:519:4: rule__Boolean__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Boolean__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBooleanAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBoolean"


    // $ANTLR start "rule__Header__Alternatives_5"
    // InternalQsv.g:527:1: rule__Header__Alternatives_5 : ( ( ( rule__Header__HasColumnNameAssignment_5_0 ) ) | ( 'no' ) );
    public final void rule__Header__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:531:1: ( ( ( rule__Header__HasColumnNameAssignment_5_0 ) ) | ( 'no' ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==33) ) {
                alt1=1;
            }
            else if ( (LA1_0==11) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalQsv.g:532:2: ( ( rule__Header__HasColumnNameAssignment_5_0 ) )
                    {
                    // InternalQsv.g:532:2: ( ( rule__Header__HasColumnNameAssignment_5_0 ) )
                    // InternalQsv.g:533:3: ( rule__Header__HasColumnNameAssignment_5_0 )
                    {
                     before(grammarAccess.getHeaderAccess().getHasColumnNameAssignment_5_0()); 
                    // InternalQsv.g:534:3: ( rule__Header__HasColumnNameAssignment_5_0 )
                    // InternalQsv.g:534:4: rule__Header__HasColumnNameAssignment_5_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Header__HasColumnNameAssignment_5_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getHeaderAccess().getHasColumnNameAssignment_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQsv.g:538:2: ( 'no' )
                    {
                    // InternalQsv.g:538:2: ( 'no' )
                    // InternalQsv.g:539:3: 'no'
                    {
                     before(grammarAccess.getHeaderAccess().getNoKeyword_5_1()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getHeaderAccess().getNoKeyword_5_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Header__Alternatives_5"


    // $ANTLR start "rule__Columns__Alternatives_1"
    // InternalQsv.g:548:1: rule__Columns__Alternatives_1 : ( ( ( rule__Columns__RangeAssignment_1_0 ) ) | ( ( rule__Columns__ColumnAssignment_1_1 ) ) | ( '*' ) );
    public final void rule__Columns__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:552:1: ( ( ( rule__Columns__RangeAssignment_1_0 ) ) | ( ( rule__Columns__ColumnAssignment_1_1 ) ) | ( '*' ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==EOF||LA2_1==24||LA2_1==28) ) {
                    alt2=2;
                }
                else if ( (LA2_1==26) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
                }
                break;
            case 27:
                {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==RULE_INT) ) {
                    int LA2_6 = input.LA(3);

                    if ( (LA2_6==EOF||LA2_6==24||LA2_6==28) ) {
                        alt2=2;
                    }
                    else if ( (LA2_6==26) ) {
                        alt2=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 6, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }
                }
                break;
            case 12:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalQsv.g:553:2: ( ( rule__Columns__RangeAssignment_1_0 ) )
                    {
                    // InternalQsv.g:553:2: ( ( rule__Columns__RangeAssignment_1_0 ) )
                    // InternalQsv.g:554:3: ( rule__Columns__RangeAssignment_1_0 )
                    {
                     before(grammarAccess.getColumnsAccess().getRangeAssignment_1_0()); 
                    // InternalQsv.g:555:3: ( rule__Columns__RangeAssignment_1_0 )
                    // InternalQsv.g:555:4: rule__Columns__RangeAssignment_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Columns__RangeAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getColumnsAccess().getRangeAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQsv.g:559:2: ( ( rule__Columns__ColumnAssignment_1_1 ) )
                    {
                    // InternalQsv.g:559:2: ( ( rule__Columns__ColumnAssignment_1_1 ) )
                    // InternalQsv.g:560:3: ( rule__Columns__ColumnAssignment_1_1 )
                    {
                     before(grammarAccess.getColumnsAccess().getColumnAssignment_1_1()); 
                    // InternalQsv.g:561:3: ( rule__Columns__ColumnAssignment_1_1 )
                    // InternalQsv.g:561:4: rule__Columns__ColumnAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Columns__ColumnAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getColumnsAccess().getColumnAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQsv.g:565:2: ( '*' )
                    {
                    // InternalQsv.g:565:2: ( '*' )
                    // InternalQsv.g:566:3: '*'
                    {
                     before(grammarAccess.getColumnsAccess().getAsteriskKeyword_1_2()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getColumnsAccess().getAsteriskKeyword_1_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Columns__Alternatives_1"


    // $ANTLR start "rule__Column__Alternatives"
    // InternalQsv.g:575:1: rule__Column__Alternatives : ( ( ruleColumnName ) | ( ruleColumnNumber ) );
    public final void rule__Column__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:579:1: ( ( ruleColumnName ) | ( ruleColumnNumber ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            else if ( (LA3_0==27) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalQsv.g:580:2: ( ruleColumnName )
                    {
                    // InternalQsv.g:580:2: ( ruleColumnName )
                    // InternalQsv.g:581:3: ruleColumnName
                    {
                     before(grammarAccess.getColumnAccess().getColumnNameParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleColumnName();

                    state._fsp--;

                     after(grammarAccess.getColumnAccess().getColumnNameParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQsv.g:586:2: ( ruleColumnNumber )
                    {
                    // InternalQsv.g:586:2: ( ruleColumnNumber )
                    // InternalQsv.g:587:3: ruleColumnNumber
                    {
                     before(grammarAccess.getColumnAccess().getColumnNumberParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleColumnNumber();

                    state._fsp--;

                     after(grammarAccess.getColumnAccess().getColumnNumberParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Column__Alternatives"


    // $ANTLR start "rule__Lines__Alternatives_1"
    // InternalQsv.g:596:1: rule__Lines__Alternatives_1 : ( ( ( rule__Lines__RangeAssignment_1_0 ) ) | ( ( rule__Lines__LineAssignment_1_1 ) ) | ( '*' ) );
    public final void rule__Lines__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:600:1: ( ( ( rule__Lines__RangeAssignment_1_0 ) ) | ( ( rule__Lines__LineAssignment_1_1 ) ) | ( '*' ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt4=1;
                }
                break;
            case 27:
                {
                alt4=2;
                }
                break;
            case 12:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalQsv.g:601:2: ( ( rule__Lines__RangeAssignment_1_0 ) )
                    {
                    // InternalQsv.g:601:2: ( ( rule__Lines__RangeAssignment_1_0 ) )
                    // InternalQsv.g:602:3: ( rule__Lines__RangeAssignment_1_0 )
                    {
                     before(grammarAccess.getLinesAccess().getRangeAssignment_1_0()); 
                    // InternalQsv.g:603:3: ( rule__Lines__RangeAssignment_1_0 )
                    // InternalQsv.g:603:4: rule__Lines__RangeAssignment_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Lines__RangeAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLinesAccess().getRangeAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQsv.g:607:2: ( ( rule__Lines__LineAssignment_1_1 ) )
                    {
                    // InternalQsv.g:607:2: ( ( rule__Lines__LineAssignment_1_1 ) )
                    // InternalQsv.g:608:3: ( rule__Lines__LineAssignment_1_1 )
                    {
                     before(grammarAccess.getLinesAccess().getLineAssignment_1_1()); 
                    // InternalQsv.g:609:3: ( rule__Lines__LineAssignment_1_1 )
                    // InternalQsv.g:609:4: rule__Lines__LineAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Lines__LineAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getLinesAccess().getLineAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQsv.g:613:2: ( '*' )
                    {
                    // InternalQsv.g:613:2: ( '*' )
                    // InternalQsv.g:614:3: '*'
                    {
                     before(grammarAccess.getLinesAccess().getAsteriskKeyword_1_2()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getLinesAccess().getAsteriskKeyword_1_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lines__Alternatives_1"


    // $ANTLR start "rule__HighestPriority__Alternatives"
    // InternalQsv.g:623:1: rule__HighestPriority__Alternatives : ( ( ( rule__HighestPriority__ConditionAssignment_0 ) ) | ( ( rule__HighestPriority__Group_1__0 ) ) );
    public final void rule__HighestPriority__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:627:1: ( ( ( rule__HighestPriority__ConditionAssignment_0 ) ) | ( ( rule__HighestPriority__Group_1__0 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            else if ( (LA5_0==31) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalQsv.g:628:2: ( ( rule__HighestPriority__ConditionAssignment_0 ) )
                    {
                    // InternalQsv.g:628:2: ( ( rule__HighestPriority__ConditionAssignment_0 ) )
                    // InternalQsv.g:629:3: ( rule__HighestPriority__ConditionAssignment_0 )
                    {
                     before(grammarAccess.getHighestPriorityAccess().getConditionAssignment_0()); 
                    // InternalQsv.g:630:3: ( rule__HighestPriority__ConditionAssignment_0 )
                    // InternalQsv.g:630:4: rule__HighestPriority__ConditionAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HighestPriority__ConditionAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getHighestPriorityAccess().getConditionAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQsv.g:634:2: ( ( rule__HighestPriority__Group_1__0 ) )
                    {
                    // InternalQsv.g:634:2: ( ( rule__HighestPriority__Group_1__0 ) )
                    // InternalQsv.g:635:3: ( rule__HighestPriority__Group_1__0 )
                    {
                     before(grammarAccess.getHighestPriorityAccess().getGroup_1()); 
                    // InternalQsv.g:636:3: ( rule__HighestPriority__Group_1__0 )
                    // InternalQsv.g:636:4: rule__HighestPriority__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HighestPriority__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getHighestPriorityAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HighestPriority__Alternatives"


    // $ANTLR start "rule__BinCond__Alternatives_2"
    // InternalQsv.g:644:1: rule__BinCond__Alternatives_2 : ( ( ( rule__BinCond__CompStrAssignment_2_0 ) ) | ( ( rule__BinCond__CompIdAssignment_2_1 ) ) | ( ( rule__BinCond__CompValueAssignment_2_2 ) ) );
    public final void rule__BinCond__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:648:1: ( ( ( rule__BinCond__CompStrAssignment_2_0 ) ) | ( ( rule__BinCond__CompIdAssignment_2_1 ) ) | ( ( rule__BinCond__CompValueAssignment_2_2 ) ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt6=1;
                }
                break;
            case RULE_ID:
                {
                alt6=2;
                }
                break;
            case RULE_INT:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalQsv.g:649:2: ( ( rule__BinCond__CompStrAssignment_2_0 ) )
                    {
                    // InternalQsv.g:649:2: ( ( rule__BinCond__CompStrAssignment_2_0 ) )
                    // InternalQsv.g:650:3: ( rule__BinCond__CompStrAssignment_2_0 )
                    {
                     before(grammarAccess.getBinCondAccess().getCompStrAssignment_2_0()); 
                    // InternalQsv.g:651:3: ( rule__BinCond__CompStrAssignment_2_0 )
                    // InternalQsv.g:651:4: rule__BinCond__CompStrAssignment_2_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BinCond__CompStrAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBinCondAccess().getCompStrAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQsv.g:655:2: ( ( rule__BinCond__CompIdAssignment_2_1 ) )
                    {
                    // InternalQsv.g:655:2: ( ( rule__BinCond__CompIdAssignment_2_1 ) )
                    // InternalQsv.g:656:3: ( rule__BinCond__CompIdAssignment_2_1 )
                    {
                     before(grammarAccess.getBinCondAccess().getCompIdAssignment_2_1()); 
                    // InternalQsv.g:657:3: ( rule__BinCond__CompIdAssignment_2_1 )
                    // InternalQsv.g:657:4: rule__BinCond__CompIdAssignment_2_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__BinCond__CompIdAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getBinCondAccess().getCompIdAssignment_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQsv.g:661:2: ( ( rule__BinCond__CompValueAssignment_2_2 ) )
                    {
                    // InternalQsv.g:661:2: ( ( rule__BinCond__CompValueAssignment_2_2 ) )
                    // InternalQsv.g:662:3: ( rule__BinCond__CompValueAssignment_2_2 )
                    {
                     before(grammarAccess.getBinCondAccess().getCompValueAssignment_2_2()); 
                    // InternalQsv.g:663:3: ( rule__BinCond__CompValueAssignment_2_2 )
                    // InternalQsv.g:663:4: rule__BinCond__CompValueAssignment_2_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__BinCond__CompValueAssignment_2_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getBinCondAccess().getCompValueAssignment_2_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinCond__Alternatives_2"


    // $ANTLR start "rule__OpComp__Alternatives"
    // InternalQsv.g:671:1: rule__OpComp__Alternatives : ( ( ( rule__OpComp__OpAssignment_0 ) ) | ( 'in' ) | ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '!=' ) | ( 'not in' ) );
    public final void rule__OpComp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:675:1: ( ( ( rule__OpComp__OpAssignment_0 ) ) | ( 'in' ) | ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '!=' ) | ( 'not in' ) )
            int alt7=8;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt7=1;
                }
                break;
            case 13:
                {
                alt7=2;
                }
                break;
            case 14:
                {
                alt7=3;
                }
                break;
            case 15:
                {
                alt7=4;
                }
                break;
            case 16:
                {
                alt7=5;
                }
                break;
            case 17:
                {
                alt7=6;
                }
                break;
            case 18:
                {
                alt7=7;
                }
                break;
            case 19:
                {
                alt7=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalQsv.g:676:2: ( ( rule__OpComp__OpAssignment_0 ) )
                    {
                    // InternalQsv.g:676:2: ( ( rule__OpComp__OpAssignment_0 ) )
                    // InternalQsv.g:677:3: ( rule__OpComp__OpAssignment_0 )
                    {
                     before(grammarAccess.getOpCompAccess().getOpAssignment_0()); 
                    // InternalQsv.g:678:3: ( rule__OpComp__OpAssignment_0 )
                    // InternalQsv.g:678:4: rule__OpComp__OpAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OpComp__OpAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getOpCompAccess().getOpAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQsv.g:682:2: ( 'in' )
                    {
                    // InternalQsv.g:682:2: ( 'in' )
                    // InternalQsv.g:683:3: 'in'
                    {
                     before(grammarAccess.getOpCompAccess().getInKeyword_1()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getOpCompAccess().getInKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQsv.g:688:2: ( '<' )
                    {
                    // InternalQsv.g:688:2: ( '<' )
                    // InternalQsv.g:689:3: '<'
                    {
                     before(grammarAccess.getOpCompAccess().getLessThanSignKeyword_2()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getOpCompAccess().getLessThanSignKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalQsv.g:694:2: ( '>' )
                    {
                    // InternalQsv.g:694:2: ( '>' )
                    // InternalQsv.g:695:3: '>'
                    {
                     before(grammarAccess.getOpCompAccess().getGreaterThanSignKeyword_3()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getOpCompAccess().getGreaterThanSignKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalQsv.g:700:2: ( '<=' )
                    {
                    // InternalQsv.g:700:2: ( '<=' )
                    // InternalQsv.g:701:3: '<='
                    {
                     before(grammarAccess.getOpCompAccess().getLessThanSignEqualsSignKeyword_4()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getOpCompAccess().getLessThanSignEqualsSignKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalQsv.g:706:2: ( '>=' )
                    {
                    // InternalQsv.g:706:2: ( '>=' )
                    // InternalQsv.g:707:3: '>='
                    {
                     before(grammarAccess.getOpCompAccess().getGreaterThanSignEqualsSignKeyword_5()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getOpCompAccess().getGreaterThanSignEqualsSignKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalQsv.g:712:2: ( '!=' )
                    {
                    // InternalQsv.g:712:2: ( '!=' )
                    // InternalQsv.g:713:3: '!='
                    {
                     before(grammarAccess.getOpCompAccess().getExclamationMarkEqualsSignKeyword_6()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getOpCompAccess().getExclamationMarkEqualsSignKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalQsv.g:718:2: ( 'not in' )
                    {
                    // InternalQsv.g:718:2: ( 'not in' )
                    // InternalQsv.g:719:3: 'not in'
                    {
                     before(grammarAccess.getOpCompAccess().getNotInKeyword_7()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getOpCompAccess().getNotInKeyword_7()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpComp__Alternatives"


    // $ANTLR start "rule__Boolean__Alternatives"
    // InternalQsv.g:728:1: rule__Boolean__Alternatives : ( ( ( rule__Boolean__BolAssignment_0 ) ) | ( 'no' ) );
    public final void rule__Boolean__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:732:1: ( ( ( rule__Boolean__BolAssignment_0 ) ) | ( 'no' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==33) ) {
                alt8=1;
            }
            else if ( (LA8_0==11) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalQsv.g:733:2: ( ( rule__Boolean__BolAssignment_0 ) )
                    {
                    // InternalQsv.g:733:2: ( ( rule__Boolean__BolAssignment_0 ) )
                    // InternalQsv.g:734:3: ( rule__Boolean__BolAssignment_0 )
                    {
                     before(grammarAccess.getBooleanAccess().getBolAssignment_0()); 
                    // InternalQsv.g:735:3: ( rule__Boolean__BolAssignment_0 )
                    // InternalQsv.g:735:4: rule__Boolean__BolAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Boolean__BolAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBooleanAccess().getBolAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQsv.g:739:2: ( 'no' )
                    {
                    // InternalQsv.g:739:2: ( 'no' )
                    // InternalQsv.g:740:3: 'no'
                    {
                     before(grammarAccess.getBooleanAccess().getNoKeyword_1()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getBooleanAccess().getNoKeyword_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Boolean__Alternatives"


    // $ANTLR start "rule__QuerySeparatedValues__Group__0"
    // InternalQsv.g:749:1: rule__QuerySeparatedValues__Group__0 : rule__QuerySeparatedValues__Group__0__Impl rule__QuerySeparatedValues__Group__1 ;
    public final void rule__QuerySeparatedValues__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:753:1: ( rule__QuerySeparatedValues__Group__0__Impl rule__QuerySeparatedValues__Group__1 )
            // InternalQsv.g:754:2: rule__QuerySeparatedValues__Group__0__Impl rule__QuerySeparatedValues__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__QuerySeparatedValues__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuerySeparatedValues__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuerySeparatedValues__Group__0"


    // $ANTLR start "rule__QuerySeparatedValues__Group__0__Impl"
    // InternalQsv.g:761:1: rule__QuerySeparatedValues__Group__0__Impl : ( ( rule__QuerySeparatedValues__HeaderAssignment_0 ) ) ;
    public final void rule__QuerySeparatedValues__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:765:1: ( ( ( rule__QuerySeparatedValues__HeaderAssignment_0 ) ) )
            // InternalQsv.g:766:1: ( ( rule__QuerySeparatedValues__HeaderAssignment_0 ) )
            {
            // InternalQsv.g:766:1: ( ( rule__QuerySeparatedValues__HeaderAssignment_0 ) )
            // InternalQsv.g:767:2: ( rule__QuerySeparatedValues__HeaderAssignment_0 )
            {
             before(grammarAccess.getQuerySeparatedValuesAccess().getHeaderAssignment_0()); 
            // InternalQsv.g:768:2: ( rule__QuerySeparatedValues__HeaderAssignment_0 )
            // InternalQsv.g:768:3: rule__QuerySeparatedValues__HeaderAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__QuerySeparatedValues__HeaderAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getQuerySeparatedValuesAccess().getHeaderAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuerySeparatedValues__Group__0__Impl"


    // $ANTLR start "rule__QuerySeparatedValues__Group__1"
    // InternalQsv.g:776:1: rule__QuerySeparatedValues__Group__1 : rule__QuerySeparatedValues__Group__1__Impl ;
    public final void rule__QuerySeparatedValues__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:780:1: ( rule__QuerySeparatedValues__Group__1__Impl )
            // InternalQsv.g:781:2: rule__QuerySeparatedValues__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuerySeparatedValues__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuerySeparatedValues__Group__1"


    // $ANTLR start "rule__QuerySeparatedValues__Group__1__Impl"
    // InternalQsv.g:787:1: rule__QuerySeparatedValues__Group__1__Impl : ( ( rule__QuerySeparatedValues__StatementsAssignment_1 )* ) ;
    public final void rule__QuerySeparatedValues__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:791:1: ( ( ( rule__QuerySeparatedValues__StatementsAssignment_1 )* ) )
            // InternalQsv.g:792:1: ( ( rule__QuerySeparatedValues__StatementsAssignment_1 )* )
            {
            // InternalQsv.g:792:1: ( ( rule__QuerySeparatedValues__StatementsAssignment_1 )* )
            // InternalQsv.g:793:2: ( rule__QuerySeparatedValues__StatementsAssignment_1 )*
            {
             before(grammarAccess.getQuerySeparatedValuesAccess().getStatementsAssignment_1()); 
            // InternalQsv.g:794:2: ( rule__QuerySeparatedValues__StatementsAssignment_1 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==24) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalQsv.g:794:3: rule__QuerySeparatedValues__StatementsAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__QuerySeparatedValues__StatementsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getQuerySeparatedValuesAccess().getStatementsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuerySeparatedValues__Group__1__Impl"


    // $ANTLR start "rule__Header__Group__0"
    // InternalQsv.g:803:1: rule__Header__Group__0 : rule__Header__Group__0__Impl rule__Header__Group__1 ;
    public final void rule__Header__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:807:1: ( rule__Header__Group__0__Impl rule__Header__Group__1 )
            // InternalQsv.g:808:2: rule__Header__Group__0__Impl rule__Header__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Header__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Header__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Header__Group__0"


    // $ANTLR start "rule__Header__Group__0__Impl"
    // InternalQsv.g:815:1: rule__Header__Group__0__Impl : ( 'using' ) ;
    public final void rule__Header__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:819:1: ( ( 'using' ) )
            // InternalQsv.g:820:1: ( 'using' )
            {
            // InternalQsv.g:820:1: ( 'using' )
            // InternalQsv.g:821:2: 'using'
            {
             before(grammarAccess.getHeaderAccess().getUsingKeyword_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getHeaderAccess().getUsingKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Header__Group__0__Impl"


    // $ANTLR start "rule__Header__Group__1"
    // InternalQsv.g:830:1: rule__Header__Group__1 : rule__Header__Group__1__Impl rule__Header__Group__2 ;
    public final void rule__Header__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:834:1: ( rule__Header__Group__1__Impl rule__Header__Group__2 )
            // InternalQsv.g:835:2: rule__Header__Group__1__Impl rule__Header__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__Header__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Header__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Header__Group__1"


    // $ANTLR start "rule__Header__Group__1__Impl"
    // InternalQsv.g:842:1: rule__Header__Group__1__Impl : ( ( rule__Header__NameFileAssignment_1 ) ) ;
    public final void rule__Header__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:846:1: ( ( ( rule__Header__NameFileAssignment_1 ) ) )
            // InternalQsv.g:847:1: ( ( rule__Header__NameFileAssignment_1 ) )
            {
            // InternalQsv.g:847:1: ( ( rule__Header__NameFileAssignment_1 ) )
            // InternalQsv.g:848:2: ( rule__Header__NameFileAssignment_1 )
            {
             before(grammarAccess.getHeaderAccess().getNameFileAssignment_1()); 
            // InternalQsv.g:849:2: ( rule__Header__NameFileAssignment_1 )
            // InternalQsv.g:849:3: rule__Header__NameFileAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Header__NameFileAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getHeaderAccess().getNameFileAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Header__Group__1__Impl"


    // $ANTLR start "rule__Header__Group__2"
    // InternalQsv.g:857:1: rule__Header__Group__2 : rule__Header__Group__2__Impl rule__Header__Group__3 ;
    public final void rule__Header__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:861:1: ( rule__Header__Group__2__Impl rule__Header__Group__3 )
            // InternalQsv.g:862:2: rule__Header__Group__2__Impl rule__Header__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__Header__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Header__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Header__Group__2"


    // $ANTLR start "rule__Header__Group__2__Impl"
    // InternalQsv.g:869:1: rule__Header__Group__2__Impl : ( 'with' ) ;
    public final void rule__Header__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:873:1: ( ( 'with' ) )
            // InternalQsv.g:874:1: ( 'with' )
            {
            // InternalQsv.g:874:1: ( 'with' )
            // InternalQsv.g:875:2: 'with'
            {
             before(grammarAccess.getHeaderAccess().getWithKeyword_2()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getHeaderAccess().getWithKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Header__Group__2__Impl"


    // $ANTLR start "rule__Header__Group__3"
    // InternalQsv.g:884:1: rule__Header__Group__3 : rule__Header__Group__3__Impl rule__Header__Group__4 ;
    public final void rule__Header__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:888:1: ( rule__Header__Group__3__Impl rule__Header__Group__4 )
            // InternalQsv.g:889:2: rule__Header__Group__3__Impl rule__Header__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__Header__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Header__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Header__Group__3"


    // $ANTLR start "rule__Header__Group__3__Impl"
    // InternalQsv.g:896:1: rule__Header__Group__3__Impl : ( 'column' ) ;
    public final void rule__Header__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:900:1: ( ( 'column' ) )
            // InternalQsv.g:901:1: ( 'column' )
            {
            // InternalQsv.g:901:1: ( 'column' )
            // InternalQsv.g:902:2: 'column'
            {
             before(grammarAccess.getHeaderAccess().getColumnKeyword_3()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getHeaderAccess().getColumnKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Header__Group__3__Impl"


    // $ANTLR start "rule__Header__Group__4"
    // InternalQsv.g:911:1: rule__Header__Group__4 : rule__Header__Group__4__Impl rule__Header__Group__5 ;
    public final void rule__Header__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:915:1: ( rule__Header__Group__4__Impl rule__Header__Group__5 )
            // InternalQsv.g:916:2: rule__Header__Group__4__Impl rule__Header__Group__5
            {
            pushFollow(FOLLOW_9);
            rule__Header__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Header__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Header__Group__4"


    // $ANTLR start "rule__Header__Group__4__Impl"
    // InternalQsv.g:923:1: rule__Header__Group__4__Impl : ( 'names:' ) ;
    public final void rule__Header__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:927:1: ( ( 'names:' ) )
            // InternalQsv.g:928:1: ( 'names:' )
            {
            // InternalQsv.g:928:1: ( 'names:' )
            // InternalQsv.g:929:2: 'names:'
            {
             before(grammarAccess.getHeaderAccess().getNamesKeyword_4()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getHeaderAccess().getNamesKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Header__Group__4__Impl"


    // $ANTLR start "rule__Header__Group__5"
    // InternalQsv.g:938:1: rule__Header__Group__5 : rule__Header__Group__5__Impl ;
    public final void rule__Header__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:942:1: ( rule__Header__Group__5__Impl )
            // InternalQsv.g:943:2: rule__Header__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Header__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Header__Group__5"


    // $ANTLR start "rule__Header__Group__5__Impl"
    // InternalQsv.g:949:1: rule__Header__Group__5__Impl : ( ( rule__Header__Alternatives_5 ) ) ;
    public final void rule__Header__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:953:1: ( ( ( rule__Header__Alternatives_5 ) ) )
            // InternalQsv.g:954:1: ( ( rule__Header__Alternatives_5 ) )
            {
            // InternalQsv.g:954:1: ( ( rule__Header__Alternatives_5 ) )
            // InternalQsv.g:955:2: ( rule__Header__Alternatives_5 )
            {
             before(grammarAccess.getHeaderAccess().getAlternatives_5()); 
            // InternalQsv.g:956:2: ( rule__Header__Alternatives_5 )
            // InternalQsv.g:956:3: rule__Header__Alternatives_5
            {
            pushFollow(FOLLOW_2);
            rule__Header__Alternatives_5();

            state._fsp--;


            }

             after(grammarAccess.getHeaderAccess().getAlternatives_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Header__Group__5__Impl"


    // $ANTLR start "rule__Print__Group__0"
    // InternalQsv.g:965:1: rule__Print__Group__0 : rule__Print__Group__0__Impl rule__Print__Group__1 ;
    public final void rule__Print__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:969:1: ( rule__Print__Group__0__Impl rule__Print__Group__1 )
            // InternalQsv.g:970:2: rule__Print__Group__0__Impl rule__Print__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__Print__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Print__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Print__Group__0"


    // $ANTLR start "rule__Print__Group__0__Impl"
    // InternalQsv.g:977:1: rule__Print__Group__0__Impl : ( 'print' ) ;
    public final void rule__Print__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:981:1: ( ( 'print' ) )
            // InternalQsv.g:982:1: ( 'print' )
            {
            // InternalQsv.g:982:1: ( 'print' )
            // InternalQsv.g:983:2: 'print'
            {
             before(grammarAccess.getPrintAccess().getPrintKeyword_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getPrintAccess().getPrintKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Print__Group__0__Impl"


    // $ANTLR start "rule__Print__Group__1"
    // InternalQsv.g:992:1: rule__Print__Group__1 : rule__Print__Group__1__Impl ;
    public final void rule__Print__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:996:1: ( rule__Print__Group__1__Impl )
            // InternalQsv.g:997:2: rule__Print__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Print__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Print__Group__1"


    // $ANTLR start "rule__Print__Group__1__Impl"
    // InternalQsv.g:1003:1: rule__Print__Group__1__Impl : ( ( rule__Print__SelectorAssignment_1 ) ) ;
    public final void rule__Print__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1007:1: ( ( ( rule__Print__SelectorAssignment_1 ) ) )
            // InternalQsv.g:1008:1: ( ( rule__Print__SelectorAssignment_1 ) )
            {
            // InternalQsv.g:1008:1: ( ( rule__Print__SelectorAssignment_1 ) )
            // InternalQsv.g:1009:2: ( rule__Print__SelectorAssignment_1 )
            {
             before(grammarAccess.getPrintAccess().getSelectorAssignment_1()); 
            // InternalQsv.g:1010:2: ( rule__Print__SelectorAssignment_1 )
            // InternalQsv.g:1010:3: rule__Print__SelectorAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Print__SelectorAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPrintAccess().getSelectorAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Print__Group__1__Impl"


    // $ANTLR start "rule__Selector__Group__0"
    // InternalQsv.g:1019:1: rule__Selector__Group__0 : rule__Selector__Group__0__Impl rule__Selector__Group__1 ;
    public final void rule__Selector__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1023:1: ( rule__Selector__Group__0__Impl rule__Selector__Group__1 )
            // InternalQsv.g:1024:2: rule__Selector__Group__0__Impl rule__Selector__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__Selector__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Selector__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selector__Group__0"


    // $ANTLR start "rule__Selector__Group__0__Impl"
    // InternalQsv.g:1031:1: rule__Selector__Group__0__Impl : ( ( rule__Selector__ColumnsAssignment_0 )? ) ;
    public final void rule__Selector__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1035:1: ( ( ( rule__Selector__ColumnsAssignment_0 )? ) )
            // InternalQsv.g:1036:1: ( ( rule__Selector__ColumnsAssignment_0 )? )
            {
            // InternalQsv.g:1036:1: ( ( rule__Selector__ColumnsAssignment_0 )? )
            // InternalQsv.g:1037:2: ( rule__Selector__ColumnsAssignment_0 )?
            {
             before(grammarAccess.getSelectorAccess().getColumnsAssignment_0()); 
            // InternalQsv.g:1038:2: ( rule__Selector__ColumnsAssignment_0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==25) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalQsv.g:1038:3: rule__Selector__ColumnsAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Selector__ColumnsAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSelectorAccess().getColumnsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selector__Group__0__Impl"


    // $ANTLR start "rule__Selector__Group__1"
    // InternalQsv.g:1046:1: rule__Selector__Group__1 : rule__Selector__Group__1__Impl ;
    public final void rule__Selector__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1050:1: ( rule__Selector__Group__1__Impl )
            // InternalQsv.g:1051:2: rule__Selector__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Selector__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selector__Group__1"


    // $ANTLR start "rule__Selector__Group__1__Impl"
    // InternalQsv.g:1057:1: rule__Selector__Group__1__Impl : ( ( rule__Selector__LinesAssignment_1 )? ) ;
    public final void rule__Selector__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1061:1: ( ( ( rule__Selector__LinesAssignment_1 )? ) )
            // InternalQsv.g:1062:1: ( ( rule__Selector__LinesAssignment_1 )? )
            {
            // InternalQsv.g:1062:1: ( ( rule__Selector__LinesAssignment_1 )? )
            // InternalQsv.g:1063:2: ( rule__Selector__LinesAssignment_1 )?
            {
             before(grammarAccess.getSelectorAccess().getLinesAssignment_1()); 
            // InternalQsv.g:1064:2: ( rule__Selector__LinesAssignment_1 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==28) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalQsv.g:1064:3: rule__Selector__LinesAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Selector__LinesAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSelectorAccess().getLinesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selector__Group__1__Impl"


    // $ANTLR start "rule__Columns__Group__0"
    // InternalQsv.g:1073:1: rule__Columns__Group__0 : rule__Columns__Group__0__Impl rule__Columns__Group__1 ;
    public final void rule__Columns__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1077:1: ( rule__Columns__Group__0__Impl rule__Columns__Group__1 )
            // InternalQsv.g:1078:2: rule__Columns__Group__0__Impl rule__Columns__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__Columns__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Columns__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Columns__Group__0"


    // $ANTLR start "rule__Columns__Group__0__Impl"
    // InternalQsv.g:1085:1: rule__Columns__Group__0__Impl : ( ':columns' ) ;
    public final void rule__Columns__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1089:1: ( ( ':columns' ) )
            // InternalQsv.g:1090:1: ( ':columns' )
            {
            // InternalQsv.g:1090:1: ( ':columns' )
            // InternalQsv.g:1091:2: ':columns'
            {
             before(grammarAccess.getColumnsAccess().getColumnsKeyword_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getColumnsAccess().getColumnsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Columns__Group__0__Impl"


    // $ANTLR start "rule__Columns__Group__1"
    // InternalQsv.g:1100:1: rule__Columns__Group__1 : rule__Columns__Group__1__Impl ;
    public final void rule__Columns__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1104:1: ( rule__Columns__Group__1__Impl )
            // InternalQsv.g:1105:2: rule__Columns__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Columns__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Columns__Group__1"


    // $ANTLR start "rule__Columns__Group__1__Impl"
    // InternalQsv.g:1111:1: rule__Columns__Group__1__Impl : ( ( rule__Columns__Alternatives_1 )? ) ;
    public final void rule__Columns__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1115:1: ( ( ( rule__Columns__Alternatives_1 )? ) )
            // InternalQsv.g:1116:1: ( ( rule__Columns__Alternatives_1 )? )
            {
            // InternalQsv.g:1116:1: ( ( rule__Columns__Alternatives_1 )? )
            // InternalQsv.g:1117:2: ( rule__Columns__Alternatives_1 )?
            {
             before(grammarAccess.getColumnsAccess().getAlternatives_1()); 
            // InternalQsv.g:1118:2: ( rule__Columns__Alternatives_1 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID||LA12_0==12||LA12_0==27) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalQsv.g:1118:3: rule__Columns__Alternatives_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Columns__Alternatives_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getColumnsAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Columns__Group__1__Impl"


    // $ANTLR start "rule__ColRange__Group__0"
    // InternalQsv.g:1127:1: rule__ColRange__Group__0 : rule__ColRange__Group__0__Impl rule__ColRange__Group__1 ;
    public final void rule__ColRange__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1131:1: ( rule__ColRange__Group__0__Impl rule__ColRange__Group__1 )
            // InternalQsv.g:1132:2: rule__ColRange__Group__0__Impl rule__ColRange__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__ColRange__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ColRange__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColRange__Group__0"


    // $ANTLR start "rule__ColRange__Group__0__Impl"
    // InternalQsv.g:1139:1: rule__ColRange__Group__0__Impl : ( ( rule__ColRange__StartAssignment_0 ) ) ;
    public final void rule__ColRange__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1143:1: ( ( ( rule__ColRange__StartAssignment_0 ) ) )
            // InternalQsv.g:1144:1: ( ( rule__ColRange__StartAssignment_0 ) )
            {
            // InternalQsv.g:1144:1: ( ( rule__ColRange__StartAssignment_0 ) )
            // InternalQsv.g:1145:2: ( rule__ColRange__StartAssignment_0 )
            {
             before(grammarAccess.getColRangeAccess().getStartAssignment_0()); 
            // InternalQsv.g:1146:2: ( rule__ColRange__StartAssignment_0 )
            // InternalQsv.g:1146:3: rule__ColRange__StartAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ColRange__StartAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getColRangeAccess().getStartAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColRange__Group__0__Impl"


    // $ANTLR start "rule__ColRange__Group__1"
    // InternalQsv.g:1154:1: rule__ColRange__Group__1 : rule__ColRange__Group__1__Impl rule__ColRange__Group__2 ;
    public final void rule__ColRange__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1158:1: ( rule__ColRange__Group__1__Impl rule__ColRange__Group__2 )
            // InternalQsv.g:1159:2: rule__ColRange__Group__1__Impl rule__ColRange__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__ColRange__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ColRange__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColRange__Group__1"


    // $ANTLR start "rule__ColRange__Group__1__Impl"
    // InternalQsv.g:1166:1: rule__ColRange__Group__1__Impl : ( '-' ) ;
    public final void rule__ColRange__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1170:1: ( ( '-' ) )
            // InternalQsv.g:1171:1: ( '-' )
            {
            // InternalQsv.g:1171:1: ( '-' )
            // InternalQsv.g:1172:2: '-'
            {
             before(grammarAccess.getColRangeAccess().getHyphenMinusKeyword_1()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getColRangeAccess().getHyphenMinusKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColRange__Group__1__Impl"


    // $ANTLR start "rule__ColRange__Group__2"
    // InternalQsv.g:1181:1: rule__ColRange__Group__2 : rule__ColRange__Group__2__Impl ;
    public final void rule__ColRange__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1185:1: ( rule__ColRange__Group__2__Impl )
            // InternalQsv.g:1186:2: rule__ColRange__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ColRange__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColRange__Group__2"


    // $ANTLR start "rule__ColRange__Group__2__Impl"
    // InternalQsv.g:1192:1: rule__ColRange__Group__2__Impl : ( ( rule__ColRange__EndAssignment_2 ) ) ;
    public final void rule__ColRange__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1196:1: ( ( ( rule__ColRange__EndAssignment_2 ) ) )
            // InternalQsv.g:1197:1: ( ( rule__ColRange__EndAssignment_2 ) )
            {
            // InternalQsv.g:1197:1: ( ( rule__ColRange__EndAssignment_2 ) )
            // InternalQsv.g:1198:2: ( rule__ColRange__EndAssignment_2 )
            {
             before(grammarAccess.getColRangeAccess().getEndAssignment_2()); 
            // InternalQsv.g:1199:2: ( rule__ColRange__EndAssignment_2 )
            // InternalQsv.g:1199:3: rule__ColRange__EndAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ColRange__EndAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getColRangeAccess().getEndAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColRange__Group__2__Impl"


    // $ANTLR start "rule__ColumnNumber__Group__0"
    // InternalQsv.g:1208:1: rule__ColumnNumber__Group__0 : rule__ColumnNumber__Group__0__Impl rule__ColumnNumber__Group__1 ;
    public final void rule__ColumnNumber__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1212:1: ( rule__ColumnNumber__Group__0__Impl rule__ColumnNumber__Group__1 )
            // InternalQsv.g:1213:2: rule__ColumnNumber__Group__0__Impl rule__ColumnNumber__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__ColumnNumber__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ColumnNumber__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColumnNumber__Group__0"


    // $ANTLR start "rule__ColumnNumber__Group__0__Impl"
    // InternalQsv.g:1220:1: rule__ColumnNumber__Group__0__Impl : ( '#' ) ;
    public final void rule__ColumnNumber__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1224:1: ( ( '#' ) )
            // InternalQsv.g:1225:1: ( '#' )
            {
            // InternalQsv.g:1225:1: ( '#' )
            // InternalQsv.g:1226:2: '#'
            {
             before(grammarAccess.getColumnNumberAccess().getNumberSignKeyword_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getColumnNumberAccess().getNumberSignKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColumnNumber__Group__0__Impl"


    // $ANTLR start "rule__ColumnNumber__Group__1"
    // InternalQsv.g:1235:1: rule__ColumnNumber__Group__1 : rule__ColumnNumber__Group__1__Impl ;
    public final void rule__ColumnNumber__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1239:1: ( rule__ColumnNumber__Group__1__Impl )
            // InternalQsv.g:1240:2: rule__ColumnNumber__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ColumnNumber__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColumnNumber__Group__1"


    // $ANTLR start "rule__ColumnNumber__Group__1__Impl"
    // InternalQsv.g:1246:1: rule__ColumnNumber__Group__1__Impl : ( ( rule__ColumnNumber__NumberAssignment_1 ) ) ;
    public final void rule__ColumnNumber__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1250:1: ( ( ( rule__ColumnNumber__NumberAssignment_1 ) ) )
            // InternalQsv.g:1251:1: ( ( rule__ColumnNumber__NumberAssignment_1 ) )
            {
            // InternalQsv.g:1251:1: ( ( rule__ColumnNumber__NumberAssignment_1 ) )
            // InternalQsv.g:1252:2: ( rule__ColumnNumber__NumberAssignment_1 )
            {
             before(grammarAccess.getColumnNumberAccess().getNumberAssignment_1()); 
            // InternalQsv.g:1253:2: ( rule__ColumnNumber__NumberAssignment_1 )
            // InternalQsv.g:1253:3: rule__ColumnNumber__NumberAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ColumnNumber__NumberAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getColumnNumberAccess().getNumberAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColumnNumber__Group__1__Impl"


    // $ANTLR start "rule__Lines__Group__0"
    // InternalQsv.g:1262:1: rule__Lines__Group__0 : rule__Lines__Group__0__Impl rule__Lines__Group__1 ;
    public final void rule__Lines__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1266:1: ( rule__Lines__Group__0__Impl rule__Lines__Group__1 )
            // InternalQsv.g:1267:2: rule__Lines__Group__0__Impl rule__Lines__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__Lines__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lines__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lines__Group__0"


    // $ANTLR start "rule__Lines__Group__0__Impl"
    // InternalQsv.g:1274:1: rule__Lines__Group__0__Impl : ( ':lines' ) ;
    public final void rule__Lines__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1278:1: ( ( ':lines' ) )
            // InternalQsv.g:1279:1: ( ':lines' )
            {
            // InternalQsv.g:1279:1: ( ':lines' )
            // InternalQsv.g:1280:2: ':lines'
            {
             before(grammarAccess.getLinesAccess().getLinesKeyword_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getLinesAccess().getLinesKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lines__Group__0__Impl"


    // $ANTLR start "rule__Lines__Group__1"
    // InternalQsv.g:1289:1: rule__Lines__Group__1 : rule__Lines__Group__1__Impl rule__Lines__Group__2 ;
    public final void rule__Lines__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1293:1: ( rule__Lines__Group__1__Impl rule__Lines__Group__2 )
            // InternalQsv.g:1294:2: rule__Lines__Group__1__Impl rule__Lines__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__Lines__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lines__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lines__Group__1"


    // $ANTLR start "rule__Lines__Group__1__Impl"
    // InternalQsv.g:1301:1: rule__Lines__Group__1__Impl : ( ( rule__Lines__Alternatives_1 )? ) ;
    public final void rule__Lines__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1305:1: ( ( ( rule__Lines__Alternatives_1 )? ) )
            // InternalQsv.g:1306:1: ( ( rule__Lines__Alternatives_1 )? )
            {
            // InternalQsv.g:1306:1: ( ( rule__Lines__Alternatives_1 )? )
            // InternalQsv.g:1307:2: ( rule__Lines__Alternatives_1 )?
            {
             before(grammarAccess.getLinesAccess().getAlternatives_1()); 
            // InternalQsv.g:1308:2: ( rule__Lines__Alternatives_1 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_INT||LA13_0==12||LA13_0==27) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalQsv.g:1308:3: rule__Lines__Alternatives_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Lines__Alternatives_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLinesAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lines__Group__1__Impl"


    // $ANTLR start "rule__Lines__Group__2"
    // InternalQsv.g:1316:1: rule__Lines__Group__2 : rule__Lines__Group__2__Impl ;
    public final void rule__Lines__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1320:1: ( rule__Lines__Group__2__Impl )
            // InternalQsv.g:1321:2: rule__Lines__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Lines__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lines__Group__2"


    // $ANTLR start "rule__Lines__Group__2__Impl"
    // InternalQsv.g:1327:1: rule__Lines__Group__2__Impl : ( ( rule__Lines__CondAssignment_2 )? ) ;
    public final void rule__Lines__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1331:1: ( ( ( rule__Lines__CondAssignment_2 )? ) )
            // InternalQsv.g:1332:1: ( ( rule__Lines__CondAssignment_2 )? )
            {
            // InternalQsv.g:1332:1: ( ( rule__Lines__CondAssignment_2 )? )
            // InternalQsv.g:1333:2: ( rule__Lines__CondAssignment_2 )?
            {
             before(grammarAccess.getLinesAccess().getCondAssignment_2()); 
            // InternalQsv.g:1334:2: ( rule__Lines__CondAssignment_2 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID||LA14_0==31) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalQsv.g:1334:3: rule__Lines__CondAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Lines__CondAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLinesAccess().getCondAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lines__Group__2__Impl"


    // $ANTLR start "rule__LineRange__Group__0"
    // InternalQsv.g:1343:1: rule__LineRange__Group__0 : rule__LineRange__Group__0__Impl rule__LineRange__Group__1 ;
    public final void rule__LineRange__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1347:1: ( rule__LineRange__Group__0__Impl rule__LineRange__Group__1 )
            // InternalQsv.g:1348:2: rule__LineRange__Group__0__Impl rule__LineRange__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__LineRange__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LineRange__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineRange__Group__0"


    // $ANTLR start "rule__LineRange__Group__0__Impl"
    // InternalQsv.g:1355:1: rule__LineRange__Group__0__Impl : ( ( rule__LineRange__StartAssignment_0 ) ) ;
    public final void rule__LineRange__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1359:1: ( ( ( rule__LineRange__StartAssignment_0 ) ) )
            // InternalQsv.g:1360:1: ( ( rule__LineRange__StartAssignment_0 ) )
            {
            // InternalQsv.g:1360:1: ( ( rule__LineRange__StartAssignment_0 ) )
            // InternalQsv.g:1361:2: ( rule__LineRange__StartAssignment_0 )
            {
             before(grammarAccess.getLineRangeAccess().getStartAssignment_0()); 
            // InternalQsv.g:1362:2: ( rule__LineRange__StartAssignment_0 )
            // InternalQsv.g:1362:3: rule__LineRange__StartAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__LineRange__StartAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getLineRangeAccess().getStartAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineRange__Group__0__Impl"


    // $ANTLR start "rule__LineRange__Group__1"
    // InternalQsv.g:1370:1: rule__LineRange__Group__1 : rule__LineRange__Group__1__Impl rule__LineRange__Group__2 ;
    public final void rule__LineRange__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1374:1: ( rule__LineRange__Group__1__Impl rule__LineRange__Group__2 )
            // InternalQsv.g:1375:2: rule__LineRange__Group__1__Impl rule__LineRange__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__LineRange__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LineRange__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineRange__Group__1"


    // $ANTLR start "rule__LineRange__Group__1__Impl"
    // InternalQsv.g:1382:1: rule__LineRange__Group__1__Impl : ( '-' ) ;
    public final void rule__LineRange__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1386:1: ( ( '-' ) )
            // InternalQsv.g:1387:1: ( '-' )
            {
            // InternalQsv.g:1387:1: ( '-' )
            // InternalQsv.g:1388:2: '-'
            {
             before(grammarAccess.getLineRangeAccess().getHyphenMinusKeyword_1()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getLineRangeAccess().getHyphenMinusKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineRange__Group__1__Impl"


    // $ANTLR start "rule__LineRange__Group__2"
    // InternalQsv.g:1397:1: rule__LineRange__Group__2 : rule__LineRange__Group__2__Impl ;
    public final void rule__LineRange__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1401:1: ( rule__LineRange__Group__2__Impl )
            // InternalQsv.g:1402:2: rule__LineRange__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LineRange__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineRange__Group__2"


    // $ANTLR start "rule__LineRange__Group__2__Impl"
    // InternalQsv.g:1408:1: rule__LineRange__Group__2__Impl : ( ( rule__LineRange__EndAssignment_2 ) ) ;
    public final void rule__LineRange__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1412:1: ( ( ( rule__LineRange__EndAssignment_2 ) ) )
            // InternalQsv.g:1413:1: ( ( rule__LineRange__EndAssignment_2 ) )
            {
            // InternalQsv.g:1413:1: ( ( rule__LineRange__EndAssignment_2 ) )
            // InternalQsv.g:1414:2: ( rule__LineRange__EndAssignment_2 )
            {
             before(grammarAccess.getLineRangeAccess().getEndAssignment_2()); 
            // InternalQsv.g:1415:2: ( rule__LineRange__EndAssignment_2 )
            // InternalQsv.g:1415:3: rule__LineRange__EndAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__LineRange__EndAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getLineRangeAccess().getEndAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineRange__Group__2__Impl"


    // $ANTLR start "rule__Line__Group__0"
    // InternalQsv.g:1424:1: rule__Line__Group__0 : rule__Line__Group__0__Impl rule__Line__Group__1 ;
    public final void rule__Line__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1428:1: ( rule__Line__Group__0__Impl rule__Line__Group__1 )
            // InternalQsv.g:1429:2: rule__Line__Group__0__Impl rule__Line__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__Line__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Line__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Line__Group__0"


    // $ANTLR start "rule__Line__Group__0__Impl"
    // InternalQsv.g:1436:1: rule__Line__Group__0__Impl : ( '#' ) ;
    public final void rule__Line__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1440:1: ( ( '#' ) )
            // InternalQsv.g:1441:1: ( '#' )
            {
            // InternalQsv.g:1441:1: ( '#' )
            // InternalQsv.g:1442:2: '#'
            {
             before(grammarAccess.getLineAccess().getNumberSignKeyword_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getLineAccess().getNumberSignKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Line__Group__0__Impl"


    // $ANTLR start "rule__Line__Group__1"
    // InternalQsv.g:1451:1: rule__Line__Group__1 : rule__Line__Group__1__Impl ;
    public final void rule__Line__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1455:1: ( rule__Line__Group__1__Impl )
            // InternalQsv.g:1456:2: rule__Line__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Line__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Line__Group__1"


    // $ANTLR start "rule__Line__Group__1__Impl"
    // InternalQsv.g:1462:1: rule__Line__Group__1__Impl : ( ( rule__Line__NumberAssignment_1 ) ) ;
    public final void rule__Line__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1466:1: ( ( ( rule__Line__NumberAssignment_1 ) ) )
            // InternalQsv.g:1467:1: ( ( rule__Line__NumberAssignment_1 ) )
            {
            // InternalQsv.g:1467:1: ( ( rule__Line__NumberAssignment_1 ) )
            // InternalQsv.g:1468:2: ( rule__Line__NumberAssignment_1 )
            {
             before(grammarAccess.getLineAccess().getNumberAssignment_1()); 
            // InternalQsv.g:1469:2: ( rule__Line__NumberAssignment_1 )
            // InternalQsv.g:1469:3: rule__Line__NumberAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Line__NumberAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getLineAccess().getNumberAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Line__Group__1__Impl"


    // $ANTLR start "rule__Condition__Group__0"
    // InternalQsv.g:1478:1: rule__Condition__Group__0 : rule__Condition__Group__0__Impl rule__Condition__Group__1 ;
    public final void rule__Condition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1482:1: ( rule__Condition__Group__0__Impl rule__Condition__Group__1 )
            // InternalQsv.g:1483:2: rule__Condition__Group__0__Impl rule__Condition__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__Condition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__0"


    // $ANTLR start "rule__Condition__Group__0__Impl"
    // InternalQsv.g:1490:1: rule__Condition__Group__0__Impl : ( ( rule__Condition__MidAssignment_0 ) ) ;
    public final void rule__Condition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1494:1: ( ( ( rule__Condition__MidAssignment_0 ) ) )
            // InternalQsv.g:1495:1: ( ( rule__Condition__MidAssignment_0 ) )
            {
            // InternalQsv.g:1495:1: ( ( rule__Condition__MidAssignment_0 ) )
            // InternalQsv.g:1496:2: ( rule__Condition__MidAssignment_0 )
            {
             before(grammarAccess.getConditionAccess().getMidAssignment_0()); 
            // InternalQsv.g:1497:2: ( rule__Condition__MidAssignment_0 )
            // InternalQsv.g:1497:3: rule__Condition__MidAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Condition__MidAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getConditionAccess().getMidAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__0__Impl"


    // $ANTLR start "rule__Condition__Group__1"
    // InternalQsv.g:1505:1: rule__Condition__Group__1 : rule__Condition__Group__1__Impl ;
    public final void rule__Condition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1509:1: ( rule__Condition__Group__1__Impl )
            // InternalQsv.g:1510:2: rule__Condition__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Condition__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__1"


    // $ANTLR start "rule__Condition__Group__1__Impl"
    // InternalQsv.g:1516:1: rule__Condition__Group__1__Impl : ( ( rule__Condition__Group_1__0 )? ) ;
    public final void rule__Condition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1520:1: ( ( ( rule__Condition__Group_1__0 )? ) )
            // InternalQsv.g:1521:1: ( ( rule__Condition__Group_1__0 )? )
            {
            // InternalQsv.g:1521:1: ( ( rule__Condition__Group_1__0 )? )
            // InternalQsv.g:1522:2: ( rule__Condition__Group_1__0 )?
            {
             before(grammarAccess.getConditionAccess().getGroup_1()); 
            // InternalQsv.g:1523:2: ( rule__Condition__Group_1__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==29) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalQsv.g:1523:3: rule__Condition__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Condition__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConditionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__1__Impl"


    // $ANTLR start "rule__Condition__Group_1__0"
    // InternalQsv.g:1532:1: rule__Condition__Group_1__0 : rule__Condition__Group_1__0__Impl rule__Condition__Group_1__1 ;
    public final void rule__Condition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1536:1: ( rule__Condition__Group_1__0__Impl rule__Condition__Group_1__1 )
            // InternalQsv.g:1537:2: rule__Condition__Group_1__0__Impl rule__Condition__Group_1__1
            {
            pushFollow(FOLLOW_17);
            rule__Condition__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group_1__0"


    // $ANTLR start "rule__Condition__Group_1__0__Impl"
    // InternalQsv.g:1544:1: rule__Condition__Group_1__0__Impl : ( 'or' ) ;
    public final void rule__Condition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1548:1: ( ( 'or' ) )
            // InternalQsv.g:1549:1: ( 'or' )
            {
            // InternalQsv.g:1549:1: ( 'or' )
            // InternalQsv.g:1550:2: 'or'
            {
             before(grammarAccess.getConditionAccess().getOrKeyword_1_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getOrKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group_1__0__Impl"


    // $ANTLR start "rule__Condition__Group_1__1"
    // InternalQsv.g:1559:1: rule__Condition__Group_1__1 : rule__Condition__Group_1__1__Impl ;
    public final void rule__Condition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1563:1: ( rule__Condition__Group_1__1__Impl )
            // InternalQsv.g:1564:2: rule__Condition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Condition__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group_1__1"


    // $ANTLR start "rule__Condition__Group_1__1__Impl"
    // InternalQsv.g:1570:1: rule__Condition__Group_1__1__Impl : ( ( rule__Condition__OrConditionAssignment_1_1 ) ) ;
    public final void rule__Condition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1574:1: ( ( ( rule__Condition__OrConditionAssignment_1_1 ) ) )
            // InternalQsv.g:1575:1: ( ( rule__Condition__OrConditionAssignment_1_1 ) )
            {
            // InternalQsv.g:1575:1: ( ( rule__Condition__OrConditionAssignment_1_1 ) )
            // InternalQsv.g:1576:2: ( rule__Condition__OrConditionAssignment_1_1 )
            {
             before(grammarAccess.getConditionAccess().getOrConditionAssignment_1_1()); 
            // InternalQsv.g:1577:2: ( rule__Condition__OrConditionAssignment_1_1 )
            // InternalQsv.g:1577:3: rule__Condition__OrConditionAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Condition__OrConditionAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getConditionAccess().getOrConditionAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group_1__1__Impl"


    // $ANTLR start "rule__MidPriority__Group__0"
    // InternalQsv.g:1586:1: rule__MidPriority__Group__0 : rule__MidPriority__Group__0__Impl rule__MidPriority__Group__1 ;
    public final void rule__MidPriority__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1590:1: ( rule__MidPriority__Group__0__Impl rule__MidPriority__Group__1 )
            // InternalQsv.g:1591:2: rule__MidPriority__Group__0__Impl rule__MidPriority__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__MidPriority__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MidPriority__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidPriority__Group__0"


    // $ANTLR start "rule__MidPriority__Group__0__Impl"
    // InternalQsv.g:1598:1: rule__MidPriority__Group__0__Impl : ( ( rule__MidPriority__HighAssignment_0 ) ) ;
    public final void rule__MidPriority__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1602:1: ( ( ( rule__MidPriority__HighAssignment_0 ) ) )
            // InternalQsv.g:1603:1: ( ( rule__MidPriority__HighAssignment_0 ) )
            {
            // InternalQsv.g:1603:1: ( ( rule__MidPriority__HighAssignment_0 ) )
            // InternalQsv.g:1604:2: ( rule__MidPriority__HighAssignment_0 )
            {
             before(grammarAccess.getMidPriorityAccess().getHighAssignment_0()); 
            // InternalQsv.g:1605:2: ( rule__MidPriority__HighAssignment_0 )
            // InternalQsv.g:1605:3: rule__MidPriority__HighAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__MidPriority__HighAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMidPriorityAccess().getHighAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidPriority__Group__0__Impl"


    // $ANTLR start "rule__MidPriority__Group__1"
    // InternalQsv.g:1613:1: rule__MidPriority__Group__1 : rule__MidPriority__Group__1__Impl ;
    public final void rule__MidPriority__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1617:1: ( rule__MidPriority__Group__1__Impl )
            // InternalQsv.g:1618:2: rule__MidPriority__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MidPriority__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidPriority__Group__1"


    // $ANTLR start "rule__MidPriority__Group__1__Impl"
    // InternalQsv.g:1624:1: rule__MidPriority__Group__1__Impl : ( ( rule__MidPriority__Group_1__0 )? ) ;
    public final void rule__MidPriority__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1628:1: ( ( ( rule__MidPriority__Group_1__0 )? ) )
            // InternalQsv.g:1629:1: ( ( rule__MidPriority__Group_1__0 )? )
            {
            // InternalQsv.g:1629:1: ( ( rule__MidPriority__Group_1__0 )? )
            // InternalQsv.g:1630:2: ( rule__MidPriority__Group_1__0 )?
            {
             before(grammarAccess.getMidPriorityAccess().getGroup_1()); 
            // InternalQsv.g:1631:2: ( rule__MidPriority__Group_1__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==30) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalQsv.g:1631:3: rule__MidPriority__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MidPriority__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMidPriorityAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidPriority__Group__1__Impl"


    // $ANTLR start "rule__MidPriority__Group_1__0"
    // InternalQsv.g:1640:1: rule__MidPriority__Group_1__0 : rule__MidPriority__Group_1__0__Impl rule__MidPriority__Group_1__1 ;
    public final void rule__MidPriority__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1644:1: ( rule__MidPriority__Group_1__0__Impl rule__MidPriority__Group_1__1 )
            // InternalQsv.g:1645:2: rule__MidPriority__Group_1__0__Impl rule__MidPriority__Group_1__1
            {
            pushFollow(FOLLOW_17);
            rule__MidPriority__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MidPriority__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidPriority__Group_1__0"


    // $ANTLR start "rule__MidPriority__Group_1__0__Impl"
    // InternalQsv.g:1652:1: rule__MidPriority__Group_1__0__Impl : ( 'and' ) ;
    public final void rule__MidPriority__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1656:1: ( ( 'and' ) )
            // InternalQsv.g:1657:1: ( 'and' )
            {
            // InternalQsv.g:1657:1: ( 'and' )
            // InternalQsv.g:1658:2: 'and'
            {
             before(grammarAccess.getMidPriorityAccess().getAndKeyword_1_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getMidPriorityAccess().getAndKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidPriority__Group_1__0__Impl"


    // $ANTLR start "rule__MidPriority__Group_1__1"
    // InternalQsv.g:1667:1: rule__MidPriority__Group_1__1 : rule__MidPriority__Group_1__1__Impl ;
    public final void rule__MidPriority__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1671:1: ( rule__MidPriority__Group_1__1__Impl )
            // InternalQsv.g:1672:2: rule__MidPriority__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MidPriority__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidPriority__Group_1__1"


    // $ANTLR start "rule__MidPriority__Group_1__1__Impl"
    // InternalQsv.g:1678:1: rule__MidPriority__Group_1__1__Impl : ( ( rule__MidPriority__AndConditionAssignment_1_1 ) ) ;
    public final void rule__MidPriority__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1682:1: ( ( ( rule__MidPriority__AndConditionAssignment_1_1 ) ) )
            // InternalQsv.g:1683:1: ( ( rule__MidPriority__AndConditionAssignment_1_1 ) )
            {
            // InternalQsv.g:1683:1: ( ( rule__MidPriority__AndConditionAssignment_1_1 ) )
            // InternalQsv.g:1684:2: ( rule__MidPriority__AndConditionAssignment_1_1 )
            {
             before(grammarAccess.getMidPriorityAccess().getAndConditionAssignment_1_1()); 
            // InternalQsv.g:1685:2: ( rule__MidPriority__AndConditionAssignment_1_1 )
            // InternalQsv.g:1685:3: rule__MidPriority__AndConditionAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MidPriority__AndConditionAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMidPriorityAccess().getAndConditionAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidPriority__Group_1__1__Impl"


    // $ANTLR start "rule__HighestPriority__Group_1__0"
    // InternalQsv.g:1694:1: rule__HighestPriority__Group_1__0 : rule__HighestPriority__Group_1__0__Impl rule__HighestPriority__Group_1__1 ;
    public final void rule__HighestPriority__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1698:1: ( rule__HighestPriority__Group_1__0__Impl rule__HighestPriority__Group_1__1 )
            // InternalQsv.g:1699:2: rule__HighestPriority__Group_1__0__Impl rule__HighestPriority__Group_1__1
            {
            pushFollow(FOLLOW_17);
            rule__HighestPriority__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HighestPriority__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HighestPriority__Group_1__0"


    // $ANTLR start "rule__HighestPriority__Group_1__0__Impl"
    // InternalQsv.g:1706:1: rule__HighestPriority__Group_1__0__Impl : ( '(' ) ;
    public final void rule__HighestPriority__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1710:1: ( ( '(' ) )
            // InternalQsv.g:1711:1: ( '(' )
            {
            // InternalQsv.g:1711:1: ( '(' )
            // InternalQsv.g:1712:2: '('
            {
             before(grammarAccess.getHighestPriorityAccess().getLeftParenthesisKeyword_1_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getHighestPriorityAccess().getLeftParenthesisKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HighestPriority__Group_1__0__Impl"


    // $ANTLR start "rule__HighestPriority__Group_1__1"
    // InternalQsv.g:1721:1: rule__HighestPriority__Group_1__1 : rule__HighestPriority__Group_1__1__Impl rule__HighestPriority__Group_1__2 ;
    public final void rule__HighestPriority__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1725:1: ( rule__HighestPriority__Group_1__1__Impl rule__HighestPriority__Group_1__2 )
            // InternalQsv.g:1726:2: rule__HighestPriority__Group_1__1__Impl rule__HighestPriority__Group_1__2
            {
            pushFollow(FOLLOW_19);
            rule__HighestPriority__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HighestPriority__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HighestPriority__Group_1__1"


    // $ANTLR start "rule__HighestPriority__Group_1__1__Impl"
    // InternalQsv.g:1733:1: rule__HighestPriority__Group_1__1__Impl : ( ( rule__HighestPriority__ConditionAssignment_1_1 ) ) ;
    public final void rule__HighestPriority__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1737:1: ( ( ( rule__HighestPriority__ConditionAssignment_1_1 ) ) )
            // InternalQsv.g:1738:1: ( ( rule__HighestPriority__ConditionAssignment_1_1 ) )
            {
            // InternalQsv.g:1738:1: ( ( rule__HighestPriority__ConditionAssignment_1_1 ) )
            // InternalQsv.g:1739:2: ( rule__HighestPriority__ConditionAssignment_1_1 )
            {
             before(grammarAccess.getHighestPriorityAccess().getConditionAssignment_1_1()); 
            // InternalQsv.g:1740:2: ( rule__HighestPriority__ConditionAssignment_1_1 )
            // InternalQsv.g:1740:3: rule__HighestPriority__ConditionAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__HighestPriority__ConditionAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getHighestPriorityAccess().getConditionAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HighestPriority__Group_1__1__Impl"


    // $ANTLR start "rule__HighestPriority__Group_1__2"
    // InternalQsv.g:1748:1: rule__HighestPriority__Group_1__2 : rule__HighestPriority__Group_1__2__Impl ;
    public final void rule__HighestPriority__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1752:1: ( rule__HighestPriority__Group_1__2__Impl )
            // InternalQsv.g:1753:2: rule__HighestPriority__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HighestPriority__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HighestPriority__Group_1__2"


    // $ANTLR start "rule__HighestPriority__Group_1__2__Impl"
    // InternalQsv.g:1759:1: rule__HighestPriority__Group_1__2__Impl : ( ')' ) ;
    public final void rule__HighestPriority__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1763:1: ( ( ')' ) )
            // InternalQsv.g:1764:1: ( ')' )
            {
            // InternalQsv.g:1764:1: ( ')' )
            // InternalQsv.g:1765:2: ')'
            {
             before(grammarAccess.getHighestPriorityAccess().getRightParenthesisKeyword_1_2()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getHighestPriorityAccess().getRightParenthesisKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HighestPriority__Group_1__2__Impl"


    // $ANTLR start "rule__BinCond__Group__0"
    // InternalQsv.g:1775:1: rule__BinCond__Group__0 : rule__BinCond__Group__0__Impl rule__BinCond__Group__1 ;
    public final void rule__BinCond__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1779:1: ( rule__BinCond__Group__0__Impl rule__BinCond__Group__1 )
            // InternalQsv.g:1780:2: rule__BinCond__Group__0__Impl rule__BinCond__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__BinCond__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BinCond__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinCond__Group__0"


    // $ANTLR start "rule__BinCond__Group__0__Impl"
    // InternalQsv.g:1787:1: rule__BinCond__Group__0__Impl : ( ( rule__BinCond__ColIdAssignment_0 ) ) ;
    public final void rule__BinCond__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1791:1: ( ( ( rule__BinCond__ColIdAssignment_0 ) ) )
            // InternalQsv.g:1792:1: ( ( rule__BinCond__ColIdAssignment_0 ) )
            {
            // InternalQsv.g:1792:1: ( ( rule__BinCond__ColIdAssignment_0 ) )
            // InternalQsv.g:1793:2: ( rule__BinCond__ColIdAssignment_0 )
            {
             before(grammarAccess.getBinCondAccess().getColIdAssignment_0()); 
            // InternalQsv.g:1794:2: ( rule__BinCond__ColIdAssignment_0 )
            // InternalQsv.g:1794:3: rule__BinCond__ColIdAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__BinCond__ColIdAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getBinCondAccess().getColIdAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinCond__Group__0__Impl"


    // $ANTLR start "rule__BinCond__Group__1"
    // InternalQsv.g:1802:1: rule__BinCond__Group__1 : rule__BinCond__Group__1__Impl rule__BinCond__Group__2 ;
    public final void rule__BinCond__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1806:1: ( rule__BinCond__Group__1__Impl rule__BinCond__Group__2 )
            // InternalQsv.g:1807:2: rule__BinCond__Group__1__Impl rule__BinCond__Group__2
            {
            pushFollow(FOLLOW_21);
            rule__BinCond__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BinCond__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinCond__Group__1"


    // $ANTLR start "rule__BinCond__Group__1__Impl"
    // InternalQsv.g:1814:1: rule__BinCond__Group__1__Impl : ( ( rule__BinCond__OperatorAssignment_1 ) ) ;
    public final void rule__BinCond__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1818:1: ( ( ( rule__BinCond__OperatorAssignment_1 ) ) )
            // InternalQsv.g:1819:1: ( ( rule__BinCond__OperatorAssignment_1 ) )
            {
            // InternalQsv.g:1819:1: ( ( rule__BinCond__OperatorAssignment_1 ) )
            // InternalQsv.g:1820:2: ( rule__BinCond__OperatorAssignment_1 )
            {
             before(grammarAccess.getBinCondAccess().getOperatorAssignment_1()); 
            // InternalQsv.g:1821:2: ( rule__BinCond__OperatorAssignment_1 )
            // InternalQsv.g:1821:3: rule__BinCond__OperatorAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__BinCond__OperatorAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getBinCondAccess().getOperatorAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinCond__Group__1__Impl"


    // $ANTLR start "rule__BinCond__Group__2"
    // InternalQsv.g:1829:1: rule__BinCond__Group__2 : rule__BinCond__Group__2__Impl ;
    public final void rule__BinCond__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1833:1: ( rule__BinCond__Group__2__Impl )
            // InternalQsv.g:1834:2: rule__BinCond__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BinCond__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinCond__Group__2"


    // $ANTLR start "rule__BinCond__Group__2__Impl"
    // InternalQsv.g:1840:1: rule__BinCond__Group__2__Impl : ( ( rule__BinCond__Alternatives_2 ) ) ;
    public final void rule__BinCond__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1844:1: ( ( ( rule__BinCond__Alternatives_2 ) ) )
            // InternalQsv.g:1845:1: ( ( rule__BinCond__Alternatives_2 ) )
            {
            // InternalQsv.g:1845:1: ( ( rule__BinCond__Alternatives_2 ) )
            // InternalQsv.g:1846:2: ( rule__BinCond__Alternatives_2 )
            {
             before(grammarAccess.getBinCondAccess().getAlternatives_2()); 
            // InternalQsv.g:1847:2: ( rule__BinCond__Alternatives_2 )
            // InternalQsv.g:1847:3: rule__BinCond__Alternatives_2
            {
            pushFollow(FOLLOW_2);
            rule__BinCond__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getBinCondAccess().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinCond__Group__2__Impl"


    // $ANTLR start "rule__QuerySeparatedValues__HeaderAssignment_0"
    // InternalQsv.g:1856:1: rule__QuerySeparatedValues__HeaderAssignment_0 : ( ruleHeader ) ;
    public final void rule__QuerySeparatedValues__HeaderAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1860:1: ( ( ruleHeader ) )
            // InternalQsv.g:1861:2: ( ruleHeader )
            {
            // InternalQsv.g:1861:2: ( ruleHeader )
            // InternalQsv.g:1862:3: ruleHeader
            {
             before(grammarAccess.getQuerySeparatedValuesAccess().getHeaderHeaderParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleHeader();

            state._fsp--;

             after(grammarAccess.getQuerySeparatedValuesAccess().getHeaderHeaderParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuerySeparatedValues__HeaderAssignment_0"


    // $ANTLR start "rule__QuerySeparatedValues__StatementsAssignment_1"
    // InternalQsv.g:1871:1: rule__QuerySeparatedValues__StatementsAssignment_1 : ( ruleStatement ) ;
    public final void rule__QuerySeparatedValues__StatementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1875:1: ( ( ruleStatement ) )
            // InternalQsv.g:1876:2: ( ruleStatement )
            {
            // InternalQsv.g:1876:2: ( ruleStatement )
            // InternalQsv.g:1877:3: ruleStatement
            {
             before(grammarAccess.getQuerySeparatedValuesAccess().getStatementsStatementParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleStatement();

            state._fsp--;

             after(grammarAccess.getQuerySeparatedValuesAccess().getStatementsStatementParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuerySeparatedValues__StatementsAssignment_1"


    // $ANTLR start "rule__Header__NameFileAssignment_1"
    // InternalQsv.g:1886:1: rule__Header__NameFileAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Header__NameFileAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1890:1: ( ( RULE_STRING ) )
            // InternalQsv.g:1891:2: ( RULE_STRING )
            {
            // InternalQsv.g:1891:2: ( RULE_STRING )
            // InternalQsv.g:1892:3: RULE_STRING
            {
             before(grammarAccess.getHeaderAccess().getNameFileSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getHeaderAccess().getNameFileSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Header__NameFileAssignment_1"


    // $ANTLR start "rule__Header__HasColumnNameAssignment_5_0"
    // InternalQsv.g:1901:1: rule__Header__HasColumnNameAssignment_5_0 : ( ( 'yes' ) ) ;
    public final void rule__Header__HasColumnNameAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1905:1: ( ( ( 'yes' ) ) )
            // InternalQsv.g:1906:2: ( ( 'yes' ) )
            {
            // InternalQsv.g:1906:2: ( ( 'yes' ) )
            // InternalQsv.g:1907:3: ( 'yes' )
            {
             before(grammarAccess.getHeaderAccess().getHasColumnNameYesKeyword_5_0_0()); 
            // InternalQsv.g:1908:3: ( 'yes' )
            // InternalQsv.g:1909:4: 'yes'
            {
             before(grammarAccess.getHeaderAccess().getHasColumnNameYesKeyword_5_0_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getHeaderAccess().getHasColumnNameYesKeyword_5_0_0()); 

            }

             after(grammarAccess.getHeaderAccess().getHasColumnNameYesKeyword_5_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Header__HasColumnNameAssignment_5_0"


    // $ANTLR start "rule__Statement__StatementAssignment"
    // InternalQsv.g:1920:1: rule__Statement__StatementAssignment : ( rulePrint ) ;
    public final void rule__Statement__StatementAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1924:1: ( ( rulePrint ) )
            // InternalQsv.g:1925:2: ( rulePrint )
            {
            // InternalQsv.g:1925:2: ( rulePrint )
            // InternalQsv.g:1926:3: rulePrint
            {
             before(grammarAccess.getStatementAccess().getStatementPrintParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            rulePrint();

            state._fsp--;

             after(grammarAccess.getStatementAccess().getStatementPrintParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__StatementAssignment"


    // $ANTLR start "rule__Print__SelectorAssignment_1"
    // InternalQsv.g:1935:1: rule__Print__SelectorAssignment_1 : ( ruleSelector ) ;
    public final void rule__Print__SelectorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1939:1: ( ( ruleSelector ) )
            // InternalQsv.g:1940:2: ( ruleSelector )
            {
            // InternalQsv.g:1940:2: ( ruleSelector )
            // InternalQsv.g:1941:3: ruleSelector
            {
             before(grammarAccess.getPrintAccess().getSelectorSelectorParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleSelector();

            state._fsp--;

             after(grammarAccess.getPrintAccess().getSelectorSelectorParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Print__SelectorAssignment_1"


    // $ANTLR start "rule__Selector__ColumnsAssignment_0"
    // InternalQsv.g:1950:1: rule__Selector__ColumnsAssignment_0 : ( ruleColumns ) ;
    public final void rule__Selector__ColumnsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1954:1: ( ( ruleColumns ) )
            // InternalQsv.g:1955:2: ( ruleColumns )
            {
            // InternalQsv.g:1955:2: ( ruleColumns )
            // InternalQsv.g:1956:3: ruleColumns
            {
             before(grammarAccess.getSelectorAccess().getColumnsColumnsParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleColumns();

            state._fsp--;

             after(grammarAccess.getSelectorAccess().getColumnsColumnsParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selector__ColumnsAssignment_0"


    // $ANTLR start "rule__Selector__LinesAssignment_1"
    // InternalQsv.g:1965:1: rule__Selector__LinesAssignment_1 : ( ruleLines ) ;
    public final void rule__Selector__LinesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1969:1: ( ( ruleLines ) )
            // InternalQsv.g:1970:2: ( ruleLines )
            {
            // InternalQsv.g:1970:2: ( ruleLines )
            // InternalQsv.g:1971:3: ruleLines
            {
             before(grammarAccess.getSelectorAccess().getLinesLinesParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLines();

            state._fsp--;

             after(grammarAccess.getSelectorAccess().getLinesLinesParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selector__LinesAssignment_1"


    // $ANTLR start "rule__Columns__RangeAssignment_1_0"
    // InternalQsv.g:1980:1: rule__Columns__RangeAssignment_1_0 : ( ruleColRange ) ;
    public final void rule__Columns__RangeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1984:1: ( ( ruleColRange ) )
            // InternalQsv.g:1985:2: ( ruleColRange )
            {
            // InternalQsv.g:1985:2: ( ruleColRange )
            // InternalQsv.g:1986:3: ruleColRange
            {
             before(grammarAccess.getColumnsAccess().getRangeColRangeParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleColRange();

            state._fsp--;

             after(grammarAccess.getColumnsAccess().getRangeColRangeParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Columns__RangeAssignment_1_0"


    // $ANTLR start "rule__Columns__ColumnAssignment_1_1"
    // InternalQsv.g:1995:1: rule__Columns__ColumnAssignment_1_1 : ( ruleColumn ) ;
    public final void rule__Columns__ColumnAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:1999:1: ( ( ruleColumn ) )
            // InternalQsv.g:2000:2: ( ruleColumn )
            {
            // InternalQsv.g:2000:2: ( ruleColumn )
            // InternalQsv.g:2001:3: ruleColumn
            {
             before(grammarAccess.getColumnsAccess().getColumnColumnParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleColumn();

            state._fsp--;

             after(grammarAccess.getColumnsAccess().getColumnColumnParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Columns__ColumnAssignment_1_1"


    // $ANTLR start "rule__ColRange__StartAssignment_0"
    // InternalQsv.g:2010:1: rule__ColRange__StartAssignment_0 : ( ruleColumn ) ;
    public final void rule__ColRange__StartAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2014:1: ( ( ruleColumn ) )
            // InternalQsv.g:2015:2: ( ruleColumn )
            {
            // InternalQsv.g:2015:2: ( ruleColumn )
            // InternalQsv.g:2016:3: ruleColumn
            {
             before(grammarAccess.getColRangeAccess().getStartColumnParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleColumn();

            state._fsp--;

             after(grammarAccess.getColRangeAccess().getStartColumnParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColRange__StartAssignment_0"


    // $ANTLR start "rule__ColRange__EndAssignment_2"
    // InternalQsv.g:2025:1: rule__ColRange__EndAssignment_2 : ( ruleColumn ) ;
    public final void rule__ColRange__EndAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2029:1: ( ( ruleColumn ) )
            // InternalQsv.g:2030:2: ( ruleColumn )
            {
            // InternalQsv.g:2030:2: ( ruleColumn )
            // InternalQsv.g:2031:3: ruleColumn
            {
             before(grammarAccess.getColRangeAccess().getEndColumnParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleColumn();

            state._fsp--;

             after(grammarAccess.getColRangeAccess().getEndColumnParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColRange__EndAssignment_2"


    // $ANTLR start "rule__ColumnName__NamebAssignment"
    // InternalQsv.g:2040:1: rule__ColumnName__NamebAssignment : ( RULE_ID ) ;
    public final void rule__ColumnName__NamebAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2044:1: ( ( RULE_ID ) )
            // InternalQsv.g:2045:2: ( RULE_ID )
            {
            // InternalQsv.g:2045:2: ( RULE_ID )
            // InternalQsv.g:2046:3: RULE_ID
            {
             before(grammarAccess.getColumnNameAccess().getNamebIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getColumnNameAccess().getNamebIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColumnName__NamebAssignment"


    // $ANTLR start "rule__ColumnNumber__NumberAssignment_1"
    // InternalQsv.g:2055:1: rule__ColumnNumber__NumberAssignment_1 : ( RULE_INT ) ;
    public final void rule__ColumnNumber__NumberAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2059:1: ( ( RULE_INT ) )
            // InternalQsv.g:2060:2: ( RULE_INT )
            {
            // InternalQsv.g:2060:2: ( RULE_INT )
            // InternalQsv.g:2061:3: RULE_INT
            {
             before(grammarAccess.getColumnNumberAccess().getNumberINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getColumnNumberAccess().getNumberINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColumnNumber__NumberAssignment_1"


    // $ANTLR start "rule__Lines__RangeAssignment_1_0"
    // InternalQsv.g:2070:1: rule__Lines__RangeAssignment_1_0 : ( ruleLineRange ) ;
    public final void rule__Lines__RangeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2074:1: ( ( ruleLineRange ) )
            // InternalQsv.g:2075:2: ( ruleLineRange )
            {
            // InternalQsv.g:2075:2: ( ruleLineRange )
            // InternalQsv.g:2076:3: ruleLineRange
            {
             before(grammarAccess.getLinesAccess().getRangeLineRangeParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleLineRange();

            state._fsp--;

             after(grammarAccess.getLinesAccess().getRangeLineRangeParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lines__RangeAssignment_1_0"


    // $ANTLR start "rule__Lines__LineAssignment_1_1"
    // InternalQsv.g:2085:1: rule__Lines__LineAssignment_1_1 : ( ruleLine ) ;
    public final void rule__Lines__LineAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2089:1: ( ( ruleLine ) )
            // InternalQsv.g:2090:2: ( ruleLine )
            {
            // InternalQsv.g:2090:2: ( ruleLine )
            // InternalQsv.g:2091:3: ruleLine
            {
             before(grammarAccess.getLinesAccess().getLineLineParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLine();

            state._fsp--;

             after(grammarAccess.getLinesAccess().getLineLineParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lines__LineAssignment_1_1"


    // $ANTLR start "rule__Lines__CondAssignment_2"
    // InternalQsv.g:2100:1: rule__Lines__CondAssignment_2 : ( ruleCondition ) ;
    public final void rule__Lines__CondAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2104:1: ( ( ruleCondition ) )
            // InternalQsv.g:2105:2: ( ruleCondition )
            {
            // InternalQsv.g:2105:2: ( ruleCondition )
            // InternalQsv.g:2106:3: ruleCondition
            {
             before(grammarAccess.getLinesAccess().getCondConditionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getLinesAccess().getCondConditionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lines__CondAssignment_2"


    // $ANTLR start "rule__LineRange__StartAssignment_0"
    // InternalQsv.g:2115:1: rule__LineRange__StartAssignment_0 : ( RULE_INT ) ;
    public final void rule__LineRange__StartAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2119:1: ( ( RULE_INT ) )
            // InternalQsv.g:2120:2: ( RULE_INT )
            {
            // InternalQsv.g:2120:2: ( RULE_INT )
            // InternalQsv.g:2121:3: RULE_INT
            {
             before(grammarAccess.getLineRangeAccess().getStartINTTerminalRuleCall_0_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getLineRangeAccess().getStartINTTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineRange__StartAssignment_0"


    // $ANTLR start "rule__LineRange__EndAssignment_2"
    // InternalQsv.g:2130:1: rule__LineRange__EndAssignment_2 : ( RULE_INT ) ;
    public final void rule__LineRange__EndAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2134:1: ( ( RULE_INT ) )
            // InternalQsv.g:2135:2: ( RULE_INT )
            {
            // InternalQsv.g:2135:2: ( RULE_INT )
            // InternalQsv.g:2136:3: RULE_INT
            {
             before(grammarAccess.getLineRangeAccess().getEndINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getLineRangeAccess().getEndINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineRange__EndAssignment_2"


    // $ANTLR start "rule__Line__NumberAssignment_1"
    // InternalQsv.g:2145:1: rule__Line__NumberAssignment_1 : ( RULE_INT ) ;
    public final void rule__Line__NumberAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2149:1: ( ( RULE_INT ) )
            // InternalQsv.g:2150:2: ( RULE_INT )
            {
            // InternalQsv.g:2150:2: ( RULE_INT )
            // InternalQsv.g:2151:3: RULE_INT
            {
             before(grammarAccess.getLineAccess().getNumberINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getLineAccess().getNumberINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Line__NumberAssignment_1"


    // $ANTLR start "rule__Condition__MidAssignment_0"
    // InternalQsv.g:2160:1: rule__Condition__MidAssignment_0 : ( ruleMidPriority ) ;
    public final void rule__Condition__MidAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2164:1: ( ( ruleMidPriority ) )
            // InternalQsv.g:2165:2: ( ruleMidPriority )
            {
            // InternalQsv.g:2165:2: ( ruleMidPriority )
            // InternalQsv.g:2166:3: ruleMidPriority
            {
             before(grammarAccess.getConditionAccess().getMidMidPriorityParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMidPriority();

            state._fsp--;

             after(grammarAccess.getConditionAccess().getMidMidPriorityParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__MidAssignment_0"


    // $ANTLR start "rule__Condition__OrConditionAssignment_1_1"
    // InternalQsv.g:2175:1: rule__Condition__OrConditionAssignment_1_1 : ( ruleCondition ) ;
    public final void rule__Condition__OrConditionAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2179:1: ( ( ruleCondition ) )
            // InternalQsv.g:2180:2: ( ruleCondition )
            {
            // InternalQsv.g:2180:2: ( ruleCondition )
            // InternalQsv.g:2181:3: ruleCondition
            {
             before(grammarAccess.getConditionAccess().getOrConditionConditionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getConditionAccess().getOrConditionConditionParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__OrConditionAssignment_1_1"


    // $ANTLR start "rule__MidPriority__HighAssignment_0"
    // InternalQsv.g:2190:1: rule__MidPriority__HighAssignment_0 : ( ruleHighestPriority ) ;
    public final void rule__MidPriority__HighAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2194:1: ( ( ruleHighestPriority ) )
            // InternalQsv.g:2195:2: ( ruleHighestPriority )
            {
            // InternalQsv.g:2195:2: ( ruleHighestPriority )
            // InternalQsv.g:2196:3: ruleHighestPriority
            {
             before(grammarAccess.getMidPriorityAccess().getHighHighestPriorityParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleHighestPriority();

            state._fsp--;

             after(grammarAccess.getMidPriorityAccess().getHighHighestPriorityParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidPriority__HighAssignment_0"


    // $ANTLR start "rule__MidPriority__AndConditionAssignment_1_1"
    // InternalQsv.g:2205:1: rule__MidPriority__AndConditionAssignment_1_1 : ( ruleMidPriority ) ;
    public final void rule__MidPriority__AndConditionAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2209:1: ( ( ruleMidPriority ) )
            // InternalQsv.g:2210:2: ( ruleMidPriority )
            {
            // InternalQsv.g:2210:2: ( ruleMidPriority )
            // InternalQsv.g:2211:3: ruleMidPriority
            {
             before(grammarAccess.getMidPriorityAccess().getAndConditionMidPriorityParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMidPriority();

            state._fsp--;

             after(grammarAccess.getMidPriorityAccess().getAndConditionMidPriorityParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidPriority__AndConditionAssignment_1_1"


    // $ANTLR start "rule__HighestPriority__ConditionAssignment_0"
    // InternalQsv.g:2220:1: rule__HighestPriority__ConditionAssignment_0 : ( ruleBinCond ) ;
    public final void rule__HighestPriority__ConditionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2224:1: ( ( ruleBinCond ) )
            // InternalQsv.g:2225:2: ( ruleBinCond )
            {
            // InternalQsv.g:2225:2: ( ruleBinCond )
            // InternalQsv.g:2226:3: ruleBinCond
            {
             before(grammarAccess.getHighestPriorityAccess().getConditionBinCondParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleBinCond();

            state._fsp--;

             after(grammarAccess.getHighestPriorityAccess().getConditionBinCondParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HighestPriority__ConditionAssignment_0"


    // $ANTLR start "rule__HighestPriority__ConditionAssignment_1_1"
    // InternalQsv.g:2235:1: rule__HighestPriority__ConditionAssignment_1_1 : ( ruleCondition ) ;
    public final void rule__HighestPriority__ConditionAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2239:1: ( ( ruleCondition ) )
            // InternalQsv.g:2240:2: ( ruleCondition )
            {
            // InternalQsv.g:2240:2: ( ruleCondition )
            // InternalQsv.g:2241:3: ruleCondition
            {
             before(grammarAccess.getHighestPriorityAccess().getConditionConditionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getHighestPriorityAccess().getConditionConditionParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HighestPriority__ConditionAssignment_1_1"


    // $ANTLR start "rule__BinCond__ColIdAssignment_0"
    // InternalQsv.g:2250:1: rule__BinCond__ColIdAssignment_0 : ( RULE_ID ) ;
    public final void rule__BinCond__ColIdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2254:1: ( ( RULE_ID ) )
            // InternalQsv.g:2255:2: ( RULE_ID )
            {
            // InternalQsv.g:2255:2: ( RULE_ID )
            // InternalQsv.g:2256:3: RULE_ID
            {
             before(grammarAccess.getBinCondAccess().getColIdIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getBinCondAccess().getColIdIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinCond__ColIdAssignment_0"


    // $ANTLR start "rule__BinCond__OperatorAssignment_1"
    // InternalQsv.g:2265:1: rule__BinCond__OperatorAssignment_1 : ( ruleOpComp ) ;
    public final void rule__BinCond__OperatorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2269:1: ( ( ruleOpComp ) )
            // InternalQsv.g:2270:2: ( ruleOpComp )
            {
            // InternalQsv.g:2270:2: ( ruleOpComp )
            // InternalQsv.g:2271:3: ruleOpComp
            {
             before(grammarAccess.getBinCondAccess().getOperatorOpCompParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOpComp();

            state._fsp--;

             after(grammarAccess.getBinCondAccess().getOperatorOpCompParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinCond__OperatorAssignment_1"


    // $ANTLR start "rule__BinCond__CompStrAssignment_2_0"
    // InternalQsv.g:2280:1: rule__BinCond__CompStrAssignment_2_0 : ( RULE_STRING ) ;
    public final void rule__BinCond__CompStrAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2284:1: ( ( RULE_STRING ) )
            // InternalQsv.g:2285:2: ( RULE_STRING )
            {
            // InternalQsv.g:2285:2: ( RULE_STRING )
            // InternalQsv.g:2286:3: RULE_STRING
            {
             before(grammarAccess.getBinCondAccess().getCompStrSTRINGTerminalRuleCall_2_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getBinCondAccess().getCompStrSTRINGTerminalRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinCond__CompStrAssignment_2_0"


    // $ANTLR start "rule__BinCond__CompIdAssignment_2_1"
    // InternalQsv.g:2295:1: rule__BinCond__CompIdAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__BinCond__CompIdAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2299:1: ( ( RULE_ID ) )
            // InternalQsv.g:2300:2: ( RULE_ID )
            {
            // InternalQsv.g:2300:2: ( RULE_ID )
            // InternalQsv.g:2301:3: RULE_ID
            {
             before(grammarAccess.getBinCondAccess().getCompIdIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getBinCondAccess().getCompIdIDTerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinCond__CompIdAssignment_2_1"


    // $ANTLR start "rule__BinCond__CompValueAssignment_2_2"
    // InternalQsv.g:2310:1: rule__BinCond__CompValueAssignment_2_2 : ( RULE_INT ) ;
    public final void rule__BinCond__CompValueAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2314:1: ( ( RULE_INT ) )
            // InternalQsv.g:2315:2: ( RULE_INT )
            {
            // InternalQsv.g:2315:2: ( RULE_INT )
            // InternalQsv.g:2316:3: RULE_INT
            {
             before(grammarAccess.getBinCondAccess().getCompValueINTTerminalRuleCall_2_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getBinCondAccess().getCompValueINTTerminalRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinCond__CompValueAssignment_2_2"


    // $ANTLR start "rule__OpComp__OpAssignment_0"
    // InternalQsv.g:2325:1: rule__OpComp__OpAssignment_0 : ( ( '=' ) ) ;
    public final void rule__OpComp__OpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2329:1: ( ( ( '=' ) ) )
            // InternalQsv.g:2330:2: ( ( '=' ) )
            {
            // InternalQsv.g:2330:2: ( ( '=' ) )
            // InternalQsv.g:2331:3: ( '=' )
            {
             before(grammarAccess.getOpCompAccess().getOpEqualsSignKeyword_0_0()); 
            // InternalQsv.g:2332:3: ( '=' )
            // InternalQsv.g:2333:4: '='
            {
             before(grammarAccess.getOpCompAccess().getOpEqualsSignKeyword_0_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getOpCompAccess().getOpEqualsSignKeyword_0_0()); 

            }

             after(grammarAccess.getOpCompAccess().getOpEqualsSignKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpComp__OpAssignment_0"


    // $ANTLR start "rule__Boolean__BolAssignment_0"
    // InternalQsv.g:2344:1: rule__Boolean__BolAssignment_0 : ( ( 'yes' ) ) ;
    public final void rule__Boolean__BolAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:2348:1: ( ( ( 'yes' ) ) )
            // InternalQsv.g:2349:2: ( ( 'yes' ) )
            {
            // InternalQsv.g:2349:2: ( ( 'yes' ) )
            // InternalQsv.g:2350:3: ( 'yes' )
            {
             before(grammarAccess.getBooleanAccess().getBolYesKeyword_0_0()); 
            // InternalQsv.g:2351:3: ( 'yes' )
            // InternalQsv.g:2352:4: 'yes'
            {
             before(grammarAccess.getBooleanAccess().getBolYesKeyword_0_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getBooleanAccess().getBolYesKeyword_0_0()); 

            }

             after(grammarAccess.getBooleanAccess().getBolYesKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Boolean__BolAssignment_0"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000200000800L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000008001020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000088001060L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000080000020L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00000004000FE000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000070L});

}