/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.ui;

import com.vaadin.ui.VerticalLayout;
import com.web.organizer.events.EventBus;

/**
 *
 * @author Gery
 */
public class BaseContent extends VerticalLayout {
    
    private EventBus eventBus;
    
    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }
}
