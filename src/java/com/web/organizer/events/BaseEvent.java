/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.events;

/**
 *
 * @author Gery
 */
public class BaseEvent {

    public enum EventType {
        CHANGE_PAGE_TO_HOME,
        CHANGE_PAGE_TO_ABOUT,
        CHANGE_PAGE_TO_HELP,
        CHANGE_PAGE_TO_POLICY,
        CHANGE_PAGE_TO_SIGNUP,
        CHANGE_PAGE_TO_TERMS,
        CHANGE_PAGE_TO_CONTACT,
        CHANGE_PAGE_TO_SHARE,
        CHANGE_PAGE_TO_PREVIEW,
        CHANGE_PAGE_TO_DEMOLOGIN,
        CHANGE_PAGE_TO_FEATURES,
        CHANGE_PAGE_TO_SCREENSHOTS,
        CHANGE_PAGE_TO_LOGIN,
        CHANGE_PAGE_TO_MAINVIEW,
        CHANGE_PAGE_TO_NEWCONTACT,
        ANY_EVENT
    }

    private EventType eventType = null;
    private Object source = null;
    private Object sourceEvent = null;

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getSourceEvent() {
        return sourceEvent;
    }

    public void setSourceEvent(Object sourceEvent) {
        this.sourceEvent = sourceEvent;
    }
}
