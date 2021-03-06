/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Clone Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CloneTarget#getSoapAction <em>Soap Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CloneTarget#getToAddress <em>To Address</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloneTarget()
 * @model
 * @generated
 */
public interface CloneTarget extends AbstractCommonTarget {
	/**
	 * Returns the value of the '<em><b>Soap Action</b></em>' attribute.
	 * The default value is <code>"soap_action"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Soap Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Soap Action</em>' attribute.
	 * @see #setSoapAction(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloneTarget_SoapAction()
	 * @model default="soap_action"
	 * @generated
	 */
	String getSoapAction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CloneTarget#getSoapAction <em>Soap Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Soap Action</em>' attribute.
	 * @see #getSoapAction()
	 * @generated
	 */
	void setSoapAction(String value);

	/**
	 * Returns the value of the '<em><b>To Address</b></em>' attribute.
	 * The default value is <code>"to_address"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Address</em>' attribute.
	 * @see #setToAddress(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloneTarget_ToAddress()
	 * @model default="to_address"
	 * @generated
	 */
	String getToAddress();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CloneTarget#getToAddress <em>To Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Address</em>' attribute.
	 * @see #getToAddress()
	 * @generated
	 */
	void setToAddress(String value);

} // CloneTarget
