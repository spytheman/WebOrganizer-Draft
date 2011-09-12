/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.events;

import com.web.organizer.events.BaseEvent.EventType;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Gery
 */
public class EventBus {
    
    EnumMap<EventType, Set<EventListener>> subscribers;

    public EventBus() {
        
        // All event types start with empty subscribers list.
        subscribers = new EnumMap<EventType, Set<EventListener>>(EventType.class);
        for( EventType eventType : EventType.values()) {
            subscribers.put(eventType, new HashSet<EventListener>());
        }
    }
    
    public void addListener(EventType eventType, EventListener listener) {
        subscribers.get(eventType).add(listener);
    }
    
    public void fireEvent(BaseEvent event) {
        
        // Get appropriate listeners.
        EventType eventType = event.getEventType();
        Set<EventListener> listeners = subscribers.get(eventType);
        
        // Activate each listener
        for( EventListener listener : listeners) {
            listener.actionPerformed(event);
        }
        
        // Fire also ANY_EVENT
        listeners = subscribers.get(EventType.ANY_EVENT);
        
        // Activate each listener
        for( EventListener listener : listeners) {
            listener.actionPerformed(event);
        }
    }
}
