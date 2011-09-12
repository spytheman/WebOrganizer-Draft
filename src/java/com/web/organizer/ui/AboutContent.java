/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.ui;

import com.vaadin.ui.Label;

/**
 *
 * @author Gery
 */
public class AboutContent extends BaseContent {

    public AboutContent() {

        Label about = new Label(
                "<h2>About OrganizedLife - The free business and personal organizer</h2>"
                + "<p>Thanks for visiting OrganizedLife, we are aiming to become the first place online you go to check what you need doing today, during the week or even throughout the month. Our innovative drag and drop contact management system asks you to build your contact base through OrganizedLife based on groups (such as Family, friends, colleagues infact you are free to create any group you wish to) , for your ease of finding and contacting who you want whenever or wherever you are online.</p>"
                + "<p>OrganizedLife was drawn up whilst I was running a small business, with , at times, many tasks to do and with different circles of contacts such as suppliers, customers, etc. I felt that there was nothing really usable out there online which would help me run my business and personal life from day to day and where the information I needed was in one place to do so! Thus OrganizedLife was born!</p>"
                + "<p>So give it a go and Join OrganizedLife Today! we would love to hear your Feedback (use contact tab) to get in touch thanks!</p>"
                + "<p><b>Best Regards,</p>"
                + "<p>Gergana Katsarska</p>"
                + "<p>OrganizedLife.com</b></p>");

        about.setContentMode(Label.CONTENT_XHTML);
        addComponent(about);
    }
}
