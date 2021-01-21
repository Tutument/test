package com.example.test.tomcat.listener;

public interface EventListener extends java.util.EventListener {
    void handleEvent(EventObject event);
}

