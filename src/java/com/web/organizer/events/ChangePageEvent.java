/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.events;

import com.web.organizer.ui.MainWindow;

/**
 *
 * @author Gery
 */
public class ChangePageEvent extends BaseEvent {
    
    private MainWindow sourceWindow = null;

    public MainWindow getSourceWindow() {
        return sourceWindow;
    }

    public void setSourceWindow(MainWindow sourceWindow) {
        this.sourceWindow = sourceWindow;
    }
}
