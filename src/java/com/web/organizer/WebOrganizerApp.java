/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer;
//package com.web.organizer.ui;

import com.vaadin.Application;
//import com.vaadin.ui.Label;
//import com.vaadin.ui.Window;
import com.vaadin.terminal.ExternalResource;
import com.web.organizer.events.BaseEvent.EventType;
import com.web.organizer.events.EventBus;
import com.web.organizer.events.OnChangePageListener;
import com.web.organizer.ui.AboutContent;
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
import java.util.ArrayList;

/**
 *
 * @author Gery
 */
public class WebOrganizerApp extends Application {

    private MainWindow wMain;
    private MainWindow wHelp;
    private MainWindow wShare;
    private MainWindow wContact;
    private MainWindow wTerms;
    private MainWindow wAbout;
    private MainWindow wPolicy;
    private MainWindow wSignUp;
    private MainWindow wMainRegisterView;
    private MainWindow wNewContact;
    private EventBus eventBus = new EventBus();

    public void print(Object object) {
        System.out.println(object.toString());

        ArrayList<MainWindow> arr = new ArrayList();
        arr.add(new MainWindow());

        arr.get(2).setPageContent(wContact);
    }

    @Override
    public void init() {
        MainContent mainContent = new MainContent();
        wMain = new MainWindow(eventBus, mainContent);
        wMain.setName("Home");
        setMainWindow(wMain);
        eventBus.addListener(EventType.CHANGE_PAGE_TO_HOME,
                new OnChangePageListener(new ExternalResource(wMain.getURL()))
                );

        wHelp = new MainWindow(eventBus, new HelpContent());
        wHelp.setName("help");
        addWindow(wHelp);
        eventBus.addListener(EventType.CHANGE_PAGE_TO_HELP,
                new OnChangePageListener(new ExternalResource(wHelp.getURL()))
                );

        wTerms = new MainWindow(eventBus, new TermsContent());
        wTerms.setName("terms");
        addWindow(wTerms);
        eventBus.addListener(EventType.CHANGE_PAGE_TO_TERMS,
                new OnChangePageListener(new ExternalResource(wTerms.getURL()))
                );

        wAbout = new MainWindow(eventBus, new AboutContent());
        wAbout.setName("about");
        addWindow(wAbout);
        eventBus.addListener(EventType.CHANGE_PAGE_TO_ABOUT,
                new OnChangePageListener(new ExternalResource(wAbout.getURL()))
                );

        wPolicy = new MainWindow(eventBus, new PolicyContent());
        wPolicy.setName("policy");
        addWindow(wPolicy);
        eventBus.addListener(EventType.CHANGE_PAGE_TO_POLICY,
                new OnChangePageListener(new ExternalResource(wPolicy.getURL()))
                );

        wSignUp = new MainWindow(eventBus, new SignUpContent());
        wSignUp.setName("signUp");
        addWindow(wSignUp);
        eventBus.addListener(EventType.CHANGE_PAGE_TO_SIGNUP,
                new OnChangePageListener(new ExternalResource(wSignUp.getURL()))
                );

        wShare = new MainWindow(eventBus, new ShareContent());
        wShare.setName("share");
        addWindow(wShare);
        eventBus.addListener(EventType.CHANGE_PAGE_TO_SHARE,
                new OnChangePageListener(new ExternalResource(wShare.getURL()))
                );

        wContact = new MainWindow(eventBus, new ContactContent());
        wContact.setName("contact");
        addWindow(wContact);
        eventBus.addListener(EventType.CHANGE_PAGE_TO_CONTACT,
                new OnChangePageListener(new ExternalResource(wContact.getURL()))
                );

        wMainRegisterView = new MainWindow(eventBus, new MainViewContent());
        wMainRegisterView.setName("registerview");
        addWindow(wMainRegisterView);
        eventBus.addListener(EventType.CHANGE_PAGE_TO_MAINVIEW,
                new OnChangePageListener(new ExternalResource(wMainRegisterView.getURL()))
                );

        wNewContact = new MainWindow(eventBus, new NewContactContent());
        wNewContact.setName("newcontact");
        addWindow(wNewContact);
        eventBus.addListener(EventType.CHANGE_PAGE_TO_NEWCONTACT,
                new OnChangePageListener(new ExternalResource(wNewContact.getURL()))
                );
    }
}
