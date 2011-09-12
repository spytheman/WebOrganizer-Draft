/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.events;

import com.vaadin.terminal.Resource;
import com.web.organizer.ui.MainWindow;

/**
 *
 * @author Gery
 */
public class OnChangePageListener implements EventListener {

    Resource resource= null;
    String windowName = null;

    public OnChangePageListener(Resource resource) {
        this.resource = resource;
        this.windowName = "_self";
    }
    
    public OnChangePageListener(Resource resource, String windowName) {
        this.resource = resource;
        this.windowName = windowName;
    }
    
    @Override
    public void actionPerformed(BaseEvent e) {
        MainWindow window = ((ChangePageEvent) e).getSourceWindow();
        
        window.open(resource, windowName);
    }
    
}
