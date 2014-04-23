/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dataMapper.diagram.custom.action;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import dataMapper.DataMapperFactory;
import dataMapper.DataMapperPackage;
import dataMapper.SchemaDataType;
import dataMapper.TreeNode;

public class AddNewRecordsListAction extends AbstractActionHandler {

	private EditPart selectedEP;
	private static final String ADD_NEW_RECORDS_LIST_ACTION_ID = "add-new-records-list-action-id"; //$NON-NLS-1$
	private static final String NEW_RECORDS_LIST_ID = "NewRecordsList"; //$NON-NLS-1$
	private static final String ADD_NEW_RECORDS_LIST = Messages.AddNewRecordsListAction_addNewRecordsList;

	public AddNewRecordsListAction(IWorkbenchPart workbenchPart) {
		super(workbenchPart);

		setId(ADD_NEW_RECORDS_LIST_ACTION_ID);
		setText(ADD_NEW_RECORDS_LIST);
		setToolTipText(ADD_NEW_RECORDS_LIST);
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
	}

	@Override
	protected void doRun(IProgressMonitor progressMonitor) {
		selectedEP = getSelectedEditPart();

		if (null != selectedEP) {
			// Returns the TreeNodeImpl object respective to selectedEP
			EObject object = ((Node) selectedEP.getModel()).getElement();
			// Used to identify the selected resource of the model
			TreeNode selectedNode = (TreeNode) object;

			// Configure the new tree node by setting default values
			TreeNode treeNodeNew = DataMapperFactory.eINSTANCE.createTreeNode();
			treeNodeNew.setName(NEW_RECORDS_LIST_ID);
			treeNodeNew.setLevel(selectedNode.getLevel() + 1);
			treeNodeNew.setSchemaDataType(SchemaDataType.ARRAY);

			/*
			 * AddCommand is used to avoid concurrent updating. index 0 to add
			 * as the first child
			 */
			AddCommand addCmd = new AddCommand(((GraphicalEditPart) selectedEP).getEditingDomain(),
					selectedNode, DataMapperPackage.Literals.TREE_NODE__NODE, treeNodeNew, 0);
			if (addCmd.canExecute()) {
				((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack()
						.execute(addCmd);
			}
		}
	}

	private EditPart getSelectedEditPart() {
		IStructuredSelection selection = getStructuredSelection();
		if (selection.size() == 1) {
			Object selectedEP = selection.getFirstElement();
			if (selectedEP instanceof EditPart) {
				return (EditPart) selectedEP;
			}
		}
		// In case of selecting the wrong editpart
		return null;
	}

	@Override
	public void refresh() {
		// refresh action. Does not do anything
	}
}