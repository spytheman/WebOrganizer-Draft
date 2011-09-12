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
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;This policy covers how OrganizedLife treats personal information that OrganizedLife collects and receives, including information related to your past use of OrganizedLife products and services. Personal information is information about you that is personally identifiable like your name, address, email address, or phone number, and that is not otherwise publicly available.</p>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;This policy does not apply to the practices of companies that OrganizedLife does not own or control, or to people that OrganizedLife does not employ or manage.</p>"
                + "<h3>Information Collection and Use</h3>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;OrganizedLife collects personal information when you register with OrganizedLife.</p>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;When you register we ask for information such as your name and email address. For some financial products and services we may also ask for your address and related information that is relevent to the product or service being sought. Once you register with OrganizedLife and sign in to our services, you are not anonymous to us.</p>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;OrganizedLife collects information about your transactions with us.</p>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;OrganizedLife automatically receives and records information on our server logs from your browser, including your IP address, OrganizedLife cookie information.</p>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;OrganizedLife may use information for the following general purposes: to customize the advertising and content you see, fulfill your requests for products and services, improve our services, contact you, conduct research, and provide 'anonymous' reporting for internal and external clients.</p>"
                + "<h3>Information Sharing and Disclosure</h3>"
                + "<p><u>OrganizedLife does not rent, sell, or share</u> personal information about you with other people or nonaffiliated companies except to provide products or services you've requested, when we have your permission, or under the following circumstances:</p>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;We respond to subpoenas, court orders, or legal process, or to establish or exercise our legal rights or defend against legal claims;</p>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;We believe it is necessary to share information in order to investigate, prevent, or take action regarding illegal activities, suspected fraud, situations involving potential threats to the physical safety of any person, violations of OrganizedLife's terms of use, or as otherwise required by law.</p>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;We transfer information about you if OrganizedLife is acquired by or merged with another company. In this event, OrganizedLife will notify you before information about you is transferred and becomes subject to a different privacy policy.</p>"
                + "<h3>Your Ability to Edit and Delete Your Account Information and Preferences General</h3>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;You can edit your OrganizedLife Account Information (Personal Profile), at any time.</p>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;We reserve the right to send you certain communications relating to the OrganizedLife service, such as service announcements, administrative messages and product announcements that are considered part of your OrganizedLife account, without offering you the opportunity to opt-out of receiving them.</p>"
                + "<h3>Changes to this Privacy Policy</h3>"
                + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;OrganizedLife may update this policy. We will notify you about significant changes in the way we treat personal information by sending a notice to the primary email address specified in your OrganizedLife account or by placing a prominent notice on our site.</p>");

        policy.setContentMode(Label.CONTENT_XHTML);
        addComponent(policy);
    }
}