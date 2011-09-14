/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.ui;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;
import com.web.organizer.events.BaseEvent.EventType;
import com.web.organizer.events.ButtonChangePageListener;
import com.web.organizer.events.EventBus;

/**
 *
 * @author Gery
 */
public class MainWindow extends Window {

    //private Embedded imgLogo;
    private GridLayout mainLayout = null;
    private Button btnHome;
    private Button btnLogin;
    private Button btnSignup;
    private Button btnDemoLogin;
    private Button btnHelp;
    private Button btnContact;
    private Button btnFeatures;
    private Button btnScreenshots;
    private Button btnTerms;
    private Button btnAboutUs;
    private Button btnPrivacyPolicy;
    private EventBus eventBus = null;

    public MainWindow() {
        this(null, null);
    }

    private Button newButton(String label, EventType x) {
        Button b = new Button(label);
        b.setStyleName(Reindeer.BUTTON_LINK);
        b.addListener(new ButtonChangePageListener(x, this));
        return b;
    }

    public MainWindow(EventBus eventBus, BaseContent content) {
        setTheme("runo");
        // Set my event bus
        this.eventBus = eventBus;

        // Main Buttons

        btnHome = newButton("Home", EventType.CHANGE_PAGE_TO_HOME);
        btnLogin = newButton("Login", EventType.CHANGE_PAGE_TO_LOGIN);
        btnSignup = newButton("Sign up", EventType.CHANGE_PAGE_TO_SIGNUP);
        btnDemoLogin = newButton("DemoLogin", EventType.CHANGE_PAGE_TO_DEMOLOGIN);
        btnContact = newButton("Contacts", EventType.CHANGE_PAGE_TO_CONTACT);
        btnHelp = newButton("Help", EventType.CHANGE_PAGE_TO_HELP);
        btnTerms = newButton("Terms Of Use", EventType.CHANGE_PAGE_TO_TERMS);
        btnFeatures = newButton("Features", EventType.CHANGE_PAGE_TO_FEATURES);
        btnScreenshots = newButton("Screenshots", EventType.CHANGE_PAGE_TO_SCREENSHOTS);
        btnPrivacyPolicy = newButton("Privacy Policy", EventType.CHANGE_PAGE_TO_POLICY);
        btnAboutUs = newButton("About Us", EventType.CHANGE_PAGE_TO_ABOUT);

        setCaption("Main Window");
        mainLayout = new GridLayout(3, 3);
        mainLayout.setSpacing(true);

        mainLayout.setSizeFull();
        mainLayout.addComponent(MotoToolBar(), 1, 0);
        mainLayout.addComponent(InfoText(), 1, 2);

        addComponent(mainLayout);

        // Set content
        mainLayout.removeComponent(1, 1);
        mainLayout.addComponent(content, 1, 1);
        content.setEventBus(eventBus);
    }

    public void setPageContent(Component content) {
        mainLayout.removeComponent(1, 1);
        mainLayout.addComponent(content, 1, 1);
    }

    public Component getPageContent() {
        return (VerticalLayout) mainLayout.getComponent(1, 1);
    }

    private HorizontalLayout createToolbar() {

        HorizontalLayout lo = new HorizontalLayout();
        lo.addStyleName("Toolbar");
        lo.setSpacing(true);
        lo.setMargin(true);

        lo.setWidth("100%");

        lo.addComponent(btnHome);
        lo.addComponent(btnLogin);
        lo.addComponent(btnSignup);
        lo.addComponent(btnDemoLogin);
        lo.addComponent(btnContact);
        return lo;

    }

    private VerticalLayout MotoToolBar() {

        VerticalLayout moto = new VerticalLayout();
        Label title = new Label(("<h1><font color = 33CC00><b>Get your life and work properly ordered!</b></font></h1>"));
        title.setContentMode(Label.CONTENT_XHTML);
        moto.addComponent(title);
        moto.addComponent(createToolbar());
        return moto;

    }

    private HorizontalLayout InfoText() {
        HorizontalLayout FAQLinks = new HorizontalLayout();
        FAQLinks.addStyleName("FAQ");
        FAQLinks.setSpacing(true);
        //FAQLinks.setWidth("100%");

        FAQLinks.addComponent(btnFeatures);
        FAQLinks.addComponent(btnHelp);
        FAQLinks.addComponent(btnScreenshots);
        FAQLinks.addComponent(btnTerms);
        FAQLinks.addComponent(btnAboutUs);
        FAQLinks.addComponent(btnPrivacyPolicy);
        FAQLinks.setSpacing(true);
        // FAQLinks.setMargin(true);


        return FAQLinks;

    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }
}
