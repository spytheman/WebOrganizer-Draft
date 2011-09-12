/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.ui;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.LoginForm;
import com.vaadin.ui.LoginForm.LoginEvent;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import com.web.organizer.events.BaseEvent.EventType;
import com.web.organizer.events.ButtonChangePageListener;
import com.web.organizer.events.EventBus;

/**
 *
 * @author Gery
 */
public class MainContent extends BaseContent {

    private Button btnSignUp;
    private LoginForm login = new LoginForm();

    public MainContent() {
        HorizontalSplitPanel hsplit = new HorizontalSplitPanel();
        VerticalLayout vlayout = new VerticalLayout();
        VerticalSplitPanel vert = new VerticalSplitPanel();
        vert.setHeight("450px");
        vert.setWidth("100%");
        vert.setSplitPosition(150, Sizeable.UNITS_PIXELS);

        btnSignUp = new Button("Sign Up Now!");

        Label contentLabel = new Label((
                        "<h2><font color = 006600><b>The best way to manage your tasks.</b></font></h2>"
                        + "<p><font color = 00CC00><i><b>Never forget the meeting (or anything else) again.</b><font></i></p>"));

        contentLabel.setContentMode(Label.CONTENT_XHTML);

        login.addListener(new LoginForm.LoginListener()
                {

            @Override
            public void onLogin(LoginEvent event) {
                getWindow().showNotification(
                        "New Login",
                        "Username: " + event.getLoginParameter("username")
                        + ", password: "
                        + event.getLoginParameter("password"));


            }
        });


        Label contentLabel2 = new Label((
                        "<i>for a free account</i>"));

        contentLabel2.setContentMode(Label.CONTENT_XHTML);
        addComponent(contentLabel2);

        vlayout.addComponent(contentLabel);
        vlayout.addComponent(btnSignUp);
        vlayout.addComponent(contentLabel2);



         Label contentLabel3 = new Label((
                        "<h3>Your own personal online calendar.</h3>"
                                 + "<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;Calendar reminder system.</h3>"
                                 + "<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;ToDO Lists.</h3>"
                                 + "<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;Contacts. </h3>"
                                 + "<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;Personal Profile for shaduling meetings.  </h3>"
                                 + "<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;No software to install, no data to copy around or backup to worry about. </h3>"));

        contentLabel3.setContentMode(Label.CONTENT_XHTML);
        addComponent(contentLabel3);

        hsplit.setFirstComponent(contentLabel3);
        hsplit.setSecondComponent(login);
        hsplit.setSplitPosition(75, Sizeable.UNITS_PERCENTAGE);
        hsplit.setLocked(true);
        addComponent(hsplit);
        vert.addComponent(vlayout);
        vert.addComponent(hsplit);
        addComponent(vert);

    }

    @Override
    public void setEventBus(EventBus eventBus) {

        // Set up event bus
        super.setEventBus(eventBus);
        btnSignUp.addListener(new ButtonChangePageListener(EventType.CHANGE_PAGE_TO_SIGNUP, (MainWindow) getWindow()));


    }

}
