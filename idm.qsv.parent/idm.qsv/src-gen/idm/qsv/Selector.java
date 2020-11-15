/**
 * generated by Xtext 2.23.0
 */
package idm.qsv;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link idm.qsv.Selector#getColumns <em>Columns</em>}</li>
 *   <li>{@link idm.qsv.Selector#getLines <em>Lines</em>}</li>
 * </ul>
 *
 * @see idm.qsv.QsvPackage#getSelector()
 * @model
 * @generated
 */
public interface Selector extends EObject
{
  /**
   * Returns the value of the '<em><b>Columns</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Columns</em>' containment reference.
   * @see #setColumns(Columns)
   * @see idm.qsv.QsvPackage#getSelector_Columns()
   * @model containment="true"
   * @generated
   */
  Columns getColumns();

  /**
   * Sets the value of the '{@link idm.qsv.Selector#getColumns <em>Columns</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Columns</em>' containment reference.
   * @see #getColumns()
   * @generated
   */
  void setColumns(Columns value);

  /**
   * Returns the value of the '<em><b>Lines</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lines</em>' containment reference.
   * @see #setLines(Lines)
   * @see idm.qsv.QsvPackage#getSelector_Lines()
   * @model containment="true"
   * @generated
   */
  Lines getLines();

  /**
   * Sets the value of the '{@link idm.qsv.Selector#getLines <em>Lines</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lines</em>' containment reference.
   * @see #getLines()
   * @generated
   */
  void setLines(Lines value);

} // Selector