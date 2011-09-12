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
public class HelpContent extends BaseContent {

    public HelpContent() {
        Label contentLabel = new Label(("HEEEEELP content!</br></br>hahah"));
        contentLabel.setContentMode(Label.CONTENT_XHTML);
        addComponent(contentLabel);
        addComponent(new Label("ANOTHER ONEEE!!!!!"));
    }
}
