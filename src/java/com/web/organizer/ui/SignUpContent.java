/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.ui;
import java.util.Arrays;
import com.vaadin.data.Validator;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.themes.BaseTheme;
import com.web.organizer.data.Person;
import com.web.organizer.data.PersonFieldFactory;
import com.web.organizer.events.BaseEvent.EventType;
import com.web.organizer.events.ButtonChangePageListener;
import com.web.organizer.events.EventBus;

/**
 *
 * @author Gery
 */
public class SignUpContent extends BaseContent {

    // the 'POJO' we're editing
    Person person;
    private Button btnApply;

    public SignUpContent() {


        person = new Person(); // a person POJO
        BeanItem<Person> personItem = new BeanItem<Person>(person); // item from
        // POJO

        // Create the Form
        final Form personForm = new Form();
        personForm.setCaption("Personal details");
        personForm.setWriteThrough(false); // we want explicit 'apply'
        personForm.setInvalidCommitted(false); // no invalid values in datamodel

        // FieldFactory for customizing the fields and adding validators
        personForm.setFormFieldFactory(new PersonFieldFactory());
        personForm.setItemDataSource(personItem); // bind to POJO via BeanItem

        // Determines which properties are shown, and in which order:
        personForm.setVisibleItemProperties(Arrays.asList(new String[]{
                    "firstName", "lastName", "username", "password", "email","email2","mobile","mobile2", "birthdate", "countryCode", "timeZone"}));

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

        btnApply = new Button("Apply", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                try {
                    personForm.commit();
                } catch (Exception e) {
                    // Ignored, we'll let the Form handle the errors
                }
            }
        });
        buttons.addComponent(btnApply);
        personForm.getFooter().addComponent(buttons);
        personForm.getFooter().setMargin(false, false, true, true);

    }

    public class IntegerValidator implements Validator {

        private String message;

        public IntegerValidator(String message) {
            this.message = message;
        }

        @Override
        public boolean isValid(Object value) {
            if (value == null || !(value instanceof String)) {
                return false;
            }
            try {
                Integer.parseInt((String) value);
            } catch (Exception e) {
                return false;
            }
            return true;
        }

        @Override
        public void validate(Object value) throws InvalidValueException {
            if (!isValid(value)) {
                throw new InvalidValueException(message);

            }

        }
    }

    @Override
    public void setEventBus(EventBus eventBus) {

        // Set up event bus

        super.setEventBus(eventBus);
        btnApply.addListener(new ButtonChangePageListener(EventType.CHANGE_PAGE_TO_MAINVIEW, (MainWindow) getWindow()));
    }
}
