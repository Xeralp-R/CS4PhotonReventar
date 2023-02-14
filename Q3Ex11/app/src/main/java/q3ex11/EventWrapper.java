package q3ex11;

import javafx.event.Event;

public class EventWrapper {
    public final Event event;
    public final String message;

    public EventWrapper(Event event, String message) {
        this.event = event;
        this.message = message;
    }
}