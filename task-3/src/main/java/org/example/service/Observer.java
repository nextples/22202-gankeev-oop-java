package org.example.service;

import org.example.event.Event;

public interface Observer {
    public void update(Event event);

}
