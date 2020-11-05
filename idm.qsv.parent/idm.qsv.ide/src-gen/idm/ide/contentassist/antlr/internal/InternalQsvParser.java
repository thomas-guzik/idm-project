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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'no'", "'using'", "'with'", "'column'", "'names:'", "'yes'", "'print'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=6;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

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



    // $ANTLR start "entryRuleQuerySepartedValue"
    // InternalQsv.g:53:1: entryRuleQuerySepartedValue : ruleQuerySepartedValue EOF ;
    public final void entryRuleQuerySepartedValue() throws RecognitionException {
        try {
            // InternalQsv.g:54:1: ( ruleQuerySepartedValue EOF )
            // InternalQsv.g:55:1: ruleQuerySepartedValue EOF
            {
             before(grammarAccess.getQuerySepartedValueRule()); 
            pushFollow(FOLLOW_1);
            ruleQuerySepartedValue();

            state._fsp--;

             after(grammarAccess.getQuerySepartedValueRule()); 
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
    // $ANTLR end "entryRuleQuerySepartedValue"


    // $ANTLR start "ruleQuerySepartedValue"
    // InternalQsv.g:62:1: ruleQuerySepartedValue : ( ( rule__QuerySepartedValue__Group__0 ) ) ;
    public final void ruleQuerySepartedValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:66:2: ( ( ( rule__QuerySepartedValue__Group__0 ) ) )
            // InternalQsv.g:67:2: ( ( rule__QuerySepartedValue__Group__0 ) )
            {
            // InternalQsv.g:67:2: ( ( rule__QuerySepartedValue__Group__0 ) )
            // InternalQsv.g:68:3: ( rule__QuerySepartedValue__Group__0 )
            {
             before(grammarAccess.getQuerySepartedValueAccess().getGroup()); 
            // InternalQsv.g:69:3: ( rule__QuerySepartedValue__Group__0 )
            // InternalQsv.g:69:4: rule__QuerySepartedValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QuerySepartedValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQuerySepartedValueAccess().getGroup()); 

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
    // $ANTLR end "ruleQuerySepartedValue"


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
    // InternalQsv.g:137:1: rulePrint : ( ( rule__Print__PrintAssignment ) ) ;
    public final void rulePrint() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:141:2: ( ( ( rule__Print__PrintAssignment ) ) )
            // InternalQsv.g:142:2: ( ( rule__Print__PrintAssignment ) )
            {
            // InternalQsv.g:142:2: ( ( rule__Print__PrintAssignment ) )
            // InternalQsv.g:143:3: ( rule__Print__PrintAssignment )
            {
             before(grammarAccess.getPrintAccess().getPrintAssignment()); 
            // InternalQsv.g:144:3: ( rule__Print__PrintAssignment )
            // InternalQsv.g:144:4: rule__Print__PrintAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Print__PrintAssignment();

            state._fsp--;


            }

             after(grammarAccess.getPrintAccess().getPrintAssignment()); 

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


    // $ANTLR start "rule__Header__Alternatives_5"
    // InternalQsv.g:152:1: rule__Header__Alternatives_5 : ( ( ( rule__Header__HasColumnNameAssignment_5_0 ) ) | ( 'no' ) );
    public final void rule__Header__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:156:1: ( ( ( rule__Header__HasColumnNameAssignment_5_0 ) ) | ( 'no' ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==16) ) {
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
                    // InternalQsv.g:157:2: ( ( rule__Header__HasColumnNameAssignment_5_0 ) )
                    {
                    // InternalQsv.g:157:2: ( ( rule__Header__HasColumnNameAssignment_5_0 ) )
                    // InternalQsv.g:158:3: ( rule__Header__HasColumnNameAssignment_5_0 )
                    {
                     before(grammarAccess.getHeaderAccess().getHasColumnNameAssignment_5_0()); 
                    // InternalQsv.g:159:3: ( rule__Header__HasColumnNameAssignment_5_0 )
                    // InternalQsv.g:159:4: rule__Header__HasColumnNameAssignment_5_0
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
                    // InternalQsv.g:163:2: ( 'no' )
                    {
                    // InternalQsv.g:163:2: ( 'no' )
                    // InternalQsv.g:164:3: 'no'
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


    // $ANTLR start "rule__QuerySepartedValue__Group__0"
    // InternalQsv.g:173:1: rule__QuerySepartedValue__Group__0 : rule__QuerySepartedValue__Group__0__Impl rule__QuerySepartedValue__Group__1 ;
    public final void rule__QuerySepartedValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:177:1: ( rule__QuerySepartedValue__Group__0__Impl rule__QuerySepartedValue__Group__1 )
            // InternalQsv.g:178:2: rule__QuerySepartedValue__Group__0__Impl rule__QuerySepartedValue__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__QuerySepartedValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuerySepartedValue__Group__1();

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
    // $ANTLR end "rule__QuerySepartedValue__Group__0"


    // $ANTLR start "rule__QuerySepartedValue__Group__0__Impl"
    // InternalQsv.g:185:1: rule__QuerySepartedValue__Group__0__Impl : ( ( rule__QuerySepartedValue__HeaderAssignment_0 ) ) ;
    public final void rule__QuerySepartedValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:189:1: ( ( ( rule__QuerySepartedValue__HeaderAssignment_0 ) ) )
            // InternalQsv.g:190:1: ( ( rule__QuerySepartedValue__HeaderAssignment_0 ) )
            {
            // InternalQsv.g:190:1: ( ( rule__QuerySepartedValue__HeaderAssignment_0 ) )
            // InternalQsv.g:191:2: ( rule__QuerySepartedValue__HeaderAssignment_0 )
            {
             before(grammarAccess.getQuerySepartedValueAccess().getHeaderAssignment_0()); 
            // InternalQsv.g:192:2: ( rule__QuerySepartedValue__HeaderAssignment_0 )
            // InternalQsv.g:192:3: rule__QuerySepartedValue__HeaderAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__QuerySepartedValue__HeaderAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getQuerySepartedValueAccess().getHeaderAssignment_0()); 

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
    // $ANTLR end "rule__QuerySepartedValue__Group__0__Impl"


    // $ANTLR start "rule__QuerySepartedValue__Group__1"
    // InternalQsv.g:200:1: rule__QuerySepartedValue__Group__1 : rule__QuerySepartedValue__Group__1__Impl ;
    public final void rule__QuerySepartedValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:204:1: ( rule__QuerySepartedValue__Group__1__Impl )
            // InternalQsv.g:205:2: rule__QuerySepartedValue__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuerySepartedValue__Group__1__Impl();

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
    // $ANTLR end "rule__QuerySepartedValue__Group__1"


    // $ANTLR start "rule__QuerySepartedValue__Group__1__Impl"
    // InternalQsv.g:211:1: rule__QuerySepartedValue__Group__1__Impl : ( ( rule__QuerySepartedValue__StatementsAssignment_1 )* ) ;
    public final void rule__QuerySepartedValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:215:1: ( ( ( rule__QuerySepartedValue__StatementsAssignment_1 )* ) )
            // InternalQsv.g:216:1: ( ( rule__QuerySepartedValue__StatementsAssignment_1 )* )
            {
            // InternalQsv.g:216:1: ( ( rule__QuerySepartedValue__StatementsAssignment_1 )* )
            // InternalQsv.g:217:2: ( rule__QuerySepartedValue__StatementsAssignment_1 )*
            {
             before(grammarAccess.getQuerySepartedValueAccess().getStatementsAssignment_1()); 
            // InternalQsv.g:218:2: ( rule__QuerySepartedValue__StatementsAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==17) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalQsv.g:218:3: rule__QuerySepartedValue__StatementsAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__QuerySepartedValue__StatementsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getQuerySepartedValueAccess().getStatementsAssignment_1()); 

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
    // $ANTLR end "rule__QuerySepartedValue__Group__1__Impl"


    // $ANTLR start "rule__Header__Group__0"
    // InternalQsv.g:227:1: rule__Header__Group__0 : rule__Header__Group__0__Impl rule__Header__Group__1 ;
    public final void rule__Header__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:231:1: ( rule__Header__Group__0__Impl rule__Header__Group__1 )
            // InternalQsv.g:232:2: rule__Header__Group__0__Impl rule__Header__Group__1
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
    // InternalQsv.g:239:1: rule__Header__Group__0__Impl : ( 'using' ) ;
    public final void rule__Header__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:243:1: ( ( 'using' ) )
            // InternalQsv.g:244:1: ( 'using' )
            {
            // InternalQsv.g:244:1: ( 'using' )
            // InternalQsv.g:245:2: 'using'
            {
             before(grammarAccess.getHeaderAccess().getUsingKeyword_0()); 
            match(input,12,FOLLOW_2); 
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
    // InternalQsv.g:254:1: rule__Header__Group__1 : rule__Header__Group__1__Impl rule__Header__Group__2 ;
    public final void rule__Header__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:258:1: ( rule__Header__Group__1__Impl rule__Header__Group__2 )
            // InternalQsv.g:259:2: rule__Header__Group__1__Impl rule__Header__Group__2
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
    // InternalQsv.g:266:1: rule__Header__Group__1__Impl : ( ( rule__Header__NameFileAssignment_1 ) ) ;
    public final void rule__Header__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:270:1: ( ( ( rule__Header__NameFileAssignment_1 ) ) )
            // InternalQsv.g:271:1: ( ( rule__Header__NameFileAssignment_1 ) )
            {
            // InternalQsv.g:271:1: ( ( rule__Header__NameFileAssignment_1 ) )
            // InternalQsv.g:272:2: ( rule__Header__NameFileAssignment_1 )
            {
             before(grammarAccess.getHeaderAccess().getNameFileAssignment_1()); 
            // InternalQsv.g:273:2: ( rule__Header__NameFileAssignment_1 )
            // InternalQsv.g:273:3: rule__Header__NameFileAssignment_1
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
    // InternalQsv.g:281:1: rule__Header__Group__2 : rule__Header__Group__2__Impl rule__Header__Group__3 ;
    public final void rule__Header__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:285:1: ( rule__Header__Group__2__Impl rule__Header__Group__3 )
            // InternalQsv.g:286:2: rule__Header__Group__2__Impl rule__Header__Group__3
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
    // InternalQsv.g:293:1: rule__Header__Group__2__Impl : ( 'with' ) ;
    public final void rule__Header__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:297:1: ( ( 'with' ) )
            // InternalQsv.g:298:1: ( 'with' )
            {
            // InternalQsv.g:298:1: ( 'with' )
            // InternalQsv.g:299:2: 'with'
            {
             before(grammarAccess.getHeaderAccess().getWithKeyword_2()); 
            match(input,13,FOLLOW_2); 
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
    // InternalQsv.g:308:1: rule__Header__Group__3 : rule__Header__Group__3__Impl rule__Header__Group__4 ;
    public final void rule__Header__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:312:1: ( rule__Header__Group__3__Impl rule__Header__Group__4 )
            // InternalQsv.g:313:2: rule__Header__Group__3__Impl rule__Header__Group__4
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
    // InternalQsv.g:320:1: rule__Header__Group__3__Impl : ( 'column' ) ;
    public final void rule__Header__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:324:1: ( ( 'column' ) )
            // InternalQsv.g:325:1: ( 'column' )
            {
            // InternalQsv.g:325:1: ( 'column' )
            // InternalQsv.g:326:2: 'column'
            {
             before(grammarAccess.getHeaderAccess().getColumnKeyword_3()); 
            match(input,14,FOLLOW_2); 
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
    // InternalQsv.g:335:1: rule__Header__Group__4 : rule__Header__Group__4__Impl rule__Header__Group__5 ;
    public final void rule__Header__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:339:1: ( rule__Header__Group__4__Impl rule__Header__Group__5 )
            // InternalQsv.g:340:2: rule__Header__Group__4__Impl rule__Header__Group__5
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
    // InternalQsv.g:347:1: rule__Header__Group__4__Impl : ( 'names:' ) ;
    public final void rule__Header__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:351:1: ( ( 'names:' ) )
            // InternalQsv.g:352:1: ( 'names:' )
            {
            // InternalQsv.g:352:1: ( 'names:' )
            // InternalQsv.g:353:2: 'names:'
            {
             before(grammarAccess.getHeaderAccess().getNamesKeyword_4()); 
            match(input,15,FOLLOW_2); 
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
    // InternalQsv.g:362:1: rule__Header__Group__5 : rule__Header__Group__5__Impl ;
    public final void rule__Header__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:366:1: ( rule__Header__Group__5__Impl )
            // InternalQsv.g:367:2: rule__Header__Group__5__Impl
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
    // InternalQsv.g:373:1: rule__Header__Group__5__Impl : ( ( rule__Header__Alternatives_5 ) ) ;
    public final void rule__Header__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:377:1: ( ( ( rule__Header__Alternatives_5 ) ) )
            // InternalQsv.g:378:1: ( ( rule__Header__Alternatives_5 ) )
            {
            // InternalQsv.g:378:1: ( ( rule__Header__Alternatives_5 ) )
            // InternalQsv.g:379:2: ( rule__Header__Alternatives_5 )
            {
             before(grammarAccess.getHeaderAccess().getAlternatives_5()); 
            // InternalQsv.g:380:2: ( rule__Header__Alternatives_5 )
            // InternalQsv.g:380:3: rule__Header__Alternatives_5
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


    // $ANTLR start "rule__QuerySepartedValue__HeaderAssignment_0"
    // InternalQsv.g:389:1: rule__QuerySepartedValue__HeaderAssignment_0 : ( ruleHeader ) ;
    public final void rule__QuerySepartedValue__HeaderAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:393:1: ( ( ruleHeader ) )
            // InternalQsv.g:394:2: ( ruleHeader )
            {
            // InternalQsv.g:394:2: ( ruleHeader )
            // InternalQsv.g:395:3: ruleHeader
            {
             before(grammarAccess.getQuerySepartedValueAccess().getHeaderHeaderParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleHeader();

            state._fsp--;

             after(grammarAccess.getQuerySepartedValueAccess().getHeaderHeaderParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__QuerySepartedValue__HeaderAssignment_0"


    // $ANTLR start "rule__QuerySepartedValue__StatementsAssignment_1"
    // InternalQsv.g:404:1: rule__QuerySepartedValue__StatementsAssignment_1 : ( ruleStatement ) ;
    public final void rule__QuerySepartedValue__StatementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:408:1: ( ( ruleStatement ) )
            // InternalQsv.g:409:2: ( ruleStatement )
            {
            // InternalQsv.g:409:2: ( ruleStatement )
            // InternalQsv.g:410:3: ruleStatement
            {
             before(grammarAccess.getQuerySepartedValueAccess().getStatementsStatementParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleStatement();

            state._fsp--;

             after(grammarAccess.getQuerySepartedValueAccess().getStatementsStatementParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__QuerySepartedValue__StatementsAssignment_1"


    // $ANTLR start "rule__Header__NameFileAssignment_1"
    // InternalQsv.g:419:1: rule__Header__NameFileAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Header__NameFileAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:423:1: ( ( RULE_STRING ) )
            // InternalQsv.g:424:2: ( RULE_STRING )
            {
            // InternalQsv.g:424:2: ( RULE_STRING )
            // InternalQsv.g:425:3: RULE_STRING
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
    // InternalQsv.g:434:1: rule__Header__HasColumnNameAssignment_5_0 : ( ( 'yes' ) ) ;
    public final void rule__Header__HasColumnNameAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:438:1: ( ( ( 'yes' ) ) )
            // InternalQsv.g:439:2: ( ( 'yes' ) )
            {
            // InternalQsv.g:439:2: ( ( 'yes' ) )
            // InternalQsv.g:440:3: ( 'yes' )
            {
             before(grammarAccess.getHeaderAccess().getHasColumnNameYesKeyword_5_0_0()); 
            // InternalQsv.g:441:3: ( 'yes' )
            // InternalQsv.g:442:4: 'yes'
            {
             before(grammarAccess.getHeaderAccess().getHasColumnNameYesKeyword_5_0_0()); 
            match(input,16,FOLLOW_2); 
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
    // InternalQsv.g:453:1: rule__Statement__StatementAssignment : ( rulePrint ) ;
    public final void rule__Statement__StatementAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:457:1: ( ( rulePrint ) )
            // InternalQsv.g:458:2: ( rulePrint )
            {
            // InternalQsv.g:458:2: ( rulePrint )
            // InternalQsv.g:459:3: rulePrint
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


    // $ANTLR start "rule__Print__PrintAssignment"
    // InternalQsv.g:468:1: rule__Print__PrintAssignment : ( ( 'print' ) ) ;
    public final void rule__Print__PrintAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQsv.g:472:1: ( ( ( 'print' ) ) )
            // InternalQsv.g:473:2: ( ( 'print' ) )
            {
            // InternalQsv.g:473:2: ( ( 'print' ) )
            // InternalQsv.g:474:3: ( 'print' )
            {
             before(grammarAccess.getPrintAccess().getPrintPrintKeyword_0()); 
            // InternalQsv.g:475:3: ( 'print' )
            // InternalQsv.g:476:4: 'print'
            {
             before(grammarAccess.getPrintAccess().getPrintPrintKeyword_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getPrintAccess().getPrintPrintKeyword_0()); 

            }

             after(grammarAccess.getPrintAccess().getPrintPrintKeyword_0()); 

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
    // $ANTLR end "rule__Print__PrintAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010800L});

}