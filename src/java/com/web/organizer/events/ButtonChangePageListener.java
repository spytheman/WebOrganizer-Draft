/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.events;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.web.organizer.events.BaseEvent.EventType;
import com.web.organizer.ui.MainWindow;

/**
 *
 * @author Gery
 */
// Custom event for buttons changing page
public class ButtonChangePageListener implements Button.ClickListener {

    EventType eventType;
    MainWindow sourceWindow;

    public ButtonChangePageListener(EventType eventType, MainWindow sourceWindow) {
        this.eventType = eventType;
        this.sourceWindow = sourceWindow;
    }

    @Override
    public void buttonClick(ClickEvent event) {
        // Set up event
        ChangePageEvent changeEvent = new ChangePageEvent();
        changeEvent.setEventType(eventType);
        changeEvent.setSource(event.getSource());
        changeEvent.setSourceEvent(event);
        changeEvent.setSourceWindow(sourceWindow);

        // Fire event
        sourceWindow.getEventBus().fireEvent(changeEvent);
    }
}
