/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.ui;
import java.util.Arrays;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.IntegerValidator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.DateField;
import com.vaadin.ui.themes.BaseTheme;
import com.web.organizer.data.Task;

/**
 *
 * @author Gery
 */
public class TaskForm extends BaseContent{
     Task task;

    private static final String COMMON_FIELD_WIDTH = "12em";

    public TaskForm() {

        task = new Task();
        BeanItem<Task> taskItem = new BeanItem<Task>(task); // item from
                                                                    // POJO

        // Create the Form
        final Form personForm = new Form();
        personForm.setCaption("Task details");
        personForm.setWriteThrough(false); // we want explicit 'apply'
        personForm.setInvalidCommitted(false); // no invalid values in datamodel

        // FieldFactory for customizing the fields and adding validators
        personForm.setFormFieldFactory(new PersonFieldFactory());
        personForm.setItemDataSource(taskItem); // bind to POJO via BeanItem

        // Determines which properties are shown, and in which order:
        personForm.setVisibleItemProperties(Arrays.asList(new String[] {
                "title", "description", "startTime", "endTime",
                "reocurring", "amount", "comming","finished", }));

        // Add form to layout
        addComponent(personForm);

        // The cancel / apply buttons
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        Button discardChanges = new Button("Discard changes",
                new Button.ClickListener() {
            @Override
                    public void buttonClick(ClickEvent event) {
                        personForm.discard();
                    }
                });
        discardChanges.setStyleName(BaseTheme.BUTTON_LINK);
        buttons.addComponent(discardChanges);
        buttons.setComponentAlignment(discardChanges, Alignment.MIDDLE_LEFT);

        Button apply = new Button("Apply", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                try {
                    personForm.commit();
                } catch (Exception e) {
                    // Ignored, we'll let the Form handle the errors
                }
            }
        });
        buttons.addComponent(apply);
        personForm.getFooter().addComponent(buttons);
        personForm.getFooter().setMargin(false, false, true, true);


    }


    private class PersonFieldFactory extends DefaultFieldFactory {


        @Override
        public Field createField(Item item, Object propertyId,
                Component uiContext) {
            Field f;
          f = super.createField(item, propertyId, uiContext);


            if ("title".equals(propertyId)) {
                TextField tf = (TextField) f;
                tf.setRequired(true);
                tf.setRequiredError("Please enter a Title");
                tf.setWidth(COMMON_FIELD_WIDTH);
                tf.addValidator(new StringLengthValidator(
                        "Title must be 3-25 characters", 3, 25, false));
            } else if ("description".equals(propertyId)) {
                TextField tf = (TextField) f;
                tf.setRequired(true);
                tf.setRequiredError("Please enter a description");
                tf.setWidth(COMMON_FIELD_WIDTH);
                tf.addValidator(new StringLengthValidator(
                        "Description must be 3-50 characters", 3, 50, false));
            } else if ("startTime".equals(propertyId)) {
                DateField tf = (DateField) f;
                tf.setRequired(true);
                tf.setRequiredError("Please enter a startTime");
                tf.setWidth(COMMON_FIELD_WIDTH);

                } else if ("endTime".equals(propertyId)) {
                DateField tf = (DateField) f;
                tf.setRequired(true);
                tf.setRequiredError("Please enter an endTime");
                tf.setWidth(COMMON_FIELD_WIDTH);

            } else if ("reocurring".equals(propertyId)) {
                TextField tf = (TextField) f;
                tf.setNullRepresentation("");
                tf.setNullSettingAllowed(true);
                tf.addValidator(new IntegerValidator(
                        "Reocurring must be an Integer"));
                tf.setWidth("2em");
                } else if ("amount".equals(propertyId)) {
                TextField tf = (TextField) f;
                tf.setNullRepresentation("");
                tf.setNullSettingAllowed(true);
                tf.addValidator(new IntegerValidator(
                        "Amount must be an Integer"));
                tf.setWidth("2em");
            } else if ("comming".equals(propertyId)) {
                TextField tf = (TextField) f;
                tf.setNullRepresentation("");
                tf.setNullSettingAllowed(true);
                tf.addValidator(new IntegerValidator(
                        "Comming must be an Integer"));
                tf.setWidth("2em");
             } else if ("finished".equals(propertyId)) {
                TextField tf = (TextField) f;
                tf.setNullRepresentation("");
                tf.setNullSettingAllowed(true);
                tf.addValidator(new IntegerValidator(
                        "Finished must be an Integer"));
                tf.setWidth("2em");
            }


            return f;
        }


    }


}
