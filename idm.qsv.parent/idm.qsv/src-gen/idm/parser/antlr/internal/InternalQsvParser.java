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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'using'", "'with'", "'column'", "'names:'", "'yes'", "'no'", "'print'"
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

        public InternalQsvParser(TokenStream input, QsvGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "QuerySepartedValue";
       	}

       	@Override
       	protected QsvGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleQuerySepartedValue"
    // InternalQsv.g:64:1: entryRuleQuerySepartedValue returns [EObject current=null] : iv_ruleQuerySepartedValue= ruleQuerySepartedValue EOF ;
    public final EObject entryRuleQuerySepartedValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuerySepartedValue = null;


        try {
            // InternalQsv.g:64:59: (iv_ruleQuerySepartedValue= ruleQuerySepartedValue EOF )
            // InternalQsv.g:65:2: iv_ruleQuerySepartedValue= ruleQuerySepartedValue EOF
            {
             newCompositeNode(grammarAccess.getQuerySepartedValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQuerySepartedValue=ruleQuerySepartedValue();

            state._fsp--;

             current =iv_ruleQuerySepartedValue; 
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
    // $ANTLR end "entryRuleQuerySepartedValue"


    // $ANTLR start "ruleQuerySepartedValue"
    // InternalQsv.g:71:1: ruleQuerySepartedValue returns [EObject current=null] : ( ( (lv_header_0_0= ruleHeader ) ) ( (lv_statements_1_0= ruleStatement ) )* ) ;
    public final EObject ruleQuerySepartedValue() throws RecognitionException {
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

            					newCompositeNode(grammarAccess.getQuerySepartedValueAccess().getHeaderHeaderParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_3);
            lv_header_0_0=ruleHeader();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getQuerySepartedValueRule());
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

            	    					newCompositeNode(grammarAccess.getQuerySepartedValueAccess().getStatementsStatementParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_statements_1_0=ruleStatement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getQuerySepartedValueRule());
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
    // $ANTLR end "ruleQuerySepartedValue"


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
    // InternalQsv.g:238:1: rulePrint returns [EObject current=null] : ( (lv_print_0_0= 'print' ) ) ;
    public final EObject rulePrint() throws RecognitionException {
        EObject current = null;

        Token lv_print_0_0=null;


        	enterRule();

        try {
            // InternalQsv.g:244:2: ( ( (lv_print_0_0= 'print' ) ) )
            // InternalQsv.g:245:2: ( (lv_print_0_0= 'print' ) )
            {
            // InternalQsv.g:245:2: ( (lv_print_0_0= 'print' ) )
            // InternalQsv.g:246:3: (lv_print_0_0= 'print' )
            {
            // InternalQsv.g:246:3: (lv_print_0_0= 'print' )
            // InternalQsv.g:247:4: lv_print_0_0= 'print'
            {
            lv_print_0_0=(Token)match(input,17,FOLLOW_2); 

            				newLeafNode(lv_print_0_0, grammarAccess.getPrintAccess().getPrintPrintKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getPrintRule());
            				}
            				setWithLastConsumed(current, "print", lv_print_0_0, "print");
            			

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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000018000L});

}