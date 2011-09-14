/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.ui;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import com.vaadin.addon.calendar.event.CalendarEvent;
import com.vaadin.addon.calendar.event.CalendarEventProvider;
import com.vaadin.addon.calendar.gwt.client.ui.VCalendar;
import com.vaadin.addon.calendar.ui.Calendar;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.DateClickEvent;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.DateClickHandler;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventClick;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventClickHandler;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventMoveHandler;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventResize;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventResizeHandler;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.MoveEvent;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.RangeSelectEvent;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.RangeSelectHandler;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.WeekClick;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.WeekClickHandler;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

/**
 *
 * @author Gery
 */
public class CalendarContent extends BaseContent {

    private static final long serialVersionUID = -2399403357909880914L;

    private MyEventProvider provider = new MyEventProvider();

    @SuppressWarnings("serial")

    public void init() {
        Window w = new Window();

        setLocale(Locale.US);

        final Calendar cal = new Calendar(provider);
        cal.setSizeFull();

        cal.setStartDate(new Date());
        cal.setEndDate(new Date());

        // Add date click listener
        cal.setHandler(new DateClickHandler() {

            public void dateClick(DateClickEvent event) {
                Calendar cal = event.getComponent();
                long currentCalDateRange = cal.getEndDate().getTime()
                        - cal.getStartDate().getTime();
                if (currentCalDateRange < VCalendar.DAYINMILLIS) {
                    // Change the date range to the current week
                    cal.setStartDate(cal.getFirstDateForWeek(event.getDate()));
                    cal.setEndDate(cal.getLastDateForWeek(event.getDate()));
                } else {
                    // Change the date range to the clicked day
                    cal.setStartDate(event.getDate());
                    cal.setEndDate(event.getDate());
                }
            }
        });

        cal.setHandler(new WeekClickHandler() {

            public void weekClick(WeekClick event) {
                Calendar cal = event.getComponent();
                GregorianCalendar gc = new GregorianCalendar(cal.getTimeZone(),
                        cal.getLocale());
                // Reset calendar's start time to the target week's first day.
                gc.set(GregorianCalendar.YEAR, event.getYear());
                gc.set(GregorianCalendar.WEEK_OF_YEAR, event.getWeek());
                gc.set(GregorianCalendar.DAY_OF_WEEK, gc.getFirstDayOfWeek());
                gc.set(GregorianCalendar.HOUR_OF_DAY, 0);
                gc.set(GregorianCalendar.MINUTE, 0);
                gc.set(GregorianCalendar.SECOND, 0);
                gc.set(GregorianCalendar.MILLISECOND, 0);
                cal.setStartDate(gc.getTime());
                gc.add(GregorianCalendar.DATE, 6);
                cal.setEndDate(gc.getTime());
            }
        });

        cal.setHandler(new EventClickHandler() {

            public void eventClick(EventClick event) {
                MyEvent e = (MyEvent) event.getCalendarEvent();
               // getMainWindow().showNotification("Event clicked",
                       // e.getCaption(), Notification.POSITION_CENTERED);
            }
        });

        // Add event move listener
        cal.setHandler(new EventMoveHandler() {

            public void eventMove(MoveEvent event) {
                MyEvent calEvent = ((MyEvent) event.getCalendarEvent());
                long duration = calEvent.getEnd().getTime()
                        - calEvent.getStart().getTime();
                calEvent.setStart(event.getNewStart());
                calEvent.setEnd(new Date(event.getNewStart().getTime()
                        + duration));
                event.getComponent().requestRepaint();
            }
        });

        // Add drag selection listener
        cal.setHandler(new RangeSelectHandler() {

            public void rangeSelect(RangeSelectEvent event) {
                long currentCalDateRange = cal.getEndDate().getTime()
                        - cal.getStartDate().getTime();
                boolean allDayEvent = currentCalDateRange > (VCalendar.DAYINMILLIS * 7);
                MyEvent myEvent = new MyEvent("", event.getStart(), event
                        .getEnd(), allDayEvent);

                // Create popup window and add a form in it.
                VerticalLayout layout = new VerticalLayout();
                layout.setMargin(true);
                layout.setSpacing(true);

                final Window w = new Window(null, layout);
                w.setWidth("400px");
                w.setModal(true);
                w.center();

                // Wrap the calendar event to a BeanItem and pass it to the form
                final BeanItem<CalendarEvent> item = new BeanItem<CalendarEvent>(
                        myEvent);

                final Form form = new Form();
                form.setWriteThrough(false);
                form.setItemDataSource(item);
                form.setFormFieldFactory(new FormFieldFactory() {

                    public Field createField(Item item, Object propertyId,
                            Component uiContext) {
                        if (propertyId.equals("caption")) {
                            TextField f = new TextField("Caption");
                            f.setNullRepresentation("");
                            f.focus();
                            return f;

                        }
                        return null;
                    }
                });
                form.setVisibleItemProperties(new Object[] { "caption" });

                layout.addComponent(form);

                HorizontalLayout buttons = new HorizontalLayout();
                buttons.setSpacing(true);
                buttons.addComponent(new Button("OK", new ClickListener() {

                    public void buttonClick(ClickEvent event) {
                        form.commit();
                        // Update event provider's data source
                        provider.addEvent(item.getBean());
                        // Calendar needs to be repainted
                        cal.requestRepaint();

                      // BaseContent().removeWindow(w);
                    }
                }));
                buttons.addComponent(new Button("Calcel", new ClickListener() {

                    public void buttonClick(ClickEvent event) {
                        //getMainWindow().removeWindow(w);
                    }
                }));
                layout.addComponent(buttons);
                layout.setComponentAlignment(buttons, Alignment.BOTTOM_RIGHT);

                //getMainWindow().addWindow(w);
            }
        });

        cal.setHandler(new EventResizeHandler() {

            public void eventResize(EventResize event) {
                MyEvent calendarEvent = (MyEvent) event.getCalendarEvent();
                calendarEvent.setStart(event.getNewStartTime());
                calendarEvent.setEnd(event.getNewEndTime());
            }

        });

        Button monthViewButton = new Button("Show month");
        monthViewButton.addListener(new ClickListener() {

            public void buttonClick(ClickEvent event) {
                GregorianCalendar gc = new GregorianCalendar(cal.getTimeZone(),
                        cal.getLocale());
                gc.setTime(cal.getStartDate());

                long currentCalDateRange = cal.getEndDate().getTime()
                        - cal.getStartDate().getTime();
                if (currentCalDateRange > (VCalendar.DAYINMILLIS * 7)) {
                    return;
                }

                // Reset calendar's start time to the target month's first day.
                gc.set(GregorianCalendar.DATE, gc
                        .getMinimum(GregorianCalendar.DATE));
                gc.set(GregorianCalendar.HOUR_OF_DAY, 0);
                gc.set(GregorianCalendar.MINUTE, 0);
                gc.set(GregorianCalendar.SECOND, 0);
                gc.set(GregorianCalendar.MILLISECOND, 0);
                cal.setStartDate(gc.getTime());
                gc.add(GregorianCalendar.MONTH, 1);
                gc.add(GregorianCalendar.DATE, -1);
                cal.setEndDate(gc.getTime());

            }
        });

        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setMargin(true);
        layout.addComponent(monthViewButton);
        layout.addComponent(cal);
        layout.setExpandRatio(cal, 1);
        w.setContent(layout);
        w.setSizeFull();
    }

