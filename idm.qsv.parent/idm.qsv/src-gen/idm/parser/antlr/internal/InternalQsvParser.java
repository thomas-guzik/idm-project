package idm.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import idm.services.QsvGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalQsvParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'using'", "'with'", "'column'", "'names:'", "'yes'", "'no'", "'print'", "':columns'", "'*'", "'-'", "'#'", "':lines'", "'or'", "'and'", "'('", "')'", "'='", "'in'", "'<'", "'>'", "'<='", "'>='", "'!='", "'not in'"
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

        public InternalQsvParser(TokenStream input, QsvGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "QuerySeparatedValues";
       	}

       	@Override
       	protected QsvGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleQuerySeparatedValues"
    // InternalQsv.g:64:1: entryRuleQuerySeparatedValues returns [EObject current=null] : iv_ruleQuerySeparatedValues= ruleQuerySeparatedValues EOF ;
    public final EObject entryRuleQuerySeparatedValues() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuerySeparatedValues = null;


        try {
            // InternalQsv.g:64:61: (iv_ruleQuerySeparatedValues= ruleQuerySeparatedValues EOF )
            // InternalQsv.g:65:2: iv_ruleQuerySeparatedValues= ruleQuerySeparatedValues EOF
            {
             newCompositeNode(grammarAccess.getQuerySeparatedValuesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQuerySeparatedValues=ruleQuerySeparatedValues();

            state._fsp--;

             current =iv_ruleQuerySeparatedValues; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuerySeparatedValues"


    // $ANTLR start "ruleQuerySeparatedValues"
    // InternalQsv.g:71:1: ruleQuerySeparatedValues returns [EObject current=null] : ( ( (lv_header_0_0= ruleHeader ) ) ( (lv_statements_1_0= ruleStatement ) )* ) ;
    public final EObject ruleQuerySeparatedValues() throws RecognitionException {
        EObject current = null;

        EObject lv_header_0_0 = null;

        EObject lv_statements_1_0 = null;



        	enterRule();

        try {
            // InternalQsv.g:77:2: ( ( ( (lv_header_0_0= ruleHeader ) ) ( (lv_statements_1_0= ruleStatement ) )* ) )
            // InternalQsv.g:78:2: ( ( (lv_header_0_0= ruleHeader ) ) ( (lv_statements_1_0= ruleStatement ) )* )
            {
            // InternalQsv.g:78:2: ( ( (lv_header_0_0= ruleHeader ) ) ( (lv_statements_1_0= ruleStatement ) )* )
            // InternalQsv.g:79:3: ( (lv_header_0_0= ruleHeader ) ) ( (lv_statements_1_0= ruleStatement ) )*
            {
            // InternalQsv.g:79:3: ( (lv_header_0_0= ruleHeader ) )
            // InternalQsv.g:80:4: (lv_header_0_0= ruleHeader )
            {
            // InternalQsv.g:80:4: (lv_header_0_0= ruleHeader )
            // InternalQsv.g:81:5: lv_header_0_0= ruleHeader
            {

            					newCompositeNode(grammarAccess.getQuerySeparatedValuesAccess().getHeaderHeaderParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_3);
            lv_header_0_0=ruleHeader();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getQuerySeparatedValuesRule());
            					}
            					set(
            						current,
            						"header",
            						lv_header_0_0,
            						"idm.Qsv.Header");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalQsv.g:98:3: ( (lv_statements_1_0= ruleStatement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==17) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalQsv.g:99:4: (lv_statements_1_0= ruleStatement )
            	    {
            	    // InternalQsv.g:99:4: (lv_statements_1_0= ruleStatement )
            	    // InternalQsv.g:100:5: lv_statements_1_0= ruleStatement
            	    {

            	    					newCompositeNode(grammarAccess.getQuerySeparatedValuesAccess().getStatementsStatementParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_statements_1_0=ruleStatement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getQuerySeparatedValuesRule());
            	    					}
            	    					add(
            	    						current,
            	    						"statements",
            	    						lv_statements_1_0,
            	    						"idm.Qsv.Statement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuerySeparatedValues"


    // $ANTLR start "entryRuleHeader"
    // InternalQsv.g:121:1: entryRuleHeader returns [EObject current=null] : iv_ruleHeader= ruleHeader EOF ;
    public final EObject entryRuleHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHeader = null;


        try {
            // InternalQsv.g:121:47: (iv_ruleHeader= ruleHeader EOF )
            // InternalQsv.g:122:2: iv_ruleHeader= ruleHeader EOF
            {
             newCompositeNode(grammarAccess.getHeaderRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHeader=ruleHeader();

            state._fsp--;

             current =iv_ruleHeader; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHeader"


    // $ANTLR start "ruleHeader"
    // InternalQsv.g:128:1: ruleHeader returns [EObject current=null] : (otherlv_0= 'using' ( (lv_nameFile_1_0= RULE_STRING ) ) otherlv_2= 'with' otherlv_3= 'column' otherlv_4= 'names:' ( ( (lv_hasColumnName_5_0= 'yes' ) ) | otherlv_6= 'no' ) ) ;
    public final EObject ruleHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_nameFile_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_hasColumnName_5_0=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalQsv.g:134:2: ( (otherlv_0= 'using' ( (lv_nameFile_1_0= RULE_STRING ) ) otherlv_2= 'with' otherlv_3= 'column' otherlv_4= 'names:' ( ( (lv_hasColumnName_5_0= 'yes' ) ) | otherlv_6= 'no' ) ) )
            // InternalQsv.g:135:2: (otherlv_0= 'using' ( (lv_nameFile_1_0= RULE_STRING ) ) otherlv_2= 'with' otherlv_3= 'column' otherlv_4= 'names:' ( ( (lv_hasColumnName_5_0= 'yes' ) ) | otherlv_6= 'no' ) )
            {
            // InternalQsv.g:135:2: (otherlv_0= 'using' ( (lv_nameFile_1_0= RULE_STRING ) ) otherlv_2= 'with' otherlv_3= 'column' otherlv_4= 'names:' ( ( (lv_hasColumnName_5_0= 'yes' ) ) | otherlv_6= 'no' ) )
            // InternalQsv.g:136:3: otherlv_0= 'using' ( (lv_nameFile_1_0= RULE_STRING ) ) otherlv_2= 'with' otherlv_3= 'column' otherlv_4= 'names:' ( ( (lv_hasColumnName_5_0= 'yes' ) ) | otherlv_6= 'no' )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getHeaderAccess().getUsingKeyword_0());
            		
            // InternalQsv.g:140:3: ( (lv_nameFile_1_0= RULE_STRING ) )
            // InternalQsv.g:141:4: (lv_nameFile_1_0= RULE_STRING )
            {
            // InternalQsv.g:141:4: (lv_nameFile_1_0= RULE_STRING )
            // InternalQsv.g:142:5: lv_nameFile_1_0= RULE_STRING
            {
            lv_nameFile_1_0=(Token)match(input,RULE_STRING,FOLLOW_5); 

            					newLeafNode(lv_nameFile_1_0, grammarAccess.getHeaderAccess().getNameFileSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHeaderRule());
            					}
            					setWithLastConsumed(
            						current,
            						"nameFile",
            						lv_nameFile_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getHeaderAccess().getWithKeyword_2());
            		
            otherlv_3=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getHeaderAccess().getColumnKeyword_3());
            		
            otherlv_4=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getHeaderAccess().getNamesKeyword_4());
            		
            // InternalQsv.g:170:3: ( ( (lv_hasColumnName_5_0= 'yes' ) ) | otherlv_6= 'no' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==15) ) {
                alt2=1;
            }
            else if ( (LA2_0==16) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalQsv.g:171:4: ( (lv_hasColumnName_5_0= 'yes' ) )
                    {
                    // InternalQsv.g:171:4: ( (lv_hasColumnName_5_0= 'yes' ) )
                    // InternalQsv.g:172:5: (lv_hasColumnName_5_0= 'yes' )
                    {
                    // InternalQsv.g:172:5: (lv_hasColumnName_5_0= 'yes' )
                    // InternalQsv.g:173:6: lv_hasColumnName_5_0= 'yes'
                    {
                    lv_hasColumnName_5_0=(Token)match(input,15,FOLLOW_2); 

                    						newLeafNode(lv_hasColumnName_5_0, grammarAccess.getHeaderAccess().getHasColumnNameYesKeyword_5_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHeaderRule());
                    						}
                    						setWithLastConsumed(current, "hasColumnName", lv_hasColumnName_5_0 != null, "yes");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQsv.g:186:4: otherlv_6= 'no'
                    {
                    otherlv_6=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getHeaderAccess().getNoKeyword_5_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHeader"


    // $ANTLR start "entryRuleStatement"
    // InternalQsv.g:195:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalQsv.g:195:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalQsv.g:196:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalQsv.g:202:1: ruleStatement returns [EObject current=null] : ( (lv_statement_0_0= rulePrint ) ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_statement_0_0 = null;



        	enterRule();

        try {
            // InternalQsv.g:208:2: ( ( (lv_statement_0_0= rulePrint ) ) )
            // InternalQsv.g:209:2: ( (lv_statement_0_0= rulePrint ) )
            {
            // InternalQsv.g:209:2: ( (lv_statement_0_0= rulePrint ) )
            // InternalQsv.g:210:3: (lv_statement_0_0= rulePrint )
            {
            // InternalQsv.g:210:3: (lv_statement_0_0= rulePrint )
            // InternalQsv.g:211:4: lv_statement_0_0= rulePrint
            {

            				newCompositeNode(grammarAccess.getStatementAccess().getStatementPrintParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_statement_0_0=rulePrint();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getStatementRule());
            				}
            				set(
            					current,
            					"statement",
            					lv_statement_0_0,
            					"idm.Qsv.Print");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRulePrint"
    // InternalQsv.g:231:1: entryRulePrint returns [EObject current=null] : iv_rulePrint= rulePrint EOF ;
    public final EObject entryRulePrint() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrint = null;


        try {
            // InternalQsv.g:231:46: (iv_rulePrint= rulePrint EOF )
            // InternalQsv.g:232:2: iv_rulePrint= rulePrint EOF
            {
             newCompositeNode(grammarAccess.getPrintRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrint=rulePrint();

            state._fsp--;

             current =iv_rulePrint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrint"


    // $ANTLR start "rulePrint"
    // InternalQsv.g:238:1: rulePrint returns [EObject current=null] : (otherlv_0= 'print' ( (lv_selector_1_0= ruleSelector ) ) ) ;
    public final EObject rulePrint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_selector_1_0 = null;



        	enterRule();

        try {
            // InternalQsv.g:244:2: ( (otherlv_0= 'print' ( (lv_selector_1_0= ruleSelector ) ) ) )
            // InternalQsv.g:245:2: (otherlv_0= 'print' ( (lv_selector_1_0= ruleSelector ) ) )
            {
            // InternalQsv.g:245:2: (otherlv_0= 'print' ( (lv_selector_1_0= ruleSelector ) ) )
            // InternalQsv.g:246:3: otherlv_0= 'print' ( (lv_selector_1_0= ruleSelector ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getPrintAccess().getPrintKeyword_0());
            		
            // InternalQsv.g:250:3: ( (lv_selector_1_0= ruleSelector ) )
            // InternalQsv.g:251:4: (lv_selector_1_0= ruleSelector )
            {
            // InternalQsv.g:251:4: (lv_selector_1_0= ruleSelector )
            // InternalQsv.g:252:5: lv_selector_1_0= ruleSelector
            {

            					newCompositeNode(grammarAccess.getPrintAccess().getSelectorSelectorParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_selector_1_0=ruleSelector();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPrintRule());
            					}
            					set(
            						current,
            						"selector",
            						lv_selector_1_0,
            						"idm.Qsv.Selector");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrint"


    // $ANTLR start "entryRuleSelector"
    // InternalQsv.g:273:1: entryRuleSelector returns [EObject current=null] : iv_ruleSelector= ruleSelector EOF ;
    public final EObject entryRuleSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelector = null;


        try {
            // InternalQsv.g:273:49: (iv_ruleSelector= ruleSelector EOF )
            // InternalQsv.g:274:2: iv_ruleSelector= ruleSelector EOF
            {
             newCompositeNode(grammarAccess.getSelectorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSelector=ruleSelector();

            state._fsp--;

             current =iv_ruleSelector; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelector"


    // $ANTLR start "ruleSelector"
    // InternalQsv.g:280:1: ruleSelector returns [EObject current=null] : ( ( (lv_columns_0_0= ruleColumns ) )? ( (lv_lines_1_0= ruleLines ) )? ) ;
    public final EObject ruleSelector() throws RecognitionException {
        EObject current = null;

        EObject lv_columns_0_0 = null;

        EObject lv_lines_1_0 = null;



        	enterRule();

        try {
            // InternalQsv.g:286:2: ( ( ( (lv_columns_0_0= ruleColumns ) )? ( (lv_lines_1_0= ruleLines ) )? ) )
            // InternalQsv.g:287:2: ( ( (lv_columns_0_0= ruleColumns ) )? ( (lv_lines_1_0= ruleLines ) )? )
            {
            // InternalQsv.g:287:2: ( ( (lv_columns_0_0= ruleColumns ) )? ( (lv_lines_1_0= ruleLines ) )? )
            // InternalQsv.g:288:3: ( (lv_columns_0_0= ruleColumns ) )? ( (lv_lines_1_0= ruleLines ) )?
            {
            // InternalQsv.g:288:3: ( (lv_columns_0_0= ruleColumns ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==18) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalQsv.g:289:4: (lv_columns_0_0= ruleColumns )
                    {
                    // InternalQsv.g:289:4: (lv_columns_0_0= ruleColumns )
                    // InternalQsv.g:290:5: lv_columns_0_0= ruleColumns
                    {

                    					newCompositeNode(grammarAccess.getSelectorAccess().getColumnsColumnsParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_10);
                    lv_columns_0_0=ruleColumns();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSelectorRule());
                    					}
                    					set(
                    						current,
                    						"columns",
                    						lv_columns_0_0,
                    						"idm.Qsv.Columns");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalQsv.g:307:3: ( (lv_lines_1_0= ruleLines ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==22) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalQsv.g:308:4: (lv_lines_1_0= ruleLines )
                    {
                    // InternalQsv.g:308:4: (lv_lines_1_0= ruleLines )
                    // InternalQsv.g:309:5: lv_lines_1_0= ruleLines
                    {

                    					newCompositeNode(grammarAccess.getSelectorAccess().getLinesLinesParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_lines_1_0=ruleLines();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSelectorRule());
                    					}
                    					set(
                    						current,
                    						"lines",
                    						lv_lines_1_0,
                    						"idm.Qsv.Lines");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelector"


    // $ANTLR start "entryRuleColumns"
    // InternalQsv.g:330:1: entryRuleColumns returns [EObject current=null] : iv_ruleColumns= ruleColumns EOF ;
    public final EObject entryRuleColumns() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColumns = null;


        try {
            // InternalQsv.g:330:48: (iv_ruleColumns= ruleColumns EOF )
            // InternalQsv.g:331:2: iv_ruleColumns= ruleColumns EOF
            {
             newCompositeNode(grammarAccess.getColumnsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleColumns=ruleColumns();

            state._fsp--;

             current =iv_ruleColumns; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleColumns"


    // $ANTLR start "ruleColumns"
    // InternalQsv.g:337:1: ruleColumns returns [EObject current=null] : (otherlv_0= ':columns' ( ( (lv_range_1_0= ruleColRange ) ) | ( (lv_column_2_0= ruleColumn ) ) | otherlv_3= '*' )? ) ;
    public final EObject ruleColumns() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_range_1_0 = null;

        EObject lv_column_2_0 = null;



        	enterRule();

        try {
            // InternalQsv.g:343:2: ( (otherlv_0= ':columns' ( ( (lv_range_1_0= ruleColRange ) ) | ( (lv_column_2_0= ruleColumn ) ) | otherlv_3= '*' )? ) )
            // InternalQsv.g:344:2: (otherlv_0= ':columns' ( ( (lv_range_1_0= ruleColRange ) ) | ( (lv_column_2_0= ruleColumn ) ) | otherlv_3= '*' )? )
            {
            // InternalQsv.g:344:2: (otherlv_0= ':columns' ( ( (lv_range_1_0= ruleColRange ) ) | ( (lv_column_2_0= ruleColumn ) ) | otherlv_3= '*' )? )
            // InternalQsv.g:345:3: otherlv_0= ':columns' ( ( (lv_range_1_0= ruleColRange ) ) | ( (lv_column_2_0= ruleColumn ) ) | otherlv_3= '*' )?
            {
            otherlv_0=(Token)match(input,18,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getColumnsAccess().getColumnsKeyword_0());
            		
            // InternalQsv.g:349:3: ( ( (lv_range_1_0= ruleColRange ) ) | ( (lv_column_2_0= ruleColumn ) ) | otherlv_3= '*' )?
            int alt5=4;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1==EOF||LA5_1==17||LA5_1==22) ) {
                        alt5=2;
                    }
                    else if ( (LA5_1==20) ) {
                        alt5=1;
                    }
                    }
                    break;
                case 21:
                    {
                    int LA5_2 = input.LA(2);

                    if ( (LA5_2==RULE_INT) ) {
                        int LA5_7 = input.LA(3);

                        if ( (LA5_7==EOF||LA5_7==17||LA5_7==22) ) {
                            alt5=2;
                        }
                        else if ( (LA5_7==20) ) {
                            alt5=1;
                        }
                    }
                    }
                    break;
                case 19:
                    {
                    alt5=3;
                    }
                    break;
            }

            switch (alt5) {
                case 1 :
                    // InternalQsv.g:350:4: ( (lv_range_1_0= ruleColRange ) )
                    {
                    // InternalQsv.g:350:4: ( (lv_range_1_0= ruleColRange ) )
                    // InternalQsv.g:351:5: (lv_range_1_0= ruleColRange )
                    {
                    // InternalQsv.g:351:5: (lv_range_1_0= ruleColRange )
                    // InternalQsv.g:352:6: lv_range_1_0= ruleColRange
                    {

                    						newCompositeNode(grammarAccess.getColumnsAccess().getRangeColRangeParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_range_1_0=ruleColRange();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getColumnsRule());
                    						}
                    						set(
                    							current,
                    							"range",
                    							lv_range_1_0,
                    							"idm.Qsv.ColRange");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQsv.g:370:4: ( (lv_column_2_0= ruleColumn ) )
                    {
                    // InternalQsv.g:370:4: ( (lv_column_2_0= ruleColumn ) )
                    // InternalQsv.g:371:5: (lv_column_2_0= ruleColumn )
                    {
                    // InternalQsv.g:371:5: (lv_column_2_0= ruleColumn )
                    // InternalQsv.g:372:6: lv_column_2_0= ruleColumn
                    {

                    						newCompositeNode(grammarAccess.getColumnsAccess().getColumnColumnParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_column_2_0=ruleColumn();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getColumnsRule());
                    						}
                    						set(
                    							current,
                    							"column",
                    							lv_column_2_0,
                    							"idm.Qsv.Column");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalQsv.g:390:4: otherlv_3= '*'
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getColumnsAccess().getAsteriskKeyword_1_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleColumns"


    // $ANTLR start "entryRuleColRange"
    // InternalQsv.g:399:1: entryRuleColRange returns [EObject current=null] : iv_ruleColRange= ruleColRange EOF ;
    public final EObject entryRuleColRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColRange = null;


        try {
            // InternalQsv.g:399:49: (iv_ruleColRange= ruleColRange EOF )
            // InternalQsv.g:400:2: iv_ruleColRange= ruleColRange EOF
            {
             newCompositeNode(grammarAccess.getColRangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleColRange=ruleColRange();

            state._fsp--;

             current =iv_ruleColRange; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleColRange"


    // $ANTLR start "ruleColRange"
    // InternalQsv.g:406:1: ruleColRange returns [EObject current=null] : ( ( (lv_start_0_0= ruleColumn ) ) otherlv_1= '-' ( (lv_end_2_0= ruleColumn ) ) ) ;
    public final EObject ruleColRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_start_0_0 = null;

        EObject lv_end_2_0 = null;



        	enterRule();

        try {
            // InternalQsv.g:412:2: ( ( ( (lv_start_0_0= ruleColumn ) ) otherlv_1= '-' ( (lv_end_2_0= ruleColumn ) ) ) )
            // InternalQsv.g:413:2: ( ( (lv_start_0_0= ruleColumn ) ) otherlv_1= '-' ( (lv_end_2_0= ruleColumn ) ) )
            {
            // InternalQsv.g:413:2: ( ( (lv_start_0_0= ruleColumn ) ) otherlv_1= '-' ( (lv_end_2_0= ruleColumn ) ) )
            // InternalQsv.g:414:3: ( (lv_start_0_0= ruleColumn ) ) otherlv_1= '-' ( (lv_end_2_0= ruleColumn ) )
            {
            // InternalQsv.g:414:3: ( (lv_start_0_0= ruleColumn ) )
            // InternalQsv.g:415:4: (lv_start_0_0= ruleColumn )
            {
            // InternalQsv.g:415:4: (lv_start_0_0= ruleColumn )
            // InternalQsv.g:416:5: lv_start_0_0= ruleColumn
            {

            					newCompositeNode(grammarAccess.getColRangeAccess().getStartColumnParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_12);
            lv_start_0_0=ruleColumn();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getColRangeRule());
            					}
            					set(
            						current,
            						"start",
            						lv_start_0_0,
            						"idm.Qsv.Column");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,20,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getColRangeAccess().getHyphenMinusKeyword_1());
            		
            // InternalQsv.g:437:3: ( (lv_end_2_0= ruleColumn ) )
            // InternalQsv.g:438:4: (lv_end_2_0= ruleColumn )
            {
            // InternalQsv.g:438:4: (lv_end_2_0= ruleColumn )
            // InternalQsv.g:439:5: lv_end_2_0= ruleColumn
            {

            					newCompositeNode(grammarAccess.getColRangeAccess().getEndColumnParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_end_2_0=ruleColumn();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getColRangeRule());
            					}
            					set(
            						current,
            						"end",
            						lv_end_2_0,
            						"idm.Qsv.Column");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleColRange"


    // $ANTLR start "entryRuleColumn"
    // InternalQsv.g:460:1: entryRuleColumn returns [EObject current=null] : iv_ruleColumn= ruleColumn EOF ;
    public final EObject entryRuleColumn() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColumn = null;


        try {
            // InternalQsv.g:460:47: (iv_ruleColumn= ruleColumn EOF )
            // InternalQsv.g:461:2: iv_ruleColumn= ruleColumn EOF
            {
             newCompositeNode(grammarAccess.getColumnRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleColumn=ruleColumn();

            state._fsp--;

             current =iv_ruleColumn; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleColumn"


    // $ANTLR start "ruleColumn"
    // InternalQsv.g:467:1: ruleColumn returns [EObject current=null] : (this_ColumnName_0= ruleColumnName | this_ColumnNumber_1= ruleColumnNumber ) ;
    public final EObject ruleColumn() throws RecognitionException {
        EObject current = null;

        EObject this_ColumnName_0 = null;

        EObject this_ColumnNumber_1 = null;



        	enterRule();

        try {
            // InternalQsv.g:473:2: ( (this_ColumnName_0= ruleColumnName | this_ColumnNumber_1= ruleColumnNumber ) )
            // InternalQsv.g:474:2: (this_ColumnName_0= ruleColumnName | this_ColumnNumber_1= ruleColumnNumber )
            {
            // InternalQsv.g:474:2: (this_ColumnName_0= ruleColumnName | this_ColumnNumber_1= ruleColumnNumber )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==21) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalQsv.g:475:3: this_ColumnName_0= ruleColumnName
                    {

                    			newCompositeNode(grammarAccess.getColumnAccess().getColumnNameParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ColumnName_0=ruleColumnName();

                    state._fsp--;


                    			current = this_ColumnName_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalQsv.g:484:3: this_ColumnNumber_1= ruleColumnNumber
                    {

                    			newCompositeNode(grammarAccess.getColumnAccess().getColumnNumberParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ColumnNumber_1=ruleColumnNumber();

                    state._fsp--;


                    			current = this_ColumnNumber_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleColumn"


    // $ANTLR start "entryRuleColumnName"
    // InternalQsv.g:496:1: entryRuleColumnName returns [EObject current=null] : iv_ruleColumnName= ruleColumnName EOF ;
    public final EObject entryRuleColumnName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColumnName = null;


        try {
            // InternalQsv.g:496:51: (iv_ruleColumnName= ruleColumnName EOF )
            // InternalQsv.g:497:2: iv_ruleColumnName= ruleColumnName EOF
            {
             newCompositeNode(grammarAccess.getColumnNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleColumnName=ruleColumnName();

            state._fsp--;

             current =iv_ruleColumnName; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleColumnName"


    // $ANTLR start "ruleColumnName"
    // InternalQsv.g:503:1: ruleColumnName returns [EObject current=null] : ( (lv_nameb_0_0= RULE_ID ) ) ;
    public final EObject ruleColumnName() throws RecognitionException {
        EObject current = null;

        Token lv_nameb_0_0=null;


        	enterRule();

        try {
            // InternalQsv.g:509:2: ( ( (lv_nameb_0_0= RULE_ID ) ) )
            // InternalQsv.g:510:2: ( (lv_nameb_0_0= RULE_ID ) )
            {
            // InternalQsv.g:510:2: ( (lv_nameb_0_0= RULE_ID ) )
            // InternalQsv.g:511:3: (lv_nameb_0_0= RULE_ID )
            {
            // InternalQsv.g:511:3: (lv_nameb_0_0= RULE_ID )
            // InternalQsv.g:512:4: lv_nameb_0_0= RULE_ID
            {
            lv_nameb_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_nameb_0_0, grammarAccess.getColumnNameAccess().getNamebIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getColumnNameRule());
            				}
            				setWithLastConsumed(
            					current,
            					"nameb",
            					lv_nameb_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleColumnName"


    // $ANTLR start "entryRuleColumnNumber"
    // InternalQsv.g:531:1: entryRuleColumnNumber returns [EObject current=null] : iv_ruleColumnNumber= ruleColumnNumber EOF ;
    public final EObject entryRuleColumnNumber() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColumnNumber = null;


        try {
            // InternalQsv.g:531:53: (iv_ruleColumnNumber= ruleColumnNumber EOF )
            // InternalQsv.g:532:2: iv_ruleColumnNumber= ruleColumnNumber EOF
            {
             newCompositeNode(grammarAccess.getColumnNumberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleColumnNumber=ruleColumnNumber();

            state._fsp--;

             current =iv_ruleColumnNumber; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleColumnNumber"


    // $ANTLR start "ruleColumnNumber"
    // InternalQsv.g:538:1: ruleColumnNumber returns [EObject current=null] : (otherlv_0= '#' ( (lv_number_1_0= RULE_INT ) ) ) ;
    public final EObject ruleColumnNumber() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_number_1_0=null;


        	enterRule();

        try {
            // InternalQsv.g:544:2: ( (otherlv_0= '#' ( (lv_number_1_0= RULE_INT ) ) ) )
            // InternalQsv.g:545:2: (otherlv_0= '#' ( (lv_number_1_0= RULE_INT ) ) )
            {
            // InternalQsv.g:545:2: (otherlv_0= '#' ( (lv_number_1_0= RULE_INT ) ) )
            // InternalQsv.g:546:3: otherlv_0= '#' ( (lv_number_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,21,FOLLOW_14); 

            			newLeafNode(otherlv_0, grammarAccess.getColumnNumberAccess().getNumberSignKeyword_0());
            		
            // InternalQsv.g:550:3: ( (lv_number_1_0= RULE_INT ) )
            // InternalQsv.g:551:4: (lv_number_1_0= RULE_INT )
            {
            // InternalQsv.g:551:4: (lv_number_1_0= RULE_INT )
            // InternalQsv.g:552:5: lv_number_1_0= RULE_INT
            {
            lv_number_1_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_number_1_0, grammarAccess.getColumnNumberAccess().getNumberINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getColumnNumberRule());
            					}
            					setWithLastConsumed(
            						current,
            						"number",
            						lv_number_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleColumnNumber"


    // $ANTLR start "entryRuleLines"
    // InternalQsv.g:572:1: entryRuleLines returns [EObject current=null] : iv_ruleLines= ruleLines EOF ;
    public final EObject entryRuleLines() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLines = null;


        try {
            // InternalQsv.g:572:46: (iv_ruleLines= ruleLines EOF )
            // InternalQsv.g:573:2: iv_ruleLines= ruleLines EOF
            {
             newCompositeNode(grammarAccess.getLinesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLines=ruleLines();

            state._fsp--;

             current =iv_ruleLines; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLines"


    // $ANTLR start "ruleLines"
    // InternalQsv.g:579:1: ruleLines returns [EObject current=null] : (otherlv_0= ':lines' ( ( (lv_range_1_0= ruleLineRange ) ) | ( (lv_line_2_0= ruleLine ) ) | otherlv_3= '*' )? ( (lv_cond_4_0= ruleCondition ) )? ) ;
    public final EObject ruleLines() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_range_1_0 = null;

        EObject lv_line_2_0 = null;

        EObject lv_cond_4_0 = null;



        	enterRule();

        try {
            // InternalQsv.g:585:2: ( (otherlv_0= ':lines' ( ( (lv_range_1_0= ruleLineRange ) ) | ( (lv_line_2_0= ruleLine ) ) | otherlv_3= '*' )? ( (lv_cond_4_0= ruleCondition ) )? ) )
            // InternalQsv.g:586:2: (otherlv_0= ':lines' ( ( (lv_range_1_0= ruleLineRange ) ) | ( (lv_line_2_0= ruleLine ) ) | otherlv_3= '*' )? ( (lv_cond_4_0= ruleCondition ) )? )
            {
            // InternalQsv.g:586:2: (otherlv_0= ':lines' ( ( (lv_range_1_0= ruleLineRange ) ) | ( (lv_line_2_0= ruleLine ) ) | otherlv_3= '*' )? ( (lv_cond_4_0= ruleCondition ) )? )
            // InternalQsv.g:587:3: otherlv_0= ':lines' ( ( (lv_range_1_0= ruleLineRange ) ) | ( (lv_line_2_0= ruleLine ) ) | otherlv_3= '*' )? ( (lv_cond_4_0= ruleCondition ) )?
            {
            otherlv_0=(Token)match(input,22,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getLinesAccess().getLinesKeyword_0());
            		
            // InternalQsv.g:591:3: ( ( (lv_range_1_0= ruleLineRange ) ) | ( (lv_line_2_0= ruleLine ) ) | otherlv_3= '*' )?
            int alt7=4;
            switch ( input.LA(1) ) {
                case RULE_INT:
                    {
                    alt7=1;
                    }
                    break;
                case 21:
                    {
                    alt7=2;
                    }
                    break;
                case 19:
                    {
                    alt7=3;
                    }
                    break;
            }

            switch (alt7) {
                case 1 :
                    // InternalQsv.g:592:4: ( (lv_range_1_0= ruleLineRange ) )
                    {
                    // InternalQsv.g:592:4: ( (lv_range_1_0= ruleLineRange ) )
                    // InternalQsv.g:593:5: (lv_range_1_0= ruleLineRange )
                    {
                    // InternalQsv.g:593:5: (lv_range_1_0= ruleLineRange )
                    // InternalQsv.g:594:6: lv_range_1_0= ruleLineRange
                    {

                    						newCompositeNode(grammarAccess.getLinesAccess().getRangeLineRangeParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_range_1_0=ruleLineRange();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLinesRule());
                    						}
                    						set(
                    							current,
                    							"range",
                    							lv_range_1_0,
                    							"idm.Qsv.LineRange");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQsv.g:612:4: ( (lv_line_2_0= ruleLine ) )
                    {
                    // InternalQsv.g:612:4: ( (lv_line_2_0= ruleLine ) )
                    // InternalQsv.g:613:5: (lv_line_2_0= ruleLine )
                    {
                    // InternalQsv.g:613:5: (lv_line_2_0= ruleLine )
                    // InternalQsv.g:614:6: lv_line_2_0= ruleLine
                    {

                    						newCompositeNode(grammarAccess.getLinesAccess().getLineLineParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_line_2_0=ruleLine();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLinesRule());
                    						}
                    						set(
                    							current,
                    							"line",
                    							lv_line_2_0,
                    							"idm.Qsv.Line");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalQsv.g:632:4: otherlv_3= '*'
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_16); 

                    				newLeafNode(otherlv_3, grammarAccess.getLinesAccess().getAsteriskKeyword_1_2());
                    			

                    }
                    break;

            }

            // InternalQsv.g:637:3: ( (lv_cond_4_0= ruleCondition ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID||LA8_0==25) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalQsv.g:638:4: (lv_cond_4_0= ruleCondition )
                    {
                    // InternalQsv.g:638:4: (lv_cond_4_0= ruleCondition )
                    // InternalQsv.g:639:5: lv_cond_4_0= ruleCondition
                    {

                    					newCompositeNode(grammarAccess.getLinesAccess().getCondConditionParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_cond_4_0=ruleCondition();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getLinesRule());
                    					}
                    					set(
                    						current,
                    						"cond",
                    						lv_cond_4_0,
                    						"idm.Qsv.Condition");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLines"


    // $ANTLR start "entryRuleLineRange"
    // InternalQsv.g:660:1: entryRuleLineRange returns [EObject current=null] : iv_ruleLineRange= ruleLineRange EOF ;
    public final EObject entryRuleLineRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLineRange = null;


        try {
            // InternalQsv.g:660:50: (iv_ruleLineRange= ruleLineRange EOF )
            // InternalQsv.g:661:2: iv_ruleLineRange= ruleLineRange EOF
            {
             newCompositeNode(grammarAccess.getLineRangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLineRange=ruleLineRange();

            state._fsp--;

             current =iv_ruleLineRange; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLineRange"


    // $ANTLR start "ruleLineRange"
    // InternalQsv.g:667:1: ruleLineRange returns [EObject current=null] : ( ( (lv_start_0_0= RULE_INT ) ) otherlv_1= '-' ( (lv_end_2_0= RULE_INT ) ) ) ;
    public final EObject ruleLineRange() throws RecognitionException {
        EObject current = null;

        Token lv_start_0_0=null;
        Token otherlv_1=null;
        Token lv_end_2_0=null;


        	enterRule();

        try {
            // InternalQsv.g:673:2: ( ( ( (lv_start_0_0= RULE_INT ) ) otherlv_1= '-' ( (lv_end_2_0= RULE_INT ) ) ) )
            // InternalQsv.g:674:2: ( ( (lv_start_0_0= RULE_INT ) ) otherlv_1= '-' ( (lv_end_2_0= RULE_INT ) ) )
            {
            // InternalQsv.g:674:2: ( ( (lv_start_0_0= RULE_INT ) ) otherlv_1= '-' ( (lv_end_2_0= RULE_INT ) ) )
            // InternalQsv.g:675:3: ( (lv_start_0_0= RULE_INT ) ) otherlv_1= '-' ( (lv_end_2_0= RULE_INT ) )
            {
            // InternalQsv.g:675:3: ( (lv_start_0_0= RULE_INT ) )
            // InternalQsv.g:676:4: (lv_start_0_0= RULE_INT )
            {
            // InternalQsv.g:676:4: (lv_start_0_0= RULE_INT )
            // InternalQsv.g:677:5: lv_start_0_0= RULE_INT
            {
            lv_start_0_0=(Token)match(input,RULE_INT,FOLLOW_12); 

            					newLeafNode(lv_start_0_0, grammarAccess.getLineRangeAccess().getStartINTTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLineRangeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"start",
            						lv_start_0_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_1=(Token)match(input,20,FOLLOW_14); 

            			newLeafNode(otherlv_1, grammarAccess.getLineRangeAccess().getHyphenMinusKeyword_1());
            		
            // InternalQsv.g:697:3: ( (lv_end_2_0= RULE_INT ) )
            // InternalQsv.g:698:4: (lv_end_2_0= RULE_INT )
            {
            // InternalQsv.g:698:4: (lv_end_2_0= RULE_INT )
            // InternalQsv.g:699:5: lv_end_2_0= RULE_INT
            {
            lv_end_2_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_end_2_0, grammarAccess.getLineRangeAccess().getEndINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLineRangeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"end",
            						lv_end_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLineRange"


    // $ANTLR start "entryRuleLine"
    // InternalQsv.g:719:1: entryRuleLine returns [EObject current=null] : iv_ruleLine= ruleLine EOF ;
    public final EObject entryRuleLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLine = null;


        try {
            // InternalQsv.g:719:45: (iv_ruleLine= ruleLine EOF )
            // InternalQsv.g:720:2: iv_ruleLine= ruleLine EOF
            {
             newCompositeNode(grammarAccess.getLineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLine=ruleLine();

            state._fsp--;

             current =iv_ruleLine; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLine"


    // $ANTLR start "ruleLine"
    // InternalQsv.g:726:1: ruleLine returns [EObject current=null] : (otherlv_0= '#' ( (lv_number_1_0= RULE_INT ) ) ) ;
    public final EObject ruleLine() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_number_1_0=null;


        	enterRule();

        try {
            // InternalQsv.g:732:2: ( (otherlv_0= '#' ( (lv_number_1_0= RULE_INT ) ) ) )
            // InternalQsv.g:733:2: (otherlv_0= '#' ( (lv_number_1_0= RULE_INT ) ) )
            {
            // InternalQsv.g:733:2: (otherlv_0= '#' ( (lv_number_1_0= RULE_INT ) ) )
            // InternalQsv.g:734:3: otherlv_0= '#' ( (lv_number_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,21,FOLLOW_14); 

            			newLeafNode(otherlv_0, grammarAccess.getLineAccess().getNumberSignKeyword_0());
            		
            // InternalQsv.g:738:3: ( (lv_number_1_0= RULE_INT ) )
            // InternalQsv.g:739:4: (lv_number_1_0= RULE_INT )
            {
            // InternalQsv.g:739:4: (lv_number_1_0= RULE_INT )
            // InternalQsv.g:740:5: lv_number_1_0= RULE_INT
            {
            lv_number_1_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_number_1_0, grammarAccess.getLineAccess().getNumberINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLineRule());
            					}
            					setWithLastConsumed(
            						current,
            						"number",
            						lv_number_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLine"


    // $ANTLR start "entryRuleCondition"
    // InternalQsv.g:760:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalQsv.g:760:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalQsv.g:761:2: iv_ruleCondition= ruleCondition EOF
            {
             newCompositeNode(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCondition=ruleCondition();

            state._fsp--;

             current =iv_ruleCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalQsv.g:767:1: ruleCondition returns [EObject current=null] : ( ( (lv_mid_0_0= ruleMidPriority ) ) (otherlv_1= 'or' ( (lv_orCondition_2_0= ruleCondition ) ) )? ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_mid_0_0 = null;

        EObject lv_orCondition_2_0 = null;



        	enterRule();

        try {
            // InternalQsv.g:773:2: ( ( ( (lv_mid_0_0= ruleMidPriority ) ) (otherlv_1= 'or' ( (lv_orCondition_2_0= ruleCondition ) ) )? ) )
            // InternalQsv.g:774:2: ( ( (lv_mid_0_0= ruleMidPriority ) ) (otherlv_1= 'or' ( (lv_orCondition_2_0= ruleCondition ) ) )? )
            {
            // InternalQsv.g:774:2: ( ( (lv_mid_0_0= ruleMidPriority ) ) (otherlv_1= 'or' ( (lv_orCondition_2_0= ruleCondition ) ) )? )
            // InternalQsv.g:775:3: ( (lv_mid_0_0= ruleMidPriority ) ) (otherlv_1= 'or' ( (lv_orCondition_2_0= ruleCondition ) ) )?
            {
            // InternalQsv.g:775:3: ( (lv_mid_0_0= ruleMidPriority ) )
            // InternalQsv.g:776:4: (lv_mid_0_0= ruleMidPriority )
            {
            // InternalQsv.g:776:4: (lv_mid_0_0= ruleMidPriority )
            // InternalQsv.g:777:5: lv_mid_0_0= ruleMidPriority
            {

            					newCompositeNode(grammarAccess.getConditionAccess().getMidMidPriorityParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_17);
            lv_mid_0_0=ruleMidPriority();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionRule());
            					}
            					set(
            						current,
            						"mid",
            						lv_mid_0_0,
            						"idm.Qsv.MidPriority");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalQsv.g:794:3: (otherlv_1= 'or' ( (lv_orCondition_2_0= ruleCondition ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==23) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalQsv.g:795:4: otherlv_1= 'or' ( (lv_orCondition_2_0= ruleCondition ) )
                    {
                    otherlv_1=(Token)match(input,23,FOLLOW_18); 

                    				newLeafNode(otherlv_1, grammarAccess.getConditionAccess().getOrKeyword_1_0());
                    			
                    // InternalQsv.g:799:4: ( (lv_orCondition_2_0= ruleCondition ) )
                    // InternalQsv.g:800:5: (lv_orCondition_2_0= ruleCondition )
                    {
                    // InternalQsv.g:800:5: (lv_orCondition_2_0= ruleCondition )
                    // InternalQsv.g:801:6: lv_orCondition_2_0= ruleCondition
                    {

                    						newCompositeNode(grammarAccess.getConditionAccess().getOrConditionConditionParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_orCondition_2_0=ruleCondition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConditionRule());
                    						}
                    						set(
                    							current,
                    							"orCondition",
                    							lv_orCondition_2_0,
                    							"idm.Qsv.Condition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleMidPriority"
    // InternalQsv.g:823:1: entryRuleMidPriority returns [EObject current=null] : iv_ruleMidPriority= ruleMidPriority EOF ;
    public final EObject entryRuleMidPriority() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMidPriority = null;


        try {
            // InternalQsv.g:823:52: (iv_ruleMidPriority= ruleMidPriority EOF )
            // InternalQsv.g:824:2: iv_ruleMidPriority= ruleMidPriority EOF
            {
             newCompositeNode(grammarAccess.getMidPriorityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMidPriority=ruleMidPriority();

            state._fsp--;

             current =iv_ruleMidPriority; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMidPriority"


    // $ANTLR start "ruleMidPriority"
    // InternalQsv.g:830:1: ruleMidPriority returns [EObject current=null] : ( ( (lv_high_0_0= ruleHighestPriority ) ) (otherlv_1= 'and' ( (lv_andCondition_2_0= ruleMidPriority ) ) )? ) ;
    public final EObject ruleMidPriority() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_high_0_0 = null;

        EObject lv_andCondition_2_0 = null;



        	enterRule();

        try {
            // InternalQsv.g:836:2: ( ( ( (lv_high_0_0= ruleHighestPriority ) ) (otherlv_1= 'and' ( (lv_andCondition_2_0= ruleMidPriority ) ) )? ) )
            // InternalQsv.g:837:2: ( ( (lv_high_0_0= ruleHighestPriority ) ) (otherlv_1= 'and' ( (lv_andCondition_2_0= ruleMidPriority ) ) )? )
            {
            // InternalQsv.g:837:2: ( ( (lv_high_0_0= ruleHighestPriority ) ) (otherlv_1= 'and' ( (lv_andCondition_2_0= ruleMidPriority ) ) )? )
            // InternalQsv.g:838:3: ( (lv_high_0_0= ruleHighestPriority ) ) (otherlv_1= 'and' ( (lv_andCondition_2_0= ruleMidPriority ) ) )?
            {
            // InternalQsv.g:838:3: ( (lv_high_0_0= ruleHighestPriority ) )
            // InternalQsv.g:839:4: (lv_high_0_0= ruleHighestPriority )
            {
            // InternalQsv.g:839:4: (lv_high_0_0= ruleHighestPriority )
            // InternalQsv.g:840:5: lv_high_0_0= ruleHighestPriority
            {

            					newCompositeNode(grammarAccess.getMidPriorityAccess().getHighHighestPriorityParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_19);
            lv_high_0_0=ruleHighestPriority();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMidPriorityRule());
            					}
            					set(
            						current,
            						"high",
            						lv_high_0_0,
            						"idm.Qsv.HighestPriority");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalQsv.g:857:3: (otherlv_1= 'and' ( (lv_andCondition_2_0= ruleMidPriority ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==24) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalQsv.g:858:4: otherlv_1= 'and' ( (lv_andCondition_2_0= ruleMidPriority ) )
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_18); 

                    				newLeafNode(otherlv_1, grammarAccess.getMidPriorityAccess().getAndKeyword_1_0());
                    			
                    // InternalQsv.g:862:4: ( (lv_andCondition_2_0= ruleMidPriority ) )
                    // InternalQsv.g:863:5: (lv_andCondition_2_0= ruleMidPriority )
                    {
                    // InternalQsv.g:863:5: (lv_andCondition_2_0= ruleMidPriority )
                    // InternalQsv.g:864:6: lv_andCondition_2_0= ruleMidPriority
                    {

                    						newCompositeNode(grammarAccess.getMidPriorityAccess().getAndConditionMidPriorityParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_andCondition_2_0=ruleMidPriority();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMidPriorityRule());
                    						}
                    						set(
                    							current,
                    							"andCondition",
                    							lv_andCondition_2_0,
                    							"idm.Qsv.MidPriority");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMidPriority"


    // $ANTLR start "entryRuleHighestPriority"
    // InternalQsv.g:886:1: entryRuleHighestPriority returns [EObject current=null] : iv_ruleHighestPriority= ruleHighestPriority EOF ;
    public final EObject entryRuleHighestPriority() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHighestPriority = null;


        try {
            // InternalQsv.g:886:56: (iv_ruleHighestPriority= ruleHighestPriority EOF )
            // InternalQsv.g:887:2: iv_ruleHighestPriority= ruleHighestPriority EOF
            {
             newCompositeNode(grammarAccess.getHighestPriorityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHighestPriority=ruleHighestPriority();

            state._fsp--;

             current =iv_ruleHighestPriority; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHighestPriority"


    // $ANTLR start "ruleHighestPriority"
    // InternalQsv.g:893:1: ruleHighestPriority returns [EObject current=null] : ( ( (lv_condition_0_0= ruleBinCond ) ) | (otherlv_1= '(' ( (lv_condition_2_0= ruleCondition ) ) otherlv_3= ')' ) ) ;
    public final EObject ruleHighestPriority() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_condition_0_0 = null;

        EObject lv_condition_2_0 = null;



        	enterRule();

        try {
            // InternalQsv.g:899:2: ( ( ( (lv_condition_0_0= ruleBinCond ) ) | (otherlv_1= '(' ( (lv_condition_2_0= ruleCondition ) ) otherlv_3= ')' ) ) )
            // InternalQsv.g:900:2: ( ( (lv_condition_0_0= ruleBinCond ) ) | (otherlv_1= '(' ( (lv_condition_2_0= ruleCondition ) ) otherlv_3= ')' ) )
            {
            // InternalQsv.g:900:2: ( ( (lv_condition_0_0= ruleBinCond ) ) | (otherlv_1= '(' ( (lv_condition_2_0= ruleCondition ) ) otherlv_3= ')' ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            else if ( (LA11_0==25) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalQsv.g:901:3: ( (lv_condition_0_0= ruleBinCond ) )
                    {
                    // InternalQsv.g:901:3: ( (lv_condition_0_0= ruleBinCond ) )
                    // InternalQsv.g:902:4: (lv_condition_0_0= ruleBinCond )
                    {
                    // InternalQsv.g:902:4: (lv_condition_0_0= ruleBinCond )
                    // InternalQsv.g:903:5: lv_condition_0_0= ruleBinCond
                    {

                    					newCompositeNode(grammarAccess.getHighestPriorityAccess().getConditionBinCondParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_condition_0_0=ruleBinCond();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getHighestPriorityRule());
                    					}
                    					set(
                    						current,
                    						"condition",
                    						lv_condition_0_0,
                    						"idm.Qsv.BinCond");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQsv.g:921:3: (otherlv_1= '(' ( (lv_condition_2_0= ruleCondition ) ) otherlv_3= ')' )
                    {
                    // InternalQsv.g:921:3: (otherlv_1= '(' ( (lv_condition_2_0= ruleCondition ) ) otherlv_3= ')' )
                    // InternalQsv.g:922:4: otherlv_1= '(' ( (lv_condition_2_0= ruleCondition ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,25,FOLLOW_18); 

                    				newLeafNode(otherlv_1, grammarAccess.getHighestPriorityAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalQsv.g:926:4: ( (lv_condition_2_0= ruleCondition ) )
                    // InternalQsv.g:927:5: (lv_condition_2_0= ruleCondition )
                    {
                    // InternalQsv.g:927:5: (lv_condition_2_0= ruleCondition )
                    // InternalQsv.g:928:6: lv_condition_2_0= ruleCondition
                    {

                    						newCompositeNode(grammarAccess.getHighestPriorityAccess().getConditionConditionParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_condition_2_0=ruleCondition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHighestPriorityRule());
                    						}
                    						set(
                    							current,
                    							"condition",
                    							lv_condition_2_0,
                    							"idm.Qsv.Condition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,26,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getHighestPriorityAccess().getRightParenthesisKeyword_1_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHighestPriority"


    // $ANTLR start "entryRuleBinCond"
    // InternalQsv.g:954:1: entryRuleBinCond returns [EObject current=null] : iv_ruleBinCond= ruleBinCond EOF ;
    public final EObject entryRuleBinCond() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinCond = null;


        try {
            // InternalQsv.g:954:48: (iv_ruleBinCond= ruleBinCond EOF )
            // InternalQsv.g:955:2: iv_ruleBinCond= ruleBinCond EOF
            {
             newCompositeNode(grammarAccess.getBinCondRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinCond=ruleBinCond();

            state._fsp--;

             current =iv_ruleBinCond; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinCond"


    // $ANTLR start "ruleBinCond"
    // InternalQsv.g:961:1: ruleBinCond returns [EObject current=null] : ( ( (lv_colId_0_0= RULE_ID ) ) ( (lv_operator_1_0= ruleOpComp ) ) ( ( (lv_compStr_2_0= RULE_STRING ) ) | ( (lv_compId_3_0= RULE_ID ) ) | ( (lv_compValue_4_0= RULE_INT ) ) ) ) ;
    public final EObject ruleBinCond() throws RecognitionException {
        EObject current = null;

        Token lv_colId_0_0=null;
        Token lv_compStr_2_0=null;
        Token lv_compId_3_0=null;
        Token lv_compValue_4_0=null;
        EObject lv_operator_1_0 = null;



        	enterRule();

        try {
            // InternalQsv.g:967:2: ( ( ( (lv_colId_0_0= RULE_ID ) ) ( (lv_operator_1_0= ruleOpComp ) ) ( ( (lv_compStr_2_0= RULE_STRING ) ) | ( (lv_compId_3_0= RULE_ID ) ) | ( (lv_compValue_4_0= RULE_INT ) ) ) ) )
            // InternalQsv.g:968:2: ( ( (lv_colId_0_0= RULE_ID ) ) ( (lv_operator_1_0= ruleOpComp ) ) ( ( (lv_compStr_2_0= RULE_STRING ) ) | ( (lv_compId_3_0= RULE_ID ) ) | ( (lv_compValue_4_0= RULE_INT ) ) ) )
            {
            // InternalQsv.g:968:2: ( ( (lv_colId_0_0= RULE_ID ) ) ( (lv_operator_1_0= ruleOpComp ) ) ( ( (lv_compStr_2_0= RULE_STRING ) ) | ( (lv_compId_3_0= RULE_ID ) ) | ( (lv_compValue_4_0= RULE_INT ) ) ) )
            // InternalQsv.g:969:3: ( (lv_colId_0_0= RULE_ID ) ) ( (lv_operator_1_0= ruleOpComp ) ) ( ( (lv_compStr_2_0= RULE_STRING ) ) | ( (lv_compId_3_0= RULE_ID ) ) | ( (lv_compValue_4_0= RULE_INT ) ) )
            {
            // InternalQsv.g:969:3: ( (lv_colId_0_0= RULE_ID ) )
            // InternalQsv.g:970:4: (lv_colId_0_0= RULE_ID )
            {
            // InternalQsv.g:970:4: (lv_colId_0_0= RULE_ID )
            // InternalQsv.g:971:5: lv_colId_0_0= RULE_ID
            {
            lv_colId_0_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(lv_colId_0_0, grammarAccess.getBinCondAccess().getColIdIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBinCondRule());
            					}
            					setWithLastConsumed(
            						current,
            						"colId",
            						lv_colId_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalQsv.g:987:3: ( (lv_operator_1_0= ruleOpComp ) )
            // InternalQsv.g:988:4: (lv_operator_1_0= ruleOpComp )
            {
            // InternalQsv.g:988:4: (lv_operator_1_0= ruleOpComp )
            // InternalQsv.g:989:5: lv_operator_1_0= ruleOpComp
            {

            					newCompositeNode(grammarAccess.getBinCondAccess().getOperatorOpCompParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_22);
            lv_operator_1_0=ruleOpComp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinCondRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"idm.Qsv.OpComp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalQsv.g:1006:3: ( ( (lv_compStr_2_0= RULE_STRING ) ) | ( (lv_compId_3_0= RULE_ID ) ) | ( (lv_compValue_4_0= RULE_INT ) ) )
            int alt12=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt12=1;
                }
                break;
            case RULE_ID:
                {
                alt12=2;
                }
                break;
            case RULE_INT:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalQsv.g:1007:4: ( (lv_compStr_2_0= RULE_STRING ) )
                    {
                    // InternalQsv.g:1007:4: ( (lv_compStr_2_0= RULE_STRING ) )
                    // InternalQsv.g:1008:5: (lv_compStr_2_0= RULE_STRING )
                    {
                    // InternalQsv.g:1008:5: (lv_compStr_2_0= RULE_STRING )
                    // InternalQsv.g:1009:6: lv_compStr_2_0= RULE_STRING
                    {
                    lv_compStr_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_compStr_2_0, grammarAccess.getBinCondAccess().getCompStrSTRINGTerminalRuleCall_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBinCondRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"compStr",
                    							lv_compStr_2_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQsv.g:1026:4: ( (lv_compId_3_0= RULE_ID ) )
                    {
                    // InternalQsv.g:1026:4: ( (lv_compId_3_0= RULE_ID ) )
                    // InternalQsv.g:1027:5: (lv_compId_3_0= RULE_ID )
                    {
                    // InternalQsv.g:1027:5: (lv_compId_3_0= RULE_ID )
                    // InternalQsv.g:1028:6: lv_compId_3_0= RULE_ID
                    {
                    lv_compId_3_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(lv_compId_3_0, grammarAccess.getBinCondAccess().getCompIdIDTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBinCondRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"compId",
                    							lv_compId_3_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalQsv.g:1045:4: ( (lv_compValue_4_0= RULE_INT ) )
                    {
                    // InternalQsv.g:1045:4: ( (lv_compValue_4_0= RULE_INT ) )
                    // InternalQsv.g:1046:5: (lv_compValue_4_0= RULE_INT )
                    {
                    // InternalQsv.g:1046:5: (lv_compValue_4_0= RULE_INT )
                    // InternalQsv.g:1047:6: lv_compValue_4_0= RULE_INT
                    {
                    lv_compValue_4_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_compValue_4_0, grammarAccess.getBinCondAccess().getCompValueINTTerminalRuleCall_2_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBinCondRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"compValue",
                    							lv_compValue_4_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinCond"


    // $ANTLR start "entryRuleOpComp"
    // InternalQsv.g:1068:1: entryRuleOpComp returns [EObject current=null] : iv_ruleOpComp= ruleOpComp EOF ;
    public final EObject entryRuleOpComp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpComp = null;


        try {
            // InternalQsv.g:1068:47: (iv_ruleOpComp= ruleOpComp EOF )
            // InternalQsv.g:1069:2: iv_ruleOpComp= ruleOpComp EOF
            {
             newCompositeNode(grammarAccess.getOpCompRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOpComp=ruleOpComp();

            state._fsp--;

             current =iv_ruleOpComp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpComp"


    // $ANTLR start "ruleOpComp"
    // InternalQsv.g:1075:1: ruleOpComp returns [EObject current=null] : ( ( (lv_op_0_0= '=' ) ) | otherlv_1= 'in' | otherlv_2= '<' | otherlv_3= '>' | otherlv_4= '<=' | otherlv_5= '>=' | otherlv_6= '!=' | otherlv_7= 'not in' ) ;
    public final EObject ruleOpComp() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalQsv.g:1081:2: ( ( ( (lv_op_0_0= '=' ) ) | otherlv_1= 'in' | otherlv_2= '<' | otherlv_3= '>' | otherlv_4= '<=' | otherlv_5= '>=' | otherlv_6= '!=' | otherlv_7= 'not in' ) )
            // InternalQsv.g:1082:2: ( ( (lv_op_0_0= '=' ) ) | otherlv_1= 'in' | otherlv_2= '<' | otherlv_3= '>' | otherlv_4= '<=' | otherlv_5= '>=' | otherlv_6= '!=' | otherlv_7= 'not in' )
            {
            // InternalQsv.g:1082:2: ( ( (lv_op_0_0= '=' ) ) | otherlv_1= 'in' | otherlv_2= '<' | otherlv_3= '>' | otherlv_4= '<=' | otherlv_5= '>=' | otherlv_6= '!=' | otherlv_7= 'not in' )
            int alt13=8;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt13=1;
                }
                break;
            case 28:
                {
                alt13=2;
                }
                break;
            case 29:
                {
                alt13=3;
                }
                break;
            case 30:
                {
                alt13=4;
                }
                break;
            case 31:
                {
                alt13=5;
                }
                break;
            case 32:
                {
                alt13=6;
                }
                break;
            case 33:
                {
                alt13=7;
                }
                break;
            case 34:
                {
                alt13=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalQsv.g:1083:3: ( (lv_op_0_0= '=' ) )
                    {
                    // InternalQsv.g:1083:3: ( (lv_op_0_0= '=' ) )
                    // InternalQsv.g:1084:4: (lv_op_0_0= '=' )
                    {
                    // InternalQsv.g:1084:4: (lv_op_0_0= '=' )
                    // InternalQsv.g:1085:5: lv_op_0_0= '='
                    {
                    lv_op_0_0=(Token)match(input,27,FOLLOW_2); 

                    					newLeafNode(lv_op_0_0, grammarAccess.getOpCompAccess().getOpEqualsSignKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOpCompRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_0, "=");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQsv.g:1098:3: otherlv_1= 'in'
                    {
                    otherlv_1=(Token)match(input,28,FOLLOW_2); 

                    			newLeafNode(otherlv_1, grammarAccess.getOpCompAccess().getInKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalQsv.g:1103:3: otherlv_2= '<'
                    {
                    otherlv_2=(Token)match(input,29,FOLLOW_2); 

                    			newLeafNode(otherlv_2, grammarAccess.getOpCompAccess().getLessThanSignKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalQsv.g:1108:3: otherlv_3= '>'
                    {
                    otherlv_3=(Token)match(input,30,FOLLOW_2); 

                    			newLeafNode(otherlv_3, grammarAccess.getOpCompAccess().getGreaterThanSignKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalQsv.g:1113:3: otherlv_4= '<='
                    {
                    otherlv_4=(Token)match(input,31,FOLLOW_2); 

                    			newLeafNode(otherlv_4, grammarAccess.getOpCompAccess().getLessThanSignEqualsSignKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalQsv.g:1118:3: otherlv_5= '>='
                    {
                    otherlv_5=(Token)match(input,32,FOLLOW_2); 

                    			newLeafNode(otherlv_5, grammarAccess.getOpCompAccess().getGreaterThanSignEqualsSignKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalQsv.g:1123:3: otherlv_6= '!='
                    {
                    otherlv_6=(Token)match(input,33,FOLLOW_2); 

                    			newLeafNode(otherlv_6, grammarAccess.getOpCompAccess().getExclamationMarkEqualsSignKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalQsv.g:1128:3: otherlv_7= 'not in'
                    {
                    otherlv_7=(Token)match(input,34,FOLLOW_2); 

                    			newLeafNode(otherlv_7, grammarAccess.getOpCompAccess().getNotInKeyword_7());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpComp"


    // $ANTLR start "entryRuleBoolean"
    // InternalQsv.g:1136:1: entryRuleBoolean returns [EObject current=null] : iv_ruleBoolean= ruleBoolean EOF ;
    public final EObject entryRuleBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolean = null;


        try {
            // InternalQsv.g:1136:48: (iv_ruleBoolean= ruleBoolean EOF )
            // InternalQsv.g:1137:2: iv_ruleBoolean= ruleBoolean EOF
            {
             newCompositeNode(grammarAccess.getBooleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoolean=ruleBoolean();

            state._fsp--;

             current =iv_ruleBoolean; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // InternalQsv.g:1143:1: ruleBoolean returns [EObject current=null] : ( ( (lv_bol_0_0= 'yes' ) ) | otherlv_1= 'no' ) ;
    public final EObject ruleBoolean() throws RecognitionException {
        EObject current = null;

        Token lv_bol_0_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalQsv.g:1149:2: ( ( ( (lv_bol_0_0= 'yes' ) ) | otherlv_1= 'no' ) )
            // InternalQsv.g:1150:2: ( ( (lv_bol_0_0= 'yes' ) ) | otherlv_1= 'no' )
            {
            // InternalQsv.g:1150:2: ( ( (lv_bol_0_0= 'yes' ) ) | otherlv_1= 'no' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==15) ) {
                alt14=1;
            }
            else if ( (LA14_0==16) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalQsv.g:1151:3: ( (lv_bol_0_0= 'yes' ) )
                    {
                    // InternalQsv.g:1151:3: ( (lv_bol_0_0= 'yes' ) )
                    // InternalQsv.g:1152:4: (lv_bol_0_0= 'yes' )
                    {
                    // InternalQsv.g:1152:4: (lv_bol_0_0= 'yes' )
                    // InternalQsv.g:1153:5: lv_bol_0_0= 'yes'
                    {
                    lv_bol_0_0=(Token)match(input,15,FOLLOW_2); 

                    					newLeafNode(lv_bol_0_0, grammarAccess.getBooleanAccess().getBolYesKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanRule());
                    					}
                    					setWithLastConsumed(current, "bol", lv_bol_0_0, "yes");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQsv.g:1166:3: otherlv_1= 'no'
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_2); 

                    			newLeafNode(otherlv_1, grammarAccess.getBooleanAccess().getNoKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolean"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000440000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000280022L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000200020L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002280062L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000002000022L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002000020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00000007F8000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000070L});

}