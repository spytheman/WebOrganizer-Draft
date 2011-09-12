/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.data;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.data.Item;
import com.web.organizer.ui.ExampleUtil;
/**
 *
 * @author Gery
 */
 public class PersonFieldFactory extends DefaultFieldFactory {

        final ComboBox countries = new ComboBox("Country");
        final ComboBox timeZone = new ComboBox("Time Zone");
        private static final String[] zones = new String[]{"GMT	Greenwich Mean Time	GMT", "UTC	Universal Coordinated Time	GMT", "ECT	European Central Time	GMT+1:00", "EET	Eastern European Time	GMT+2:00", "ART	(Arabic) Egypt Standard Time	GMT+2:00", "EAT	Eastern African Time	GMT+3:00", "MET	Middle East Time	GMT+3:3", "NET	Near East Time	GMT+4:00", "PLT	Pakistan Lahore Time	GMT+5:00", "IST	India Standard Time	GMT+5:30", "BST	Bangladesh Standard Time	GMT+6:00", "VST	Vietnam Standard Time	GMT+7:00",
        "CTT	China Taiwan Time	GMT+8:00", "JST	Japan Standard Time	GMT+9:00", "ACT	Australia Central Time	GMT+9:30", "AET	Australia Eastern Time	GMT+10:00", "SST	Solomon Standard Time	GMT+11:00", "NST	New Zealand Standard Time	GMT+12:00", "MIT	Midway Islands Time	GMT-11:00", "HST	Hawaii Standard Time	GMT-10:00", "AST	Alaska Standard Time	GMT-9:00", "PST	Pacific Standard Time	GMT-8:00", "PNT	Phoenix Standard Time	GMT-7:00", "MST	Mountain Standard Time	GMT-7:00", "CST	Central Standard Time	GMT-6:00", "EST	Eastern Standard Time	GMT-5:00", "IET	Indiana Eastern Standard Time	GMT-5:00", "PRT	Puerto Rico and US Virgin Islands Time	GMT-4:00", "CNT	Canada Newfoundland Time	GMT-3:30", "AGT	Argentina Standard Time	GMT-3:00", "BET	Brazil Eastern Time	GMT-3:00", "CAT	Central African Time	GMT-1:00"};
    private static final String COMMON_FIELD_WIDTH = "12em";
    private static final String regexp = "[a-zA-Z]*";

        public PersonFieldFactory() {
            countries.setWidth(COMMON_FIELD_WIDTH);
            countries.setContainerDataSource(ExampleUtil.getISO3166Container());
            countries.setItemCaptionPropertyId(ExampleUtil.iso3166_PROPERTY_NAME);
            countries.setItemIconPropertyId(ExampleUtil.iso3166_PROPERTY_FLAG);
            countries.setFilteringMode(ComboBox.FILTERINGMODE_STARTSWITH);

            timeZone.setNullSelectionAllowed(true);
            // Add the item that marks 'null' value

            // Designate it as the 'null' value marker

            timeZone.setImmediate(true);
            timeZone.setWidth(COMMON_FIELD_WIDTH);
            timeZone.setFilteringMode(ComboBox.FILTERINGMODE_STARTSWITH);
            //setMargin(true, false, false, false);
            for (int i = 0; i < zones.length; i++) {
            timeZone.addItem(zones[i]);
        }


        }

        @Override
        public Field createField(Item item, Object propertyId,
                Component uiContext) {
            Field f;
            if ("countryCode".equals(propertyId)) {
                // filtering ComboBox w/ country names
                return countries;
            } else if ("password".equals(propertyId)) {
                // Create a password field so the password is not shown
                f = createPasswordField(propertyId);
            } else if ("timeZone".equals(propertyId)) {
                // filtering ComboBox w/ zone names
                return timeZone;

            } else {
                // Use the super class to create a suitable field base on the
                // property type.
                f = super.createField(item, propertyId, uiContext);
            }

            if ("firstName".equals(propertyId)) {
                TextField tf = (TextField) f;
                tf.setRequired(true);
                tf.setRequiredError("Please enter a First Name");
                tf.setWidth(COMMON_FIELD_WIDTH);
                tf.addValidator(new StringLengthValidator(
                        "First Name must be 3-25 characters", 3, 25, false));
                tf.addValidator(new RegexpValidator(regexp,
                "{0} does not match the regular expression"));

            } else if ("lastName".equals(propertyId)) {
                TextField tf = (TextField) f;
                tf.setRequired(true);
                tf.setRequiredError("Please enter a Last Name");
                tf.setWidth(COMMON_FIELD_WIDTH);
                tf.addValidator(new StringLengthValidator(
                        "Last Name must be 3-50 characters", 3, 50, false));
                tf.addValidator(new RegexpValidator(regexp,
                "{0} does not match the regular expression"));
            } else if ("password".equals(propertyId)) {
                PasswordField pf = (PasswordField) f;
                pf.setRequired(true);
                pf.setRequiredError("Please enter a password");
                pf.setWidth("10em");
                pf.addValidator(new StringLengthValidator(
                        "Password must be 6-20 characters", 6, 20, false));

                } else if ("email".equals(propertyId)) {
                TextField tf = (TextField) f;
                tf.setRequired(true);
                tf.setRequiredError("Please enter an email");
                tf.setWidth("10em");
                tf.addValidator(new EmailValidator(
                        "Please enter a valid email"));
                } else if ("email2".equals(propertyId)) {
                TextField tf = (TextField) f;
                tf.setWidth("10em");
                tf.addValidator(new EmailValidator(
                        "Please enter a valid email"));
                } else if ("mobile".equals(propertyId)) {
                TextField tf = (TextField) f;
                tf.setWidth("10em");
                tf.addValidator(new StringLengthValidator(
                        "Please enter a valid mobile number", 10, 12, false));
                } else if ("mobile2".equals(propertyId)) {
                TextField tf = (TextField) f;
                tf.setWidth("10em");
                tf.addValidator(new StringLengthValidator(
                        "Please enter a valid mobile number", 10, 12, false));

            } else if ("username".equals(propertyId)) {
                TextField tf = (TextField) f;
                tf.setNullRepresentation("");
                tf.setNullSettingAllowed(true);
                tf.addValidator(new StringLengthValidator(
                        "Username size must be must be 6-20 characters", 6, 20, false));
               tf.addValidator(new RegexpValidator(regexp,
                "{0} does not match the regular expression"));
                tf.setWidth("10em");
            }

            return f;
        }

        private PasswordField createPasswordField(Object propertyId) {
            PasswordField pf = new PasswordField();
            pf.setCaption(DefaultFieldFactory.createCaptionByPropertyId(propertyId));
            return pf;
        }
    }

