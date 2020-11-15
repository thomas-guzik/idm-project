/*
 * generated by Xtext 2.23.0
 */
package idm.serializer;

import com.google.inject.Inject;
import idm.services.QsvGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class QsvSyntacticSequencer extends AbstractSyntacticSequencer {

	protected QsvGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Boolean_Value_NoKeyword_1_or_STRINGTerminalRuleCall_1;
	protected AbstractElementAlias match_Columns_AsteriskKeyword_1_2_q;
	protected AbstractElementAlias match_Lines_AsteriskKeyword_1_2_q;
	protected AbstractElementAlias match_OpComp_ExclamationMarkEqualsSignKeyword_6_or_GreaterThanSignEqualsSignKeyword_5_or_GreaterThanSignKeyword_3_or_InKeyword_1_or_LessThanSignEqualsSignKeyword_4_or_LessThanSignKeyword_2_or_NotInKeyword_7;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (QsvGrammarAccess) access;
		match_Boolean_Value_NoKeyword_1_or_STRINGTerminalRuleCall_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getBooleanAccess().getNoKeyword_1()), new TokenAlias(false, false, grammarAccess.getValueAccess().getSTRINGTerminalRuleCall_1()));
		match_Columns_AsteriskKeyword_1_2_q = new TokenAlias(false, true, grammarAccess.getColumnsAccess().getAsteriskKeyword_1_2());
		match_Lines_AsteriskKeyword_1_2_q = new TokenAlias(false, true, grammarAccess.getLinesAccess().getAsteriskKeyword_1_2());
		match_OpComp_ExclamationMarkEqualsSignKeyword_6_or_GreaterThanSignEqualsSignKeyword_5_or_GreaterThanSignKeyword_3_or_InKeyword_1_or_LessThanSignEqualsSignKeyword_4_or_LessThanSignKeyword_2_or_NotInKeyword_7 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getOpCompAccess().getExclamationMarkEqualsSignKeyword_6()), new TokenAlias(false, false, grammarAccess.getOpCompAccess().getGreaterThanSignEqualsSignKeyword_5()), new TokenAlias(false, false, grammarAccess.getOpCompAccess().getGreaterThanSignKeyword_3()), new TokenAlias(false, false, grammarAccess.getOpCompAccess().getInKeyword_1()), new TokenAlias(false, false, grammarAccess.getOpCompAccess().getLessThanSignEqualsSignKeyword_4()), new TokenAlias(false, false, grammarAccess.getOpCompAccess().getLessThanSignKeyword_2()), new TokenAlias(false, false, grammarAccess.getOpCompAccess().getNotInKeyword_7()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getSTRINGRule())
			return getSTRINGToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal STRING:
	 * 			'"' ( '\\' .  | !('\\'|'"') )* '"' |
	 * 			"'" ( '\\' .  | !('\\'|"'") )* "'"
	 * 		;
	 */
	protected String getSTRINGToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "\"\"";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_Boolean_Value_NoKeyword_1_or_STRINGTerminalRuleCall_1.equals(syntax))
				emit_Boolean_Value_NoKeyword_1_or_STRINGTerminalRuleCall_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Columns_AsteriskKeyword_1_2_q.equals(syntax))
				emit_Columns_AsteriskKeyword_1_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Lines_AsteriskKeyword_1_2_q.equals(syntax))
				emit_Lines_AsteriskKeyword_1_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_OpComp_ExclamationMarkEqualsSignKeyword_6_or_GreaterThanSignEqualsSignKeyword_5_or_GreaterThanSignKeyword_3_or_InKeyword_1_or_LessThanSignEqualsSignKeyword_4_or_LessThanSignKeyword_2_or_NotInKeyword_7.equals(syntax))
				emit_OpComp_ExclamationMarkEqualsSignKeyword_6_or_GreaterThanSignEqualsSignKeyword_5_or_GreaterThanSignKeyword_3_or_InKeyword_1_or_LessThanSignEqualsSignKeyword_4_or_LessThanSignKeyword_2_or_NotInKeyword_7(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     STRING | 'no'
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) (rule start)
	 */
	protected void emit_Boolean_Value_NoKeyword_1_or_STRINGTerminalRuleCall_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '*'?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) ':columns' (ambiguity) (rule start)
	 */
	protected void emit_Columns_AsteriskKeyword_1_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '*'?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) ':lines' (ambiguity) (rule start)
	 *     (rule start) ':lines' (ambiguity) cond=Condition
	 */
	protected void emit_Lines_AsteriskKeyword_1_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (
	  *         'in' | 
	  *         '<' | 
	  *         '>' | 
	  *         '<=' | 
	  *         '>=' | 
	  *         '!=' | 
	  *         'not in'
	  *     )
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) (rule start)
	 */
	protected void emit_OpComp_ExclamationMarkEqualsSignKeyword_6_or_GreaterThanSignEqualsSignKeyword_5_or_GreaterThanSignKeyword_3_or_InKeyword_1_or_LessThanSignEqualsSignKeyword_4_or_LessThanSignKeyword_2_or_NotInKeyword_7(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}