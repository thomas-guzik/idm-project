/**
 * generated by Xtext 2.23.0
 */
package idm.qsv.impl;

import idm.qsv.Header;
import idm.qsv.QsvPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Header</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link idm.qsv.impl.HeaderImpl#getNameFile <em>Name File</em>}</li>
 *   <li>{@link idm.qsv.impl.HeaderImpl#isHasColumnName <em>Has Column Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HeaderImpl extends MinimalEObjectImpl.Container implements Header
{
  /**
   * The default value of the '{@link #getNameFile() <em>Name File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNameFile()
   * @generated
   * @ordered
   */
  protected static final String NAME_FILE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNameFile() <em>Name File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNameFile()
   * @generated
   * @ordered
   */
  protected String nameFile = NAME_FILE_EDEFAULT;

  /**
   * The default value of the '{@link #isHasColumnName() <em>Has Column Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHasColumnName()
   * @generated
   * @ordered
   */
  protected static final boolean HAS_COLUMN_NAME_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isHasColumnName() <em>Has Column Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHasColumnName()
   * @generated
   * @ordered
   */
  protected boolean hasColumnName = HAS_COLUMN_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HeaderImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return QsvPackage.Literals.HEADER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getNameFile()
  {
    return nameFile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNameFile(String newNameFile)
  {
    String oldNameFile = nameFile;
    nameFile = newNameFile;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QsvPackage.HEADER__NAME_FILE, oldNameFile, nameFile));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isHasColumnName()
  {
    return hasColumnName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setHasColumnName(boolean newHasColumnName)
  {
    boolean oldHasColumnName = hasColumnName;
    hasColumnName = newHasColumnName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QsvPackage.HEADER__HAS_COLUMN_NAME, oldHasColumnName, hasColumnName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case QsvPackage.HEADER__NAME_FILE:
        return getNameFile();
      case QsvPackage.HEADER__HAS_COLUMN_NAME:
        return isHasColumnName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case QsvPackage.HEADER__NAME_FILE:
        setNameFile((String)newValue);
        return;
      case QsvPackage.HEADER__HAS_COLUMN_NAME:
        setHasColumnName((Boolean)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case QsvPackage.HEADER__NAME_FILE:
        setNameFile(NAME_FILE_EDEFAULT);
        return;
      case QsvPackage.HEADER__HAS_COLUMN_NAME:
        setHasColumnName(HAS_COLUMN_NAME_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case QsvPackage.HEADER__NAME_FILE:
        return NAME_FILE_EDEFAULT == null ? nameFile != null : !NAME_FILE_EDEFAULT.equals(nameFile);
      case QsvPackage.HEADER__HAS_COLUMN_NAME:
        return hasColumnName != HAS_COLUMN_NAME_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (nameFile: ");
    result.append(nameFile);
    result.append(", hasColumnName: ");
    result.append(hasColumnName);
    result.append(')');
    return result.toString();
  }

} //HeaderImpl
