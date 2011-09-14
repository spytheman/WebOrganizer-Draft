/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.ui;

import com.vaadin.data.Validator;
import com.vaadin.data.Validator.InvalidValueException;
import java.util.Arrays;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.themes.BaseTheme;
import com.web.organizer.data.BusinessPerson;
import com.web.organizer.data.PersonFieldFactory;

/**
 *
 * @author Gery
 */
public class BusinessForm extends BaseContent {

    // the 'POJO' we're editing
    BusinessPerson busPerson;
    private Button btnApply;

    public BusinessForm() {


        busPerson = new BusinessPerson(); // a person POJO
        BeanItem<BusinessPerson> personItem = new BeanItem<BusinessPerson>(busPerson); // item from
        // POJO

        // Create the Form
        final Form busunessPersonForm = new Form();
        busunessPersonForm.setCaption("Business details");
        busunessPersonForm.setWriteThrough(false); // we want explicit 'apply'
        busunessPersonForm.setInvalidCommitted(false); // no invalid values in datamodel


        // FieldFactory for customizing the fields and adding validators
        busunessPersonForm.setFormFieldFactory(new PersonFieldFactory());
        busunessPersonForm.setItemDataSource(personItem); // bind to POJO via BeanItem

        // Determines which properties are shown, and in which order:
        busunessPersonForm.setVisibleItemProperties(Arrays.asList(new String[]{
                    "companyName", "position", "bEmail", "bMobile", "bMobile2", "fax"}));
        addComponent(busunessPersonForm);

        // The cancel / apply buttons
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        Button discardChanges = new Button("Discard changes",
                new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        busunessPersonForm.discard();
                    }
                });
        discardChanges.setStyleName(BaseTheme.BUTTON_LINK);
        buttons.addComponent(discardChanges);
        buttons.setComponentAlignment(discardChanges, Alignment.MIDDLE_LEFT);

        btnApply = new Button("Apply", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                try {
                    busunessPersonForm.commit();
                } catch (Exception e) {
                    // Ignored, we'll let the Form handle the errors
                }
            }
        });
        buttons.addComponent(btnApply);
        busunessPersonForm.getFooter().addComponent(buttons);
        busunessPersonForm.getFooter().setMargin(false, false, true, true);

    }

}
