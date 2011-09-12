/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.ui;

/**
 *
 * @author Gery
 */

import com.vaadin.ui.Tree;

@SuppressWarnings("serial")
public class MenuTree extends Tree {
	public static final Object NEW_CONTACT = "Add New Contact";
	public static final Object NEW_TASK = "Add New Task";

	public MenuTree() {
		addItem(NEW_CONTACT);
		addItem(NEW_TASK);


		/*
		 * We want items to be selectable but do not want the user to be able to
		 * de-select an item.
		 */
		setSelectable(true);
		setNullSelectionAllowed(false);

		// Make application handle item click events
		//addListener((ItemClickListener) layout);

	}


}

