/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.ui;

/**
 *
 * @author Gery
 */
import com.vaadin.data.util.BeanItem;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Form;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.VerticalLayout;
import com.web.organizer.data.Person;
import com.web.organizer.data.PersonFieldFactory;
import java.util.Arrays;


/**
 *
 * @author Gery
 */
public class NewContactContent extends BaseContent implements
        TabSheet.SelectedTabChangeListener {
    private Person person;
    private static final ThemeResource icon1 = new ThemeResource(
            "../sampler/icons/action_save.gif");
    private static final ThemeResource icon2 = new ThemeResource(
            "../sampler/icons/comment_yellow.gif");

    private TabSheet tContact;
    //private SignUpContent Cform = new SignUpContent();

    private BusinessForm bPersonForm = new BusinessForm();
    public NewContactContent() {

        person = new Person(); // a person POJO
        BeanItem<Person> personItem = new BeanItem<Person>(person); // item from
        // POJO

        // Create the Form
        final Form Cform = new Form();
        Cform.setCaption("Personal details");
        Cform.setWriteThrough(false); // we want explicit 'apply'
        Cform.setInvalidCommitted(false); // no invalid values in datamodel

        // FieldFactory for customizing the fields and adding validators
        Cform.setFormFieldFactory(new PersonFieldFactory());
        Cform.setItemDataSource(personItem); // bind to POJO via BeanItem

        // Determines which properties are shown, and in which order:
        Cform.setVisibleItemProperties(Arrays.asList(new String[]{
                    "firstName", "lastName","email","email2","mobile","mobile2", "birthdate", "countryCode",}));

        // Tab 1 content
        VerticalLayout l1 = new VerticalLayout();
        l1.setMargin(true);
        l1.addComponent(Cform);

        // Tab 2 content
        VerticalLayout l2 = new VerticalLayout();
        l2.setMargin(true);
        l2.addComponent(bPersonForm);

        tContact= new TabSheet();
        tContact.addTab(l1, "Personal information", icon1);
        tContact.addTab(l2, "Bussines information", icon2);
        addComponent(tContact);

        // tContact.addTab(Cform, "Saved actions",item1);
    }

    @Override
    public void selectedTabChange(SelectedTabChangeEvent event) {
        TabSheet tabsheet = event.getTabSheet();
        Tab tab = tabsheet.getTab(tabsheet.getSelectedTab());
        if (tab != null) {
            getWindow().showNotification("Selected tab: " + tab.getCaption());
        }
    }
}

