/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.data;

import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.TextField;
import com.vaadin.data.Item;

/**
 *
 * @author Gery
 */
public class BusinessPersonFieldFactory extends DefaultFieldFactory {

    private static final String COMMON_FIELD_WIDTH = "12em";
    private static final String regexp = "[a-zA-Z]*";

    public BusinessPersonFieldFactory() {
    }

    @Override
    public Field createField(Item item, Object propertyId,
            Component uiContext) {
        Field f;
        f = super.createField(item, propertyId, uiContext);


        if ("companyName".equals(propertyId)) {
            TextField tf = (TextField) f;
            tf.setWidth(COMMON_FIELD_WIDTH);
            tf.addValidator(new StringLengthValidator(
                    "Company Name must be 3-25 characters", 3, 25, false));
            tf.addValidator(new RegexpValidator(regexp,
                    "{0} does not match the regular expression"));

        } else if ("position".equals(propertyId)) {
            TextField tf = (TextField) f;
            tf.setWidth(COMMON_FIELD_WIDTH);
            tf.addValidator(new StringLengthValidator(
                    "Position must be 3-50 characters", 3, 50, false));
            tf.addValidator(new RegexpValidator(regexp,
                    "{0} does not match the regular expression"));
        } else if ("bEmail".equals(propertyId)) {
            TextField tf = (TextField) f;
            tf.setWidth("10em");
            tf.addValidator(new EmailValidator(
                    "Please enter a valid business email"));
        } else if ("bEmail2".equals(propertyId)) {
            TextField tf = (TextField) f;
            tf.setWidth("10em");
            tf.addValidator(new EmailValidator(
                    "Please enter a valid second business email"));
        } else if ("bMobile".equals(propertyId)) {
            TextField tf = (TextField) f;
            tf.setWidth("10em");
            tf.addValidator(new StringLengthValidator(
                    "Please enter a valid business mobile number", 10, 12, false));
        } else if ("bMobile2".equals(propertyId)) {
            TextField tf = (TextField) f;
            tf.setWidth("10em");
            tf.addValidator(new StringLengthValidator(
                    "Please enter a valid second business mobile number", 10, 12, false));

        } else if ("fax".equals(propertyId)) {
            TextField tf = (TextField) f;
            tf.setNullRepresentation("");
            tf.setNullSettingAllowed(true);
            tf.addValidator(new StringLengthValidator(
                    "Fax size must be must be 6-10 characters", 6, 10, false));
            tf.addValidator(new RegexpValidator(regexp,
                    "{0} does not match the regular expression"));
            tf.setWidth("10em");
        }

        return f;
    }
}
