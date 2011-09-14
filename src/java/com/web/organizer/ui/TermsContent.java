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
public class TermsContent extends BaseContent {

    public TermsContent() {
        Label terms = new Label(
                "<h2>OrganizedLife Terms & Conditions of Use</h2>"
                + "<p>We wish to inform you that the terms and conditions are in English and that we will communicate with you in English.</p>"
                + "<h3>1. About the OrganizedLife Online Service Terms of Service</h3>"
                + "<p>The term you refers to you as a user of OrganizedLife Website or Services. </p>"
                + "<h3>2. Accepting These Terms</h3>"
                + "<p>In order for you to use any of the OrganizedLife Services, you must first agree to abide by the Terms.</p>"
                + "<h3>3. Registration</h3>"
                + "<p>In order to use the OrganizedLife Services you may be required to provide information about yourself (such as identification or contact details) as part of the registration process. You agree that any registration information you give to OrganizedLife will be accurate, correct, and current.</p>"
                + "<h3>4. Prohibited Uses</h3>"
                + "<p>You specifically agree not to:</p>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;post, store, send, transmit any information or material which a reasonable person could deem to be unlawful;</p>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;post an unsolicited bulk or commercial messages commonly known as 'spam;'</p>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;send very large numbers of copies of the same or substantially similar messages;</p>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;impersonate any person or entity, engage in sender address falsification, forge anyone else's signature; </p>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;register under the name of, nor attempt to use the OrganizedLife Website under the name of, another person; </p>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;collect responses from unsolicited bulk messages posted on the OrganizedLife Website; </p>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;allow another person to access the website using your credentials; </p>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;capture, rip, download, or otherwise create a copy of any content that is shown on the OrganizedLife Website; </p>"
                + "<h3>5. Your Passwords and Unauthorized Use of Your Account</h3>"
                + "<p>You agree and understand that you are responsible for maintaining the confidentiality of the password(s) you use to access the OrganizedLife Website. </p>"
                + "<h3>6. Privacy and Your Personal Information</h3>"
                + "<p>To understand how the OrganizedLife Services use information you provide, please read the Web Services Privacy Policy. This policy explains how OrganizedLife and its providers handle your personal information when you register.</p>");

        terms.setContentMode(Label.CONTENT_XHTML);
        addComponent(terms);
    }
}