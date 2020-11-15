/*
 * generated by Xtext 2.23.0
 */
package idm.serializer;

import com.google.inject.Inject;
import idm.qsv.BinCond;
import idm.qsv.ColRange;
import idm.qsv.ColumnName;
import idm.qsv.ColumnNumber;
import idm.qsv.Columns;
import idm.qsv.Condition;
import idm.qsv.Empty;
import idm.qsv.Header;
import idm.qsv.HighestPriority;
import idm.qsv.Line;
import idm.qsv.LineRange;
import idm.qsv.Lines;
import idm.qsv.MidPriority;
import idm.qsv.OpComp;
import idm.qsv.Print;
import idm.qsv.QsvPackage;
import idm.qsv.QuerySeparatedValues;
import idm.qsv.Selector;
import idm.qsv.Statement;
import idm.qsv.Value;
import idm.services.QsvGrammarAccess;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class QsvSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private QsvGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == QsvPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case QsvPackage.BIN_COND:
				sequence_BinCond(context, (BinCond) semanticObject); 
				return; 
			case QsvPackage.BOOLEAN:
				sequence_Boolean(context, (idm.qsv.Boolean) semanticObject); 
				return; 
			case QsvPackage.COL_RANGE:
				sequence_ColRange(context, (ColRange) semanticObject); 
				return; 
			case QsvPackage.COLUMN_NAME:
				sequence_ColumnName(context, (ColumnName) semanticObject); 
				return; 
			case QsvPackage.COLUMN_NUMBER:
				sequence_ColumnNumber(context, (ColumnNumber) semanticObject); 
				return; 
			case QsvPackage.COLUMNS:
				sequence_Columns(context, (Columns) semanticObject); 
				return; 
			case QsvPackage.CONDITION:
				sequence_Condition(context, (Condition) semanticObject); 
				return; 
			case QsvPackage.EMPTY:
				sequence_Empty(context, (Empty) semanticObject); 
				return; 
			case QsvPackage.HEADER:
				sequence_Header(context, (Header) semanticObject); 
				return; 
			case QsvPackage.HIGHEST_PRIORITY:
				sequence_HighestPriority(context, (HighestPriority) semanticObject); 
				return; 
			case QsvPackage.LINE:
				sequence_Line(context, (Line) semanticObject); 
				return; 
			case QsvPackage.LINE_RANGE:
				sequence_LineRange(context, (LineRange) semanticObject); 
				return; 
			case QsvPackage.LINES:
				sequence_Lines(context, (Lines) semanticObject); 
				return; 
			case QsvPackage.MID_PRIORITY:
				sequence_MidPriority(context, (MidPriority) semanticObject); 
				return; 
			case QsvPackage.OP_COMP:
				sequence_OpComp(context, (OpComp) semanticObject); 
				return; 
			case QsvPackage.PRINT:
				sequence_Print(context, (Print) semanticObject); 
				return; 
			case QsvPackage.QUERY_SEPARATED_VALUES:
				sequence_QuerySeparatedValues(context, (QuerySeparatedValues) semanticObject); 
				return; 
			case QsvPackage.SELECTOR:
				sequence_Selector(context, (Selector) semanticObject); 
				return; 
			case QsvPackage.STATEMENT:
				sequence_Statement(context, (Statement) semanticObject); 
				return; 
			case QsvPackage.VALUE:
				sequence_Value(context, (Value) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     BinCond returns BinCond
	 *
	 * Constraint:
	 *     (colId=ID operator=OpComp (compStr=STRING | compId=ID | compValue=INT))
	 */
	protected void sequence_BinCond(ISerializationContext context, BinCond semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Value returns Boolean
	 *     Boolean returns Boolean
	 *
	 * Constraint:
	 *     bol='yes'
	 */
	protected void sequence_Boolean(ISerializationContext context, idm.qsv.Boolean semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, QsvPackage.Literals.BOOLEAN__BOL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QsvPackage.Literals.BOOLEAN__BOL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBooleanAccess().getBolYesKeyword_0_0(), semanticObject.getBol());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ColRange returns ColRange
	 *
	 * Constraint:
	 *     (start=Column end=Column)
	 */
	protected void sequence_ColRange(ISerializationContext context, ColRange semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, QsvPackage.Literals.COL_RANGE__START) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QsvPackage.Literals.COL_RANGE__START));
			if (transientValues.isValueTransient(semanticObject, QsvPackage.Literals.COL_RANGE__END) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QsvPackage.Literals.COL_RANGE__END));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getColRangeAccess().getStartColumnParserRuleCall_0_0(), semanticObject.getStart());
		feeder.accept(grammarAccess.getColRangeAccess().getEndColumnParserRuleCall_2_0(), semanticObject.getEnd());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Column returns ColumnName
	 *     ColumnName returns ColumnName
	 *
	 * Constraint:
	 *     nameb=ID
	 */
	protected void sequence_ColumnName(ISerializationContext context, ColumnName semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, QsvPackage.Literals.COLUMN_NAME__NAMEB) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QsvPackage.Literals.COLUMN_NAME__NAMEB));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getColumnNameAccess().getNamebIDTerminalRuleCall_0(), semanticObject.getNameb());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Column returns ColumnNumber
	 *     ColumnNumber returns ColumnNumber
	 *
	 * Constraint:
	 *     number=INT
	 */
	protected void sequence_ColumnNumber(ISerializationContext context, ColumnNumber semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, QsvPackage.Literals.COLUMN_NUMBER__NUMBER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QsvPackage.Literals.COLUMN_NUMBER__NUMBER));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getColumnNumberAccess().getNumberINTTerminalRuleCall_1_0(), semanticObject.getNumber());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Columns returns Columns
	 *
	 * Constraint:
	 *     (range=ColRange | column=Column)
	 */
	protected void sequence_Columns(ISerializationContext context, Columns semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Condition returns Condition
	 *
	 * Constraint:
	 *     (mid=MidPriority orCondition=Condition?)
	 */
	protected void sequence_Condition(ISerializationContext context, Condition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Empty returns Empty
	 *
	 * Constraint:
	 *     empty=' '
	 */
	protected void sequence_Empty(ISerializationContext context, Empty semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, QsvPackage.Literals.EMPTY__EMPTY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QsvPackage.Literals.EMPTY__EMPTY));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEmptyAccess().getEmptySpaceKeyword_0(), semanticObject.getEmpty());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Header returns Header
	 *
	 * Constraint:
	 *     (nameFile=STRING hasColumnName?='yes'?)
	 */
	protected void sequence_Header(ISerializationContext context, Header semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     HighestPriority returns HighestPriority
	 *
	 * Constraint:
	 *     (condition=BinCond | condition=Condition)
	 */
	protected void sequence_HighestPriority(ISerializationContext context, HighestPriority semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LineRange returns LineRange
	 *
	 * Constraint:
	 *     (start=INT end=INT)
	 */
	protected void sequence_LineRange(ISerializationContext context, LineRange semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, QsvPackage.Literals.LINE_RANGE__START) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QsvPackage.Literals.LINE_RANGE__START));
			if (transientValues.isValueTransient(semanticObject, QsvPackage.Literals.LINE_RANGE__END) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QsvPackage.Literals.LINE_RANGE__END));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLineRangeAccess().getStartINTTerminalRuleCall_0_0(), semanticObject.getStart());
		feeder.accept(grammarAccess.getLineRangeAccess().getEndINTTerminalRuleCall_2_0(), semanticObject.getEnd());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Line returns Line
	 *
	 * Constraint:
	 *     number=INT
	 */
	protected void sequence_Line(ISerializationContext context, Line semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, QsvPackage.Literals.LINE__NUMBER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QsvPackage.Literals.LINE__NUMBER));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLineAccess().getNumberINTTerminalRuleCall_1_0(), semanticObject.getNumber());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Lines returns Lines
	 *
	 * Constraint:
	 *     (((range=LineRange | line=Line) cond=Condition) | cond=Condition)?
	 */
	protected void sequence_Lines(ISerializationContext context, Lines semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     MidPriority returns MidPriority
	 *
	 * Constraint:
	 *     (high=HighestPriority andCondition=MidPriority?)
	 */
	protected void sequence_MidPriority(ISerializationContext context, MidPriority semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     OpComp returns OpComp
	 *
	 * Constraint:
	 *     op='='
	 */
	protected void sequence_OpComp(ISerializationContext context, OpComp semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, QsvPackage.Literals.OP_COMP__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QsvPackage.Literals.OP_COMP__OP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOpCompAccess().getOpEqualsSignKeyword_0_0(), semanticObject.getOp());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Print returns Print
	 *
	 * Constraint:
	 *     selector=Selector
	 */
	protected void sequence_Print(ISerializationContext context, Print semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, QsvPackage.Literals.PRINT__SELECTOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QsvPackage.Literals.PRINT__SELECTOR));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPrintAccess().getSelectorSelectorParserRuleCall_1_0(), semanticObject.getSelector());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     QuerySeparatedValues returns QuerySeparatedValues
	 *
	 * Constraint:
	 *     (header=Header statements+=Statement*)
	 */
	protected void sequence_QuerySeparatedValues(ISerializationContext context, QuerySeparatedValues semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Selector returns Selector
	 *
	 * Constraint:
	 *     ((columns=Columns lines=Lines) | lines=Lines)?
	 */
	protected void sequence_Selector(ISerializationContext context, Selector semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns Statement
	 *
	 * Constraint:
	 *     statement=Print
	 */
	protected void sequence_Statement(ISerializationContext context, Statement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, QsvPackage.Literals.STATEMENT__STATEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QsvPackage.Literals.STATEMENT__STATEMENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getStatementAccess().getStatementPrintParserRuleCall_0(), semanticObject.getStatement());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Value returns Value
	 *
	 * Constraint:
	 *     val=INT
	 */
	protected void sequence_Value(ISerializationContext context, Value semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, QsvPackage.Literals.VALUE__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QsvPackage.Literals.VALUE__VAL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getValueAccess().getValINTTerminalRuleCall_0_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
}