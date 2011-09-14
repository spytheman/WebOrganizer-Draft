/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.ui;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.Tab;
import com.web.organizer.data.Note;
import com.web.organizer.data.Payment;
import com.web.organizer.data.Task;

/**
 *
 * @author Gery
 */
public class NewTabTaskContent extends BaseContent implements
        TabSheet.SelectedTabChangeListener {
    private Note note;
    private Task task;
    private Event event;
    private Payment payment;
    private static final ThemeResource icon1 = new ThemeResource(
            "../sampler/icons/action_save.gif");
    private static final ThemeResource icon2 = new ThemeResource(
            "../sampler/icons/comment_yellow.gif");

    private TabSheet tNotes;
    private TaskForm taskForm = new TaskForm();

   

    @Override
    public void selectedTabChange(SelectedTabChangeEvent event) {
        TabSheet tabsheet = event.getTabSheet();
        Tab tab = tabsheet.getTab(tabsheet.getSelectedTab());
        if (tab != null) {
            getWindow().showNotification("Selected tab: " + tab.getCaption());
        }


}}
