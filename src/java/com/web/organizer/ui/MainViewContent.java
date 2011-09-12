/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.ui;

import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.web.organizer.events.BaseEvent.EventType;
import com.web.organizer.events.ButtonChangePageListener;
import com.web.organizer.events.EventBus;

/**
 *
 * @author Gery
 */
public class MainViewContent extends BaseContent {

    private GridLayout viewLayout = null;
    private Panel pReminders;
    private Panel panelComming;
    private Panel pCalendar;
    private Panel pNotifications;
    private FormLayout fReminders;
    private FormLayout formComming;
    private FormLayout fCalendar;
    private FormLayout fNotifications;
    private Button btnNewContact;
    private MenuTree menu = new MenuTree();

    public MainViewContent() {
        btnNewContact = new Button("Add new contact");
        pReminders = new Panel("Reminders");
        //pReminders.setWidth(Sizeable.SIZE_UNDEFINED, 50);
        fReminders = new FormLayout();
        fReminders.setMargin(true);
        fReminders.addComponent(new Label("You don't have new reminders"));
        pReminders.setContent(fReminders);

        panelComming = new Panel("Coming Up");
        //panelComming.setWidth(Sizeable.SIZE_UNDEFINED, 0);
        formComming = new FormLayout();
        formComming.setMargin(true);
        formComming.addComponent(new Label("No results found"));
        panelComming.setContent(formComming);

        pCalendar = new Panel("Daily View");
        //pCalendar.setWidth(Sizeable.SIZE_UNDEFINED, 0);
        fCalendar = new FormLayout();
        fCalendar.setMargin(true);
        fCalendar.addComponent(new Label("Calendar"));
        pCalendar.setContent(fCalendar);

        pNotifications = new Panel("Latest Notifications");
        //pCalendar.setWidth(Sizeable.SIZE_UNDEFINED, 0);
        fNotifications = new FormLayout();
        fNotifications.setMargin(true);
        fNotifications.addComponent(new Label("No Notifications"));
        pNotifications.setContent(fNotifications);

        viewLayout = new GridLayout(3, 3);
        viewLayout.setSpacing(true);
        viewLayout.addComponent(panelComming,1,0);
        viewLayout.addComponent(pReminders,2,1);
        viewLayout.addComponent(pCalendar,1,1);
        viewLayout.addComponent(pNotifications,2,0);
        viewLayout.addComponent(menu,0,1);
        viewLayout.addComponent(btnNewContact,0,0);

        viewLayout.setSizeFull();
        addComponent(viewLayout);
}
@Override
    public void setEventBus(EventBus eventBus) {

        // Set up event bus

        super.setEventBus(eventBus);
        btnNewContact.addListener(new ButtonChangePageListener(EventType.CHANGE_PAGE_TO_NEWCONTACT, (MainWindow) getWindow()));
    }
}