    public static class MyEventProvider implements CalendarEventProvider {

        private static final long serialVersionUID = -3655982234130426761L;

        private List<CalendarEvent> events = new ArrayList<CalendarEvent>();

        public MyEventProvider() {
            events = new ArrayList<CalendarEvent>();
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(new Date());

            Date start = cal.getTime();
            cal.add(GregorianCalendar.HOUR, 5);
            Date end = cal.getTime();
            events.add(new MyEvent("My event", start, end, false));
        }

        public void addEvent(CalendarEvent myEvent) {
            events.add(myEvent);
        }

        public List<CalendarEvent> getEvents(Date startDate, Date endDate) {
            return events;
        }
    }

    public static class MyEvent implements CalendarEvent {

        private static final long serialVersionUID = 6147099504819813059L;

        private String caption;
        private Date start;
        private Date end;
        private boolean allDay;

        public MyEvent(String caption, Date start, Date end, boolean allDay) {
            this.caption = caption;
            this.start = start;
            this.end = end;
            this.allDay = allDay;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public Date getEnd() {
            return end;
        }

        public void setEnd(Date end) {
            this.end = end;
        }

        public Date getStart() {
            return start;
        }

        public void setStart(Date start) {
            this.start = start;
        }

        public String getStyleName() {
            return null;
        }

        public String getDescription() {
            return null;
        }

        public void setAllDay(boolean allDay) {
            this.allDay = allDay;
        }

        public boolean isAllDay() {
            return allDay;
        }
    }
}
