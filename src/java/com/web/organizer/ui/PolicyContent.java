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
public class PolicyContent extends BaseContent {

    public PolicyContent() {
        Label policy = new Label(
                "<h2>OrganizedLife - Privacy Policy</h2>"
                + "<p>OrganizedLife takes your privacy seriously. Please read the following to learn more about our privacy policy:</p>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;This policy covers how OrganizedLife treats personal information that OrganizedLife collects and receives. Personal information is information about you that is personally identifiable like your name, address, email address, or phone number, and that is not otherwise publicly available.</p>"
                + "<h3>Information Collection and Use</h3>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;OrganizedLife collects personal information when you register with OrganizedLife.</p>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;When you register we ask for information such as your name and email address. Once you register with OrganizedLife and sign in to our services, you are not anonymous to us.</p>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;OrganizedLife may use information for the following general purposes: to customize the advertising and content you see, improve our services, contact you.</p>"
                + "<h3>Information Sharing and Disclosure</h3>"
                + "<p><u>OrganizedLife does not rent, sell, or share</u> personal information about you with other people or nonaffiliated companies except to provide products or services you've requested, when we have your permission, or under the following circumstances:</p>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;We believe it is necessary to share information in order to, prevent, investigate, or take action regarding illegal activities, suspected fraud, situations involving potential threats to the physical safety of any person.</p>"
                + "<h3>Your Ability to Edit and Delete Your Account Information and Preferences General</h3>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;You can edit your OrganizedLife Account Information (Personal Profile), at any time.</p>");

        policy.setContentMode(Label.CONTENT_XHTML);
        addComponent(policy);
    }
}