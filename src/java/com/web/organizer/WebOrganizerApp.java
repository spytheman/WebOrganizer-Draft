/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer;
//package com.web.organizer.ui;

import com.vaadin.Application;

import com.vaadin.terminal.ExternalResource;
import com.web.organizer.events.BaseEvent.EventType;
import com.web.organizer.events.EventBus;
import com.web.organizer.events.OnChangePageListener;
import com.web.organizer.ui.AboutContent;
import com.web.organizer.ui.BaseContent;
import com.web.organizer.ui.ContactContent;
import com.web.organizer.ui.HelpContent;
import com.web.organizer.ui.MainContent;
import com.web.organizer.ui.MainViewContent;
import com.web.organizer.ui.MainWindow;
import com.web.organizer.ui.NewContactContent;
import com.web.organizer.ui.PolicyContent;
import com.web.organizer.ui.ShareContent;
import com.web.organizer.ui.SignUpContent;
import com.web.organizer.ui.TermsContent;

/**
 *
 * @author Gery
 */
public class WebOrganizerApp extends Application {
    private EventBus eventBus;

    @Override
    public void init() {
        eventBus = new EventBus();

        newTab(new HelpContent(), "Help", EventType.CHANGE_PAGE_TO_HELP);
        newTab(new TermsContent(), "Terms", EventType.CHANGE_PAGE_TO_TERMS);
        newTab(new AboutContent(), "About", EventType.CHANGE_PAGE_TO_ABOUT);
        newTab(new PolicyContent(), "Policy", EventType.CHANGE_PAGE_TO_POLICY);
        newTab(new SignUpContent(), "SignUp", EventType.CHANGE_PAGE_TO_SIGNUP);
        newTab(new ShareContent(), "Share", EventType.CHANGE_PAGE_TO_SHARE);
        newTab(new ContactContent(), "Contact", EventType.CHANGE_PAGE_TO_CONTACT);
        newTab(new MainViewContent(), "Register", EventType.CHANGE_PAGE_TO_MAINVIEW);
        newTab(new NewContactContent(), "NewContact", EventType.CHANGE_PAGE_TO_NEWCONTACT);
        
        // The last one will be the default view
        newTab(new MainContent(), "/", EventType.CHANGE_PAGE_TO_HOME);
    }

    private void newTab(BaseContent c, String label, EventType e) {
        MainWindow tab = new MainWindow(eventBus, c);
        tab.setName(label);
        setMainWindow(tab);
        eventBus.addListener(e, new OnChangePageListener(new ExternalResource(tab.getURL())));
    }
}
