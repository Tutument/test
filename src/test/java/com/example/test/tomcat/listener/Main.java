package com.example.test.tomcat.listener;

public class Main {

    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        eventSource.addListener(new EventListener() {
            @Override
            public void handleEvent(EventObject event) {
                event.doEvent();
                if (event.getSource().equals("closeWindows")) {
                    System.out.println("doClose");
                }
            }
        });
        eventSource.addListener(new EventListener() {
            @Override
            public void handleEvent(EventObject event) {
                System.out.println("gogogo");
            }
        });
    /*
      * 传入openWindows事件，通知listener，事件监听器，
      对open事件感兴趣的listener将会执行 closeWindows openWindows
      **/
        eventSource.notifyListenerEvents(new EventObject("closeWindows"));
    }

}
